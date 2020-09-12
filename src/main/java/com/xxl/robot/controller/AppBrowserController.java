package com.xxl.robot.controller;

import com.xxl.common.response.BaseResponse;
import com.xxl.robot.service.AppBrowserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app/browser")
@Api(tags = "app-步行控制器")
public class AppBrowserController {

    @Autowired
    private AppBrowserService appBrowserService;

    @GetMapping("start")
    @ApiOperation("开始")
    public BaseResponse start() {
        appBrowserService.start();
        return BaseResponse.newSuccess();
    }


    @GetMapping("one")
    @ApiOperation("执行一次")
    public BaseResponse one() {
        appBrowserService.one();
        return BaseResponse.newSuccess();
    }

    @GetMapping("circulate")
    @ApiOperation("循环执行")
    public BaseResponse circulate() {
        appBrowserService.circulate();
        return BaseResponse.newSuccess();
    }

    @GetMapping("playGame")
    @ApiOperation("玩游戏")
    public BaseResponse playGame() {
        appBrowserService.playGame();
        return BaseResponse.newSuccess();
    }


    @GetMapping("end")
    @ApiOperation("结束")
    public BaseResponse end() {
        appBrowserService.end();
        return BaseResponse.newSuccess();
    }


}
