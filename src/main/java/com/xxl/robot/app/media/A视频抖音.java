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
public class A视频抖音 {
    private static Logger log = LoggerFactory.getLogger(A视频抖音.class);

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
            case AppConstants.WATCH_NOVELS://看小说
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
        String operate1 = "A视频抖音-签到";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        log.info("3.清除");
        PhoneCodeDto dto3 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-青少年模式")).findAny().orElse(null);
        String operate3 = AdbTools.tap(dto3.getPositionX(),dto3.getPositionY());
        MouseTools.normalEvent(robot,operate3);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);
            MouseTools.normalEvent(robot, AdbTools.downPage());
            MouseTools.normalEvent(robot, AdbTools.downPage());

            log.info("4.步骤-2");
            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-签到")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);

            log.info("4.步骤-3");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-签到-看视频")).findAny().orElse(null);
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


    /**
     * todo 2.看视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle2(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        log.info("1.动作");
        String operate1 = "A视频抖音-看视频";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);

            log.info("4.步骤-2");
            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-点攒")).findAny().orElse(null);
            int i = RandomTools.init(10);
            int y = RandomTools.init(10);
            int re = RandomTools.init(6000);
            for (int a = 0; a < i; a++) {
                robot.delay(re);
                MouseTools.normalEvent(robot, AdbTools.downPage());
                if (a == y) {
                    String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
                    MouseTools.normalEvent(robot, operate42);
                }
                if (a > y) {
                    robot.delay(re);
                    MouseTools.normalEvent(robot, AdbTools.upPage());
                }

            }
        }catch (Exception e){

        }

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
        String operate1 = "A视频抖音-睡觉";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);
            MouseTools.normalEvent(robot, AdbTools.upPage());
            MouseTools.normalEvent(robot, AdbTools.upPage());

            log.info("4.步骤-2");
            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-睡觉赚金币")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);

            log.info("4.步骤-3");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-睡觉赚金币-我要睡觉")).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);

            log.info("4.步骤-4");
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-睡觉赚金币-领取金币")).findAny().orElse(null);
            String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
            MouseTools.normalEvent(robot, operate44);

            LocalTime now = LocalTime.now();
            int hour = now.getHour();
            if (hour < 20) {
                robot.delay(RandomTools.init(1000));
                MouseTools.normalEvent(robot, operate43);
            }
        }catch (Exception e){}

        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
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
        String operate1 = "A视频抖音-走路";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);
            MouseTools.normalEvent(robot, AdbTools.upPage());

            log.info("4.步骤-2");
            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-走路")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);

            log.info("4.步骤-3");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-走路-领取金币")).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);
        }catch (Exception e){}

        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
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
        String operate1 = "A视频抖音-看广告";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);
            MouseTools.normalEvent(robot, AdbTools.upPage());
            MouseTools.normalEvent(robot, AdbTools.upPage());

            log.info("4.步骤-2");
            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-看广告")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);
            robot.delay(36000);
        }catch (Exception e){}

        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);

        log.info("6.步骤-退出");
        String operateQuit = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateQuit);
    }


    /**
     * todo 6.看小说
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle6(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        log.info("1.动作");
        String operate1 = "A视频抖音-看小说";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);
            MouseTools.normalEvent(robot, AdbTools.downPage());
            MouseTools.normalEvent(robot, AdbTools.downPage());

            log.info("4.步骤-2");
            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-看小说")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);
            MouseTools.normalEvent(robot, AdbTools.downPage());

            log.info("4.步骤-3");
            PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-看小说-阅读")).findAny().orElse(null);
            String operate2 = AdbTools.tap(dto2.getPositionX(), dto2.getPositionY());
            MouseTools.normalEvent(robot, operate2);
            robot.delay(RandomTools.init(6000));

            log.info("4.步骤-4");
            PhoneCodeDto dto3 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-看小说-阅读-加入书架")).findAny().orElse(null);
            String operate3 = AdbTools.tap(dto2.getPositionX(), dto2.getPositionY());
            MouseTools.normalEvent(robot, operate3);

            int i = RandomTools.init(120);
            int j = RandomTools.init(120);
            for (int a = 0; a < i; a++) {
                robot.delay(RandomTools.init(2000));
                MouseTools.normalEvent(robot, AdbTools.right());
                if (a == j) {
                    robot.delay(RandomTools.init(10000));
                    MouseTools.normalEvent(robot, AdbTools.left());
                }

                if (a == j * 2) {
                    robot.delay(RandomTools.init(2600));
                    MouseTools.normalEvent(robot, AdbTools.left());
                }

                if (a == j + 6) {
                    robot.delay(RandomTools.init(1000));
                    MouseTools.normalEvent(robot, AdbTools.left());
                }

            }
        }catch (Exception e){}

        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
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
        String operate1 = "A视频抖音-开宝箱";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
            String operate = AdbTools.tap(dto.getPositionX(), dto.getPositionY());
            MouseTools.normalEvent(robot, operate);
            MouseTools.normalEvent(robot, AdbTools.downPage());
            MouseTools.normalEvent(robot, AdbTools.downPage());

            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-开宝箱")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);

            log.info("4.步骤-2");
            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-开宝箱-看视频")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);
            robot.delay(36000);
        }catch (Exception e){}

        log.info("5.步骤-返回主界面");
        String operateBackHome = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateBackHome);
        MouseTools.normalEvent(robot,operateBackHome);

        log.info("6.步骤-退出");
        String operateQuit = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateQuit);
    }



}
