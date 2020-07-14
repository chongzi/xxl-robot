package com.xxl.robot.controller;

import com.github.pagehelper.PageInfo;
import com.xxl.common.response.BaseResponse;
import com.xxl.robot.dto.RobotPlanDto;
import com.xxl.robot.dto.RobotQqDto;
import com.xxl.robot.service.RobotPlanService;
import com.xxl.robot.service.RobotQqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/plan")
@Api(tags = "执行计划")
public class RobotPlanController {

    @Autowired
    private RobotPlanService robotPlanService;

    @GetMapping
    @ApiOperation("详情")
    public BaseResponse get(Long id) {
        return BaseResponse.newSuccess(robotPlanService.get(id));
    }

    @PostMapping
    @ApiOperation("新增")
    public BaseResponse save(@RequestBody RobotPlanDto dto) {
        return BaseResponse.newSuccess(robotPlanService.save(dto));
    }

    @PutMapping
    @ApiOperation("更新")
    public BaseResponse update(@RequestBody RobotPlanDto dto) {
        return BaseResponse.newSuccess(robotPlanService.update(dto));
    }

    @DeleteMapping
    @ApiOperation("删除")
    public BaseResponse delete(@RequestBody String ids) {
        return BaseResponse.newSuccess(robotPlanService.delete(ids));
    }

    @PostMapping("list")
    @ApiOperation("全部查询")
    public BaseResponse list(@RequestBody RobotPlanDto dto) {
        List<RobotPlanDto> dtos = robotPlanService.list(dto);
        return BaseResponse.newSuccess(dtos);
    }

    @PostMapping("page")
    @ApiOperation("分页查询")
    public BaseResponse page(@RequestBody RobotPlanDto dto) {
        PageInfo<RobotPlanDto> pageInfo = robotPlanService.page(dto,dto.getPageIndex(),dto.getPageSize());
        return BaseResponse.newSuccess(pageInfo.getList(), pageInfo.getTotal());
    }



}
