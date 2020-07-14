package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Api(tags="机器人表实体类")
@Data
public class RobotInfoDto {
	@ApiModelProperty(value="当前页码，默认是第一页 ")
	private int pageIndex;
	@ApiModelProperty(value="每页显示的记录数，默认是10 ，设置为“-1”表示不进行分页（分页无效）")
	private int pageSize;

	@ApiModelProperty(value = "主键ID")
	private Long id;
	@ApiModelProperty(value="机器人编号", required=true)
	private String robotCode;
	@ApiModelProperty(value="主机ip", required=true)
	private String host;
	@ApiModelProperty(value="服务类型")
	private String serviceType;
	@ApiModelProperty(value="机器人名称")
	private String name;
	@ApiModelProperty(value="机器人配置", required=true)
	private String deploy;
	@ApiModelProperty(value="排名")
	private int ranking;
	@ApiModelProperty(value="区域", required=true)
	private String region;
	@ApiModelProperty(value="开关(0-启用/1-禁用)", required=true)
	private Byte enabled;
	@ApiModelProperty(value="创建时间")
	private Date createDate;
	@ApiModelProperty(value="租户")
	private Long tenantCode;


}
