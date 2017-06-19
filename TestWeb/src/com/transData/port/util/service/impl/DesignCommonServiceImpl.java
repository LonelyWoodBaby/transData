package com.transData.port.util.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.transData.port.util.service.DesignCommonService;

@Service
public class DesignCommonServiceImpl implements DesignCommonService {

	@Override
	public boolean userJurisdictionByKey(String operatorNo, String passworkKey) {
		// TODO 完成用户信息验证功能
		if("123".equals(operatorNo) && "noKey".equals(passworkKey)){
			return true;
		}
		return false;
	}

	@Override
	public String formatDateTime(Date date) {
		// 自定义日期时间格式
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}


}
