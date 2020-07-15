package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.RobotPlanDto;
import com.xxl.robot.entity.RobotPlan;

/**
 * 
 * todo 执行计划接口
 */
public interface RobotPlanService extends IBaseService<RobotPlanDto> {

	/**
	 * 启用/禁用
	 * @param id
	 * @return
	 */
	int doEnabled(Long id);

	/**
	 * todo
	 * @return
	 */
	RobotPlanDto selectByHostOperate(RobotPlan entity);

	/**
	 * todo 开启执行计划
	 */
	void handleTask(String condition, RobotPlanDto dto);

	/**
	 * todo 开启操作执行计划
	 */
	void handleTaskOperate(RobotPlanDto dto);

}
