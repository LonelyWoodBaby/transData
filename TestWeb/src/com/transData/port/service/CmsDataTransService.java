package com.transData.port.service;

import com.transData.port.entity.RequestMessageEntity;
import com.transData.port.entity.ResponseMessageEntity;

public interface CmsDataTransService {
	
	/**
	 * 用于解析报文数据，并执行。
	 * 主要工作为
	 * 1.解析数据
	 * 2.校验数据
	 * 3.执行数据
	 * 4.获取返回结果并发送给ESB
	 * @param requestMessageEntity
	 * @return
	 */
	public ResponseMessageEntity analysisRequestMessage(RequestMessageEntity requestMessageEntity);
}
