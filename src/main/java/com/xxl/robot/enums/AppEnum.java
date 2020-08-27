package com.xxl.robot.enums;

/**
 * todo APP用户行为
 * @author xuxuelei
 *
 */
public enum AppEnum {

	CHECK_IN( "签到"),
	WATCH_VIDEOS("看视频"),
	CONCERN( "关注"),
	GIVE_UP( "点赞"),
	COLLECT("收藏"),
	COMMENT("评论"),
	TREASURE("开宝箱"),
	GROW( "种菜"),
	WALK( "走路"),
	SLEEP("睡觉"),
	NOVELS("看小说"),
	PALY_GAMES("玩游戏"),
	MONEY_TREE( "摇钱树"),
	SHARE( "分享"),
	DRAW("抽奖"),
	EAT( "吃饭"),
	DRINK_WATER( "喝水"),
	WATCH_NEWS("看新闻"),
	CHARGE( "充电"),
	MUSIC("听歌曲");

	private String code;

	AppEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
