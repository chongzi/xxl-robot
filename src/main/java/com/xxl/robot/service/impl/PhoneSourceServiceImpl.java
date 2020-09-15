package com.xxl.robot.service.impl;

import com.xxl.robot.app.media.*;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.PhoneCodeService;
import com.xxl.robot.service.PhoneSourceService;
import com.xxl.robot.tools.WindowTools;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class PhoneSourceServiceImpl implements PhoneSourceService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(PhoneSourceServiceImpl.class);
	@Autowired
	private PhoneCodeService phoneCodeService;

	@Override
	public void handleRobot2() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","抖音极速版");
		WindowTools.initWindowApp(robot,dtos);

		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.CHECK_IN,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.TREASURE,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_ADVERT,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.SLEEP,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_NOVELS,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WALK,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_VIDEOS,dtos);
	}


	@Override
	public void handleRobot3() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","火山极速版");
		WindowTools.initWindowApp(robot,dtos);

		//B视频火山.handle(robot,"phone001","火山极速版", AppConstants.CHECK_IN,dtos);
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.TREASURE,dtos);
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.GROW,dtos);
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.WALK,dtos);
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.WATCH_ADVERT,dtos);
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.SLEEP,dtos);
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.WATCH_VIDEOS,dtos);
	}




	@Override
	public void handleRobot4() {
		PhoneCodeDto dto = new PhoneCodeDto();
		dto.setRobotCode("phone001");
		dto.setAppCode("快手极速版");
		List<PhoneCodeDto> dtos = phoneCodeService.list(dto);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WindowTools.initWindowApp(robot,dtos);

		A视频快手.handle(robot,"phone001","快手极速版", AppConstants.WATCH_ADVERT,dtos);
	}

	@Override
	public void handleRobot5() {
		PhoneCodeDto dto = new PhoneCodeDto();
		dto.setRobotCode("phone001");
		dto.setAppCode("微视");
		List<PhoneCodeDto> dtos = phoneCodeService.list(dto);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WindowTools.initWindowApp(robot,dtos);

		A视频微视.handle(robot,"phone001","微视", AppConstants.WATCH_VIDEOS,dtos);
	}

	@Override
	public void handleRobot6() {
		PhoneCodeDto dto = new PhoneCodeDto();
		dto.setRobotCode("phone001");
		dto.setAppCode("刷宝");
		List<PhoneCodeDto> dtos = phoneCodeService.list(dto);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WindowTools.initWindowApp(robot,dtos);

		A视频刷宝.handle(robot,"phone001","刷宝", AppConstants.WATCH_VIDEOS,dtos);
	}

	@Override
	public void handleRobot7() {
		PhoneCodeDto dto = new PhoneCodeDto();
		dto.setRobotCode("phone001");
		dto.setAppCode("快逗");
		List<PhoneCodeDto> dtos = phoneCodeService.list(dto);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WindowTools.initWindowApp(robot,dtos);

		F视频快逗.handle(robot,"phone001","快逗", AppConstants.WATCH_VIDEOS,dtos);
	}

	@Override
	public void handleRobot8() {
		PhoneCodeDto dto = new PhoneCodeDto();
		dto.setRobotCode("phone001");
		dto.setAppCode("追看");
		List<PhoneCodeDto> dtos = phoneCodeService.list(dto);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WindowTools.initWindowApp(robot,dtos);

		G视频追看.handle(robot,"phone001","追看", AppConstants.WATCH_VIDEOS,dtos);
	}

	@Override
	public void handleRobot9() {
		PhoneCodeDto dto = new PhoneCodeDto();
		dto.setRobotCode("phone001");
		dto.setAppCode("小吃货");
		List<PhoneCodeDto> dtos = phoneCodeService.list(dto);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WindowTools.initWindowApp(robot,dtos);

		H视频小吃货.handle(robot,"phone001","小吃货", AppConstants.WATCH_VIDEOS,dtos);
	}


}