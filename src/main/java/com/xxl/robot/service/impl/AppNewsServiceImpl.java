package com.xxl.robot.service.impl;

import com.xxl.robot.app.media.*;
import com.xxl.robot.app.news.A新闻今日头条;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.AppMediaService;
import com.xxl.robot.service.AppNewsService;
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



	}

	/**
	 * todo 白天执行一次
	 */
	@SneakyThrows
	@Override
	public void  one() {
		Robot robot = new Robot();

	 	log.info("********************今日头条**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","今日头条");
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.EAT,dtos);//吃饭
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.DRAW,dtos);//抽奖
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.WATCH_NOVELS,dtos);//看小说
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.WATCH_NEWS,dtos);//看新闻


	}

	/**
	 * todo 循环执行领金币
	 */
	@SneakyThrows
	@Override
	public void circulate() {
		Robot robot = new Robot();
		log.info("********************今日头条**************************");
 		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","今日头条");
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.TREASURE,dtos);//夺宝
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.WATCH_NEWS,dtos);//看新闻


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

		log.info("********************今日头条**************************");
		List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","今日头条");
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.WALK,dtos);
		A新闻今日头条.handle(robot,"phone001","今日头条", AppConstants.SLEEP,dtos);


	}

	//*******************************************以下操作只能得取少量金币*******************************************************

	@Override
	public void watchMedia() {

	}

	@Override
	public void watchNovels() {

	}

	@Override
	public void watchNews() {

	}

	@Override
	public void other() {

	}


}
