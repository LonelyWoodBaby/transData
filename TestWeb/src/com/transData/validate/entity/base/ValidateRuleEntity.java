package com.transData.validate.entity.base;

import com.transData.util.ParametersUtil;
import com.transData.validate.entity.dojo.ValidateRuleData;



public class ValidateRuleEntity {
	private String dataValidId; //ValidateId
	private ValidateEnum enumType;
	private String[] stringParams;
	private int[] numberParams;
	private double[] doubleParams;
	
	public ValidateRuleEntity() {
		super();
	}
	
	public ValidateRuleEntity(ValidateRuleData ruleData) {
		this.dataValidId = ruleData.getDataValidId();
		this.enumType = ValidateEnum.getEnumType(ruleData.getEnumTypeName());
		this.stringParams = (ruleData.getStringArguments() == null || ruleData.getStringArguments().trim().isEmpty()) ? null : ruleData.getStringArguments().split(ParametersUtil.ARGUMENTS_SPLIT_SIGN);
		if (ruleData.getNumberArguments() == null || ruleData.getNumberArguments().trim().isEmpty())
			this.numberParams = null;
		else{
			String[] numberArrays = ruleData.getNumberArguments().split(ParametersUtil.ARGUMENTS_SPLIT_SIGN);
			this.numberParams = new int[numberArrays.length];
			for(int i=0;i<numberArrays.length;i++){
				numberParams[i]=Integer.parseInt(numberArrays[i]);
			}
		}
		
		if (ruleData.getDoubleArguments() == null || ruleData.getDoubleArguments().trim().isEmpty())
			this.doubleParams = null;
		else{
			String[] doubleArrays = ruleData.getDoubleArguments().split(ParametersUtil.ARGUMENTS_SPLIT_SIGN);
			this.doubleParams = new double[doubleArrays.length];
			for(int i=0;i<doubleArrays.length;i++){
				doubleParams[i]=Double.parseDouble(doubleArrays[i]);
			}
		}
	}

	public String getDataValidId() {
		return dataValidId;
	}
	public void setDataValidId(String dataValidId) {
		this.dataValidId = dataValidId;
	}
	public ValidateEnum getEnumType() {
		return enumType;
	}
	public void setEnumType(ValidateEnum enumType) {
		this.enumType = enumType;
	}
	public String[] getStringParams() {
		return stringParams;
	}
	public void setStringParams(String[] stringParams) {
		this.stringParams = stringParams;
	}
	public int[] getNumberParams() {
		return numberParams;
	}
	public void setNumberParams(int[] numberParams) {
		this.numberParams = numberParams;
	}
	public double[] getDoubleParams() {
		return doubleParams;
	}
	public void setDoubleParams(double[] doubleParams) {
		this.doubleParams = doubleParams;
	}
	
	
}
