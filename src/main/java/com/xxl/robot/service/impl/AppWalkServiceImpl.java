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

	/**
	 * todo 早上收取昨晚金币（签到，领取睡觉金币）
	 */
	@SneakyThrows
	@Override
	public void start() {
		Robot robot = new Robot();

		log.info("********************多多步**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","多多步");
		A步行多多.handle(robot,"phone001","多多步", AppConstants.CHECK_IN,dtos);

		log.info("********************步数赚**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","步数赚");
		A步行多多.handle(robot,"phone001","步数赚", AppConstants.CHECK_IN,dtos1);

		log.info("********************步步宝赚**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList("phone001","步步宝");
		A步行多多.handle(robot,"phone001","步步宝", AppConstants.CHECK_IN,dtos2);

		log.info("********************走走赚**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList("phone001","走走赚");
		A步行走走赚.handle(robot,"phone001","走走赚", AppConstants.CHECK_IN,dtos3);

		log.info("********************赚赚多**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","赚赚多");
		A步行走走赚.handle(robot,"phone001","赚赚多", AppConstants.CHECK_IN,dtos4);

		log.info("********************步多多**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList("phone001","步多多");
		A步行步多多.handle(robot,"phone001","步多多", AppConstants.CHECK_IN,dtos5);

		log.info("********************步步赚钱7**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList("phone001","步步赚钱7");
		A步行步多多.handle(robot,"phone001","步步赚钱7", AppConstants.CHECK_IN,dtos6);

		log.info("********************一起来走路**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList("phone001","一起来走路");
		A步行步多多.handle(robot,"phone001","一起来走路", AppConstants.CHECK_IN,dtos7);

	}

	/**
	 * todo 白天执行一次
	 */
	@SneakyThrows
	@Override
	public void  one() {
		Robot robot = new Robot();


	}

	/**
	 * todo 循环执行领金币(夺宝，领红包，开宝箱，看广告，抽奖)
	 */
	@SneakyThrows
	@Override
	public void circulate() {
		Robot robot = new Robot();
		log.info("********************多多步**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","多多步");
		A步行多多.handle(robot,"phone001","多多步", AppConstants.WATCH_ADVERT,dtos);
		A步行多多.handle(robot,"phone001","多多步", AppConstants.SCRATCH_CARD,dtos);

		log.info("********************步数赚**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","步数赚");
		A步行多多.handle(robot,"phone001","步数赚", AppConstants.WATCH_ADVERT,dtos1);
		A步行多多.handle(robot,"phone001","步数赚", AppConstants.WALK,dtos1);
		A步行多多.handle(robot,"phone001","步数赚", AppConstants.GIFT_MONEY,dtos1);

		log.info("********************步步宝赚**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList("phone001","步步宝");
		A步行多多.handle(robot,"phone001","步步宝", AppConstants.GIFT_MONEY,dtos2);
		A步行多多.handle(robot,"phone001","步步宝", AppConstants.TREASURE,dtos2);
		A步行多多.handle(robot,"phone001","步步宝", AppConstants.DRAW,dtos2);
		A步行多多.handle(robot,"phone001","步步宝", AppConstants.WALK,dtos2);

		log.info("********************走走赚**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList("phone001","走走赚");
		A步行走走赚.handle(robot,"phone001","步步宝", AppConstants.GIFT_MONEY,dtos3);
		A步行走走赚.handle(robot,"phone001","步步宝", AppConstants.TREASURE,dtos3);
		A步行走走赚.handle(robot,"phone001","步步宝", AppConstants.DRAW,dtos3);
		A步行走走赚.handle(robot,"phone001","步步宝", AppConstants.WALK,dtos3);
		A步行走走赚.handle(robot,"phone001","步步宝", AppConstants.WATCH_ADVERT,dtos3);
		A步行走走赚.handle(robot,"phone001","步步宝", AppConstants.DRINK_WATER,dtos3);

		log.info("********************赚赚多**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","赚赚多");
		A步行赚赚多.handle(robot,"phone001","赚赚多", AppConstants.WATCH_ADVERT,dtos4);
		A步行赚赚多.handle(robot,"phone001","赚赚多", AppConstants.SWEEPSTAKES,dtos4);
		A步行赚赚多.handle(robot,"phone001","赚赚多", AppConstants.WALK,dtos4);
		A步行赚赚多.handle(robot,"phone001","赚赚多", AppConstants.SCRATCH_CARD,dtos4);

		log.info("********************步多多**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList("phone001","步多多");
		A步行步多多.handle(robot,"phone001","步多多", AppConstants.WALK,dtos5);
		A步行步多多.handle(robot,"phone001","步多多", AppConstants.TREASURE,dtos5);
		A步行步多多.handle(robot,"phone001","步多多", AppConstants.DRINK_WATER,dtos5);


		log.info("********************步步赚钱7**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList("phone001","步步赚钱7");
		A步行步多多.handle(robot,"phone001","步步赚钱7", AppConstants.WALK,dtos6);
		A步行步多多.handle(robot,"phone001","步步赚钱7", AppConstants.GIFT_MONEY,dtos6);
		A步行步多多.handle(robot,"phone001","步步赚钱7", AppConstants.SWEEPSTAKES,dtos6);

		log.info("********************一起来走路**************************");
		List<PhoneCodeDto> dtos7 = phoneCodeService.getList("phone001","一起来走路");
		A步行步多多.handle(robot,"phone001","一起来走路", AppConstants.GIFT_MONEY,dtos7);
		A步行步多多.handle(robot,"phone001","一起来走路", AppConstants.WATCH_ADVERT,dtos7);
		A步行步多多.handle(robot,"phone001","一起来走路", AppConstants.SCRATCH_CARD,dtos7);
		A步行步多多.handle(robot,"phone001","一起来走路", AppConstants.WALK,dtos7);


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
		log.info("********************多多步**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","多多步");
		A步行多多.handle(robot,"phone001","多多步", AppConstants.WALK,dtos);

	}

	//*******************************************以下操作只能得取少量金币*******************************************************

	@SneakyThrows
	@Override
	public void watchMedia() {
		Robot robot = new Robot();




	}

	@SneakyThrows
	@Override
	public void watchNovels() {
		Robot robot = new Robot();


	}

	@SneakyThrows
	@Override
	public void watchNews() {
		Robot robot = new Robot();



	}

	@Override
	public void other() {

	}


}
