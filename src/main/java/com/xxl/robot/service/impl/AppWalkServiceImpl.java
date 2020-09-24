package com.xxl.robot.service.impl;

import com.xxl.robot.app.walk.A步行多多;
import com.xxl.robot.app.walk.A步行步多多;
import com.xxl.robot.app.walk.A步行赚赚多;
import com.xxl.robot.app.walk.A步行走走赚;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.AppWalkService;
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
public class AppWalkServiceImpl implements AppWalkService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppWalkServiceImpl.class);

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

		log.info("********************多多步**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"多多步");
		A步行多多.handle(robot,robotCode,"多多步", AppConstants.CHECK_IN,dtos);

		log.info("********************步数赚**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"步数赚");
		A步行多多.handle(robot,robotCode,"步数赚", AppConstants.CHECK_IN,dtos1);
/*

		log.info("********************步步宝赚**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"步步宝");
		A步行多多.handle(robot,robotCode,"步步宝", AppConstants.CHECK_IN,dtos2);

		log.info("********************走走赚**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"走走赚");
		A步行走走赚.handle(robot,robotCode,"走走赚", AppConstants.CHECK_IN,dtos3);

		log.info("********************赚赚多**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"赚赚多");
		A步行走走赚.handle(robot,robotCode,"赚赚多", AppConstants.CHECK_IN,dtos4);

		log.info("********************步多多**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"步多多");
		A步行步多多.handle(robot,robotCode,"步多多", AppConstants.CHECK_IN,dtos5);

		log.info("********************步步赚钱7**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"步步赚钱7");
		A步行步多多.handle(robot,robotCode,"步步赚钱7", AppConstants.CHECK_IN,dtos6);
*/

		log.info("********************一起来走路**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"一起来走路");
		A步行步多多.handle(robot,robotCode,"一起来走路", AppConstants.CHECK_IN,dtos7);

	}


//************************二种类型：分段（一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）*****************************************
	/***
	 * todo 2.1-早上8:00-9:00  （一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@SneakyThrows
	@Override
	@Async
	public void section1(String robotCode){

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
		log.info("********************多多步**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"多多步");
		A步行多多.handle(robot,robotCode,"多多步", AppConstants.WALK,dtos);

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
		log.info("********************多多步**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"多多步");
		A步行多多.handle(robot,robotCode,"多多步", AppConstants.WATCH_ADVERT,dtos);
		A步行多多.handle(robot,robotCode,"多多步", AppConstants.GIFT_MONEY,dtos);


		log.info("********************步数赚**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"步数赚");
		A步行多多.handle(robot,robotCode,"步数赚", AppConstants.WATCH_ADVERT,dtos1);
		A步行多多.handle(robot,robotCode,"步数赚", AppConstants.GIFT_MONEY,dtos1);

	/*	log.info("********************步步宝赚**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"步步宝");
		A步行多多.handle(robot,robotCode,"步步宝", AppConstants.GIFT_MONEY,dtos2);
		A步行多多.handle(robot,robotCode,"步步宝", AppConstants.TREASURE,dtos2);


		log.info("********************走走赚**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"走走赚");
		A步行走走赚.handle(robot,robotCode,"步步宝", AppConstants.TREASURE,dtos3);
		A步行走走赚.handle(robot,robotCode,"步步宝", AppConstants.WATCH_ADVERT,dtos3);
		A步行走走赚.handle(robot,robotCode,"步步宝", AppConstants.GIFT_MONEY,dtos3);

		A步行走走赚.handle(robot,robotCode,"步步宝", AppConstants.DRINK_WATER,dtos3);

		log.info("********************赚赚多**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"赚赚多");
		A步行赚赚多.handle(robot,robotCode,"赚赚多", AppConstants.WATCH_ADVERT,dtos4);

		log.info("********************步多多**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"步多多");
		A步行步多多.handle(robot,robotCode,"步多多", AppConstants.TREASURE,dtos5);


		log.info("********************步步赚钱7**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"步步赚钱7");
		A步行步多多.handle(robot,robotCode,"步步赚钱7", AppConstants.GIFT_MONEY,dtos6);*/

		log.info("********************一起来走路**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"一起来走路");
		A步行步多多.handle(robot,robotCode,"一起来走路", AppConstants.WATCH_ADVERT,dtos7);
		A步行步多多.handle(robot,robotCode,"一起来走路", AppConstants.GIFT_MONEY,dtos7);



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
