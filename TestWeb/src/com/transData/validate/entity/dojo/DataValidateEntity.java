package com.transData.validate.entity.dojo;

import java.util.Set;

import com.transData.validate.entity.base.ValidateRuleEntity;

public class DataValidateEntity {
	private String dataValidId; //ValidateId
	private String bussCode;	//业务编号
	private String dataValidName;	//字段名称，此部分与数据模板部分相同
	private Set<ValidateRuleEntity> validateRuleEntitySet; //需要校验的类型集合

	public DataValidateEntity() {
		super();
	}

	public DataValidateEntity(String dataValidName) {
		super();
		this.dataValidName = dataValidName;
	}

	public String getDataValidId() {
		return dataValidId;
	}

	public void setDataValidId(String dataValidId) {
		this.dataValidId = dataValidId;
	}

	public String getBussCode() {
		return bussCode;
	}

	public void setBussCode(String bussCode) {
		this.bussCode = bussCode;
	}

	public String getDataValidName() {
		return dataValidName;
	}

	public void setDataValidName(String dataValidName) {
		this.dataValidName = dataValidName;
	}

	public Set<ValidateRuleEntity> getValidateRuleEntitySet() {
		return validateRuleEntitySet;
	}

	public void setValidateRuleEntitySet(
			Set<ValidateRuleEntity> validateRuleEntitySet) {
		this.validateRuleEntitySet = validateRuleEntitySet;
	}
}
