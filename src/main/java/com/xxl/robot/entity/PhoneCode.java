package com.xxl.robot.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Api(tags="手机数据字典实体类")
@Data
@Entity
@Table(name="phone_code")
public class PhoneCode {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @Id
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
