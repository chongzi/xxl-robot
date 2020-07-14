package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.RobotPopularizeDto;

/**
 * 
 * 推广接口
 */
public interface RobotPopularizeService extends IBaseService<RobotPopularizeDto> {



    /**
     * 启用/禁用
     * @param id
     * @return
     */
    int doEnabled(Long id);


}
