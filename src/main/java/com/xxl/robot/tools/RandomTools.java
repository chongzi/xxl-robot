package com.xxl.robot.tools;

import java.util.Random;

public class RandomTools {

    /**
     * 随机产生 1-100之间数
     * @return
     */
    public static int init(int number){
        Random rand =new Random();
        int i=rand.nextInt(number);
        return i;
    }
}
