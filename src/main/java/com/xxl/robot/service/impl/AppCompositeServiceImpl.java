package com.xxl.robot.service.impl;

import com.xxl.robot.app.composite.*;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.AppCompositeService;
import com.xxl.robot.service.PhoneCodeService;
import com.xxl.robot.tools.RandomTools;
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
public class AppCompositeServiceImpl implements AppCompositeService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppCompositeServiceImpl.class);

	@Autowired
	private PhoneCodeService phoneCodeService;

//************************一种类型：签到********************************************************

	@Override
	public void clear(String robotCode) {

	}

	/**
	 * todo 1-签到
	 */
	@SneakyThrows
	@Override
	@Async
	public void start(String robotCode){
		Robot robot = new Robot();
 		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"抖音极速版");
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.CHECK_IN,dtos1);

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"火山极速版");
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.CHECK_IN,dtos2);

		log.info("********************快手极速版**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"快手极速版");
		A视频快手.handle(robot,robotCode,"快手极速版", AppConstants.CHECK_IN,dtos3);

		log.info("********************今日头条极速版**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"今日头条");
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.CHECK_IN,dtos4);

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"趣头条");
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.CHECK_IN,dtos5);

		log.info("********************搜狐资讯**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"搜狐资讯");
		A新闻搜狐资讯.handle(robot,robotCode,"搜狐资讯", AppConstants.CHECK_IN,dtos6);


		log.info("********************QQ阅读**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"QQ阅读");
		A小说QQ阅读.handle(robot,robotCode,"QQ阅读", AppConstants.CHECK_IN,dtos7);

		log.info("********************火山小说**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"火山小说");
		A小说火山.handle(robot,robotCode,"火山小说", AppConstants.CHECK_IN,dtos8);

		log.info("********************腾讯NOW直播**************************");
		List<PhoneCodeDto> dtos9 = phoneCodeService.getList(robotCode,"腾讯NOW直播");
		A视频腾讯NOW直播.handle(robot,robotCode,"腾讯NOW直播", AppConstants.CHECK_IN,dtos9);



	/*	log.info("********************搜狗浏览器**************************");
		List<PhoneCodeDto> dtos10 = phoneCodeService.getList(robotCode,"搜狗浏览器");
		A浏览器搜狗.handle(robot,robotCode,"搜狗浏览器", AppConstants.CHECK_IN,dtos10);*/

		log.info("********************拼多多**************************");
		List<PhoneCodeDto> dtos11 = phoneCodeService.getList(robotCode,"拼多多");
		A拼多多.handle(robot,robotCode,"拼多多",AppConstants.CHECK_IN,dtos11);



		log.info("********************书旗小说**************************");
		List<PhoneCodeDto> dtos13 = phoneCodeService.getList(robotCode,"书旗小说");
		B小说书旗.handle(robot,robotCode,"书旗小说",AppConstants.CHECK_IN,dtos13);

		log.info("********************番茄小说**************************");
		List<PhoneCodeDto> dtos14 = phoneCodeService.getList(robotCode,"番茄小说");
		B小说番茄.handle(robot,robotCode,"番茄小说", AppConstants.CHECK_IN,dtos14);

		log.info("********************奇热小说**************************");
		List<PhoneCodeDto> dtos15 = phoneCodeService.getList(robotCode,"奇热小说");
		B小说奇热.handle(robot,robotCode,"奇热小说", AppConstants.CHECK_IN,dtos15);


		log.info("********************晴象浏览器**************************");
		List<PhoneCodeDto> dtos16 = phoneCodeService.getList(robotCode,"晴象浏览器");
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.CHECK_IN,dtos16);


	}


//************************二种类型：分段（一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）*****************************************
	/***
	 * todo 2.1-早上8:00-9:00 （一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@SneakyThrows
	@Override
	@Async
	public void section1(String robotCode){
		Robot robot = new Robot();
		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"抖音极速版");
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.WATCH_NOVELS,dtos1);

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"火山极速版");
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.GROW,dtos2);

		log.info("********************今日头条**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"今日头条");
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.EAT,dtos4);//吃饭
		//A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.DRAW,dtos4);//抽奖

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"趣头条");
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.WATCH_NOVELS,dtos5);

		log.info("********************搜狐资讯**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"搜狐资讯");
		A新闻搜狐资讯.handle(robot,robotCode,"搜狐资讯", AppConstants.EAT,dtos6);

	}

	/**
	 * todo 2.2-中午11：00-12:00（吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@Async
	@SneakyThrows
	@Override
	public void  section2(String robotCode){
		Robot robot = new Robot();

		log.info("********************搜狐资讯**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"搜狐资讯");
		A新闻搜狐资讯.handle(robot,robotCode,"搜狐资讯", AppConstants.EAT,dtos6);
	}
	/**
	 * todo 2.3-下午19：00-20：00（吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@Async
	@SneakyThrows
	@Override
	public void  section3(String robotCode){
		Robot robot = new Robot();

		log.info("********************搜狐资讯**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"搜狐资讯");
		A新闻搜狐资讯.handle(robot,robotCode,"搜狐资讯", AppConstants.EAT,dtos6);
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

		log.info("********************今日头条**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"今日头条");
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.WALK,dtos4);
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.SLEEP,dtos4);

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"趣头条");
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.WALK,dtos5);
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.SLEEP,dtos5);

		log.info("********************搜狐资讯**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"搜狐资讯");
		A新闻搜狐资讯.handle(robot,robotCode,"搜狐资讯", AppConstants.EAT,dtos6);
		A新闻搜狐资讯.handle(robot,robotCode,"搜狐资讯", AppConstants.SHARE,dtos6);

	}

//*************************三种类型：循环(开宝箱，看广告，领红包,看视频，看新闻，看小说，刮卡，抽奖)********************************************************
	/**
	 * todo 3.1-循环收取金币大于200金币
	 */

	@SneakyThrows
	@Override
	public void circulate1(String robotCode){
		Robot robot = new Robot();
		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"抖音极速版");
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.WATCH_VIDEOS,dtos1);
		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.TREASURE,dtos1);
 		A视频抖音.handle(robot,robotCode,"抖音极速版", AppConstants.WATCH_ADVERT,dtos1);

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"火山极速版");
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.WATCH_VIDEOS,dtos2);
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.TREASURE,dtos2);
		A视频火山.handle(robot,robotCode,"火山极速版", AppConstants.WATCH_ADVERT,dtos2);

		log.info("********************快手极速版**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"快手极速版");
		A视频快手.handle(robot,robotCode,"快手极速版", AppConstants.WATCH_VIDEOS,dtos3);
		A视频快手.handle(robot,robotCode,"快手极速版", AppConstants.TREASURE,dtos3);
		A视频快手.handle(robot,robotCode,"快手极速版", AppConstants.WATCH_ADVERT,dtos3);
		A视频快手.handle(robot,robotCode,"快手极速版", AppConstants.DIRECT,dtos3);

		log.info("********************今日头条**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"今日头条");
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.WATCH_NEWS,dtos4);
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.TREASURE,dtos4);

	  	log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"趣头条");
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.WATCH_NEWS,dtos5);
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.TREASURE,dtos5);
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.WATCH_ADVERT,dtos5);
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.GIFT_MONEY,dtos5);


		log.info("********************QQ阅读**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"QQ阅读");
		A小说QQ阅读.handle(robot,robotCode,"QQ阅读", AppConstants.TREASURE,dtos7);
		A小说QQ阅读.handle(robot,robotCode,"QQ阅读", AppConstants.WATCH_ADVERT,dtos7);

		log.info("********************火山小说**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"火山小说");
		A小说火山.handle(robot,robotCode,"火山小说", AppConstants.GIFT_MONEY,dtos8);
		A小说火山.handle(robot,robotCode,"火山小说", AppConstants.WATCH_ADVERT,dtos8);
		A小说火山.handle(robot,robotCode,"火山小说", AppConstants.SCRATCH_CARD,dtos8);


	 	log.info("********************书旗小说**************************");
		List<PhoneCodeDto> dtos13 = phoneCodeService.getList(robotCode,"书旗小说");
		B小说书旗.handle(robot,robotCode,"书旗小说",AppConstants.WATCH_ADVERT,dtos13);

		log.info("********************番茄小说**************************");
		List<PhoneCodeDto> dtos14 = phoneCodeService.getList(robotCode,"番茄小说");
		B小说番茄.handle(robot,robotCode,"番茄小说", AppConstants.TREASURE,dtos14);
		B小说番茄.handle(robot,robotCode,"番茄小说", AppConstants.WATCH_ADVERT,dtos14);

 	    log.info("********************奇热小说**************************");
		List<PhoneCodeDto> dtos15 = phoneCodeService.getList(robotCode,"奇热小说");
 		B小说奇热.handle(robot,robotCode,"奇热小说", AppConstants.GIFT_MONEY,dtos15);
		B小说奇热.handle(robot,robotCode,"奇热小说", AppConstants.WATCH_ADVERT,dtos15);
		B小说奇热.handle(robot,robotCode,"奇热小说", AppConstants.SWEEPSTAKES,dtos15);

		log.info("********************晴象浏览器**************************");
		List<PhoneCodeDto> dtos16 = phoneCodeService.getList(robotCode,"晴象浏览器");
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.WATCH_VIDEOS,dtos16);
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.GIFT_MONEY,dtos16);
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.GIFT_MONEY,dtos16);
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.DRAW,dtos16);
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.SCRATCH_CARD,dtos16);

	}

	/**
	 * todo 3.2-循环收取金币小于200金币
	 */
	@Async
	@SneakyThrows
	@Override
	public void circulate2(String robotCode){
		Robot robot = new Robot();

		log.info("********************QQ阅读**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"QQ阅读");
		A小说QQ阅读.handle(robot,robotCode,"QQ阅读", AppConstants.WATCH_NOVELS,dtos7);

		log.info("********************火山小说**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"火山小说");
		A小说火山.handle(robot,robotCode,"火山小说", AppConstants.WATCH_NOVELS,dtos8);




		log.info("********************书旗小说**************************");
		List<PhoneCodeDto> dtos13 = phoneCodeService.getList(robotCode,"书旗小说");
		B小说书旗.handle(robot,robotCode,"书旗小说",AppConstants.WATCH_NOVELS,dtos13);

		log.info("********************番茄小说**************************");
		List<PhoneCodeDto> dtos14 = phoneCodeService.getList(robotCode,"番茄小说");
		B小说番茄.handle(robot,robotCode,"番茄小说", AppConstants.WATCH_NOVELS,dtos14);

		log.info("********************奇热小说**************************");
		List<PhoneCodeDto> dtos15 = phoneCodeService.getList(robotCode,"奇热小说");
		B小说奇热.handle(robot,robotCode,"奇热小说", AppConstants.WATCH_NOVELS,dtos15);


	}





}
