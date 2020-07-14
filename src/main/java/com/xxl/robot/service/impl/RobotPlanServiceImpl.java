package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.RobotPlanMapper;
import com.xxl.robot.dto.RobotPlanDto;
import com.xxl.robot.entity.RobotPlan;
import com.xxl.robot.service.RobotPlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;

/**
 * 
 * todo 配置表服务类
 */
@Service
public class RobotPlanServiceImpl implements RobotPlanService {

	@Autowired
	private RobotPlanMapper robotPlanMapper;


	@Override
	public RobotPlanDto get(Long id) {
		RobotPlan entity = new RobotPlan();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotPlanMapper.selectOne(entity),RobotPlanDto.class);
	}

	@Override
	public int save(RobotPlanDto dto) {
		RobotPlan entity = BeanTools.sourceToTarget(dto, RobotPlan.class);
		return robotPlanMapper.insert(entity);
	}


	@Override
	public int update(RobotPlanDto dto) {
		RobotPlan entity = BeanTools.sourceToTarget(dto, RobotPlan.class);
		return robotPlanMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return robotPlanMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotPlanDto> list(RobotPlanDto dto) {
		List<RobotPlan> dtos = robotPlanMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotPlanDto.class);
	}


	@Override
	public PageInfo<RobotPlanDto> page(RobotPlanDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotPlanDto> beans = BeanTools.sourceToTarget(robotPlanMapper.selectByCondition(getCondition(dto)),RobotPlanDto.class);
		PageInfo<RobotPlanDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotPlanDto dto){
		Condition condition = new Condition(RobotPlan.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(StringUtils.isNotBlank(dto.getRobotCode())){
			criteria.andEqualTo("robot_code",dto.getRobotCode());
		}
		if(null!=dto.getOperateType()){
			criteria.andEqualTo("operate_type",dto.getOperateType());
		}
		if(null!=dto.getEnabled()){
			criteria.andEqualTo("enabled",dto.getEnabled());
		}
		return condition;
	}



	@Override
	public int doEnabled(Long id) {
		RobotPlan entity = robotPlanMapper.selectByPrimaryKey(id);
		if(null!=entity){
			if(entity.getEnabled()==0){
				entity.setEnabled((byte) 1);
			}else{
				entity.setEnabled((byte) 0);
			}
		}
		return robotPlanMapper.updateByPrimaryKey(entity);
	}

	@Override
	public RobotPlanDto selectByHostOperate(RobotPlan entity) {
		return BeanTools.sourceToTarget(robotPlanMapper.selectOne(entity),RobotPlanDto.class);
	}


}
