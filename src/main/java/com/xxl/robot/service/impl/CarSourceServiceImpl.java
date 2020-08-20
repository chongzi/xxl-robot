package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.CarSourceMapper;
import com.xxl.robot.dto.RobotInfoDto;
import com.xxl.robot.dto.RobotQqDto;
import com.xxl.robot.dto.CarSourceDto;
import com.xxl.robot.entity.CarSource;
import com.xxl.robot.service.RobotInfoService;
import com.xxl.robot.service.RobotQqService;
import com.xxl.robot.service.CarSourceService;
import com.xxl.robot.tools.CarTools;
import com.xxl.robot.tools.DateTools;
import com.xxl.robot.tools.HostTools;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class CarSourceServiceImpl implements CarSourceService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(CarSourceServiceImpl.class);

	@Autowired
	private CarSourceMapper carSourceMapper;
	@Autowired
	public SimpMessagingTemplate template;
	@Autowired
	private RobotQqService RobotQqService;
	@Autowired
	private RobotInfoService robotInfoService;

	@Override
	public CarSourceDto get(Long id) {
		CarSource entity = new CarSource();
		entity.setId(id);
		return BeanTools.sourceToTarget(carSourceMapper.selectOne(entity),CarSourceDto.class);
	}

	@Override
	public int save(CarSourceDto dto) {
		CarSource entity = BeanTools.sourceToTarget(dto,CarSource.class);
		return carSourceMapper.insert(entity);
	}


	@Override
	public int update(CarSourceDto dto) {
		CarSource entity = BeanTools.sourceToTarget(dto,CarSource.class);
		return carSourceMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return carSourceMapper.deleteByIds(ids);
	}

	@Override
	public List<CarSourceDto> list(CarSourceDto dto) {
		List<CarSource> dtos = carSourceMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, CarSourceDto.class);
	}


	@Override
	public PageInfo<CarSourceDto> page(CarSourceDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<CarSourceDto> beans = BeanTools.sourceToTarget(carSourceMapper.selectByCondition(getCondition(dto)),CarSourceDto.class);
		PageInfo<CarSourceDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}


	@Override
	public PageInfo<CarSourceDto> subPage(CarSourceDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		dto.setRentType((byte) 1);
		if(dto.getCarSourceId()>0L){
			CarSource carSource= carSourceMapper.selectByPrimaryKey(dto.getCarSourceId());
			String startTime = carSource.getStartTime();
			Date date = DateTools.stringToDate(startTime,DateTools.DATE_TIME_PATTERN);

			Date planStartTime = DateTools.addDateHours(date,-2);
			Date planEndTime = DateTools.addDateHours(date,2);

			dto.setPlanStartDate(DateTools.format(planStartTime,DateTools.DATE_TIME_PATTERN));
			dto.setPlanEndDate((DateTools.format(planEndTime,DateTools.DATE_TIME_PATTERN)));
			dto.setToPlace(carSource.getToPlace());
			dto.setFromPlace(carSource.getFromPlace());
		}
		List<CarSourceDto> beans = BeanTools.sourceToTarget(carSourceMapper.selectByCondition(getCondition(dto)),CarSourceDto.class);

		PageInfo<CarSourceDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(CarSourceDto dto){
		Condition condition = new Condition(CarSource.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(null!=dto.getStated()){
			criteria.andEqualTo("stated",dto.getStated());
		}
		if(null!=dto.getRentType()){
			criteria.andEqualTo("rentType",dto.getRentType());
		}
		if(null!=dto.getMobile()){
			criteria.andEqualTo("mobile",dto.getMobile());
		}

		if(null!=dto.getToPlace()){
			criteria.andEqualTo("toPlace",dto.getToPlace());
		}
		if(null!=dto.getFromPlace()){
			criteria.andEqualTo("fromPlace",dto.getFromPlace());
		}

		if(null!=dto.getPlanStartDate()){
			criteria.andCondition("start_time >= '"+dto.getPlanStartDate()+"'");
		}

		if(null!=dto.getPlanEndDate()){
			criteria.andCondition("start_time <= '"+dto.getPlanEndDate()+"'");
		}


		condition.orderBy("startTime").desc();



		return condition;
	}


	public CarSource getCarSource(String robotCode, String rowData) {
		try {
			CarSource carSource = new CarSource();

            Map<String,Object> map = CarTools.analysis(rowData);
            if(null!=map) {
				carSource.setStated((byte) 0);
				carSource.setRobotCode(robotCode);
				carSource.setRentType(Byte.valueOf(String.valueOf(map.get("type"))));
 				carSource.setStartTime(String.valueOf(map.get("startTime")));
				carSource.setMobile((String) map.get("mobile"));
				carSource.setToPlace((String) map.get("to"));
				carSource.setFromPlace((String) map.get("from"));
				carSource.setPersonNumber((Integer) map.get("personNumber"));
				carSource.setBasicData((String) map.get("rowData"));
				carSource.setCreateDate(new Date());

				return carSource;
			}
		}catch (Exception e){
			log.info("方法 analysis（）单条数据解析失败：｛｝");
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 异步分析QQ聊天数据
	 */
	@Async("taskExecutor")
	@Override
	public void analysisQQ(){
		RobotQqDto dto = new RobotQqDto();
		dto.setEnabled((byte) 0);
		List<RobotQqDto> list = RobotQqService.list(dto);
		if(!CollectionUtils.isEmpty(list)){
			for(RobotQqDto vo:list){
				CarSource carSource = getCarSource(vo.getRobotCode(), vo.getContent());
				try {
					int i = carSourceMapper.insert(carSource);
					speedWebsocket(carSource);
				}catch (Exception e){
					e.printStackTrace();
				}
				vo.setEnabled((byte) 1);
				vo.setUpdateDate(new Date());
				RobotQqService.update(vo);
			}
//			List<Long> ids= list.stream().map(RobotQqDto::getId).collect(Collectors.toList());
//			String  idss = StringUtils.join(ids.toArray(), ",");
//			RobotQqService.delete(idss);
		}

	}

	@Override
	public void speedWebsocket(CarSource dto) {
		CarSource dto0 = new CarSource();
		dto0.setRentType((byte) 0);
		int count0 = carSourceMapper.selectCount(dto0);

		CarSource dto1 = new CarSource();
		dto1.setRentType((byte) 1);
		int count1 = carSourceMapper.selectCount(dto1);

		CarSourceDto entity = BeanTools.sourceToTarget(dto,CarSourceDto.class);
		entity.setCount0(count0);
		entity.setCount1(count1);
		entity.setTotalNum(count0+count1);
		entity.setRobotNum(count0);
		if(entity.getRentType().equals(Byte.valueOf("0"))){
			template.convertAndSend("/topic/notice", entity);
		}


	}


}
