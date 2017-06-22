package com.transData.business.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.transData.business.entity.ArgumentsEntity;
import com.transData.business.entity.BusinessModel;
import com.transData.business.service.BusinessModelService;
import com.transData.business.service.DoBusinessService;
import com.transData.business.util.BusinessBeanFactory;
import com.transData.db.common.CommonDbService;
import com.transData.db.common.CommonServiceType;
import com.transData.exception.BusinessException;
import com.transData.trans.entity.DataTransEntity;
import com.transData.util.ParametersUtil;

public class DoBusinessServiceImpl implements DoBusinessService {
	@Autowired
	private BusinessModelService businessModelService;
	
	@Autowired
	private CommonDbService commonDbService;

	@Override
	public BusinessModel callBusinessMethod(ArgumentsEntity argumentsEntity) throws BusinessException {
		try {
			return callBusinessMethodExec(argumentsEntity);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | InstantiationException
				| ClassNotFoundException e) {
			e.printStackTrace();
			String exceptionMsg = "在调用业务执行方法时出现了错误";
			throw new BusinessException(exceptionMsg,e);
		}
	}
	
	private BusinessModel callBusinessMethodExec(ArgumentsEntity argumentsEntity) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException{
		//1.根据业务编号获取要执行的类，方法以及执行参数
		BusinessModel model = businessModelService.getBusinessModel(argumentsEntity.getBusiCode());
		//2.给参数类赋值
		Object paramObject = null;
		Object resultObject = null;
		String targetClazzPath = model.getParamterClass();

		//对参数对象进行赋值。如果能够反射出正确的参数对象，则可以执行模板化操作
		if(targetClazzPath != null && !targetClazzPath.trim().isEmpty()){
			paramObject = assignmentTargetClazzValue(targetClazzPath,argumentsEntity.getPrepareDataList());
			model.setParamterObject(paramObject);
		}
		
		
		if(model.getCommonServiceName()!=null && !model.getCommonServiceName().isEmpty() && paramObject != null){
			//3.1 如果该model存在模板方法，优先执行model执行模板方法
			CommonServiceType serviceType = CommonServiceType.getServiceType(model.getCommonServiceName());
			switch (serviceType) {
			case INSERT:
				resultObject = commonDbService.insertObject(paramObject, model.getColumnNameType());
				break;
			case UPDATE:
				//TODO 修改部分的模板操作不建议在此处进行
//				resultObject = commonDbService.insertObject(paramObject, model.getColumnNameType());
				break;
			case DELETE:
				resultObject = commonDbService.deleteObject(paramObject, model.getColumnNameType());
				break;
			case SELECT_ONE:
				resultObject = commonDbService.selectOneObject(paramObject, model.getColumnNameType());
				break;
			case SELECT_PAGE:
				int startNum = getNumberValueFromDataArrayList(ParametersUtil.START_NUMBER_DATANAME,argumentsEntity.getPrepareDataList());
				int endNum = getNumberValueFromDataArrayList(ParametersUtil.END_NUMBER_DATANAME,argumentsEntity.getPrepareDataList());
				resultObject = commonDbService.selectAllObject(paramObject, startNum, endNum, model.getColumnNameType());
			default:
				break;
			}
		}else{
			//3.2 如果不存在model模板方法，则反射调用这个方法和这个类(此处使用spring配置)
			if(model.getServiceBeanName()==null || model.getServiceBeanName().isEmpty()){
				throw new NoSuchMethodException("没有配置对应的业务执行方法，请在后台配置与【"+argumentsEntity.getBusiCode()+"】对应的业务bean或者模板发方法");
			}
			Object clazz = BusinessBeanFactory.getBeanFromSpringBean(model.getServiceBeanName());
			model.setServiceClassName(clazz.getClass().getName());
			Method execMethod = null;
			
			if(paramObject == null){
				execMethod = clazz.getClass().getDeclaredMethod(model.getMethodName());
				resultObject = execMethod.invoke(clazz);
			}else{
				execMethod = clazz.getClass().getDeclaredMethod(model.getMethodName(),paramObject.getClass());
				resultObject = execMethod.invoke(clazz,paramObject);
			}
		}
		
		//4.给返回值赋值
		model.setResultObject(resultObject);
		if(resultObject instanceof String || resultObject instanceof Integer || resultObject instanceof Double || resultObject.getClass().isPrimitive()){
			model.setResultMsg(String.valueOf(resultObject));
		}
		return model;
	}
	
	private Object assignmentTargetClazzValue(String clazzPath, List<DataTransEntity> prepareDataList) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException{
		if(clazzPath == null || clazzPath.isEmpty()){
			return null;
		}
		Object targetClazz = Class.forName(clazzPath).newInstance();
		//如果是基本类型的话，则直接取第一个值进行赋值操作
		//TODO 如果所需参数与传递进来的参数数量不符，是否需要进行校验和提示
		if(targetClazz instanceof String){
			targetClazz = prepareDataList.get(0).getDataValue();
		}else if(targetClazz instanceof Double){
			targetClazz = Integer.valueOf(prepareDataList.get(0).getDataValue());
		}else if(targetClazz instanceof Integer){
			targetClazz = Double.valueOf(prepareDataList.get(0).getDataValue());
		}else if(targetClazz instanceof Boolean){
			targetClazz = Boolean.valueOf(prepareDataList.get(0).getDataValue());
		}else if(targetClazz.getClass().isPrimitive()){
			targetClazz = prepareDataList.get(0).getDataValue();
		}
		
		Field[] fields = targetClazz.getClass().getDeclaredFields();
		Method setMethod = null;
		String fieldName = "";
		String fieldTypeName = "";
		String setMethodName = "";
		for(Field field : fields){
			fieldName = field.getName();
			for(DataTransEntity entiyEntity : prepareDataList){
				if(entiyEntity.getDataTransName().equals(fieldName)){
					setMethodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
					setMethod = targetClazz.getClass().getDeclaredMethod(setMethodName, field.getType());
					//TODO 如果DataTransEntity中的值为其他类型如何处理？
					if(entiyEntity.getDataValue()!=null){
						fieldTypeName = field.getType().getSimpleName();
						if("String".equals(fieldTypeName)){
							setMethod.invoke(targetClazz, entiyEntity.getDataValue());
						}else if("Integer".equals(fieldTypeName) || ("int").equals(fieldTypeName)){
							setMethod.invoke(targetClazz, Integer.valueOf(entiyEntity.getDataValue()));
						}else if("Double".equals(fieldTypeName) || ("double").equals(fieldTypeName)){
							setMethod.invoke(targetClazz, Double.valueOf(entiyEntity.getDataValue()));
						}else if("Boolean".equals(fieldTypeName) || ("boolean").equals(fieldTypeName)){
							setMethod.invoke(targetClazz, Boolean.valueOf(entiyEntity.getDataValue()));
						}
						break;
					}
				}
			}
		}
		return targetClazz;
	}
	
	private Integer getNumberValueFromDataArrayList (String dataName,List<DataTransEntity> prepareDataList){
		for(DataTransEntity entity: prepareDataList){
			if(entity.getDataTransName().equalsIgnoreCase(dataName)){
				return  Integer.valueOf(entity.getDataValue());
			}
		}
		return null;
	}
}