package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Api(tags="智能配置实体类")
@Data
public class RobotConfigDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="当前页码，默认是第一页 ")
    private int pageIndex;
    @ApiModelProperty(value="每页显示的记录数，默认是10 ，设置为“-1”表示不进行分页（分页无效）")
    private int pageSize;

    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value="配置编号")
    private String configNo;
    @ApiModelProperty(value="配置名称")
    private String configName;
    @ApiModelProperty(value="启用/禁用")
    private Byte enabled;
    @ApiModelProperty(value="备注")
    private String remark;

}
