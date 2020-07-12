package com.xxl.robot.controller;

import com.github.pagehelper.PageInfo;
import com.xxl.common.response.BaseResponse;
import com.xxl.robot.dto.RobotQqDto;
import com.xxl.robot.service.RobotQqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ar")
@Api(tags = "机器人控制器")
public class RobotController {

    @Autowired
    private RobotQqService robotQqService;


    @PostMapping("collectQQ")
    @ApiOperation("QQ数据采集")
    public BaseResponse collectQQ(@RequestBody RobotQqDto dto) {
        robotQqService.collectQQ();
        return BaseResponse.newSuccess();
    }

}
