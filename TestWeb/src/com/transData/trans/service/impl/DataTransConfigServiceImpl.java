package com.transData.trans.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.transData.trans.entity.DataTransEntity;
import com.transData.trans.entity.DataTransEntityCache;
import com.transData.trans.service.DataTransConfigService;
import com.transData.util.ParametersUtil;

@Service
public class DataTransConfigServiceImpl implements DataTransConfigService{
	@Override
	public List<DataTransEntity> getEntityListByCode(String businessCode) {
		List<DataTransEntity> entityList = DataTransEntityCache.getEntityListFromCache();
		if(ParametersUtil.GET_ENTITY_ALL.equals(businessCode))return entityList;
		List<DataTransEntity> resultList = new ArrayList<DataTransEntity>();
		for(DataTransEntity entity:entityList){
			if(businessCode.equals(entity.getBussCode())) {
				resultList.add(entity);
			}
		}
		return resultList;
	}

	@Override
	public boolean reloadDataCache() {
		try {
			DataTransEntityCache.reloadCache();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
