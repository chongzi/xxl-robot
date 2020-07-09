package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.CarSourceDto;
import com.xxl.robot.entity.CarSource;

/**
 * 
 * 汽车源数据服务接口类接口
 */
public interface CarSourceService extends IBaseService<CarSourceDto> {

    /**
     * 解析QQ信息
     */
    void analysisQQ();

    /**
     * 时时信息
     * @param dto
     */
    void speedWebsocket(CarSource dto);

}
