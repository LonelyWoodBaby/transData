package trans.test;

import java.util.List;

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
import com.transData.trans.entity.DataTransEntity;
import com.transData.trans.service.DataTransConfigService;
import com.transData.trans.service.DataTransExecuteService;
import com.transData.util.ParametersUtil;
import com.transData.validate.entity.service.ValidateEntityService;
import com.transData.validate.log.ValidateLogFactory;
import com.transData.validate.log.entity.ValidateLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = (DataTransTestConfig.class))
@FixMethodOrder(MethodSorters.DEFAULT)
public class DataTransExecuteTest {
	private final String TEST_CODE = ParametersUtil.GET_ENTITY_ALL;
	private String dataJson;
	private String businessCode;
	private RequestMessageEntity request;
	private List<DataTransEntity> entityTransList;
	private List<DataTransEntity> entityTransListFromJson;
	
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
		this.dataJson = "{\"name\":\"foo\",\"age\":\"23\",\"salary\":\"234.123\",\"num\":\"100\",\"balance\":\"1000.21\",\"is_vip\":\"true\",\"nickname\":null}";
		this.businessCode = TEST_CODE;
		entityTransList = dtcs.getEntityListByCode(businessCode);
		
		request = new RequestMessageEntity();
		request.setAssistCode("");
		request.setBusinessBody(dataJson);
		request.setDepartmentNo("");
		request.setOperatorNo("123");
		request.setPassworkKey("noKey");
		request.setRequestInfo("");
		request.setRequestTime(DesignCommonUtils.getDateTimeForNow());
		request.setTradeCode(TEST_CODE);
	}
	
	/**
	 * 主要用于测试json串中的数据是否能够与entityList列表进行匹配，并对name相同的值进行值配对
	 */
	@Ignore
	public void testTransReceiveData() {
		Assert.assertTrue(entityTransList != null && entityTransList.size() > 0);
		entityTransListFromJson = dtes.transReceiveData(entityTransList, dataJson);
		Assert.assertTrue(entityTransListFromJson != null && entityTransListFromJson.size() > 0);
		Assert.assertTrue(entityTransListFromJson.size() == 5);
	}
	
	@Ignore
	public void testValidateDataTest(){
		entityTransListFromJson = dtes.transReceiveData(entityTransList, dataJson);
		ValidateLog validateLog = logFactory.createValidateResultLog(TEST_CODE, entityTransListFromJson);
		Assert.assertNotNull(validateLog);
		System.out.println(validateLog.showLog());
	}
	
	@Test
	public void testAnalysisRequestMessage(){
		ResponseMessageEntity response = cmsDataTransService.analysisRequestMessage(request);
		Assert.assertNotNull(response);
		System.out.println(response.getResponseMessage());
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
