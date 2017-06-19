package com.transData.business.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.transData.business.entity.ArgumentsEntity;
import com.transData.business.entity.BusinessModel;
import com.transData.business.service.BusinessModelService;
import com.transData.business.service.DoBusinessService;
import com.transData.business.util.BusinessBeanFactory;
import com.transData.exception.BusinessException;
import com.transData.trans.entity.DataTransEntity;

public class DoBusinessForArrayServiceImpl implements DoBusinessService {
	@Autowired
	private BusinessModelService businessModelService;
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

	private BusinessModel callBusinessMethodExec(ArgumentsEntity argumentsEntity) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		//1.根据业务编号获取要执行的类，方法以及执行参数
		BusinessModel model = businessModelService.getBusinessModel(argumentsEntity.getBusiCode());
		
		//2.给参数类赋值
		Object paramObject = null;
		String targetClazzPath = model.getParamterClass();
		if(targetClazzPath != null && !targetClazzPath.trim().isEmpty()){
			Object targetClazz = Class.forName(targetClazzPath).newInstance();
			if(argumentsEntity.isArrayData()){//如果传递的是一个数组序列，则生成一个列表并传递赋给该方法。
				paramObject = assignmentTargetArrayClazzValue(targetClazz,argumentsEntity.getPrepareDataArrayList());
			}else{//如果不是数组或者集合序列，则传递一个对象给对方
				paramObject = assignmentTargetClazzValue(targetClazz,argumentsEntity.getPrepareDataArrayList().get(0));

			}
			model.setParamterObject(paramObject);
		}
		
		//3.反射调用这个方法和这个类(此处使用spring配置)
		Object clazz = BusinessBeanFactory.getBeanFromSpringBean(model.getServiceBeanName());
		model.setServiceClassName(clazz.getClass().getName());
		Method execMethod = null;
		Object resultObject = null;
		if(paramObject == null){
			execMethod = clazz.getClass().getDeclaredMethod(model.getMethodName());
			resultObject = execMethod.invoke(clazz);
		}else{
			execMethod = clazz.getClass().getDeclaredMethod(model.getMethodName(),paramObject.getClass());
			resultObject = execMethod.invoke(clazz,paramObject);
		}
		
		//4.给返回值赋值
		model.setResultObject(resultObject);
		if(resultObject instanceof String || resultObject instanceof Integer || resultObject instanceof Double){
			model.setResultMsg(String.valueOf(resultObject));
		}
		return model;
	}
	
	private Object assignmentTargetClazzValue(Object targetClazz, List<DataTransEntity> prepareDataList) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException{
		//如果是基本类型的话，则直接取第一个值进行赋值操作
		//TODO 如果所需参数与传递进来的参数数量不符，是否需要进行校验和提示
		if(targetClazz instanceof String){
			targetClazz = prepareDataList.get(0).getDataValue();
		}else if(targetClazz instanceof Double){
			targetClazz = Integer.valueOf(prepareDataList.get(0).getDataValue());
		}else if(targetClazz instanceof Integer){
			targetClazz = Double.valueOf(prepareDataList.get(0).getDataValue());
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
						}else if("Integer".equals(fieldTypeName)){
							setMethod.invoke(targetClazz, Integer.valueOf(entiyEntity.getDataValue()));
						}else if("Double".equals(fieldTypeName)){
							setMethod.invoke(targetClazz, Double.valueOf(entiyEntity.getDataValue()));
						}else if(field.getType().isPrimitive()){
							setMethod.invoke(targetClazz, entiyEntity.getDataValue());
						}else if(field.getType().isAssignableFrom(List.class)){
							continue;//TODO 类型为List类型，暂时不作处理
						}
					}
				}
			}
		}
		return targetClazz;
	}
	
	public List<?> assignmentTargetArrayClazzValue(Object targetClazz,
			List<List<DataTransEntity>> prepareDataList) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException{
		//此时已经确定targetClazz为list
		List<Object> targetList = new ArrayList<Object>();
		for(List<DataTransEntity> dataTransEntityList : prepareDataList){
			targetList.add(assignmentTargetClazzValue(targetClazz,dataTransEntityList));
		}
		//先反射出List的泛型类别
		
		return targetList;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("111133");
		testList.add("55533");
		testList.add("423123");
		testList.add("54323");
//		DoBusinessForArrayServiceImpl.assignmentTargetArrayClazzValue(testList, null);
	}
}





































