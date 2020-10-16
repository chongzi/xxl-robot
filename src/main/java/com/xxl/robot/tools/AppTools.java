package com.xxl.robot.tools;

import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.constants.PhoneConstants;
import com.xxl.robot.dto.AppDto;
import com.xxl.robot.dto.PhoneCodeDto;
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
public class AppTools {
    private static Logger log = LoggerFactory.getLogger(AppTools.class);

    /**
     * todo 总控制
     * 以category分类定位，再点击用户行为,用一category下不可多次点击category,否则试为程序运行
     * 传相应的app_code对应的phoneCodeDtos
     */
    public static void handle(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos, AppDto app){
        try {
            log.info("robotCode:{}" + robotCode);
            String androidId = "";
            if (robotCode.equals("phone001")) {
                androidId = PhoneConstants.phone001;
            } else if (robotCode.equals("phone002")) {
                androidId = PhoneConstants.phone002;
            } else if (robotCode.equals("phone003")) {
                androidId = PhoneConstants.phone003;
            } else if (robotCode.equals("phone0031")) {
                androidId = PhoneConstants.phone0031;
            } else if (robotCode.equals("phone0032")) {
                androidId = PhoneConstants.phone0032;
            } else if (robotCode.equals("phone0033")) {
                androidId = PhoneConstants.phone0033;
            } else if (robotCode.equals("phone0034")) {
                androidId = PhoneConstants.phone0034;
            } else if (robotCode.equals("phone0035")) {
                androidId = PhoneConstants.phone0035;
            }

            if(StringUtils.isBlank(androidId))return;
//*************************************************************业务处理  START ***************************************************************************
                    if(!AdbTools.screen(androidId)) {
                        log.info("0.唤醒手机屏幕");
                        String operateScreen = "adb -s " + androidId + " shell input keyevent 26";
                        AdbTools.process(robot, operateScreen);
                    }
                    log.info("0.返回主界面");
                    String operateHome = "adb -s " + androidId + " shell input keyevent 3";
                    AdbTools.process(robot, operateHome);

                    log.info("0.调取缓存");
                    String operateDispath = "adb -s " + androidId + " shell input keyevent 82";
                    AdbTools.process(robot, operateDispath);

                    log.info("0.删除缓存");
                    String operateDelete = "";
                    if (androidId.equals(PhoneConstants.phone001)) {
                        operateDispath = "adb -s " + androidId + " shell input tap 770 2280";
                        AdbTools.process(robot, operateDispath);
                        operateDelete = AdbTools.tap(androidId, String.valueOf(540), String.valueOf(2080));
                    } else if (androidId.equals(PhoneConstants.phone002)) {
                        operateDelete = AdbTools.tap(androidId, String.valueOf(540), String.valueOf(2000));
                    } else if (androidId.equals(PhoneConstants.phone003)||androidId.equals(PhoneConstants.phone0031)
                    ||androidId.equals(PhoneConstants.phone0032)||androidId.equals(PhoneConstants.phone0033)
                    ||androidId.equals(PhoneConstants.phone0034)||androidId.equals(PhoneConstants.phone0035)) {
                        operateDelete = AdbTools.tap(androidId, String.valueOf(540), String.valueOf(1860));
                    }
                    AdbTools.process(robot, operateDelete);

                    log.info("0.返回主界面");
                    AdbTools.process(robot, operateHome);


                    log.info("1.动作");
                    String operate1 = appCode + "-" + event;
                    AdbTools.process(robot, operate1);

                    log.info("2.初始化");
                    initWindow(appCode,androidId);
                     robot.delay(6000);

                    if (null == app) {
                        return;
                    }

//********************************************用户行为操作 START********************************************************

                    log.info("**************用户行为：" + app.getOperate() + "*********************");
                    log.info("3.1清除");
                    String operateEsc = "adb -s " + androidId + " shell input keyevent 111";
                    AdbTools.process(robot, operateEsc);

                    log.info("3.2 强制清除");
                    PhoneCodeDto dto3 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getClear())).findAny().orElse(null);
                    if (null != dto3) {
                        String operate3 = AdbTools.tap(androidId, dto3.getPositionX(), dto3.getPositionY());
                        AdbTools.process(robot, operate3);
                    }
                    log.info("4.1步骤-分类");
                    PhoneCodeDto dto41 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getCategory())).findAny().orElse(null);
                    if (null != dto41) {
                        String operate41 = AdbTools.tap(androidId, dto41.getPositionX(), dto41.getPositionY());
                        AdbTools.process(robot, operate41);
                        if (app.getUpDown() == 0) {
                            AdbTools.process(robot, AdbTools.upPage(androidId));
                            AdbTools.process(robot, AdbTools.upPage(androidId));
                        } else {
                            AdbTools.process(robot, AdbTools.downPage(androidId));
                            AdbTools.process(robot, AdbTools.downPage(androidId));
                        }
                    }

                    log.info("4.2步骤-事件前清除");
                    PhoneCodeDto dto42 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventClear())).findAny().orElse(null);
                    if (null != dto42) {
                        String operate42 = AdbTools.tap(androidId, dto42.getPositionX(), dto42.getPositionY());
                        AdbTools.process(robot, operate42);
                    }

                    log.info("4.3步骤-事件");
                    PhoneCodeDto dto43 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEvent())).findAny().orElse(null);
                    if (null != dto43) {
                        String operate43 = AdbTools.tap(androidId, dto43.getPositionX(), dto43.getPositionY());
                        AdbTools.process(robot, operate43);
                    }

                    log.info("4.4步骤-事件-各种动作");
                    process(robot, phoneCodeDtos, app, androidId);

                    log.info("5返回定制化");
                    PhoneCodeDto dto45 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventBack())).findAny().orElse(null);
                    if (null != dto45) {
                        String operate45 = AdbTools.tap(androidId, dto45.getPositionX(), dto45.getPositionY());
                        AdbTools.process(robot, operate45);
                    }

                    log.info("6返回上一步");
                    String operateBack = "adb -s " + androidId + " shell input keyevent BACK";
                    AdbTools.process(robot, operateBack);
                    AdbTools.process(robot, operateBack);


//********************************************用户行为操作 END********************************************************

                    log.info("7.返回主界面");
                    AdbTools.process(robot, operateHome);





        }catch (Exception e){

        }

    }

    /**
     * todo 初始化启动app
     * @param appCode
     * @param androidId
     */
    public static void initWindow(String appCode, String androidId){

          if(appCode.contains("抖音")){
              AdbTools.startup(androidId,AppConstants.startup抖音);
          }else if(appCode.contains("火山极速")){
              AdbTools.startup(androidId,AppConstants.startup火山);
          }else if(appCode.contains("快手")){
              AdbTools.startup(androidId,AppConstants.startup快手);
          }else if(appCode.contains("今日头条")){
              AdbTools.startup(androidId,AppConstants.startup今日头条);
          }else if(appCode.contains("趣头条")){
              AdbTools.startup(androidId,AppConstants.startup趣头条);
          }else if(appCode.contains("QQ阅读")){
              AdbTools.startup(androidId,AppConstants.startupQQ阅读);
          }else if(appCode.contains("火山小说")){
              AdbTools.startup(androidId,AppConstants.startup火山小说);
          }else if(appCode.contains("NOW直播")){
              AdbTools.startup(androidId,AppConstants.startupNOW直播);
          }else if(appCode.contains("搜狗")){
              AdbTools.startup(androidId,AppConstants.startup搜狗);
          }else if(appCode.contains("拼多多")){
              AdbTools.startup(androidId,AppConstants.startup拼多多);
          }else if(appCode.contains("微博")){
              AdbTools.startup(androidId,AppConstants.startup微博);


          }else if(appCode.contains("书旗")){
              AdbTools.startup(androidId,AppConstants.startup书旗);
          }else if(appCode.contains("番茄")){
              AdbTools.startup(androidId,AppConstants.startup番茄);
          }else if(appCode.contains("奇热")){
              AdbTools.startup(androidId,AppConstants.startup奇热);
          }else if(appCode.contains("抖音火山")){
              AdbTools.startup(androidId,AppConstants.startup抖音火山);
          }else if(appCode.contains("晴象")){
              AdbTools.startup(androidId,AppConstants.startup晴象);
          }else if(appCode.contains("米读")){
              AdbTools.startup(androidId,AppConstants.startup米读);
          }else if(appCode.contains("必看")){
              AdbTools.startup(androidId,AppConstants.startup必看);
          }else if(appCode.contains("牛角")){
              AdbTools.startup(androidId,AppConstants.startup牛角);
          }else if(appCode.contains("喜马拉雅")){
              AdbTools.startup(androidId,AppConstants.startup喜马拉雅);
          }else if(appCode.contains("新浪")){
              AdbTools.startup(androidId,AppConstants.startup新浪);
          }else if(appCode.contains("2345")){
              AdbTools.startup(androidId,AppConstants.startup2345);

          }else if(appCode.contains("刷宝")){
              AdbTools.startup(androidId,AppConstants.startup刷宝);
          }else if(appCode.contains("快逗")){
              AdbTools.startup(androidId,AppConstants.startup快逗);
          }else if(appCode.contains("追看")){
              AdbTools.startup(androidId,AppConstants.startup追看);
          }else if(appCode.contains("小吃货")){
              AdbTools.startup(androidId,AppConstants.startup小吃货);
          }else if(appCode.contains("微视")){
              AdbTools.startup(androidId,AppConstants.startup微视);
          }else if(appCode.contains("火火")){
              AdbTools.startup(androidId,AppConstants.startup火火视频);
          }else if(appCode.contains("红包视频")){
              AdbTools.startup(androidId,AppConstants.startup红包视频);
          }else if(appCode.contains("彩蛋")){
              AdbTools.startup(androidId,AppConstants.startup彩蛋);
          }else if(appCode.contains("热火")){
              AdbTools.startup(androidId,AppConstants.startup热火);
          }else if(appCode.contains("赚钱")){
              AdbTools.startup(androidId,AppConstants.startup赚钱);
          }else if(appCode.contains("长豆")){
              AdbTools.startup(androidId,AppConstants.startup长豆);


          }else if(appCode.contains("点点")){
              AdbTools.startup(androidId,AppConstants.startup点点);
          }else if(appCode.contains("悦头条")){
              AdbTools.startup(androidId,AppConstants.startup悦头条);
          }else if(appCode.contains("忆头条")){
              AdbTools.startup(androidId,AppConstants.startup忆头条);
          }else if(appCode.contains("惠头条")){
              AdbTools.startup(androidId,AppConstants.startup惠头条);
          }else if(appCode.contains("蚂蚁看点")){
              AdbTools.startup(androidId,AppConstants.startup蚂蚁看点);
          }else if(appCode.contains("趣新闻")){
              AdbTools.startup(androidId,AppConstants.startup趣新闻);
          }else if(appCode.contains("快看点")){
              AdbTools.startup(androidId,AppConstants.startup快看点);
          }else if(appCode.contains("聚看点")){
              AdbTools.startup(androidId,AppConstants.startup聚看点);
          }else if(appCode.contains("趣故事")){
              AdbTools.startup(androidId,AppConstants.startup趣故事);
          }else if(appCode.contains("有料看看")){
              AdbTools.startup(androidId,AppConstants.startup有料看看);
          }else if(appCode.contains("微鲤看看")){
              AdbTools.startup(androidId,AppConstants.startup微鲤看看);
          }else if(appCode.contains("赚钱阅文赚")){
              AdbTools.startup(androidId,AppConstants.startup赚钱阅文赚);


          }else if(appCode.contains("多多步")){
              AdbTools.startup(androidId,AppConstants.startup多多步);
          }else if(appCode.contains("步数赚零钱")){
              AdbTools.startup(androidId,AppConstants.startup步数赚零钱);
          }else if(appCode.contains("步步宝")){
              AdbTools.startup(androidId,AppConstants.startup步步宝);
          }else if(appCode.contains("走走赚")){
              AdbTools.startup(androidId,AppConstants.startup走走赚);
          }else if(appCode.contains("步多多")){
              AdbTools.startup(androidId,AppConstants.startup步多多);
          }else if(appCode.contains("步步赚钱")){
              AdbTools.startup(androidId,AppConstants.startup步步赚钱);
          }else if(appCode.contains("一起来走路")){
              AdbTools.startup(androidId,AppConstants.startup一起来走路);
          }else if(appCode.contains("多宝")){
              AdbTools.startup(androidId,AppConstants.startup多宝);
          }else if(appCode.contains("走路赚钱")){
              AdbTools.startup(androidId,AppConstants.startup走路赚钱);
          }else if(appCode.contains("乐步")){
              AdbTools.startup(androidId,AppConstants.startup乐步);
          }else if(appCode.contains("计步赚钱")){
              AdbTools.startup(androidId,AppConstants.startup计步赚钱);
          }else if(appCode.contains("步步多")){
              AdbTools.startup(androidId,AppConstants.startup步步多);


          }else if(appCode.contains("红包赚不停")){
              AdbTools.startup(androidId,AppConstants.startup红包赚不停);
          }else if(appCode.contains("快乐看天气")){
              AdbTools.startup(androidId,AppConstants.startup快乐看天气);
          }else if(appCode.contains("云朵天气")){
              AdbTools.startup(androidId,AppConstants.startup云朵天气);
          }else if(appCode.contains("幸福果园")){
              AdbTools.startup(androidId,AppConstants.startup幸福果园);

          }

    }



    /**
     * todo 动作行为-签到,开宝箱，领红包，看广告，抽奖，喝水，吃饭等
     * @param robot
     * @param phoneCodeDtos
     */
    public static void process(Robot robot, List<PhoneCodeDto> phoneCodeDtos, AppDto app, String androidId){
        try {
            PhoneCodeDto dto400 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep())).findAny().orElse(null);
            if(null!=dto400) {
                String operate400 = AdbTools.tap(androidId,dto400.getPositionX(), dto400.getPositionY());
                AdbTools.process(robot, operate400);
            }

            PhoneCodeDto dto401 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep1())).findAny().orElse(null);
            if(null!=dto401) {
                String operate401 = AdbTools.tap(androidId,dto401.getPositionX(), dto401.getPositionY());
                AdbTools.process(robot, operate401);
            }

            PhoneCodeDto dto402 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep2())).findAny().orElse(null);
            if(null!=dto402) {
                String operate402 = AdbTools.tap(androidId,dto402.getPositionX(), dto402.getPositionY());
                AdbTools.process(robot, operate402);
            }

            PhoneCodeDto dto403 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep3())).findAny().orElse(null);
            if(null!=dto403) {
                String operate403 = AdbTools.tap(androidId,dto403.getPositionX(), dto403.getPositionY());
                AdbTools.process(robot, operate403);
            }

            PhoneCodeDto dto404 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep4())).findAny().orElse(null);
            if(null!=dto404) {
                String operate404 = AdbTools.tap(androidId,dto404.getPositionX(), dto404.getPositionY());
                AdbTools.process(robot, operate404);
            }

            PhoneCodeDto dto405 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventStep5())).findAny().orElse(null);
            if(null!=dto405) {
                String operate405 = AdbTools.tap(androidId,dto405.getPositionX(), dto405.getPositionY());
                AdbTools.process(robot, operate405);
            }

            //上下滑动
            if(null!=app.getEventType()&&app.getEventType().equals(1)) {
                 int x = RandomTools.init(8);
                    for (int i = 0; i < x ; i++) {
                        AdbTools.process(robot, AdbTools.downPage(androidId));
                        robot.delay(RandomTools.init(20000));
                        if (i == RandomTools.init(6)) {
                            log.info("4.步骤-事件-点攒");
                            PhoneCodeDto dto406 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventGiveUP() )).findAny().orElse(null);
                            String operate406 = AdbTools.tap(androidId,dto406.getPositionX(), dto406.getPositionY());
                            AdbTools.process(robot, operate406);
                        }
                        if (i == RandomTools.init(6)) {
                            robot.delay(RandomTools.init(2000));
                            AdbTools.process(robot, AdbTools.upPage(androidId));
                        }

                        PhoneCodeDto dto407 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventUpDownStep())).findAny().orElse(null);
                        if(null!=dto407) {
                            String operate407 = AdbTools.tap(androidId,dto407.getPositionX(), dto407.getPositionY());
                            AdbTools.process(robot, operate407);
                        }

                        PhoneCodeDto dto408 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventUpDownStep1())).findAny().orElse(null);
                        if(null!=dto408) {
                            String operate408 = AdbTools.tap(androidId,dto408.getPositionX(), dto408.getPositionY());
                            AdbTools.process(robot, operate408);
                        }

                        PhoneCodeDto dto409 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventUpDownStep2())).findAny().orElse(null);
                        if(null!=dto409) {
                            String operate409 = AdbTools.tap(androidId,dto409.getPositionX(), dto409.getPositionY());
                            AdbTools.process(robot, operate409);
                        }

                        PhoneCodeDto dto410 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventUpDownBack())).findAny().orElse(null);
                        if(null!=dto410) {
                            String operate410 = AdbTools.tap(androidId,dto410.getPositionX(), dto410.getPositionY());
                            AdbTools.process(robot, operate410);
                        }

                        PhoneCodeDto dto411 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventUpDownBack1())).findAny().orElse(null);
                        if(null!=dto411) {
                            String operate411 = AdbTools.tap(androidId,dto411.getPositionX(), dto411.getPositionY());
                            AdbTools.process(robot, operate411);
                        }

                        PhoneCodeDto dto412 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventUpDownBack2())).findAny().orElse(null);
                        if(null!=dto412) {
                            String operate412 = AdbTools.tap(androidId,dto412.getPositionX(), dto412.getPositionY());
                            AdbTools.process(robot, operate412);
                        }

                    }

            }


            //左右滑动
            if(null!=app.getEventType()&&app.getEventType().equals(2)) {
                int x = RandomTools.init(8);
                for (int i = 0; i < x ; i++) {
                    AdbTools.process(robot, AdbTools.downPage(androidId));
                    robot.delay(RandomTools.init(10000));

                    PhoneCodeDto dto413 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventLeftRightStep())).findAny().orElse(null);
                    if(null!=dto413) {
                        String operate413 = AdbTools.tap(androidId,dto413.getPositionX(), dto413.getPositionY());
                        AdbTools.process(robot, operate413);
                    }

                    PhoneCodeDto dto414 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventLeftRightStep1())).findAny().orElse(null);
                    if(null!=dto414) {
                        String operate414 = AdbTools.tap(androidId,dto414.getPositionX(), dto414.getPositionY());
                        AdbTools.process(robot, operate414);
                    }

                    PhoneCodeDto dto415 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventLeftRightStep2())).findAny().orElse(null);
                    if(null!=dto415) {
                        String operate415 = AdbTools.tap(androidId,dto415.getPositionX(), dto415.getPositionY());
                        AdbTools.process(robot, operate415);
                    }

                    PhoneCodeDto dto416 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventLeftRightBack())).findAny().orElse(null);
                    if(null!=dto416) {
                        String operate416 = AdbTools.tap(androidId,dto416.getPositionX(), dto416.getPositionY());
                        AdbTools.process(robot, operate416);
                    }

                    PhoneCodeDto dto417 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventLeftRightBack1())).findAny().orElse(null);
                    if(null!=dto417) {
                        String operate417 = AdbTools.tap(androidId,dto417.getPositionX(), dto417.getPositionY());
                        AdbTools.process(robot, operate417);
                    }

                    PhoneCodeDto dto418 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventLeftRightBack2())).findAny().orElse(null);
                    if(null!=dto418) {
                        String operate418 = AdbTools.tap(androidId,dto418.getPositionX(), dto418.getPositionY());
                        AdbTools.process(robot, operate418);
                    }

                }

            }

            //快速上下滑动
            if(null!=app.getEventType()&&app.getEventType().equals(3)) {
                PhoneCodeDto dto419 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventFastUpDown())).findAny().orElse(null);
                if(null!=dto419) {
                    for (int i = 0; i < 8; i++) {
                        int x = 100 * i + Integer.valueOf(dto419.getPositionX());
                        String operate419 = AdbTools.tapDraw(androidId, String.valueOf(x), dto419.getPositionY());
                        AdbTools.process(robot, operate419);
                    }
                }
            }

            //快速左右滑动
            if(null!=app.getEventType()&&app.getEventType().equals(4)) {
                PhoneCodeDto dto420 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventFastLeftRight())).findAny().orElse(null);
                if(null!=dto420) {
                    for (int i = 0; i < 8; i++) {
                        int y = 100 * i + Integer.valueOf(dto420.getPositionY());
                        String operate420 = AdbTools.tapDraw(androidId, dto420.getPositionX(), String.valueOf(y));
                        AdbTools.process(robot, operate420);
                    }
                }
            }


            PhoneCodeDto dto47 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventAdvertStep())).findAny().orElse(null);
            if(null!=dto47) {
                String operate47 = AdbTools.tap(androidId,dto47.getPositionX(), dto47.getPositionY());
                AdbTools.process(robot, operate47);
            }

            PhoneCodeDto dto48 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals(app.getEventAdvert())).findAny().orElse(null);
            //if(null!=dto48&&null!=dto48.getTimes()&&dto48.getTimes()>0) {
            if(null!=dto48){
                String operate48 = AdbTools.tap(androidId,dto48.getPositionX(), dto48.getPositionY());
                AdbTools.process(robot, operate48);
                int duration = 36000;//看广告36秒
                if(null!=app.getEventAdvertDelay()){
                    duration = duration + app.getEventAdvertDelay();
                }
                robot.delay(duration);
            }


        }catch (Exception e){}

    }

}
