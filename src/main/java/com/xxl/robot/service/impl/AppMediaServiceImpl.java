package com.xxl.robot.service.impl;

import com.xxl.robot.app.media.*;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.AppMediaService;
import com.xxl.robot.service.PhoneCodeService;
import com.xxl.robot.tools.WindowTools;
import lombok.SneakyThrows;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 *
 * todo app-视频服务接口类接口
 */
@Service
public class AppMediaServiceImpl implements AppMediaService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppMediaServiceImpl.class);

	@Autowired
	private PhoneCodeService phoneCodeService;

	/**
	 * todo 早上收取昨晚金币（签到，领取睡觉金币，）
	 */
	@SneakyThrows
	@Override
	public void start() {

	}

	/**
	 * todo 白天执行一次
	 */
	@Override
	public void  one() {

	}

	/**
	 * todo 循环执行领金币
	 */
	@SneakyThrows
	@Override
	public void circulate() {
		Robot robot = new Robot();

		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","抖音极速版");
		WindowTools.initWindowApp(robot,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.TREASURE,dtos);//夺宝
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_ADVERT,dtos);//观看广告

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","火山极速版");
		WindowTools.initWindowApp(robot,dtos1);
		B视频火山.handle(robot,"phone001","火山极速版", AppConstants.TREASURE,dtos1);//夺宝
	}

	/***
	 * todo 玩游戏
	 */
	@Override
	public void playGame() {

	}

	/***
	 * todo 晚上收取白天金币
	 */
	@Override
	public void end() {

	}

//********************************************************************定制化 START**********************************************************************************

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
		B视频火山.handle(robot,"phone001","火山极速版", AppConstants.TREASURE,dtos);
		B视频火山.handle(robot,"phone001","火山极速版", AppConstants.GROW,dtos);
		B视频火山.handle(robot,"phone001","火山极速版", AppConstants.WALK,dtos);
		B视频火山.handle(robot,"phone001","火山极速版", AppConstants.WATCH_ADVERT,dtos);
		B视频火山.handle(robot,"phone001","火山极速版", AppConstants.SLEEP,dtos);
		B视频火山.handle(robot,"phone001","火山极速版", AppConstants.WATCH_VIDEOS,dtos);
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

		C视频快手.handle(robot,"phone001","快手极速版", AppConstants.WATCH_ADVERT,dtos);
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

		D视频微视.handle(robot,"phone001","微视", AppConstants.WATCH_VIDEOS,dtos);
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

		E视频刷宝.handle(robot,"phone001","刷宝", AppConstants.WATCH_VIDEOS,dtos);
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
