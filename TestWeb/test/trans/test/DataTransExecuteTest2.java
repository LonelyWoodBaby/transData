package trans.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.transData.port.entity.RequestMessageEntity;
import com.transData.port.entity.ResponseMessageEntity;
import com.transData.port.service.CmsDataTransService;
import com.transData.port.util.DesignCommonUtils;
import com.transData.trans.entity.DataTransEntityCache;
import com.transData.trans.service.DataTransConfigService;
import com.transData.trans.service.DataTransExecuteService;
import com.transData.validate.entity.dojo.DataValidateEntityCache;
import com.transData.validate.entity.service.ValidateEntityService;
import com.transData.validate.log.ValidateLogFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = (DataTransTestConfig.class))
@FixMethodOrder(MethodSorters.DEFAULT)
public class DataTransExecuteTest2 {
	private RequestMessageEntity request;
	
	
	@Autowired
	private DataTransExecuteService dtes;
	
	@Autowired
	private DataTransConfigService dtcs;
	
	@Autowired
	private ValidateEntityService ves;
	
	@Autowired
	private ValidateLogFactory logFactory;
	
	@Autowired
	private CmsDataTransService cmsDataTransService;
	
	/**
	 * 初始化测试数据
	 */
	@Before
	public void initDataConfig(){
		//1.初始化数据模板
		DataTransEntityCache.reloadCache();
		//2.初始化校验模板
		DataValidateEntityCache.reloadCache();
		//3.初始化请求数据
		String dataJson = "{\"name1\":\"liyabin\",\"age1\":\"23\",\"salay1\":234.123,\"work1\":\"100\",\"username1\":\"ceshiyixia\",\"firstName1\":\"true\",\"babyName1\":\"32112\","+
						"\"getMoney1\":123,\"birthday1\":\"2017-12-24\",\"depaName1\":\"sdsadas\",\"cause1\":\"312312321dddd\",\"sendDate1\":\"2018-1-2\",\"sendType1\":\"1\",\"isDeadLine1\":true,"+
				"\"sign1\":\"ddaaa\",\"signDate1\":\"31sa12\",\"myJugment1\":\"234.123\",\"telephone1\":\"ewaewee\",\"phoneNumber1\":\"13098712312\",\"appname1\":\"test123\",\"appprice1\":20.1,\"appdate1\":\"33dasd\",\"gamename1\":\"30.1\",\"gameprice1\":\"56.2\"}";
		request = new RequestMessageEntity();
		request.setAssistCode("");
		request.setBusinessBody(dataJson);
		request.setDepartmentNo("");
		request.setOperatorNo("123");
		request.setPassworkKey("noKey");
		request.setRequestInfo("");
		request.setRequestTime(DesignCommonUtils.getDateTimeForNow());
		request.setTradeCode("testTrans1");
		
		System.out.println("缓存初始化完毕");
	}
	
	@Ignore
	public void sendRequestFunction(){
		ResponseMessageEntity response = cmsDataTransService.analysisRequestMessage(request);
		Assert.assertNotNull(response);
		System.out.println(response.getBusinessBody());
	}
	@Test
	public void sendRequestSpeedFor10000(){
		for(int i = 0; i<50; i++){
			cmsDataTransService.analysisRequestMessage(request);
			System.out.println("---------------------已执行"+i+"次---------------------------");
		}
	}

	public void setDtes(DataTransExecuteService dtes) {
		this.dtes = dtes;
	}


	public void setVes(ValidateEntityService ves) {
		this.ves = ves;
	}

	public void setLogFactory(ValidateLogFactory logFactory) {
		this.logFactory = logFactory;
	}

	public void setCmsDataTransService(CmsDataTransService cmsDataTransService) {
		this.cmsDataTransService = cmsDataTransService;
	}
	
}
