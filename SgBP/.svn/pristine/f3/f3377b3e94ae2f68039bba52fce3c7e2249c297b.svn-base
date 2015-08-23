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
import com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo;

@Service("outRsTechnologicalHarvestService")
public class OutRsTechnologicalHarvestService extends RsExtBaseService {
	
	/**
	 * 
	  * @Title: saveOrUpdate
	  * @Description: TODO(保存或者修改科技成果信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public Integer saveOrUpdate(Object obj)throws Exception {
		TechnologicalHarvestVo dto = (TechnologicalHarvestVo)obj;
		com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo();
		parameters=(TechnologicalHarvestVo)dto;
		int result = this.initTechnologicalHarvestStubOut().acceptSaveTechnologicalHarvest(parameters);
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
	public List<TechnologicalHarvestVo> findAll(Object soObject) throws Exception {
		// 将搜索对象转换成职称详细信息查询的搜索对象
		String personId = (String) soObject;
		com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo[] valueElement = null;
        valueElement = this.initTechnologicalHarvestStubOut().acceptTechnologicalHarvestByPerId(personId);		
		if(valueElement == null || valueElement.length==0){
			return null;
		}
		List<TechnologicalHarvestVo> listDto = new ArrayList<TechnologicalHarvestVo>();
		for(TechnologicalHarvestVo vo:valueElement){
			listDto.add(vo);
		}
		return listDto;
	}
}
