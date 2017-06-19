package com.transData.trans.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.transData.trans.entity.DataTransEntity;
import com.transData.trans.service.DataTransExecuteService;
import com.transData.trans.springconfig.DataTransSpringConfig;

public class TestMain {
	public static void main(String[] args) {
		//读取spring配置
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataTransSpringConfig.class);
		DataTransExecuteService dtes = context.getBean(DataTransExecuteService.class);
		
		//自定义json串
		String dataJson = "{\"name\":\"foo\",\"num\":\"100\",\"balance\":\"1000.21\",\"is_vip\":\"true\",\"nickname\":null}";
		//进行业务操作
		List<DataTransEntity> resultList = dtes.transReceiveData("suibainxie", dataJson);
		//遍历打印
		for(DataTransEntity entity: resultList){
			System.out.println(entity.getDataTransName() + ":" + entity.getDataValue());
		}
		
		
		context.close();
	}
}
