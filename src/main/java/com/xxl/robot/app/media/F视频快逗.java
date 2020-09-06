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
import java.util.List;

/**
 * todo 抖音视频操作
 * app-视频用户行为操作(签到，看视频，关注，点赞，收藏，评论，开宝箱，种菜，走路)
 */
public class F视频快逗 {
    private static Logger log = LoggerFactory.getLogger(F视频快逗.class);

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
                handle5(robot, robotCode, appCode, event, phoneCodeDtos);
                break;
            case AppConstants.GIFT_MONEY://开宝箱
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
        String operate1 = "F视频快逗-签到";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);
            MouseTools.normalEvent(robot, AdbTools.upPage());

            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-签到")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);
            robot.delay(31000);
            robot.delay(31000);

            String operateBackHome = "adb shell input keyevent BACK";
            MouseTools.normalEvent(robot,operateBackHome);
            MouseTools.normalEvent(robot,operateBackHome);
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
    public static void handle2(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos) {
        log.info("1.动作");
        String operate1 = "F视频快逗-看视频";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页")).findAny().orElse(null);
            String operate41= AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);

            int i = RandomTools.init(100);
            int y = RandomTools.init(100);
            int g = RandomTools.init(100);
            int re = RandomTools.init(20000);
            for (int a = 0; a < i; a++) {
                robot.delay(re);
                MouseTools.normalEvent(robot, AdbTools.downPage());
                if (a > y) {
                    robot.delay(re);
                    MouseTools.normalEvent(robot, AdbTools.upPage());
                }
                if (a == g) {
                    robot.delay(re);
                    PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-点攒")).findAny().orElse(null);
                    String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                    MouseTools.normalEvent(robot, operate43);
                }

                if (a == 16 || a == 32 || a == 49 || a == 64 || a == 78 || a == 83) {
                    PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-看视频-翻倍")).findAny().orElse(null);
                    String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                    MouseTools.normalEvent(robot, operate44);
                    robot.delay(3600);
                    String operateBackHome = "adb shell input keyevent BACK";
                    MouseTools.normalEvent(robot,operateBackHome);
                    MouseTools.normalEvent(robot,operateBackHome);
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
     * todo 5.看广告 2小时一次5000金币相当于0.05元
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle5(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){

        log.info("1.动作");
        String operate1 = "F视频快逗-看广告";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);

            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-看广告")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);
            robot.delay(36000);
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
     * todo 6.拆红包
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle7(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){

        log.info("1.动作");
        String operate1 = "F视频快逗-拆红包";
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        try {
            log.info("4.步骤-1");
            PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);

            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包")).findAny().orElse(null);
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);

            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币")).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);

            String operateDataHome = "adb shell input keyevent BACK";
            MouseTools.normalEvent(robot, operateDataHome);

            PhoneCodeDto dto45 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币1")).findAny().orElse(null);
            String operate45 = AdbTools.tap(dto45.getPositionX(), dto45.getPositionY());
            MouseTools.normalEvent(robot, operate45);
            MouseTools.normalEvent(robot, operateDataHome);

            PhoneCodeDto dto46 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币2")).findAny().orElse(null);
            String operate46= AdbTools.tap(dto46.getPositionX(), dto46.getPositionY());
            MouseTools.normalEvent(robot, operate46);
            MouseTools.normalEvent(robot, operateDataHome);

            PhoneCodeDto dto47 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币3")).findAny().orElse(null);
            String operate47 = AdbTools.tap(dto47.getPositionX(), dto47.getPositionY());
            MouseTools.normalEvent(robot, operate47);
            MouseTools.normalEvent(robot, operateDataHome);

            PhoneCodeDto dto48 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币4")).findAny().orElse(null);
            String operate48 = AdbTools.tap(dto48.getPositionX(), dto48.getPositionY());
            MouseTools.normalEvent(robot, operate48);
            MouseTools.normalEvent(robot, operateDataHome);

            PhoneCodeDto dto49 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币5")).findAny().orElse(null);
            String operate49 = AdbTools.tap(dto49.getPositionX(), dto49.getPositionY());
            MouseTools.normalEvent(robot, operate49);
            MouseTools.normalEvent(robot, operateDataHome);

            PhoneCodeDto dto410 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币6")).findAny().orElse(null);
            String operate410 = AdbTools.tap(dto410.getPositionX(), dto410.getPositionY());
            MouseTools.normalEvent(robot, operate410);
            MouseTools.normalEvent(robot, operateDataHome);

            PhoneCodeDto dto411 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币7")).findAny().orElse(null);
            String operate411 = AdbTools.tap(dto411.getPositionX(), dto411.getPositionY());
            MouseTools.normalEvent(robot, operate411);
            MouseTools.normalEvent(robot, operateDataHome);

            PhoneCodeDto dto412 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币8")).findAny().orElse(null);
            String operate412 = AdbTools.tap(dto412.getPositionX(), dto412.getPositionY());
            MouseTools.normalEvent(robot, operate412);
            MouseTools.normalEvent(robot, operateDataHome);

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
