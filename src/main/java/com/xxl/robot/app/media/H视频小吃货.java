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
public class H视频小吃货 {
    private static Logger log = LoggerFactory.getLogger(H视频小吃货.class);


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
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-签到")).findAny().orElse(null);
        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        MouseTools.normalEvent(robot,AdbTools.upPage());

        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);
        robot.delay(31000);
        robot.delay(31000);
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
    public static void handle2(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos) {
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-看视频-翻倍")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-关注")).findAny().orElse(null);
        PhoneCodeDto dto3 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-点攒")).findAny().orElse(null);

        String operate = AdbTools.tap(dto.getPositionX(), dto.getPositionY());
        MouseTools.normalEvent(robot, operate);
        int i = RandomTools.init(100);
        int y = RandomTools.init(100);
        int g = RandomTools.init(100);
        int re = RandomTools.init(20000);
        log.info("随机值:{}" + i);
        for (int a = 0; a < i; a++) {
            robot.delay(re);
            MouseTools.normalEvent(robot, AdbTools.downPage());
            if (a == y) {
                robot.delay(re);
                String operate1 = AdbTools.tap(dto2.getPositionX(), dto2.getPositionY());
                MouseTools.normalEvent(robot, operate1);
            }
            if (a > y) {
                robot.delay(re);
                MouseTools.normalEvent(robot, AdbTools.upPage());
            }
            if (a == g) {
                robot.delay(re);
                String operate3 = AdbTools.tap(dto3.getPositionX(), dto3.getPositionY());
                MouseTools.normalEvent(robot, operate3);
            }

            if (a == 16 || a == 32 || a == 49 || a == 64 || a == 78 || a == 83) {
                robot.delay(1000);
                String operate1 = AdbTools.tap(dto1.getPositionX(), dto1.getPositionY());
                MouseTools.normalEvent(robot, operate1);
                robot.delay(3600);
                String operateData1 = "adb shell input keyevent BACK";
                MouseTools.normalEvent(robot, operateData1);
                MouseTools.normalEvent(robot, operateData1);
            }

        }

        String operateData1 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot, operateData1);

        String operateDataHome = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateDataHome);

    }



    /**
     * todo 5.看广告 2小时一次5000金币相当于0.05元
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle5(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-看广告")).findAny().orElse(null);
        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);

        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);
        robot.delay(36000);
        robot.delay(36000);
        String operateData1 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData1);
        MouseTools.normalEvent(robot,operateData1);

        String operateDataHome = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateDataHome);


    }



    /**
     * todo 6.拆红包
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle7(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        WindowTools.initWindowApp(robot,phoneCodeDtos);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币")).findAny().orElse(null);
        PhoneCodeDto dto3 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币1")).findAny().orElse(null);
        PhoneCodeDto dto4 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币2")).findAny().orElse(null);
        PhoneCodeDto dto5 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币3")).findAny().orElse(null);
        PhoneCodeDto dto6 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币4")).findAny().orElse(null);
        PhoneCodeDto dto7 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币5")).findAny().orElse(null);
        PhoneCodeDto dto8 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币6")).findAny().orElse(null);
        PhoneCodeDto dto9 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币7")).findAny().orElse(null);
        PhoneCodeDto dto10 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-拆红包-零金币8")).findAny().orElse(null);

        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        robot.delay(1000);
        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);

        robot.delay(4000);
        String operate2 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
        MouseTools.normalEvent(robot,operate2);
        String operateData1 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData1);
        robot.delay(1000);

        robot.delay(4000);
        String operate3 = AdbTools.tap(dto3.getPositionX(),dto3.getPositionY());
        MouseTools.normalEvent(robot,operate3);
        MouseTools.normalEvent(robot,operateData1);
        robot.delay(1000);

        robot.delay(4000);
        String operate4 = AdbTools.tap(dto4.getPositionX(),dto4.getPositionY());
        MouseTools.normalEvent(robot,operate4);
        MouseTools.normalEvent(robot,operateData1);
        robot.delay(1000);

        robot.delay(4000);
        String operate5 = AdbTools.tap(dto5.getPositionX(),dto5.getPositionY());
        MouseTools.normalEvent(robot,operate5);
        MouseTools.normalEvent(robot,operateData1);
        robot.delay(1000);

        robot.delay(4000);
        String operate6 = AdbTools.tap(dto6.getPositionX(),dto6.getPositionY());
        MouseTools.normalEvent(robot,operate6);
        MouseTools.normalEvent(robot,operateData1);
        robot.delay(1000);

        robot.delay(4000);
        String operate7 = AdbTools.tap(dto7.getPositionX(),dto7.getPositionY());
        MouseTools.normalEvent(robot,operate7);
        MouseTools.normalEvent(robot,operateData1);
        robot.delay(1000);

        robot.delay(4000);
        String operate8 = AdbTools.tap(dto8.getPositionX(),dto8.getPositionY());
        MouseTools.normalEvent(robot,operate8);
        MouseTools.normalEvent(robot,operateData1);
        robot.delay(1000);


        robot.delay(4000);
        String operate9 = AdbTools.tap(dto9.getPositionX(),dto9.getPositionY());
        MouseTools.normalEvent(robot,operate9);
        MouseTools.normalEvent(robot,operateData1);
        robot.delay(1000);

        robot.delay(4000);
        String operate10 = AdbTools.tap(dto10.getPositionX(),dto10.getPositionY());
        MouseTools.normalEvent(robot,operate10);
        MouseTools.normalEvent(robot,operateData1);
        robot.delay(1000);

        String operateDataHome = "adb shell input keyevent 3";
        MouseTools.normalEvent(robot,operateDataHome);


    }



}
