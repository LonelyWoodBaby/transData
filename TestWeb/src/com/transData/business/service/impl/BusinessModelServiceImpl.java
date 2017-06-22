package com.transData.business.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.transData.business.entity.BusinessModel;
import com.transData.business.service.BusinessModelService;
import com.transData.db.util.DbSessionFactory;

@Service
public class BusinessModelServiceImpl implements BusinessModelService {

	//TODO 这里都是测试用的，以后需要删除
	@Override
	public BusinessModel getBusinessModel(String businessCode) {
//		BusinessModel model = new BusinessModel();
//		model.setMethodName("reciveTestObject");
//		model.setParamterObject(null);
//		model.setParamterClass("com.creditapp.test.dojo.TestDataEntity");
//		model.setServiceBeanName("testDataBusinessService");
//		model.setServiceClassName("");
//		model.setServicePath("");
//		return model;
		
		SqlSession session = DbSessionFactory.getSqlSession();
		BusinessModel model = session.selectOne("trans.mapper.busiModelEntity.getAllTransDataByCode",businessCode);
		return model;
		
	}

	@Override
	public BusinessModel getBusinessModel(String businessCode, String assistCode) {
		BusinessModel model = new BusinessModel();
		model.setMethodName("testYourRequest");
		model.setParamterObject(null);
		model.setParamterClass(null);
		model.setServiceBeanName("testBusinessService");
		model.setServiceClassName("");
		model.setServicePath("");
		return model;
	}

}
