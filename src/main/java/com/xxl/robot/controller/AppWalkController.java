package com.xxl.robot.controller;

import com.xxl.common.response.BaseResponse;
import com.xxl.robot.constants.PhoneConstants;
import com.xxl.robot.service.AppBrowserService;
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
    String robotCode = PhoneConstants.phone001;

    @Autowired
    private AppWalkService appWalkService;
    @Autowired
    private AppBrowserService appBrowserService;

    @GetMapping("start")
    @ApiOperation("开始")
    public BaseResponse start() {
        appWalkService.start("phone001");
        appWalkService.start("phone002");

        appBrowserService.start("phone001");
        appBrowserService.start("phone002");
        return BaseResponse.newSuccess();
    }


    @GetMapping("section")
    @ApiOperation("执行一次")
    public BaseResponse section() {
        appWalkService.section("phone001");
        appWalkService.section("phone002");

        return BaseResponse.newSuccess();
    }

    @GetMapping("circulate")
    @ApiOperation("循环执行")
    public BaseResponse circulate() {
        appWalkService.circulate("phone001");
        appWalkService.circulate("phone002");
        appBrowserService.circulate("phone001");
        appBrowserService.circulate("phone002");
        return BaseResponse.newSuccess();
    }


    @GetMapping("end")
    @ApiOperation("结束")
    public BaseResponse end() {
        appWalkService.end("phone001");
        appWalkService.end("phone002");
        return BaseResponse.newSuccess();
    }


}
