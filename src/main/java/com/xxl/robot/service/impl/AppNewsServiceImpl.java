package com.xxl.robot.service.impl;

import com.xxl.robot.app.media.*;
import com.xxl.robot.app.news.A新闻今日头条;
import com.xxl.robot.app.news.A新闻趣头条;
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

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WATCH_NOVELS,dtos1);

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

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.GIFT_MONEY,dtos1);
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.TREASURE,dtos1);
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WATCH_ADVERT,dtos1);
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.DRAW,dtos1);

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

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.SLEEP,dtos1);
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WALK,dtos1);

	}

	//*******************************************以下操作只能得取少量金币*******************************************************

	@SneakyThrows
	@Override
	public void watchMedia() {
		Robot robot = new Robot();

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WATCH_NEWS,dtos1);
	}

	@SneakyThrows
	@Override
	public void watchNovels() {
		Robot robot = new Robot();

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WATCH_NOVELS,dtos1);
	}

	@SneakyThrows
	@Override
	public void watchNews() {
		Robot robot = new Robot();

		log.info("********************趣头条**************************");
		List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","趣头条");
		A新闻趣头条.handle(robot,"phone001","趣头条", AppConstants.WATCH_NEWS,dtos1);
	}

	@Override
	public void other() {

	}


}
