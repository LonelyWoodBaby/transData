package com.transData.trans.service;

import java.util.List;

import com.transData.trans.entity.DataTransEntity;

public interface DataTransExecuteService {
	
	/**
	 * 获取两个参数，一个是接收过来的数据列表：json串，一个是业务编码。
	 * 根据业务编码从缓存或数据库中获取对应的数据模板
	 * 根据json串获取键值对应的map集合
	 * 最终将json串数据翻译转换为DataTransEntity集合
	 */
	public List<DataTransEntity> transReceiveData(String businessCode, String receiveJson);
	
	public List<DataTransEntity> transReceiveData(List<DataTransEntity> entityList, String receiveJson);
	
	public List<List<DataTransEntity>> transReceiveDataForArray(String businessCode, String receiveJson);
	
}
