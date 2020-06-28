package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.CarDriverDto;
import com.xxl.robot.dto.CarSourceDto;
import com.xxl.robot.entity.CarSource;

import java.util.List;

/**
 * 
 * 汽车源数据服务接口类接口
 */
public interface CarSourceService extends IBaseService<CarSourceDto> {


    /**
     * 批量插入
     * @param carSources
     * @return
     */
    int insertBatch(List<CarSource> carSources);

    /**
     * 解析QQ信息
     * @param datas
     */
    void analysisQQ(List<String> datas);

    /**
     * 时时信息
     * @param carSources
     */
    void speedWebsocket(List<CarSource> carSources);

}
