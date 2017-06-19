package com.transData.trans.service;

import java.util.List;

import com.transData.trans.entity.DataTransEntity;

/**
 * 专门处理数据模板对应的方法
 * 本部分应当包括：
 * 	根据业务编码获取数据模板集合
 * 	从数据库或者文件中初始化业务模板集合，并将初始化后的业务模板加入缓存
 * 	重新初始化业务模板缓存结构
 * @author Lee Yarbin
 *
 */
public interface DataTransConfigService {
	

	/**
	 * 根据业务编码获取对应的数据模板集合
	 * 1.从数据库中获取
		 * 1.查询数据库中的数据，并获取业务编码为businessCode的集合
		 * 2.组装成为List<DataTransEntity>列表
	 * 2.从配置文件中获取
	 * @param businessCode 业务编码
	 * @return
	 */
	public List<DataTransEntity> getEntityListByCode(String businessCode);
	
	/**
	 * 刷新缓存，重新读取库或者文件，将数据模板列表重新获取
	 * @return 成功与否
	 */
	public boolean reloadDataCache();
}
