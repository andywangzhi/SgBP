package com.gzepro.internal.query.soa.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceQo;
import com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo;
import com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo;
import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.QueryWorkexperienceListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.RetrieveWorkexperienceSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceListDTO;

/**
 * 
 * @ClassName: WorkexperienceService
 * @Description: TODO(业务系统工作简历服务)
 * @author 张建薇
 * @date Jul 27, 2012 12:39:45 PM
 */
@Service("workexperienceService")
public class WorkexperienceService extends BaseService {

	/**
	 * @Title: saveOrUpdate
	 * @Description: TODO(保存或者修改工作简历)
	 * @param obj
	 * @throws Exception
	 * @return Integer 返回类型
	 * @throws
	 */
	public Integer saveOrUpdate(Object obj) throws Exception {
		WorkexperienceListDTO dto = (WorkexperienceListDTO) obj;
		com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo parameters = new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo();
		parameters = (WorkexperienceVo) CloneUtil.cloneObject(dto, parameters, null);
		parameters.setFromDate(this.dealDate(dto.getFromDate()));
		parameters.setToDate(this.dealDate(dto.getToDate()));
		parameters.setAdddate(Integer.valueOf(dto.getAdddate()));
		if(dto.getModifydate()!=null&&!"0".equals(dto.getModifydate())&&!"".equals(dto.getModifydate())){
			parameters.setModifydate(Integer.valueOf(dto.getModifydate()));
		}
		int result = this.initWorkexperienceStub().acceptSaveWorkexperience(parameters);
		return result;
	}

	/**
	 * @Title: delete
	 * @Description: TODO(删除人员所有工作简历)
	 * @param obj
	 * @throws Exception
	 * @return Integer 返回类型
	 * @throws
	 */
	public Integer deleteALL(Object obj) throws Exception {
		String personId = (String) obj;
		if (personId != null && !personId.equals("")) {
			int result = this.initWorkexperienceStub().acceptDelWorkexperience(personId);
			return result;
		}
		return null;
	}

	/**
	 * @Title: delete
	 * @Description: TODO(删除人员单条工作简历)
	 * @param obj
	 * @throws Exception
	 * @return Integer 返回类型
	 * @throws
	 */
	public Integer delete(Object obj) throws Exception {
		String workId = (String) obj;
		if (workId != null && !workId.equals("")) {
			int result = this.initWorkexperienceStub().acceptDelWorkexperienceByworkID(workId);
			return result;
		}
		return null;
	}
	
	/**
	 * @Title: find
	 * @Description: TODO(根据查询参数调用WS,返回查询到的工作简历详细信息)
	 * @param soObject
	 * @throws Exception
	 * @return Object 返回类型
	 * @throws
	 */
	public Object find(Object soObject) throws Exception {
		// 将搜索对象转换成工作简历详细信息查询的搜索对象
		RetrieveWorkexperienceSO retrieveSO = (RetrieveWorkexperienceSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo valueElement = null;
		valueElement = this.initWorkexperienceStub().acceptWorkexperienceDetailbyworkId(retrieveSO.getWorkId());
		// 调用WS返回结果 value
		WorkexperienceVo value = valueElement;
		if (value != null) {
			WorkexperienceDetailDTO result = new WorkexperienceDetailDTO();// 保存处理结果
			result = (WorkexperienceDetailDTO) CloneUtil.cloneObject(value, result,null); // 转换dto对象
			String formatStr = getResourceValue(Constants.FORMAT_DATE);// 页面显示的日期格式
			result.setFromDate(DateUtil.getDateStringFormInt(value.getFromDate(), formatStr));
			result.setToDate(DateUtil.getDateStringFormInt(value.getToDate(), formatStr));
			return result;
		}
		return null;
	}

	
	
	/**
	 * @Title: delete
	 * @Description: TODO(根据personID查询所有工作简历)
	 * @param obj
	 * @throws Exception
	 * @return Integer 返回类型
	 * @throws
	 */
	public Object findAll(Object soObject, Long menuId, Long accountId) throws Exception {
		String personId = (String) soObject;
		com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo[] valueElement = null;
		valueElement= this.initWorkexperienceStub().acceptWorkexperienceDetail(personId);
		//调用WS返回结果 value
		WorkexperienceVo[] value =valueElement;
		if (value != null && value.length>0) {
			return this.parseQueryResult(value, menuId, accountId);
		}
		return null;
	}
	
	
	/**
	 * @Title: view
	 * @Description: TODO(根据查询参数调用WS,返回查询到的工作简历详细信息)
	 * @param soObject
	 * @param menuId
	 * @param accountId
	 * @throws Exception
	 * @return Object 返回类型
	 * @throws
	 */
	public Object view(Object soObject, Long menuId, Long accountId)
			throws Exception {
		// 将搜索对象转换成工作简历详细信息查询的搜索对象
		RetrieveWorkexperienceSO retrieveSO = (RetrieveWorkexperienceSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo valueElement = null;
		valueElement = this.initWorkexperienceStub().acceptWorkexperienceDetailbyworkId(retrieveSO.getWorkId());
		// 调用WS返回结果 value
		WorkexperienceVo value = valueElement;
		if (value != null) {
			return this.parseDetailResult(value, menuId, accountId);
		}
		return null;
	}

	/**
	 * 根据查询参数调用WS,返回查询到的工作简历信息
	 * @param soObject查询的参数对象
	 * @param menuId功能模块Id
	 * @param accounted当前的登录用户
	 * @return 结果对象
	 */
	public Object query(Object soObject, Long menuId, Long accountId)
			throws Exception {
		// 将搜索对象转换成工作简历查询的搜索对象
		QueryWorkexperienceListSO queryListSO = (QueryWorkexperienceListSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceQo parameters = new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceQo();
		parameters = (WorkexperienceQo) CloneUtil.cloneObject(queryListSO, parameters, null);
		com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo[] valueElement = null;
		valueElement = this.initWorkexperienceStub().acceptQueryWorkexperience(parameters);
		// 调用WS返回结果 value
		WorkexperienceVo[] value = valueElement;
		if (value != null && value.length > 0) {
			return this.parseQueryResult(value, menuId, accountId);
		}
		return null;
	}

	/**
	 * 屏蔽查询结果的敏感信息
	 * @param obj待分析对象
	 * @param menuId功能模块Id
	 * @param accountId当前登录用户Id
	 * @return 分析的结果
	 * @throws Exception
	 */
	private Object parseQueryResult(Object obj, Long menuId, Long accountId)
			throws Exception {
		Map map = this.findMenuDicByAccountId(menuId, accountId);// 获取用户指定功能模块的敏感字段
		ArrayList<WorkexperienceDetailDTO> result = new ArrayList<WorkexperienceDetailDTO>();// 保存处理结果
		WorkexperienceVo[] dtoArr = (WorkexperienceVo[]) obj; // 转换object对象
		for (int i = 0; i < dtoArr.length; i++) {
			WorkexperienceVo dto = dtoArr[i];
			WorkexperienceDetailDTO tmpDto = new WorkexperienceDetailDTO();
			tmpDto = (WorkexperienceDetailDTO) CloneUtil.cloneObject(dto, tmpDto, map); // 转换dto对象
			String formatStr = getResourceValue(Constants.FORMAT_DATE);// 页面显示的日期格式
			if (map == null || (map != null && !map.containsKey("fromDate"))) {
				tmpDto.setFromDate(DateUtil.getDateStringFormInt(dto.getFromDate(), formatStr));
			}
			if (map == null || (map != null && !map.containsKey("toDate"))) {
				tmpDto.setToDate(DateUtil.getDateStringFormInt(dto.getToDate(), formatStr));
			}
			result.add(tmpDto);
		}
		return result;
	}

	/**
	 * 屏蔽查询结果的敏感信息
	 * @param obj待分析对象
	 * @param menuId功能模块Id
	 * @param accountId当前登录用户Id
	 * @return 分析的结果
	 * @throws Exception
	 */
	private Object parseDetailResult(Object obj, Long menuId, Long accountId)
			throws Exception {
		Map map = this.findMenuDicByAccountId(menuId, accountId);// 获取用户指定功能模块的敏感字段
		WorkexperienceDetailDTO result = new WorkexperienceDetailDTO();// 保存处理结果
		WorkexperienceVo value = (WorkexperienceVo) obj; // 转换object对象
		result = (WorkexperienceDetailDTO) CloneUtil.cloneObject(value, result, map); // 转换dto对象
		String formatStr = getResourceValue(Constants.FORMAT_DATE);// 页面显示的日期格式
		if (map == null || (map != null && !map.containsKey("fromDate"))) {
			result.setFromDate(DateUtil.getDateStringFormInt(value.getFromDate(), formatStr));
		}
		if (map == null || (map != null && !map.containsKey("toDate"))) {
			result.setToDate(DateUtil.getDateStringFormInt(value.getToDate(), formatStr));
		}
		return result;
	}
}
