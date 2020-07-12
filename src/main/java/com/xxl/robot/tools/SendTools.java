package com.xxl.robot.tools;

import com.github.binarywang.java.emoji.EmojiConverter;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * todo 发送数据（获取数据库中数据发送，截取window中程序中内容，实现模拟人工操作电脑）
 */
public class SendTools {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SendTools.class);

    private Clipboard system;


    /**
     * todo 弹出QQ窗口程序，自动发送QQ相应数据 8s 共 3.2s
     *  param windowName 窗口名称
     *  param dbData     要发送的数据
     */
    public static void QQSend(String windowName,String dbData) {
        try {
            //点击左边菜单标题
            Robot robot = new Robot();
            EmojiConverter emojiConverter = EmojiConverter.getInstance();
            boolean bool = WindowTools.initWindow(windowName);
            if (bool) {
                setClipboard(dbData);
                robot.delay(2000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.delay(600);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.delay(600);
                robot.keyRelease(KeyEvent.VK_ENTER);
                System.out.println("QQ自动发送数据******************");

            } else {
                //调出相应的QQ标题窗口
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_Z);
                    robot.delay(100);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    robot.keyRelease(KeyEvent.VK_Z);
            }
        }catch (Exception e){
            log.info("QQSend--QQ自动发送出现异常：{}");
            e.printStackTrace();
        }
    }



    /**
     * todo 微信在线聊天数据爬取
     */
    public static void WechatSend(){
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






    /**
     * todo 获取系统剪切板中的内容
     * @return
     */
    public static String getClipboard(){
        Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable clipTf =sysClip.getContents(null);
        if(clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)){
            try{
                String ret = (String) clipTf.getTransferData(DataFlavor.stringFlavor);
                return ret ;
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return null ;
    }


    /**
     * todo 向剪贴板中添加内容
     * @param contents
     */
    public static void setClipboard(String contents) {
        StringSelection stringSelection = new StringSelection( contents );
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
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
        QQSend("拼多多砍价互砍群","测试自动发报机");
    }


}
