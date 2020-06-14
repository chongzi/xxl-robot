package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.CarDriverDto;

/**
 * 
 * 司机服务接口类接口
 */
public interface CarDriverService extends IBaseService<CarDriverDto> {

    int doEnabled(Long id);

}
