package com.xxl.robot.time;

import com.xxl.robot.constants.PhoneConstants;
import com.xxl.robot.entity.PhoneCode;
import com.xxl.robot.service.*;
import com.xxl.robot.tools.RandomTools;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;


/**
 * 电脑模拟自动化操作手机
 */
@Component
public class PhoneSchedule {
  private static final Logger log = LoggerFactory.getLogger(PhoneSchedule.class);

    @Autowired
    private AppService appService;
    @Autowired
    private AppCompositeService appComposiateService;
    @Autowired
    private AppBrowserService appBrowserService;
    @Autowired
    private AppMediaService aAppMediaService;
    @Autowired
    private AppNewsService appNewsService;
    @Autowired
    private AppNovelService appNovelService;
    @Autowired
    private AppWalkService appWalkService;


//************************一种类型：签到********************************************************
    /**
     * todo 1-签到6:00-8:00
     */
     @Scheduled(cron = "0 0 6 * * ?")
    public void start() throws AWTException {
        log.info("********************1-签到6:00-8:00定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(60000));
        appService.start(PhoneConstants.phone001);

    }

//************************二种类型：分段（一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）*****************************************
    /**
     * todo 2.1-早上8:00-9:00  （一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电）
     */
    @Scheduled(cron = "0 0 8 * * ?")
    public void section1() throws AWTException {
        log.info("********************2.1-早上8:00-9:00  （一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电）定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(60000));
        appService.section1(PhoneConstants.phone001);

    }


    /**
     * todo 2.2-中午11：00-12:00（吃饭，喝水，打卡，种菜，分享，游戏，充电）
     */
    @Scheduled(cron = "0 0 11 * * ?")
    public void section2() throws AWTException {
        log.info("********************2.2-中午11：00-12:00（吃饭，喝水，打卡，种菜，分享，游戏，充电）定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(60000));
        appService.section2(PhoneConstants.phone001);

    }

    /**
     *  todo 2.3-下午19：00-20：00（吃饭，喝水，打卡，种菜，分享，游戏，充电）
     */
    @Scheduled(cron = "0 0 19 * * ?")
    public void section3() throws AWTException {
        log.info("********************2.3-下午19：00-20：00（吃饭，喝水，打卡，种菜，分享，游戏，充电）定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(60000));
        appService.section3(PhoneConstants.phone001);

    }

    /**
     * todo 2.4-晚上23：00-24：00（睡觉打卡，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）
     */
   // @Scheduled(cron = "0 0 23 * * ?")
    public void section4() throws AWTException {
        log.info("********************2.4-晚上23：00-24：00（睡觉打卡，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(60000));
        appService.section4(PhoneConstants.phone001);

    }

    /**
     * todo 3.1-循环收取金币大于200金币
     */
    @Scheduled(cron = "0 0/36 * * * ?")
    public void circulate1() throws AWTException {
        log.info("********************3.1-循环收取金币大于200金币 定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(60000));
        appService.circulate1(PhoneConstants.phone001);
        appService.circulate1(PhoneConstants.phone002);
        appService.circulate1(PhoneConstants.phone003);

    }

    /**
     * todo 3.2-循环收取金币小于200金币
     */
    //@Scheduled(cron = "0 0/20 * * * ?")
    public void circulate2() throws AWTException {
        log.info("********************3.2-循环收取金币小于200金币 定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(60000));
        appService.circulate2(PhoneConstants.phone001);

    }










}

