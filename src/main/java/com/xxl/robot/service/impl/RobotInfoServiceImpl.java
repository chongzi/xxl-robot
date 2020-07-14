package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.RobotInfoMapper;
import com.xxl.robot.dto.RobotInfoDto;
import com.xxl.robot.entity.RobotInfo;
import com.xxl.robot.service.RobotInfoService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * todo 配置表服务类
 */
@Service
public class RobotInfoServiceImpl implements RobotInfoService {

	@Autowired
	private RobotInfoMapper robotConfigMapper;


	@Override
	public RobotInfoDto get(Long id) {
		RobotInfo entity = new RobotInfo();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotConfigMapper.selectOne(entity), RobotInfoDto.class);
	}

	@Override
	public int save(RobotInfoDto dto) {
		RobotInfo entity = BeanTools.sourceToTarget(dto, RobotInfo.class);
		return robotConfigMapper.insert(entity);
	}


	@Override
	public int update(RobotInfoDto dto) {
		RobotInfo entity = BeanTools.sourceToTarget(dto, RobotInfo.class);
		return robotConfigMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return robotConfigMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotInfoDto> list(RobotInfoDto dto) {
		List<RobotInfo> dtos = robotConfigMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotInfoDto.class);
	}


	@Override
	public PageInfo<RobotInfoDto> page(RobotInfoDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotInfoDto> beans = BeanTools.sourceToTarget(robotConfigMapper.selectByCondition(getCondition(dto)), RobotInfoDto.class);
		PageInfo<RobotInfoDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotInfoDto dto){
		Condition condition = new Condition(RobotInfo.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(StringUtils.isNotBlank(dto.getHost())){
			criteria.andLike("host",dto.getHost());
		}
		if(StringUtils.isNotBlank(dto.getRobotCode())){
			criteria.andEqualTo("robotCode",dto.getRobotCode());
		}
		if(StringUtils.isNotBlank(dto.getServiceType())){
			criteria.andEqualTo("serviceType",dto.getServiceType());
		}
		if(StringUtils.isNotBlank(dto.getName())){
			criteria.andEqualTo("name",dto.getName());
		}
		return condition;
	}


	@Override
	public int doEnabled(Long id) {
		RobotInfo entity = robotConfigMapper.selectByPrimaryKey(id);
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
