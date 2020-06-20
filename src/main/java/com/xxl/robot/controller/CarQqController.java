package com.xxl.robot.controller;

import com.github.pagehelper.PageInfo;
import com.xxl.common.response.BaseResponse;
import com.xxl.robot.dto.CarQqDto;
import com.xxl.robot.service.CarQqService;
import com.xxl.robot.service.RobotConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car/qq")
@Api(tags = "汽车QQ服务")
public class CarQqController {

    @Autowired
    private CarQqService carQqService;

    @GetMapping
    @ApiOperation("详情")
    public BaseResponse get(Long id) {
        return BaseResponse.newSuccess(carQqService.get(id));
    }

    @PostMapping
    @ApiOperation("新增")
    public BaseResponse save(@RequestBody CarQqDto dto) {
        return BaseResponse.newSuccess(carQqService.save(dto));
    }

    @PutMapping
    @ApiOperation("更新")
    public BaseResponse update(@RequestBody CarQqDto dto) {
        return BaseResponse.newSuccess(carQqService.update(dto));
    }

    @DeleteMapping
    @ApiOperation("删除")
    public BaseResponse delete(@RequestBody String ids) {
        return BaseResponse.newSuccess(carQqService.delete(ids));
    }

    @PostMapping("list")
    @ApiOperation("全部查询")
    public BaseResponse list(@RequestBody CarQqDto dto) {
        List<CarQqDto> dtos = carQqService.list(dto);
        return BaseResponse.newSuccess(dtos);
    }

    @PostMapping("page")
    @ApiOperation("分页查询")
    public BaseResponse page(@RequestBody CarQqDto dto) {
        PageInfo<CarQqDto> pageInfo = carQqService.page(dto,dto.getPageIndex(),dto.getPageSize());
        return BaseResponse.newSuccess(pageInfo.getList(), pageInfo.getTotal());
    }



}
