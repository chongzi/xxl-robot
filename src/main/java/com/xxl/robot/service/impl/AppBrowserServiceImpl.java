package com.xxl.robot.service.impl;

import com.xxl.robot.app.browser.A快乐天气;
import com.xxl.robot.app.browser.A浏览器搜狗;
import com.xxl.robot.app.browser.A浏览器晴象;
import com.xxl.robot.app.browser.A综合红包赚不停;
import com.xxl.robot.app.novel.A小说奇热;
import com.xxl.robot.app.novel.A小说番茄;
import com.xxl.robot.app.novel.A小说米读;
import com.xxl.robot.app.walk.A步行多多;
import com.xxl.robot.app.walk.A步行步多多;
import com.xxl.robot.app.walk.A步行赚赚多;
import com.xxl.robot.app.walk.A步行走走赚;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.AppBrowserService;
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
public class AppBrowserServiceImpl implements AppBrowserService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppBrowserServiceImpl.class);

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

	/*	log.info("********************搜狗浏览器**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"搜狗浏览器");
		A浏览器搜狗.handle(robot,robotCode,"搜狗浏览器", AppConstants.CHECK_IN,dtos);
*/
		log.info("********************晴象浏览器**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"晴象浏览器");
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.CHECK_IN,dtos1);


		/*log.info("********************A小说米读**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"米读小说");
		A小说米读.handle(robot,robotCode,"米读小说", AppConstants.CHECK_IN,dtos3);


		log.info("********************番茄小说**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"番茄小说");
		A小说番茄.handle(robot,robotCode,"番茄小说", AppConstants.CHECK_IN,dtos4);


		log.info("********************奇热小说**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"奇热小说");
		A小说奇热.handle(robot,robotCode,"奇热小说", AppConstants.CHECK_IN,dtos5);*/

		log.info("********************快乐天气**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"快乐天气");
		A快乐天气.handle(robot,robotCode,"快乐天气", AppConstants.CHECK_IN,dtos6);

	}


//************************二种类型：分段（一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）*****************************************
	/***
	 * todo 2.1-早上7:00-8:00 （一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@SneakyThrows
	@Override
	@Async
	public void section1(String robotCode){
		Robot robot = new Robot();

		log.info("********************晴象浏览器**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"晴象浏览器");
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.OTHER_QINGXIANG_WATCH_VIDEOS,dtos1);
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

		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"晴象浏览器");
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.CHECK_IN,dtos1);
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

		//	List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"搜狗浏览器");
		/*A浏览器搜狗.handle(robot,robotCode,"搜狗浏览器", AppConstants.WATCH_NEWS,dtos);
		A浏览器搜狗.handle(robot,robotCode,"搜狗浏览器", AppConstants.SEARCH,dtos);*/


		log.info("********************晴象浏览器**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"晴象浏览器");
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.GIFT_MONEY,dtos1);
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.DRAW,dtos1);
		A浏览器晴象.handle(robot,robotCode,"晴象浏览器", AppConstants.SCRATCH_CARD,dtos1);

/*		log.info("********************红包赚不停**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"红包赚不停");
		A综合红包赚不停.handle(robot,robotCode,"红包赚不停", AppConstants.GIFT_MONEY,dtos2);
		A综合红包赚不停.handle(robot,robotCode,"红包赚不停", AppConstants.DRAW,dtos2);
		A综合红包赚不停.handle(robot,robotCode,"红包赚不停", AppConstants.SWEEPSTAKES,dtos2);*/

		/*log.info("********************番茄小说**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"番茄小说");
		A小说番茄.handle(robot,robotCode,"番茄小说", AppConstants.TREASURE,dtos4);
		A小说番茄.handle(robot,robotCode,"番茄小说", AppConstants.WATCH_ADVERT,dtos4);*/


	/*	log.info("********************快乐天气**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList(robotCode,"快乐天气");
		A快乐天气.handle(robot,robotCode,"快乐天气", AppConstants.GIFT_MONEY,dtos6);
		A快乐天气.handle(robot,robotCode,"快乐天气", AppConstants.DRAW,dtos6);
		A快乐天气.handle(robot,robotCode,"快乐天气", AppConstants.SCRATCH_CARD,dtos6);*/


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
