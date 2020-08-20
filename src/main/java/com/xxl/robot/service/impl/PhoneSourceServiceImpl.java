package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.PhoneCodeMapper;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.entity.PhoneCode;
import com.xxl.robot.service.PhoneCodeService;
import com.xxl.robot.service.PhoneSourceService;
import com.xxl.robot.service.RobotInfoService;
import com.xxl.robot.tools.MouseTools;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;

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
	public void handleRobot1() {
		try {
			Robot robot = new Robot();

			log.info("0.调取CMD窗口");
			try {
				Runtime.getRuntime().exec("cmd /k start cmd.exe /k ");
			} catch (Exception e) {
			}

			log.info("1.进入adb shell连接手机命令");
			String operateData1 = "adb shell";
			MouseTools.normalEvent(robot,operateData1);

			log.info("2.打开app所在集合窗口");
			PhoneCodeDto dto2 = phoneCodeService.getUnique("phone001", "点点新闻", "window");
			String operateData2 = "input tap " + dto2.getPositionX() + " " + dto2.getPositionY();
			MouseTools.normalEvent(robot,operateData2);

			log.info("3.打开app程序");
			PhoneCodeDto dto3 = phoneCodeService.getUnique("phone001", "点点新闻", "初始化");
			String operateData3 = "input tap " + dto3.getPositionX() + " " + dto3.getPositionY();
			MouseTools.normalEvent(robot, operateData3);















		}catch (Exception e){

		}
	}


	public void sleep(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



















}