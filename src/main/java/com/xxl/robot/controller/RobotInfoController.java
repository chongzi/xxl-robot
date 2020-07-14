package com.xxl.robot.controller;

import com.github.pagehelper.PageInfo;
import com.xxl.common.response.BaseResponse;
import com.xxl.robot.dto.RobotInfoDto;
import com.xxl.robot.service.RobotInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/info")
@Api(tags = "机器人控制器")
public class RobotInfoController {

    @Autowired
    private RobotInfoService robotInfoService;

    @GetMapping
    @ApiOperation("详情")
    public BaseResponse get(Long id) {
        return BaseResponse.newSuccess(robotInfoService.get(id));
    }

    @PostMapping
    @ApiOperation("新增")
    public BaseResponse save(@RequestBody RobotInfoDto dto) {
        return BaseResponse.newSuccess(robotInfoService.save(dto));
    }

    @PutMapping
    @ApiOperation("更新")
    public BaseResponse update(@RequestBody RobotInfoDto dto) {
        return BaseResponse.newSuccess(robotInfoService.update(dto));
    }

    @DeleteMapping
    @ApiOperation("删除")
    public BaseResponse delete(@RequestBody String ids) {
        return BaseResponse.newSuccess(robotInfoService.delete(ids));
    }

    @PostMapping("list")
    @ApiOperation("全部查询")
    public BaseResponse list(@RequestBody RobotInfoDto dto) {
        List<RobotInfoDto> dtos = robotInfoService.list(dto);
        return BaseResponse.newSuccess(dtos);
    }

    @PostMapping("page")
    @ApiOperation("分页查询")
    public BaseResponse page(@RequestBody RobotInfoDto dto) {
        PageInfo<RobotInfoDto> pageInfo = robotInfoService.page(dto,dto.getPageIndex(),dto.getPageSize());
        return BaseResponse.newSuccess(pageInfo.getList(), pageInfo.getTotal());
    }


    @GetMapping("doEnabled")
    @ApiOperation("启用/禁用")
    public BaseResponse doEnabled(Long id) {
        return BaseResponse.newSuccess(robotInfoService.doEnabled(id));
    }


}
