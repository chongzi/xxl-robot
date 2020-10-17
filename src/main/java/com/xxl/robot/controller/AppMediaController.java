package com.xxl.robot.controller;

import com.xxl.common.response.BaseResponse;
import com.xxl.robot.constants.PhoneConstants;
import com.xxl.robot.service.AppMediaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app/media")
@Api(tags = "app-视频控制器")
public class AppMediaController {
    String robotCode = PhoneConstants.phone001;

    @Autowired
    private AppMediaService appMediaService;



    //************************一种类型：签到********************************************************
    @GetMapping("start")
    @ApiOperation("1-签到")
    public BaseResponse start() {
      //  appMediaService.start("phone001");
        appMediaService.start("phone002");
      /*  appMediaService.start("phone003");
        appMediaService.start("phone0031");
        appMediaService.start("phone0032");
        appMediaService.start("phone0033");
        appMediaService.start("phone0034");
        appMediaService.start("phone0035");*/

        return BaseResponse.newSuccess();
    }


    //************************二种类型：分段（一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）*****************************************
    @GetMapping("section1")
    @ApiOperation("2.1-早上8:00-9:00 （一次性收取，睡觉收取，吃饭，喝水，打卡，种菜，分享，游戏，充电）")
    public BaseResponse section1() {
        appMediaService.section1("phone001");
        appMediaService.section1("phone002");
        appMediaService.section1("phone003");
        appMediaService.section1("phone0031");
        appMediaService.section1("phone0032");
        appMediaService.section1("phone0033");
        appMediaService.section1("phone0034");
        appMediaService.section1("phone0035");

        return BaseResponse.newSuccess();
    }

    @GetMapping("section2")
    @ApiOperation("2.2-中午11：00-12:00（吃饭，喝水，打卡，种菜，分享，游戏，充电）")
    public BaseResponse section2() {
        appMediaService.section2("phone001");
        appMediaService.section2("phone002");
        appMediaService.section2("phone003");
        appMediaService.section2("phone0031");
        appMediaService.section2("phone0032");
        appMediaService.section2("phone0033");
        appMediaService.section2("phone0034");
        appMediaService.section2("phone0035");
        return BaseResponse.newSuccess();
    }

    @GetMapping("section3")
    @ApiOperation("2.3-下午19：00-20：00（吃饭，喝水，打卡，种菜，分享，游戏，充电）")
    public BaseResponse section3() {
        appMediaService.section3("phone001");
        appMediaService.section3("phone002");
        appMediaService.section3("phone003");
        appMediaService.section3("phone0031");
        appMediaService.section3("phone0032");
        appMediaService.section3("phone0033");
        appMediaService.section3("phone0034");
        appMediaService.section3("phone0035");
        return BaseResponse.newSuccess();
    }

    @GetMapping("section4")
    @ApiOperation("2.4-晚上23：00-24：00（睡觉打卡，吃饭，喝水，打卡，种菜，分享，游戏，充电，步行收取）")
    public BaseResponse section4() {
        appMediaService.section4("phone001");
        appMediaService.section4("phone002");
        appMediaService.section4("phone003");
        appMediaService.section4("phone0031");
        appMediaService.section4("phone0032");
        appMediaService.section4("phone0033");
        appMediaService.section4("phone0034");
        appMediaService.section4("phone0035");
        return BaseResponse.newSuccess();
    }


    //*************************三种类型：循环(开宝箱，看广告，领红包,看视频，看新闻，看小说，刮卡，抽奖)********************************************************
    @GetMapping("circulate1")
    @ApiOperation("3.1-循环收取金币大于200金币")
    public BaseResponse circulate1() {
        //appMediaService.circulate1("phone001");
        appMediaService.circulate1("phone002");
       /* appMediaService.circulate1("phone003");
        appMediaService.circulate1("phone0031");
        appMediaService.circulate1("phone0032");
        appMediaService.circulate1("phone0033");
        appMediaService.circulate1("phone0034");
        appMediaService.circulate1("phone0035");*/
        return BaseResponse.newSuccess();
    }


    @GetMapping("circulate2")
    @ApiOperation("3.2-循环收取金币小于200金币")
    public BaseResponse circulate2() {

        return BaseResponse.newSuccess();
    }


}
