package com.transData.validate.entity.base;

public enum ValidateEnum {
	//非空系列
	NOT_NULL("NOT_NULL"),//不能为空
	NOT_BLANK("NOT_BLANK"),//不能为空字符，且字符长度必须大于零
	NOT_EMPTY("NOT_EMPTY"),//字符串长度必须大于零，但可以是一串空字符
	//字符长度系列
	MAX_LENGTH("MAX_LENGTH"),//参数最大长度
	MIN_LENGTH("MIN_LENGTH"),//参数最小长度
	LENGTH_SIZE("LENGTH_SIZE"),//参数长度范围
	//数据类型系列
	IS_BOOLEAN("IS_BOOLEAN"),//必须是布尔值
	IS_NUMBER("IS_NUMBER"),//必须是整数类型
	IS_FLOAT_NUMBER("IS_FLOAT_NUMBER"),//允许为小数类型
	IS_DATE("IS_DATE"),//必须是日期，支持格式为yyyy-MM-dd或yyyy/MM/dd
	//IS_TIME,//必须是时间
	//最大值（数字比较）系列
	MAX_VALUE("MAX_VALUE"),//最大值不得超过
	MIN_VALUE("MIN_VALUE"),//最小值不得超过
	ASSERT_EQUAL("ASSERT_EQUAL"),//结果值必须相等
	//特殊类型系列
	IS_EMAIL("IS_EMAIL"),//是否为邮箱格式
	IS_ID_CARD("IS_ID_CARD"),//是否为身份证格式
	IS_IP_ADDRSS("IS_IP_ADDRSS"),//验证是否为IP地址
	PATTERN("PATTERN") //自定义正则
	;
	
	private String enumTypeValue;
	private ValidateEnum(String enumTypeValue){
		this.enumTypeValue = enumTypeValue;
	}
	
	public static ValidateEnum getEnumType(String enumTypeValue){
		for(ValidateEnum type:ValidateEnum.values()){
			if(type.enumTypeValue.equals(enumTypeValue)){
				return type;
			}
		}
		return null;
	}
}
