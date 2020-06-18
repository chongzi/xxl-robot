package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.CarDriverDto;
import com.xxl.robot.dto.CarQqDto;
import com.xxl.robot.entity.CarQq;

import java.util.List;

/**
 * 
 * 汽车租赁qq服务接口类接口
 */
public interface CarQqService extends IBaseService<CarQqDto> {

    /**
     * 处理QQ信息入库
     * @param datas
     * @return
     */
    List<String> handleQQ(List<String> datas);

    void analysisQQ(List<String> datas);

}
