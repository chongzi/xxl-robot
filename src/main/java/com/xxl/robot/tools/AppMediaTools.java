package com.xxl.robot.tools;

import com.xxl.robot.dto.PhoneCodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.List;

/**
 * todo 手机综合性操作
 */
public class AppMediaTools {
    private static Logger log = LoggerFactory.getLogger(AppMediaTools.class);

    /**
     * todo 1.app-视频用户行为操作(签到，看视频，关注，点赞，收藏，评论，开宝箱，种菜，走路)
     * 以category分类定位，再点击用户行为,用一category下不可多次点击category,否则试为程序运行
     * 传相应的app_code对应的phoneCodeDtos
     */
    public static void handleMedia(Robot robot, List<PhoneCodeDto> phoneCodeDtos, String appCode){
        switch (appCode){
            case "抖音极速版":
                mediaDou(robot,phoneCodeDtos);
                break;
            case "火山极速版":
                mediaHuo(robot,phoneCodeDtos);
                break;
            case "快手极速版":
                mediaKuai(robot,phoneCodeDtos);
                break;
            case "刷宝短视频":
                mediaShua(robot,phoneCodeDtos);
                break;
            case "快逗短视频":
                mediaKuaiDou(robot,phoneCodeDtos);
                break;
            case "彩蛋视频":
                mediaCai(robot,phoneCodeDtos);
                break;
            case "小吃货短视频":
                mediaXiao(robot,phoneCodeDtos);
                break;
            case "火火视频极速版":
                mediaHuoHuo(robot,phoneCodeDtos);
                break;
            case "追看视频":
                mediaZhui(robot,phoneCodeDtos);
                break;
            case "微视频":
                mediaWei(robot,phoneCodeDtos);
                break;

        }

    }

    /**
     * todo 1.抖音极速版
     * @param robot
     * @param phoneCodeDtos
     */
    public static void mediaDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos){
        initWindow(robot,phoneCodeDtos);




















    }

    /**
     * todo 2.火山极速版
     * @param robot
     * @param phoneCodeDtos
     */
    public static void mediaHuo(Robot robot, List<PhoneCodeDto> phoneCodeDtos){

    }

    /**
     * todo 3.快手极速版
     * @param robot
     * @param phoneCodeDtos
     */
    public static void mediaKuai(Robot robot, List<PhoneCodeDto> phoneCodeDtos){

    }

    /**
     * todo 4.刷宝短视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void mediaShua(Robot robot, List<PhoneCodeDto> phoneCodeDtos){

    }

    /**
     * todo 5.快逗短视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void mediaKuaiDou(Robot robot, List<PhoneCodeDto> phoneCodeDtos){

    }
    public static void mediaCai(Robot robot, List<PhoneCodeDto> phoneCodeDtos){

    }
    public static void mediaXiao(Robot robot, List<PhoneCodeDto> phoneCodeDtos){

    }

    public static void mediaHuoHuo(Robot robot, List<PhoneCodeDto> phoneCodeDtos){

    }
    public static void mediaZhui(Robot robot, List<PhoneCodeDto> phoneCodeDtos){

    }

    public static void mediaWei(Robot robot, List<PhoneCodeDto> phoneCodeDtos){

    }


//********************************************辅助功能****************************************************************
    public static void initWindow(Robot robot, List<PhoneCodeDto> phoneCodeDtos){
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
