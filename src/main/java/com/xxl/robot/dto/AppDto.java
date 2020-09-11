package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Api(tags="app用户行为类")
@Data
public class AppDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="全局清除")
    private String clear;
    @ApiModelProperty(value="分类")
    private String category;
    @ApiModelProperty(value="动作前清除")
    private String eventClear;
    @ApiModelProperty(value="动作")
    private String event;
    @ApiModelProperty(value="动作-看广告")
    private String eventAdvert;
    @ApiModelProperty(value="动作-点攒")
    private String eventGiveUP;
    @ApiModelProperty(value="动作-步骤（点击视频，阅读新闻，阅读小说）")
    private String eventStep;
    @ApiModelProperty(value="动作-步骤1")
    private String eventStep1;
    @ApiModelProperty(value="动作-步骤2")
    private String eventStep2;
    @ApiModelProperty(value="动作-返回")
    private String eventBack;
    @ApiModelProperty(value="动作-返回1")
    private String eventBack1;
    @ApiModelProperty(value="动作-返回2")
    private String eventBack2;

    @ApiModelProperty(value="向上/向下")
    private int upDown = 0;

    @ApiModelProperty(value="向左/向右｛1-向左，2-向右｝")
    private int leftRight = 0;

}
