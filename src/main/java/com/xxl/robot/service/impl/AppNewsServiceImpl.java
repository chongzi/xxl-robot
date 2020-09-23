package com.xxl.robot.service.impl;

import com.xxl.robot.app.media.*;
import com.xxl.robot.app.news.*;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.AppDto;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.AppMediaService;
import com.xxl.robot.service.AppNewsService;
import com.xxl.robot.service.PhoneCodeService;
import com.xxl.robot.tools.AppUserTools;
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


//**********************一种类型：签到，睡觉，步行，一次性，分享********************************************************
	/**
	 * todo 早上收取昨晚金币（签到，领取睡觉金币）
	 */
	@SneakyThrows
	@Override
	@Async
	public void start(String robotCode) {
		Robot robot = new Robot();

		log.info("********************今日头条极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"今日头条");
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.CHECK_IN,dtos);
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.SLEEP,dtos);

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"趣头条");
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.CHECK_IN,dtos1);
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.SLEEP,dtos1);

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
	/***
	 * todo 晚上收取白天金币
	 */
	@SneakyThrows
	@Override
	@Async
	public void end(String robotCode) {
		Robot robot = new Robot();

		log.info("********************今日头条**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"今日头条");
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.WALK,dtos);
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.SLEEP,dtos);

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"趣头条");
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.WALK,dtos1);
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.SLEEP,dtos1);


	}



	//************************二种类型：喝水，打卡，种菜，充电，吃饭********************************************************
	/**
	 * todo 白天执行一次
	 */
	@SneakyThrows
	@Override
	@Async
	public void  section(String robotCode) {
		Robot robot = new Robot();

	 	log.info("********************今日头条**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"今日头条");
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.EAT,dtos);//吃饭
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.DRAW,dtos);//抽奖

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"趣头条");
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.WATCH_NOVELS,dtos1);

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

//*************************三种类型：开宝箱，看广告，领红包********************************************************
	/**
	 * todo 循环执行领金币(夺宝，领红包，开宝箱，看广告，抽奖)
	 */
	@SneakyThrows
	@Override
	@Async
	public void circulate(String robotCode) {
		Robot robot = new Robot();
		log.info("********************今日头条**************************");
 		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"今日头条");
		A新闻今日头条.handle(robot,robotCode,"今日头条", AppConstants.TREASURE,dtos);

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"趣头条");
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.TREASURE,dtos1);
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.WATCH_ADVERT,dtos1);
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.GIFT_MONEY,dtos1);

	}




//************************四种类型：玩游戏********************************************************
	/***
	 * todo 玩游戏（少量金币，适合网络开启）
	 */
	@Async
	public void playGame(String robotCode){};


	@SneakyThrows
	@Override
	@Async
	public void watchMedia(String robotCode) {
		Robot robot = new Robot();

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"趣头条");
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.WATCH_VIDEOS,dtos1);

		log.info("********************忆头条**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"忆头条");
		A新闻忆头条.handle(robot,robotCode,"忆头条", AppConstants.WATCH_VIDEOS,dtos4);

		log.info("********************慧头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"慧头条");
		A新闻慧头条.handle(robot,robotCode,"慧头条", AppConstants.WATCH_VIDEOS,dtos5);


	}

//************************五种类型：看视频，看新闻，看小说********************************************************

	@SneakyThrows
	@Override
	@Async
	public void watchNews(String robotCode) {
		Robot robot = new Robot();

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList(robotCode,"趣头条");
		A新闻趣头条.handle(robot,robotCode,"趣头条", AppConstants.WATCH_NEWS,dtos1);

		log.info("********************点点新闻**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList(robotCode,"点点");
		A新闻点点新闻.handle(robot,robotCode,"点点", AppConstants.WATCH_NEWS,dtos2);

		log.info("********************悦头条**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList(robotCode,"悦头条");
		A新闻悦头条.handle(robot,robotCode,"悦头条", AppConstants.WATCH_NEWS,dtos3);

		log.info("********************忆头条**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList(robotCode,"忆头条");
		A新闻忆头条.handle(robot,robotCode,"忆头条", AppConstants.WATCH_NEWS,dtos4);

		log.info("********************慧头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList(robotCode,"慧头条");
		A新闻慧头条.handle(robot,robotCode,"慧头条", AppConstants.WATCH_NEWS,dtos5);

		log.info("********************趣新闻**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList(robotCode,"趣新闻");
		A新闻趣新闻.handle(robot,robotCode,"趣新闻", AppConstants.WATCH_NEWS,dtos8);

	}

	@Override
	@Async
	public void watchNovel(String robotCode) {

	}


//************************六种类型： 抽奖 刮卡********************************************************
	@Override
	@Async
	public void other(String robotCode) {

	}


}
