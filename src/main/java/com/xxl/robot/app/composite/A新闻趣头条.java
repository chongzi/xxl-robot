package com.xxl.robot.app.composite;

import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.AppDto;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.tools.AppUserTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * todo A新闻趣头条操作
 * app-用户行为操作(签到，看视频，关注，点赞，收藏，评论，开宝箱，种菜，走路)
 */
public class A新闻趣头条 {
    private static Logger log = LoggerFactory.getLogger(A新闻趣头条.class);

    /**
     * todo 1.
     * 以category分类定位，再点击用户行为,用一category下不可多次点击category,否则试为程序运行
     * 传相应的app_code对应的phoneCodeDtos
     */
    public static void handle(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        List<AppDto> apps = new ArrayList<>();
        switch (event){
            case AppConstants.CHECK_IN://签到
                handle1(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.WATCH_VIDEOS://看视频（看视频，看广告-点攒）
                handle2(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.WATCH_VIDEOS_SMALL://看视频（看视频，看广告-点攒）
                handle3(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.WATCH_NEWS://看新闻
                handle4(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.WATCH_NOVELS://看小说
                handle5(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.WATCH_ADVERT://看广告
                handle6(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.PALY_GAMES://玩游戏
                handle7(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.GIFT_MONEY://领红包
                handle8(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.TREASURE://开宝箱
                handle9(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.DRAW://抽奖
                handle10(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.SLEEP://睡觉
                handle11(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.WALK://走路
                handle12(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.DRINK_WATER://喝水
                handle13(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.CHARGE://充电
                handle14(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.MUSIC://听歌曲
                handle15(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.EAT://吃饭
                handle16(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.SHARE://分享
                handle17(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
            case AppConstants.MONEY_TREE://摇钱树
                handle18(robot, robotCode, appCode, event, phoneCodeDtos, apps);
                break;
        }

    }

    /**
     * todo 1.签到
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle1(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){
        AppDto app = new AppDto();
        app.setCategory("category任务");
        app.setEvent("category任务-签到");
        app.setEventAdvert("category任务-签到-advert");
        app.setUpDown(0);
        apps.add(app);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, apps);
    }


    /**
     * todo 2.看视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle2(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){
        AppDto app = new AppDto();
        app.setCategory("category小视频");
        app.setEvent("category小视频-看视频");
        app.setEventGiveUP("category小视频-看视频-giveup");
        app.setUpDown(0);
        apps.add(app);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, apps);

    }


    /**
     * todo 3.看小视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle3(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){

    }


    /**
     * todo 4.看新闻
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle4(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){
        AppDto app = new AppDto();
        app.setCategory("category头条");
        app.setEvent("category头条-看新闻");
        app.setEventStep("category头条-看新闻-step");
        app.setUpDown(0);
        apps.add(app);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, apps);
    }


    /**
     * todo 5.看小说
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle5(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){
        AppDto app = new AppDto();
        app.setCategory("category我的");
        app.setEvent("category我的-看小说");
        app.setEventStep("category我的-看小说-step");
        app.setUpDown(0);
        apps.add(app);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, apps);
    }


    /**
     * todo 6.看广告
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle6(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){
        AppDto app = new AppDto();
        app.setCategory("category任务");
        app.setEvent("category任务-看广告");
        app.setEventAdvert("category任务-看广告-advert");
        app.setUpDown(0);
        apps.add(app);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, apps);
    }

    /**
     * todo 7.玩游戏
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle7(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){

    }


    /**
     * todo 8.领红包(操作流程：1-点击红包，2-看广告)
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle8(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){
        AppDto app = new AppDto();
        app.setCategory("category头条");
        app.setEvent("category头条-领红包");
        app.setEventAdvert("category头条-领红包-advert");
        apps.add(app);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, apps);
    }




    /**
     * todo 9.开宝箱
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle9(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){
        AppDto app = new AppDto();
        app.setCategory("category任务");
        app.setEvent("category任务-开宝箱");
        app.setEventAdvert("category任务-开宝箱-advert");
        app.setUpDown(0);
        apps.add(app);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, apps);
    }


    /**
     * todo 10.抽奖
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle10(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){
        AppDto app = new AppDto();
        app.setCategory("category我的");
        app.setEvent("category我的-抽奖");
        app.setEventAdvert("category我的-抽奖-advert");
        app.setUpDown(0);
        apps.add(app);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, apps);
    }


    /**
     * todo 11.睡觉
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle11(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){
        AppDto app = new AppDto();
        app.setCategory("category任务");
        app.setEvent("category任务-睡觉");
        app.setEventStep("category任务-睡觉-step");
        app.setEventStep1("category任务-睡觉-step1");
        app.setUpDown(0);
        apps.add(app);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, apps);
    }

    /**
     * todo 12.走路
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle12(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){
        AppDto app = new AppDto();
        app.setCategory("category任务");
        app.setEvent("category任务-走路");
        app.setEventStep("category任务-走路-step");
        app.setUpDown(0);
        apps.add(app);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, apps);
    }


    /**
     * todo 13.喝水
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle13(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){

    }


    /**
     * todo 14.充电
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle14(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){

    }

    /**
     * todo 15.听歌曲
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle15(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){

    }

    /**
     * todo 16.吃饭
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle16(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){

    }

    /**
     * todo 17.分享
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle17(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){

    }

    /**
     * todo 18.摇钱树
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle18(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,List<AppDto> apps){

    }



}
