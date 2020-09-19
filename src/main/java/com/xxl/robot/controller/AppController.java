package com.xxl.robot.controller;

import com.xxl.common.response.BaseResponse;
import com.xxl.robot.service.AppBrowserService;
import com.xxl.robot.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app/browser")
@Api(tags = "app-步行控制器")
public class AppController {



    @Autowired
    private AppService appService;

    @GetMapping("start")
    @ApiOperation("开始")
    public BaseResponse start() {
        appService.start("phone001");
        appService.start("phone002");
        return BaseResponse.newSuccess();
    }


    @GetMapping("section")
    @ApiOperation("执行一次")
    public BaseResponse section() {
        appService.section("phone001");
        appService.section("phone002");
        return BaseResponse.newSuccess();
    }

    @GetMapping("circulate")
    @ApiOperation("循环执行")
    public BaseResponse circulate() {
        appService.circulate("phone001");
       // appBrowserService.circulate("phone002");
        return BaseResponse.newSuccess();
    }

    @GetMapping("end")
    @ApiOperation("结束")
    public BaseResponse end() {
        appService.end("phone001");
        appService.end("phone002");
        return BaseResponse.newSuccess();
    }


}