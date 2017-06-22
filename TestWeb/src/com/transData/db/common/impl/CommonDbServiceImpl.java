package com.transData.db.common.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.transData.db.common.CommonDbService;
import com.transData.db.util.DbSessionFactory;
import com.transData.util.ParametersUtil;
import com.transData.util.TransDataUtils;

@Service
public class CommonDbServiceImpl implements CommonDbService {

	@Override
	public Map<String,Object> selectOneObject(Object entity,String changeType) {
		String sql =createSelectSqlfromObject(entity,changeType);
		return selectOneObject(sql,changeType);
	}
	
	@Override
	public Map<String,Object> selectOneObject(String sql,String changeType) {
		System.out.println(sql);
		return executeSelectQuery(sql);
	}

	@Override
	public List<Map<String,Object>> selectAllObject(Object entity,int startNum, int endNum,String changeType) {
		String sql = createSelectSqlfromObject(entity,changeType);
		sql = processSqlForPage_mysql(sql, startNum, endNum);
		System.out.println(sql);
		return executeSelectQueryForList(sql);
	}

	@Override
	public boolean updateObject(Object entity,Object oldEntity,String changeType) {
		try {
			String updateSql = createUpdateSql(entity,oldEntity,changeType);
			System.out.println(updateSql);
			Connection connection = DbSessionFactory.getConnection();
			Statement st = connection.createStatement();
			st.executeUpdate(updateSql);
			connection.commit();
			st.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteObject(Object entity,String changeType) {
		String ObjectName = entity.getClass().getSimpleName();
		String sql = "delete from " + changeColumnName(ObjectName,changeType ) ;
		sql = sql + " " + processSqlForWhere(entity,changeType);
		System.out.println(sql);
		try {
			Connection connection = DbSessionFactory.getConnection();
			Statement st = connection.createStatement();
			int result = st.executeUpdate(sql);
			st.close();
			connection.commit();
			connection.close();
			if(result > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertObject(Object entity,String changeType) {
		String sql = processSqlForInsert(entity,changeType);
		System.out.println(sql);
		try {
			Connection connection = DbSessionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			int result = ps.executeUpdate();
			ps.close();
			connection.commit();
			connection.close();
			if(result > 0)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String,Object> transObject2Map(Object entity){
		return (Map<String, Object>) TransDataUtils.objectToMap(entity);
	}
	
	private String createUpdateSql(Object entity,Object oldEntity,String changeType){
		String ObjectName = entity.getClass().getSimpleName();
		Map<String,Object> columnMap = transObject2Map(entity);
		StringBuilder sqlBuilder = new StringBuilder("update " + changeColumnName(ObjectName,changeType )).append(" set ");
		for(String columnName : columnMap.keySet()){
			if("class".equals(columnName))continue;
			if(columnMap.get(columnName)!= null ){
				sqlBuilder.append(changeColumnName(columnName,changeType))
				.append("=");
				if("java.lang.String".equals(columnMap.get(columnName).getClass().getTypeName())){
					sqlBuilder.append("'").append(columnMap.get(columnName)).append("',");
				}else{
					sqlBuilder.append(columnMap.get(columnName)).append(",");
				}
			}
		}
		
		sqlBuilder.deleteCharAt(sqlBuilder.length() - 1).append(" ").append(processSqlForWhere(oldEntity,changeType));
		return sqlBuilder.toString();
	}
	
	private String createSelectSqlfromObject(Object entity,String changeType){
		String tableName = entity.getClass().getSimpleName();
		tableName = changeColumnName(tableName,changeType);
		Map<String,Object> columnMap = transObject2Map(entity);
		StringBuilder sqlBuilder = new StringBuilder("select ");
		sqlBuilder.append(" * ");//因为实体类中的字段未必都存在在数据库中，所以采取用*去查询，然后再用取回来的值进行匹配
		sqlBuilder.deleteCharAt(sqlBuilder.length() - 1).append(" from ").append(tableName);
		
		StringBuilder whereSql = new StringBuilder(" where ");;
		boolean isAddWhere = false;
		for(String columnName : columnMap.keySet()){
			if("class".equals(columnName))continue;
			if(columnMap.get(columnName)!= null ){
				if(isAddWhere)whereSql.append(" and ");
				whereSql.append(changeColumnName(columnName,changeType)).append("=");
				if("java.lang.String".equals(columnMap.get(columnName).getClass().getTypeName())){
					whereSql.append("'").append(columnMap.get(columnName)).append("' ");
				}else{
					whereSql.append(columnMap.get(columnName)).append(" ");
				}
				isAddWhere = true;
			}
		}
		if(isAddWhere)sqlBuilder.append(whereSql);
		return sqlBuilder.toString();
	}
	
	private String processSqlForPage_mysql(String sql,int startNum,int endNum){
		String pageSql = sql + " limit " + startNum + " ,"+(endNum - startNum);
		return pageSql;
	}
	
	@SuppressWarnings("unused")
	private String processSqlForPage_oracle(String sql,int startNum,int endNum){
		String pageSql = "select * from ( select A.*,rownum rn from (" 
				+ sql + ") A ) WHERE RN BETWEEN " + startNum + " and " + endNum;
		return pageSql;
	}
	
	private String processSqlForWhere(Object whereObject,String changeType){
		Map<String,Object> oldColumnMap = transObject2Map(whereObject);
		StringBuilder whereSql = new StringBuilder(" where ");;
		boolean isAddWhere = false;
		for(String columnName : oldColumnMap.keySet()){
			if("class".equals(columnName))continue;
			if(oldColumnMap.get(columnName)!= null ){
				if(isAddWhere)whereSql.append(" and ");
				whereSql.append(changeColumnName(columnName,changeType)).append("=");
				if("java.lang.String".equals(oldColumnMap.get(columnName).getClass().getTypeName())){
					whereSql.append("'").append(oldColumnMap.get(columnName)).append("' ");
				}else{
					whereSql.append(oldColumnMap.get(columnName)).append(" ");
				}
				isAddWhere = true;
			}
		}
		return whereSql.toString();
	}
	
	private String processSqlForInsert(Object insertObject,String changeType){
		Map<String,Object> columnMap = transObject2Map(insertObject);
		String objectName = insertObject.getClass().getSimpleName();
		objectName = changeColumnName(objectName,changeType);
		StringBuilder insertSql = new StringBuilder(" insert into ");
		insertSql.append(objectName).append(" (");
		StringBuilder valueSql = new StringBuilder();
		for(String columnName : columnMap.keySet()){
			if("class".equals(columnName))continue;
			if(columnMap.get(columnName)!= null ){
				insertSql.append(changeColumnName(columnName,changeType)).append(",");
				if("java.lang.String".equals(columnMap.get(columnName).getClass().getTypeName())){
					valueSql.append("'").append(columnMap.get(columnName)).append("',");
				}else{
					valueSql.append(columnMap.get(columnName)).append("',");
				}
			}
		}
		insertSql.deleteCharAt(insertSql.length() - 1).append(") values (");
		insertSql.append(valueSql.deleteCharAt(valueSql.length() - 1)).append(")");
		return insertSql.toString();
	}
	
	private Map<String,Object> executeSelectQuery(String sql){
		Connection connection = DbSessionFactory.getConnection();
		Statement st = null;
		ResultSet rs = null;
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			st = connection.createStatement();
			rs= st.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			String columName = "";
			if(rs.next()){
				for(int i=0; i < metaData.getColumnCount(); i++){
					columName = metaData.getColumnName(i+1);
					switch (metaData.getColumnType(i+1)) {
					case Types.VARCHAR:
						resultMap.put(columName, rs.getString(columName));
						break;
					case Types.INTEGER:
						resultMap.put(columName, rs.getInt(columName));
						break;
					case Types.DOUBLE:
						resultMap.put(columName, rs.getDouble(columName));
						break;
					default:
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(st!=null)st.close();
				if(rs!=null)rs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}
	
	private List<Map<String,Object>> executeSelectQueryForList(String sql){
		Connection connection = DbSessionFactory.getConnection();
		Statement st = null;
		ResultSet rs = null;
		List<Map<String,Object>> resultMapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> resultMap = null;
		try {
			st = connection.createStatement();
			rs= st.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			String columName = "";
			while(rs.next()){
				resultMap = new HashMap<String,Object>();
				for(int i=0; i < metaData.getColumnCount(); i++){
					columName = metaData.getColumnName(i+1);
					switch (metaData.getColumnType(i+1)) {
					case Types.VARCHAR:
						resultMap.put(columName, rs.getString(columName));
						break;
					case Types.INTEGER:
						resultMap.put(columName, rs.getInt(columName));
						break;
					case Types.DOUBLE:
						resultMap.put(columName, rs.getDouble(columName));
						break;
					default:
						break;
					}
				}
				resultMapList.add(resultMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(st!=null)st.close();
				if(rs!=null)rs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultMapList;
	}
	
	private String changeColumnName(String columnName,String changeType){
		if(ParametersUtil.COLUMN_UPLINE2CAMEL.equals(changeType)){
			return TransDataUtils.underline2Camel(columnName, false);
		}else if(ParametersUtil.COLUMN_CAMEL2UPLINE.equals(changeType)){
			return TransDataUtils.camel2Underline(columnName);
		}else{
			return columnName;
		}
	}
}
