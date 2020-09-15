package com.xxl.robot.service.impl;

import com.xxl.robot.app.media.*;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.AppMediaService;
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
public class AppMediaServiceImpl implements AppMediaService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppMediaServiceImpl.class);

	@Autowired
	private PhoneCodeService phoneCodeService;

	/**
	 * todo 早上收取昨晚金币（签到，领取睡觉金币）
	 */
	@SneakyThrows
	@Override
	public void start() {
		Robot robot = new Robot();

		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","抖音极速版");
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.CHECK_IN,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.SLEEP,dtos);

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","火山极速版");
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.CHECK_IN,dtos1);
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.SLEEP,dtos1);

			log.info("********************快手极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList("phone001","快手极速版");
		A视频快手.handle(robot,"phone001","快手极速版", AppConstants.CHECK_IN,dtos2);


		log.info("********************刷宝**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","刷宝");
		A视频刷宝.handle(robot,"phone001","刷宝", AppConstants.CHECK_IN,dtos4);

		log.info("********************快逗**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList("phone001","快逗");
		F视频快逗.handle(robot,"phone001","快逗", AppConstants.CHECK_IN,dtos6);


			log.info("********************追看**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList("phone001","追看");
		G视频追看.handle(robot,"phone001","追看", AppConstants.CHECK_IN,dtos7);


		log.info("********************小吃货**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList("phone001","小吃货");
		H视频小吃货.handle(robot,"phone001","小吃货", AppConstants.CHECK_IN,dtos8);

	}

	/**
	 * todo 白天执行一次
	 */
	@SneakyThrows
	@Override
	public void  one() {
		Robot robot = new Robot();

	 	log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","抖音极速版");
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_NOVELS,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_VIDEOS,dtos);

 	log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","火山极速版");
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.GROW,dtos1);
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.WATCH_VIDEOS,dtos1);

	 log.info("********************快手极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList("phone001","快手极速版");
		A视频快手.handle(robot,"phone001","快手极速版", AppConstants.WATCH_VIDEOS,dtos2);

		log.info("********************微视**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList("phone001","微视");
		A视频快手.handle(robot,"phone001","微视", AppConstants.WATCH_VIDEOS,dtos3);

		log.info("********************刷宝**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","刷宝");
		A视频刷宝.handle(robot,"phone001","刷宝", AppConstants.WATCH_VIDEOS,dtos4);

		log.info("********************快逗**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList("phone001","快逗");
		F视频快逗.handle(robot,"phone001","快逗", AppConstants.WATCH_VIDEOS,dtos6);

		log.info("********************追看**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList("phone001","追看");
		G视频追看.handle(robot,"phone001","追看", AppConstants.WATCH_VIDEOS,dtos7);
		G视频追看.handle(robot,"phone001","追看", AppConstants.DIRECT,dtos7);

		log.info("********************小吃货**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList("phone001","小吃货");
		H视频小吃货.handle(robot,"phone001","小吃货", AppConstants.WATCH_VIDEOS,dtos8);


	}

	/**
	 * todo 循环执行领金币
	 */
	@SneakyThrows
	@Override
	public void circulate() {
		Robot robot = new Robot();
		log.info("********************抖音极速版**************************");
 		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","抖音极速版");
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.TREASURE,dtos);//夺宝
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_ADVERT,dtos);//观看广告

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","火山极速版");
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.TREASURE,dtos1);//夺宝
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.WATCH_ADVERT,dtos1);//观看广告

		log.info("********************快手极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList("phone001","快手极速版");
		A视频快手.handle(robot,"phone001","快手极速版", AppConstants.WATCH_ADVERT,dtos2);


 	log.info("********************刷宝**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","刷宝");
		A视频刷宝.handle(robot,"phone001","刷宝", AppConstants.TREASURE,dtos4);

/*
		log.info("********************快逗**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList("phone001","快逗");
		F视频快逗.handle(robot,"phone001","快逗", AppConstants.WATCH_ADVERT,dtos5);
		F视频快逗.handle(robot,"phone001","快逗", AppConstants.GIFT_MONEY,dtos5);
*/
/*

		log.info("********************追看**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList("phone001","追看");
		G视频追看.handle(robot,"phone001","追看", AppConstants.WATCH_ADVERT,dtos7);
		G视频追看.handle(robot,"phone001","追看", AppConstants.SWEEPSTAKES,dtos7);
		G视频追看.handle(robot,"phone001","追看", AppConstants.TREASURE,dtos7);
		G视频追看.handle(robot,"phone001","追看", AppConstants.GIFT_MONEY,dtos7);

		log.info("********************小吃货**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList("phone001","小吃货");
		H视频小吃货.handle(robot,"phone001","小吃货", AppConstants.WATCH_ADVERT,dtos8);
		H视频小吃货.handle(robot,"phone001","小吃货", AppConstants.GIFT_MONEY,dtos8);
*/

	}

	/***
	 * todo 玩游戏
	 */
	@Override
	public void playGame() {

	}

	/***
	 * todo 晚上收取白天金币
	 */
	@SneakyThrows
	@Override
	public void end() {
		Robot robot = new Robot();

		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","抖音极速版");
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WALK,dtos);
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.SLEEP,dtos);

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","火山极速版");
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.WALK,dtos1);
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.SLEEP,dtos1);
	}


//*******************************************以下操作只能得取少量金币*******************************************************

	/**
	 * todo 看视频
	 */
	@SneakyThrows
	@Override
	public void watchMedia() {
		Robot robot = new Robot();
		log.info("********************抖音极速版**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","抖音极速版");
		A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_VIDEOS,dtos);

		log.info("********************火山极速版**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","火山极速版");
		A视频火山.handle(robot,"phone001","火山极速版", AppConstants.WATCH_VIDEOS,dtos1);

		log.info("********************快手极速版**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList("phone001","快手极速版");
		A视频快手.handle(robot,"phone001","快手极速版", AppConstants.WATCH_VIDEOS,dtos2);

		log.info("********************微视**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList("phone001","微视");
		A视频快手.handle(robot,"phone001","微视", AppConstants.WATCH_VIDEOS,dtos3);

		log.info("********************刷宝**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","刷宝");
		A视频刷宝.handle(robot,"phone001","刷宝", AppConstants.WATCH_VIDEOS,dtos4);

		log.info("********************快逗**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList("phone001","快逗");
		F视频快逗.handle(robot,"phone001","快逗", AppConstants.WATCH_VIDEOS,dtos5);

		log.info("********************追看**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList("phone001","追看");
		G视频追看.handle(robot,"phone001","追看", AppConstants.WATCH_VIDEOS,dtos7);

		log.info("********************小吃货**************************");
		List<PhoneCodeDto> dtos8 = phoneCodeService.getList("phone001","小吃货");
		H视频小吃货.handle(robot,"phone001","小吃货", AppConstants.WATCH_VIDEOS,dtos8);
	}

	/**
	 * todo 看小说
	 */
	@Override
	public void watchNovels() {

	}

	/**
	 * todo 看新闻
	 */
	@Override
	public void watchNews() {

	}

	/**
	 * todo 其它
	 */
	@Override
	public void other() {

	}



}
