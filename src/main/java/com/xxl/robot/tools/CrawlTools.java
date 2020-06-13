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

            //    moveMouse(200,100);
                try {

                   for(int i=1;i<16;i++){
                       //点击左边菜单标题
                       Robot robot = new Robot();
                       robot.delay(3000);
                       moveMouse(100,61*i);
                       robot.mousePress(InputEvent.BUTTON1_MASK);
                       robot.delay(3000);
                       robot.mouseRelease(InputEvent.BUTTON1_MASK);
                       //点击右边菜单对应内容窗口
                       robot.delay(3000);
                       moveMouse(200,100);
                       robot.mousePress(InputEvent.BUTTON1_MASK);
                       robot.delay(1000);
                       robot.keyPress(KeyEvent.VK_SHIFT); //按下空格键
                       moveMouse(200,800);
                       robot.keyRelease(KeyEvent.VK_SHIFT);
                       robot.mouseRelease(InputEvent.BUTTON1_MASK);
                       robot.keyPress(KeyEvent.VK_CONTROL);
                       robot.keyPress(KeyEvent.VK_C);
                       robot.delay(1000);
                       robot.keyRelease(KeyEvent.VK_CONTROL);
                       robot.keyRelease(KeyEvent.VK_C);

                   }





                }catch (Exception e){
                    e.printStackTrace();
                }

   }

    /**
     * todo 微信在线聊天数据爬取
     */
    public static void WechatCrawl(){
        //    moveMouse(200,100);
        try {

            for(int i=1;i<16;i++){
                Robot robot = new Robot();
                robot.delay(3000);
                moveMouse(100,57*i);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.delay(3000);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);


            }





        }catch (Exception e){
            e.printStackTrace();
        }
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