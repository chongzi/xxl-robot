package com.xxl.robot.controller;

import com.xxl.common.response.BaseResponse;
import com.xxl.robot.service.AppMediaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app/news")
@Api(tags = "app-新闻控制器")
public class AppNewsController {

    @Autowired
    private AppMediaService appMediaService;

    @GetMapping("start")
    @ApiOperation("开始")
    public BaseResponse start() {
        appMediaService.start();
        return BaseResponse.newSuccess();
    }


    @GetMapping("one")
    @ApiOperation("执行一次")
    public BaseResponse one() {
        appMediaService.one();
        return BaseResponse.newSuccess();
    }

    @GetMapping("circulate")
    @ApiOperation("循环执行")
    public BaseResponse circulate() {
        appMediaService.circulate();
        return BaseResponse.newSuccess();
    }

    @GetMapping("playGame")
    @ApiOperation("玩游戏")
    public BaseResponse playGame() {
        appMediaService.playGame();
        return BaseResponse.newSuccess();
    }


    @GetMapping("end")
    @ApiOperation("结束")
    public BaseResponse end() {
        appMediaService.end();
        return BaseResponse.newSuccess();
    }


}
