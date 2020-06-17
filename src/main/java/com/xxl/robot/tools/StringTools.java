package com.xxl.robot.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * todo 智能获取字符串中数据
 */
public class StringTools {

    /**
     * todo java提取字符串中手机号
     * @param str
     * @return
     */
    public static String getMobile(String str) {
         if (str == null || str.length() <= 0)
            return null;
        Pattern pattern = Pattern.compile(RegTools.PHONE);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            return matcher.group();
        }
        return null;
    }



}
