package com.xxl.robot.service;

/**
 * 
 * todo app-视频服务接口类接口
 */
public interface AppMediaService {

//**********************一种类型：签到，睡觉，步行，一次性，分享********************************************************
    /**
     * todo 1-早上收取金币（用户行为：1.签到 2.领取睡觉金币）
     */
    public void start(String robotCode);

    /***
     * todo 1-晚上收取金币（1.收取步行金币 2.个性化一次性收取 3.分享）
     */
    public void end(String robotCode);

//************************二种类型：喝水，打卡，种菜，充电，吃饭********************************************************
    /**
     * todo 2-时段收取金币（用户行为：1.喝水 2.种菜 3.充电 4.吃饭）
     */
    public void  section(String robotCode);

//*************************三种类型：开宝箱，看广告，领红包********************************************************
    /**
     * todo 3-循环收取金币大于200金币（1.开宝箱 2.看广告 3.领红包）
     */
    public void circulate(String robotCode);

//************************四种类型：玩游戏********************************************************
    /***
     * todo 4-玩游戏（少量金币，适合网络开启）
     */
    public void playGame(String robotCode);

//************************五种类型：看视频，看新闻，看小说********************************************************
    /**
     * todo 5-看视频（少量金币，适合网络开启）
     */
    public void watchMedia(String robotCode);

    /**
     * todo 5-看新闻（少量金币，适合网络开启）
     */
    public void watchNews(String robotCode);

    /**
     * todo 5-看小说（少量金币，适合网络开启）
     */
    public void watchNovel(String robotCode);

//************************六种类型： 抽奖 刮卡********************************************************
    /**
     * todo 6-其它（抽奖 刮卡,猜成语）
     */
    public void other(String robotCode);


}
