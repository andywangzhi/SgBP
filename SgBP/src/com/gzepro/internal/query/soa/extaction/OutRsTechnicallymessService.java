package com.gzepro.internal.query.soa.extaction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo;
import com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo;
import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.common.util.Paging;
import com.gzepro.internal.query.common.util.StrUtils;
import com.gzepro.internal.query.soa.extaction.RsExtBaseService;

import com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo;

@Service("outRsTechnicallymessService")
public class OutRsTechnicallymessService extends RsExtBaseService {
	
	/**
	 * 
	 * @Title: saveOrUpdate
	 * @Description: TODO(保存或者修改职称信息)
	 * @param @param obj
	 * @param @throws Exception
	 * @return Integer 返回类型
	 * @throws
	 */
	public Integer saveOrUpdate(Object obj) throws Exception {
		TechnicallymessVo dto = (TechnicallymessVo) obj;
		com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo();
		parameters = (TechnicallymessVo) obj;
		int result = this.initTechnicallymessStubOut().acceptSaveTechnicallymess(parameters);
		return result;
	}
	
	/**
	 * @Title: find
	 * @Description: TODO(根据查询人员ID,查询到的人员的所有职称信息)
	 * @param @param soObject
	 * @param @throws Exception
	 * @return Object[] 返回类型
	 * @throws
	 */
	public List<TechnicallymessVo> findAll(Object soObject) throws Exception {
		// 将搜索对象转换成职称详细信息查询的搜索对象
		String personId = (String) soObject;
		TechnicallymessVo[] list = this.initTechnicallymessStubOut().acceptTechnicallymessDetailByPersonId(personId);
		List<TechnicallymessVo> listDto = new ArrayList<TechnicallymessVo>();
		if(list == null || list.length==0){
			return null;
		}
		for(TechnicallymessVo vo:list){
			listDto.add(vo);
		}
		return listDto;
	}
}
