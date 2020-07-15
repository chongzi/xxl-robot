package com.xxl.robot.controller;

import com.xxl.common.response.BaseResponse;
import com.xxl.robot.time.DynamicSchedule;
import io.swagger.annotations.Api;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping(value = "/time")
@Api(tags = "定时器控制器")
public class TimeController {

    @Resource
    private DynamicSchedule dynamicSchedule;
    //添加定时器
    @RequestMapping("add")
    public BaseResponse add() {

        dynamicSchedule.addTriggerTask("task",
                new TriggerTask(
                        () -> System.out.println("hello"+"0/5 * * * * ? "),
                        new CronTrigger("0/5 * * * * ? ")));//5秒执行一次


        return BaseResponse.newSuccess("ok");
    }


    //删除定时器
    @RequestMapping("del")
    public BaseResponse del() {
        dynamicSchedule.cancelTriggerTask("task");
        return BaseResponse.newSuccess("ok");
    }










}