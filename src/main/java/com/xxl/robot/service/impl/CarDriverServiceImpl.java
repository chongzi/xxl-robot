package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.CarDriverMapper;
import com.xxl.robot.dto.CarDriverDto;
import com.xxl.robot.entity.CarDriver;
import com.xxl.robot.service.CarDriverService;
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
public class CarDriverServiceImpl implements CarDriverService {

	@Autowired
	private CarDriverMapper carDriverMapper;


	@Override
	public CarDriverDto get(Long id) {
		CarDriver entity = new CarDriver();
		entity.setId(id);
		return BeanTools.sourceToTarget(carDriverMapper.selectOne(entity),CarDriverDto.class);
	}

	@Override
	public int save(CarDriverDto dto) {
		CarDriver entity = BeanTools.sourceToTarget(dto,CarDriver.class);
		return carDriverMapper.insert(entity);
	}


	@Override
	public int update(CarDriverDto dto) {
		CarDriver entity = BeanTools.sourceToTarget(dto,CarDriver.class);
		return carDriverMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return carDriverMapper.deleteByIds(ids);
	}

	@Override
	public List<CarDriverDto> list(CarDriverDto dto) {
		List<CarDriver> dtos = carDriverMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, CarDriverDto.class);
	}


	@Override
	public PageInfo<CarDriverDto> page(CarDriverDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<CarDriverDto> beans = BeanTools.sourceToTarget(carDriverMapper.selectByCondition(getCondition(dto)),CarDriverDto.class);
		PageInfo<CarDriverDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(CarDriverDto dto){
		Condition condition = new Condition(CarDriver.class);
		Condition.Criteria criteria = condition.createCriteria();

		if(StringUtils.isNotBlank(dto.getName())){
			criteria.andEqualTo("name",dto.getName());
		}


		return condition;
	}


	@Override
	public int doEnabled(Long id) {
		CarDriver entity = carDriverMapper.selectByPrimaryKey(id);
		if(null!=entity){
			if(entity.getEnabled()==0){
				entity.setEnabled((byte) 1);
			}else{
				entity.setEnabled((byte) 0);
			}
		}
		return carDriverMapper.updateByPrimaryKey(entity);
	}


}
