package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Api(tags="app用户行为类")
@Data
public class AppDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="用户操作方式")
    private String operate;

    @ApiModelProperty(value="全局清除")
    private String clear;
    @ApiModelProperty(value="分类")
    private String category;

    @ApiModelProperty(value="事件前清除")
    private String eventClear;
    @ApiModelProperty(value="事件")
    private String event;
    @ApiModelProperty(value="事件类型（0-普通点击，1-上下滑动点击《带有多次点击和返回》，2-左右滑动点击《带有多次点击和返回》" +
            "，3-上下滑动(速度快，不带有点击和返回)，4-左右滑动（速度快，不带有点击和返回））")
    private Integer eventType;

    @ApiModelProperty(value="辅助-点攒")
    private String eventGiveUP;

    @ApiModelProperty(value="事件-点击")
    private String eventStep;
    @ApiModelProperty(value="事件-点击1")
    private String eventStep1;
    @ApiModelProperty(value="事件-点击2")
    private String eventStep2;
    @ApiModelProperty(value="事件-点击3")
    private String eventStep3;
    @ApiModelProperty(value="事件-点击4")
    private String eventStep4;
    @ApiModelProperty(value="事件-点击5")
    private String eventStep5;

//说明-批量上下滑动行为
    @ApiModelProperty(value="事件-上下滑动-点击")//看视频，看新闻用的多
    private String eventUpDownStep;
    @ApiModelProperty(value="事件-上下滑动-点击1")//看视频，看新闻用的多
    private String eventUpDownStep1;
    @ApiModelProperty(value="事件-上下滑动-点击2")//看视频，看新闻用的多
    private String eventUpDownStep2;
    @ApiModelProperty(value="事件-上下滑动-返回")//看视频，看新闻用的多
    private String eventUpDownBack;
    @ApiModelProperty(value="事件-上下滑动-返回1")//看视频，看新闻用的多
    private String eventUpDownBack1;
    @ApiModelProperty(value="事件-上下滑动-返回2")//看视频，看新闻用的多
    private String eventUpDownBack2;

//说明-2.左右滑动行为
    @ApiModelProperty(value="事件-上下滑动-点击")//看视频，看新闻用的多
    private String eventLeftRightStep;
    @ApiModelProperty(value="事件-上下滑动-点击1")//看视频，看新闻用的多
    private String eventLeftRightStep1;
    @ApiModelProperty(value="事件-上下滑动-点击2")//看视频，看新闻用的多
    private String eventLeftRightStep2;
    @ApiModelProperty(value="事件-上下滑动-返回")//看视频，看新闻用的多
    private String eventLeftRightBack;
    @ApiModelProperty(value="事件-上下滑动-返回1")//看视频，看新闻用的多
    private String eventLeftRightBack1;
    @ApiModelProperty(value="事件-上下滑动-返回2")//看视频，看新闻用的多
    private String eventLeftRightBack2;

//说明-3.上下滑动不带有点击和返回
    @ApiModelProperty(value="事件-上下滑动不带有点击和返回")//看视频，看新闻用的多
    private String eventFastUpDown;

//说明-4.上下滑动不带有点击和返回
    @ApiModelProperty(value="事件-左右滑动不带有点击和返回")//看视频，看新闻用的多
    private String eventFastLeftRight;



    @ApiModelProperty(value="动作-看广告前点击")
    private String eventAdvertStep;
    @ApiModelProperty(value="动作-看广告额外时间")
    private Integer eventAdvertDelay;
    @ApiModelProperty(value="动作-看广告")
    private String eventAdvert;

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
