package com.xxl.robot.time;

import com.xxl.robot.service.CarSourceService;
import com.xxl.robot.service.PhoneSourceService;
import com.xxl.robot.service.RobotQqService;
import com.xxl.robot.service.RobotWechartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 电脑模拟自动化操作手机
 */
@Component
public class PhoneSchedule {
  private static final Logger log = LoggerFactory.getLogger(PhoneSchedule.class);

    @Autowired
    private PhoneSourceService phoneSourceService;




    /**
     * todo 源始数据采集信息
     * 表示每隔3分钟获取数据一次
     * 至少大于1分钟
     */
   @Scheduled(cron = "0 0/30 * * * ?")
    public void collectSource(){
        log.info("********************电脑模拟自动化操作手机定时器启动**************************");

    }




}

