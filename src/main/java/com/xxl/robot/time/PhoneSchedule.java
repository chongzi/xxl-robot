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
     * todo 1-签到00:00-1:00
     */
     @Scheduled(cron = "0 0 0 * * ?")
    public void start() throws AWTException {
        log.info("********************1-签到00:00-1:00定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(6000));
         appService.start("phone001");
         appService.start("phone002");
         appService.start("phone003");
         appService.start("phone0031");
         appService.start("phone0032");
         appService.start("phone0033");
         appService.start("phone0034");
         appService.start("phone0035");

         aAppMediaService.start("phone001");
         aAppMediaService.start("phone002");
         aAppMediaService.start("phone003");
         aAppMediaService.start("phone0031");
         aAppMediaService.start("phone0032");
         aAppMediaService.start("phone0033");
         aAppMediaService.start("phone0034");
         aAppMediaService.start("phone0035");

         appNewsService.start("phone001");
         appNewsService.start("phone002");
         appNewsService.start("phone003");
         appNewsService.start("phone0031");
         appNewsService.start("phone0032");
         appNewsService.start("phone0033");
         appNewsService.start("phone0034");
         appNewsService.start("phone0035");

         appNovelService.start("phone001");
         appNovelService.start("phone002");
         appNovelService.start("phone003");
         appNovelService.start("phone0031");
         appNovelService.start("phone0032");
         appNovelService.start("phone0033");
         appNovelService.start("phone0034");
         appNovelService.start("phone0035");

         appWalkService.start("phone001");
         appWalkService.start("phone002");
         appWalkService.start("phone003");
         appWalkService.start("phone0031");
         appWalkService.start("phone0032");
         appWalkService.start("phone0033");
         appWalkService.start("phone0034");
         appWalkService.start("phone0035");


     }

//************************二种类型：分段（一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）*****************************************
    /**
     * todo 2.1-早上8:00-9:00  （一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电）
     */
    @Scheduled(cron = "0 0 8 * * ?")
    public void section1() throws AWTException {
        log.info("********************2.1-早上8:00-9:00  （一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电）定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(6000));
        appService.section1("phone001");
        appService.section1("phone002");
        appService.section1("phone003");
        appService.section1("phone0031");
        appService.section1("phone0032");
        appService.section1("phone0033");
        appService.section1("phone0034");
        appService.section1("phone0035");

        aAppMediaService.section1("phone001");
        aAppMediaService.section1("phone002");
        aAppMediaService.section1("phone003");
        aAppMediaService.section1("phone0031");
        aAppMediaService.section1("phone0032");
        aAppMediaService.section1("phone0033");
        aAppMediaService.section1("phone0034");
        aAppMediaService.section1("phone0035");

        appNewsService.section1("phone001");
        appNewsService.section1("phone002");
        appNewsService.section1("phone003");
        appNewsService.section1("phone0031");
        appNewsService.section1("phone0032");
        appNewsService.section1("phone0033");
        appNewsService.section1("phone0034");
        appNewsService.section1("phone0035");

        appNovelService.section1("phone001");
        appNovelService.section1("phone002");
        appNovelService.section1("phone003");
        appNovelService.section1("phone0031");
        appNovelService.section1("phone0032");
        appNovelService.section1("phone0033");
        appNovelService.section1("phone0034");
        appNovelService.section1("phone0035");

        appWalkService.section1("phone001");
        appWalkService.section1("phone002");
        appWalkService.section1("phone003");
        appWalkService.section1("phone0031");
        appWalkService.section1("phone0032");
        appWalkService.section1("phone0033");
        appWalkService.section1("phone0034");
        appWalkService.section1("phone0035");

    }


    /**
     * todo 2.2-中午11：00-12:00（吃饭，喝水，打卡，种菜，分享，游戏，充电）
     */
    @Scheduled(cron = "0 0 11 * * ?")
    public void section2() throws AWTException {
        log.info("********************2.2-中午11：00-12:00（吃饭，喝水，打卡，种菜，分享，游戏，充电）定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(6000));
        appService.section2("phone001");
        appService.section2("phone002");
        appService.section2("phone003");
        appService.section2("phone0031");
        appService.section2("phone0032");
        appService.section2("phone0033");
        appService.section2("phone0034");
        appService.section2("phone0035");

        aAppMediaService.section2("phone001");
        aAppMediaService.section2("phone002");
        aAppMediaService.section2("phone003");
        aAppMediaService.section2("phone0031");
        aAppMediaService.section2("phone0032");
        aAppMediaService.section2("phone0033");
        aAppMediaService.section2("phone0034");
        aAppMediaService.section2("phone0035");

        appNewsService.section2("phone001");
        appNewsService.section2("phone002");
        appNewsService.section2("phone003");
        appNewsService.section2("phone0031");
        appNewsService.section2("phone0032");
        appNewsService.section2("phone0033");
        appNewsService.section2("phone0034");
        appNewsService.section2("phone0035");

        appNovelService.section2("phone001");
        appNovelService.section2("phone002");
        appNovelService.section2("phone003");
        appNovelService.section2("phone0031");
        appNovelService.section2("phone0032");
        appNovelService.section2("phone0033");
        appNovelService.section2("phone0034");
        appNovelService.section2("phone0035");

        appWalkService.section2("phone001");
        appWalkService.section2("phone002");
        appWalkService.section2("phone003");
        appWalkService.section2("phone0031");
        appWalkService.section2("phone0032");
        appWalkService.section2("phone0033");
        appWalkService.section2("phone0034");
        appWalkService.section2("phone0035");


    }

    /**
     *  todo 2.3-下午19：00-20：00（吃饭，喝水，打卡，种菜，分享，游戏，充电）
     */
    @Scheduled(cron = "0 0 19 * * ?")
    public void section3() throws AWTException {
        log.info("********************2.3-下午19：00-20：00（吃饭，喝水，打卡，种菜，分享，游戏，充电）定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(6000));
        appService.section3("phone001");
        appService.section3("phone002");
        appService.section3("phone003");
        appService.section3("phone0031");
        appService.section3("phone0032");
        appService.section3("phone0033");
        appService.section3("phone0034");
        appService.section3("phone0035");


        aAppMediaService.section3("phone001");
        aAppMediaService.section3("phone002");
        aAppMediaService.section3("phone003");
        aAppMediaService.section3("phone0031");
        aAppMediaService.section3("phone0032");
        aAppMediaService.section3("phone0033");
        aAppMediaService.section3("phone0034");
        aAppMediaService.section3("phone0035");

        appNewsService.section3("phone001");
        appNewsService.section3("phone002");
        appNewsService.section3("phone003");
        appNewsService.section3("phone0031");
        appNewsService.section3("phone0032");
        appNewsService.section3("phone0033");
        appNewsService.section3("phone0034");
        appNewsService.section3("phone0035");

        appNovelService.section3("phone001");
        appNovelService.section3("phone002");
        appNovelService.section3("phone003");
        appNovelService.section3("phone0031");
        appNovelService.section3("phone0032");
        appNovelService.section3("phone0033");
        appNovelService.section3("phone0034");
        appNovelService.section3("phone0035");

        appWalkService.section3("phone001");
        appWalkService.section3("phone002");
        appWalkService.section3("phone003");
        appWalkService.section3("phone0031");
        appWalkService.section3("phone0032");
        appWalkService.section3("phone0033");
        appWalkService.section3("phone0034");
        appWalkService.section3("phone0035");

    }

    /**
     * todo 2.4-晚上23：00-24：00（睡觉打卡，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）
     */
    @Scheduled(cron = "0 28 23 * * ?")
    public void section4() throws AWTException {
        log.info("********************2.4-晚上23：00-24：00（睡觉打卡，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(6000));
        appService.section4("phone001");
        appService.section4("phone002");
        appService.section4("phone003");
        appService.section4("phone0031");
        appService.section4("phone0032");
        appService.section4("phone0033");
        appService.section4("phone0034");
        appService.section4("phone0035");


        aAppMediaService.section4("phone001");
        aAppMediaService.section4("phone002");
        aAppMediaService.section4("phone003");
        aAppMediaService.section4("phone0031");
        aAppMediaService.section4("phone0032");
        aAppMediaService.section4("phone0033");
        aAppMediaService.section4("phone0034");
        aAppMediaService.section4("phone0035");

        appNewsService.section4("phone001");
        appNewsService.section4("phone002");
        appNewsService.section4("phone003");
        appNewsService.section4("phone0031");
        appNewsService.section4("phone0032");
        appNewsService.section4("phone0033");
        appNewsService.section4("phone0034");
        appNewsService.section4("phone0035");

        appNovelService.section4("phone001");
        appNovelService.section4("phone002");
        appNovelService.section4("phone003");
        appNovelService.section4("phone0031");
        appNovelService.section4("phone0032");
        appNovelService.section4("phone0033");
        appNovelService.section4("phone0034");
        appNovelService.section4("phone0035");

        appWalkService.section4("phone001");
        appWalkService.section4("phone002");
        appWalkService.section4("phone003");
        appWalkService.section4("phone0031");
        appWalkService.section4("phone0032");
        appWalkService.section4("phone0033");
        appWalkService.section4("phone0034");
        appWalkService.section4("phone0035");


    }

    /**
     * todo 3.1-循环收取金币大于200金币
     * 执行时间 00：00-6：00，10：00-11：00，12：00-19：00，20：00-23：00
     */
    @Scheduled(cron = "0 0 1,2,3,4,5,6,7,9,10,12,13,14,15,16,17,18,20,21,22 * * ?")
    public void circulate1() throws AWTException {
        log.info("********************3.1-循环收取金币大于200金币 定时器启动**************************");
        appService.circulate1("phone001");
        appService.circulate1("phone002");
        appService.circulate1("phone003");
        appService.circulate1("phone0031");
        appService.circulate1("phone0032");
        appService.circulate1("phone0033");
        appService.circulate1("phone0034");
        appService.circulate1("phone0035");


        aAppMediaService.circulate1("phone001");
        aAppMediaService.circulate1("phone002");
        aAppMediaService.circulate1("phone003");
        aAppMediaService.circulate1("phone0031");
        aAppMediaService.circulate1("phone0032");
        aAppMediaService.circulate1("phone0033");
        aAppMediaService.circulate1("phone0034");
        aAppMediaService.circulate1("phone0035");

        appNewsService.circulate1("phone001");
        appNewsService.circulate1("phone002");
        appNewsService.circulate1("phone003");
        appNewsService.circulate1("phone0031");
        appNewsService.circulate1("phone0032");
        appNewsService.circulate1("phone0033");
        appNewsService.circulate1("phone0034");
        appNewsService.circulate1("phone0035");

        appNovelService.circulate1("phone001");
        appNovelService.circulate1("phone002");
        appNovelService.circulate1("phone003");
        appNovelService.circulate1("phone0031");
        appNovelService.circulate1("phone0032");
        appNovelService.circulate1("phone0033");
        appNovelService.circulate1("phone0034");
        appNovelService.circulate1("phone0035");

        appWalkService.circulate1("phone001");
        appWalkService.circulate1("phone002");
        appWalkService.circulate1("phone003");
        appWalkService.circulate1("phone0031");
        appWalkService.circulate1("phone0032");
        appWalkService.circulate1("phone0033");
        appWalkService.circulate1("phone0034");
        appWalkService.circulate1("phone0035");

    }











}

