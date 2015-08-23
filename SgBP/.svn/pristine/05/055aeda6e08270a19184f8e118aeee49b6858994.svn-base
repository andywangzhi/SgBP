package com.gzepro.internal.query.soa.service.user.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestQo;
import com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo;
import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.common.util.StrUtils;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.QueryWorkexperienceListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.QueryTechnologicalHarvestListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.TechnologicalHarvestDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.TechnologicalHarvestListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.RetrieveTechnologicalHarvestSO;

/**
 * 
  * @ClassName: RsPersonService
  * @Description: TODO(人员科技成果服务业务调用类)
  * @author 张建薇
  * @date Jul 24, 2012 7:25:33 PM
  *
 */
@Service("technologicalHarvestService")
public class TechnologicalHarvestService extends BaseService{
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
		TechnologicalHarvestListDTO dto = (TechnologicalHarvestListDTO)obj;
		com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo parameters = new com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo();
		parameters=(TechnologicalHarvestVo)CloneUtil.cloneObject(dto,parameters,null);

		parameters.setAssessDate((this.dealDate(dto.getAssessDate())));
		if(StrUtils.strIsNull(dto.getAdddate())) {
			parameters.setAdddate(this.dealDate(dto.getAdddate()));
		}
		if(StrUtils.strIsNull(dto.getModifydate())) {
			parameters.setModifydate(this.dealDate(dto.getModifydate()));
		}
		
		int result = this.initTechnologicalHarvestStub().acceptSaveTechnologicalHarvest(parameters);
		return result;
	}
	
	/**
	 * 
	  * @Title: delete
	  * @Description: TODO(删除科技成果信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public Integer deleteAll(Object obj)throws Exception {
		String personID = (String)obj;
		if(personID != null && !personID.equals("")){
			int result = this.initTechnologicalHarvestStub().acceptDelTechnologicalHarvestByPerId(personID);
			return result;
		}
		return null;
	}
	
	/**
	 * 
	  * @Title: delete
	  * @Description: TODO(删除科技成果信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public Integer delete(Object obj)throws Exception {
		String harvestId = (String)obj;
		if(harvestId != null && !harvestId.equals("")){
			int result = this.initTechnologicalHarvestStub().acceptDelTechnologicalHarvest(harvestId);
			return result;
		}
		return null;
	}
	
	
	/**
	 * 
	  * @Title: find
	  * @Description: TODO(根据查询参数调用WS,返回查询到的科技成果详细信息)
	  * @param @param soObject
	  * @param @throws Exception
	  * @return Object    返回类型
	  * @throws
	 */
	public Object find(Object soObject)throws Exception {
		//将搜索对象转换成科技成果详细信息查询的搜索对象
		RetrieveTechnologicalHarvestSO retrieveSO = (RetrieveTechnologicalHarvestSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo valueElement = null;
        valueElement = this.initTechnologicalHarvestStub().acceptTechnologicalHarvestDetail(retrieveSO.getHarvestId());
		//调用WS返回结果 value
        TechnologicalHarvestVo value = valueElement;
		if( value != null ){ 
			TechnologicalHarvestDetailDTO  result = new TechnologicalHarvestDetailDTO();//保存处理结果
			result  = (TechnologicalHarvestDetailDTO) CloneUtil.cloneObject(value,result,null); //转换dto对象
			String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
			result.setAssessDate(DateUtil.getDateStringFormInt(value.getAssessDate(),formatStr));
			if(StrUtils.strIsNull(""+value.getAdddate()) && !(""+value.getAdddate()).trim().equals("0")) {
				result.setAdddate(DateUtil.getDateStringFormInt(value.getAssessDate(),formatStr));
			}
			return result;
	    }
		return null;
	}
	
	/**
	 * 
	  * @Title: view
	  * @Description: TODO(根据查询参数调用WS,返回查询到的科技成果详细信息)
	  * @param @param soObject
	  * @param @param menuId
	  * @param @param accountId
	  * @param @throws Exception
	  * @return Object    返回类型
	  * @throws
	 */
	public Object view(Object soObject, Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成科技成果详细信息查询的搜索对象
		RetrieveTechnologicalHarvestSO retrieveSO = (RetrieveTechnologicalHarvestSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo valueElement = null;
        valueElement = this.initTechnologicalHarvestStub().acceptTechnologicalHarvestDetail(retrieveSO.getHarvestId());
		//调用WS返回结果 value
        TechnologicalHarvestVo value = valueElement;
		if( value != null ){ 
			return this.parseDetailResult(value, menuId, accountId);
	    }
		return null;
	}
	
	/**
	 * 根据查询参数调用WS,返回查询到的科技成果信息
	 * @param soObject 查询的参数对象
	 * @param menuId  功能模块Id
	 * @param accounted 当前的登录用户
	 * @return 结果对象
	 */
	public Object query(Object soObject, Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		QueryTechnologicalHarvestListSO queryListSO = (QueryTechnologicalHarvestListSO) soObject;
        com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestQo parameters = new com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestQo();
		parameters = (TechnologicalHarvestQo) CloneUtil.cloneObject(queryListSO, parameters, null);
		com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo[] valueElement = null;
        valueElement = this.initTechnologicalHarvestStub().acceptQueryHarvest(parameters);
		//调用WS返回结果 value
        TechnologicalHarvestVo[] value =valueElement;
		if (value != null && value.length>0) {
			return this.parseQueryResult(value, menuId, accountId);
		}
		return null;
	}
	
	/**
	 * 根据查询参数调用WS,返回查询到的科技成果信息
	 * @param soObject 查询的参数对象
	 * @param menuId  功能模块Id
	 * @param accounted 当前的登录用户
	 * @return 结果对象
	 */
	public Object findAll(Object soObject, Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		String personId = (String) soObject;
		com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo[] valueElement = null;
        valueElement = this.initTechnologicalHarvestStub().acceptTechnologicalHarvestByPerId(personId);
		//调用WS返回结果 value
        TechnologicalHarvestVo[] value =valueElement;
		if (value != null && value.length>0) {
			return this.parseQueryResult(value, menuId, accountId);
		}
		return null;
	}


	/**
	 * 屏蔽查询结果的敏感信息
	 * @param obj 待分析对象
	 * @param menuId 功能模块Id
	 * @param accountId 当前登录用户Id
	 * @return 分析的结果
	 * @throws Exception 
	 */
	private Object parseQueryResult(Object obj, Long menuId, Long accountId)throws Exception {
		Map map = this.findMenuDicByAccountId(menuId, accountId);//获取用户指定功能模块的敏感字段
		ArrayList<TechnologicalHarvestListDTO> result = new ArrayList<TechnologicalHarvestListDTO>();//保存处理结果
		TechnologicalHarvestVo[] dtoArr = (TechnologicalHarvestVo[]) obj; //转换object对象
		for (int i = 0; i < dtoArr.length; i++) {
			TechnologicalHarvestVo dto = dtoArr[i];
			TechnologicalHarvestListDTO tmpDto = new TechnologicalHarvestListDTO();
			tmpDto = (TechnologicalHarvestListDTO) CloneUtil.cloneObject(dto, tmpDto, null);//map); //转换dto对象
			
			String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
			if (map == null || (map != null && !map.containsKey("assessDate"))) {
				tmpDto.setAssessDate(DateUtil.getDateStringFormInt(dto.getAssessDate(),formatStr));
			}
			if(StrUtils.strIsNull(""+dto.getAdddate()) && !(""+dto.getAdddate()).trim().equals("0")) {
				tmpDto.setAdddate(DateUtil.getDateStringFormInt(dto.getAssessDate(),formatStr));
			}
			
			result.add(tmpDto);
		}
		return result;
	}
	
	/**
     * 屏蔽查询结果的敏感信息
	 * @param obj 待分析对象
	 * @param menuId 功能模块Id
	 * @param accountId 当前登录用户Id
	 * @return 分析的结果
	 * @throws Exception 
	 */
	private Object parseDetailResult(Object obj, Long menuId, Long accountId) throws Exception {
		Map map = this.findMenuDicByAccountId(menuId, accountId);//获取用户指定功能模块的敏感字段
		TechnologicalHarvestDetailDTO  result = new TechnologicalHarvestDetailDTO();//保存处理结果
		TechnologicalHarvestVo value =(TechnologicalHarvestVo) obj; //转换object对象
		result  = (TechnologicalHarvestDetailDTO) CloneUtil.cloneObject(value,result,map); //转换dto对象
		
		String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
		if (map == null || (map != null && !map.containsKey("birthDate"))) 
			result.setAssessDate(DateUtil.getDateStringFormInt(value.getAssessDate(),formatStr));
		
		return result;
	}
	
}
