package com.xxl.robot.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.RobotQqMapper;
import com.xxl.robot.dto.*;
import com.xxl.robot.entity.*;
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
	private RobotPlanService robotPlanService;
    @Autowired
	@Lazy
	private CarSourceService carSourceService;
    @Autowired
	private RobotPopularizeService robotPopularizeService;
	@Autowired
	private RobotInfoService robotInfoService;



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
	public void deleteQQ() {
		RobotQqDto dto = new RobotQqDto();
		dto.setEnabled((byte) 1);
		robotQqMapper.deleteByCondition(getCondition(dto));
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
	public void handleQQ(RobotInfoDto robotInfo, String data) {
		List<RobotQq> robotQqs = new ArrayList<>();
		String[] result = data.split(RegTools.TIME);
		for(int i=0;i<result.length;i++){
			RobotQq dto = new RobotQq();
			dto.setRobotCode(robotInfo.getRobotCode());
			dto.setContent(result[i]);
			dto.setEnabled((byte) 0);
			dto.setCreateDate(new Date());
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
		String host = HostTools.getHost();
		RobotInfoDto robotInfoDto = new RobotInfoDto();
		robotInfoDto.setEnabled((byte) 0);
		robotInfoDto.setHost(host);
		RobotInfoDto robotInfo = robotInfoService.selectByUnique(robotInfoDto);
		List<RobotCode> configs = robotConfigService.queryDictionary("QQ_SOURCE_GROUP");
		if(!CollectionUtils.isEmpty(configs)){
			for(RobotCode robotCode:configs){
				logger.info("***********************打印config配置：{}"+JSON.toJSONString(robotCode));
				try {
					String data = CrawlTools.QQCrawl(robotCode.getName());
					handleQQ(robotInfo, data);
				}catch (Exception e){
					logger.info("***********抓取QQ数据出错***********");
				}
			}
		}
	}

	@Override
	public void sendQQ() {
		String host = HostTools.getHost();
		RobotInfoDto robotInfoDto = new RobotInfoDto();
		robotInfoDto.setEnabled((byte) 0);
		robotInfoDto.setHost(host);
		RobotInfoDto robotInfo = robotInfoService.selectByUnique(robotInfoDto);
		RobotPopularizeDto robotPopularizeDto = new RobotPopularizeDto();
		robotPopularizeDto.setServiceType(robotInfo.getServiceType());
		List<RobotPopularizeDto> dtos = robotPopularizeService.list(robotPopularizeDto);
		//需要发送的数据
        StringBuffer  sourceData = new StringBuffer();
		if(StringUtils.isNotBlank(robotInfo.getServiceType())&&robotInfo.getServiceType().equals("租车")){
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
			RobotPopularizeDto robotPopularizeDtoBean = dtos.get(iRandom);
            if(StringUtils.isNotBlank(robotPopularizeDtoBean.getPopularize1())){
				sourceData.append(robotPopularizeDtoBean.getPopularize1());
			}
			if(StringUtils.isNotBlank(robotPopularizeDtoBean.getPopularize2())){
				sourceData.append(robotPopularizeDtoBean.getPopularize2());
			}
			if(StringUtils.isNotBlank(robotPopularizeDtoBean.getPopularize3())){
				sourceData.append(robotPopularizeDtoBean.getPopularize3());
			}
			if(StringUtils.isNotBlank(robotPopularizeDtoBean.getPopularize4())){
				sourceData.append(robotPopularizeDtoBean.getPopularize4());
			}
			if(StringUtils.isNotBlank(robotPopularizeDtoBean.getPopularize5())){
				sourceData.append(robotPopularizeDtoBean.getPopularize5());
			}
			if(StringUtils.isNotBlank(robotPopularizeDtoBean.getPopularize6())){
				sourceData.append(robotPopularizeDtoBean.getPopularize6());
			}

		}
		List<RobotCode> configs = robotConfigService.queryDictionary("QQ_SOURCE_GROUP");
		if(!CollectionUtils.isEmpty(configs)){
			for(RobotCode config:configs){
				logger.info("***********************打印config配置：{}"+JSON.toJSONString(config));
				try {
					 SendTools.QQSend(config.getName(),sourceData.toString());

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
