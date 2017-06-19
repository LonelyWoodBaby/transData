package com.transData.validate.entity.base;

import java.util.HashMap;
import java.util.Map;

import com.transData.trans.entity.DataTransEntity;
import com.transData.validate.entity.dojo.DataValidateEntity;

public class ValidateEntityStock {
	private String bussCode;	//业务编号
	private String dataValidName;	//字段名称，此部分与数据模板部分相同
	private String validateValue;//准备要进行校验的值
	
	private Map<ValidateRuleEntity,ValidateResult> validateResultMap; //校验结束后将对应点结果保存在对应的Map中，以校验类型为key值

	public ValidateEntityStock() {
		super();
	}

	public ValidateEntityStock(String bussCode, String dataValidName,
			String validateValue) {
		super();
		this.bussCode = bussCode;
		this.dataValidName = dataValidName;
		this.validateValue = validateValue;
	}

	public Map<ValidateRuleEntity, ValidateResult> getValidateResultMap() {
		return validateResultMap;
	}

	public void setValidateResultMap(Map<ValidateRuleEntity, ValidateResult> validateResultMap) {
		this.validateResultMap = validateResultMap;
	}

	public String getValidateValue() {
		return validateValue;
	}

	public void setValidateValue(String validateValue) {
		this.validateValue = validateValue;
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
	
	public static ValidateEntityStock createValidateEntityStockFromDataEntity(DataTransEntity transEntity, DataValidateEntity validateEntity){
		ValidateEntityStock stock = new ValidateEntityStock(transEntity.getBussCode(),transEntity.getDataTransName(),transEntity.getDataValue());
		Map<ValidateRuleEntity,ValidateResult> validateResultMap = new HashMap<ValidateRuleEntity,ValidateResult>();
		for(ValidateRuleEntity ruleEntity : validateEntity.getValidateRuleEntitySet()){
			validateResultMap.put(ruleEntity, null);
		}
		stock.setValidateResultMap(validateResultMap);
		return stock;
	}
	
}
