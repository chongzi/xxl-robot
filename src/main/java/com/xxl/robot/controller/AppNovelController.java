package com.xxl.robot.controller;

import com.xxl.common.response.BaseResponse;
import com.xxl.robot.constants.PhoneConstants;
import com.xxl.robot.service.AppNewsService;
import com.xxl.robot.service.AppNovelService;
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
    private AppNovelService appNovelService;

    @GetMapping("start")
    @ApiOperation("开始")
    public BaseResponse start() {
        appNovelService.start("phone001");
        appNovelService.start("phone002");
        return BaseResponse.newSuccess();
    }


    @GetMapping("section")
    @ApiOperation("执行一次")
    public BaseResponse section() {
        appNovelService.section("phone001");
        appNovelService.section("phone002");
        return BaseResponse.newSuccess();
    }

    @GetMapping("circulate")
    @ApiOperation("循环执行")
    public BaseResponse circulate() {
        appNovelService.circulate("phone001");
        appNovelService.circulate("phone002");
        return BaseResponse.newSuccess();
    }


    @GetMapping("end")
    @ApiOperation("结束")
    public BaseResponse end() {
        appNovelService.end("phone001");
        appNovelService.end("phone002");
        return BaseResponse.newSuccess();
    }


}
