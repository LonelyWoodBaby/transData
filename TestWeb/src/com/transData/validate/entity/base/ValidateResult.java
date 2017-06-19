package com.transData.validate.entity.base;


public class ValidateResult {
	private String validateColumnName;
	private String validateColumnValue;
	private ValidateEnum validateType;
	private String validateMsg;
	
	public ValidateResult(String validateColumnName,
			String validateColumnValue, ValidateEnum validateType,
			String validateMsg) {
		super();
		this.validateColumnName = validateColumnName;
		this.validateColumnValue = validateColumnValue;
		this.validateType = validateType;
		this.validateMsg = validateMsg;
	}
	
	public ValidateResult(String validateColumnName,
			String validateColumnValue, ValidateEnum validateType) {
		super();
		this.validateColumnName = validateColumnName;
		this.validateColumnValue = validateColumnValue;
		this.validateType = validateType;
	}
	
	public ValidateResult buildValidateMsg(String validateMsg){
		this.setValidateMsg(validateMsg);
		return this;
	}

	public String getValidateColumnName() {
		return validateColumnName;
	}
	public void setValidateColumnName(String validateColumnName) {
		this.validateColumnName = validateColumnName;
	}
	public String getValidateColumnValue() {
		return validateColumnValue;
	}
	public void setValidateColumnValue(String validateColumnValue) {
		this.validateColumnValue = validateColumnValue;
	}
	public ValidateEnum getValidateType() {
		return validateType;
	}
	public void setValidateType(ValidateEnum validateType) {
		this.validateType = validateType;
	}
	public String getValidateMsg() {
		return validateMsg;
	}
	public void setValidateMsg(String validateMsg) {
		this.validateMsg = validateMsg;
	}
	
	
}
