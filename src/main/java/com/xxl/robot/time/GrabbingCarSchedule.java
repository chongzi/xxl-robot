package com.xxl.robot.time;

import com.xxl.robot.entity.RobotCode;
import com.xxl.robot.service.*;
import com.xxl.robot.tools.CrawlTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 汽车租赁方面微信，QQ数据爬取
 */
@Component
public class GrabbingCarSchedule {
  private static final Logger log = LoggerFactory.getLogger(GrabbingCarSchedule.class);

    @Autowired
    private RobotQqService robotQqService;
    @Autowired
    private RobotWechartService  robotWechartService;
    @Autowired
    private CarSourceService carSourceService;
    @Autowired
    private RobotCodeService robotCodeService;



    /**
     * todo 源始数据采集信息
     * 表示每隔3分钟获取数据一次
     * 至少大于1分钟
     */
   //@Scheduled(cron = "0 0/3 * * * ?")
    public void collectSource(){
        log.info("********************collectSource()方法源始数据采集信定时器启动**************************");
            carSourceService.analysisQQ();
    }


//***********************************************业务性操作*******************************************************

    /**
     * todo qq采集信息
     * 表示每隔3分钟获取数据一次
     * 至少大于1分钟
     */
  @Scheduled(cron = "0 0/1 * * * ?")
   public void qqCrawl(){
       log.info("********************qqProces定时器启动**************************");
      List<RobotCode> codes = robotCodeService.queryDictionary("QQ_SOURCE_GROUP");
      if(!CollectionUtils.isEmpty(codes)){
          for(RobotCode code:codes){
              String data = CrawlTools.QQCrawl(code.getNo());
              robotQqService.handleQQ(data);
          }
      }


   }









}

