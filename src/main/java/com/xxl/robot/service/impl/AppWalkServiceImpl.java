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

//**********************一种类型：签到，睡觉，步行，一次性，分享********************************************************
	/**
	 * todo 早上收取昨晚金币（签到，领取睡觉金币）
	 */
	@SneakyThrows
	@Override
	public void start(String robotCode) {
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

	/***
	 * todo 晚上收取白天金币
	 */
	@SneakyThrows
	@Override
	public void end(String robotCode) {
		Robot robot = new Robot();
		log.info("********************多多步**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"多多步");
		A步行多多.handle(robot,robotCode,"多多步", AppConstants.WALK,dtos);

	}

//************************二种类型：喝水，打卡，种菜，充电，吃饭********************************************************
	/**
	 * todo 白天执行一次
	 */
	@SneakyThrows
	@Override
	public void  section(String robotCode) {
		Robot robot = new Robot();


	}


//*************************三种类型：开宝箱，看广告，领红包********************************************************
	/**
	 * todo 循环执行领金币(夺宝，领红包，开宝箱，看广告，抽奖)
	 */
	@SneakyThrows
	@Override
	public void circulate(String robotCode) {
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


//************************四种类型：玩游戏********************************************************
	/***
	 * todo 玩游戏
	 */
	@Override
	public void playGame(String robotCode) {

	}

//************************五种类型：看视频，看新闻，看小说********************************************************
	@SneakyThrows
	@Override
	public void watchMedia(String robotCode) {
		Robot robot = new Robot();




	}

	@SneakyThrows
	@Override
	public void watchNews(String robotCode) {
		Robot robot = new Robot();



	}

	@Override
	public void watchNovel(String robotCode) {

	}

//************************六种类型： 抽奖 刮卡********************************************************
	@Override
	public void other(String robotCode) {

	}


}
