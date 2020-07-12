package com.xxl.robot.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Api(tags="执行计划实体类")
@Data
@Entity
@Table(name="robot_plan")
public class RobotPlan {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键ID")
	@Id
	private Long id;
	@ApiModelProperty(value="主机ip", required=true)
	private String host;
	@ApiModelProperty(value="种类")
	private String kind;
	@ApiModelProperty(value="种类编码值")
	private String cron;
	@ApiModelProperty(value="顺序号")
	private Byte operate;
	@ApiModelProperty(value="是否启用（0-启用，1-禁用）", required=true)
	private Byte enabled;
	@ApiModelProperty(value="备注")
	private String remark;


}
