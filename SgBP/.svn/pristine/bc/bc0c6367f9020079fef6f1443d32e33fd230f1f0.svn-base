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
import com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo;

@Service("outRsWorkexperienceService")
public class OutRsWorkexperienceService extends RsExtBaseService {
	
	/**
	 * @Title: saveOrUpdate
	 * @Description: TODO(保存或者修改工作简历)
	 * @param obj
	 * @throws Exception
	 * @return Integer 返回类型
	 * @throws
	 */
	public Integer saveOrUpdate(Object obj) throws Exception {
		WorkexperienceVo dto = (WorkexperienceVo) obj;
		com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo();
		parameters = (WorkexperienceVo) dto;
		int result = this.initWorkexperienceStubOut().acceptSaveWorkexperience(parameters);
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
	public List<WorkexperienceVo> findAll(Object soObject) throws Exception {
		// 将搜索对象转换成职称详细信息查询的搜索对象
		String personId = (String) soObject;
		com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo[] valueElement = null;
		valueElement= this.initWorkexperienceStubOut().acceptWorkexperienceDetail(personId);
		//调用WS返回结果 value
		if(valueElement == null || valueElement.length==0){
			return null;
		}
		List<WorkexperienceVo> listDto = new ArrayList<WorkexperienceVo>();
		for(WorkexperienceVo vo:valueElement){
			listDto.add(vo);
		}
		return listDto;
	}
}
