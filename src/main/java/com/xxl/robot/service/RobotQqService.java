package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.RobotQqDto;
import com.xxl.robot.entity.RobotCode;

import java.util.List;

/**
 * 
 * qq服务接口类接口
 */
public interface RobotQqService extends IBaseService<RobotQqDto> {


    /**
     * QQ初始化
     */
    void initQQ();

    /**
     * 处理QQ信息入库
     * @param datas
     * @return
     */
    void handleQQ(List<String> datas);

    /**
     * 处理QQ信息入库
     * @param data
     * @return
     */
    void handleQQ(RobotCode config, String data);


    /**
     * 启用/禁用
     * @param id
     * @return
     */
    int doEnabled(Long id);

    /**
     * qq数据信息采集
     */
    void collectQQ();


    /**
     * QQ发送消息
     */
    void sendQQ();

    /**
     * QQ自动添加
     */
    void addQQ();

}
