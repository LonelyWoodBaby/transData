package com.transData.util;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.transData.exception.JsonTransException;
import com.transData.port.entity.RequestMessageEntity;
import com.transData.port.util.DesignCommonUtils;

public class JsonTrans {
	private static JSONParser parser = new JSONParser();
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private static ContainerFactory simpleContainerFactory = new ContainerFactory(){
		@Override
		public List<String> creatArrayContainer() {
			return new LinkedList<String>();
		}

		@Override
		public Map<String,String> createObjectContainer() {
			return new LinkedHashMap<String,String>();
		}
	};
	
	private static ContainerFactory comlexContainerFactory = new ContainerFactory(){
		@Override
		public List<Object> creatArrayContainer() {
			return new LinkedList<Object>();
		}

		@Override
		public Map<String,Object> createObjectContainer() {
			return new LinkedHashMap<String,Object>();
		}
	};
	
	public static Map<String,String> transJsonToSimpleMap(String dataJson) throws JsonTransException{
		try {
			@SuppressWarnings("unchecked")
			Map<String,String> resultMap = (Map<String, String>) parser.parse(dataJson,simpleContainerFactory);
			return resultMap;
		} catch (ParseException e) {
			throw new JsonTransException("执行transJsonToSimpleMap方法时转换失败，json转换Map时出现错误",e.getCause());
		}
	}
	
	public static Map<String,Object> transJsonToComplexMap(String dataJson) throws JsonTransException{
		try {
			@SuppressWarnings("unchecked")
			Map<String,Object> resultMap = (Map<String, Object>) parser.parse(dataJson,comlexContainerFactory);
			return resultMap;
		} catch (ParseException e) {
			throw new JsonTransException("执行transJsonToComplexMap方法时转换失败，json转换Map时出现错误",e.getCause());
		}
	}
	
	public static List<Map<String,Object>> transJsonToComplexMapList(String dataJson) throws JsonTransException{
		try {
			@SuppressWarnings("unchecked")
			List<Map<String,Object>> resultMapList = (LinkedList<Map<String, Object>>) parser.parse(dataJson,comlexContainerFactory);
			return resultMapList;
		} catch (ParseException e) {
			throw new JsonTransException("执行transJsonToComplexMapList方法时转换失败，json转换Map集合时出现错误",e.getCause());
		}
	}
	
	public static String ObjectToStrWithRootName(Object obj) throws JsonTransException{
		objectMapper.configure(Feature.WRAP_ROOT_VALUE,true);
		String result = null;
		try {
			result = objectMapper.writeValueAsString(obj);
		} catch (IOException e) {
			throw new JsonTransException("执行ObjectToStrWithRootName方法时转换失败，对象转换为json串时出现错误",e.getCause());
		}
		return result;
	}
	
	public static String ObjectToStr(Object obj) throws JsonTransException{
		objectMapper.configure(Feature.WRAP_ROOT_VALUE,false);
		String result;
		try {
			result = objectMapper.writeValueAsString(obj);
		} catch (IOException e) {
			throw new JsonTransException("执行ObjectToStr方法时转换失败，对象转换为json串时出现错误",e.getCause());
		}
		return result;
	}
	
	public static void main(String[] args){
		RequestMessageEntity request = new RequestMessageEntity();
		request.setAssistCode("");
		request.setBusinessBody("{\"name\":\"foo\",\"num\":\"100\",\"balance\":\"1000.21\",\"is_vip\":\"true\",\"nickname\":null}");
		request.setDepartmentNo("");
		request.setOperatorNo("123");
		request.setPassworkKey("noKey");
		request.setRequestInfo("");
		request.setRequestTime(DesignCommonUtils.getDateTimeForNow());
		request.setTradeCode("23211312");
		
		try {
			String json = JsonTrans.ObjectToStrWithRootName(request);
			System.out.println(json);
		} catch (JsonTransException e) {
			e.printStackTrace();
		}
		
	}
}
