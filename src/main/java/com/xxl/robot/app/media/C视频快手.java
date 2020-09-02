package com.xxl.robot.app.media;

import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.tools.AdbTools;
import com.xxl.robot.tools.MouseTools;
import com.xxl.robot.tools.RandomTools;
import com.xxl.robot.tools.WindowTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.time.LocalTime;
import java.util.List;

/**
 * todo 抖音视频操作
 * app-视频用户行为操作(签到，看视频，关注，点赞，收藏，评论，开宝箱，种菜，走路)
 */
public class C视频快手 {
    private static Logger log = LoggerFactory.getLogger(C视频快手.class);

    /**
     * todo 1.
     * 以category分类定位，再点击用户行为,用一category下不可多次点击category,否则试为程序运行
     * 传相应的app_code对应的phoneCodeDtos
     */
    public static void handle(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){

        switch (event){
            case AppConstants.CHECK_IN://签到
                handle1(robot, robotCode, appCode, event, phoneCodeDtos);
                break;
            case AppConstants.WATCH_VIDEOS://看视频
                handle2(robot, robotCode, appCode, event, phoneCodeDtos);
                break;
            case AppConstants.WATCH_ADVERT://看广告
                handle3(robot, robotCode, appCode, event, phoneCodeDtos);
                break;
        }

    }

    /**
     * todo 1.签到
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle1(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-去赚钱")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-去赚钱-签到")).findAny().orElse(null);
        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);

        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);
        MouseTools.normalEvent(robot,AdbTools.upPage());

        String operate2 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
        MouseTools.normalEvent(robot,operate2);

        robot.delay(2000);
        String operateData1 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData1);
        MouseTools.normalEvent(robot,operateData1);

        String operateDataHome = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateDataHome);

    }


    /**
     * todo 2.看视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle2(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category发现")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category发现-看视频")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category发现-看视频-关注")).findAny().orElse(null);
        PhoneCodeDto dto3 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category发现-看视频-点攒")).findAny().orElse(null);
        PhoneCodeDto dto4 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category发现-发布")).findAny().orElse(null);
        PhoneCodeDto dto5 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category发现-发布-看视频")).findAny().orElse(null);

        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        int i = RandomTools.init(20);
        int re = RandomTools.init(20000);
        log.info("随机值:{}"+i);
        for(int a=0;a<i;a++){
            robot.delay(re);
            MouseTools.normalEvent(robot,AdbTools.downPage());
            if(a==6){
                robot.delay(re);
                String operate1 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
                MouseTools.normalEvent(robot,operate1);
            }
            if(a==10){
                robot.delay(re);
                MouseTools.normalEvent(robot,AdbTools.upPage());
            }
            if(a==16){
                robot.delay(re);
                String operate3 = AdbTools.tap(dto3.getPositionX(),dto3.getPositionY());
                MouseTools.normalEvent(robot,operate3);
            }

        }

        if(i==12){
            robot.delay(re);
            String operate0 = AdbTools.tap(dto4.getPositionX(),dto4.getPositionY());
            MouseTools.normalEvent(robot,operate0);
            robot.delay(re);
            String operate1 = AdbTools.tap(dto5.getPositionX(),dto5.getPositionY());
            MouseTools.normalEvent(robot,operate1);

            int x = RandomTools.init(6);
            for(int a=0;a<x;x++){
                robot.delay(re);
                MouseTools.normalEvent(robot,AdbTools.downPage());
                if(a==5){
                    robot.delay(re);
                    MouseTools.normalEvent(robot,AdbTools.upPage());
                }
            }

            String operateData1 = "adb shell input keyevent BACK";
            MouseTools.normalEvent(robot,operateData1);
            MouseTools.normalEvent(robot,operateData1);

        }

        String operateDataHome = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateDataHome);

    }




    /**
     * todo 5.看广告
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle3(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-去赚钱")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-去赚钱-看广告")).findAny().orElse(null);
        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);

        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);
        MouseTools.normalEvent(robot,AdbTools.upPage());

        for(int i=0;i<10;i++) {
            robot.delay(1000);
            String operate2 = AdbTools.tap(dto2.getPositionX(), dto2.getPositionY());
            MouseTools.normalEvent(robot, operate2);
            robot.delay(18000);
            String operateData1 = "adb shell input keyevent BACK";
            MouseTools.normalEvent(robot, operateData1);
        }

        String operateDataHome = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateDataHome);

    }



}
