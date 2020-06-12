package com.xxl.robot.tools;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * todo 自动复制，发送，截取window中程序中内容，实现模拟人工操作电脑
 */
public class CrawlTools {


    private Clipboard system;


            /**
             * todo QQ在线聊天数据爬取
             */
            public static void QQCrawl(){


                try {
                    Robot robot = new Robot();
                    moveMouse(200,100);
                    robot.delay(6000);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_SHIFT); //按下空格键
//            robot.delay(3000);
            moveMouse(200,600);

            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.delay(1000);


            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_C);

                }catch (Exception e){
            e.printStackTrace();
        }

   }

    /**
     * todo 微信在线聊天数据爬取
     */
    public static void WechatCrawl(){

    }




    public static void moveMouse(int x,int y){
        try {
            Robot robot = new Robot();
            robot.mouseMove(x, y);
            robot.delay(300);
        }catch (Exception e){
            e.printStackTrace();
        }
    }






    public static void main(String args[]){
        QQCrawl();
    }


}
