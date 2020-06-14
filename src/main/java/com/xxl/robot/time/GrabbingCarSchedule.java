package com.xxl.robot.time;

import com.xxl.robot.service.CarDriverService;
import com.xxl.robot.service.CarQqService;
import com.xxl.robot.service.CarSourceService;
import com.xxl.robot.service.CarWechartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 汽车租赁方面微信，QQ数据爬取
 */
@Component
public class GrabbingCarSchedule {

    @Autowired
    private CarDriverService carDriverService;
    @Autowired
    private CarQqService carQqService;
    @Autowired
    private CarWechartService carWechartService;
    @Autowired
    private CarSourceService carSourceService;

    /**
     * 表示每隔6秒发送一次邮件
     */
    @Scheduled(cron = "*/6 * * * * ?")
    private void qqProces(){


        System.out.println("发送定时邮件成功");
    }


}
