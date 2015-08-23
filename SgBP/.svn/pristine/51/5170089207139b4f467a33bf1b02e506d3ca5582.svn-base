package com.gzepro.internal.query.soa.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.Paging;
import com.gzepro.internal.query.common.util.StrUtils;
import com.gzepro.internal.query.soa.extaction.RsExtBaseService;


@Service("rsPersonneedService")
public class RsPersonneedService extends RsExtBaseService {
	
	/**
	 * 
	  * @Title: saveOrUpdate
	  * @Description: TODO(保存或者修改人员信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public String saveOrUpdate(Object obj)throws Exception {
		RsPersonneed dto = (RsPersonneed)obj;
		RsPersonneed parameters = new RsPersonneed();
		parameters=(RsPersonneed)CloneUtil.cloneObject(dto,parameters,null);
		
		String result = this.initRsPersonneedStub().acceptSaveRsPersonneed(parameters);
		return result;
	}
	
	/**
	 * 根据查询参数调用WS,返回查询到的人员信息
	 * @param soObject 查询的参数对象
	 * @param menuId  功能模块Id
	 * @param accounted 当前的登录用户
	 * @return 结果对象
	 */
	public Paging queryByPage(Paging paging, RsPersonneed rsPersonneed) throws Exception {
		//将搜索对象转换成用户查询的搜索对象
        com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed parameters = new com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed();
		parameters =  (RsPersonneed) CloneUtil.cloneObject(rsPersonneed, parameters, null);
		com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed valueElement = null;
		com.gmcc.support.trade.service.provider.rcsm.need.Paging paramPaging = new com.gmcc.support.trade.service.provider.rcsm.need.Paging();
		paramPaging.setCurrentIndex(paging.getCurrentIndex());
		paramPaging.setPageSize(paging.getPageSize());
		
		
		paramPaging = this.initRsPersonneedStub().acceptQueryRsPersonneedByPage(parameters, paramPaging);
		if(paramPaging != null) {
			paging.setTotalPages(paramPaging.getTotalPages());
			paging.setTotalRecords(paramPaging.getTotalRecords());
			paging.setVoList(new ArrayList<RsPersonneed>());
			//调用WS返回结果 value
			if(paramPaging.getVoList() != null) {
				Object[] objList=paramPaging.getVoList();
				for (int i = 0; i < objList.length; i++) {
					valueElement = new RsPersonneed();
					valueElement= (RsPersonneed) CloneUtil.cloneObject(objList[i], valueElement, null); //转换dto对象
					RsPersonneed vo=(RsPersonneed)objList[i];
					paging.getVoList().add(valueElement);
				}
				return paging;
			}
		}
		return null;
	}
}
