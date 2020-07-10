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
@RequestMapping(value = "/robot/qq")
@Api(tags = "QQ服务控制器")
public class RobotQqController {

    @Autowired
    private RobotQqService robotQqService;

    @GetMapping
    @ApiOperation("详情")
    public BaseResponse get(Long id) {
        return BaseResponse.newSuccess(robotQqService.get(id));
    }

    @PostMapping
    @ApiOperation("新增")
    public BaseResponse save(@RequestBody RobotQqDto dto) {
        return BaseResponse.newSuccess(robotQqService.save(dto));
    }

    @PutMapping
    @ApiOperation("更新")
    public BaseResponse update(@RequestBody RobotQqDto dto) {
        return BaseResponse.newSuccess(robotQqService.update(dto));
    }

    @DeleteMapping
    @ApiOperation("删除")
    public BaseResponse delete(@RequestBody String ids) {
        return BaseResponse.newSuccess(robotQqService.delete(ids));
    }

    @PostMapping("list")
    @ApiOperation("全部查询")
    public BaseResponse list(@RequestBody RobotQqDto dto) {
        List<RobotQqDto> dtos = robotQqService.list(dto);
        return BaseResponse.newSuccess(dtos);
    }

    @PostMapping("page")
    @ApiOperation("分页查询")
    public BaseResponse page(@RequestBody RobotQqDto dto) {
        PageInfo<RobotQqDto> pageInfo = robotQqService.page(dto,dto.getPageIndex(),dto.getPageSize());
        return BaseResponse.newSuccess(pageInfo.getList(), pageInfo.getTotal());
    }

    @PostMapping("collectQQ")
    @ApiOperation("QQ数据采集")
    public BaseResponse collectQQ(@RequestBody RobotQqDto dto) {
        robotQqService.collectQQ();
        return BaseResponse.newSuccess();
    }

}
