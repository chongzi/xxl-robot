package com.xxl.robot.controller;

import com.xxl.common.response.BaseResponse;
import com.xxl.robot.service.AppNewsService;
import com.xxl.robot.service.AppWalkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app/walk")
@Api(tags = "app-步行控制器")
public class AppWalkController {

    @Autowired
    private AppWalkService appWalkService;

    @GetMapping("start")
    @ApiOperation("开始")
    public BaseResponse start() {
        appWalkService.start();
        return BaseResponse.newSuccess();
    }


    @GetMapping("one")
    @ApiOperation("执行一次")
    public BaseResponse one() {
        appWalkService.one();
        return BaseResponse.newSuccess();
    }

    @GetMapping("circulate")
    @ApiOperation("循环执行")
    public BaseResponse circulate() {
        appWalkService.circulate();
        return BaseResponse.newSuccess();
    }

    @GetMapping("playGame")
    @ApiOperation("玩游戏")
    public BaseResponse playGame() {
        appWalkService.playGame();
        return BaseResponse.newSuccess();
    }


    @GetMapping("end")
    @ApiOperation("结束")
    public BaseResponse end() {
        appWalkService.end();
        return BaseResponse.newSuccess();
    }


}
