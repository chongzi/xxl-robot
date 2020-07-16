package com.xxl.robot.service.impl;

import com.xxl.robot.service.RobotQqService;
import com.xxl.robot.service.RobotService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * todo 机器人服务类
 */
@Service
public class RobotServiceImpl implements RobotService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(RobotServiceImpl.class);

	@Autowired
	public SimpMessagingTemplate template;
	@Autowired
	private RobotQqService robotQqService;

	/**
	 * QQ自动采集
	 */
	@Override
	public void autoCollectQQ() {
		robotQqService.collectQQ();
	}

	/**
	 * QQ自动发送
	 */
	@Override
	public void autoSendQQ() {

	}

	/**
	 * QQ自动添加
	 */
	@Override
	public void autoAddQQ() {

	}


}
