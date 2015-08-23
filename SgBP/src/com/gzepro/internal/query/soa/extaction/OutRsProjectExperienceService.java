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
import com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo;
import com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceQo;

@Service("outRsProjectExperienceService")
public class OutRsProjectExperienceService extends RsExtBaseService {
	
	/**
	 * 
	  * @Title: saveOrUpdate
	  * @Description: TODO(保存或者修改项目经验信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public Integer saveOrUpdate(Object obj)throws Exception {
		ProjectExperienceVo dto = (ProjectExperienceVo)obj;
		com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo();
		parameters=(ProjectExperienceVo)CloneUtil.cloneObject(dto,parameters,null);
		parameters.setPersonnum(new Long(dto.getPersonnum()));
		parameters.setProjmoney(Double.valueOf(dto.getProjmoney()));
		parameters.setAdddate(Integer.valueOf(dto.getAdddate()));
		int result = this.initProjectExperienceStubOut().acceptSavePJExperience(parameters);
		return result;
	}
	
	
	/**
	  * @Title: find
	  * @Description: TODO(根据查询参数调用WS,返回查询到的项目经验详细信息)
	  * @param @param soObject
	  * @param @throws Exception
	  * @return Object    返回类型
	  * @throws
	 */
	public List<ProjectExperienceVo> findAll(Object soObject)throws Exception {
		//将搜索对象转换成项目经验详细信息查询的搜索对象
		String personId = (String) soObject;
		com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo[] valueElement = null;
        valueElement = this.initProjectExperienceStubOut().acceptPJEByPIdDetail(personId);
		//调用WS返回结果 value
        if(valueElement == null || valueElement.length == 0){
        	return null;
        }
        ArrayList<ProjectExperienceVo> result = new ArrayList<ProjectExperienceVo>();
		for (int i = 0; i<valueElement.length; i++){
			result.add(valueElement[i]);
		}		
		return result;
	}
}
