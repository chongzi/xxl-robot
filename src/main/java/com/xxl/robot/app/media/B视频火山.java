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
public class B视频火山 {
    private static Logger log = LoggerFactory.getLogger(B视频火山.class);

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
            case AppConstants.SLEEP://睡觉
                handle3(robot, robotCode, appCode, event, phoneCodeDtos);
                break;
            case AppConstants.WALK://走路
                handle4(robot, robotCode, appCode, event, phoneCodeDtos);
                break;
            case AppConstants.WATCH_ADVERT://看广告
                handle5(robot, robotCode, appCode, event, phoneCodeDtos);
                break;
            case AppConstants.GROW://种菜
                handle6(robot, robotCode, appCode, event, phoneCodeDtos);
                break;
            case AppConstants.TREASURE://开宝箱
                handle7(robot, robotCode, appCode, event, phoneCodeDtos);
                break;
        }

    }

    /**
     * todo 1.签到
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle1(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        log.info("1.动作");
        String operate1 = "B视频火山-签到";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try{
            log.info("4.步骤-1");
            PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包")).findAny().orElse(null);
            String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
            MouseTools.normalEvent(robot,operate);
            MouseTools.normalEvent(robot,AdbTools.downPage());

            PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-签到-看视频")).findAny().orElse(null);
            String operate2 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
            MouseTools.normalEvent(robot,operate2);
            robot.delay(36000);

       }catch (Exception e){}

        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);

        log.info("6.步骤-退出");
        String operateQuit = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateQuit);
    }


    /**
     * todo 2.看视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle2(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){

        log.info("1.动作");
        String operate1 = "B视频火山-看视频";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);

            int i = RandomTools.init(20);
            int c = RandomTools.init(20);
            int re = RandomTools.init(10000);
            for (int a = 0; a < i; a++) {
                robot.delay(re);
                MouseTools.normalEvent(robot, AdbTools.downPage());

                if (a == c) {
                    robot.delay(re);
                    MouseTools.normalEvent(robot, AdbTools.upPage());
                }
                if (a == c + 1) {
                    robot.delay(re);
                    PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-点攒")).findAny().orElse(null);
                    String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
                    MouseTools.normalEvent(robot, operate42);
                }

            }

        }catch (Exception e){}

        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);

        log.info("6.步骤-退出");
        String operateQuit = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateQuit);

    }


    /**
     * todo 3.睡觉
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle3(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){

        log.info("1.动作");
        String operate1 = "B视频火山-睡觉";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);
            MouseTools.normalEvent(robot, AdbTools.upPage());

            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-睡觉")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);

            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-睡觉-我要睡觉")).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);

            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-睡觉-领取金币")).findAny().orElse(null);
            String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
            MouseTools.normalEvent(robot, operate44);

            LocalTime now = LocalTime.now();
            int hour = now.getHour();
            if (hour < 20) {
                MouseTools.normalEvent(robot, operate43);
                MouseTools.normalEvent(robot, operate43);
            }

        }catch (Exception e){}


        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);

        log.info("6.步骤-退出");
        String operateQuit = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateQuit);

    }


    /**
     * todo 4.走路
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle4(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){

        log.info("1.动作");
        String operate1 = "B视频火山-睡觉";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);


        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);
            MouseTools.normalEvent(robot, AdbTools.upPage());

            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-走路")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);

            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-走路-领金币")).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);
        }catch (Exception e){}

        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);

        log.info("6.步骤-退出");
        String operateQuit = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateQuit);
    }


    /**
     * todo 5.看广告
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle5(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){

        log.info("1.动作");
        String operate1 = "B视频火山-睡觉";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);
            MouseTools.normalEvent(robot, AdbTools.upPage());

            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-看广告")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);
            robot.delay(36000);

        }catch (Exception e){}

        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);

        log.info("6.步骤-退出");
        String operateQuit = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateQuit);


    }


    /**
     * todo 6.种菜
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle6(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){

        log.info("1.动作");
        String operate1 = "B视频火山-种菜";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(),dto41.getPositionY());
            MouseTools.normalEvent(robot,operate41);
            MouseTools.normalEvent(robot,AdbTools.upPage());

            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-种菜")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(),dto42.getPositionY());
            MouseTools.normalEvent(robot,operate1);


            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-种菜-初始化-关闭")).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(),dto43.getPositionY());
            MouseTools.normalEvent(robot,operate43);


            robot.delay(3000);
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-种菜-开宝箱")).findAny().orElse(null);
            String operate44 = AdbTools.tap(dto44.getPositionX(),dto44.getPositionY());
            MouseTools.normalEvent(robot,operate44);
            robot.delay(3000);
            MouseTools.normalEvent(robot,operate44);
            robot.delay(3000);
         }catch (Exception e){}

        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);

        log.info("6.步骤-退出");
        String operateQuit = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateQuit);
    }


    /**
     * todo 7.开宝箱
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle7(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){

        log.info("1.动作");
        String operate1 = "B视频火山-开宝箱";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);

            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-开宝箱")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);
            robot.delay(2000);

            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category红包-开宝箱-看视频")).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);
            robot.delay(36000);

        }catch (Exception e){}


        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);

        log.info("6.步骤-退出");
        String operateQuit = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateQuit);
    }



}
