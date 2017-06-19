package com.transData.validate.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.transData.validate.entity.base.ValidateEntityStock;
import com.transData.validate.entity.base.ValidateEnum;
import com.transData.validate.entity.base.ValidateResult;
import com.transData.validate.entity.base.ValidateRuleEntity;

public class ValidateUtil {
	
	/**
	 * 
	 * @param stock
	 * @param isReturnAll 如果为true，则返回全部的校验结果，无论是否通过。如果为false，只返回未通过校验的stock值
	 * @return
	 */
	public static ValidateEntityStock createStockResult(ValidateEntityStock stock,boolean isReturnAll){
		if(stock == null || stock.getValidateResultMap() == null)return stock;
		Map<ValidateRuleEntity, ValidateResult> resultMap =  new HashMap<ValidateRuleEntity, ValidateResult>();
		ValidateResult result = null;
		for(ValidateRuleEntity entity : stock.getValidateResultMap().keySet()){
			result = validateExecute(stock.getDataValidName(), stock.getValidateValue(), entity.getEnumType(), entity.getNumberParams(), entity.getDoubleParams(), entity.getStringParams());
			if(isReturnAll || result != null){
				resultMap.put(entity, result);
			}
		}
		stock.setValidateResultMap(resultMap);//重新赋值
		return stock;
	}
	
	/**
	 * 对所输入的值进行校验，其中将所需要的一些参数作为数组传进来。普通的数字类型参数尽量使用int类型传入，如果是需要进行数字比较，则尽量使用double类型传入。
	 * @param validateName 要校验的字段名称
	 * @param validateValue	准备校验的实际值
	 * @param enumType
	 * @param numberParams  MAX_LENGTH，MIN_LENGTH，LENGTH_SIZE，【ASSERT_EQUAL】
	 * @param doubleParams	MAX_VALUE，MIN_VALUE，【ASSERT_EQUAL】
	 * @param stringParams	IS_DATE，【ASSERT_EQUAL】，PATTERN
	 * @param 无	NOT_NULL，NOT_BLANK，NOT_EMPTY，IS_BOOLEAN，IS_NUMBER，IS_FLOAT_NUMBER，IS_EMAIL，IS_ID_CARD，IS_IP_ADDRSS
	 * @return 
	 */
	public static ValidateResult validateExecute(String validateName,String validateValue,ValidateEnum enumType,int[] numberParams,double[] doubleParams,String[] stringParams){
		ValidateResult result = new ValidateResult(validateName,validateValue,enumType);
		switch (enumType) {
		
			case NOT_NULL:
				if(validateValue == null || validateValue.isEmpty()){
					return result.buildValidateMsg("【" + validateName + "】字段不应为空!");
				}
				break;
			case NOT_BLANK:
				if(validateValue == null || validateValue.trim().isEmpty()){
					return result.buildValidateMsg("【" + validateName + "】字段不能为空字符，且字符长度必须大于零!");
				}
				break;
			case NOT_EMPTY:
				if(validateValue == null || validateValue.length() == 0){
					return result.buildValidateMsg("【" + validateName + "】字段值长度必须大于零!");
				}
				break;
			case MAX_LENGTH:
				if(validateValue == null || validateValue.length() > numberParams[0]){
					return result.buildValidateMsg("【" + validateName + "】字段值【" + validateValue + "】的长度不应超过最大值【" + numberParams[0] + "】!");
				}
				break;
			case MIN_LENGTH:
				if(validateValue == null || validateValue.length() < numberParams[0]){
					return result.buildValidateMsg("【" + validateName + "】字段值【" + validateValue + "】的长度不应少于最小值【" + numberParams[0] + "】!");
				}
				break;
			case LENGTH_SIZE:
				if(validateValue == null || validateValue.length() < numberParams[0] || validateValue.length() > numberParams[1]){
					return result.buildValidateMsg("【" + validateName + "】字段值【" + validateValue + "】的长度应当在【" + numberParams[0] + "】与【" + numberParams[1] + "】之间!");
				}
				break;
			case IS_BOOLEAN:
				if(validateValue == null || !validateValue.equalsIgnoreCase("true") || !validateValue.equalsIgnoreCase("false")){
					return result.buildValidateMsg("【" + validateName + "】字段的值【" + validateValue + "】应当为布尔值!");
				}
				break;
			case IS_NUMBER:
				if(!isMatch("^-?\\d+$", validateValue)){
					return result.buildValidateMsg("【" + validateName + "】字段的值【" + validateValue + "】应当为整数类型!");
				}
				break;
			case IS_FLOAT_NUMBER:
				if(!isMatch("^(-?\\d+)(\\.\\d+)?$", validateValue)){
					return result.buildValidateMsg("【" + validateName + "】字段的值【" + validateValue + "】应当为数字类型!");
				}
				break;
			case IS_DATE:
				if(validateValue == null)return null;//如果为空则不参与判断是否非空
				if(stringParams == null || stringParams[0] == null){//如果没有为日期赋值，则提供一个默认格式
					stringParams = new String[1];
					stringParams[0] = "yyyy-MM-dd";
				}
				SimpleDateFormat sdf = new SimpleDateFormat(stringParams[0]);
				try {
					sdf.parse(validateValue);
				} catch (ParseException e) {
					//e.printStackTrace();
					return result.buildValidateMsg("【" + validateName + "】字段的值【" + validateValue + "】不是日期类型或日期类型格式不正确!");
				}
				break;
			case MAX_VALUE:
				Double compareMaxValue = getCompareValue(numberParams,doubleParams);
				if(compareMaxValue == null)return result.buildValidateMsg("【" + validateName + "】字段的值【"+validateValue+"】有最大值判断，但校验规则中没有为该规则赋值，校验失败。");
				if(!isMatch("^(-?\\d+)(\\.\\d+)?$", validateValue) || compareTo(validateValue, compareMaxValue) > 0){
					return result.buildValidateMsg("【" + validateName + "】字段的值【"+validateValue+"】不是数字或该值超过【"+doubleParams[0]+"】!");
				}
				break;
			case MIN_VALUE:
				Double compareMinValue = getCompareValue(numberParams,doubleParams);
				if(compareMinValue == null)return result.buildValidateMsg("【" + validateName + "】字段的值【"+validateValue+"】有最小值判断，但校验规则中没有为该规则赋值，校验失败。");
				if(!isMatch("^(-?\\d+)(\\.\\d+)?$", validateValue) || compareTo(validateValue, compareMinValue) < 0){
					return result.buildValidateMsg("【" + validateName + "】字段的值【"+validateValue+"】不是数字或该值超过【"+doubleParams[0]+"】!");
				}
				break;
			case ASSERT_EQUAL:
				if(validateValue == null || validateValue.isEmpty()){
					return result.buildValidateMsg("【" + validateName + "】字段不应为空!");
				}
				if(stringParams!=null && stringParams[0]!=null && stringParams[0].equals(validateValue)){
					return result.buildValidateMsg("【" + validateName + "】字段的值【"+validateValue+"】不等于目标值【"+stringParams[0]+"】!");
				}
				
				if(doubleParams != null && compareTo(validateValue, doubleParams[0])!=0){
					return result.buildValidateMsg("【" + validateName + "】字段的值【"+validateValue+"】不等于目标值【"+stringParams[0]+"】!");
				}
				
				if(numberParams != null && Long.valueOf(validateValue) != numberParams[0]){
					return result.buildValidateMsg("【" + validateName + "】字段的值【"+validateValue+"】不等于目标值【"+stringParams[0]+"】!");
				}
				break;
			case IS_EMAIL:
				if(!isMatch("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", validateValue)){
					return result.buildValidateMsg("【" + validateName + "】字段的值【" + validateValue + "】不符合校验要求，应当为邮箱类型!");
				}
				break;
			case IS_ID_CARD:
				if(!isMatch("^\\d{15}|^\\d{17}([0-9]|X|x)$", validateValue)){
					return result.buildValidateMsg("【" + validateName + "】字段的值【" + validateValue + "】不符合校验要求，应当为身份证类型!");
				}
				break;
			case IS_IP_ADDRSS:
				String rexString = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
						+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
						+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
						+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
				
				if(!isMatch(rexString, validateValue)){
					return result.buildValidateMsg("【" + validateName + "】字段的值【" + validateValue + "】不符合校验要求，应当为正确的IP地址类型!");
				}
				break;
			case PATTERN:
				if(!isMatch(stringParams[0], validateValue)){
					return result.buildValidateMsg("【" + validateName + "】字段的值【" + validateValue + "】不符合所需求的正则表达式【" + stringParams[0] + "】!");
				}
				break;
	
			default:
				return null;
		}
		return null;
	}
	
	private static boolean isMatch(String regex, String orginal) {
		if (orginal == null || orginal.trim().equals("")) {
			return false;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher isNum = pattern.matcher(orginal);
		return isNum.matches();
	}
	
	private static int compareTo(String aValue, double bValue){
		BigDecimal a = BigDecimal.valueOf(Double.valueOf(aValue));
		BigDecimal b = BigDecimal.valueOf(Double.valueOf(bValue));
		return a.compareTo(b);
	}
	
	private static Double getCompareValue(int[] numberParams, double[] doubleParams){
		if((doubleParams == null || doubleParams.length ==0) && (numberParams == null || numberParams.length == 0)){
			return null;
		}
		Double compareValue = 0.0;
		compareValue = (doubleParams == null || doubleParams.length ==0)?numberParams[0] : doubleParams[0];
		return compareValue;
	}
}
