package com.xxl.robot.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Api(tags="智能配置实体类")
@Data
@Entity
@Table(name="robot_config")
public class RobotConfig {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @Id
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
