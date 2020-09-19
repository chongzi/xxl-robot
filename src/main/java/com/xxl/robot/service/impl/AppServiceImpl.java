package com.xxl.robot.service.impl;

import com.xxl.robot.app.browser.A快乐天气;
import com.xxl.robot.app.browser.A浏览器晴象;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.*;
import lombok.SneakyThrows;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 *
 * todo app-接口
 */
@Service
public class AppServiceImpl implements AppService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppServiceImpl.class);

	@Autowired
	private AppBrowserService appBrowserService;
	@Autowired
	private AppMediaService appMediaService;
	@Autowired
	private AppNewsService appNewsService;
	@Autowired
	private AppNovelService appNovelService;
	@Autowired
	private AppWalkService appWalkService;

//**********************一种类型：签到，睡觉，步行，一次性，分享********************************************************
	/**
	 * todo 早上收取金币（用户行为：1.签到 2.领取睡觉金币）
	 */
	@SneakyThrows
	@Override
	public void start(String robotCode) {
		appBrowserService.start(robotCode);
		appMediaService.start(robotCode);
		appNewsService.start(robotCode);
		appNovelService.start(robotCode);
		appWalkService.start(robotCode);
	}


	/***
	 * todo 晚上收取金币（1.收取步行金币 2.个性化一次性收取 3.分享 4.游戏）
	 */
	@SneakyThrows
	@Override
	public void end(String robotCode) {
		appBrowserService.end(robotCode);
		appMediaService.end(robotCode);
		appNewsService.end(robotCode);
		appNovelService.end(robotCode);
		appWalkService.end(robotCode);

	}




//************************二种类型：喝水，打卡，种菜，充电，吃饭********************************************************
	/**
	 * todo 时段收取金币（用户行为：1.喝水 2.种菜 3.充电 4.吃饭）
	 */
	@SneakyThrows
	@Override
	public void  section(String robotCode) {
		appBrowserService.section(robotCode);
		appMediaService.section(robotCode);
		appNewsService.section(robotCode);
		appNovelService.section(robotCode);
		appWalkService.section(robotCode);
	}


//*************************三种类型：开宝箱，看广告，领红包********************************************************
	/**
	 * todo 循环收取金币大于200金币（1.开宝箱 2.看广告 3.领红包 4.抽奖 5.刮卡）
	 */
	@Async
	@SneakyThrows
	@Override
	public void circulate(String robotCode) {
		appBrowserService.circulate(robotCode);
		appMediaService.circulate(robotCode);
		appNewsService.circulate(robotCode);
		appNovelService.circulate(robotCode);
		appWalkService.circulate(robotCode);
	}


//************************四种类型：玩游戏********************************************************
	/***
	 * todo 玩游戏（少量金币，适合网络开启）
	 */
	@Override
	public void playGame(String robotCode) {
		appBrowserService.playGame(robotCode);
		appMediaService.playGame(robotCode);
		appNewsService.playGame(robotCode);
		appNovelService.playGame(robotCode);
		appWalkService.playGame(robotCode);
	}

//************************五种类型：看视频，看新闻，看小说********************************************************
	/**
	 * todo 看视频（少量金币，适合网络开启）
	 */
	@SneakyThrows
	@Override
	public void watchMedia(String robotCode) {
		appBrowserService.watchMedia(robotCode);
		appMediaService.watchMedia(robotCode);
		appNewsService.watchMedia(robotCode);
		appNovelService.watchMedia(robotCode);
		appWalkService.watchMedia(robotCode);

	}
	/**
	 * todo 看新闻（少量金币，适合网络开启）
	 */
	@SneakyThrows
	@Override
	public void watchNews(String robotCode) {
		appBrowserService.watchNews(robotCode);
		appMediaService.watchNews(robotCode);
		appNewsService.watchNews(robotCode);
		appNovelService.watchNews(robotCode);
		appWalkService.watchNews(robotCode);

	}

	@Override
	public void watchNovel(String robotCode) {
		appBrowserService.watchNovel(robotCode);
		appMediaService.watchNovel(robotCode);
		appNewsService.watchNovel(robotCode);
		appNovelService.watchNovel(robotCode);
		appWalkService.watchNovel(robotCode);
	}

//************************六种类型： 抽奖 刮卡********************************************************
	/**
	 * todo 其它（少量金币，适合网络开启）
	 */
	@Override
	public void other(String robotCode) {
		appBrowserService.other(robotCode);
		appMediaService.other(robotCode);
		appNewsService.other(robotCode);
		appNovelService.other(robotCode);
		appWalkService.other(robotCode);
	}


}
