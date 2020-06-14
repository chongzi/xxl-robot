package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.CarWechartMapper;
import com.xxl.robot.dto.CarWechartDto;
import com.xxl.robot.entity.CarWechart;
import com.xxl.robot.service.CarWechartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class CarWechartServiceImpl implements CarWechartService {

	@Autowired
	private CarWechartMapper carWechartMapper;


	@Override
	public CarWechartDto get(Long id) {
		CarWechart entity = new CarWechart();
		entity.setId(id);
		return BeanTools.sourceToTarget(carWechartMapper.selectOne(entity),CarWechartDto.class);
	}

	@Override
	public int save(CarWechartDto dto) {
		CarWechart entity = BeanTools.sourceToTarget(dto,CarWechart.class);
		return carWechartMapper.insert(entity);
	}


	@Override
	public int update(CarWechartDto dto) {
		CarWechart entity = BeanTools.sourceToTarget(dto,CarWechart.class);
		return carWechartMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return carWechartMapper.deleteByIds(ids);
	}

	@Override
	public List<CarWechartDto> list(CarWechartDto dto) {
		List<CarWechart> dtos = carWechartMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, CarWechartDto.class);
	}


	@Override
	public PageInfo<CarWechartDto> page(CarWechartDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<CarWechartDto> beans = BeanTools.sourceToTarget(carWechartMapper.selectByCondition(getCondition(dto)),CarWechartDto.class);
		PageInfo<CarWechartDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(CarWechartDto dto){
		Condition condition = new Condition(CarWechart.class);
		Condition.Criteria criteria = condition.createCriteria();


		return condition;
	}



}
