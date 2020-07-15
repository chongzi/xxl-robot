package com.xxl.robot.time;

import com.xxl.robot.dto.RobotInfoDto;
import com.xxl.robot.dto.RobotPlanDto;
import com.xxl.robot.service.RobotInfoService;
import com.xxl.robot.service.RobotPlanService;
import com.xxl.robot.tools.HostTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @see @Order注解的执行优先级是按value值从小到大顺序。
 * 项目启动完毕后开启需要自启的任务
 */
@Component
@Order(value = 1)
public class InitSchedule implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitSchedule.class);

    @Autowired
    private RobotInfoService robotInfoService;
    @Autowired
    private RobotPlanService robotPlanService;
    /**
     * 程序启动完毕后,需要自启的任务
     */
    
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LOGGER.info(" >>>>>> 项目启动完毕, 开启 => 需要自启的任务 开始!");
        RobotInfoDto robotInfoDto = new RobotInfoDto();
        robotInfoDto.setHost(HostTools.getHost());
        RobotInfoDto robotInfo = robotInfoService.selectByUnique(robotInfoDto);
        RobotPlanDto robotPlanDto = new RobotPlanDto();
        robotPlanDto.setEnabled((byte) 0);
        if(null!=robotInfo){
            robotPlanDto.setRobotCode(robotInfo.getRobotCode());
        }
        List<RobotPlanDto> dtos = robotPlanService.list(robotPlanDto);

        try {
            dtos.forEach((entity)->{
                robotPlanService.handleTask("update",entity);
            });

        }catch (Exception e){
            LOGGER.info("**********************定时器执行出现异常:{}*********************"+e.toString());
        }
        LOGGER.info(" >>>>>> 项目启动完毕, 开启 => 需要自启的任务 结束！");
    }
}