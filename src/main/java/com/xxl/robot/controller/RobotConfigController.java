package com.xxl.robot.controller;

import com.github.pagehelper.PageInfo;
import com.xxl.common.response.BaseResponse;
import com.xxl.robot.dto.RobotConfigDto;
import com.xxl.robot.service.RobotConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/robot/config")
@Api(tags = "智能配置控制器")
public class RobotConfigController {

    @Autowired
    private RobotConfigService robotConfigService;

    @GetMapping
    @ApiOperation("详情")
    public BaseResponse get(Long id) {
        return BaseResponse.newSuccess(robotConfigService.get(id));
    }

    @PostMapping
    @ApiOperation("新增")
    public BaseResponse save(@RequestBody RobotConfigDto dto) {
        return BaseResponse.newSuccess(robotConfigService.save(dto));
    }

    @PutMapping
    @ApiOperation("更新")
    public BaseResponse update(@RequestBody RobotConfigDto dto) {
        return BaseResponse.newSuccess(robotConfigService.update(dto));
    }

    @DeleteMapping
    @ApiOperation("删除")
    public BaseResponse delete(@RequestBody String ids) {
        return BaseResponse.newSuccess(robotConfigService.delete(ids));
    }

    @PostMapping("list")
    @ApiOperation("全部查询")
    public BaseResponse list(@RequestBody RobotConfigDto dto) {
        List<RobotConfigDto> dtos = robotConfigService.list(dto);
        return BaseResponse.newSuccess(dtos);
    }

    @PostMapping("page")
    @ApiOperation("分页查询")
    public BaseResponse page(@RequestBody RobotConfigDto dto) {
        PageInfo<RobotConfigDto> pageInfo = robotConfigService.page(dto,dto.getPageIndex(),dto.getPageSize());
        return BaseResponse.newSuccess(pageInfo.getList(), pageInfo.getTotal());
    }

    @PostMapping(value = "queryDictionary")
    @ApiOperation("分页查询数据字典编码值定义表")
    public BaseResponse queryDictionary(@RequestBody String codeType) {
        return BaseResponse.newSuccess(robotConfigService.queryDictionary(codeType));
    }

    @PostMapping("/getTypeValus")
    public BaseResponse getTypeValus(@RequestBody String[] typeNos){
        List<String> list = new ArrayList<>(Arrays.asList(typeNos));
        Map<String, Object> map  = robotConfigService.getTypeValus(list);
        return BaseResponse.newSuccess(map);
    }


    @GetMapping("doEnabled")
    @ApiOperation("启用/禁用")
    public BaseResponse doEnabled(Long id) {
        return BaseResponse.newSuccess(robotConfigService.doEnabled(id));
    }


}
