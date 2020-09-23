package com.xxl.robot.service.impl;

import com.xxl.robot.app.browser.A浏览器搜狗;
import com.xxl.robot.app.browser.A浏览器晴象;
import com.xxl.robot.app.browser.A综合红包赚不停;
import com.xxl.robot.app.novel.A小说米读;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.AppBrowserService;
import com.xxl.robot.service.AppNovelService;
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
public class AppNovelServiceImpl implements AppNovelService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppNovelServiceImpl.class);

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

		log.info("********************米读小说**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"米读小说");
		A小说米读.handle(robot,robotCode,"米读小说", AppConstants.CHECK_IN,dtos);


	}

	/***
	 * todo 晚上收取白天金币
	 */
	@SneakyThrows
	@Override
	@Async
	public void end(String robotCode) {


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
		log.info("********************米读小说**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList(robotCode,"\t\tlog.info(\"**********************************************\");\n");
		A小说米读.handle(robot,robotCode,"米读小说", AppConstants.WATCH_NOVELS,dtos);


	}


//************************四种类型：玩游戏********************************************************
	/***
	 * todo 玩游戏
	 */
	@Override
	@Async
	public void playGame(String robotCode) {

	}


//************************五种类型：看视频，看新闻，看小说********************************************************
	@SneakyThrows
	@Override
	@Async
	public void watchMedia(String robotCode) {
		Robot robot = new Robot();




	}

	@SneakyThrows
	@Override
	@Async
	public void watchNews(String robotCode) {
		Robot robot = new Robot();



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
