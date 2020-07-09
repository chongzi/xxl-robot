package com.xxl.robot.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Api(tags="数据字典编码值定义表实体类")
@Data
@Entity
@Table(name="robot_code")
public class RobotCode {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键ID")
	@Id
	private Long id;
	@ApiModelProperty(value="编码值", required=true)
	private String no;
	@ApiModelProperty(value="编码值名称")
	private String name;
	@ApiModelProperty(value="编码类型", required=true)
	private String codeType;
	@ApiModelProperty(value="顺序号")
	private Byte seq;
	@ApiModelProperty(value="是否启用（0-启用，1-禁用）", required=true)
	private Byte enabled;
	@ApiModelProperty(value="备注")
	private String remark;
	@ApiModelProperty(value="创建时间")
	private Date createDate;
	@ApiModelProperty(value="更新时间")
	private Date updateDate;
}
