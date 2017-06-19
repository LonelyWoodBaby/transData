package com.transData.validate.log.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transData.trans.entity.DataTransEntity;
import com.transData.validate.entity.base.ValidateEntityStock;
import com.transData.validate.entity.dojo.DataValidateEntity;
import com.transData.validate.entity.service.ValidateEntityService;
import com.transData.validate.log.ValidateLogFactory;
import com.transData.validate.log.entity.ValidateLog;
import com.transData.validate.util.ValidateUtil;

@Service
public class ValidateLogFactoryImpl implements ValidateLogFactory{
	@Autowired
	private ValidateEntityService validateEntityService;
	
	/**
	 * 此部分应当做到的工作
	 * 1.产生一个ValidateLog对象，此对象应保存校验结果，能够格式化输出该结果，并尽量保存校验细节。
	 * 2.传入参数为一个包含Value值的DataTransEntity列表。以及一个对应的的busscode业务编号。
	 * 3.不修改DataTransEntity的值，只产生log日志
	 * 4.提供插入log日志与否的开关
	 * 5.根据bussCode的值查找到校验模板，与数据值模板进行比对
	 */
	public ValidateLog createValidateResultLog(String bussCode, List<DataTransEntity> prepareDataList){
		ValidateLog log = new ValidateLog();
		log.setBussCode(bussCode);
		/*
		 *	1.根据bussCode从全部的校验模板数据中获取对应的集合 ，这个模板数据据应该是DataValidateEntity
		 *	2.根据DataValidateEntity生成校验进件包装类ValidateEntityStock，开始执行校验
		 *	3.将校验结果封装为映射Map
		 */
		List<DataValidateEntity> validateEntityList = validateEntityService.findValidateEntityByBussCode(bussCode);
		Map<DataTransEntity,ValidateEntityStock> verifyResultMap = transValidateEntityStock(prepareDataList, validateEntityList);
		log.setValidateStatus(verifyResultMap.size() == 0);
		log.setVerifyResultMap(verifyResultMap);
		log.setCreateTime(new Date());
		log.setValidateEntityList(validateEntityList);
		return log;
	}
	
	private Map<DataTransEntity,ValidateEntityStock> transValidateEntityStock(List<DataTransEntity> prepareDataList, List<DataValidateEntity> validateEntityList){
		Map<DataTransEntity,ValidateEntityStock> verifyResultMap = new HashMap<DataTransEntity,ValidateEntityStock>();
		ValidateEntityStock stock = new ValidateEntityStock();
		for(DataTransEntity transData: prepareDataList){
			for(DataValidateEntity validateData : validateEntityList){
				if(transData.getDataTransName().equals(validateData.getDataValidName())){
					stock = ValidateEntityStock.createValidateEntityStockFromDataEntity(transData, validateData);
					stock = ValidateUtil.createStockResult(stock, false);
					if(stock.getValidateResultMap()!=null && stock.getValidateResultMap().size()>0){
						verifyResultMap.put(transData, stock);
					}
					break;
				}
			}
		}
		
		return verifyResultMap;
	}
	
	public void setValidateEntityService(ValidateEntityService validateEntityService) {
		this.validateEntityService = validateEntityService;
	}
}
