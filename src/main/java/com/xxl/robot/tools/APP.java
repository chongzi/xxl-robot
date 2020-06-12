package com.xxl.robot.tools;


import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.InputEvent;

/**
 *  聊天窗口置为顶层，并放在屏幕左上角。窗口左、上边缘与屏幕左、上边缘重合
 *  聊天窗口大小 ： 613*536(默认)
 * */
public class APP{
    private Robot robot ;
    private Clipboard system;

    public APP() throws AWTException{
        robot = new Robot();
        system = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    private void moveMouse(int x,int y){
        robot.mouseMove(x, y);
        robot.delay(300);
    }

    private void leftClick(){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(300);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    private void rightClick(){
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.delay(300);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    public static void main(String[] args) throws AWTException{
        APP app = new APP();
        StringBuffer msg = new StringBuffer();
        long cnt = 0;
        while(true){
            cnt ++;






            //msg = new StringBuffer();
            //msg.append("\r随机消息"+cnt+"    ").append(StringUtil.dateToStr(new Date())+" \r");
            //msg.append("*&@@/wx￥%#刷！@#￥%……分……&*/wx￥#");
            //StringSelection stsel  = new StringSelection(msg.toString());
            //app.getSystem().setContents(stsel, stsel);
            //间隔5s
            app.getRobot().delay(10000);
            //移动鼠标到聊天窗口的输入框
            app.moveMouse(0, 453);
//                //鼠标右击
//                app.rightClick();
//                //移动鼠标到"粘贴"菜单
//                app.moveMouse(173,511);
//                //选择"粘贴"
//                app.leftClick();
//                //移动鼠标到"发送"按钮
//                app.moveMouse(357,526);
//                //发送
//                app.leftClick();
        }
    }
    public Robot getRobot() {
        return robot;
    }
    public void setRobot(Robot robot) {
        this.robot = robot;
    }
    public Clipboard getSystem() {
        return system;
    }
    public void setSystem(Clipboard system) {
        this.system = system;
    }

}
