package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.CarQqMapper;
import com.xxl.robot.dto.CarQqDto;
import com.xxl.robot.entity.CarQq;
import com.xxl.robot.entity.CarQq;
import com.xxl.robot.service.CarQqService;
import com.xxl.robot.service.CarQqService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class CarQqServiceImpl implements CarQqService {

	@Autowired
	private CarQqMapper carQqMapper;


	@Override
	public CarQqDto get(Long id) {
		CarQq entity = new CarQq();
		entity.setId(id);
		return BeanTools.sourceToTarget(carQqMapper.selectOne(entity),CarQqDto.class);
	}

	@Override
	public int save(CarQqDto dto) {
		CarQq entity = BeanTools.sourceToTarget(dto,CarQq.class);
		return carQqMapper.insert(entity);
	}


	@Override
	public int update(CarQqDto dto) {
		CarQq entity = BeanTools.sourceToTarget(dto,CarQq.class);
		return carQqMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return carQqMapper.deleteByIds(ids);
	}

	@Override
	public List<CarQqDto> list(CarQqDto dto) {
		List<CarQq> dtos = carQqMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, CarQqDto.class);
	}


	@Override
	public PageInfo<CarQqDto> page(CarQqDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<CarQqDto> beans = BeanTools.sourceToTarget(carQqMapper.selectByCondition(getCondition(dto)),CarQqDto.class);
		PageInfo<CarQqDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(CarQqDto dto){
		Condition condition = new Condition(CarQq.class);
		Condition.Criteria criteria = condition.createCriteria();

		return condition;
	}


}
