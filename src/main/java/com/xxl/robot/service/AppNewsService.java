package com.xxl.robot.service;

/**
 * 
 * todo app-视频服务接口类接口
 */
public interface AppNewsService {


    /**
     * todo 早上收取昨晚金币（签到，领取睡觉金币）
     */
    public void start();

    /**
     * todo 白天执行一次
     */
    public void  one();

    /**
     * todo 循环执行领金币
     */
    public void circulate();
    /***
     * todo 玩游戏
     */
    public void playGame();


    /***
     * todo 晚上收取白天金币
     */
    public void end();




}
