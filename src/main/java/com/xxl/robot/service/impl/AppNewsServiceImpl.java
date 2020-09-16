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

	/**
	 * todo 早上收取昨晚金币（签到，领取睡觉金币）
	 */
	@SneakyThrows
	@Override
	public void start() {
		Robot robot = new Robot();

		log.info("********************今日头条极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","今日头条");
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.CHECK_IN,dtos);
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.SLEEP,dtos);

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.CHECK_IN,dtos1);
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.SLEEP,dtos1);

		log.info("********************点点新闻**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList("phone001","点点");
		A新闻点点新闻.handle(robot,"phone001","点点", AppConstants.CHECK_IN,dtos2);

		log.info("********************悦头条**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList("phone001","悦头条");
		A新闻悦头条.handle(robot,"phone001","悦头条", AppConstants.CHECK_IN,dtos3);

		log.info("********************忆头条**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","忆头条");
		A新闻忆头条.handle(robot,"phone001","忆头条", AppConstants.CHECK_IN,dtos4);

		log.info("********************慧头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList("phone001","慧头条");
		A新闻忆头条.handle(robot,"phone001","慧头条", AppConstants.CHECK_IN,dtos5);

		log.info("********************蚂蚁看点**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList("phone001","蚂蚁看点");
		A新闻蚂蚁看点.handle(robot,"phone001","蚂蚁看点", AppConstants.CHECK_IN,dtos7);

		log.info("********************趣新闻**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList("phone001","趣新闻");
		A新闻趣新闻.handle(robot,"phone001","趣新闻", AppConstants.CHECK_IN,dtos8);

		log.info("********************快看点**************************");
		List<PhoneCodeDto> dtos9 = phoneCodeService.getList("phone001","快看点");
		A新闻快看点.handle(robot,"phone001","快看点", AppConstants.CHECK_IN,dtos9);


	}

	/**
	 * todo 白天执行一次
	 */
	@SneakyThrows
	@Override
	public void  section() {
		Robot robot = new Robot();

	 	log.info("********************今日头条**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","今日头条");
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.EAT,dtos);//吃饭
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.DRAW,dtos);//抽奖

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WATCH_NOVELS,dtos1);

		log.info("********************点点新闻**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList("phone001","点点");
		A新闻点点新闻.handle(robot,"phone001","点点", AppConstants.WATCH_NEWS,dtos2);

		log.info("********************悦头条**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList("phone001","悦头条");
		A新闻悦头条.handle(robot,"phone001","悦头条", AppConstants.WATCH_NEWS,dtos3);

		log.info("********************蚂蚁看点**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList("phone001","蚂蚁看点");
		A新闻蚂蚁看点.handle(robot,"phone001","蚂蚁看点", AppConstants.GIFT_MONEY,dtos7);
		A新闻蚂蚁看点.handle(robot,"phone001","蚂蚁看点", AppConstants.TREASURE,dtos7);
		A新闻蚂蚁看点.handle(robot,"phone001","蚂蚁看点", AppConstants.WATCH_ADVERT,dtos7);
		A新闻蚂蚁看点.handle(robot,"phone001","蚂蚁看点", AppConstants.DRAW,dtos7);

		log.info("********************快看点**************************");
		List<PhoneCodeDto> dtos9 = phoneCodeService.getList("phone001","快看点");
		A新闻快看点.handle(robot,"phone001","快看点", AppConstants.WATCH_ADVERT,dtos9);
		A新闻快看点.handle(robot,"phone001","快看点", AppConstants.DRAW,dtos9);
		A新闻快看点.handle(robot,"phone001","快看点", AppConstants.GIFT_MONEY,dtos9);

	}

	/**
	 * todo 循环执行领金币(夺宝，领红包，开宝箱，看广告，抽奖)
	 */
	@SneakyThrows
	@Override
	public void circulate() {
		Robot robot = new Robot();
		log.info("********************今日头条**************************");
 		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","今日头条");
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.TREASURE,dtos);

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.TREASURE,dtos1);
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WATCH_ADVERT,dtos1);
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.GIFT_MONEY,dtos1);

		log.info("********************慧头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList("phone001","慧头条");
		A新闻忆头条.handle(robot,"phone001","慧头条", AppConstants.TREASURE,dtos5);
		A新闻忆头条.handle(robot,"phone001","慧头条", AppConstants.GIFT_MONEY,dtos5);


		log.info("********************蚂蚁看点**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList("phone001","蚂蚁看点");
		A新闻蚂蚁看点.handle(robot,"phone001","蚂蚁看点", AppConstants.TREASURE,dtos7);
		A新闻蚂蚁看点.handle(robot,"phone001","蚂蚁看点", AppConstants.WATCH_ADVERT,dtos7);


		log.info("********************快看点**************************");
		List<PhoneCodeDto> dtos9 = phoneCodeService.getList("phone001","快看点");
		A新闻快看点.handle(robot,"phone001","快看点", AppConstants.WATCH_ADVERT,dtos9);
		A新闻快看点.handle(robot,"phone001","快看点", AppConstants.GIFT_MONEY,dtos9);

	}


	/***
	 * todo 晚上收取白天金币
	 */
	@SneakyThrows
	@Override
	public void end() {
		Robot robot = new Robot();

		log.info("********************今日头条**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","今日头条");
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.WALK,dtos);
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.SLEEP,dtos);

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WALK,dtos1);
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.SLEEP,dtos1);


	}

	//*******************************************以下操作只能得取少量金币*******************************************************

	/***
	 * todo 玩游戏（少量金币，适合网络开启）
	 */
	public void playGame(){};


	@SneakyThrows
	@Override
	public void watchMedia() {
		Robot robot = new Robot();

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WATCH_VIDEOS,dtos1);

		log.info("********************忆头条**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","忆头条");
		A新闻忆头条.handle(robot,"phone001","忆头条", AppConstants.WATCH_VIDEOS,dtos4);

		log.info("********************慧头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList("phone001","慧头条");
		A新闻慧头条.handle(robot,"phone001","慧头条", AppConstants.WATCH_VIDEOS,dtos5);


	}


	@SneakyThrows
	@Override
	public void watchNews() {
		Robot robot = new Robot();

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WATCH_NEWS,dtos1);

		log.info("********************点点新闻**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList("phone001","点点");
		A新闻点点新闻.handle(robot,"phone001","点点", AppConstants.WATCH_NEWS,dtos2);

		log.info("********************悦头条**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList("phone001","悦头条");
		A新闻悦头条.handle(robot,"phone001","悦头条", AppConstants.WATCH_NEWS,dtos3);

		log.info("********************忆头条**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","忆头条");
		A新闻忆头条.handle(robot,"phone001","忆头条", AppConstants.WATCH_NEWS,dtos4);

		log.info("********************慧头条**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList("phone001","慧头条");
		A新闻慧头条.handle(robot,"phone001","慧头条", AppConstants.WATCH_NEWS,dtos5);

		log.info("********************趣新闻**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList("phone001","趣新闻");
		A新闻趣新闻.handle(robot,"phone001","趣新闻", AppConstants.WATCH_NEWS,dtos8);

	}

	@Override
	public void other() {

	}


}
