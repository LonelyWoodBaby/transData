package com.transData.business.entity;

import java.util.List;

import com.transData.trans.entity.DataTransEntity;

public class ArgumentsEntity {
	private String busiCode;
	private String assistCode;
	private String operatorNo;
	private String departmentNo;
	private List<DataTransEntity> prepareDataList;
	private List<List<DataTransEntity>> prepareDataArrayList;
	private boolean isArrayData;
	public boolean isArrayData() {
		return isArrayData;
	}
	public void setArrayData(boolean isArrayData) {
		this.isArrayData = isArrayData;
	}
	public List<List<DataTransEntity>> getPrepareDataArrayList() {
		return prepareDataArrayList;
	}
	public void setPrepareDataArrayList(
			List<List<DataTransEntity>> prepareDataArrayList) {
		this.prepareDataArrayList = prepareDataArrayList;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public String getAssistCode() {
		return assistCode;
	}
	public void setAssistCode(String assistCode) {
		this.assistCode = assistCode;
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
	public List<DataTransEntity> getPrepareDataList() {
		return prepareDataList;
	}
	public void setPrepareDataList(List<DataTransEntity> prepareDataList) {
		this.prepareDataList = prepareDataList;
	}
	
}
