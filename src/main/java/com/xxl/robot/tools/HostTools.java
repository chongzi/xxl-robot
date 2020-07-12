package com.xxl.robot.tools;

import java.net.InetAddress;

/**
 * todo 主机ip获取
 */
public class HostTools {

    /**
     * 获取本机ip
     * @return
     */
    public static String getHost(){
        InetAddress ia=null;
        String localip= null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
             localip=ia.getHostAddress();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return localip;
    }


}
