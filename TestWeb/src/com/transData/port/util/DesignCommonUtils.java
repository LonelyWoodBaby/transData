package com.transData.port.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.transData.port.entity.ResponseMessageEntity;

public class DesignCommonUtils {
	public static String getDateTimeForNow(){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
	
	/**
	 * 以下四种多态方法为返回一个响应报文体。参数分别为：返回响应状态status，响应时间dateTime，返回结果实体类json串
	 * @param status
	 * @return
	 */
	public static ResponseMessageEntity createNewResponseMessage(ResponseStatus status){
		return DesignCommonUtils.createNewResponseMessage(status, "");
	}
	
	public static ResponseMessageEntity createNewResponseMessage(ResponseStatus status,String businessBody){
		return DesignCommonUtils.createNewResponseMessageWithTime(status, DesignCommonUtils.getDateTimeForNow(), businessBody);
	}
	
	public static ResponseMessageEntity createNewResponseMessageWithTime(ResponseStatus status,String dateTime){
		return DesignCommonUtils.createNewResponseMessageWithTime(status, dateTime, "");
	}
	
	public static ResponseMessageEntity createNewResponseMessageWithTime(ResponseStatus status,String dateTime,String businessBody){
		ResponseMessageEntity responseMessageEntity = new ResponseMessageEntity();
		responseMessageEntity.setResponseTime(dateTime);
		responseMessageEntity.setResponseMessage(status.getStatusMessage());
		responseMessageEntity.setResponseCode(status.getStatusCode());
		responseMessageEntity.setBusinessBody(businessBody);
		return responseMessageEntity;
	}
}
