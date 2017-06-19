package com.transData.validate.entity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.transData.util.ParametersUtil;
import com.transData.validate.entity.dojo.DataValidateEntity;
import com.transData.validate.entity.dojo.DataValidateEntityCache;
import com.transData.validate.entity.service.ValidateEntityService;

@Service
public class ValidateEntityServiceImpl implements ValidateEntityService {

	@Override
	public List<DataValidateEntity> findValidateEntityByBussCode(String bussCode) {
		List<DataValidateEntity> entityList = DataValidateEntityCache.getEntityListFromCache();
		if(ParametersUtil.GET_ENTITY_ALL.equals(bussCode))return entityList;
		List<DataValidateEntity> resultList = new ArrayList<DataValidateEntity>();
		for(DataValidateEntity entity:entityList){
			if(bussCode.equals(entity.getBussCode())) {
				resultList.add(entity);
			}
		}
		return resultList;
	}
	
	@Override
	public boolean reloadDataCache() {
		try {
			DataValidateEntityCache.reloadCache();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
