package com.transData.business.service;

import com.transData.business.entity.ArgumentsEntity;
import com.transData.business.entity.BusinessModel;
import com.transData.exception.BusinessException;

public interface DoBusinessService {
	public BusinessModel callBusinessMethod(ArgumentsEntity argumentsEntity) throws BusinessException;
}
