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
     * 启用/禁用
     * @param id
     * @return
     */
    int doEnabled(Long id);

    /**
     * 批量插入
     * @param carSources
     * @return
     */
    int insertBatch(List<CarSource> carSources);

     void analysisQQ(List<String> datas);

}
