package com.xxl.robot.app;

import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.tools.MouseTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.List;

/**
 * todo 手机综合性操作
 */
public class AppWalkTools {
    private static Logger log = LoggerFactory.getLogger(AppWalkTools.class);
    /**
     * todo 1.app-视频用户行为操作(签到，看视频，关注，点赞，收藏，评论，开宝箱，种菜，走路)
     * 以category分类定位，再点击用户行为,用一category下不可多次点击category,否则试为程序运行
     * 传相应的app_code对应的phoneCodeDtos
     */
     public static void handleMedia(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){
         switch (appCode){
             case "抖音极速版":
                 mediaDou(robot,phoneCodeDtos,appCode);
                 break;
             case "火山极速版":
                 mediaHuo(robot,phoneCodeDtos,appCode);
                 break;
             case "快手极速版":
                 mediaKuai(robot,phoneCodeDtos,appCode);
                 break;
             case "刷宝短视频":
                 mediaShua(robot,phoneCodeDtos,appCode);
                 break;
             case "快逗短视频":
                 mediaKuaiDou(robot,phoneCodeDtos,appCode);
                 break;
             case "彩蛋视频":
                 mediaCai(robot,phoneCodeDtos,appCode);
                 break;
             case "小吃货短视频":
                 mediaXiao(robot,phoneCodeDtos,appCode);
                 break;
             case "火火视频极速版":
                 mediaHuoHuo(robot,phoneCodeDtos,appCode);
                 break;
             case "追看视频":
                 mediaZhui(robot,phoneCodeDtos,appCode);
                 break;
             case "微视频":
                 mediaWei(robot,phoneCodeDtos,appCode);
                 break;

         }

     }

     public static void mediaDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){

     }

    public static void mediaDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){

    }
    public static void mediaDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){

    }
    public static void mediaDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){

    }
    public static void mediaDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){

    }
    public static void mediaDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){

    }
    public static void mediaDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){

    }

    public static void mediaDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){

    }
    public static void mediaDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){

    }



    /**
     * todo 2.app-新闻用户行为操作
     */
    public static void handleNews(){

     }

    /**
     * todo 3.app-小说用户行为操作
     */
    public static void handleNovel(){

     }

    /**
     * todo 4.app-步行用户行为操作
     */
    public static void handleWalk(){

    }

    /**
     * todo 5.app-音乐用户行为操作
     */
    public static void handleMusic(){

    }

    /**
     * todo 6.app-充电用户行为操作
     */
    public static void handleCharge(){

    }

    /**
     * todo 7.app-睡觉用户行为操作
     */
    public static void handleSleep(){

    }

    /**
     * todo 8.app-游戏用户行为操作
     */
    public static void handleGame(){

    }


//********************************************辅助功能****************************************************************
    public void initWindow(Robot robot, List<PhoneCodeDto> phoneCodeDtos){
        log.info("2.打开app所在集合窗口");
        PhoneCodeDto dto2 =  phoneCodeDtos.stream().filter(o -> o.getAppEvent() == "window").findAny().orElse(null);
        String operateData2 = "adb shell input tap " + dto2.getPositionX() + " " + dto2.getPositionY();
        MouseTools.normalEvent(robot,operateData2);

        log.info("3.打开初始化app程序");
        robot.delay(2000);
        PhoneCodeDto dto3 =  phoneCodeDtos.stream().filter(o -> o.getAppEvent() == "init").findAny().orElse(null);
        String operateData3 = "adb shell input tap " + dto3.getPositionX() + " " + dto3.getPositionY();
        MouseTools.normalEvent(robot, operateData3);
    }

}
