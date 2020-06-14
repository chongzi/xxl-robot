package com.xxl.robot.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Api(tags="司机qq实体类")
@Data
@Entity
@Table(name="car_qq")
public class CarQq {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @Id
    private Long id;
    @ApiModelProperty(value="会话时间")
    private Date sessionTime;
    @ApiModelProperty(value="内容")
    private String content;


}
