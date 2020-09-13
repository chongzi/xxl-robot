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

        log.info("4.步骤-事件前清除");
        PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventClear())).findAny().orElse(null);
        if(null!=dto42) {
            String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
            MouseTools.normalEvent(robot, operate42);
        }

        log.info("4.步骤-事件");
        PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEvent())).findAny().orElse(null);
        if(null!=dto43) {
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);
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
            case AppConstants.SCRATCH_CARD://刮奖
                handle19(robot, phoneCodeDtos, app);
                break;
            case AppConstants.SEARCH://搜索
                handle20(robot, phoneCodeDtos, app);
                break;
            case AppConstants.OTHER_QINGXIANG_WATCH_VIDEOS://睛象浏览器
                handle21(robot, phoneCodeDtos, app);
                break;
        }

        PhoneCodeDto dto45 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventBack())).findAny().orElse(null);
        if(null!=dto45) {
            String operate45 = AdbTools.tap(dto45.getPositionX(), dto45.getPositionY());
            MouseTools.normalEvent(robot, operate45);
            String operateBackHome = "adb shell input keyevent BACK";
            MouseTools.normalEvent(robot,operateBackHome);
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
       // MouseTools.normalEvent(robot,operateBackHome);

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

            log.info("4.步骤-事件-看广告辅助");
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventAdvertStep())).findAny().orElse(null);
            if(null!=dto44) {
                String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                MouseTools.normalEvent(robot, operate44);
            }
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
                PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
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
            int i = RandomTools.init(10);
            int y = RandomTools.init(10);
            int re = RandomTools.init(6000);
            for (int a = 0; a < i; a++) {
                robot.delay(re);
                MouseTools.normalEvent(robot, AdbTools.downPage());

                log.info("4.步骤-事件-开始执行");
                PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep() )).findAny().orElse(null);
                if(null!=dto43) {
                    String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                    MouseTools.normalEvent(robot, operate43);
                }
                PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep1() )).findAny().orElse(null);
                if(null!=dto44) {
                    String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                    MouseTools.normalEvent(robot, operate44);
                }

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
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);
            robot.delay(RandomTools.init(6000));

            log.info("4.步骤-事件-开始执行1");
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep1())).findAny().orElse(null);
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

            log.info("4.步骤-事件-step");
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
            if(null!=dto44) {
                String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                MouseTools.normalEvent(robot, operate44);
            }
            log.info("4.步骤-事件-step1");
            PhoneCodeDto dto45 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep1())).findAny().orElse(null);
            if(null!=dto45) {
                String operate45 = AdbTools.tap(dto45.getPositionX(), dto45.getPositionY());
                MouseTools.normalEvent(robot, operate45);
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
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
            if(null!=dto44) {
                String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                MouseTools.normalEvent(robot, operate44);
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
            log.info("4.步骤-事件-step");
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
            if(null!=dto44) {
                String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                MouseTools.normalEvent(robot, operate44);
            }
            log.info("4.步骤-事件-step1");
            PhoneCodeDto dto45 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep1())).findAny().orElse(null);
            if(null!=dto45) {
                String operate45 = AdbTools.tap(dto45.getPositionX(), dto45.getPositionY());
                MouseTools.normalEvent(robot, operate45);
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
            log.info("4.步骤-事件-step");
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
            if(null!=dto44) {
                String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                MouseTools.normalEvent(robot, operate44);
            }
            log.info("4.步骤-事件-step1");
            PhoneCodeDto dto45 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep1())).findAny().orElse(null);
            if(null!=dto45) {
                String operate45 = AdbTools.tap(dto45.getPositionX(), dto45.getPositionY());
                MouseTools.normalEvent(robot, operate45);
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
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
            String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
            MouseTools.normalEvent(robot, operate43);

            log.info("4.步骤-事件-开始执行1");
            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep1())).findAny().orElse(null);
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
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
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
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
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
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
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
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
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
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
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
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
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
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
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
            PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventClear())).findAny().orElse(null);
            if(null!=dto42) {
                String operate42 = AdbTools.tap(dto42.getPositionX(), dto42.getPositionY());
                MouseTools.normalEvent(robot, operate42);
            }

            PhoneCodeDto dto422 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventAdvertStep())).findAny().orElse(null);
            if(null!=dto422) {
                for(int i=0;i<8;i++) {
                    int x = 100*i + Integer.valueOf(dto422.getPositionX());
                    String operate422 = AdbTools.tapDraw(String.valueOf(x), dto422.getPositionY());
                    MouseTools.fastNormalEvent(robot, operate422);
                }
            }

            PhoneCodeDto dto4222 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventAdvert())).findAny().orElse(null);
            if(null!=dto4222) {
                    String operate4222 = AdbTools.tap(dto4222.getPositionX(), dto4222.getPositionY());
                    MouseTools.normalEvent(robot, operate4222);
                    robot.delay(27000);
            }

            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
            if(null!=dto43) {
                for(int i=0;i<8;i++) {
                    int x = 100*i + Integer.valueOf(dto43.getPositionX());
                    String operate43 = AdbTools.tapDraw(String.valueOf(x), dto43.getPositionY());
                    MouseTools.fastNormalEvent(robot, operate43);
                }
            }

            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep1())).findAny().orElse(null);
            if(null!=dto44) {
                String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                MouseTools.normalEvent(robot, operate44);
            }

        }catch (Exception e){}

    }


    /**
     * todo 20.搜索
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle20(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("4.步骤-事件-开始执行");
            PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventSearchClear())).findAny().orElse(null);
            if(null!=dto43) {
                String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                MouseTools.normalEvent(robot, operate43);
                MouseTools.normalEvent(robot, operate43);
                String str = "每个人的成功都不会是偶然，" +
                        "只有敢于尝试，因为好的赚钱之路，永远掌握在少数人的手里，也没有人会因为10不要以为只有在高级写字楼里工作的白领才有机会月收入2万，" +
                        "其实还有很多不起眼却很赚钱的小生意！下面是有可能月入2万的10个小生意，有些没人注意的暴利行业，欢迎阅0元而破产，却有很多人用100元跟着团队发家致富，" +
                        "只要你不贪，每天赚300—5000不是问题！只要100元起步，超高收益，超高回报率，操作简单，免学费，无押金，不收取任何做婚庆生意利润很高，在小城市负责一场婚礼" +
                        "早餐店的生意也是比较火爆的，毕竟民以食为天早餐是每天必吃的一餐，按照现在的消费水平平均一人就得消费8元到19元左右。其中最低利润在5元一人，如果店面大那可以接待更多食客" +
                        "大概在6千到1万左右，更别说在大城市里面。婚庆公司有专门的婚庆团队每个人做好自己的事情，其自媒体需要很长时间" +
                        "的运营和持续的创作优质的原创文章出来，因为自媒体靠阅读量和广告收益赚钱的。如果文章写得好就有很多粉丝，那样长期下来收益就不会低中有" +
                        "主持人和摄影师以及婚礼场地设计师等，这个行业的成本不高，利润很惊人团队每人月收入过万不是梦费用" +
                        "现在很多年轻人聚会喜欢吃烧烤，喝喝啤酒什么的。所以晚上很多烧烤店的生意非常火爆。一些食物的成本低但是利润很高。如果在学校附近开个烧烤店收入还是不错的" +
                        "在的年轻人喜欢喝奶茶和咖啡等饮品，而这些奶茶的价格在10元以上，利润很高。如果是学校附近或者步行街的奶茶店都是排着长长的队，老板生意火爆着呢，是月入2万的10个小生" +
                        "婴店的利润高，抓哟是来源于产品包装和知名度。而且母婴店品种多小孩子的奶粉和用品以及服装、零食、配饰、儿网上赚钱已经不再是秘密，现在越来越多的人加入到网上赚钱的行列中， " +
                        "但是还有很多人一直在摸索，没有找到简单快捷的赚钱之道。 赚钱之道永远掌握在少数人手里" +
                        "童玩具等很齐全。这些 东西的价格并不便宜，比网上要贵很多但是生意依然火想要赚钱，那么你就应该有自己独有投" +
                        "资技巧，除了要有技巧以外还要有投。资前的充分准备，所谓的准备就是你对今天开奖的充分了解，想要做到百战百胜这真的是很难，不过十盘赢7-8盘这个还是能通过各种准备来帮你达到";
                int i = RandomTools.init(400);
                AdbTools.text(str.substring(i,i+6));
            }

            PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventSearch())).findAny().orElse(null);
            if(null!=dto44) {
                String operate44 = AdbTools.tap(dto44.getPositionX(), dto44.getPositionY());
                MouseTools.normalEvent(robot, operate44);
            }

            PhoneCodeDto dto45 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
            if(null!=dto45) {
                String operate45 = AdbTools.tap(dto45.getPositionX(), dto45.getPositionY());
                MouseTools.normalEvent(robot, operate45);
            }



        }catch (Exception e){}

    }




    /**
     * todo 21.晴象看视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle21(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            int i = RandomTools.init(20);
            int y = RandomTools.init(20);
            int re = RandomTools.init(6000);
            for (int a = 0; a < i; a++) {

                PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventBack() )).findAny().orElse(null);
                if(null!=dto43) {
                    String operate43 = AdbTools.tap(dto43.getPositionX(), dto43.getPositionY());
                    MouseTools.normalEvent(robot, operate43);
                }

                robot.delay(re);
                MouseTools.normalEvent(robot, AdbTools.downPage());
                if (a == y) {
                    log.info("4.步骤-事件-点攒");
                    PhoneCodeDto dto44 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventGiveUP() )).findAny().orElse(null);
                    if(null!=dto44) {
                        String operate44 = AdbTools.tap(dto44.getPositionX(), dto43.getPositionY());
                        MouseTools.normalEvent(robot, operate44);
                    }
                }
                if (a > y) {
                    robot.delay(re);
                    MouseTools.normalEvent(robot, AdbTools.upPage());
                }
            }



        }catch (Exception e){

        }

    }





}
