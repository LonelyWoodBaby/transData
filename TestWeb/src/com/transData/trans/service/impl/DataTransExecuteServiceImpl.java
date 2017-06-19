package com.transData.trans.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transData.exception.JsonTransException;
import com.transData.trans.entity.DataTransEntity;
import com.transData.trans.service.DataTransConfigService;
import com.transData.trans.service.DataTransExecuteService;
import com.transData.util.JsonTrans;
import com.transData.util.TransDataUtils;

@Service
public class DataTransExecuteServiceImpl implements DataTransExecuteService {
	@Autowired
	private DataTransConfigService dataTransConfigService;
	
	@Override
	public List<DataTransEntity> transReceiveData(String businessCode, String receiveJson) {
		/*
		 * 方法执行分三步走
		 * 1.根据businessCode从缓存或数据库中获取数据模板集合
		 * 2.转换json串为map映射
		 * 	这部分有两种情况：
		 * 		1.都是简单的字符串映射
		 * 		2.包含复杂树逻辑结构的映射
		 * 3.给获取到的数据模板集合赋值
		 * 
		 * 调用接口：数据模板集合获取接口
		 */
		List<DataTransEntity> entityList = this.dataTransConfigService.getEntityListByCode(businessCode);
		return transReceiveData(entityList,receiveJson);
	}
	
	@Override
	public List<DataTransEntity> transReceiveData(List<DataTransEntity> entityList, String receiveJson) {
		if(entityList!=null && entityList.size() > 0) {
			Map<String,Object> jsonDataMap = transJsonToComplexMap(receiveJson);
			entityList = transExecute(entityList, jsonDataMap);
		}else{
			entityList = new ArrayList<DataTransEntity>();
		}
		return entityList;
	}
	
	/**
	 * 当传递来的json为一个数组或者列表集合对象时，采用集合形式
	 * 一个List<DataTransEntity>为一个数据对象，nameList<List<DataTransEntity>>可以视为多个该数据对象
	 * @param businessCode
	 * @param receiveJson
	 * @return
	 * 
	 * 目前考察河南项目与海南项目，暂时没有传递一个集合对象或者列表对象作为参数的情况。因此暂时保留这部分不做，再下个版本中升级。
	 */
	public List<List<DataTransEntity>> transReceiveDataForArray(String businessCode, String receiveJson) {
		List<DataTransEntity> entityList = this.dataTransConfigService.getEntityListByCode(businessCode);
		List<Map<String,Object>> jsonDataMapList = transJsonToComplexMapList(receiveJson);
		List<List<DataTransEntity>> dataArrayList = new ArrayList<List<DataTransEntity>>();
		List<DataTransEntity> oneDataEntityList = null;
		try {
			for(Map<String,Object> jsonDataMap : jsonDataMapList){
				oneDataEntityList = TransDataUtils.deepCopy(entityList);
				oneDataEntityList = transExecute(oneDataEntityList, jsonDataMap);
				dataArrayList.add(oneDataEntityList);
			}
		} catch (ClassNotFoundException | IOException e) {
			//TODO 对转换拷贝数据中出现错误的情况进行异常捕捉
			System.out.println("转换拷贝数据中出现错误");
			e.printStackTrace();
		}
		return dataArrayList;
	}
	
	/**
	 * 执行转换操作，根据简单的jsonData映射集合进行简单匹配操作。
	 * @param entityList
	 * @param jsonDataMap
	 * @return
	 */
	private List<DataTransEntity> transExecute(List<DataTransEntity> entityList,Map<String,Object> jsonDataMap){
		Object valObj = null;
		for(DataTransEntity entity : entityList) {
			for(String key : jsonDataMap.keySet()){
				if(key.equalsIgnoreCase(entity.getDataTransName())){
					valObj = jsonDataMap.get(key);
					if(valObj instanceof LinkedList && entity.getChildrenList()!=null){
						//如果该模型包含子类,使用子类的json串
						entity.setChildrenList(transReceiveData(entity.getChildrenList(),valObj.toString()));
					}else{
						entity.setDataValue(String.valueOf(jsonDataMap.get(key)));
					}
					break;
				}
			}
		}
		return entityList;
	}
	
	/**
	 * 对于比较简单的接口逻辑，可以将其转换为都是字符串的映射集合
	 * @param dataJson
	 * @return
	 */
	//TODO 这部分要添加对于转换失败后的处理逻辑
	@SuppressWarnings("unused")
	private Map<String,String> transJsonToSimpleMap(String dataJson){
		try {
			return JsonTrans.transJsonToSimpleMap(dataJson);
		} catch (JsonTransException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Map<String,Object> transJsonToComplexMap(String dataJson){
		try {
			return JsonTrans.transJsonToComplexMap(dataJson);
		} catch (JsonTransException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private List<Map<String,Object>> transJsonToComplexMapList(String dataJson){
		try {
			return JsonTrans.transJsonToComplexMapList(dataJson);
		} catch (JsonTransException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void setDataTransConfigService(DataTransConfigService dataTransConfigService) {
		this.dataTransConfigService = dataTransConfigService;
	}
	
}
