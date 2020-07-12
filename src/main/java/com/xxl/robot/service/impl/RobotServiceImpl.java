package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.CarSourceMapper;
import com.xxl.robot.dto.CarSourceDto;
import com.xxl.robot.dto.RobotQqDto;
import com.xxl.robot.entity.CarSource;
import com.xxl.robot.service.CarSourceService;
import com.xxl.robot.service.RobotQqService;
import com.xxl.robot.service.RobotService;
import com.xxl.robot.time.GrabbingCarSchedule;
import com.xxl.robot.tools.CarTools;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
