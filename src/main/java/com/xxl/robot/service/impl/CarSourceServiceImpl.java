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
import com.xxl.robot.tools.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.logging.Logger;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class CarSourceServiceImpl implements CarSourceService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(GrabbingCarSchedule.class);

	@Autowired
	private CarSourceMapper carSourceMapper;


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
	public int doEnabled(Long id) {
		CarSource entity = carSourceMapper.selectByPrimaryKey(id);
		if(null!=entity){
			if(entity.getEnabled()==0){
				entity.setEnabled((byte) 1);
			}else{
				entity.setEnabled((byte) 0);
			}
		}
		return carSourceMapper.updateByPrimaryKey(entity);
	}

	@Override
	public int insertBatch(List<CarSource> carSources) {
		return carSourceMapper.insertBatch(carSources);
	}

	@Override
	public CarSource analysis(String rowData) {
		try {
			CarSource carSource = new CarSource();
			carSource.setBasicData(rowData);
			String to = null;
			String from = null;
			String startTime = null;
			if (rowData.contains("车找人")) {
				carSource.setType((byte) 1);


			} else if (rowData.contains("人找车")) {
				carSource.setType((byte) 0);
			}
			//起始-终点
			if (rowData.contains(CarEnum.BACK.getCode())||rowData.contains(CarEnum.ARRIVE.getCode()) ||rowData.contains(CarEnum.GO.getCode())
					||rowData.contains(CarEnum.MIDDLE_LINE.getCode())) {
				to = rowData.substring(rowData.indexOf(CarEnum.BACK.getCode())-2,rowData.indexOf(CarEnum.BACK.getCode()));
				from = rowData.substring(rowData.indexOf(CarEnum.BACK.getCode()),rowData.indexOf(CarEnum.BACK.getCode())+2);
			}
			//时间
			if(rowData.contains(CarEnum.POINT.getCode())){
				if()
			}


			String mobile = StringTools.getMobile(rowData);

		}catch (Exception e){
			log.info("方法 analysis（）顺风车单条数据解析失败：｛｝");
			e.printStackTrace();
		}
		return null;
	}


}
