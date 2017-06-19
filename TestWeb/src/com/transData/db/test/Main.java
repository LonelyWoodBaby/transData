package com.transData.db.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {
	public static void main(String[] args) {
		String resource = "conf.xml";
		InputStream is = Main.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		
		String statement = "trans.mapper.dataTransEntity.getAllTransData";
		String statementByCode = "trans.mapper.dataTransEntity.getAllTransDataByCode";
		List<DataTransEntity> entityList = session.selectList(statement);
		List<DataTransEntity> entityList2 = session.selectList(statementByCode,"testTrans1");
		System.out.println(entityList.size());
		System.out.println(entityList2.size());
		session.close();
	}
}
