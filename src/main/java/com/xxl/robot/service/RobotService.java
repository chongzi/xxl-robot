package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.RobotDto;

/**
 * 
 * todo 机器人接口
 */
public interface RobotService{

//*****************************************************************************************************************************************
//QQ必要条件：1.设置独立窗口  2.设置有消息时弹出

    /**
     * QQ信息采集
     */
    void autoCollectQQ();

    /**
     * QQ发送消息
     */
    void autoSendQQ();

    /**
     * QQ自动添加
     */
    void autoAddQQ();

}
