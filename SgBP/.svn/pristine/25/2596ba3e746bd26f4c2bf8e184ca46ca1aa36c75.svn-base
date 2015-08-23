package com.gzepro.internal.query.soa.extaction;

import org.springframework.stereotype.Component;

import com.gmcc.support.trade.service.provider.UserServiceLocator;
import com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub;
import com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixServiceLocator;
import com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixServiceSoapBindingStub;
import com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonServiceLocator;
import com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonServiceSoapBindingStub;
import com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceServiceLocator;
import com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceServiceSoapBindingStub;
import com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceServiceLocator;
import com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceServiceSoapBindingStub;
import com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestServiceLocator;
import com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestServiceSoapBindingStub;
import com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServiceLocator;
import com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServicePortBindingStub;
import com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceServiceLocator;
import com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceServiceSoapBindingStub;
import com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessServiceLocator;
import com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessServiceSoapBindingStub;
import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.util.WSProxy;

@Component("rsExtBaseService")
public class RsExtBaseService extends BaseService {
	/**
	 * 初始化customerStub 
	 * @return
	 * @throws Exception
	 */
	protected UserServiceSoapBindingStub initUserStubOut () throws Exception{
        com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub binding;
        UserServiceLocator serviceLocator = new UserServiceLocator();
		String serviceUrl = this.getPropertieValue("config/webservice.properties", "OutRouterForUser");
		serviceLocator.setUserServicePortEndpointAddress(serviceUrl);
		binding = (com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub)serviceLocator.getUserServicePort();
		
		//为服务添加SoapHeads信息
        WSProxy sSProxy = new WSProxy();
        binding.setHeader(sSProxy.getUsernameEle());
        binding.setHeader(sSProxy.getPasswordEle()); 
		return binding;
	}
	

	/**
	 * 初始化RsPersonStub 人员基本信息
	 * @return
	 * @throws Exception
	 */
	protected com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonServiceSoapBindingStub initRsPersonStubOut () throws Exception{
        com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonServiceSoapBindingStub binding;
        com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonServiceLocator serviceLocator = new com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonServiceLocator();
		String serviceUrl = this.getPropertieValue("config/webservice.properties", "OutRsPersonProxyService");
		serviceLocator.setRsPersonServicePortEndpointAddress(serviceUrl);
		binding = (com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonServiceSoapBindingStub)serviceLocator.getRsPersonServicePort();
		
		//为服务添加SoapHeads信息
        WSProxy sSProxy = new WSProxy();
        binding.setHeader(sSProxy.getUsernameEle());
        binding.setHeader(sSProxy.getPasswordEle()); 
		return binding;
	}
	
	/**
	 * 初始化RsPersonType 人才统计基本信息
	 * @return
	 * @throws Exception
	 */
	protected RsPersonTypeServicePortBindingStub initRctjStubOut () throws Exception{
        com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServicePortBindingStub binding;
        RsPersonTypeServiceLocator serviceLocator = new RsPersonTypeServiceLocator();
		String serviceUrl = this.getPropertieValue("config/webservice.properties", "OutRsPersonTypeProxyService");
		serviceLocator.setRsPersonTypeServicePortEndpointAddress(serviceUrl);
		binding = (com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServicePortBindingStub)serviceLocator.getRsPersonTypeServicePort();
		
		//为服务添加SoapHeads信息
        WSProxy sSProxy = new WSProxy();
        binding.setHeader(sSProxy.getUsernameEle());
        binding.setHeader(sSProxy.getPasswordEle()); 
		return binding;
	}
	
	
	/**
	 * 初始化WorkexperienceStub 工作经历
	 * @return
	 * @throws Exception
	 */
	protected WorkexperienceServiceSoapBindingStub initWorkexperienceStubOut () throws Exception{
        com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceServiceSoapBindingStub binding;
        WorkexperienceServiceLocator serviceLocator = new WorkexperienceServiceLocator();
		String serviceUrl = this.getPropertieValue("config/webservice.properties", "OutWorkexperienceProxyService");
		serviceLocator.setWorkexperienceServicePortEndpointAddress(serviceUrl);
		binding = (com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceServiceSoapBindingStub)serviceLocator.getWorkexperienceServicePort();
		
		//为服务添加SoapHeads信息
        WSProxy sSProxy = new WSProxy();
        binding.setHeader(sSProxy.getUsernameEle());
        binding.setHeader(sSProxy.getPasswordEle()); 
		return binding;
	}
	
	/**
	 * 初始化EducationProxyServiceStub 教育经历
	 * @return
	 * @throws Exception
	 */
	protected EducationexperienceServiceSoapBindingStub initEducationexperienceStubOut () throws Exception{
        com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceServiceSoapBindingStub binding;
        EducationexperienceServiceLocator serviceLocator = new EducationexperienceServiceLocator();
		String serviceUrl = this.getPropertieValue("config/webservice.properties", "OutEducationProxyService");
		serviceLocator.setEducationexperienceServicePortEndpointAddress(serviceUrl);
		binding = (com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceServiceSoapBindingStub)serviceLocator.getEducationexperienceServicePort();
		
		//为服务添加SoapHeads信息
        WSProxy sSProxy = new WSProxy();
        binding.setHeader(sSProxy.getUsernameEle());
        binding.setHeader(sSProxy.getPasswordEle()); 
		return binding;
	}
	
	/**
	 * 初始化TechnologicalHarvestServiceSoapBindingStub 科技成果
	 * @return
	 * @throws Exception
	 */
	protected TechnologicalHarvestServiceSoapBindingStub initTechnologicalHarvestStubOut () throws Exception{
        com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestServiceSoapBindingStub binding;
        TechnologicalHarvestServiceLocator serviceLocator = new TechnologicalHarvestServiceLocator();
		String serviceUrl = this.getPropertieValue("config/webservice.properties", "OutTechnologicalHarvestProxyService");
		serviceLocator.setTechnologicalHarvestServicePortEndpointAddress(serviceUrl);
		binding = (com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestServiceSoapBindingStub)serviceLocator.getTechnologicalHarvestServicePort();
		
		//为服务添加SoapHeads信息
        WSProxy sSProxy = new WSProxy();
        binding.setHeader(sSProxy.getUsernameEle());
        binding.setHeader(sSProxy.getPasswordEle()); 
		return binding;
	}
	
	
	/**
	 * 初始化TechnologicalHarvestServiceSoapBindingStub 项目经验
	 * @return
	 * @throws Exception
	 */
	protected ProjectExperienceServiceSoapBindingStub initProjectExperienceStubOut () throws Exception{
        com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceServiceSoapBindingStub binding;
        ProjectExperienceServiceLocator serviceLocator = new ProjectExperienceServiceLocator();
		String serviceUrl = this.getPropertieValue("config/webservice.properties", "OutProjectExperienceProxyService");
		serviceLocator.setProjectExperienceServicePortEndpointAddress(serviceUrl);
		binding = (com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceServiceSoapBindingStub)serviceLocator.getProjectExperienceServicePort();
		
		//为服务添加SoapHeads信息
        WSProxy sSProxy = new WSProxy();
        binding.setHeader(sSProxy.getUsernameEle());
        binding.setHeader(sSProxy.getPasswordEle()); 
		return binding;
	}
	
	/**
	 * 初始化TechnologicalHarvestServiceSoapBindingStub 职称信息
	 * @return
	 * @throws Exception
	 */
	protected TechnicallymessServiceSoapBindingStub initTechnicallymessStubOut () throws Exception{
        com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessServiceSoapBindingStub binding;
        TechnicallymessServiceLocator serviceLocator = new TechnicallymessServiceLocator();
		String serviceUrl = this.getPropertieValue("config/webservice.properties", "OutTechnicallymessProxyService");
		serviceLocator.setTechnicallymessServicePortEndpointAddress(serviceUrl);
		binding = (com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessServiceSoapBindingStub)serviceLocator.getTechnicallymessServicePort();
		
		//为服务添加SoapHeads信息
        WSProxy sSProxy = new WSProxy();
        binding.setHeader(sSProxy.getUsernameEle());
        binding.setHeader(sSProxy.getPasswordEle()); 
		return binding;
	}

	/**
	 * 初始化RsAffixStub 附件信息
	 * @return
	 * @throws Exception
	 */
	protected RsAffixServiceSoapBindingStub initRsAffixStubOut () throws Exception{
        com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixServiceSoapBindingStub binding;
        RsAffixServiceLocator serviceLocator = new RsAffixServiceLocator();
		String serviceUrl = this.getPropertieValue("config/webservice.properties", "OutRsAffixService");
		serviceLocator.setRsAffixServicePortEndpointAddress(serviceUrl);
		binding = (com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixServiceSoapBindingStub)serviceLocator.getRsAffixServicePort();
		
		//为服务添加SoapHeads信息
        WSProxy sSProxy = new WSProxy();
        binding.setHeader(sSProxy.getUsernameEle());
        binding.setHeader(sSProxy.getPasswordEle()); 
		return binding;
	}

}
