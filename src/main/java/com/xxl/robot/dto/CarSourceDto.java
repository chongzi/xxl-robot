package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Api(tags="汽车数据源实体类")
@Data
public class CarSourceDto {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="当前页码，默认是第一页 ")
    private int pageIndex;
    @ApiModelProperty(value="每页显示的记录数，默认是10 ，设置为“-1”表示不进行分页（分页无效）")
    private int pageSize;

    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value="机器人编号")
    private String robotCode;
    @ApiModelProperty(value="状态(0-新增，1-接单中, 2-已接单，3-已过期，4-已取消)")
    private Byte stated;
    @ApiModelProperty(value="类型(0-人找车，1-车找人)")
    private Byte rentType;
    @ApiModelProperty(value="出发时间")
    private String startTime;
    @ApiModelProperty(value="从哪里面出发")
    private String toPlace;
    @ApiModelProperty(value="到哪里去")
    private String fromPlace;
    @ApiModelProperty(value="手机号")
    private String mobile;
    @ApiModelProperty(value="人数（可带几人或几人需坐车）")
    private Integer personNumber;
    @ApiModelProperty(value="原始数据")
    private String basicData;
    @ApiModelProperty(value="创建时间")
    private Date createDate;
    @ApiModelProperty(value="备注")
    private String remark;
    @ApiModelProperty(value="人找车数量")
    private Integer count0;
    @ApiModelProperty(value="车找人数量")
    private Integer count1;
    @ApiModelProperty(value="总数")
    private Integer totalNum;
    @ApiModelProperty(value="智能数量")
    private Integer robotNum;
    @ApiModelProperty(value="租户")
    private Long tenantCode;



}
