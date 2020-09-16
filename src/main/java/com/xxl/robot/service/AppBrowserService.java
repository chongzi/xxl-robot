package com.xxl.robot.service;

/**
 * 
 * todo app-视频服务接口类接口
 */
public interface AppBrowserService {


    /**
     * todo 早上收取金币（用户行为：1.签到 2.领取睡觉金币）
     */
    public void start();

    /**
     * todo 时段收取金币（用户行为：1.喝水 2.种菜 3.充电 4.吃饭）
     */
    public void  section();

    /**
     * todo 循环收取金币大于200金币（1.开宝箱 2.看广告 3.领红包 4.抽奖 5.刮卡）
     */
    public void circulate();

    /***
     * todo 晚上收取金币（1.收取步行金币 2.个性化一次性收取 3.分享 4.游戏）
     */
    public void end();

//**************************************************少量金币******************************************************

    /***
     * todo 玩游戏（少量金币，适合网络开启）
     */
    public void playGame();

    /**
     * todo 看视频（少量金币，适合网络开启）
     */
    public void watchMedia();

    /**
     * todo 看新闻（少量金币，适合网络开启）
     */
    public void watchNews();

    /**
     * todo 其它（少量金币，适合网络开启）
     */
    public void other();




}
