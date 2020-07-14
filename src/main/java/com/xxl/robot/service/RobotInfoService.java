package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.RobotCodeDto;
import com.xxl.robot.dto.RobotInfoDto;
import com.xxl.robot.entity.RobotCode;

import java.util.List;
import java.util.Map;

/**
 * 
 * 配置表服务接口类接口
 */
public interface RobotInfoService extends IBaseService<RobotInfoDto> {



	RobotInfoDto selectByUnique(RobotInfoDto dto);
	/**
	 * 启用/禁用
	 * @param id
	 * @return
	 */
	int doEnabled(Long id);


}
