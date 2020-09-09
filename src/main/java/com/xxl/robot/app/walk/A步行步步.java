package com.xxl.robot.app.walk;

import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.AppDto;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.tools.AdbTools;
import com.xxl.robot.tools.AppUserTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.List;

/**
 * todo A步行步步操作
 * app-用户行为操作(签到，看视频，关注，点赞，收藏，评论，开宝箱，种菜，走路)
 */
public class A步行步步 {
    private static Logger log = LoggerFactory.getLogger(A步行步步.class);

    /**
     * todo 1.
     * 以category分类定位，再点击用户行为,用一category下不可多次点击category,否则试为程序运行
     * 传相应的app_code对应的phoneCodeDtos
     */
    public static void handle(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        AppDto app = new AppDto();
        switch (event){
            case AppConstants.CHECK_IN://签到
                handle1(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.WATCH_VIDEOS://看视频（看视频，看广告-点攒）
                handle2(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.WATCH_VIDEOS_SMALL://看视频（看视频，看广告-点攒）
                handle3(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.WATCH_NEWS://看新闻
                handle4(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.WATCH_NOVELS://看小说
                handle5(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.WATCH_ADVERT://看广告
                handle6(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.PALY_GAMES://玩游戏
                handle7(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.GIFT_MONEY://领红包
                handle8(robot, robotCode, appCode, event, phoneCodeDtos, app);
                handle81(robot, robotCode, appCode, event, phoneCodeDtos, app);
                handle82(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.TREASURE://开宝箱
                handle9(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.DRAW://抽奖
                handle10(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.SLEEP://睡觉
                handle11(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.WALK://走路
                handle12(robot, robotCode, appCode, event, phoneCodeDtos, app);
                handle121(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.DRINK_WATER://喝水
                handle13(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.CHARGE://充电
                handle14(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.MUSIC://听歌曲
                handle15(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.EAT://吃饭
                handle16(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.SHARE://分享
                handle17(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.MONEY_TREE://摇钱树
                handle18(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.SCRATCH_CARD://刮奖
                handle19(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
        }

    }

    /**
     * todo 1.签到
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle1(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setCategory("category赚赚");
        app.setEvent("category赚赚-签到");
        app.setEventAdvert("category赚赚-签到");
        app.setClear("category全局-清除");
        app.setUpDown(0);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
    }


    /**
     * todo 2.看视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle2(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }


    /**
     * todo 3.看小视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle3(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }


    /**
     * todo 4.看新闻
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle4(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }


    /**
     * todo 5.看小说
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle5(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }


    /**
     * todo 6.看广告
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle6(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setCategory("category赚赚");
        app.setEvent("category赚赚-看广告");
        app.setEventAdvert("category赚赚-看广告-看广告");
        app.setClear("category全局-清除");
        app.setUpDown(0);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
    }

    /**
     * todo 7.玩游戏
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle7(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }


    /**
     * todo 8.领红包(操作流程：1-点击红包，2-看广告)
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle8(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setCategory("category首页");
        app.setEvent("category首页-领红包");
        app.setEventAdvert("category首页-领红包-看广告");
        app.setClear("category全局-清除");
        app.setUpDown(0);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
    }

    /**
     * todo 8.领红包(操作流程：1-点击红包，2-看广告)
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle81(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setCategory("category首页");
        app.setEvent("category首页-领视频红包");
        app.setEventAdvert("category首页-领视频红包-看广告");
        app.setClear("category全局-清除");
        app.setUpDown(0);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
    }

    /**
     * todo 8.领红包(操作流程：1-点击红包，2-看广告)
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle82(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setCategory("category首页");
        app.setEvent("category首页-领每日红包");
        app.setEventAdvert("category首页-领每日红包-看广告");
        app.setClear("category全局-清除");
        app.setUpDown(0);
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);

        app.setEventAdvert("category首页-领每日红包-看广告1");
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
        for(int i=0;i<6;i++){
            AdbTools.left();
            app.setClear("category全局-清除");
            AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
        }

    }



    /**
     * todo 9.开宝箱
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle9(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }


    /**
     * todo 10.抽奖
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle10(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }


    /**
     * todo 11.睡觉
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle11(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }

    /**
     * todo 12.走路
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle12(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setCategory("category首页");
        app.setEvent("category首页-走路步数");
        app.setEventAdvert("category首页-走路步数-看广告");
        app.setUpDown(0);
        app.setClear("category全局-清除");
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
    }

    /**
     * todo 12.走路
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle121(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setCategory("category首页");
        app.setEvent("category首页-走路视频步数");
        app.setEventAdvert("category首页-走路视频步数-看广告");
        app.setUpDown(0);
        app.setClear("category全局-清除");
        AppUserTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
    }


    /**
     * todo 13.喝水
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle13(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }


    /**
     * todo 14.充电
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle14(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }

    /**
     * todo 15.听歌曲
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle15(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }

    /**
     * todo 16.吃饭
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle16(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }

    /**
     * todo 17.分享
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle17(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }

    /**
     * todo 18.摇钱树
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle18(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

    }

    /**
     * todo 19.刮奖
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle19(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        for(int i=0;i<10;i++) {
            app.setCategory("category福利");
            app.setEvent("category福利-刮奖");
            app.setEventStart("category福利-刮奖-start");
            app.setEventStart1("category福利-刮奖-start1");
            app.setUpDown(0);
            AppUserTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        }
    }


}
