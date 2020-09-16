package com.xxl.robot.controller;

import com.xxl.common.response.BaseResponse;
import com.xxl.robot.constants.PhoneConstants;
import com.xxl.robot.service.AppNewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app/novel")
@Api(tags = "app-小说控制器")
public class AppNovelController {
    String robotCode = PhoneConstants.phone001;

    @Autowired
    private AppNewsService appNewsService;

    @GetMapping("start")
    @ApiOperation("开始")
    public BaseResponse start() {
        appNewsService.start(robotCode);
        return BaseResponse.newSuccess();
    }


    @GetMapping("section")
    @ApiOperation("执行一次")
    public BaseResponse section() {
        appNewsService.section(robotCode);
        return BaseResponse.newSuccess();
    }

    @GetMapping("circulate")
    @ApiOperation("循环执行")
    public BaseResponse circulate() {
        appNewsService.circulate(robotCode);
        return BaseResponse.newSuccess();
    }


    @GetMapping("end")
    @ApiOperation("结束")
    public BaseResponse end() {
        appNewsService.end(robotCode);
        return BaseResponse.newSuccess();
    }


}
