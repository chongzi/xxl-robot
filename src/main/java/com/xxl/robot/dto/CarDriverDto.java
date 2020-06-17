package com.xxl.robot.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Api(tags="司机表实体类")
@Data
public class CarDriverDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="当前页码，默认是第一页 ")
    private int pageIndex;
    @ApiModelProperty(value="每页显示的记录数，默认是10 ，设置为“-1”表示不进行分页（分页无效）")
    private int pageSize;

    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value="编码值名称")
    private String name;
    @ApiModelProperty(value="手机号")
    private String mobile;
    @ApiModelProperty(value="司机类型")
    private Byte driverType;
    @ApiModelProperty(value="户籍")
    private String censusRegister;
    @ApiModelProperty(value="常住地址")
    private String address;
    @ApiModelProperty(value="是否启用（0-启用，1-禁用）")
    private Byte enabled;
    @ApiModelProperty(value="备注")
    private String remark;
    @ApiModelProperty(value="创建时间")
    private Date createTime;


}
