package com.xxl.robot.time;

import com.xxl.robot.app.media.A视频抖音;
import com.xxl.robot.app.media.B视频火山;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.*;
import com.xxl.robot.tools.WindowTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;


/**
 * 电脑模拟自动化操作手机
 */
@Component
public class PhoneSchedule {
  private static final Logger log = LoggerFactory.getLogger(PhoneSchedule.class);

    @Autowired
    private PhoneSourceService phoneSourceService;
    @Autowired
    private PhoneCodeService phoneCodeService;




    /**
     * todo
     * 定时器  10分钟
     */
   //@Scheduled(cron = "0 0/10 * * * ?")
    public void timer10() throws AWTException {
        log.info("********************10分钟定时器启动**************************");
       Robot robot = new Robot();

        log.info("********************火山极速版**************************");
        List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","火山极速版");
        WindowTools.initWindowApp(robot,dtos);
        B视频火山.handle(robot,"phone001","火山极速版", AppConstants.WATCH_ADVERT,dtos);//观看广告


    }

    /**
     * todo
     * 定时器  20分钟
     */
    //@Scheduled(cron = "0 0/20 * * * ?")
    public void timer20() throws AWTException {
        log.info("********************20分钟定时器启动**************************");
        Robot robot = new Robot();

        log.info("********************抖音极速版**************************");
        List<PhoneCodeDto> dtos = phoneCodeService.getList("phone001","抖音极速版");
        WindowTools.initWindowApp(robot,dtos);
        A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.TREASURE,dtos);//夺宝
        A视频抖音.handle(robot,"phone001","抖音极速版", AppConstants.WATCH_ADVERT,dtos);//观看广告

        log.info("********************火山极速版**************************");
        List<PhoneCodeDto> dtos1 = phoneCodeService.getList("phone001","火山极速版");
        WindowTools.initWindowApp(robot,dtos1);
        B视频火山.handle(robot,"phone001","火山极速版", AppConstants.TREASURE,dtos1);//夺宝


    }


    /**
     * todo
     * 定时器  30分钟
     */
    //@Scheduled(cron = "0 0/30 * * * ?")
    public void timer30(){
        log.info("********************30分钟定时器启动**************************");

    }






    /**
     * todo
     * 定时器  30分钟
     */
    //@Scheduled(cron = "0 0/30 * * * ?")
    public void timer30(){
        log.info("********************30分钟定时器启动**************************");

    }













}

