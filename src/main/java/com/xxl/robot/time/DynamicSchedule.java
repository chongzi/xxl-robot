package com.xxl.robot.time;

import com.xxl.robot.dto.RobotInfoDto;
import com.xxl.robot.dto.RobotPlanDto;
import com.xxl.robot.entity.RobotInfo;
import com.xxl.robot.service.RobotInfoService;
import com.xxl.robot.service.RobotPlanService;
import com.xxl.robot.tools.HostTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * todo 动态加载数据库执行定时器流程
 *
 *
 */
@Component
public class DynamicSchedule implements SchedulingConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicSchedule.class);

    @Autowired
    private RobotInfoService robotInfoService;
    @Autowired
    private RobotPlanService robotPlanService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        RobotInfoDto robotInfoDto = new RobotInfoDto();
        robotInfoDto.setHost(HostTools.getHost());
        RobotInfoDto robotInfo = robotInfoService.selectByUnique(robotInfoDto);
        RobotPlanDto robotPlanDto = new RobotPlanDto();
        robotPlanDto.setEnabled((byte) 0);
        if(null!=robotInfo){
            robotPlanDto.setRobotCode(robotInfo.getRobotCode());
        }
        List<RobotPlanDto>  dtos = robotPlanService.list(robotPlanDto);

        try {
            dtos.forEach(entity->{
                scheduledTaskRegistrar.addTriggerTask(
                        //1.添加任务内容(Runnable)，可以为方法
                        () ->{
                            LOGGER.info("**************************定时器执行计划*************"+entity.getCron());


                        },
                        //2.设置执行周期(Trigger)
                        triggerContext -> {
                            //2.3 返回执行周期(Date)
                            return new CronTrigger(entity.getCron()).nextExecutionTime(triggerContext);
                        }
                );
            });

        }catch (Exception e){
            LOGGER.info("**********************定时器执行出现异常:{}*********************"+e.toString());
        }
    }

}