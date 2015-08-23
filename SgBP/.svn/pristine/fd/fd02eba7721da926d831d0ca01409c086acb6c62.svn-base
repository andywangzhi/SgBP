package com.gzepro.internal.query.soa.extaction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo;
import com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo;
import com.gmcc.support.trade.service.provider.rcsm.base.RsPersonQo;
import com.gmcc.support.trade.service.provider.rcsm.base.RsPersonVo;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.Paging;
import com.gzepro.internal.query.common.util.StrUtils;
import com.gzepro.internal.query.soa.extaction.RsExtBaseService;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.QueryRsPersonListSO;

@Service("outRsPersonService")
public class OutRsPersonService extends RsExtBaseService {
	
	/**
	 * 
	  * @Title: saveOrUpdate
	  * @Description: TODO(保存或者修改人员信息)
	  * @param @param obj
	  * @param @throws Exception
	  * @return Integer    返回类型
	  * @throws
	 */
	public String saveOrUpdate(Object obj)throws Exception {
		RsPersonOutVo dto = (RsPersonOutVo)obj;
		com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo();
		parameters=(RsPersonOutVo)CloneUtil.cloneObject(dto,parameters,null);
		//填表时间,不能为空
		//parameters.setOperationalDate((this.dealDate(dto.getOperationalDate())));
		//经手时间
		parameters.setAdddate(Integer.valueOf(dto.getAdddate()));
		parameters.setOperationalDate(20121013);
		//修改时间
		
		String result = this.initRsPersonStubOut().acceptSaveRsPerson(parameters);
		return result;
	}
	
	/**
	 * 根据查询参数调用WS,返回查询到的人员信息
	 * @param soObject 查询的参数对象
	 * @param menuId  功能模块Id
	 * @param accounted 当前的登录用户
	 * @return 结果对象
	 */
	public Paging queryByPage(Paging paging, RsPersonOutQo soObject) throws Exception {
		//将搜索对象转换成用户查询的搜索对象
        com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo parameters = new com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo();
		parameters =  (RsPersonOutQo) CloneUtil.cloneObject(soObject, parameters, null);
		parameters.setIsvalid("1");
		com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo valueElement = null;
		com.gmcc.support.trade.service.provider.outrcsm.base.Paging paramPaging = new com.gmcc.support.trade.service.provider.outrcsm.base.Paging();
		paramPaging.setCurrentIndex(paging.getCurrentIndex());
		paramPaging.setPageSize(paging.getPageSize());
		if(soObject.getAuditdate() != 0){
			String value = "[auditdate:";
			if(soObject.getAuditdate() == 0){
				value += "0-0";
			}else{
				value += soObject.getAuditdate() + "-0]";
			}
			parameters.setDateStr(value);
		}else{
			parameters.setDateStr("");
		}
		
		paramPaging = this.initRsPersonStubOut().acceptQueryRsPersonByPage(parameters, paramPaging);
		if(paramPaging != null) {
			paging.setTotalPages(paramPaging.getTotalPages());
			paging.setTotalRecords(paramPaging.getTotalRecords());
			paging.setVoList(new ArrayList<RsPersonOutVo>());
			//调用WS返回结果 value
			if(paramPaging.getVoList() != null) {
				Object[] objList=paramPaging.getVoList();
				for (int i = 0; i < objList.length; i++) {
					valueElement = new RsPersonOutVo();
					valueElement= (RsPersonOutVo) CloneUtil.cloneObject(objList[i], valueElement, null); //转换dto对象
					RsPersonOutVo vo=(RsPersonOutVo)objList[i];
					if(vo.getAdddate()>0){
						valueElement.setAdddate(vo.getAdddate());
					}
					
					if(vo.getModifydate()>0){
						valueElement.setAdddate(vo.getModifydate());
					}
					
					if(vo.getDeledate()>0){
						valueElement.setDeledate(vo.getDeledate());
					}
					
					if(vo.getCheckdate()>0){
						valueElement.setCheckdate(vo.getCheckdate());
					}
					
					if(vo.getValidatedate()>0){
						valueElement.setValidatedate(vo.getValidatedate());
					}
					
					if(vo.getAuditdate()>0){
						valueElement.setAuditdate(vo.getAuditdate());
					}	
					paging.getVoList().add(valueElement);
				}
				return paging;
			}
		}
		return null;
	}
}
