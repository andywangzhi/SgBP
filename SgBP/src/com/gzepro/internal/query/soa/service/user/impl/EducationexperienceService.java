package com.gzepro.internal.query.soa.service.user.impl;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceQo;
import com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo;
import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.EducationexperienceDetaiDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.EducationexperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.QueryEducationexperienceListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.RetrieveEducationexperienceSO;

/**
 * 
  * @ClassName: EducationexperienceService
  * @Description: TODO(教育经历服务业务调用类)
  * @author 张建薇
  * @date Jul 24, 2012 7:25:33 PM
  *
 */
@Service("educationexperienceService")
public class EducationexperienceService extends BaseService{


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
		List<EducationexperienceListDTO> dtoList = (List<EducationexperienceListDTO>) obj;
		int result = 0;
		for(EducationexperienceListDTO _dto:dtoList){
			if(null == _dto)
				continue;
			if(null == _dto.getEducationId() || _dto.getEducationId().trim().length()==0){
				//新增
				_dto.setAdddate(DateUtil.getCurDate());
				_dto.setAdduser(this.getAccount().getLoginCode());
			}else{
				//修改
				_dto.setModifydate(DateUtil.getCurDate());
				_dto.setModifyuser(this.getAccount().getLoginCode());
			}
			
			com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo parameters = new com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo();
			parameters=(EducationexperienceVo)CloneUtil.cloneObject(_dto,parameters,null);
			parameters.setFromDate(this.dealDate(_dto.getFromDate()));
			parameters.setToDate(this.dealDate(_dto.getToDate()));
			parameters.setAdddate(Integer.parseInt(_dto.getAdddate().replaceAll("-", "")));
			parameters.setModifydate(this.dealDate(_dto.getModifydate()));
			result += this.initEducationexperienceStub().acceptSaveEduExp(parameters);
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
		EducationexperienceDetaiDTO dto = (EducationexperienceDetaiDTO)obj;
		com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo parameters = new com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo();
		parameters=(EducationexperienceVo)CloneUtil.cloneObject(dto,parameters,null);
		parameters.setFromDate(this.dealDate(dto.getFromDate()));
		parameters.setToDate(this.dealDate(dto.getToDate()));
		int result = this.initEducationexperienceStub().acceptSaveEduExp(parameters);
		return result;
	}
	
	/**
	 * 
	  * @Title: delete
	  * @Description: TODO(删除教育经历信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public Integer deleteAll(Object obj)throws Exception {
		String personId = (String)obj;
		if(personId != null && !personId.equals("")){
			int result = this.initEducationexperienceStub().acceptDelEduExpbyPerId(personId);
			return result;
		}
		return null;
	}
	
	
	/**
	 * 
	  * @Title: delete
	  * @Description: TODO(删除教育经历信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public Integer delete(Object obj)throws Exception {
		String eduId = (String)obj;
		if(eduId != null && !eduId.equals("")){
			int result = this.initEducationexperienceStub().acceptDelEduExp(eduId);
			return result;
		}
		return null;
	}
	
	
	/**
	  * @Title: find
	  * @Description: TODO(根据查询参数调用WS,返回查询到的教育经历详细信息)
	  * @param @param soObject
	  * @param @throws Exception
	  * @return Object    返回类型
	  * @throws
	 */
	public Object find(Object soObject)throws Exception {
		//将搜索对象转换成教育经历详细信息查询的搜索对象
		RetrieveEducationexperienceSO retrieveSO = (RetrieveEducationexperienceSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo valueElement = null;
        valueElement = this.initEducationexperienceStub().acceptEduExpDetailbyEduId(retrieveSO.getEducationId());
		//调用WS返回结果 value
        EducationexperienceVo value = valueElement;
		if( value != null ){ 
			EducationexperienceDetaiDTO  result = new EducationexperienceDetaiDTO();//保存处理结果
			result  = (EducationexperienceDetaiDTO) CloneUtil.cloneObject(value,result,null); //转换dto对象
			String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
			result.setFromDate(DateUtil.getDateStringFormInt(value.getFromDate(),formatStr));
			result.setToDate(DateUtil.getDateStringFormInt(value.getToDate(),formatStr));
			return result;
	    }
		return null;
	}
	
	/**
	 * 
	  * @Title: view
	  * @Description: TODO(根据查询参数调用WS,返回查询到的教育经历详细信息)
	  * @param @param soObject
	  * @param @param menuId
	  * @param @param accountId
	  * @param @return
	  * @param @throws Exception
	  * @return Object    返回类型
	  * @throws
	 */
	public Object view(Object soObject, Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成教育经历详细信息查询的搜索对象
		RetrieveEducationexperienceSO retrieveSO = (RetrieveEducationexperienceSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo valueElement = null;
        valueElement = this.initEducationexperienceStub().acceptEduExpDetailbyEduId(retrieveSO.getEducationId());
		//调用WS返回结果 value
        EducationexperienceVo value = valueElement;
		if( value != null ){ 
			return this.parseDetailResult(value, menuId, accountId);
	    }
		return null;
	}
	

	/**
	 * 根据personid查询教育经验信息
	 * @param soObject
	 * @param menuId
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	public Object findAll(Object soObject, Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		String personId = (String) soObject;
		com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo[] valueElement = null;
        valueElement = this.initEducationexperienceStub().acceptEduExpDetailbyPersonId(personId);
        
		//调用WS返回结果 value
        EducationexperienceVo[] value =valueElement;
		if (value != null && value.length>0) {
			return this.parseQueryResult(value, menuId, accountId);
		}
		return null;
	}
	
	/**
	 * 根据查询参数调用WS,返回查询到的教育经历信息
	 * @param soObject 查询的参数对象
	 * @param menuId  功能模块Id
	 * @param accounted 当前的登录用户
	 * @return 结果对象
	 */
	public Object query(Object soObject, Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		QueryEducationexperienceListSO queryListSO = (QueryEducationexperienceListSO) soObject;
        com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceQo parameters = new com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceQo();
		parameters = (EducationexperienceQo) CloneUtil.cloneObject(queryListSO, parameters, null);
		com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo[] valueElement = null;
        valueElement = this.initEducationexperienceStub().acceptQueryEducationexperience(parameters);
		//调用WS返回结果 value
        EducationexperienceVo[] value =valueElement;
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
		ArrayList<EducationexperienceListDTO> result = new ArrayList<EducationexperienceListDTO>();//保存处理结果
		EducationexperienceVo[] dtoArr = (EducationexperienceVo[]) obj; //转换object对象
		for (int i = 0; i < dtoArr.length; i++) {
			EducationexperienceVo dto = dtoArr[i];
			EducationexperienceListDTO tmpDto = new EducationexperienceListDTO();
			tmpDto = (EducationexperienceListDTO) CloneUtil.cloneObject(dto, tmpDto, map); //转换dto对象
			
			String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
			if (map == null || (map != null && !map.containsKey("fromDate"))) {
				tmpDto.setFromDate(DateUtil.getDateStringFormInt(dto.getFromDate(),formatStr));
			}
			if (map == null || (map != null && !map.containsKey("toDate"))) {
				tmpDto.setToDate(DateUtil.getDateStringFormInt(dto.getToDate(),formatStr));
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
		EducationexperienceDetaiDTO  result = new EducationexperienceDetaiDTO();//保存处理结果
		EducationexperienceVo value =(EducationexperienceVo) obj; //转换object对象
		result  = (EducationexperienceDetaiDTO) CloneUtil.cloneObject(value,result,map); //转换dto对象
		
		String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
		
		if (map == null || (map != null && !map.containsKey("fromDate"))) {
			result.setFromDate(DateUtil.getDateStringFormInt(value.getFromDate(),formatStr));
		}
		if (map == null || (map != null && !map.containsKey("toDate"))) {
			result.setToDate(DateUtil.getDateStringFormInt(value.getToDate(),formatStr));
		}
		return result;
	}
	
}
