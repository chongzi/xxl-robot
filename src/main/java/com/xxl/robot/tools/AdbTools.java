package com.xxl.robot.tools;

/**
 * todo 模拟手机操作
 */
public class AdbTools {

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
    public static String screen(String androidId){
       String screen = "adb -s "+androidId + " shell dumpsys power | find \"Display Power: state=\"";
       return screen;
    }



}
