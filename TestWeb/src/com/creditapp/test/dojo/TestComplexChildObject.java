package com.creditapp.test.dojo;

public class TestComplexChildObject {
	private String childName;
	private Integer childage;
	public String getChildName() {
		return childName;
	}
	public TestComplexChildObject(String childName, Integer childage) {
		super();
		this.childName = childName;
		this.childage = childage;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public Integer getChildage() {
		return childage;
	}
	public void setChildage(Integer childage) {
		this.childage = childage;
	}
}
