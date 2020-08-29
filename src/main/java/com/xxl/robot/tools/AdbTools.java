package com.xxl.robot.tools;

/**
 * todo 模拟手机操作
 */
public class AdbTools {

    /**
     * todo 向下滑动，正常操作
     */
   public static String down(){
       int x = 100 + RandomTools.init(300);
       int y = 600 + RandomTools.init(600);
       int x1 = 600 + RandomTools.init(600);
       int y1 = 100 + RandomTools.init(300);
       String downDraw = "adb shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

       return  downDraw;
   }

    /**
     * todo 向上滑动，返回操作
     */
    public static String up(){
        int x = 600 + RandomTools.init(600);
        int y = 100 + RandomTools.init(300);
        int x1 = 100 + RandomTools.init(300);
        int y1 = 600 + RandomTools.init(600);
        String downDraw = "adb shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

        return  downDraw;
    }

    /**
     * todo 向左滑动，返回操作
     */
    public static String left(){
        int x = 600 + RandomTools.init(600);
        int y = 100 + RandomTools.init(300);
        int x1 = 100 + RandomTools.init(300);
        int y1 = 600 + RandomTools.init(600);
        String downDraw = "adb shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

        return  downDraw;
    }

    /**
     * todo 向右滑动，返回操作
     */
    public static String right(){
        int x = 600 + RandomTools.init(600);
        int y = 100 + RandomTools.init(300);
        int x1 = 100 + RandomTools.init(300);
        int y1 = 600 + RandomTools.init(600);
        String downDraw = "adb shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

        return  downDraw;
    }


    /**
     * todo 向下滑动，正常操作
     */
    public static String downPage(){
        int x = 100 + RandomTools.init(300);
        int y = 1600 + RandomTools.init(600);
        int x1 = 600 + RandomTools.init(600);
        int y1 = 100 + RandomTools.init(300);
        String downDraw = "adb shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

        return  downDraw;
    }

    /**
     * todo 向上滑动，返回操作
     */
    public static String upPage(){
        int x = 600 + RandomTools.init(600);
        int y = 100 + RandomTools.init(300);
        int x1 = 100 + RandomTools.init(300);
        int y1 = 1600 + RandomTools.init(600);
        String downDraw = "adb shell input swipe "+ x + " " + y + " " + x1 +" " +y1;

        return  downDraw;
    }


    /**
     * todo 向下滑动，正常操作
     */
    public static String tap(String x, String y){
        String tap = "adb shell input tap " + x + " " + y;
        return  tap;
    }

    public static  void main(String args[]){
        System.out.println(up());
    }

}
