package com.xxl.robot.controller;

import com.github.pagehelper.PageInfo;
import com.xxl.common.response.BaseResponse;
import com.xxl.robot.dto.RobotWechartDto;
import com.xxl.robot.service.RobotWechartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car/wechart")
@Api(tags = "汽车微信服务")
public class RobotWechartController {

    @Autowired
    private RobotWechartService robotWechartService;

    @GetMapping
    @ApiOperation("详情")
    public BaseResponse get(Long id) {
        return BaseResponse.newSuccess(robotWechartService.get(id));
    }

    @PostMapping
    @ApiOperation("新增")
    public BaseResponse save(@RequestBody RobotWechartDto dto) {
        return BaseResponse.newSuccess(robotWechartService.save(dto));
    }

    @PutMapping
    @ApiOperation("更新")
    public BaseResponse update(@RequestBody RobotWechartDto dto) {
        return BaseResponse.newSuccess(robotWechartService.update(dto));
    }

    @DeleteMapping
    @ApiOperation("删除")
    public BaseResponse delete(@RequestBody String ids) {
        return BaseResponse.newSuccess(robotWechartService.delete(ids));
    }

    @PostMapping("list")
    @ApiOperation("全部查询")
    public BaseResponse list(@RequestBody RobotWechartDto dto) {
        List<RobotWechartDto> dtos = robotWechartService.list(dto);
        return BaseResponse.newSuccess(dtos);
    }

    @PostMapping("page")
    @ApiOperation("分页查询")
    public BaseResponse page(@RequestBody RobotWechartDto dto) {
        PageInfo<RobotWechartDto> pageInfo = robotWechartService.page(dto,dto.getPageIndex(),dto.getPageSize());
        return BaseResponse.newSuccess(pageInfo.getList(), pageInfo.getTotal());
    }



    @GetMapping("doEnabled")
    @ApiOperation("启用/禁用")
    public BaseResponse doEnabled(Long id) {
        return BaseResponse.newSuccess(robotWechartService.doEnabled(id));
    }


}
