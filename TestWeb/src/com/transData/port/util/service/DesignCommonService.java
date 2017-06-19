package com.transData.port.util.service;

import java.util.Date;

public interface DesignCommonService {
	/**
	 * 根据公钥查询该用户的可用性，是否已经过期失效等等
	 * @param operatorNo 操作员账号
	 * @param passworkKey 公钥信息
	 * @return
	 */
	public boolean userJurisdictionByKey(String operatorNo, String passworkKey);
	
	/**
	 * 时间格式转换，通用情况下将当前时间根据需要转换为对应的时间格式
	 * @param date
	 * @return
	 */
	public String formatDateTime(Date date);
	
}
