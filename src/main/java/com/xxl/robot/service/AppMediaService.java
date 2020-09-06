package com.xxl.robot.service;

/**
 * 
 * todo app-视频服务接口类接口
 */
public interface AppMediaService {


    /**
     * todo 早上收取昨晚金币（签到，领取睡觉金币）
     * 早上6点到-8点执行
     */
    public void start();

    /**
     * todo 白天执行一次
     * 早上8-10点
     */
    public void  one();

    /**
     * todo 循环执行领金币
     * 每次30分钟执行一次
     */
    public void circulate();


    /***
     * todo 晚上收取白天金币
     * 每天晚上8点执行
     */
    public void end();


    /***
     * todo 玩游戏
     */
    public void playGame();

//*******************************************以下操作只能得取少量金币*******************************************************

    /**
     * todo 看视频
     */
    public void watchMedia();

    /**
     * todo 看小说
     */
    public void watchNovels();

    /**
     * todo 看新闻
     */
    public void watchNews();

    /**
     * todo 其它
     */
    public void other();


}
