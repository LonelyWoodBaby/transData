package com.creditapp.test.dojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.transData.exception.JsonTransException;
import com.transData.util.JsonTrans;

public class TestComplexObject {
	private String strValue;
	private Integer integerValue;
	private Double doubleValue;
	private List<String> strList;
	private String[] strArrays;
	private List<TestComplexChildObject> childrenList;
	
	public List<TestComplexChildObject> getChildrenList() {
		return childrenList;
	}
	public void setChildrenList(List<TestComplexChildObject> childrenList) {
		this.childrenList = childrenList;
	}
	public String getStrValue() {
		return strValue;
	}
	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}
	public Integer getIntegerValue() {
		return integerValue;
	}
	public void setIntegerValue(Integer integerValue) {
		this.integerValue = integerValue;
	}
	public Double getDoubleValue() {
		return doubleValue;
	}
	public void setDoubleValue(Double doubleValue) {
		this.doubleValue = doubleValue;
	}
	public List<String> getStrList() {
		return strList;
	}
	public void setStrList(List<String> strList) {
		this.strList = strList;
	}
	public String[] getStrArrays() {
		return strArrays;
	}
	public void setStrArrays(String[] strArrays) {
		this.strArrays = strArrays;
	}
	
	
	public static TestComplexObject createTestCase(){
		TestComplexObject obj = new TestComplexObject();
		obj.setDoubleValue(new Random().nextDouble());
		obj.setIntegerValue(new Random().nextInt());
		obj.setStrValue("测试以下复杂数据结构");
		obj.setStrArrays(new String[]{"数据结构数组","这是第二个值","这是第三个值"});
		List<String> strList = new ArrayList<String>();
		strList.add("测试列表");
		strList.add("列表中第二个值");
		strList.add("列表中第三个值");
		obj.setStrList(strList);
		List<TestComplexChildObject> childrenList = new ArrayList<TestComplexChildObject>();
		childrenList.add(new TestComplexChildObject("123", 12));
		childrenList.add(new TestComplexChildObject("234", 56));
		childrenList.add(new TestComplexChildObject("567", 78));
		obj.setChildrenList(childrenList);
		return obj;
	}
	
	public static String createTestCaseForJson(){
		try {
			return JsonTrans.ObjectToStr(TestComplexObject.createTestCase());
		} catch (JsonTransException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String createTestListCaseForJson(){
		try {
			List<TestComplexObject> testList = new ArrayList<TestComplexObject>();
			for(int i=0;i<5;i++){
				testList.add(TestComplexObject.createTestCase());
			}
			return JsonTrans.ObjectToStr(testList);
		} catch (JsonTransException e) {
			e.printStackTrace();
		}
		return null;
	}
}
