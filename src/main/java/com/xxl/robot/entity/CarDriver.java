package com.xxl.robot.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;

@Api(tags="数据字典编码值定义表实体类")
@Data
@Entity
@Table(name="car_driver")
public class CarDriver {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @Id
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
