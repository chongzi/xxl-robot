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
    @ApiOperation("开始操作")
    public BaseResponse start() {
        appMediaService.start();
        return BaseResponse.newSuccess();
    }


    @GetMapping("section")
    @ApiOperation("分段操作")
    public BaseResponse section() {
        appMediaService.section();
        return BaseResponse.newSuccess();
    }

    @GetMapping("circulate")
    @ApiOperation("循环操作")
    public BaseResponse circulate() {
        appMediaService.circulate();
        return BaseResponse.newSuccess();
    }


    @GetMapping("end")
    @ApiOperation("最后操作")
    public BaseResponse end() {
        appMediaService.end();
        return BaseResponse.newSuccess();
    }


}
