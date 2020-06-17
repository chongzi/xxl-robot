package com.xxl.robot.service;

import com.xxl.robot.enums.CarEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static  void main(String args[]){
         String rowData = "爱拼才会赢 23:15:17车找人:6月18号 （明天）早上宿迁回去上海，豪华七座商务车，空间大，乘坐舒适，需要提前电话13951361868（微信同号），开车不方便看微信，请打电话给我握手][握手]大兴人 8:42:05车找人.包接包送，17号宿迁.泗阳到上海，18号上海回泗阳.宿迁，需要出行的老乡打电话给我18012115850\n";
        String ss = rowData.substring(rowData.indexOf(CarEnum.BACK.getCode())-2,rowData.indexOf(CarEnum.BACK.getCode()));
        System.out.println(ss);
    }

}
