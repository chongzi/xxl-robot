package com.xxl.robot.controller;

import jdk.nashorn.internal.objects.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/endpoint")
public class WebSocketController {

    @Autowired
    public SimpMessagingTemplate template;


    @MessageMapping("/subscribe")
    @SendTo("/topic/notice")//config中配置的订阅前缀记得要加上
    public void subscribe() {
        while(true){
            System.out.println("******************websocket数据发送********************************");
            //广播使用convertAndSend方法，第一个参数为目的地，和js中订阅的目的地要一致
            template.convertAndSend("/topic/notice", "测试数据");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}