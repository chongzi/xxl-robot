package com.xxl.robot.controller;

import com.github.pagehelper.PageInfo;
import com.xxl.common.response.BaseResponse;
import com.xxl.robot.dto.CarSourceDto;
import com.xxl.robot.service.CarSourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car/source")
@Api(tags = "汽车源数据服务")
public class CarSourceController {

    @Autowired
    private CarSourceService carSourceService;

    @GetMapping
    @ApiOperation("详情")
    public BaseResponse get(Long id) {
        return BaseResponse.newSuccess(carSourceService.get(id));
    }

    @PostMapping
    @ApiOperation("新增")
    public BaseResponse save(@RequestBody CarSourceDto dto) {
        return BaseResponse.newSuccess(carSourceService.save(dto));
    }

    @PutMapping
    @ApiOperation("更新")
    public BaseResponse update(@RequestBody CarSourceDto dto) {
        return BaseResponse.newSuccess(carSourceService.update(dto));
    }

    @DeleteMapping
    @ApiOperation("删除")
    public BaseResponse delete(@RequestBody String ids) {
        return BaseResponse.newSuccess(carSourceService.delete(ids));
    }

    @PostMapping("list")
    @ApiOperation("全部查询")
    public BaseResponse list(@RequestBody CarSourceDto dto) {
        List<CarSourceDto> dtos = carSourceService.list(dto);
        return BaseResponse.newSuccess(dtos);
    }

    @PostMapping("page")
    @ApiOperation("分页查询")
    public BaseResponse page(@RequestBody CarSourceDto dto) {
        PageInfo<CarSourceDto> pageInfo = carSourceService.page(dto,dto.getPageIndex(),dto.getPageSize());
        return BaseResponse.newSuccess(pageInfo.getList(), pageInfo.getTotal());
    }



}
