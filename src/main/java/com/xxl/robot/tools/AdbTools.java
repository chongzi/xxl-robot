package com.xxl.robot.tools;

import com.xxl.robot.constants.PhoneConstants;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * todo 模拟手机操作
 */
public class AdbTools {
    private static final Logger log = LoggerFactory.getLogger(AdbTools.class);

    /**
     * todo 常规操作(传过来数据 点击输入并回车操作)
     *
     */
    public static void process(Robot robot, String operateData){
        try {
            log.info(operateData);
            Runtime.getRuntime().exec(operateData);
            robot.delay(600);
        }catch (Exception e){

        }
    }


    /**
     * todo 启动app
     * 命令：查看当前app启动 adb shell dumpsys window | findstr mCurrentFocus
     */
    @SneakyThrows
    public static void startup(String androidId, String operateData){
        log.info("******************启动app**************");
            String operate = " adb -s " + androidId + " shell am start -n " + operateData;
            Runtime.getRuntime().exec(operate);
    }


    /**
     * todo 向下滑动，正常操作
     */
   public static String down(String androidId){
       int x = 100 + RandomTools.init(300);
       int y = 600 + RandomTools.init(600);
       int x1 = 600 + RandomTools.init(600);
       int y1 = 100 + RandomTools.init(300);
       String downDraw = "adb -s "+androidId +" shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

       return  downDraw;
   }

    /**
     * todo 向上滑动，返回操作
     */
    public static String up(String androidId){
        int x = 600 + RandomTools.init(600);
        int y = 100 + RandomTools.init(300);
        int x1 = 100 + RandomTools.init(300);
        int y1 = 600 + RandomTools.init(600);
        String downDraw = "adb -s "+androidId +" shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

        return  downDraw;
    }

    /**
     * todo 向左滑动，返回操作
     */
    public static String left(String androidId){
        int x = 10 + RandomTools.init(200);
        int y = 300 + RandomTools.init(300);
        int x1 = 300 + RandomTools.init(300);
        int y1 = 800 + RandomTools.init(600);

        String downDraw = "adb -s "+androidId +" shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

        return  downDraw;
    }

    /**
     * todo 向右滑动，返回操作
     */
    public static String right(String androidId){
        int x = 600 + RandomTools.init(600);
        int y = 270 + RandomTools.init(100);
        int x1 = 10 + RandomTools.init(100);
        int y1 = 600 + RandomTools.init(600);
        String downDraw = "adb -s "+androidId +" shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

        return  downDraw;
    }


    /**
     * todo 向下滑动，正常操作
     */
    public static String downPage(String androidId){
        int x = 100 + RandomTools.init(300);
        int y = 1000 + RandomTools.init(600);
        int x1 = 600 + RandomTools.init(600);
        int y1 = 100 + RandomTools.init(300);
        String downDraw = "adb -s "+androidId +" shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

        return  downDraw;
    }

    /**
     * todo 向上滑动，返回操作
     */
    public static String upPage(String androidId){
        int x = 600 + RandomTools.init(600);
        int y = 100 + RandomTools.init(300);
        int x1 = 100 + RandomTools.init(300);
        int y1 = 1600 + RandomTools.init(600);
        String downDraw = "adb -s "+androidId +" shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

        return  downDraw;
    }


    /**
     * todo 向下滑动，正常操作
     */
    public static String tap(String androidId, String x, String y){
        String tap = "adb -s "+androidId +" shell input tap " + x + " " + y;
        return  tap;
    }


    /**
     * todo 刮奖，正常操作
     */
    public static String tapDraw(String androidId, String x, String y){
        int y1 = 1000+Integer.valueOf(y);

        String draw = "adb -s "+androidId +" shell input swipe "+ x + " " + y + " " + x +" " +y1;

        return draw;
    }

    /**
     * todo 输入正常操作
     */
    public static String text(String androidId, String str){
        String text = "adb -s "+androidId +" shell input text " + str;
        return  text;
    }

    /***
     * todo 获取手机屏幕是否需要点亮(android9->)
     * android9 adb shell dumpsys window policy |find "mScreenOnFully" 判断 mAwake=truemScreenOnEarly=true mScreenOnFully=true
     * android9，10 adb shell dumpsys power | find "Display Power: state=" 判断 Display Power: state=ON
     * @return
     */
    @SneakyThrows
    public static boolean screen(String androidId){
        String screen = "adb -s "+androidId + " shell dumpsys power";
        return exeCmd(screen);
    }




    public static boolean exeCmd(String commandStr) {
        boolean bool = false;
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if(line.contains("state=ON")){
                     bool = true;
                }
                //sb.append(line + "\n");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return bool;
    }




    public static void main(String[] args) throws IOException, InterruptedException {
        boolean bool = screen(PhoneConstants.phone002);
        System.out.println(bool);


    }



}
