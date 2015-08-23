package com.gzepro.internal.query.soa.service.user.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceQo;
import com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo;
import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.common.util.StrUtils;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.QueryEducationexperienceListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.ProjectExperienceDetaiDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.ProjectExperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.RetrieveProjectExperienceSO;

/**
 * 
  * @ClassName: ProjectExperienceService
  * @Description: TODO(人员项目经验服务业务调用类)
  * @author 张建薇
  * @date Jul 24, 2012 7:25:33 PM
  *
 */
@Service("projectExperienceService")
public class ProjectExperienceService extends BaseService{

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
		ProjectExperienceDetaiDTO dto = (ProjectExperienceDetaiDTO)obj;
		com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo parameters = new com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo();
		parameters=(ProjectExperienceVo)CloneUtil.cloneObject(dto,parameters,null);
		parameters.setFromDate(this.dealDate(dto.getFromDate()));
		parameters.setToDate(this.dealDate(dto.getToDate()));
		parameters.setPersonnum(new Long(dto.getPersonnum()));
		parameters.setProjmoney(Double.valueOf(dto.getProjmoney()));
		parameters.setAdddate(Integer.valueOf(dto.getAdddate()));
		if(dto.getModifydate()!=null&&dto.getModifydate().length()>0){
			parameters.setModifydate(Integer.valueOf(dto.getModifydate()));
		}
		int result = this.initProjectExperienceStub().acceptSavePJExperience(parameters);
		return result;
	}
	
	/**
	 * 
	  * @Title: delete
	  * @Description: TODO(删除项目经验信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public Integer deleteAll(Object obj)throws Exception {
		String personId = (String)obj;
		if(personId != null && !personId.equals("")){
			int result = this.initProjectExperienceStub().acceptDelPJExperienceByPId(personId);
			return result;
		}
		return null;
	}
	
	
	/**
	 * 
	  * @Title: delete
	  * @Description: TODO(删除项目经验信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public Integer delete(Object obj)throws Exception {
		String experienceId = (String)obj;
		if(experienceId != null && !experienceId.equals("")){
			int result = this.initProjectExperienceStub().acceptDelProjectExperience(experienceId);
			return result;
		}
		return null;
	}
	
	
	/**
	  * @Title: find
	  * @Description: TODO(根据查询参数调用WS,返回查询到的项目经验详细信息)
	  * @param @param soObject
	  * @param @throws Exception
	  * @return Object    返回类型
	  * @throws
	 */
	public Object find(Object soObject)throws Exception {
		//将搜索对象转换成项目经验详细信息查询的搜索对象
		RetrieveProjectExperienceSO retrieveSO = (RetrieveProjectExperienceSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo valueElement = null;
        valueElement = this.initProjectExperienceStub().acceptPJExperienceDetail(retrieveSO.getExperienceid());
		//调用WS返回结果 value
        ProjectExperienceVo value = valueElement;
		if( value != null ){ 
			ProjectExperienceDetaiDTO  result = new ProjectExperienceDetaiDTO();//保存处理结果
			result  = (ProjectExperienceDetaiDTO) CloneUtil.cloneObject(value,result,null); //转换dto对象
			String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
			result.setFromDate(DateUtil.getDateStringFormInt(value.getFromDate(),formatStr));
			result.setToDate(DateUtil.getDateStringFormInt(value.getToDate(),formatStr));
			return result;
	    }
		return null;
	}
	
	/**
	  * @Title: find
	  * @Description: TODO(根据查询参数调用WS,返回查询到的项目经验详细信息)
	  * @param @param soObject
	  * @param @throws Exception
	  * @return Object    返回类型
	  * @throws
	 */
	public Object findAll(Object soObject,Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成项目经验详细信息查询的搜索对象
		String personId = (String) soObject;
		com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo[] valueElement = null;
       valueElement = this.initProjectExperienceStub().acceptPJEByPIdDetail(personId);
		//调用WS返回结果 value
		ProjectExperienceVo[] value =valueElement;
		if (value != null && value.length>0) {
			return this.parseQueryResult(value, menuId, accountId);
		}
		
		return null;
	}
	/**
	 * 
	  * @Title: view
	  * @Description: TODO(根据查询参数调用WS,返回查询到的项目经验详细信息)
	  * @param @param soObject
	  * @param @param menuId
	  * @param @param accountId
	  * @param @return
	  * @param @throws Exception
	  * @return Object    返回类型
	  * @throws
	 */
	public Object view(Object soObject, Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成项目经验详细信息查询的搜索对象
		RetrieveProjectExperienceSO retrieveSO = (RetrieveProjectExperienceSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo valueElement = null;
        valueElement = this.initProjectExperienceStub().acceptPJExperienceDetail(retrieveSO.getExperienceid());
		//调用WS返回结果 value
        ProjectExperienceVo value = valueElement;
		if( value != null ){ 
			return this.parseDetailResult(value, menuId, accountId);
	    }
		return null;
	}
	
	/**
	 * 根据查询参数调用WS,返回查询到的项目经验信息
	 * @param soObject 查询的参数对象
	 * @param menuId  功能模块Id
	 * @param accounted 当前的登录用户
	 * @return 结果对象
	 */
	public Object query(Object soObject, Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		QueryEducationexperienceListSO queryListSO = (QueryEducationexperienceListSO) soObject;
        com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceQo parameters = new com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceQo();
		parameters = (ProjectExperienceQo) CloneUtil.cloneObject(queryListSO, parameters, null);
		com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo[] valueElement = null;
        valueElement = this.initProjectExperienceStub().acceptLikeQueryPJExperience(parameters);
		//调用WS返回结果 value
        ProjectExperienceVo[] value =valueElement;
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
		ArrayList<ProjectExperienceListDTO> result = new ArrayList<ProjectExperienceListDTO>();//保存处理结果
		ProjectExperienceVo[] dtoArr = (ProjectExperienceVo[]) obj; //转换object对象
		for (int i = 0; i < dtoArr.length; i++) {
			ProjectExperienceVo dto = dtoArr[i];
			ProjectExperienceListDTO tmpDto = new ProjectExperienceListDTO();
			tmpDto = (ProjectExperienceListDTO) CloneUtil.cloneObject(dto, tmpDto, map); //转换dto对象
			if(dto.getProjmoney() != null) {
				tmpDto.setProjmoney(dto.getProjmoney().toString());
			}
			String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
			if (map == null || (map != null && !map.containsKey("fromDate"))) {
				if(StrUtils.strIsNull(dto.getFromDate() + "") && dto.getFromDate() > 0) {
					tmpDto.setFromDate(DateUtil.getDateStringFormInt(dto.getFromDate(),formatStr));
				}
			}
			if (map == null || (map != null && !map.containsKey("toDate"))) {
				if(StrUtils.strIsNull(dto.getToDate() + "") && dto.getToDate() > 0) {
					tmpDto.setToDate(DateUtil.getDateStringFormInt(dto.getToDate(),formatStr));
				}
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
		ProjectExperienceDetaiDTO  result = new ProjectExperienceDetaiDTO();//保存处理结果
		ProjectExperienceVo value =(ProjectExperienceVo) obj; //转换object对象
		result  = (ProjectExperienceDetaiDTO) CloneUtil.cloneObject(value,result,map); //转换dto对象
		
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
