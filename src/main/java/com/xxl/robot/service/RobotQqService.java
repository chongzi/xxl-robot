package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.RobotQqDto;

import java.util.List;

/**
 * 
 * qq服务接口类接口
 */
public interface RobotQqService extends IBaseService<RobotQqDto> {

    /**
     * 处理QQ信息入库
     * @param datas
     * @return
     */
    void handleQQ(List<String> datas);



}
