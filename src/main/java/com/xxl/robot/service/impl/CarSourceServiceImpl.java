package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.CarSourceMapper;
import com.xxl.robot.dto.CarSourceDto;
import com.xxl.robot.entity.CarSource;
import com.xxl.robot.enums.CarEnum;
import com.xxl.robot.service.CarSourceService;
import com.xxl.robot.time.GrabbingCarSchedule;
import com.xxl.robot.tools.CarTools;
import com.xxl.robot.tools.DateTools;
import com.xxl.robot.tools.RegTools;
import com.xxl.robot.tools.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class CarSourceServiceImpl implements CarSourceService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(GrabbingCarSchedule.class);

	@Autowired
	private CarSourceMapper carSourceMapper;
	@Autowired
	public SimpMessagingTemplate template;

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

	private Condition getCondition(CarSourceDto dto){
		Condition condition = new Condition(CarSource.class);
		Condition.Criteria criteria = condition.createCriteria();

		return condition;
	}



	@Override
	public int insertBatch(List<CarSource> carSources) {
//		return carSourceMapper.insertBatch(carSources);
		return 0;
	}

	public CarSource getCarSource(String rowData) {
		try {
			CarSource carSource = new CarSource();

            Map<String,Object> map = CarTools.analysis(rowData);
            if(null!=map) {
				carSource.setStated((byte) 0);
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
	 * @param datas
	 */
	@Async("taskExecutor")
	@Override
	public void analysisQQ(List<String> datas){
		List<CarSource> carSources = new ArrayList<>();
		if(!CollectionUtils.isEmpty(datas)) {
			for (String data : datas) {
				String[] result = data.split(RegTools.TIME);
				for(int i=0;i<result.length;i++){
					CarSource carSource = getCarSource(result[i]);
					if(null!=carSource){
						carSources.add(carSource);
					}
				}
			}
		}
		carSources.stream().distinct().collect(Collectors.toList());
		carSourceMapper.insertList(carSources);
		speedWebsocket(carSources);
	}

	@Override
	public void speedWebsocket(List<CarSource> carSources) {
		for(CarSource dto:carSources) {
			StringBuffer str = new StringBuffer();
			if (Integer.valueOf(dto.getRentType()) == 0) {
				str.append("<div class='timeline-item' id='responseOpc'> <div class='timeline-event timeline-event-success'> <div class='timeline-heading'> <h4>");
				str.append("【时间】" + dto.getStartTime() + "【类型】" + "人找车" + "【电话】" + dto.getMobile() + "【人数】" + dto.getPersonNumber() + "个" + "【开始地】" + dto.getToPlace() + "【目的地】" + dto.getFromPlace());
				str.append("</h4></div><div class='timeline-body'><p>");
				str.append("【原始数据】" + dto.getBasicData());
				str.append("</p></div></div></div>");
			}
			if (Integer.valueOf(dto.getRentType()) == 1) {
				str.append("<div class='timeline-item' id='responseOpc'> <div class='timeline-event'> <div class='timeline-heading'> <h4>");
				str.append("【时间】" + dto.getStartTime() + "【类型】" + "人找车" + "【电话】" + dto.getMobile() + "【人数】" + dto.getPersonNumber() + "个" + "【开始地】" + dto.getToPlace() + "【目的地】" + dto.getFromPlace());
				str.append("</h4></div><div class='timeline-body'><p>");
				str.append("【原始数据】" + dto.getBasicData());
				str.append("</p></div></div></div>");
			}

			template.convertAndSend("/topic/notice", str.substring(0, str.length()));
		}
	}


}
