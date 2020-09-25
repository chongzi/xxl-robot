package com.xxl.robot.service.impl;

import com.xxl.robot.app.composite.A新闻今日头条;
import com.xxl.robot.app.composite.A新闻趣头条;
import com.xxl.robot.app.news.*;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.AppNewsService;
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
public class AppNewsServiceImpl implements AppNewsService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppNewsServiceImpl.class);

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



		log.info("********************点点新闻**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"点点");
		A新闻点点新闻.handle(robot,robotCode,"点点", AppConstants.CHECK_IN,dtos2);

		log.info("********************悦头条**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"悦头条");
		A新闻悦头条.handle(robot,robotCode,"悦头条", AppConstants.CHECK_IN,dtos3);

		log.info("********************忆头条**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"忆头条");
		A新闻忆头条.handle(robot,robotCode,"忆头条", AppConstants.CHECK_IN,dtos4);

		log.info("********************慧头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"慧头条");
		A新闻忆头条.handle(robot,robotCode,"慧头条", AppConstants.CHECK_IN,dtos5);

		log.info("********************蚂蚁看点**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"蚂蚁看点");
		A新闻蚂蚁看点.handle(robot,robotCode,"蚂蚁看点", AppConstants.CHECK_IN,dtos7);

		log.info("********************趣新闻**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"趣新闻");
		A新闻趣新闻.handle(robot,robotCode,"趣新闻", AppConstants.CHECK_IN,dtos8);

		log.info("********************快看点**************************");
		List<PhoneCodeDto> dtos9 = phoneCodeService.getList(robotCode,"快看点");
		A新闻快看点.handle(robot,robotCode,"快看点", AppConstants.CHECK_IN,dtos9);


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

		log.info("********************点点新闻**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"点点");
		A新闻点点新闻.handle(robot,robotCode,"点点", AppConstants.WATCH_NEWS,dtos2);

		log.info("********************悦头条**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"悦头条");
		A新闻悦头条.handle(robot,robotCode,"悦头条", AppConstants.WATCH_NEWS,dtos3);

		log.info("********************蚂蚁看点**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList(robotCode,"蚂蚁看点");
		A新闻蚂蚁看点.handle(robot,robotCode,"蚂蚁看点", AppConstants.GIFT_MONEY,dtos7);
		A新闻蚂蚁看点.handle(robot,robotCode,"蚂蚁看点", AppConstants.TREASURE,dtos7);
		A新闻蚂蚁看点.handle(robot,robotCode,"蚂蚁看点", AppConstants.WATCH_ADVERT,dtos7);
		A新闻蚂蚁看点.handle(robot,robotCode,"蚂蚁看点", AppConstants.DRAW,dtos7);

		log.info("********************快看点**************************");
		List<PhoneCodeDto> dtos9 = phoneCodeService.getList(robotCode,"快看点");
		A新闻快看点.handle(robot,robotCode,"快看点", AppConstants.WATCH_ADVERT,dtos9);
		A新闻快看点.handle(robot,robotCode,"快看点", AppConstants.DRAW,dtos9);
		A新闻快看点.handle(robot,robotCode,"快看点", AppConstants.GIFT_MONEY,dtos9);
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


	}

	/**
	 * todo 3.2-循环收取金币小于200金币
	 */
	@Async
	@SneakyThrows
	@Override
	public void circulate2(String robotCode){
		Robot robot = new Robot();


		log.info("********************忆头条**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"忆头条");
		A新闻忆头条.handle(robot,robotCode,"忆头条", AppConstants.WATCH_VIDEOS,dtos4);
		A新闻忆头条.handle(robot,robotCode,"忆头条", AppConstants.WATCH_NEWS,dtos4);

		log.info("********************慧头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"慧头条");
		A新闻慧头条.handle(robot,robotCode,"慧头条", AppConstants.WATCH_VIDEOS,dtos5);
		A新闻慧头条.handle(robot,robotCode,"慧头条", AppConstants.WATCH_NEWS,dtos5);

		log.info("********************点点新闻**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"点点");
		A新闻点点新闻.handle(robot,robotCode,"点点", AppConstants.WATCH_NEWS,dtos2);

		log.info("********************悦头条**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"悦头条");
		A新闻悦头条.handle(robot,robotCode,"悦头条", AppConstants.WATCH_NEWS,dtos3);


		log.info("********************趣新闻**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"趣新闻");
		A新闻趣新闻.handle(robot,robotCode,"趣新闻", AppConstants.WATCH_NEWS,dtos8);

	}


}
