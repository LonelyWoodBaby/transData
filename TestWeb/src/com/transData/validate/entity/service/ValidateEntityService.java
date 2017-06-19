package com.transData.validate.entity.service;

import java.util.List;

import com.transData.validate.entity.dojo.DataValidateEntity;

public interface ValidateEntityService {
	public List<DataValidateEntity> findValidateEntityByBussCode(String bussCode);

	boolean reloadDataCache();
}
