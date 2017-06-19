package com.transData.db.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.transData.db.test.Main;

public class DbSessionFactory {
	private DbSessionFactory(){}
	private static SqlSessionFactory sessionFactory = initSqlSessionFactory();
	
	private static SqlSessionFactory initSqlSessionFactory(){
		String resource = "conf.xml";
		InputStream is = Main.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		return sessionFactory;
	}
	
	public static SqlSession getSqlSession(){
		if(sessionFactory == null)sessionFactory = initSqlSessionFactory();
		return sessionFactory.openSession();
	}
	
	public static void closeSession(SqlSession session){
		if(session != null)session.close();
	}
}
