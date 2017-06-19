package com.transData.port.util;

public enum ResponseStatus {
	USER_STATUS_ABNORMAL("101","用户状态异常"),
	DATA_VALIDATE_FAILED("302","数据校验失败"),
	BUSINESS_ACCEPT_SUCCESS("200","业务受理成功"),
	BUSINESS_ACCEPT_FAILED("501","业务受理失败");
	
	private String statusMessage;
	private String statusCode;
	private ResponseStatus(String statusCode, String statusMessage){
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}
	public String getStatusMessage(){
		return this.statusMessage;
	}
	public String getStatusCode(){
		return this.statusCode;
	}
	
	public static String getStatusMessage(ResponseStatus statusCode){
		for(ResponseStatus code : ResponseStatus.values()){
			if(code == statusCode)return code.statusMessage;
		}
		return null;
	}
}
