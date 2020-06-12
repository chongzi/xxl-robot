package com.xxl.robot.tools;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;

/**
 * Created by lenovo on 2017/4/27.
 * 使用winID来获得窗口的类型和标题，然后发送消息或者其他操作
 *
 */
public class JnaTest {
    public static void main(String[] args) {

        HWND hwnd = User32.INSTANCE.FindWindow(null, "铁柱-铁粉大家庭等5个会话"); // 第一个参数是Windows窗体的窗体类，第二个参数是窗体的标题。不熟悉windows编程的需要先找一些Windows窗体数据结构的知识来看看，还有windows消息循环处理，其他的东西不用看太多。
         if (hwnd == null) {

        } else {
            User32.INSTANCE.ShowWindow(hwnd, 0x03);        // SW_RESTORE
            User32.INSTANCE.SetForegroundWindow(hwnd);   // bring to front
             User32.INSTANCE.GetForegroundWindow() ;//获取现在前台窗口
            WinDef.RECT qqwin_rect = new WinDef.RECT();
            User32.INSTANCE.GetWindowRect(hwnd, qqwin_rect);

             System.out.println("right:{}"+qqwin_rect.right);
             System.out.println("left:{}"+qqwin_rect.left);
            int qqwin_width = qqwin_rect.right - qqwin_rect.left;
            int qqwin_height = qqwin_rect.bottom - qqwin_rect.top;

            System.out.println(qqwin_height);
            System.out.println(qqwin_width);




        }
    }

}