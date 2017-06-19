package com.transData.validate.log;

import java.util.List;

import com.transData.trans.entity.DataTransEntity;
import com.transData.validate.log.entity.ValidateLog;

public interface ValidateLogFactory {
	public ValidateLog createValidateResultLog(String bussCode, List<DataTransEntity> prepareDataList);
}
