package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


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
	@ApiModelProperty(value="机器人编号", required=true)
	private String robotCode;
	@ApiModelProperty(value="种类编码值")
	private String cron;
	@ApiModelProperty(value="操作方式（0-QQ数据采集，1-QQ自动发送，2-QQ群、好友添加 ，3-微信采集，4-微信自动发送，5-微信添加）")
	private Byte operateType;
	@ApiModelProperty(value="登录账号(如网站登录名,QQ或微信登录账号）")
	private String account;
	@ApiModelProperty(value="密码")
	private String pwd;
	@ApiModelProperty(value="工具地址(网站地址,QQ或微信安装目录bin)")
	private String url;
	@ApiModelProperty(value="是否启用（0-启用，1-禁用）", required=true)
	private Byte enabled;
	@ApiModelProperty(value="备注")
	private String remark;
	@ApiModelProperty(value="创建时间")
	private Date createDate;
 

}
