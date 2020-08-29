package com.xxl.robot.app.media;

import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.tools.AdbTools;
import com.xxl.robot.tools.MouseTools;
import com.xxl.robot.tools.RandomTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.List;

/**
 * todo 抖音视频操作
 * app-视频用户行为操作(签到，看视频，关注，点赞，收藏，评论，开宝箱，种菜，走路)
 */
public class D视频微视 {
    private static Logger log = LoggerFactory.getLogger(D视频微视.class);

    /**
     * todo 1.
     * 以category分类定位，再点击用户行为,用一category下不可多次点击category,否则试为程序运行
     * 传相应的app_code对应的phoneCodeDtos
     */
    public static void handle(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){

        switch (event){

            case AppConstants.WATCH_VIDEOS://看视频
                handle1(robot, robotCode, appCode, event, phoneCodeDtos);
                break;

        }

    }




    /**
     * todo 2.看视频
     * @param robot
     * @param phoneCodeDtos
     */
    public static void handle1(Robot robot,String robotCode, String appCode, String event,List<PhoneCodeDto> phoneCodeDtos){
        PhoneCodeDto dto = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页")).findAny().orElse(null);
        PhoneCodeDto dto1 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-看视频")).findAny().orElse(null);
        PhoneCodeDto dto2 = phoneCodeDtos.stream().filter(o -> o.getAppEvent().equals("category首页-关注")).findAny().orElse(null);

        String operate = AdbTools.tap(dto.getPositionX(),dto.getPositionY());
        MouseTools.normalEvent(robot,operate);
        int i = RandomTools.init(20);
        int y = RandomTools.init(20);
        int re = RandomTools.init(20000);
        log.info("随机值:{}"+i);
        for(int a=0;a<i;a++){
            robot.delay(re);
            MouseTools.normalEvent(robot,AdbTools.downPage());
            if(a>y){
                robot.delay(re);
                MouseTools.normalEvent(robot,AdbTools.upPage());
            }
            if(a==y){
                robot.delay(re);
                String operate3 = AdbTools.tap(dto2.getPositionX(),dto2.getPositionY());
                MouseTools.normalEvent(robot,operate3);
            }

        }

    }




}
