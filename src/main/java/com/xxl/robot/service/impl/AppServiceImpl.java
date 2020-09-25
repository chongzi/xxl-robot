package com.xxl.robot.service.impl;

import com.xxl.robot.service.*;
import lombok.SneakyThrows;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * todo app-统一接口
 */
@Service
public class AppServiceImpl implements AppService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppServiceImpl.class);

	@Autowired
	private AppCompositeService appCompositeService;
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



//************************一种类型：签到********************************************************
	/**
	 * todo 1-签到
	 */
	@SneakyThrows
	@Override
	@Async
	public void start(String robotCode){
		appCompositeService.start(robotCode);
		/*appBrowserService.start(robotCode);
		appMediaService.start(robotCode);
		appNewsService.start(robotCode);
		appNovelService.start(robotCode);
		appWalkService.start(robotCode);*/

	}


//************************二种类型：分段（一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）*****************************************
	/***
	 * todo 2.1-早上8:00-9:00  （一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@SneakyThrows
	@Override
	@Async
	public void section1(String robotCode){
		appCompositeService.section1(robotCode);
		/*appBrowserService.section1(robotCode);
		appMediaService.section1(robotCode);
		appNewsService.section1(robotCode);
		appNovelService.section1(robotCode);
		appWalkService.section1(robotCode);*/
	}

	/**
	 * todo 2.2-中午11：00-12:00（吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@Async
	@SneakyThrows
	@Override
	public void  section2(String robotCode){
		appCompositeService.section2(robotCode);
	/*	appBrowserService.section2(robotCode);
		appMediaService.section2(robotCode);
		appNewsService.section2(robotCode);
		appNovelService.section2(robotCode);
		appWalkService.section2(robotCode);*/
	}
	/**
	 * todo 2.3-下午19：00-20：00（吃饭，喝水，打卡，种菜，分享，游戏，充电）
	 */
	@Async
	@SneakyThrows
	@Override
	public void  section3(String robotCode){
		appCompositeService.section3(robotCode);
	/*	appBrowserService.section3(robotCode);
		appMediaService.section3(robotCode);
		appNewsService.section3(robotCode);
		appNovelService.section3(robotCode);
		appWalkService.section3(robotCode);*/
	}
	/**
	 * todo 2.4-晚上23：00-24：00（睡觉打卡，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）
	 */
	@SneakyThrows
	@Override
	@Async
	public void  section4(String robotCode){
		appCompositeService.section4(robotCode);
		/*appBrowserService.section4(robotCode);
		appMediaService.section4(robotCode);
		appNewsService.section4(robotCode);
		appNovelService.section4(robotCode);
		appWalkService.section4(robotCode);*/

	}

//*************************三种类型：循环(开宝箱，看广告，领红包,看视频，看新闻，看小说，刮卡，抽奖)********************************************************
	/**
	 * todo 3.1-循环收取金币大于200金币
	 */
	@Async
	@SneakyThrows
	@Override
	public void circulate1(String robotCode){
		appCompositeService.circulate1(robotCode);
		/*appBrowserService.circulate1(robotCode);
		appMediaService.circulate1(robotCode);
		appNewsService.circulate1(robotCode);
		appNovelService.circulate1(robotCode);
		appWalkService.circulate1(robotCode);*/
	}

	/**
	 * todo 3.2-循环收取金币小于200金币
	 */
	@Async
	@SneakyThrows
	@Override
	public void circulate2(String robotCode){
		appCompositeService.circulate2(robotCode);
		/*appBrowserService.circulate2(robotCode);
		appMediaService.circulate2(robotCode);
		appNewsService.circulate2(robotCode);
		appNovelService.circulate2(robotCode);
		appWalkService.circulate2(robotCode);*/

	}



}
