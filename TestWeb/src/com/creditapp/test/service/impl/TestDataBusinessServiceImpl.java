package com.creditapp.test.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.creditapp.test.dojo.TestDataEntity;
import com.creditapp.test.dojo.TestObject;
import com.creditapp.test.service.TestDataBusinessService;
@Service("testDataBusinessService")
public class TestDataBusinessServiceImpl implements TestDataBusinessService {

	@Override
	public TestObject reciveTestObject(TestDataEntity entity){
		Field[] fields = entity.getClass().getDeclaredFields();
		Method getMethod = null;
		String getMethodName = null;
		String fieldName = null;
		try {
			for(Field f : fields){
				fieldName = f.getName();
				getMethodName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
				getMethod = entity.getClass().getDeclaredMethod(getMethodName);
				System.out.println(fieldName + "-----"+getMethod.invoke(entity));
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new TestObject("测试通过",22222,32123.212);
		
	}

}
