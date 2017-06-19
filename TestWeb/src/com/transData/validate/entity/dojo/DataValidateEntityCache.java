package com.transData.validate.entity.dojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.transData.db.util.DbSessionFactory;
import com.transData.util.ParametersUtil;
import com.transData.validate.entity.base.ValidateEnum;
import com.transData.validate.entity.base.ValidateRuleEntity;

public class DataValidateEntityCache {
	private DataValidateEntityCache(){}
	
	private static List<DataValidateEntity> dataValidateEntityCacheList;
	
	public static List<DataValidateEntity> getEntityListFromCache(){
		if(dataValidateEntityCacheList == null){
			dataValidateEntityCacheList = initCacheList();
		}
		return dataValidateEntityCacheList;
	}
	
	/**
	 * 删除缓存中存在的数据模板实例，必须要busscode与name双重符合才能删除。
	 * @param bussCode
	 * @param dataValidateName
	 * @return 返回被删掉的数目。
	 */
	public static int evictCache(String bussCode, String dataValidateName){
		Iterator<DataValidateEntity> dataEntityIter = getEntityListFromCache().iterator();
		DataValidateEntity entity = null;
		int removeNum = 0;
		while (dataEntityIter.hasNext()) {
			entity = dataEntityIter.next();
			if(entity.getBussCode().equals(bussCode) && entity.getDataValidName().equals(dataValidateName)){
				dataEntityIter.remove();
				removeNum ++;
			}
		}
		return removeNum;
	}
	
	/**
	 * 想缓存中的数据模板集合数据添加新的数据。
	 * @param entity
	 * @param isForce 即使原本缓存中存在这个数据，也强制性添加。默认为false
	 */
	public static void addNewEntity(DataValidateEntity entity, boolean isForce){
		if(isForce) {
			synchronized (entity) {
				getEntityListFromCache().add(entity);
			}
		}
		else {
			for(DataValidateEntity oldentity : getEntityListFromCache()){
				if(entity.getBussCode().equals(oldentity.getBussCode()) && entity.getDataValidName().equals(oldentity.getDataValidName())){
					isForce = false;
					break;
				}
			}
			if(isForce) {
				synchronized (entity) {
					getEntityListFromCache().add(entity);
				}
			}
		}
	}
	
	public static void addNewEntity(DataValidateEntity entity){
		addNewEntity(entity,false);
	}
	
	public static void reloadCache(){
		dataValidateEntityCacheList = initCacheList();
	}
	
	private static List<DataValidateEntity> initCacheList(){
		SqlSession session = DbSessionFactory.getSqlSession();
		try {
			List<DataValidateEntity> initEntityList = session.selectList("trans.mapper.dataValidateEntity.getAllValidateData");
			List<ValidateRuleData> initRuleDataList = session.selectList("trans.mapper.validateRuleEntity.getAllValidateRule");
			
			Set<ValidateRuleEntity> validateRuleEntitySet = null;
			for(DataValidateEntity entity : initEntityList){
				validateRuleEntitySet = new HashSet<ValidateRuleEntity>();
				for(ValidateRuleData ruleData : initRuleDataList){
					if(ruleData.getValidateEntityId().equals(entity.getDataValidId())){
						validateRuleEntitySet.add(new ValidateRuleEntity(ruleData));
					}
				}
				entity.setValidateRuleEntitySet(validateRuleEntitySet);
			}
			return initEntityList;
		} finally{
			DbSessionFactory.closeSession(session);
		}
	}
	
	@SuppressWarnings("unused")
	private static List<DataValidateEntity> initTestCacheList(){
		List<DataValidateEntity> initEntityList = new ArrayList<DataValidateEntity>();
		initEntityList.add(new DataValidateEntity("name"));
		initEntityList.add(new DataValidateEntity("num"));
		initEntityList.add(new DataValidateEntity("balance"));
		initEntityList.add(new DataValidateEntity("is_vip"));
		initEntityList.add(new DataValidateEntity("nickname"));
		
		Set<ValidateRuleEntity> ruleSet = new HashSet<ValidateRuleEntity>();
		ValidateRuleEntity ruleEntity = null;
		for(ValidateEnum enumType : ValidateEnum.values()){
			ruleEntity = new ValidateRuleEntity();
			ruleEntity.setEnumType(enumType);
			switch (enumType) {
				case NOT_NULL:
					break;
				case NOT_BLANK:
					break;
				case NOT_EMPTY:
					break;
				case MAX_LENGTH:
					ruleEntity.setNumberParams(new int[]{3});
					break;
				case MIN_LENGTH:
					ruleEntity.setNumberParams(new int[]{1});
					break;
				case LENGTH_SIZE:
					ruleEntity.setNumberParams(new int[]{1,3});
					break;
				case IS_BOOLEAN:
					break;
				case IS_NUMBER:
					break;
				case IS_FLOAT_NUMBER:
					break;
				case IS_DATE:
					ruleEntity.setStringParams(new String[]{"yyyyMMdd"});
					break;
				case MAX_VALUE:
					ruleEntity.setDoubleParams(new double[]{50});
					break;
				case MIN_VALUE:
					ruleEntity.setDoubleParams(new double[]{1});
					break;
				case ASSERT_EQUAL:
					ruleEntity.setStringParams(new String[]{"test"});
					break;
				case IS_EMAIL:
					break;
				case IS_ID_CARD:
					break;
				case IS_IP_ADDRSS:
					break;
				case PATTERN:
					ruleEntity.setStringParams(new String[]{".*runoob.*"});
					break;
				default:
					return null;
			}
			ruleSet.add(ruleEntity);
		}
		
		for(DataValidateEntity entity : initEntityList){
			entity.setBussCode(ParametersUtil.GET_ENTITY_ALL);
			entity.setValidateRuleEntitySet(ruleSet);
		}
		
		return initEntityList;
	}
}
