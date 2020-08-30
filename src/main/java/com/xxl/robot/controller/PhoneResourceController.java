package com.xxl.robot.controller;

import com.github.pagehelper.PageInfo;
import com.xxl.common.response.BaseResponse;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.PhoneCodeService;
import com.xxl.robot.service.PhoneSourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/phone/resource")
@Api(tags = "手机数据服务")
public class PhoneResourceController {

    @Autowired
    private PhoneSourceService phoneSourceService;

    @GetMapping("simulator")
    @ApiOperation("模拟手机操作")
    public BaseResponse simulator() {
        phoneSourceService.handleRobot1();
        return BaseResponse.newSuccess();
    }

    @GetMapping("simulatorApp")
    @ApiOperation("模拟手机操作")
    public BaseResponse simulatorApp() {
        phoneSourceService.handleRobot2();
        return BaseResponse.newSuccess();
    }


    @GetMapping("simulatorApp3")
    @ApiOperation("模拟火山视频操作")
    public BaseResponse simulatorApp3() {
        phoneSourceService.handleRobot3();
        return BaseResponse.newSuccess();
    }

    @GetMapping("simulatorApp4")
    @ApiOperation("模拟快手视频操作")
    public BaseResponse simulatorApp4() {
        phoneSourceService.handleRobot4();
        return BaseResponse.newSuccess();
    }

    @GetMapping("simulatorApp5")
    @ApiOperation("模拟微视视频操作")
    public BaseResponse simulatorApp5() {
        phoneSourceService.handleRobot5();
        return BaseResponse.newSuccess();
    }


    @GetMapping("simulatorApp6")
    @ApiOperation("模拟刷宝视频操作")
    public BaseResponse simulatorApp6() {
        phoneSourceService.handleRobot6();
        return BaseResponse.newSuccess();
    }


    @GetMapping("simulatorApp7")
    @ApiOperation("快逗视频操作")
    public BaseResponse simulatorApp7() {
        phoneSourceService.handleRobot7();
        return BaseResponse.newSuccess();
    }


    @GetMapping("simulatorApp8")
    @ApiOperation("追看视频操作")
    public BaseResponse simulatorApp8() {
        phoneSourceService.handleRobot8();
        return BaseResponse.newSuccess();
    }


    @GetMapping("simulatorApp9")
    @ApiOperation(" 小吃货视频操作")
    public BaseResponse simulatorApp9() {
        phoneSourceService.handleRobot9();
        return BaseResponse.newSuccess();
    }



}
