package com.xxl.robot.service.impl;

import com.xxl.robot.app.composite.*;
import com.xxl.robot.app.media.*;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.AppMediaService;
import com.xxl.robot.service.PhoneCodeService;
import lombok.SneakyThrows;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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

//************************一种类型：签到********************************************************
	/**
	 * todo 1-签到
	 */
	@SneakyThrows
	@Override
	@Async
	public void start(String robotCode){
		Robot robot = new Robot();

		log.info("********************刷宝**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"刷宝");
		A视频刷宝.handle(robot,robotCode,"刷宝", AppConstants.CHECK_IN,dtos4);

		log.info("********************快逗**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"快逗");
		A视频快逗.handle(robot,robotCode,"快逗", AppConstants.CHECK_IN,dtos6);


		log.info("********************追看**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"追看");
		A视频追看.handle(robot,robotCode,"追看", AppConstants.CHECK_IN,dtos7);


		log.info("********************小吃货**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"小吃货");
		A视频小吃货.handle(robot,robotCode,"小吃货", AppConstants.CHECK_IN,dtos8);



		log.info("********************火火视频**************************");
		List<PhoneCodeDto> dtos11 = phoneCodeService.getList(robotCode,"火火视频");
		A视频火火.handle(robot,robotCode,"火火视频", AppConstants.CHECK_IN,dtos11);




	}


//************************二种类型：分段（一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）*****************************************
	/***
	 * todo 2.1-早上8:00-9:00  （一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@SneakyThrows
	@Override
	@Async
	public void section1(String robotCode){
		Robot robot = new Robot();

		log.info("********************火火视频**************************");
		List<PhoneCodeDto> dtos11 = phoneCodeService.getList(robotCode,"火火视频");
		A视频火火.handle(robot,robotCode,"火火视频", AppConstants.CHARGE,dtos11);
	}

	/**
	 * todo 2.2-中午11：00-12:00（吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@Async
	@SneakyThrows
	@Override
	public void  section2(String robotCode){

	}
	/**
	 * todo 2.3-下午19：00-20：00（吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@Async
	@SneakyThrows
	@Override
	public void  section3(String robotCode){

	}
	/**
	 * todo 2.4-晚上23：00-24：00（睡觉打卡，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）
	 */
	@SneakyThrows
	@Override
	@Async
	public void  section4(String robotCode){
		Robot robot = new Robot();


	}

//*************************三种类型：循环(开宝箱，看广告，领红包,看视频，看新闻，看小说，刮卡，抽奖)********************************************************
	/**
	 * todo 3.1-循环收取金币大于200金币
	 */
	@Async
	@SneakyThrows
	@Override
	public void circulate1(String robotCode){
		Robot robot = new Robot();
		log.info("********************刷宝**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"刷宝");
		A视频刷宝.handle(robot,robotCode,"刷宝", AppConstants.WATCH_ADVERT,dtos4);
		A视频刷宝.handle(robot,robotCode,"刷宝", AppConstants.TREASURE,dtos4);


		log.info("********************快逗**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"快逗");
		A视频快逗.handle(robot,robotCode,"快逗", AppConstants.WATCH_VIDEOS,dtos5);
		A视频快逗.handle(robot,robotCode,"快逗", AppConstants.WATCH_ADVERT,dtos5);


 		log.info("********************追看**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"追看");
 		A视频追看.handle(robot,robotCode,"追看", AppConstants.WATCH_VIDEOS,dtos7);
		A视频追看.handle(robot,robotCode,"追看", AppConstants.WATCH_ADVERT,dtos7);
		A视频追看.handle(robot,robotCode,"追看", AppConstants.SWEEPSTAKES,dtos7);
		A视频追看.handle(robot,robotCode,"追看", AppConstants.TREASURE,dtos7);
		A视频追看.handle(robot,robotCode,"追看", AppConstants.SCRATCH_CARD,dtos7);

		log.info("********************小吃货**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"小吃货");
		A视频小吃货.handle(robot,robotCode,"小吃货", AppConstants.WATCH_VIDEOS,dtos8);
		A视频小吃货.handle(robot,robotCode,"小吃货", AppConstants.WATCH_ADVERT,dtos8);

		log.info("********************微视**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"微视");
		A视频微视.handle(robot,robotCode,"微视", AppConstants.WATCH_VIDEOS,dtos3);

 		log.info("********************火火视频**************************");
		List<PhoneCodeDto> dtos9 = phoneCodeService.getList(robotCode,"火火视频");
		A视频火火.handle(robot,robotCode,"火火视频", AppConstants.WATCH_VIDEOS,dtos9);

	}

	/**
	 * todo 3.2-循环收取金币小于200金币
	 */
	@Async
	@SneakyThrows
	@Override
	public void circulate2(String robotCode){


	}



}
