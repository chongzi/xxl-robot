package com.xxl.robot.controller;

import com.github.pagehelper.PageInfo;
import com.xxl.common.response.BaseResponse;
import com.xxl.robot.dto.RobotPopularizeDto;
import com.xxl.robot.service.RobotPopularizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parttime/agent")
@Api(tags = "兼职管理-代理推广服务")
public class RobotPopularizeController {

    @Autowired
    private RobotPopularizeService robotPopularizeService;

    @GetMapping
    @ApiOperation("详情")
    public BaseResponse get(Long id) {
        return BaseResponse.newSuccess(robotPopularizeService.get(id));
    }

    @PostMapping
    @ApiOperation("新增")
    public BaseResponse save(@RequestBody RobotPopularizeDto dto) {
        return BaseResponse.newSuccess(robotPopularizeService.save(dto));
    }

    @PutMapping
    @ApiOperation("更新")
    public BaseResponse update(@RequestBody RobotPopularizeDto dto) {
        return BaseResponse.newSuccess(robotPopularizeService.update(dto));
    }

    @DeleteMapping
    @ApiOperation("删除")
    public BaseResponse delete(@RequestBody String ids) {
        return BaseResponse.newSuccess(robotPopularizeService.delete(ids));
    }

    @PostMapping("list")
    @ApiOperation("全部查询")
    public BaseResponse list(@RequestBody RobotPopularizeDto dto) {
        List<RobotPopularizeDto> dtos = robotPopularizeService.list(dto);
        return BaseResponse.newSuccess(dtos);
    }

    @PostMapping("page")
    @ApiOperation("分页查询")
    public BaseResponse page(@RequestBody RobotPopularizeDto dto) {
        PageInfo<RobotPopularizeDto> pageInfo = robotPopularizeService.page(dto,dto.getPageIndex(),dto.getPageSize());
        return BaseResponse.newSuccess(pageInfo.getList(), pageInfo.getTotal());
    }


    @GetMapping("doEnabled")
    @ApiOperation("启用/禁用")
    public BaseResponse doEnabled(Long id) {
        return BaseResponse.newSuccess(robotPopularizeService.doEnabled(id));
    }


}
