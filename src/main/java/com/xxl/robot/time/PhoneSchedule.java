package com.xxl.robot.time;

import com.xxl.robot.app.media.A视频抖音;
import com.xxl.robot.app.media.B视频火山;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.*;
import com.xxl.robot.tools.RandomTools;
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
    @Autowired
    private AppMediaService aAppMediaService;



    /**
     * todo
     * 定时器  10分钟
     */
     //@Scheduled(cron = "0 0/6 * * * ?")
    public void timer10() throws AWTException {
        log.info("********************10分钟定时器启动**************************");
         aAppMediaService.start();

    }

    /**
     * todo
     * 定时器  20分钟
     */
    //@Scheduled(cron = "0 0/20 * * * ?")
    public void timer20() throws AWTException {
        log.info("********************20分钟定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(60000));

    }


    /**
     * todo
     * 定时器  30分钟
     */
    //@Scheduled(cron = "0 0/30 * * * ?")
    public void timer30() throws AWTException {
        log.info("********************30分钟定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(88000));

        aAppMediaService.circulate();
    }






    /**
     * todo
     * 定时器  60分钟
     */
    //@Scheduled(cron = "0 0/60 * * * ?")
    public void timer60(){
        log.info("********************30分钟定时器启动**************************");

    }













}

