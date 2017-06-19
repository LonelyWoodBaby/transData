package com.creditapp.test.service;

import com.creditapp.test.dojo.TestObject;

public interface TestBusinessService {
	public String testYourRequest();
	public String testString(String request);
	public Integer testInteger(Integer request);
	public Double testDouble(Double request);
	public TestObject testObject(TestObject request);
}
