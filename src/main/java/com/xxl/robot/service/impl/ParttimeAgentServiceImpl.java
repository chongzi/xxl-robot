package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.ParttimeAgentMapper;
import com.xxl.robot.dto.ParttimeAgentDto;
import com.xxl.robot.entity.ParttimeAgent;
import com.xxl.robot.entity.RobotConfig;
import com.xxl.robot.service.ParttimeAgentService;
import com.xxl.robot.service.CarSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class ParttimeAgentServiceImpl implements ParttimeAgentService {

	@Autowired
	private ParttimeAgentMapper parttimeAgentMapper;


	@Override
	public ParttimeAgentDto get(Long id) {
		ParttimeAgent entity = new ParttimeAgent();
		entity.setId(id);
		return BeanTools.sourceToTarget(parttimeAgentMapper.selectOne(entity),ParttimeAgentDto.class);
	}

	@Override
	public int save(ParttimeAgentDto dto) {
		ParttimeAgent entity = BeanTools.sourceToTarget(dto,ParttimeAgent.class);
		return parttimeAgentMapper.insert(entity);
	}


	@Override
	public int update(ParttimeAgentDto dto) {
		ParttimeAgent entity = BeanTools.sourceToTarget(dto,ParttimeAgent.class);
		return parttimeAgentMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return parttimeAgentMapper.deleteByIds(ids);
	}

	@Override
	public List<ParttimeAgentDto> list(ParttimeAgentDto dto) {
		List<ParttimeAgent> dtos = parttimeAgentMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, ParttimeAgentDto.class);
	}


	@Override
	public PageInfo<ParttimeAgentDto> page(ParttimeAgentDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<ParttimeAgentDto> beans = BeanTools.sourceToTarget(parttimeAgentMapper.selectByCondition(getCondition(dto)),ParttimeAgentDto.class);
		PageInfo<ParttimeAgentDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(ParttimeAgentDto dto){
		Condition condition = new Condition(ParttimeAgent.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(null!=dto.getAngentType()){
			criteria.andEqualTo("agent_type",dto.getAngentType());
		}
		if(null!=dto.getEnabled()){
			criteria.andEqualTo("enabled",dto.getEnabled());
		}
		return condition;
	}

//***********************************************业务逻辑************************************************************
	@Override
	public int doEnabled(Long id) {
		ParttimeAgent entity = parttimeAgentMapper.selectByPrimaryKey(id);
		if(null!=entity){
			if(entity.getEnabled()==0){
				entity.setEnabled((byte) 1);
			}else{
				entity.setEnabled((byte) 0);
			}
		}
		return parttimeAgentMapper.updateByPrimaryKey(entity);
	}







}
