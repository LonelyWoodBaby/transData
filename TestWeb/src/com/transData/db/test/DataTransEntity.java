package com.transData.db.test;

public class DataTransEntity {
	private String dataTransId; //id
	private String bussCode; //业务编号
	private String dataTransName; //字段名称,此部分与校验模板，实际传输字段名称匹配
	private String showChnName; //该字段的解释说明
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
