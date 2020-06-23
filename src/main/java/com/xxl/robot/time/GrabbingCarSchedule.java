package com.xxl.robot.time;

import com.alibaba.fastjson.JSON;
import com.github.binarywang.java.emoji.EmojiConverter;
import com.xxl.robot.dto.CarQqDto;
import com.xxl.robot.entity.RobotConfig;
import com.xxl.robot.service.*;
import com.xxl.robot.tools.CrawlTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 汽车租赁方面微信，QQ数据爬取
 */
@Component
public class GrabbingCarSchedule {
  private static final Logger log = LoggerFactory.getLogger(GrabbingCarSchedule.class);

    @Autowired
    private CarDriverService carDriverService;
    @Autowired
    private CarQqService carQqService;
    @Autowired
    private CarWechartService carWechartService;
    @Autowired
    private CarSourceService carSourceService;
    @Autowired
    private RobotConfigService robotConfigService;

    /**
     * todo qq采集信息
     * 表示每隔3分钟获取数据一次
     * 至少大于1分钟
     */
   @Scheduled(cron = "0 0/2 * * * ?")
   public void qqCrawl(){
       log.info("********************qqProces定时器启动**************************");
       RobotConfig robotConfig = robotConfigService.getByConfigNo("39.99.210.127");
       if(null!=robotConfig&&String.valueOf(robotConfig.getEnabled()).equals("0")){
           List<String> datas = CrawlTools.QQCrawl(6,300);
//            carSourceService.analysisQQ(datas);
            carQqService.handleQQ(datas);

       }
   }


   /**
    * todo 解析数据
    * 表示每隔2分钟获取数据一次
    * 至少大于1分钟
    */
//   @Scheduled(cron = "0 0/5 * * * ?")
   public void analysisQQ(){
       CarQqDto dto = new CarQqDto();
       dto.setEnabled((byte) 0);
       List<CarQqDto>  dtos = carQqService.list(dto);
       List<String> contents = dtos.stream().map(CarQqDto::getContent).collect(Collectors.toList());
       carSourceService.analysisQQ(contents);
       if(!CollectionUtils.isEmpty(dtos)){
           for(CarQqDto ss:dtos){
               ss.setEnabled((byte) 1);
               carQqService.update(ss);
           }
       }

    }

}

