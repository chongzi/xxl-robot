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
    private PhoneSourceService phoneSourceService;
    @Autowired
    private PhoneCodeService phoneCodeService;
    @Autowired
    private AppMediaService aAppMediaService;
    @Autowired
    private AppNewsService appNewsService;
    @Autowired
    private AppBrowserService appBrowserService;
    @Autowired
    private AppWalkService appWalkService;



    /**
     * todo
     * 定时器  10分钟
     */
     //@Scheduled(cron = "0 0/6 * * * ?")
    public void timer10() throws AWTException {
        String robotCode = PhoneConstants.phone001;
        log.info("********************10分钟定时器启动**************************");
         aAppMediaService.start(robotCode);

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
        String robotCode = PhoneConstants.phone001;
        log.info("********************30分钟定时器启动**************************");
        Robot robot = new Robot();
        robot.delay(RandomTools.init(8000));

    }




    /**
     * todo
     * 定时器  60分钟
     */
    //@Scheduled(cron = "0 0/20 * * * ?")
    @SneakyThrows
    public void timer60(){
         String robotCode = "phone001";
        log.info("********************15分钟定时器启动**************************");
        Robot robot = new Robot();
        /** appNewsService.circulate(robotCode);*/
       // appWalkService.circulate(robotCode);
       // appBrowserService.circulate(robotCode);
    }













}

