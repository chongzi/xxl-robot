package com.xxl.robot.app.composite;

import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.AppDto;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.tools.AppTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.List;


/**
 * todo A浏览器晴象操作
 * app-用户行为操作(签到，看视频，关注，点赞，收藏，评论，开宝箱，种菜，走路)
 */

public class A浏览器晴象 {
    private static Logger log = LoggerFactory.getLogger(A浏览器晴象.class);

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
                handle83(robot, robotCode, appCode, event, phoneCodeDtos, app);
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
            case AppConstants.CLOCK://打卡
                handle101(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;
            case AppConstants.OTHER_QINGXIANG_WATCH_VIDEOS://看视频
                handle21(robot, robotCode, appCode, event, phoneCodeDtos, app);
                break;


        }

    }


/**
     * todo 1.签到
     * @param robot
     * @param phoneCodeDtos
     */

    public static void handle1(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setOperate(AppConstants.CHECK_IN);
        app.setCategory("category钱包");
        app.setEvent("category钱包-签到");
        app.setEventAdvert("category钱包-签到-advert");
        app.setEventBack("category钱包-签到-back");
        app.setUpDown(0);
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
    }


/**
     * todo 11.签到打卡
     * @param robot
     * @param phoneCodeDtos
     */

    public static void handle101(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setOperate(AppConstants.CHECK_IN);
        app.setCategory("category浏览器");
        app.setEvent("category浏览器-天天爱打卡");
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡");
        app.setEventAdvert("category浏览器-天天爱打卡-advert");
        app.setEventBack("category浏览器-天天爱打卡-back");
        app.setUpDown(0);
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡1");
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡2");
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡3");
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡4");
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
        //中午
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡5");
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡6");
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡7");
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);

        //下午
        app.setUpDown(1);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡9");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡10");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡11");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡12");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡13");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡14");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡15");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡16");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);

        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡17");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡18");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        app.setEventAdvertStep("category浏览器-天天爱打卡-打卡19");
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);


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

    }


/**
     * todo 6.看广告
     * @param robot
     * @param phoneCodeDtos
     */

    public static void handle61(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){

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
        app.setOperate(AppConstants.GIFT_MONEY);
        app.setCategory("category浏览器");
        app.setEvent("category浏览器-红包");
        app.setEventAdvert("category浏览器-红包-advert");
        app.setEventBack("category浏览器-红包-back");
        app.setUpDown(0);
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
    }


/**
     * todo 8.category运动-摇红包(操作流程：1-点击红包，2-看广告)
     * @param robot
     * @param phoneCodeDtos
     */

    public static void handle81(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setOperate(AppConstants.GIFT_MONEY);
        app.setCategory("category浏览器");
        app.setEvent("category浏览器-现金红包");
        app.setEventAdvert("category浏览器-现金红包-advert");
        app.setEventBack("category浏览器-现金红包-back");
        app.setUpDown(0);
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
    }


/**
     * todo 8-摇红包(操作流程：1-点击红包，2-看广告)
     * @param robot
     * @param phoneCodeDtos
     */

    public static void handle82(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setOperate(AppConstants.GIFT_MONEY);
        app.setCategory("category浏览器");
        app.setEvent("category浏览器-现金领取红包");
        app.setEventAdvert("category浏览器-现金领取红包-advert");
        app.setEventBack("category浏览器-现金领取红包-back");
        app.setUpDown(0);
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
    }



/**
     * todo 8-摇红包(操作流程：1-点击红包，2-看广告)
     * @param robot
     * @param phoneCodeDtos
     */

    public static void handle83(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setOperate(AppConstants.GIFT_MONEY);
        app.setCategory("category浏览器");
        app.setEvent("category浏览器-右边领取红包");
        app.setEventAdvert("category浏览器-右边领取红包-advert");
        app.setEventBack("category浏览器-右边领取红包-back");
        app.setUpDown(0);
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
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
        app.setOperate(AppConstants.DRAW);
        app.setCategory("category大转盘");
        app.setEvent("category大转盘-抽奖");
        app.setEventAdvert("category大转盘-抽奖-advert");
        app.setEventBack("category大转盘-抽奖-back");
        app.setUpDown(0);
        AppTools.handle(robot, robotCode,  appCode,  event, phoneCodeDtos, app);
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
        for(int i=0;i<6;i++) {
            app.setEventType(3);
            app.setOperate(AppConstants.SCRATCH_CARD);
            app.setCategory("category刮刮卡");
            app.setEventClear("category刮刮卡-刮卡-clear");
            app.setEvent("category刮刮卡-刮卡-advertstep");
            app.setEventFastUpDown("category刮刮卡-刮卡-advertstep");
            app.setEventAdvert("category刮刮卡-刮卡-advert");
            app.setEventBack("category刮刮卡-刮卡-back");
            app.setUpDown(0);
            AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
        }
    }


/**
     * todo 19.定制化-看视频
     * @param robot
     * @param phoneCodeDtos
     */

    public static void handle21(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos,AppDto app){
        app.setEventType(1);
        app.setOperate(AppConstants.WATCH_VIDEOS);
        app.setCategory("category小视频");
        app.setEvent("category小视频-看视频");
        app.setEventGiveUP("category小视频-看视频-giveup");
        app.setEventBack("category小视频-看视频-back");
        app.setUpDown(0);
        AppTools.handle(robot, robotCode, appCode, event, phoneCodeDtos, app);
    }


}

