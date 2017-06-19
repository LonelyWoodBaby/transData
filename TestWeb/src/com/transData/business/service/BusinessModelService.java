package com.transData.business.service;

import com.transData.business.entity.BusinessModel;

public interface BusinessModelService {
	public BusinessModel getBusinessModel(String businessCode);
	public BusinessModel getBusinessModel(String businessCode,String assistCode);
}
