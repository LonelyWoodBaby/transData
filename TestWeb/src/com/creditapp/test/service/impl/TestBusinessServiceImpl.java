package com.creditapp.test.service.impl;

import org.springframework.stereotype.Service;

import com.creditapp.test.dojo.TestObject;
import com.creditapp.test.service.TestBusinessService;
@Service("testBusinessService")
public class TestBusinessServiceImpl implements TestBusinessService {

	@Override
	public String testYourRequest() {
//		System.out.println("!!!!!!!!!!!!!!!!!!!"+requestMsg+"!!!!!!!!!!!!!!!!!!");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return "我收到你的请求了，谢谢！";
	}

	@Override
	public String testString(String request) {
		System.out.println("!!!!!!!!!!!!!!!!!!!"+request+"!!!!!!!!!!!!!!!!!!");
		return "我收到你的请求了，谢谢！";
	}

	@Override
	public Integer testInteger(Integer request) {
		System.out.println("!!!!!!!!!!!!!!!!!!!"+request+"!!!!!!!!!!!!!!!!!!");
		return request + 5;
	}

	@Override
	public Double testDouble(Double request) {
		System.out.println("!!!!!!!!!!!!!!!!!!!"+request+"!!!!!!!!!!!!!!!!!!");
		return request * 5;
	}

	@Override
	public TestObject testObject(TestObject request) {
		System.out.println("--------------接入业务处理系统---------------");
		System.out.println(request.getName());
		System.out.println(request.getAge());
		System.out.println(request.getSalary());
		
		request.setAge(request.getAge()+10);
		request.setSalary(request.getSalary()*2);
		request.setName(request.getName()+"总监");
		System.out.println("--------------对业务处理结束---------------");
		return request;
	}

}
