package com.gzepro.internal.query.common.struts.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gzepro.internal.query.soa.extaction.DataChangeTask;
import com.gzepro.internal.query.soa.extaction.sundoctor.SchedulerService;

import com.gzepro.internal.query.system.model.Conf;
import com.gzepro.internal.query.system.model.SysResource;
import com.gzepro.internal.query.system.service.ConfService;
import com.gzepro.internal.query.system.service.SysResourceService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public final class ApplicationListener implements ServletContextListener {
	
	private static final String BEAN_NAME = "sysResourceService";
	private static final String CONF_NAME = "confService";
	private DataChangeTask dataChangeTask;
	public static Map<String,String[]> _resmap = new HashMap<String,String[]>();
	public static Map<String,Map> _confmap = new HashMap<String,Map>();
	public void contextDestroyed(ServletContextEvent event) {
	}
	

	public void contextInitialized(ServletContextEvent event) {
				
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());
		//dataChangeTask = (DataChangeTask) wac.getBean("dataChangeTask",DataChangeTask.class);
		//dataChangeTask.setAndReadDataChangeTime(); 
		sysResourceService = (SysResourceService) wac.getBean(BEAN_NAME,SysResourceService.class);
		List<SysResource> list = sysResourceService.findAll();
		Map<String,String[]> map = new HashMap<String,String[]>();
		if(list != null && list.size() >0){
			for(SysResource resource:list){
				String[] arr = new String[3];
				if(resource.getKey() != null && !resource.getKey().equals("")){
					if(resource.getNameZh() != null && !resource.equals("")){
						arr[0] = resource.getNameZh();
					}else{
						arr[0] = resource.getKey();
					}
					if(resource.getNameEn() != null && !resource.getNameEn().equals("")){
						arr[1] = resource.getNameEn();
					}else{
						arr[1] = resource.getKey();
					}
					if(resource.getNameTw() != null && !resource.getNameTw().equals("")){
						arr[2] = resource.getNameTw();
					}else{
						arr[2] = resource.getKey();
					}
					map.put(resource.getKey(), arr);
				}
			}
			wac.getServletContext().setAttribute("_WEB_SYS_RESOURCE_KEY_", map);
			ApplicationListener._resmap = map;
		}
		confService = (ConfService) wac.getBean(CONF_NAME,ConfService.class);
		List<Conf> clist = confService.findConfAll();
		Map<String, Map> cmap=new HashMap<String, Map>();
//		for (Conf conf : clist) {
//			Map<String, String> confMap=cmap.get(conf.getTypeId().toString());
//			if(confMap!=null&&confMap.size()>0){
//				cmap.get(conf.getTypeId().toString()).put(conf.getCode(), conf.getName());
//			}else{
//				confMap=new HashMap<String, String>();
//				confMap.put(conf.getCode(), conf.getName());
//				cmap.put(conf.getTypeId().toString(), confMap);
//			}
//		}
		
		
		for (Conf conf : clist) {
		Map<String, String> confMap=cmap.get(conf.getTypeId().toString());
		if(confMap!=null&&confMap.size()>0){
			cmap.get(conf.getTypeId().toString()).put(conf.getCode(), conf.getName());
		}else{
			confMap=new LinkedHashMap<String, String>();
			confMap.put(conf.getCode(), conf.getName());
			cmap.put(conf.getTypeId().toString(), confMap);
		}
	}
		
		
		wac.getServletContext().setAttribute("_WEB_SYS_CONF_KEY_", cmap);
		ApplicationListener._confmap = cmap;
	}
	
	private SysResourceService sysResourceService;
	private ConfService confService;
}
