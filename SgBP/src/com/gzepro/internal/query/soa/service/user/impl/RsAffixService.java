package com.gzepro.internal.query.soa.service.user.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixQo;
import com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixVo;
import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.affix.RsAffixDTO;

/**
 * 
  * @ClassName: RsPersonService
  * @Description: TODO(附件服务业务调用类)
  * @author 刘俊明
  *
 */
@Service("rsAffixService")
public class RsAffixService extends BaseService {

	/**
	 * 保存及变更附件信息
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public int saveOrUpdate(Object object) throws Exception {
		RsAffixDTO dto = (RsAffixDTO) object;
		com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixVo vo = new com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixVo();
		vo = (RsAffixVo) CloneUtil.cloneObject(dto, vo, null);
		vo.setDeleDate(""+this.dealDate(dto.getDeleDate()));
		vo.setModifyDate(""+this.dealDate(dto.getModifyDate()));
		vo.setCheckDate(""+this.dealDate(dto.getCheckDate()));
		vo.setValidateDate(""+this.dealDate(dto.getValidateDate()));
		vo.setAuditDate(""+this.dealDate(dto.getAuditDate()));
		vo.setUploadDate(""+this.dealDate(dto.getUploadDate()));
		vo.setPersonId(dto.getPersonId());
		this.initRsAffixStub().acceptSaveOrUpdateRsAffix(vo);
		return 0;
	}
	/**
	 * 保存及变更附件信息
	 * @param object
	 * @return	返回Vo
	 * @throws Exception
	 */
	public RsAffixVo saveOrUpdateVo(Object object) throws Exception {
		RsAffixDTO dto = (RsAffixDTO) object;
		com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixVo vo = new com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixVo();
		vo = (RsAffixVo) CloneUtil.cloneObject(dto, vo, null);
		vo.setDeleDate(""+this.dealDate(dto.getDeleDate()));
		vo.setModifyDate(""+this.dealDate(dto.getModifyDate()));
		vo.setCheckDate(""+this.dealDate(dto.getCheckDate()));
		vo.setValidateDate(""+this.dealDate(dto.getValidateDate()));
		vo.setAuditDate(""+this.dealDate(dto.getAuditDate()));
		vo.setUploadDate(""+this.dealDate(dto.getUploadDate()));
		vo.setPersonId(dto.getPersonId());
		return this.initRsAffixStub().acceptSaveOrUpdateRsAffix(vo);
	}
	
	/**
	 * 根据人员ID变更附件状态
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public int stateByPersonId(Object object) throws Exception {
		RsAffixDTO dto = (RsAffixDTO) object;
		com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixVo vo = new com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixVo();
		vo = (RsAffixVo) CloneUtil.cloneObject(dto, vo, null);
		vo.setDeleDate(""+this.dealDate(dto.getDeleDate()));
		vo.setAuditDate(""+this.dealDate(dto.getAuditDate()));
		this.initRsAffixStub().acceptStateRsAffixByPersonId(vo);
		return 0;
	}
	
	/**
	 * 根据附件ID变更附件状态
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public int stateByAffixId(Object object) throws Exception {
		RsAffixDTO dto = (RsAffixDTO) object;
		com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixVo vo = new com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixVo();
		vo = (RsAffixVo) CloneUtil.cloneObject(dto, vo, null);
		vo.setDeleDate(""+this.dealDate(dto.getDeleDate()));
		vo.setAuditDate(""+this.dealDate(dto.getAuditDate()));
		this.initRsAffixStub().acceptStateRsAffixByRsAffixId(vo);
		return 0;
	}
	
	/**
	 * 模糊查询附件信息
	 * @param object
	 * @param menuId
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	public Object query(Object object, Long menuId, Long accountId) throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		RsAffixDTO dto = (RsAffixDTO) object;
		com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixQo qo = new com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixQo();
		qo = (RsAffixQo) CloneUtil.cloneObject(dto, qo, null);
		com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixQo[] valueElement = null;
        valueElement = this.initRsAffixStub().acceptFindRsAffix(qo);
		//调用WS返回结果 value
        RsAffixQo[] value = valueElement;
		if (value != null && value.length>0) {
			return this.parseQueryResult(value, menuId, accountId);
		}
		return null;
	}
	
	/**
	 * 根据人员ID查询附件信息
	 * @param object
	 * @param menuId
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	public Object queryByPersonId(Object object, Long menuId, Long accountId) throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		String personId = (String) object;
		com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixQo[] valueElement = null;
        valueElement = this.initRsAffixStub().acceptFindRsAffixByPersonId(personId);
		//调用WS返回结果 value
        RsAffixQo[] value = valueElement;
		if (value != null && value.length>0) {
			return this.parseQueryResult(value, menuId, accountId);
		}
		return null;
	}
	
	/**
	 * 根据附件ID查询附件信息
	 * @param object
	 * @param menuId
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	public Object queryByRsAffixId(Object object, Long menuId, Long accountId) throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		String rsAffixId = (String) object;
		com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixQo[] valueElement = null;
        valueElement = this.initRsAffixStub().accepFindAffixByRsAffixId(rsAffixId);
		//调用WS返回结果 value
        RsAffixQo[] value = valueElement;
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
		//Map map = this.findMenuDicByAccountId(menuId, accountId);//获取用户指定功能模块的敏感字段
		ArrayList<RsAffixDTO> result = new ArrayList<RsAffixDTO>();//保存处理结果
		RsAffixQo[] dtoArr = (RsAffixQo[]) obj; //转换object对象
		for (int i = 0; i < dtoArr.length; i++) {
			RsAffixQo dto = dtoArr[i];
			RsAffixDTO tmpDto = new RsAffixDTO();
			tmpDto = (RsAffixDTO) CloneUtil.cloneObject(dto, tmpDto, null); //转换dto对象
			
			result.add(tmpDto);
		}
		return result;
	}
	
	 public byte[] inputStreamToByte(InputStream is) throws IOException { 
		ByteArrayOutputStream bAOutputStream = new ByteArrayOutputStream();
		int ch;
		while ((ch = is.read()) != -1) {
			bAOutputStream.write(ch);
		}
		byte[] data = bAOutputStream.toByteArray();
		bAOutputStream.close();
		return data;
	}
}
