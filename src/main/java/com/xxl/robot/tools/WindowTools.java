package com.xxl.robot.tools;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;

/**
 * todo 自动复制，发送，截取window中程序中内容，实现模拟人工操作电脑
 */
public class WindowTools {


    /**
     * todo 初始化Window窗口弹出
     * @param windowName 窗口名
     */
    public static void initWindow(String windowName){
        HWND hwnd = getHWND(windowName);
        if (null != hwnd) {
            User32.INSTANCE.ShowWindow(hwnd, 0x03);        // SW_RESTORE
            User32.INSTANCE.SetForegroundWindow(hwnd);   // bring to front
            User32.INSTANCE.GetForegroundWindow() ;//获取现在前台窗口
            WinDef.RECT qqwin_rect = new WinDef.RECT();
            User32.INSTANCE.GetWindowRect(hwnd, qqwin_rect);


            int qqwin_width = qqwin_rect.right - qqwin_rect.left;
            int qqwin_height = qqwin_rect.bottom - qqwin_rect.top;



        }

    }




    /**
     * todo 1.根据窗口名获取窗口句柄（handle of window,窗口的句柄）
     * @param windowName 窗口名
     * @return
     */
    public static HWND getHWND(String windowName){
        HWND hwnd = User32.INSTANCE.FindWindow (null, windowName);
        return hwnd;
    }


    /**
     * todo 2.1展示窗口，并置为活动窗口显示最前面
     * @param hwnd 窗口句柄
     */
    public static boolean showWindow(HWND hwnd) {
        if (hwnd == null) {
             return false;
        } else {
            int SW_MAXIMIZE = 0x03;//11
            User32.INSTANCE.ShowWindow(hwnd, SW_MAXIMIZE);//展示窗口显示窗口大小
            User32.INSTANCE.SetForegroundWindow(hwnd);   // bring to front(该函数将创建指定窗口的线程设置到前台，并且激活该窗口.置为活动窗口，最前面)
            return true;
        }
    }

    /**
     * todo 2.2隐藏窗口
     * @param hwnd 窗口句柄
     */
    public static boolean hideWindow(HWND hwnd){
        if (hwnd == null) {
             return false;
        } else {
            int SW_MINIMIZE = 0x06;
            User32.INSTANCE.ShowWindow(hwnd, SW_MINIMIZE);
            User32.INSTANCE.SetForegroundWindow(hwnd);   //bring to front(该函数将创建指定窗口的线程设置到前台，并且激活该窗口.置为活动窗口，最前面)
            return true;
        }
    }




    public static void main(String args[]){

    }


}
