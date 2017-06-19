package com.transData.trans.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.transData.db.util.DbSessionFactory;
import com.transData.util.ParametersUtil;

public class DataTransEntityCache {
	private DataTransEntityCache(){}
	
	private static List<DataTransEntity> dataTransEntityCacheList;
	
	public static List<DataTransEntity> getEntityListFromCache(){
		if(dataTransEntityCacheList == null){
			dataTransEntityCacheList = initCacheList();
		}
		return dataTransEntityCacheList;
	}
	
	/**
	 * 删除缓存中存在的数据模板实例，必须要busscode与name双重符合才能删除。
	 * @param bussCode
	 * @param dataTransName
	 * @return 返回被删掉的数目。
	 */
	public static int evictCache(String bussCode, String dataTransName){
		Iterator<DataTransEntity> dataEntityIter = getEntityListFromCache().iterator();
		DataTransEntity entity = null;
		int removeNum = 0;
		while (dataEntityIter.hasNext()) {
			entity = dataEntityIter.next();
			if(entity.getBussCode().equals(bussCode) && entity.getDataTransName().equals(dataTransName)){
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
	public static void addNewEntity(DataTransEntity entity, boolean isForce){
		if(isForce) {
			synchronized (entity) {
				getEntityListFromCache().add(entity);
			}
		}
		else {
			for(DataTransEntity oldentity : getEntityListFromCache()){
				if(entity.getBussCode().equals(oldentity.getBussCode()) && entity.getDataTransName().equals(oldentity.getDataTransName())){
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
	
	public static void addNewEntity(DataTransEntity entity){
		addNewEntity(entity,false);
	}
	
	public static void reloadCache(){
		dataTransEntityCacheList = initCacheList();
	}
	
	private static List<DataTransEntity> initCacheList(){
		//return initTestCacheList();
		SqlSession session = DbSessionFactory.getSqlSession();
		try {
			List<DataTransEntity> initEntityList = session.selectList("trans.mapper.dataTransEntity.getAllTransData");
			return initEntityList;
		} finally{
			DbSessionFactory.closeSession(session);
		}
	}
	
	@SuppressWarnings("unused")
	private static List<DataTransEntity> initTestCacheList(){ 
		List<DataTransEntity> initEntityList = new ArrayList<DataTransEntity>();
		initEntityList.add(new DataTransEntity(ParametersUtil.GET_ENTITY_ALL,"name",""));
		initEntityList.add(new DataTransEntity(ParametersUtil.GET_ENTITY_ALL,"num",""));
		initEntityList.add(new DataTransEntity(ParametersUtil.GET_ENTITY_ALL,"balance",""));
		initEntityList.add(new DataTransEntity(ParametersUtil.GET_ENTITY_ALL,"is_vip",""));
		initEntityList.add(new DataTransEntity(ParametersUtil.GET_ENTITY_ALL,"nickname",""));
		initEntityList.add(new DataTransEntity(ParametersUtil.GET_ENTITY_ALL,"age",""));
		initEntityList.add(new DataTransEntity(ParametersUtil.GET_ENTITY_ALL,"salary",""));
		return initEntityList;              
	}
}
