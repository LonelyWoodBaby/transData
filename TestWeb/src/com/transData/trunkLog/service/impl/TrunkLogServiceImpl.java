package com.transData.trunkLog.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.transData.db.util.DbSessionFactory;
import com.transData.trunkLog.entity.TrunkLog;
import com.transData.trunkLog.service.TrunkLogService;

@Service
public class TrunkLogServiceImpl implements TrunkLogService{

	@Override
	public TrunkLog insertNewLog(TrunkLog log) {
		// TODO 完成日志入库功能
		SqlSession session = DbSessionFactory.getSqlSession();
		session.insert("trans.mapper.trunkLog.insertLog", log);
		session.commit();
		DbSessionFactory.closeSession(session);
		System.out.println("已将日志插入库中");
//		System.out.println(log.printLogInfo());
		return log;
	}
}
