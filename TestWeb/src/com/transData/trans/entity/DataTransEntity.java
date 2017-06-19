package com.transData.trans.entity;

import java.util.List;

public class DataTransEntity {
	private String dataTransId; //id
	private String bussCode; //业务编号
	private String dataTransName; //字段名称,此部分与校验模板，实际传输字段名称匹配
	private String showChnName; //该字段的解释说明
	private List<DataTransEntity> childrenList;
	
	private String dataValue;//该字段的实际值，不保存在数据库中
	
	
	public DataTransEntity() {
		super();
	}
	
	public DataTransEntity(String dataTransName) {
		super();
		this.dataTransName = dataTransName;
	}

	public DataTransEntity(String bussCode, String dataTransName,
			String showChnName) {
		super();
		this.bussCode = bussCode;
		this.dataTransName = dataTransName;
		this.showChnName = showChnName;
	}
	
	public List<DataTransEntity> getChildrenList() {
		return childrenList;
	}
	public void setChildrenList(List<DataTransEntity> childrenList) {
		this.childrenList = childrenList;
	}

	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	public String getDataTransId() {
		return dataTransId;
	}
	public void setDataTransId(String dataTransId) {
		this.dataTransId = dataTransId;
	}
	public String getBussCode() {
		return bussCode;
	}
	public void setBussCode(String bussCode) {
		this.bussCode = bussCode;
	}
	public String getDataTransName() {
		return dataTransName;
	}
	public void setDataTransName(String dataTransName) {
		this.dataTransName = dataTransName;
	}
	public String getShowChnName() {
		return showChnName;
	}
	public void setShowChnName(String showChnName) {
		this.showChnName = showChnName;
	}
	
}
