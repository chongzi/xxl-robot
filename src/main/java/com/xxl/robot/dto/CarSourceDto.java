package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Api(tags="汽车数据源实体类")
@Data
public class CarSourceDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value="类型(0-人找车，1-车找人)")
    private Byte type;
    @ApiModelProperty(value="出发时间")
    private String startTime;
    @ApiModelProperty(value="从哪里面出发")
    private String to;
    @ApiModelProperty(value="到哪里去")
    private String from;
    @ApiModelProperty(value="手机号")
    private String mobile;
    @ApiModelProperty(value="是否有效（0-有效，1-无效）")
    private Byte enabled;
    @ApiModelProperty(value="创建时间")
    private String createDate;

}
