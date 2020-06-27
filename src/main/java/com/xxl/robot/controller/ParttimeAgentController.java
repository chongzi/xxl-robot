package com.xxl.robot.controller;

import com.github.pagehelper.PageInfo;
import com.xxl.common.response.BaseResponse;
import com.xxl.robot.dto.ParttimeAgentDto;
import com.xxl.robot.service.ParttimeAgentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parttime/agent")
@Api(tags = "兼职管理-代理推广服务")
public class ParttimeAgentController {

    @Autowired
    private ParttimeAgentService parttimeAgentService;

    @GetMapping
    @ApiOperation("详情")
    public BaseResponse get(Long id) {
        return BaseResponse.newSuccess(parttimeAgentService.get(id));
    }

    @PostMapping
    @ApiOperation("新增")
    public BaseResponse save(@RequestBody ParttimeAgentDto dto) {
        return BaseResponse.newSuccess(parttimeAgentService.save(dto));
    }

    @PutMapping
    @ApiOperation("更新")
    public BaseResponse update(@RequestBody ParttimeAgentDto dto) {
        return BaseResponse.newSuccess(parttimeAgentService.update(dto));
    }

    @DeleteMapping
    @ApiOperation("删除")
    public BaseResponse delete(@RequestBody String ids) {
        return BaseResponse.newSuccess(parttimeAgentService.delete(ids));
    }

    @PostMapping("list")
    @ApiOperation("全部查询")
    public BaseResponse list(@RequestBody ParttimeAgentDto dto) {
        List<ParttimeAgentDto> dtos = parttimeAgentService.list(dto);
        return BaseResponse.newSuccess(dtos);
    }

    @PostMapping("page")
    @ApiOperation("分页查询")
    public BaseResponse page(@RequestBody ParttimeAgentDto dto) {
        PageInfo<ParttimeAgentDto> pageInfo = parttimeAgentService.page(dto,dto.getPageIndex(),dto.getPageSize());
        return BaseResponse.newSuccess(pageInfo.getList(), pageInfo.getTotal());
    }


    @GetMapping("doEnabled")
    @ApiOperation("启用/禁用")
    public BaseResponse doEnabled(Long id) {
        return BaseResponse.newSuccess(parttimeAgentService.doEnabled(id));
    }


}
