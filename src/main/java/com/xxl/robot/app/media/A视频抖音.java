package com.xxl.robot.app.media;

import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.tools.AdbTools;
import com.xxl.robot.tools.MouseTools;
import com.xxl.robot.tools.RandomTools;
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
        String operateData = "A视频抖音-签到";
        MouseTools.normalEvent(robot,operateData);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-签到")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-签到-看视频")).findAny().orElse(null);
        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        MouseTools.normalEvent(robot,AdbTools.downPage());

        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);

        robot.delay(RandomTools.init(1000));
        String operate2 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
        MouseTools.normalEvent(robot,operate2);
        robot.delay(31000);
        String operateData1 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData1);
        MouseTools.normalEvent(robot,operateData1);

    }


    /**
     * todo 2.看视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle2(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        String operateData = "A视频抖音-看视频";
        MouseTools.normalEvent(robot,operateData);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-看视频")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-关注")).findAny().orElse(null);
        PhoneCodeDto dto3 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-点攒")).findAny().orElse(null);
        PhoneCodeDto dto4 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-发布")).findAny().orElse(null);
        PhoneCodeDto dto5 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-发布-看视频")).findAny().orElse(null);

        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        int i = RandomTools.init(30);
        int y = RandomTools.init(30);
        int re = RandomTools.init(20000);
        log.info("随机值:{}"+i);
        for(int a=0;a<i;a++){
            robot.delay(re);
            MouseTools.normalEvent(robot,AdbTools.downPage());
            if(a==y){
                robot.delay(re);
                String operate1 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
                MouseTools.normalEvent(robot,operate1);
            }
            if(a>y){
                robot.delay(re);
                MouseTools.normalEvent(robot,AdbTools.upPage());
            }
            if(a==16){
                robot.delay(re);
                String operate3 = AdbTools.tap(dto3.getPositionX(),dto3.getPositionY());
                MouseTools.normalEvent(robot,operate3);
            }

        }

        if(i==y){
            robot.delay(re);
            String operate0 = AdbTools.tap(dto4.getPositionX(),dto4.getPositionY());
            MouseTools.normalEvent(robot,operate0);
            robot.delay(re);
            String operate1 = AdbTools.tap(dto5.getPositionX(),dto5.getPositionY());
            MouseTools.normalEvent(robot,operate1);

            int x = RandomTools.init(6);
            int y1 = RandomTools.init(6);
            for(int a=0;a<x;x++){
                robot.delay(re);
                MouseTools.normalEvent(robot,AdbTools.downPage());
                if(a==y1){
                    robot.delay(re);
                    MouseTools.normalEvent(robot,AdbTools.upPage());
                }
            }

            String operateData1 = "adb shell input keyevent BACK";
            MouseTools.normalEvent(robot,operateData1);
            MouseTools.normalEvent(robot,operateData1);

        }



    }


    /**
     * todo 3.睡觉
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle3(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        String operateData = "A视频抖音-睡觉";
        MouseTools.normalEvent(robot,operateData);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-睡觉赚金币")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-睡觉赚金币-我要睡觉")).findAny().orElse(null);
        PhoneCodeDto dto3 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-睡觉赚金币-领取金币")).findAny().orElse(null);
        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        MouseTools.normalEvent(robot,AdbTools.upPage());
        robot.delay(RandomTools.init(1000));
        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);

        robot.delay(RandomTools.init(1000));
        String operate2 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
        MouseTools.normalEvent(robot,operate2);
        robot.delay(RandomTools.init(1000));
        String operate3 = AdbTools.tap(dto3.getPositionX(),dto3.getPositionY());
        MouseTools.normalEvent(robot,operate3);

        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        if(hour<20){
            robot.delay(RandomTools.init(1000));
            MouseTools.normalEvent(robot,operate3);
        }


        String operateData1 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData1);
        String operateData2 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData2);

    }


    /**
     * todo 4.走路
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle4(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        String operateData = "A视频抖音-走路";
        MouseTools.normalEvent(robot,operateData);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-走路")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-走路-领取金币")).findAny().orElse(null);
        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        MouseTools.normalEvent(robot,AdbTools.upPage());
        int time = RandomTools.init(1000);
        robot.delay(time);
        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);
        int time1 = RandomTools.init(1000);
        robot.delay(time1);
        String operate2 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
        MouseTools.normalEvent(robot,operate2);

        String operateData1 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData1);
        String operateData2 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData2);


    }


    /**
     * todo 5.看广告
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle5(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        String operateData = "A视频抖音-看广告";
        MouseTools.normalEvent(robot,operateData);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-看广告")).findAny().orElse(null);
        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        MouseTools.normalEvent(robot,AdbTools.upPage());
        MouseTools.normalEvent(robot,AdbTools.upPage());
        int time = RandomTools.init(1000);
        robot.delay(time);
        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);
        robot.delay(36000);

        String operateData1 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData1);
        MouseTools.normalEvent(robot,operateData1);


    }


    /**
     * todo 6.看小说
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle6(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        String operateData = "A视频抖音-看小说";
        MouseTools.normalEvent(robot,operateData);
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-看小说")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-看小说-阅读")).findAny().orElse(null);
        PhoneCodeDto dto3 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-看小说-阅读-加入书架")).findAny().orElse(null);
        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        MouseTools.normalEvent(robot,AdbTools.upPage());
        MouseTools.normalEvent(robot,AdbTools.upPage());

        robot.delay(RandomTools.init(1000));
        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);

        MouseTools.normalEvent(robot,AdbTools.downPage());
        robot.delay(RandomTools.init(2000));
        String operate2 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
        MouseTools.normalEvent(robot,operate2);

        robot.delay(RandomTools.init(6000));
        String operate3 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
        MouseTools.normalEvent(robot,operate3);

        int i = RandomTools.init(30);
        int j = RandomTools.init(30);
        for(int a=0;a<i;a++){
            robot.delay(RandomTools.init(20000));
            MouseTools.normalEvent(robot,AdbTools.right());
            if(a==j){
                robot.delay(RandomTools.init(10000));
                MouseTools.normalEvent(robot,AdbTools.left());
            }

            if(a==j*2){
                robot.delay(RandomTools.init(2600));
                MouseTools.normalEvent(robot,AdbTools.left());
            }

            if(a==j+6){
                robot.delay(RandomTools.init(1000));
                MouseTools.normalEvent(robot,AdbTools.left());
            }

        }

        String operateData1 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData1);
        String operate4 = AdbTools.tap(dto3.getPositionX(),dto3.getPositionY());
        MouseTools.normalEvent(robot,operate4);

        MouseTools.normalEvent(robot,operateData1);
        MouseTools.normalEvent(robot,operateData1);
        MouseTools.normalEvent(robot,operateData1);



    }


    /**
     * todo 7.开宝箱
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle7(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        String operateData = "A视频抖音-开宝箱";
        MouseTools.normalEvent(robot,operateData);

        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-开宝箱")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category来赚钱-开宝箱-看视频")).findAny().orElse(null);
        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        MouseTools.normalEvent(robot,AdbTools.downPage());
        MouseTools.normalEvent(robot,AdbTools.downPage());

        int time1 = RandomTools.init(2000);
        robot.delay(time1);
        String operate1 = AdbTools.tap(dto1.getPositionX(),dto1.getPositionY());
        MouseTools.normalEvent(robot,operate1);

        int time2 = RandomTools.init(2000);
        robot.delay(time2);
        String operate2 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
        MouseTools.normalEvent(robot,operate2);

        robot.delay(36000);
        String operateData1 = "adb shell input keyevent BACK";
        MouseTools.normalEvent(robot,operateData1);
        MouseTools.normalEvent(robot,operateData1);
    }



}
