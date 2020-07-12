package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Api(tags="执行计划实体类")
@Data
@Entity
public class RobotPlanDto {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="当前页码，默认是第一页 ")
	private int pageIndex;
	@ApiModelProperty(value="每页显示的记录数，默认是10 ，设置为“-1”表示不进行分页（分页无效）")
	private int pageSize;

	@ApiModelProperty(value = "主键ID")
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
