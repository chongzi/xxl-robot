package com.xxl.robot.enums;

/**
 * todo 汽车共享
 * @author xuxuelei
 *
 */
public enum CarEnum {

	BACK("回", "回"),
	BACK_HOME("回家", "回家"),
	BACK_BACK("返回", "返回"),
	ARRIVE("到", "到"),
	ARRIVE_DA("到达", "到达"),
	GO("去", "去"),
	MIDDLE_LINE("-", "-"),
	MIDDLE_LINE1("—", "——"),

	BELT("带", "带"),
	INDIVIDUAL("个","个"),
	POSITION("位","位"),
	PERSON("人","人"),
	TODAY("今天", "今天"),
	TOMORROW("明天", "明天"),
	AFTER_TOMORROW("后天", "后天"),
	NUMBER("号", "号"),
	MORNING("早上", "早上"),
	MORNING1("上午", "上午"),
	NOON("中午", "中午"),
	NOON1("午饭", "午饭"),
	AFTERNOON("下午", "下午"),
	EVENING("晚上", "晚上"),
	EVENING1("晚饭", "晚饭"),
	POINT("点", "点"),
	ANYTIME("随时","随时");

	private String code;
	private String message;

	CarEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
