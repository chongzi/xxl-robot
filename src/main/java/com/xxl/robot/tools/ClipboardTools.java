package com.xxl.robot.tools;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * todo 系统剪切板操作
 */
public class ClipboardTools {


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



}
