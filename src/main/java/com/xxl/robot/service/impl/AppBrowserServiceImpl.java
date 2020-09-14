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

	/**
	 * todo 早上收取昨晚金币（签到，领取睡觉金币）
	 */
	@SneakyThrows
	@Override
	public void start() {
		Robot robot = new Robot();

		log.info("********************搜狗浏览器**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","搜狗浏览器");
		A浏览器搜狗.handle(robot,"phone001","搜狗浏览器", AppConstants.CHECK_IN,dtos);

		log.info("********************晴象浏览器**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","晴象浏览器");
		A浏览器晴象.handle(robot,"phone001","晴象浏览器", AppConstants.CHECK_IN,dtos1);


		log.info("********************A小说米读**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList("phone001","米读小说");
		A小说米读.handle(robot,"phone001","米读小说", AppConstants.CHECK_IN,dtos3);


		log.info("********************番茄小说**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","番茄小说");
		A小说番茄.handle(robot,"phone001","番茄小说", AppConstants.CHECK_IN,dtos4);


		log.info("********************奇热小说**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList("phone001","奇热小说");
		A小说奇热.handle(robot,"phone001","奇热小说", AppConstants.CHECK_IN,dtos5);

		log.info("********************快乐天气**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList("phone001","快乐天气");
		A快乐天气.handle(robot,"phone001","快乐天气", AppConstants.CHECK_IN,dtos6);

	}

	/**
	 * todo 白天执行一次
	 */
	@SneakyThrows
	@Override
	public void  one() {
		Robot robot = new Robot();

		log.info("********************晴象浏览器**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","晴象浏览器");
		A浏览器晴象.handle(robot,"phone001","晴象浏览器", AppConstants.OTHER_QINGXIANG_WATCH_VIDEOS,dtos1);

	}

	/**
	 * todo 循环执行领金币(夺宝，领红包，开宝箱，看广告，抽奖)
	 */
	@SneakyThrows
	@Override
	public void circulate() {
		Robot robot = new Robot();

		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","搜狗浏览器");
		/*A浏览器搜狗.handle(robot,"phone001","搜狗浏览器", AppConstants.WATCH_NEWS,dtos);
		A浏览器搜狗.handle(robot,"phone001","搜狗浏览器", AppConstants.SEARCH,dtos);*/


 		log.info("********************晴象浏览器**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","晴象浏览器");
 		A浏览器晴象.handle(robot,"phone001","晴象浏览器", AppConstants.DRAW,dtos1);
		A浏览器晴象.handle(robot,"phone001","晴象浏览器", AppConstants.SCRATCH_CARD,dtos1);
		A浏览器晴象.handle(robot,"phone001","晴象浏览器", AppConstants.GIFT_MONEY,dtos1);

		log.info("********************红包赚不停**************************");
		List<PhoneCodeDto> dtos2 = phoneCodeService.getList("phone001","红包赚不停");
		A综合红包赚不停.handle(robot,"phone001","红包赚不停", AppConstants.GIFT_MONEY,dtos2);
		A综合红包赚不停.handle(robot,"phone001","红包赚不停", AppConstants.DRAW,dtos2);
		A综合红包赚不停.handle(robot,"phone001","红包赚不停", AppConstants.SWEEPSTAKES,dtos2);

		log.info("********************A小说米读**************************");
		List<PhoneCodeDto> dtos3 = phoneCodeService.getList("phone001","米读小说");
		A小说米读.handle(robot,"phone001","米读小说", AppConstants.WATCH_NOVELS,dtos3);

		log.info("********************番茄小说**************************");
		List<PhoneCodeDto> dtos4 = phoneCodeService.getList("phone001","番茄小说");
		A小说番茄.handle(robot,"phone001","番茄小说", AppConstants.WATCH_NOVELS,dtos4);
		A小说番茄.handle(robot,"phone001","番茄小说", AppConstants.TREASURE,dtos4);
		A小说番茄.handle(robot,"phone001","番茄小说", AppConstants.WATCH_ADVERT,dtos4);

		log.info("********************奇热小说**************************");
		List<PhoneCodeDto> dtos5 = phoneCodeService.getList("phone001","奇热小说");
		A小说奇热.handle(robot,"phone001","奇热小说", AppConstants.WATCH_NEWS,dtos5);
		A小说奇热.handle(robot,"phone001","奇热小说", AppConstants.DRAW,dtos5);
		A小说奇热.handle(robot,"phone001","奇热小说", AppConstants.WATCH_ADVERT,dtos5);
		A小说奇热.handle(robot,"phone001","奇热小说", AppConstants.GIFT_MONEY,dtos5);

		log.info("********************快乐天气**************************");
		List<PhoneCodeDto> dtos6 = phoneCodeService.getList("phone001","快乐天气");
		A快乐天气.handle(robot,"phone001","快乐天气", AppConstants.GIFT_MONEY,dtos6);
		A快乐天气.handle(robot,"phone001","快乐天气", AppConstants.DRAW,dtos6);
		A快乐天气.handle(robot,"phone001","快乐天气", AppConstants.SCRATCH_CARD,dtos6);



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

		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","晴象浏览器");
		A浏览器晴象.handle(robot,"phone001","晴象浏览器", AppConstants.CHECK_IN,dtos1);

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
