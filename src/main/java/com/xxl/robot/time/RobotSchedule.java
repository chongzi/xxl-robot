package com.xxl.robot.time;

import com.xxl.robot.dto.RobotQqDto;
import com.xxl.robot.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 汽车租赁方面微信，QQ数据爬取
 */
@Component
public class RobotSchedule {
  private static final Logger log = LoggerFactory.getLogger(RobotSchedule.class);

    @Autowired
    private RobotQqService robotQqService;
    @Autowired
    private RobotWechartService  robotWechartService;
    @Autowired
    private CarSourceService carSourceService;




    /**
     * todo 源始数据采集信息
     * 表示每隔3分钟获取数据一次
     * 至少大于1分钟
     */
   @Scheduled(cron = "0 0/3 * * * ?")
    public void collectSource(){
        log.info("********************collectSource()方法源始数据采集信定时器启动**************************");
            carSourceService.analysisQQ();
    }



    /**
     * todo 删除QQ源始数据
     * 表示每隔30分钟获取数据一次
     * 至少大于1分钟
     */
      @Scheduled(cron = "0 0/30 * * * ?")
    public void deleteQQSource(){
        log.info("********************deleteQQSource()方法删除QQ爬取来的数据定时器启动**************************");
          robotQqService.deleteQQ();
    }


//***********************************************业务性操作*******************************************************

    /**
     * todo qq采集信息
     * 表示每隔3分钟获取数据一次
     * 至少大于1分钟
     */
  //@Scheduled(cron = "0 0/1 * * * ?")
  //@Scheduled(cron = "0/30 * * * * ?")
   public void qqCrawl(){
       log.info("********************qqProces定时器启动**************************");
       robotQqService.collectQQ();
   }




    /**
     * todo qq自动发送
     * 表示每隔3分钟获取数据一次
     * 至少大于1分钟
     */
    //@Scheduled(cron = "0/30 * * * * ?")
    public void qqSend(){
        log.info("********************qqSend自动发消息定时器启动**************************");
        robotQqService.sendQQ();
    }





}

