package com.transData.validate.log.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.transData.trans.entity.DataTransEntity;
import com.transData.validate.entity.base.ValidateEntityStock;
import com.transData.validate.entity.base.ValidateResult;
import com.transData.validate.entity.base.ValidateRuleEntity;
import com.transData.validate.entity.dojo.DataValidateEntity;

public class ValidateLog {
	private String bussCode;
	private boolean validateStatus;
	private Map<DataTransEntity,ValidateEntityStock> verifyResultMap;
	private Date createTime;
	private List<DataValidateEntity> validateEntityList;//用于取数时用的，参与校验的校验模板数据。
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getBussCode() {
		return bussCode;
	}
	public void setBussCode(String bussCode) {
		this.bussCode = bussCode;
	}
	public boolean isValidateStatus() {
		return validateStatus;
	}
	public void setValidateStatus(boolean validateStatus) {
		this.validateStatus = validateStatus;
	}
	public Map<DataTransEntity, ValidateEntityStock> getVerifyResultMap() {
		return verifyResultMap;
	}
	public void setVerifyResultMap(
			Map<DataTransEntity, ValidateEntityStock> verifyResultMap) {
		this.verifyResultMap = verifyResultMap;
	}
	
	public List<DataValidateEntity> getValidateEntityList() {
		return validateEntityList;
	}
	public void setValidateEntityList(List<DataValidateEntity> validateEntityList) {
		this.validateEntityList = validateEntityList;
	}
	public String showLog(){
		StringBuilder showMsg = new StringBuilder("");
		showMsg.append("业务编号【" + this.bussCode + "】数据校验");
		if(validateStatus){
			showMsg.append("成功！");
			return showMsg.toString();
		}
		
		showMsg.append("失败。错误信息包括：\n") ;
		ValidateEntityStock stock = null;
		ValidateResult result = null;
		for(DataTransEntity transData : verifyResultMap.keySet()){
			 stock = verifyResultMap.get(transData);
			 showMsg.append("【"+transData.getDataTransName()+"】校验不通过，错误信息为：");
			 for(ValidateRuleEntity ruleEntity : stock.getValidateResultMap().keySet()){
				 result = stock.getValidateResultMap().get(ruleEntity);
				 showMsg.append(result.getValidateMsg()+" | ");
			 }
			 showMsg.append("\n");
		}
		
		return showMsg.toString();
	}
	
}
