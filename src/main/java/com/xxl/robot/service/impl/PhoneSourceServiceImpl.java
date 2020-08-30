package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.app.media.*;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dao.PhoneCodeMapper;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.entity.PhoneCode;
import com.xxl.robot.service.PhoneCodeService;
import com.xxl.robot.service.PhoneSourceService;
import com.xxl.robot.service.RobotInfoService;
import com.xxl.robot.tools.AdbTools;
import com.xxl.robot.tools.MouseTools;
import com.xxl.robot.tools.RandomTools;
import com.xxl.robot.tools.WindowTools;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;

import java.awt.*;
import java.util.List;
import java.util.Random;

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
	public void handleRobot1() {
		try {
			Robot robot = new Robot();
			robot.delay(6000);
			log.info("1.调取CMD窗口");
			try {
				//Runtime.getRuntime().exec("cmd /k start cmd.exe /k ");
			} catch (Exception e) {
			}

			log.info("2.打开app所在集合窗口");
			PhoneCodeDto dto2 = phoneCodeService.getUnique("phone001", "点点新闻", "window");
			String operateData2 = "adb shell input tap " + dto2.getPositionX() + " " + dto2.getPositionY();
			MouseTools.normalEvent(robot,operateData2);

			log.info("3.打开初始化app程序");
			robot.delay(2000);
			PhoneCodeDto dto3 = phoneCodeService.getUnique("phone001", "点点新闻", "init");
			String operateData3 = "adb shell input tap " + dto3.getPositionX() + " " + dto3.getPositionY();
			MouseTools.normalEvent(robot, operateData3);

			for(int i=0;i<30;i++){
				log.info("4.看新闻");
				//点击 tap
				PhoneCodeDto dto4 = phoneCodeService.getUnique("phone001", "点点新闻", "看新闻");
				String operateData4 = "adb shell input tap " + dto4.getPositionX() + " " + dto4.getPositionY();
				MouseTools.normalEvent(robot, operateData4);

				for(int y=0;y<12;y++) {
					log.info("5.滑动");
					//向下滑动
					String operateData6 = AdbTools.down();
					MouseTools.normalEvent(robot, operateData6);
					if(y>9){
						String operateData7 = AdbTools.up();
						MouseTools.normalEvent(robot, operateData7);
					}
					if(y==11){

					}
				}

			}


		}catch (Exception e){

		}
	}






	@Override
	public void handleRobot2() {
		PhoneCodeDto dto = new PhoneCodeDto();
		dto.setRobotCode("phone001");
		dto.setAppCode("抖音极速版");
		List<PhoneCodeDto> dtos = phoneCodeService.list(dto);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WindowTools.initWindowApp(robot,dtos);

    	A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.CHECK_IN,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.TREASURE,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_ADVERT,dtos);
		//A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.SLEEP,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_NOVELS,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WALK,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_VIDEOS,dtos);
	}


	@Override
	public void handleRobot3() {
		PhoneCodeDto dto = new PhoneCodeDto();
		dto.setRobotCode("phone001");
		dto.setAppCode("火山极速版");
		List<PhoneCodeDto> dtos = phoneCodeService.list(dto);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WindowTools.initWindowApp(robot,dtos);

		B视频火山.handle(robot,"phone001","火山极速版", AppConstants.WATCH_ADVERT,dtos);
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