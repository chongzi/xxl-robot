package com.xxl.robot.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Api(tags="兼职-代理推广实体类")
@Data
@Entity
@Table(name="parttime_agent")
public class ParttimeAgent {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @Id
    private Long id;
    @ApiModelProperty(value="推广类型")
    private String angentType;
    @ApiModelProperty(value="商家")
    private String business;
    @ApiModelProperty(value="推广链接")
    private String promotionLinks;
    @ApiModelProperty(value="推广语1")
    private String popularize1;
    @ApiModelProperty(value="推广语2")
    private String popularize2;
    @ApiModelProperty(value="推广语3")
    private String popularize3;
    @ApiModelProperty(value="推广语4")
    private String popularize4;
    @ApiModelProperty(value="推广语5")
    private String popularize5;
    @ApiModelProperty(value="推广语6")
    private String popularize6;
    @ApiModelProperty(value="权重")
    private int pr;
    @ApiModelProperty(value="备注")
    private String remark;
    @ApiModelProperty(value="开关")
    private Byte enabled;
    @ApiModelProperty(value="创建时间")
    private Date createDate;


}
