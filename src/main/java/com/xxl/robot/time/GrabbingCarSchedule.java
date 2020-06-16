package com.xxl.robot.time;

import com.alibaba.fastjson.JSON;
import com.github.binarywang.java.emoji.EmojiConverter;
import com.xxl.robot.dto.CarQqDto;
import com.xxl.robot.service.CarDriverService;
import com.xxl.robot.service.CarQqService;
import com.xxl.robot.service.CarSourceService;
import com.xxl.robot.service.CarWechartService;
import com.xxl.robot.tools.CrawlTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;


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

    /**
     * 表示每隔3分钟获取数据一次
     * 至少大于1分钟
     */
   @Scheduled(cron = "0 0/2 * * * ?")
   public void qqProces(){
       log.info("********************qqProces定时器启动**************************");
       List<String> datas = CrawlTools.QQCrawl(6,200);
       if(!CollectionUtils.isEmpty(datas)){
           for(String data:datas){
               CarQqDto dto = new CarQqDto();
               EmojiConverter emojiConverter = EmojiConverter.getInstance();
               data= emojiConverter.toAlias(data);//将聊天内容进行转义
               dto.setContent(data);
               carQqService.save(dto);
           }
       }


    }


}
