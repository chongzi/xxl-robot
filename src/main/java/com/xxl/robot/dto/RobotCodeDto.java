package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Api(tags="数据字典编码值定义表实体类")
@Data
public class RobotCodeDto {
	@ApiModelProperty(value="当前页码，默认是第一页 ")
	private int pageIndex;
	@ApiModelProperty(value="每页显示的记录数，默认是10 ，设置为“-1”表示不进行分页（分页无效）")
	private int pageSize;

	@ApiModelProperty(value = "主键ID")
	private Long id;
	@ApiModelProperty(value="编码值", required=true)
	private String code;
	@ApiModelProperty(value="编码类型", required=true)
	private String codeType;
	@ApiModelProperty(value="编码名")
	private String name;
	@ApiModelProperty(value="顺序号")
	private Byte seq;
	@ApiModelProperty(value="是否启用（0-启用，1-禁用）", required=true)
	private Byte enabled;
	@ApiModelProperty(value="备注")
	private String remark;
	@ApiModelProperty(value="创建时间")
	private Date createDate;


}
