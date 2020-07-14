package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.RobotPopularizeMapper;
import com.xxl.robot.dto.RobotPopularizeDto;
import com.xxl.robot.entity.RobotPopularize;
import com.xxl.robot.service.RobotPopularizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class RobotPopularizeServiceImpl implements RobotPopularizeService {

	@Autowired
	private RobotPopularizeMapper robotPopularizeMapper;


	@Override
	public RobotPopularizeDto get(Long id) {
		RobotPopularize entity = new RobotPopularize();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotPopularizeMapper.selectOne(entity),RobotPopularizeDto.class);
	}

	@Override
	public int save(RobotPopularizeDto dto) {
		RobotPopularize entity = BeanTools.sourceToTarget(dto, RobotPopularize.class);
		return robotPopularizeMapper.insert(entity);
	}


	@Override
	public int update(RobotPopularizeDto dto) {
		RobotPopularize entity = BeanTools.sourceToTarget(dto, RobotPopularize.class);
		return robotPopularizeMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return robotPopularizeMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotPopularizeDto> list(RobotPopularizeDto dto) {
		List<RobotPopularize> dtos = robotPopularizeMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotPopularizeDto.class);
	}


	@Override
	public PageInfo<RobotPopularizeDto> page(RobotPopularizeDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotPopularizeDto> beans = BeanTools.sourceToTarget(robotPopularizeMapper.selectByCondition(getCondition(dto)),RobotPopularizeDto.class);
		PageInfo<RobotPopularizeDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotPopularizeDto dto){
		Condition condition = new Condition(RobotPopularize.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(null!=dto.getServiceType()){
			criteria.andEqualTo("serviceType",dto.getServiceType());
		}
		if(null!=dto.getEnabled()){
			criteria.andEqualTo("enabled",dto.getEnabled());
		}
		return condition;
	}

//***********************************************业务逻辑************************************************************
	@Override
	public int doEnabled(Long id) {
		RobotPopularize entity = robotPopularizeMapper.selectByPrimaryKey(id);
		if(null!=entity){
			if(entity.getEnabled()==0){
				entity.setEnabled((byte) 1);
			}else{
				entity.setEnabled((byte) 0);
			}
		}
		return robotPopularizeMapper.updateByPrimaryKey(entity);
	}







}
