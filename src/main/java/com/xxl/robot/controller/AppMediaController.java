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
@RequestMapping(value = "/app/media")
@Api(tags = "app-视频控制器")
public class AppMediaController {

    @Autowired
    private AppMediaService appMediaService;

    @GetMapping("start")
    @ApiOperation("抖音手机操作")
    public BaseResponse start() {
        appMediaService.start();
        return BaseResponse.newSuccess();
    }


    @GetMapping("one")
    @ApiOperation("模拟火山视频操作")
    public BaseResponse one() {
        appMediaService.one();
        return BaseResponse.newSuccess();
    }

    @GetMapping("circulate")
    @ApiOperation("模拟快手视频操作")
    public BaseResponse circulate() {
        appMediaService.circulate();
        return BaseResponse.newSuccess();
    }

    @GetMapping("playGame")
    @ApiOperation("模拟微视视频操作")
    public BaseResponse playGame() {
        appMediaService.playGame();
        return BaseResponse.newSuccess();
    }


    @GetMapping("end")
    @ApiOperation("模拟刷宝视频操作")
    public BaseResponse end() {
        appMediaService.end();
        return BaseResponse.newSuccess();
    }


}
