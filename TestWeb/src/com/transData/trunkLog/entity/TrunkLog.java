package com.transData.trunkLog.entity;

public class TrunkLog {
	private String logId;					// 日志ID
	private String serialNumber;            // 日志流水号
	private String operatorNo;				// 操作员号码
	private String reqeustDataJson;         // 请求报文json数据
	private String responseDataJson;        // 响应报文json数据
	private String logTime;                 // 日志时间
	private String tradeCode;               // 交易主码
	private String userStatus;              // 用户权限通过状态
	private String validateStatus;          // 数据校验通过状态
	private String validateLog;             // 数据校验日志记录
	private String businessStatus;          // 业务执行状态
	private String businessExceptionMsg;    // 业务执行错误消息
	private String executeClass;            // 业务执行类
	private String executeMethod;           // 业务执行方法
	private String executeParams;           // 业务执行参数
	private String responseCode; 			// 响应状态码
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getOperatorNo() {
		return operatorNo;
	}
	public void setOperatorNo(String operatorNo) {
		this.operatorNo = operatorNo;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getReqeustDataJson() {
		return reqeustDataJson;
	}
	public void setReqeustDataJson(String reqeustDataJson) {
		this.reqeustDataJson = reqeustDataJson;
	}
	public String getResponseDataJson() {
		return responseDataJson;
	}
	public void setResponseDataJson(String responseDataJson) {
		this.responseDataJson = responseDataJson;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public String getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getValidateStatus() {
		return validateStatus;
	}
	public void setValidateStatus(String validateStatus) {
		this.validateStatus = validateStatus;
	}
	public String getValidateLog() {
		return validateLog;
	}
	public void setValidateLog(String validateLog) {
		this.validateLog = validateLog;
	}
	public String getBusinessStatus() {
		return businessStatus;
	}
	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}
	public String getBusinessExceptionMsg() {
		return businessExceptionMsg;
	}
	public void setBusinessExceptionMsg(String businessExceptionMsg) {
		this.businessExceptionMsg = businessExceptionMsg;
	}
	public String getExecuteClass() {
		return executeClass;
	}
	public void setExecuteClass(String executeClass) {
		this.executeClass = executeClass;
	}
	public String getExecuteMethod() {
		return executeMethod;
	}
	public void setExecuteMethod(String executeMethod) {
		this.executeMethod = executeMethod;
	}
	public String getExecuteParams() {
		return executeParams;
	}
	public void setExecuteParams(String executeParams) {
		this.executeParams = executeParams;
	}
	
	public String printLogInfo(){
		StringBuilder logInfoBuilder = new StringBuilder("本次交易日志信息：\n");
		logInfoBuilder.append("--------------------------------------------\n");
		logInfoBuilder.append("交易流水号： " +this.getSerialNumber()+"\n");
		logInfoBuilder.append("交易时间： " +this.getLogTime() +"\n");
		logInfoBuilder.append("请求操作员号码： " +this.getOperatorNo() +"\n");
		logInfoBuilder.append("交易主码： " +this.getTradeCode() +"\n");
		String userStatus = ("1".equals(this.getUserStatus()))?"通过":"未通过";
		logInfoBuilder.append("用户在线状态校验： " + userStatus +"\n");
		logInfoBuilder.append("--------------------------------------------\n");
		if(!"1".equals(this.getUserStatus()))return logInfoBuilder.toString();
		logInfoBuilder.append("请求数据Josn集合： " +this.getReqeustDataJson() +"\n");
		String validateStatus = ("1".equals(this.getValidateStatus()))?"通过":"未通过";
		logInfoBuilder.append("数据校验状态： " +validateStatus +"\n");
		logInfoBuilder.append("--------------------------------------------\n");
		if(!"1".equals(this.getValidateStatus()))return logInfoBuilder.toString();
		logInfoBuilder.append("业务执行类： " +this.getExecuteClass() +"\n");
		logInfoBuilder.append("业务执行方法： " +this.getExecuteMethod() +"\n");
		String businessStatus = ("1".equals(this.getBusinessStatus()))?"通过":"未通过";
		logInfoBuilder.append("业务执行状态： " +businessStatus+"\n");
		if(!"1".equals(this.getBusinessStatus()))
			logInfoBuilder.append("业务异常信息： " + this.getBusinessExceptionMsg() +"\n");
		logInfoBuilder.append("--------------------------------------------\n");
		logInfoBuilder.append("响应数据集合： " + this.responseDataJson +"\n");
		logInfoBuilder.append("--------------------------------------------\n");
		return logInfoBuilder.toString();
	}
	
}
