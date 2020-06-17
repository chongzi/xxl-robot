package com.xxl.robot.service.impl;

import com.github.binarywang.java.emoji.EmojiConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.RobotConfigMapper;
import com.xxl.robot.dto.RobotConfigDto;
import com.xxl.robot.entity.RobotConfig;
import com.xxl.robot.service.RobotConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class RobotConfigServiceImpl implements RobotConfigService {

	@Autowired
	private RobotConfigMapper robotConfigMapper;


	@Override
	public RobotConfigDto get(Long id) {
		RobotConfig entity = new RobotConfig();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotConfigMapper.selectOne(entity),RobotConfigDto.class);
	}

	@Override
	public int save(RobotConfigDto dto) {
		RobotConfig entity = BeanTools.sourceToTarget(dto,RobotConfig.class);
		return robotConfigMapper.insert(entity);
	}


	@Override
	public int update(RobotConfigDto dto) {
		RobotConfig entity = BeanTools.sourceToTarget(dto,RobotConfig.class);
		return robotConfigMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return robotConfigMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotConfigDto> list(RobotConfigDto dto) {
		List<RobotConfig> dtos = robotConfigMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotConfigDto.class);
	}


	@Override
	public PageInfo<RobotConfigDto> page(RobotConfigDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotConfigDto> beans = BeanTools.sourceToTarget(robotConfigMapper.selectByCondition(getCondition(dto)),RobotConfigDto.class);
		PageInfo<RobotConfigDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotConfigDto dto){
		Condition condition = new Condition(RobotConfig.class);
		Condition.Criteria criteria = condition.createCriteria();

		return condition;
	}


	@Override
	public int doEnabled(Long id) {
		RobotConfig entity = robotConfigMapper.selectByPrimaryKey(id);
		if(null!=entity){
			if(entity.getEnabled()==0){
				entity.setEnabled((byte) 1);
			}else{
				entity.setEnabled((byte) 0);
			}
		}
		return robotConfigMapper.updateByPrimaryKey(entity);
	}




}
