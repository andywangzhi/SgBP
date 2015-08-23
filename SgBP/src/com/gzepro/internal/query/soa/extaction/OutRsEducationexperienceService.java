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
import com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo;

@Service("outRsEducationexperienceService")
public class OutRsEducationexperienceService extends RsExtBaseService {
	
	/**
	 * 
	  * @Title: saveOrUpdate
	  * @Description: TODO(保存或者修改教育经历信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public Integer saveOrUpdateBatch(Object obj)throws Exception {
		List<EducationexperienceVo> dtoList = (List<EducationexperienceVo>) obj;
		int result = 0;
		for(EducationexperienceVo _dto:dtoList){
			if(null == _dto)
				continue;
			if(null == _dto.getEducationId() || _dto.getEducationId().trim().length()==0){
				//新增
				_dto.setModifyuser(this.getAccount().getLoginCode());
				_dto.setAdduser(this.getAccount().getLoginCode());
			}else{
				//修改
				_dto.setModifyuser(this.getAccount().getLoginCode());
				_dto.setAdduser(this.getAccount().getLoginCode());
			}
			
			com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo();
			parameters=(EducationexperienceVo)CloneUtil.cloneObject(_dto,parameters,null);
			result += this.initEducationexperienceStubOut().acceptSaveEduExp(parameters);
		}
		return result;
	}
	

	/**
	 * 
	  * @Title: saveOrUpdate
	  * @Description: TODO(保存或者修改教育经历信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public Integer saveOrUpdate(Object obj)throws Exception {
		EducationexperienceVo dto = (EducationexperienceVo)obj;
		com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo();
		parameters=(EducationexperienceVo)dto;
		int result = this.initEducationexperienceStubOut().acceptSaveEduExp(parameters);
		return result;
	}
	
	/**
	 * 根据personid查询教育经验信息
	 * @param soObject
	 * @param menuId
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	public List<EducationexperienceVo> findAll(Object soObject)throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		String personId = (String) soObject;
		com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo[] valueElement = null;
        valueElement = this.initEducationexperienceStubOut().acceptEduExpDetailbyPersonId(personId);
        
		//调用WS返回结果 value
        EducationexperienceVo[] value =valueElement;
        if(value == null || value.length == 0){
        	return null;
        }
        ArrayList<EducationexperienceVo> result = new ArrayList<EducationexperienceVo>();//保存处理结果        
        for(EducationexperienceVo _vo : value){
        	result.add(_vo);
        }
		return result;
	}
}
