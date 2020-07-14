package com.xxl.robot.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.RobotQqMapper;
import com.xxl.robot.dto.CarSourceDto;
import com.xxl.robot.dto.ParttimeAgentDto;
import com.xxl.robot.dto.RobotPlanDto;
import com.xxl.robot.dto.RobotQqDto;
import com.xxl.robot.entity.RobotCode;
import com.xxl.robot.entity.RobotPlan;
import com.xxl.robot.entity.RobotQq;
import com.xxl.robot.service.*;
import com.xxl.robot.tools.CrawlTools;
import com.xxl.robot.tools.HostTools;
import com.xxl.robot.tools.RegTools;
import com.xxl.robot.tools.SendTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * todo qq服务类
 */
@Service
public class RobotQqServiceImpl implements RobotQqService {

    private static final Logger logger = LoggerFactory.getLogger(RobotQqServiceImpl.class);

	@Autowired
	private RobotQqMapper robotQqMapper;
	@Autowired
	private RobotCodeService robotConfigService;
    @Autowired
	private ParttimeAgentService parttimeAgentService;
    @Autowired
	private RobotPlanService robotPlanService;
    @Autowired
	@Lazy
	private CarSourceService carSourceService;

	@Override
	public RobotQqDto get(Long id) {
		RobotQq entity = new RobotQq();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotQqMapper.selectOne(entity),RobotQqDto.class);
	}

	@Override
	public int save(RobotQqDto dto) {
		RobotQq entity = BeanTools.sourceToTarget(dto, RobotQq.class);
		return robotQqMapper.insert(entity);
	}


	@Override
	public int update(RobotQqDto dto) {
		RobotQq entity = BeanTools.sourceToTarget(dto, RobotQq.class);
		return robotQqMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return robotQqMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotQqDto> list(RobotQqDto dto) {
		List<RobotQq> dtos = robotQqMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotQqDto.class);
	}


	@Override
	public PageInfo<RobotQqDto> page(RobotQqDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotQqDto> beans = BeanTools.sourceToTarget(robotQqMapper.selectByCondition(getCondition(dto)),RobotQqDto.class);
		PageInfo<RobotQqDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotQqDto dto){
		Condition condition = new Condition(RobotQq.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(null!=dto.getEnabled()){
			criteria.andEqualTo("enabled",dto.getEnabled());
		}
		return condition;
	}

	@Override
	public void initQQ() {
		List<RobotCode> configs = robotConfigService.queryDictionary("QQ_SOURCE_GROUP");

	}

	//***********************************************业务逻辑************************************************************
    @Async("taskExecutor")
	@Override
	public void handleQQ(List<String> datas){
		List<RobotQq> robotQqs = new ArrayList<>();
 		if(!CollectionUtils.isEmpty(datas)) {
			for (String data : datas) {
				String[] result = data.split(RegTools.TIME);
				for(int i=0;i<result.length;i++){
					RobotQq dto = new RobotQq();
					dto.setContent(result[i]);
					dto.setEnabled((byte) 0);
					robotQqs.add(dto);
				}
			}
		}
		robotQqs.stream().distinct().collect(Collectors.toList());

        robotQqMapper.insertList(robotQqs);

	}

	@Async("taskExecutor")
	@Override
	public void handleQQ(RobotCode config, String data) {
		List<RobotQq> robotQqs = new ArrayList<>();
		String[] result = data.split(RegTools.TIME);
		for(int i=0;i<result.length;i++){
			RobotQq dto = new RobotQq();
			dto.setContent(result[i]);
			dto.setEnabled((byte) 0);
			dto.setCreateDate(new Date());
			dto.setSourceType(config.getKind());
			dto.setTenantCode(config.getTenantCode());
			robotQqs.add(dto);
		}
		robotQqs.stream().distinct().collect(Collectors.toList());

		robotQqMapper.insertList(robotQqs);
	}

	@Override
	public int doEnabled(Long id) {
		RobotQq robotQq = robotQqMapper.selectByPrimaryKey(id);
		if(robotQq.getEnabled()==0){
			robotQq.setEnabled((byte) 1);
		}else{
			robotQq.setEnabled((byte) 0);
		}
		return 0;
	}

	@Override
	public void collectQQ() {
		List<RobotCode> configs = robotConfigService.queryDictionary("QQ_SOURCE_GROUP");
		if(!CollectionUtils.isEmpty(configs)){
			for(RobotCode config:configs){
				logger.info("***********************打印config配置：{}"+JSON.toJSONString(config));
				try {
					String data = CrawlTools.QQCrawl(config.getNo());
					handleQQ(config, data);
				}catch (Exception e){
					logger.info("***********抓取QQ数据出错***********");
				}
			}
		}
	}

	@Override
	public void sendQQ() {
		String host = HostTools.getHost();
		RobotPlan plan = new RobotPlan();
		plan.setEnabled((byte) 0);
		plan.setHost(host);
		plan.setOperate((byte) 1);
		RobotPlanDto robotPlanDto = robotPlanService.selectByHostOperate(plan);
		ParttimeAgentDto parttimeAgentDto = new ParttimeAgentDto();
		parttimeAgentDto.setKind(robotPlanDto.getKind());
		List<ParttimeAgentDto> dtos = parttimeAgentService.list(parttimeAgentDto);
		//需要发送的数据
        StringBuffer  sourceData = new StringBuffer();
		if(StringUtils.isNotBlank(robotPlanDto.getKind())&&robotPlanDto.getKind().equals("租车")){
			CarSourceDto carSourceDto = new CarSourceDto();
			List<CarSourceDto> carSourceDtos = carSourceService.list(carSourceDto);
			if(!CollectionUtils.isEmpty(carSourceDtos)){
				CarSourceDto ss = carSourceDtos.get(0);
				if(ss.getRentType().equals("0")){
					sourceData.append("人找车, ");
				}else{
					sourceData.append("车找人, ");
				}
				sourceData.append(" 出发时间"+ss.getStartTime());
				sourceData.append(" 电话"+ss.getMobile());
				sourceData.append(" "+ss.getToPlace());
				sourceData.append(" 回 ");
				sourceData.append(" "+ss.getFromPlace());
			}
		}
        if(!CollectionUtils.isEmpty(dtos)){
			int iRandom = (int)(1+(Math.random()*dtos.size()-1));
			ParttimeAgentDto parttimeAgentDtoBean = dtos.get(iRandom);
            if(StringUtils.isNotBlank(parttimeAgentDtoBean.getPopularize1())){
				sourceData.append(parttimeAgentDtoBean.getPopularize1());
			}
			if(StringUtils.isNotBlank(parttimeAgentDtoBean.getPopularize2())){
				sourceData.append(parttimeAgentDtoBean.getPopularize2());
			}
			if(StringUtils.isNotBlank(parttimeAgentDtoBean.getPopularize3())){
				sourceData.append(parttimeAgentDtoBean.getPopularize3());
			}
			if(StringUtils.isNotBlank(parttimeAgentDtoBean.getPopularize4())){
				sourceData.append(parttimeAgentDtoBean.getPopularize4());
			}
			if(StringUtils.isNotBlank(parttimeAgentDtoBean.getPopularize5())){
				sourceData.append(parttimeAgentDtoBean.getPopularize5());
			}
			if(StringUtils.isNotBlank(parttimeAgentDtoBean.getPopularize6())){
				sourceData.append(parttimeAgentDtoBean.getPopularize6());
			}

		}
		List<RobotCode> configs = robotConfigService.queryDictionary("QQ_SOURCE_GROUP");
		if(!CollectionUtils.isEmpty(configs)){
			for(RobotCode config:configs){
				logger.info("***********************打印config配置：{}"+JSON.toJSONString(config));
				try {
					 SendTools.QQSend(config.getNo(),sourceData.toString());

				}catch (Exception e){
					logger.info("***********QQ数据自动发送出错***********");
				}
			}
		}



	}

	@Override
	public void addQQ() {

	}


}
