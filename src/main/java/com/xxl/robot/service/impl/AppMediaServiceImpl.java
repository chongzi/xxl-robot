package com.xxl.robot.service.impl;

import com.xxl.robot.app.browser.A快乐天气;
import com.xxl.robot.app.browser.A浏览器晴象;
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

		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"抖音极速版");
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.CHECK_IN,dtos);
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.SLEEP,dtos);

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"火山极速版");
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.CHECK_IN,dtos1);
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.SLEEP,dtos1);

		log.info("********************快手极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"快手极速版");
		A视频快手.handle(robot,robotCode,"快手极速版", AppConstants.CHECK_IN,dtos2);


		log.info("********************刷宝**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"刷宝");
		B视频刷宝.handle(robot,robotCode,"刷宝", AppConstants.CHECK_IN,dtos4);

		log.info("********************快逗**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"快逗");
		B视频快逗.handle(robot,robotCode,"快逗", AppConstants.CHECK_IN,dtos6);


		log.info("********************追看**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"追看");
		B视频追看.handle(robot,robotCode,"追看", AppConstants.CHECK_IN,dtos7);


		log.info("********************小吃货**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"小吃货");
		B视频小吃货.handle(robot,robotCode,"小吃货", AppConstants.CHECK_IN,dtos8);

		log.info("********************腾讯NOW直播**************************");
		List<PhoneCodeDto> dtos10 = phoneCodeService.getList(robotCode,"腾讯NOW直播");
		A视频腾讯NOW直播.handle(robot,robotCode,"腾讯NOW直播", AppConstants.CHECK_IN,dtos10);

		log.info("********************火火视频**************************");
		List<PhoneCodeDto> dtos11 = phoneCodeService.getList(robotCode,"火火视频");
		B视频火火.handle(robot,robotCode,"火火视频", AppConstants.CHECK_IN,dtos11);


		log.info("********************好看视频**************************");
		List<PhoneCodeDto> dtos12 = phoneCodeService.getList(robotCode,"好看视频");
		A视频好看.handle(robot,robotCode,"好看视频", AppConstants.CHECK_IN,dtos12);

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

		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"抖音极速版");
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.WATCH_NOVELS,dtos);
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.WATCH_VIDEOS,dtos);

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"火山极速版");
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.GROW,dtos1);
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.WATCH_VIDEOS,dtos1);

		log.info("********************快手极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"快手极速版");
		A视频快手.handle(robot,robotCode,"快手极速版", AppConstants.WATCH_VIDEOS,dtos2);

		log.info("********************微视**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"微视");
		A视频快手.handle(robot,robotCode,"微视", AppConstants.WATCH_VIDEOS,dtos3);

		log.info("********************刷宝**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"刷宝");
		B视频刷宝.handle(robot,robotCode,"刷宝", AppConstants.WATCH_VIDEOS,dtos4);

		log.info("********************快逗**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"快逗");
		B视频快逗.handle(robot,robotCode,"快逗", AppConstants.WATCH_VIDEOS,dtos6);

		log.info("********************追看**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"追看");
		B视频追看.handle(robot,robotCode,"追看", AppConstants.WATCH_VIDEOS,dtos7);
		B视频追看.handle(robot,robotCode,"追看", AppConstants.DIRECT,dtos7);

		log.info("********************小吃货**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"小吃货");
		B视频小吃货.handle(robot,robotCode,"小吃货", AppConstants.WATCH_VIDEOS,dtos8);

		log.info("********************火火视频**************************");
		List<PhoneCodeDto> dtos11 = phoneCodeService.getList(robotCode,"火火视频");
		B视频火火.handle(robot,robotCode,"火火视频", AppConstants.CHARGE,dtos11);
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

		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"抖音极速版");
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.WALK,dtos);
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.SLEEP,dtos);

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"火山极速版");
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.WALK,dtos1);
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.SLEEP,dtos1);

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
		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"抖音极速版");
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.WATCH_ADVERT,dtos);//观看广告
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.TREASURE,dtos);//夺宝


		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"火山极速版");
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.WATCH_ADVERT,dtos1);//观看广告
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.TREASURE,dtos1);//夺宝

		log.info("********************快手极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"快手极速版");
		A视频快手.handle(robot,robotCode,"快手极速版", AppConstants.WATCH_ADVERT,dtos2);


		log.info("********************刷宝**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"刷宝");
		B视频刷宝.handle(robot,robotCode,"刷宝", AppConstants.TREASURE,dtos4);

/*
		log.info("********************快逗**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"快逗");
		F视频快逗.handle(robot,robotCode,"快逗", AppConstants.WATCH_ADVERT,dtos5);
		F视频快逗.handle(robot,robotCode,"快逗", AppConstants.GIFT_MONEY,dtos5);
*/
/*

		log.info("********************追看**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"追看");
		G视频追看.handle(robot,robotCode,"追看", AppConstants.WATCH_ADVERT,dtos7);q
		G视频追看.handle(robot,robotCode,"追看", AppConstants.SWEEPSTAKES,dtos7);
		G视频追看.handle(robot,robotCode,"追看", AppConstants.TREASURE,dtos7);
		G视频追看.handle(robot,robotCode,"追看", AppConstants.GIFT_MONEY,dtos7);

		log.info("********************小吃货**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"小吃货");
		H视频小吃货.handle(robot,robotCode,"小吃货", AppConstants.WATCH_ADVERT,dtos8);
		H视频小吃货.handle(robot,robotCode,"小吃货", AppConstants.GIFT_MONEY,dtos8);
*/

		log.info("********************好看视频**************************");
		List<PhoneCodeDto> dtos12 = phoneCodeService.getList(robotCode,"好看视频");
		A视频好看.handle(robot,robotCode,"好看视频", AppConstants.TREASURE,dtos12);
		A视频好看.handle(robot,robotCode,"好看视频", AppConstants.WATCH_ADVERT,dtos12);


	}

	/**
	 * todo 3.2-循环收取金币小于200金币
	 */
	@Async
	@SneakyThrows
	@Override
	public void circulate2(String robotCode){
		Robot robot = new Robot();
		/*log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"抖音极速版");
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.WATCH_VIDEOS,dtos);

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"火山极速版");
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.WATCH_VIDEOS,dtos1);

		log.info("********************快手极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"快手极速版");
		A视频快手.handle(robot,robotCode,"快手极速版", AppConstants.WATCH_VIDEOS,dtos2);


		log.info("********************微视**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"微视");
		A视频快手.handle(robot,robotCode,"微视", AppConstants.WATCH_VIDEOS,dtos3);

		log.info("********************刷宝**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"刷宝");
		B视频刷宝.handle(robot,robotCode,"刷宝", AppConstants.WATCH_VIDEOS,dtos4);

		log.info("********************快逗**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"快逗");
		B视频快逗.handle(robot,robotCode,"快逗", AppConstants.WATCH_VIDEOS,dtos5);

		log.info("********************追看**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"追看");
		B视频追看.handle(robot,robotCode,"追看", AppConstants.WATCH_VIDEOS,dtos7);

		log.info("********************小吃货**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"小吃货");
		B视频小吃货.handle(robot,robotCode,"小吃货", AppConstants.WATCH_VIDEOS,dtos8);*/

		log.info("********************抖音火山**************************");
		List<PhoneCodeDto> dtos9 = phoneCodeService.getList(robotCode,"抖音火山");
		A视频抖音火山.handle(robot,robotCode,"抖音火山", AppConstants.WATCH_VIDEOS,dtos9);

	/*	log.info("********************火火视频**************************");
		List<PhoneCodeDto> dtos11 = phoneCodeService.getList(robotCode,"火火视频");
		B视频火火.handle(robot,robotCode,"火火视频", AppConstants.WATCH_VIDEOS,dtos11);
		B视频火火.handle(robot,robotCode,"火火视频", AppConstants.WATCH_VIDEOS_SMALL,dtos11);*/

	}



}
