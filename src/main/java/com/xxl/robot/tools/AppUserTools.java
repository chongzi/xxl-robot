package com.xxl.robot.tools;

import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.AppDto;
import com.xxl.robot.dto.PhoneCodeDto;
import net.sf.jsqlparser.expression.StringValue;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.time.LocalTime;
import java.util.List;

/**
 * todo 用户行为操作
 * app-用户行为操作(签到，看视频，关注，点赞，收藏，评论，开宝箱，种菜，走路)
 */
public class AppUserTools {
    private static Logger log = LoggerFactory.getLogger(AppUserTools.class);

    /**
     * todo 总控制
     * 以category分类定位，再点击用户行为,用一category下不可多次点击category,否则试为程序运行
     * 传相应的app_code对应的phoneCodeDtos
     */
    public static void handle(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        log.info("1.动作");
        String operate1 = appCode+"-"+event;
        MouseTools.normalEvent(robot,operate1);

        log.info("2.初始化");
        WindowTools.initWindowApp(robot,phoneCodeDtos);

        log.info("3.清除");
        PhoneCodeDto dto3 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getClear())).findAny().orElse(null);
        if(null!=dto3) {
            String operate3 = AdbTools.tap(dto3.getPositionX(), dto3.getPositionY());
            MouseTools.normalEvent(robot, operate3);
        }

        log.info("4.步骤-分类");
        PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getCategory())).findAny().orElse(null);
        if(null!=dto41) {
            String operate41 = AdbTools.tap(dto41.getPositionX(), dto41.getPositionY());
            MouseTools.normalEvent(robot, operate41);
            if(app.getUpDown()==0) {
                MouseTools.normalEvent(robot, AdbTools.upPage());
                MouseTools.normalEvent(robot, AdbTools.upPage());
            }else{
                MouseTools.normalEvent(robot, AdbTools.downPage());
                MouseTools.normalEvent(robot, AdbTools.downPage());
            }
        }

        log.info("4.步骤-事件");
        PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEvent())).findAny().orElse(null);
        if(null!=dto42) {
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);
        }


        switch (event){
            case AppConstants.CHECK_IN://签到
                handle1(robot, phoneCodeDtos, app);
                break;
            case AppConstants.WATCH_VIDEOS://看视频（看视频，看广告-点攒）
                handle2(robot, phoneCodeDtos, app);
                break;
            case AppConstants.WATCH_VIDEOS_SMALL://看视频（看视频，看广告-点攒）
                handle3(robot, phoneCodeDtos, app);
                break;
            case AppConstants.WATCH_NEWS://看新闻
                handle4(robot, phoneCodeDtos, app);
                break;
            case AppConstants.WATCH_NOVELS://看小说
                handle5(robot, phoneCodeDtos, app);
                break;
            case AppConstants.WATCH_ADVERT://看广告
                handle6(robot, phoneCodeDtos, app);
                break;
            case AppConstants.PALY_GAMES://玩游戏
                handle7(robot, phoneCodeDtos, app);
                break;
            case AppConstants.GIFT_MONEY://领红包
                handle8(robot, phoneCodeDtos, app);
                break;
            case AppConstants.TREASURE://开宝箱
                handle9(robot, phoneCodeDtos, app);
                break;
            case AppConstants.DRAW://抽奖
                handle10(robot,phoneCodeDtos, app);
                break;
            case AppConstants.SLEEP://睡觉
                handle11(robot, phoneCodeDtos, app);
                break;
            case AppConstants.WALK://走路
                handle12(robot, phoneCodeDtos, app);
                break;
            case AppConstants.DRINK_WATER://喝水
                handle13(robot, phoneCodeDtos, app);
                break;
            case AppConstants.CHARGE://充电
                handle14(robot, phoneCodeDtos, app);
                break;
            case AppConstants.MUSIC://听歌曲
                handle15(robot, phoneCodeDtos, app);
                break;
            case AppConstants.EAT://吃饭
                handle16(robot, phoneCodeDtos, app);
                break;
            case AppConstants.SHARE://分享
                handle17(robot, phoneCodeDtos, app);
                break;
            case AppConstants.MONEY_TREE://摇钱树
                handle18(robot, phoneCodeDtos, app);
                break;
            default://back
                handle19(robot, phoneCodeDtos, app);
        }

        PhoneCodeDto dto45 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventBack())).findAny().orElse(null);
        if(null!=dto45) {
            String operate45 = AdbTools.tap(dto45.getPositionX(), dto45.getPositionY());
            MouseTools.normalEvent(robot, operate45);
        }

        PhoneCodeDto dto46 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventBack1())).findAny().orElse(null);
        if(null!=dto46) {
            String operate46 = AdbTools.tap(dto46.getPositionX(), dto46.getPositionY());
            MouseTools.normalEvent(robot, operate46);
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
     * todo 1.签到
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle1(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-看广告");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventAdvert())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
                robot.delay(50000);
            }



        }catch (Exception e){}

    }


    /**
     * todo 2.看视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle2(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            int i = RandomTools.init(20);
            int y = RandomTools.init(20);
            int re = RandomTools.init(6000);
            for (int a = 0; a < i; a++) {
                robot.delay(re);
                MouseTools.normalEvent(robot, AdbTools.downPage());
                if (a == y) {
                    log.info("4.步骤-事件-点攒");
                    PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventGiveUP() )).findAny().orElse(null);
                    String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                    MouseTools.normalEvent(robot, operate43);
                }
                if (a > y) {
                    robot.delay(re);
                    MouseTools.normalEvent(robot, AdbTools.upPage());
                }

            }


        }catch (Exception e){

        }

    }


    /**
     * todo 3.看小视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle3(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            int i = RandomTools.init(20);
            int y = RandomTools.init(20);
            int re = RandomTools.init(6000);
            for (int a = 0; a < i; a++) {
                robot.delay(re);
                log.info("4.步骤-事件-开始执行");
                PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
                if(null!=dto43) {
                    String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                    MouseTools.normalEvent(robot, operate43);
                }

                MouseTools.normalEvent(robot, AdbTools.downPage());
                if (a == y) {
                    log.info("4.步骤-事件-点攒");
                    PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventGiveUP() )).findAny().orElse(null);
                    String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                    MouseTools.normalEvent(robot, operate44);
                }
                if (a > y) {
                    robot.delay(re);
                    MouseTools.normalEvent(robot, AdbTools.upPage());
                }

            }



        }catch (Exception e){

        }

    }


    /**
     * todo 4.看新闻
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle4(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            int i = RandomTools.init(20);
            int y = RandomTools.init(20);
            int re = RandomTools.init(6000);
            for (int a = 0; a < i; a++) {
                robot.delay(re);
                MouseTools.normalEvent(robot, AdbTools.downPage());

                log.info("4.步骤-事件-开始执行");
                PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart() )).findAny().orElse(null);
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);

                if (a == y) {
                    robot.delay(re);
                    MouseTools.normalEvent(robot, AdbTools.upPage());
                }

                String operateBackHome = "adb shell input keyevent BACK";
                MouseTools.normalEvent(robot,operateBackHome);

            }



        }catch (Exception e){}

    }


    /**
     * todo 5.看小说
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle5(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);
            robot.delay(RandomTools.init(6000));

            log.info("4.步骤-事件-开始执行1");
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart1())).findAny().orElse(null);
            String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
            MouseTools.normalEvent(robot, operate44);

            int i = RandomTools.init(60);
            int j = RandomTools.init(60);
            for (int a = 0; a < i; a++) {
                robot.delay(RandomTools.init(1000));
                MouseTools.normalEvent(robot, AdbTools.right());
                if (a == j) {
                    robot.delay(RandomTools.init(6000));
                    MouseTools.normalEvent(robot, AdbTools.left());
                }

                if (a == j * 2) {
                    robot.delay(RandomTools.init(1200));
                    MouseTools.normalEvent(robot, AdbTools.left());
                }

                if (a == j + 6) {
                    robot.delay(RandomTools.init(1000));
                    MouseTools.normalEvent(robot, AdbTools.left());
                }

            }

        }catch (Exception e){}

    }


    /**
     * todo 6.看广告
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle6(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-看广告");
            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventAdvert())).findAny().orElse(null);
            if(null!=dto42) {
                String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
                MouseTools.normalEvent(robot, operate42);
                robot.delay(50000);
            }

        }catch (Exception e){}

    }

    /**
     * todo 7.玩游戏
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle7(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {

        }catch (Exception e){}

    }


    /**
     * todo 8.领红包(操作流程：1-点击红包，2-看广告)
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle8(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-看广告");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventAdvert())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
                robot.delay(50000);
            }

        }catch (Exception e){}

    }




    /**
     * todo 9.开宝箱
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle9(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-看广告");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventAdvert())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
                robot.delay(50000);
            }

        }catch (Exception e){}

    }


    /**
     * todo 10.抽奖
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle10(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-看广告");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventAdvert())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
                robot.delay(50000);
            }

        }catch (Exception e){}

    }


    /**
     * todo 11.睡觉
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle11(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);

            log.info("4.步骤-事件-开始执行1");
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart1())).findAny().orElse(null);
            String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
            MouseTools.normalEvent(robot, operate44);

            LocalTime now = LocalTime.now();
            int hour = now.getHour();
            if (hour < 20) {
                robot.delay(RandomTools.init(1000));
                MouseTools.normalEvent(robot, operate43);
            }

        }catch (Exception e){}

    }

    /**
     * todo 12.走路
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle12(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
            }


            log.info("5.步骤-返回主界面");
            String operateBackHome = "adb shell input keyevent BACK";
            MouseTools.normalEvent(robot,operateBackHome);

            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart1())).findAny().orElse(null);
            if(null!=dto44) {
                String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                MouseTools.normalEvent(robot, operate44);
            }

        }catch (Exception e){}

    }


    /**
     * todo 13.喝水
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle13(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
            }

        }catch (Exception e){}

    }


    /**
     * todo 14.充电
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle14(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
            }

        }catch (Exception e){}

    }

    /**
     * todo 15.听歌曲
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle15(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
            }

        }catch (Exception e){}

    }

    /**
     * todo 16.吃饭
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle16(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
            }

        }catch (Exception e){}

    }

    /**
     * todo 17.分享
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle17(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
            }

        }catch (Exception e){}

    }

    /**
     * todo 18.摇钱树
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle18(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
            }

        }catch (Exception e){}

    }

    /**
     * todo 19.刮奖
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle19(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart())).findAny().orElse(null);
            if(null!=dto43) {
                for(int i=0;i<10;i++) {
                    int x = 100*i + Integer.valueOf(dto43.getPositionX());
                    String operate43 = AdbTools.tapDraw(String.valueOf(x), dto43.getPositionY());
                    MouseTools.normalEvent(robot, operate43);
                }
            }

            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStart1())).findAny().orElse(null);
            if(null!=dto44) {
                String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                MouseTools.normalEvent(robot, operate44);
            }

        }catch (Exception e){}

    }


    /**
     * todo 20.事件返回
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle20(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("5.步骤-返回主界面");
            String operateBackHome = "adb shell input keyevent BACK";
            MouseTools.normalEvent(robot,operateBackHome);

            log.info("4.步骤-事件-返回");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventBack())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
            }

        }catch (Exception e){}

    }

}
