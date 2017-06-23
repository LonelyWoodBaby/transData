package com.transData.port.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.transData.business.entity.ArgumentsEntity;
import com.transData.business.entity.BusinessModel;
import com.transData.business.service.DoBusinessService;
import com.transData.exception.BusinessException;
import com.transData.exception.JsonTransException;
import com.transData.port.entity.RequestMessageEntity;
import com.transData.port.entity.ResponseMessageEntity;
import com.transData.port.service.CmsDataTransService;
import com.transData.port.util.DesignCommonUtils;
import com.transData.port.util.ResponseStatus;
import com.transData.port.util.service.DesignCommonService;
import com.transData.trans.entity.DataTransEntity;
import com.transData.trans.service.DataTransExecuteService;
import com.transData.trunkLog.entity.TrunkLog;
import com.transData.trunkLog.service.TrunkLogService;
import com.transData.util.JsonTrans;
import com.transData.validate.log.ValidateLogFactory;
import com.transData.validate.log.entity.ValidateLog;

public class CmsDataTransServiceImpl implements CmsDataTransService{
	@Autowired
	private DesignCommonService designCommonService;
	@Autowired
	private ValidateLogFactory validateLogFactory;
	@Autowired
	private DataTransExecuteService dataTransExecuteService;
	@Autowired
	private TrunkLogService trunkLogService;
	@Autowired
	private DoBusinessService doBusinessService;

	@Override
	public ResponseMessageEntity analysisRequestMessage(RequestMessageEntity request) {
		TrunkLog log = insertRequestMessageToLog(request);
		//0.校验Request的合法性
		String valiResult = validateRequestMessage(request);
		if(valiResult !=null){
			return processResponseAndLog(log,ResponseStatus.MESSAGE_COMPLETE_FAILED,valiResult);
		}
		//1.
		//校验请求的用户可用性
		//将请求到报文数据插入到日志表或日志文件中（包含校验结果）
		//如果可用性失败，此时进行返回
		if(!designCommonService.userJurisdictionByKey(request.getOperatorNo(), request.getPassworkKey())){
			return processResponseAndLog(log,ResponseStatus.USER_STATUS_ABNORMAL);
		}
		//2.
		//根据交易主码查询到所需的数据模板
		//将匹配好的数据模板进行校验，判断校验结果情况
		//如果校验失败，此时进行返回
		//TODO 对交易辅码与主码都一起做封装
		String businessCode = request.getTradeCode();//交易码（后期可能会根据辅码一起做控制）
		String businessJson = request.getBusinessBody();
		//如果传递过来的参数是数组序列，则采用CmsDataTransServiceForArrayImpl实现方法
		List<DataTransEntity> prepareDataList = dataTransExecuteService.transReceiveData(businessCode, businessJson);
		ValidateLog validateLog = validateLogFactory.createValidateResultLog(businessCode, prepareDataList);
		if(!validateLog.isValidateStatus()){
			String responseBody = validateLog.showLog();
			return processResponseAndLog(log,ResponseStatus.DATA_VALIDATE_FAILED,responseBody);
		}
		//3.
		//如果校验通过则请求业务接口，将校验过的数据匹配成业务bean，发给业务接口进行处理
		//接收返回数据，并转换成requestMessageEntity，并返回
		BusinessModel businessModel = null;
		ResponseStatus businessStatus = ResponseStatus.BUSINESS_ACCEPT_SUCCESS;
		try {
			businessModel = invokeBusinessMethod(request, prepareDataList);
		} catch (BusinessException e) {
			//TODO 整理业务执行时的异常,此时应该崩溃处理。
			e.printStackTrace();
			businessStatus = ResponseStatus.BUSINESS_ACCEPT_FAILED;
		}
		String responseBody = null;
		try {
			responseBody = businessModel == null?"":JsonTrans.ObjectToStrWithRootName(businessModel.getResultObject());
		} catch (JsonTransException e) {
			responseBody = "业务执行成功，但转换返回类型对象时出现错误，请联系信贷";
			e.printStackTrace();
		}
		ResponseMessageEntity responseMessageEntity = DesignCommonUtils.createNewResponseMessage(businessStatus,responseBody); 
		insertResponseMessageLog(log,businessStatus,responseMessageEntity,responseBody,businessModel.getServiceClassName(),businessModel.getMethodName());
		responseMessageEntity.setSerialNumber(log.getSerialNumber());
		return responseMessageEntity;
	}
	
	private BusinessModel invokeBusinessMethod(RequestMessageEntity request,List<DataTransEntity> prepareDataList) throws BusinessException{
		ArgumentsEntity argumentsEntity = new ArgumentsEntity();
		argumentsEntity.setBusiCode(request.getTradeCode());
		argumentsEntity.setAssistCode(request.getAssistCode());
		argumentsEntity.setDepartmentNo(request.getDepartmentNo());
		argumentsEntity.setOperatorNo(request.getOperatorNo());
		argumentsEntity.setPrepareDataList(prepareDataList);
		
		return doBusinessService.callBusinessMethod(argumentsEntity);
	}
	
	
	/**
	 * 
	 * @param response
	 * @param serialNumber
	 * @return
	 */
	private boolean insertResponseMessageLog(TrunkLog log,ResponseStatus status,ResponseMessageEntity responseMessageEntity,String... paramster ){
		if(status == ResponseStatus.USER_STATUS_ABNORMAL){
			log.setUserStatus("0");
		}else if(status == ResponseStatus.DATA_VALIDATE_FAILED){
			log.setUserStatus("1");
			log.setValidateStatus("0");
			log.setValidateLog(paramster[0]);
		}else{
			log.setUserStatus("1");
			log.setValidateStatus("1");
			if(status == ResponseStatus.BUSINESS_ACCEPT_SUCCESS ){
				log.setBusinessStatus("1");
			}else{
				log.setBusinessStatus("0");
			}
			log.setBusinessExceptionMsg(paramster[0]);
			if(paramster.length>=2)log.setExecuteClass(paramster[1]);
			if(paramster.length>=3)log.setExecuteMethod(paramster[2]);
		}
		log.setResponseCode(responseMessageEntity.getResponseCode());
		try {
			log.setResponseDataJson(JsonTrans.ObjectToStrWithRootName(responseMessageEntity));
		} catch (JsonTransException e) {
			System.out.println("保存响应数据时出现错误");
			e.printStackTrace();
		}
		trunkLogService.insertNewLog(log);
		return false;
	}
	
	/**
	 * 插入请求数据后提供一个唯一的业务流水号
	 * @param request
	 * @return
	 */
	private TrunkLog insertRequestMessageToLog(RequestMessageEntity request){
		TrunkLog log = new TrunkLog();
		String serialNumber = String.valueOf(new Date().getTime());
		log.setSerialNumber(serialNumber);//暂定使用时间来当流水号
		request.setSerialNumber(serialNumber);
		try {
			log.setReqeustDataJson(JsonTrans.ObjectToStrWithRootName(request));
		} catch (JsonTransException e) {
			System.out.println("保存请求数据时出现错误");
			e.printStackTrace();
		}
		log.setTradeCode(request.getTradeCode());
		log.setLogTime(DesignCommonUtils.getDateTimeForNow());
		log.setOperatorNo(request.getOperatorNo());
		return log;
	}
	
	/**
	 * 进行报文完整性校验。如果返回值不为空，则意味着有返回信息，完整性校验失败。将返回信息返给日志并回复给请求端
	 * @param request
	 * @return
	 */
	private String validateRequestMessage(RequestMessageEntity request){
		if(request.getOperatorNo()==null || request.getOperatorNo().isEmpty())return "没有获取到操作员号码";
		if(request.getDepartmentNo() == null || request.getDepartmentNo().isEmpty()) return "没有获取到机构号码";
		if(request.getRequestTime() == null || request.getRequestTime().isEmpty())return "请求时间不能为空";
		if(request.getTradeCode() == null || request.getTradeCode().isEmpty())return "交易主码不能为空";
		return null;
	}
	
	private ResponseMessageEntity processResponseAndLog(TrunkLog log,ResponseStatus status,String... paramster ){
		ResponseMessageEntity responseMessageEntity = DesignCommonUtils.createNewResponseMessage(status);
		insertResponseMessageLog(log,status,responseMessageEntity,paramster);
		responseMessageEntity.setSerialNumber(log.getSerialNumber());
		return responseMessageEntity;
	}

	public void setDesignCommonService(DesignCommonService designCommonService) {
		this.designCommonService = designCommonService;
	}

	public void setValidateLogFactory(ValidateLogFactory validateLogFactory) {
		this.validateLogFactory = validateLogFactory;
	}

	public void setDataTransExecuteService(DataTransExecuteService dataTransExecuteService) {
		this.dataTransExecuteService = dataTransExecuteService;
	}
	public void setTrunkLogService(TrunkLogService trunkLogService) {
		this.trunkLogService = trunkLogService;
	}

}
