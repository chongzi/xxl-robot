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



}
