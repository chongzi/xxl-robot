package com.xxl.robot.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Api(tags="qq实体类")
@Data
@Entity
@Table(name="robot_qq")
public class RobotQq {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @Id
    private Long id;
    @ApiModelProperty(value="会话时间")
    private Byte sourceType;
    @ApiModelProperty(value="会话时间")
    private String content;
    @ApiModelProperty(value="会话时间")
    private String ips;
    @ApiModelProperty(value="开关")
    private Byte enabled;
    @ApiModelProperty(value="开关")
    private String remark;
    @ApiModelProperty(value="会话时间")
    private Date createDate;
    @ApiModelProperty(value="内容")
    private Date updateDate;



}
