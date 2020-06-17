package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.CarQqDto;
import com.xxl.robot.dto.RobotConfigDto;

/**
 * 
 * 汽车qq服务接口类接口
 */
public interface RobotConfigService extends IBaseService<RobotConfigDto> {
    /**
     * 启用/禁用
     * @param id
     * @return
     */
    int doEnabled(Long id);

}
