package com.transData.port.entity;

public class ResponseMessageEntity {
	private String serialNumber;
	private String responseTime;
	private String responseCode;
	private String responseMessage;
	private String businessBody;
	public String getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getBusinessBody() {
		return businessBody;
	}
	public void setBusinessBody(String businessBody) {
		this.businessBody = businessBody;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
}
