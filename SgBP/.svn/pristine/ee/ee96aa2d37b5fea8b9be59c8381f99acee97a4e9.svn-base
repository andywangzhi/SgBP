package com.gzepro.internal.query.soa.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo;
import com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo;
import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.QueryTechnicallymessListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.RetrieveTechnicallymessSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.TechnicallymessDetaiDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.TechnicallymessListDTO;

/**
 * 
 * @ClassName: TechnicallymessService
 * @Description: TODO(人员职称信息服务业务调用类)
 * @author 张建薇
 * @date Jul 24, 2012 7:25:33 PM
 * 
 */
@Service("technicallymessService")
public class TechnicallymessService extends BaseService {
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
		TechnicallymessDetaiDTO dto = (TechnicallymessDetaiDTO) obj;
		com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo parameters = new com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo();
		parameters = (TechnicallymessVo) CloneUtil.cloneObject(dto, parameters,null);
		parameters.setAssessDate(this.dealDate(dto.getAssessDate()));
		parameters.setAdddate(Integer.valueOf(dto.getAdddate()));
		if(dto.getModifydate()!=null&&dto.getModifydate().length()>0){
			parameters.setModifydate(Integer.valueOf(dto.getModifydate()));
		}
		int result = this.initTechnicallymessStub().acceptSaveTechnicallymess(
				parameters);
		return result;
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(删除职称信息)
	 * @param @param obj
	 * @param @throws Exception
	 * @return Integer 返回类型
	 * @throws
	 */
	public Integer deleteAll(Object obj) throws Exception {
		String personId = (String) obj;
		if (personId != null && !personId.equals("")) {
			int result = this.initTechnicallymessStub()
					.acceptDelTechnicallymessByPersonId(personId);
			return result;
		}
		return null;
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(删除职称信息)
	 * @param @param obj
	 * @param @throws Exception
	 * @return Integer 返回类型
	 * @throws
	 */
	public Integer delete(Object obj) throws Exception {
		String techId = (String) obj;
		if (techId != null && !techId.equals("")) {
			int result = this.initTechnicallymessStub()
					.acceptDelTechnicallymess(techId);
			return result;
		}
		return null;
	}

	/**
	 * @Title: find
	 * @Description: TODO(根据查询参数调用WS,返回查询到的职称详细信息)
	 * @param @param soObject
	 * @param @throws Exception
	 * @return Object 返回类型
	 * @throws
	 */
	public Object find(Object soObject) throws Exception {
		// 将搜索对象转换成职称详细信息查询的搜索对象
		RetrieveTechnicallymessSO retrieveSO = (RetrieveTechnicallymessSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo valueElement = null;
		valueElement = this.initTechnicallymessStub()
				.acceptTechnicallymessDetail(retrieveSO.getTechId());
		// 调用WS返回结果 value
		TechnicallymessVo value = valueElement;
		if (value != null) {
			TechnicallymessDetaiDTO result = new TechnicallymessDetaiDTO();// 保存处理结果
			result = (TechnicallymessDetaiDTO) CloneUtil.cloneObject(value,
					result, null); // 转换dto对象
			String formatStr = getResourceValue(Constants.FORMAT_DATE);// 页面显示的日期格式
			result.setAssessDate(DateUtil.getDateStringFormInt(value
					.getAssessDate(), formatStr));
			return result;
		}
		return null;
	}

	/**
	 * @Title: find
	 * @Description: TODO(根据查询人员ID,查询到的人员的所有职称信息)
	 * @param @param soObject
	 * @param @throws Exception
	 * @return Object[] 返回类型
	 * @throws
	 */
	public Object findAll(Object soObject,Long menuId, Long accountId) throws Exception {
		// 将搜索对象转换成职称详细信息查询的搜索对象
		String personId = (String) soObject;
		TechnicallymessVo[] list = this.initTechnicallymessStub().acceptTechnicallymessDetailByPersonId(personId);
		List<TechnicallymessDetaiDTO> listDto = new ArrayList<TechnicallymessDetaiDTO>();
		
		//调用WS返回结果 value
		TechnicallymessVo[] value =list;
		if (value != null && value.length>0) {
			return this.parseQueryResult(value, menuId, accountId);
		}
		return null;
	}

	/**
	 * 
	 * @Title: view
	 * @Description: TODO(根据查询参数调用WS,返回查询到的职称详细信息)
	 * @param @param soObject
	 * @param @param menuId
	 * @param @param accountId
	 * @param @return
	 * @param @throws Exception
	 * @return Object 返回类型
	 * @throws
	 */
	public Object view(Object soObject, Long menuId, Long accountId)
			throws Exception {
		// 将搜索对象转换成职称详细信息查询的搜索对象
		RetrieveTechnicallymessSO retrieveSO = (RetrieveTechnicallymessSO) soObject;
		com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo valueElement = null;
		valueElement = this.initTechnicallymessStub()
				.acceptTechnicallymessDetail(retrieveSO.getTechId());
		// 调用WS返回结果 value
		TechnicallymessVo value = valueElement;
		if (value != null) {
			return this.parseDetailResult(value, menuId, accountId);
		}
		return null;
	}

	/**
	 * 根据查询参数调用WS,返回查询到的职称信息
	 * 
	 * @param soObject
	 *            查询的参数对象
	 * @param menuId
	 *            功能模块Id
	 * @param accounted
	 *            当前的登录用户
	 * @return 结果对象
	 */
	public Object query(Object soObject, Long menuId, Long accountId)
			throws Exception {
		// 没有提供模糊查询服务
		return null;
	}

	/**
	 * 屏蔽查询结果的敏感信息
	 * 
	 * @param obj
	 *            待分析对象
	 * @param menuId
	 *            功能模块Id
	 * @param accountId
	 *            当前登录用户Id
	 * @return 分析的结果
	 * @throws Exception
	 */
	private Object parseQueryResult(Object obj, Long menuId, Long accountId)
			throws Exception {
		Map map = this.findMenuDicByAccountId(menuId, accountId);// 获取用户指定功能模块的敏感字段
		ArrayList<TechnicallymessListDTO> result = new ArrayList<TechnicallymessListDTO>();// 保存处理结果
		TechnicallymessVo[] dtoArr = (TechnicallymessVo[]) obj; // 转换object对象
		for (int i = 0; i < dtoArr.length; i++) {
			TechnicallymessVo dto = dtoArr[i];
			TechnicallymessListDTO tmpDto = new TechnicallymessListDTO();
			tmpDto = (TechnicallymessListDTO) CloneUtil.cloneObject(dto,
					tmpDto, map); // 转换dto对象

			String formatStr = getResourceValue(Constants.FORMAT_DATE);// 页面显示的日期格式
			if (map == null || (map != null && !map.containsKey("assessDate"))) {
				tmpDto.setAssessDate(DateUtil.getDateStringFormInt(dto
						.getAssessDate(), formatStr));
			}
			result.add(tmpDto);
		}
		return result;
	}

	/**
	 * 屏蔽查询结果的敏感信息
	 * 
	 * @param obj
	 *            待分析对象
	 * @param menuId
	 *            功能模块Id
	 * @param accountId
	 *            当前登录用户Id
	 * @return 分析的结果
	 * @throws Exception
	 */
	private Object parseDetailResult(Object obj, Long menuId, Long accountId)
			throws Exception {
		Map map = this.findMenuDicByAccountId(menuId, accountId);// 获取用户指定功能模块的敏感字段
		TechnicallymessDetaiDTO result = new TechnicallymessDetaiDTO();// 保存处理结果
		TechnicallymessVo value = (TechnicallymessVo) obj; // 转换object对象
		result = (TechnicallymessDetaiDTO) CloneUtil.cloneObject(value, result,
				map); // 转换dto对象

		String formatStr = getResourceValue(Constants.FORMAT_DATE);// 页面显示的日期格式
		if (map == null || (map != null && !map.containsKey("assessDate"))) {
			result.setAssessDate(DateUtil.getDateStringFormInt(value
					.getAssessDate(), formatStr));
		}
		return result;
	}

}
