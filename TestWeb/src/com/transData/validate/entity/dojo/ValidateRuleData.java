package com.transData.validate.entity.dojo;

public class ValidateRuleData {
	private String dataValidId; //与DataValidateEntity形成一对多的关系
	private String enumTypeName;
	private String stringArguments;
	private String numberArguments;
	private String doubleArguments;
	private String validateEntityId;
	public String getValidateEntityId() {
		return validateEntityId;
	}
	public void setValidateEntityId(String validateEntityId) {
		this.validateEntityId = validateEntityId;
	}
	public String getDataValidId() {
		return dataValidId;
	}
	public void setDataValidId(String dataValidId) {
		this.dataValidId = dataValidId;
	}
	public String getEnumTypeName() {
		return enumTypeName;
	}
	public void setEnumTypeName(String enumTypeName) {
		this.enumTypeName = enumTypeName;
	}
	public String getStringArguments() {
		return stringArguments;
	}
	public void setStringArguments(String stringArguments) {
		this.stringArguments = stringArguments;
	}
	public String getNumberArguments() {
		return numberArguments;
	}
	public void setNumberArguments(String numberArguments) {
		this.numberArguments = numberArguments;
	}
	public String getDoubleArguments() {
		return doubleArguments;
	}
	public void setDoubleArguments(String doubleArguments) {
		this.doubleArguments = doubleArguments;
	}
}
