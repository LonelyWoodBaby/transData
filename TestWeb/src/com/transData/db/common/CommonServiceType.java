package com.transData.db.common;

public enum CommonServiceType {
	INSERT("insert"),UPDATE("update"),DELETE("delete"),SELECT_ONE("selectOne"),SELECT_PAGE("selectPage");
	
	private String typeName;
	private CommonServiceType(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName(){
		return this.typeName;
	}
	
	public static CommonServiceType getServiceType(String name){
		for(CommonServiceType type : values()){
			if(type.getTypeName().equalsIgnoreCase(name)){
				return type;
			}
		}
		return null;
	}
}
