package com.transData.business.entity;

public class BusinessModel {
	private Integer model_id;
	private String serviceClassName;		//调用的className，通过此种方式会反射出类本身
	private String servicePath;             //调用的类路径，要与className配合
	private String serviceBeanName;         //如果是使用spring，则直接输入beanName即可
	private String methodName;              //调用的方法名称
	private Object paramterObject;          //需要传入的参数类型
	private String paramterClass;			//用于反射使用的全路径类名
	private String busiCode;				//业务编码
	
	private String resultMsg;				//返回的消息内容
	private Object resultObject;			//执行后返回的数据类型
	
	private String commonServiceName;		//执行业务模板方法
	private String columnNameType;			//如果执行模板业务时需要输入。确定表格与实体bean的映射模式，是驼峰原则or下划线方式
	
	
	public String getColumnNameType() {
		return columnNameType;
	}
	public void setColumnNameType(String columnNameType) {
		this.columnNameType = columnNameType;
	}
	public String getCommonServiceName() {
		return commonServiceName;
	}
	public void setCommonServiceName(String commonServiceName) {
		this.commonServiceName = commonServiceName;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public Integer getModel_id() {
		return model_id;
	}
	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}
	public String getParamterClass() {
		return paramterClass;
	}
	public void setParamterClass(String paramterClass) {
		this.paramterClass = paramterClass;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public Object getResultObject() {
		return resultObject;
	}
	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}
	public String getServiceClassName() {
		return serviceClassName;
	}
	public void setServiceClassName(String serviceClassName) {
		this.serviceClassName = serviceClassName;
	}
	public String getServicePath() {
		return servicePath;
	}
	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}
	public String getServiceBeanName() {
		return serviceBeanName;
	}
	public void setServiceBeanName(String serviceBeanName) {
		this.serviceBeanName = serviceBeanName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Object getParamterObject() {
		return paramterObject;
	}
	public void setParamterObject(Object paramterObject) {
		this.paramterObject = paramterObject;
	}
	
}
