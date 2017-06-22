package com.transData.db.common;

import java.util.List;
import java.util.Map;

public interface CommonDbService {
	
	public Map<String,Object> selectOneObject(Object entity,String changeType);
	public Map<String,Object> selectOneObject(String sql,String changeType);
	public List<Map<String,Object>> selectAllObject(Object entity,int startNum,int endNum,String changeType);
	public boolean updateObject(Object entity,Object oldEntity,String changeType);
	public boolean deleteObject(Object entity,String changeType);
	public boolean insertObject(Object entity,String changeType);
}
