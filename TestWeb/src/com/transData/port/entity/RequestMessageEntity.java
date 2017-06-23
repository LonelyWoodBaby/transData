package com.transData.port.entity;


public class RequestMessageEntity {
	private String serialNumber;
	private String operatorNo;//操作员编号 必输
	private String departmentNo;//操作员机构号/部门号 必输
	private String passworkKey;//交易公钥 除登陆以外必输
	private String requestTime;//请求时间 必输
	private String tradeCode;//交易主码 必输
	private String assistCode;//交易辅码 非必输
	private String businessBody;//交易报文主体 非必输
	private String requestInfo;//请求附加消息说明 非必输
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}
	public String getOperatorNo() {
		return operatorNo;
	}
	public void setOperatorNo(String operatorNo) {
		this.operatorNo = operatorNo;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getPassworkKey() {
		return passworkKey;
	}
	public void setPassworkKey(String passworkKey) {
		this.passworkKey = passworkKey;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	public String getAssistCode() {
		return assistCode;
	}
	public void setAssistCode(String assistCode) {
		this.assistCode = assistCode;
	}
	public String getBusinessBody() {
		return businessBody;
	}
	public void setBusinessBody(String businessBody) {
		this.businessBody = businessBody;
	}
}
