package com.creditapp.test.main;

import java.util.List;
import java.util.Map;

import com.creditapp.test.dojo.TestComplexObject;
import com.transData.exception.JsonTransException;
import com.transData.util.JsonTrans;

public class CreateTestJson {
	public String createComplexObjJson(){
		return TestComplexObject.createTestListCaseForJson();
	}
	public static void main(String[] args) throws JsonTransException {
		CreateTestJson ctj = new CreateTestJson();
		String json = ctj.createComplexObjJson();
		System.out.println(json);
		List<Map<String,Object>> resultList= JsonTrans.transJsonToComplexMapList(json);
		for(Map<String,Object> keyMap : resultList){
			System.out.println();
			for(String key:keyMap.keySet()){
				System.out.println("key:"+key+"-"+"value:"+keyMap.get(key).toString()+"-type:"+keyMap.get(key).getClass().getName());
			}
			
		}
		
	}
//{"strValue":"测试以下复杂数据结构","integerValue":1021,"doubleValue":100.213,"strList":["测试列表","列表中第二个值","列表中第三个值"],"strArrays":["数据结构数组","这是第二个值","这是第三个值"]}
}
