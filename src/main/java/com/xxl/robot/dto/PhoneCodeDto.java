package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Api(tags="手机数据字典实体类")
@Data
public class PhoneCodeDto {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="当前页码，默认是第一页 ")
    private int pageIndex;
    @ApiModelProperty(value="每页显示的记录数，默认是10 ，设置为“-1”表示不进行分页（分页无效）")
    private int pageSize;

    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value="机器人编号")
    private String robotCode;
    @ApiModelProperty(value="aopp编号")
    private String appCode;
    @ApiModelProperty(value="app操作事件")
    private String appEvent;
    @ApiModelProperty(value="坐标x位置")
    private String positionX;
    @ApiModelProperty(value="坐标y位置")
    private String positionY;
    @ApiModelProperty(value="坐标x1位置")
    private String positionX1;
    @ApiModelProperty(value="坐标y1位置")
    private String positionY1;



}
