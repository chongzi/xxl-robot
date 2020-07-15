package com.xxl.robot.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Api(tags="微信实体类")
@Data
@Entity
@Table(name="robot_wechart")
public class RobotWechart {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @Id
    private Long id;
    @ApiModelProperty(value="机器人编号")
    private String robotCode;
    @ApiModelProperty(value="内容")
    private String content;
    @ApiModelProperty(value="开关")
    private Byte enabled;
    @ApiModelProperty(value="会话时间")
    private Date createDate;
    @ApiModelProperty(value="更新时间")
    private Date updateDate;


}
