package trans.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.transData.business.service.BusinessModelService;
import com.transData.business.service.DoBusinessService;
import com.transData.business.service.impl.BusinessModelServiceImpl;
import com.transData.business.service.impl.DoBusinessServiceImpl;
import com.transData.db.common.CommonDbService;
import com.transData.db.common.impl.CommonDbServiceImpl;
import com.transData.port.service.CmsDataTransService;
import com.transData.port.service.impl.CmsDataTransServiceImpl;
import com.transData.port.util.service.DesignCommonService;
import com.transData.port.util.service.impl.DesignCommonServiceImpl;
import com.transData.trans.service.DataTransConfigService;
import com.transData.trans.service.DataTransExecuteService;
import com.transData.trans.service.impl.DataTransConfigServiceImpl;
import com.transData.trans.service.impl.DataTransExecuteServiceImpl;
import com.transData.trunkLog.service.TrunkLogService;
import com.transData.trunkLog.service.impl.TrunkLogServiceImpl;
import com.transData.validate.entity.service.ValidateEntityService;
import com.transData.validate.entity.service.impl.ValidateEntityServiceImpl;
import com.transData.validate.log.ValidateLogFactory;
import com.transData.validate.log.impl.ValidateLogFactoryImpl;

@Configuration
public class DataTransTestConfig {
	
	@Bean
	public DataTransExecuteService getDataTransExecuteService(){
		return new DataTransExecuteServiceImpl();
	}
	
	@Bean
	public DataTransConfigService getDataTransConfigService(){
		return new DataTransConfigServiceImpl();
	}
	
	@Bean
	public ValidateEntityService getValidateEntityService(){
		return new ValidateEntityServiceImpl();
	}
	
	@Bean
	public ValidateLogFactory getValidateLogFactory(){
		return new ValidateLogFactoryImpl();
	}
	
	@Bean
	public CmsDataTransService getCmsDataTransService(){
		return new CmsDataTransServiceImpl();
	}
	
	@Bean
	public DesignCommonService getDesignCommonService(){
		return new DesignCommonServiceImpl();
	}
	
	@Bean
	public TrunkLogService getTrunkLogService(){
		return new TrunkLogServiceImpl();
	}
	
	@Bean
	public DoBusinessService getDoBusinessService(){
		return new DoBusinessServiceImpl();
	}
	
	@Bean
	public BusinessModelService getBusinessModelService(){
		return new BusinessModelServiceImpl();
	}
	
	@Bean
	public CommonDbService getCommonDbService(){
		return new CommonDbServiceImpl();
	}
}
