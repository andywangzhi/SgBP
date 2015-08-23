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
import com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo;
import com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixQo;

@Service("outRsRsAffixService")
public class OutRsAffixService extends RsExtBaseService {
	
	/**
	 * 保存及变更附件信息
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public int saveOrUpdate(Object object) throws Exception {
		RsAffixVo dto = (RsAffixVo) object;
		com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo vo = new com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo();
		vo = (RsAffixVo) dto;
		this.initRsAffixStubOut().acceptSaveOrUpdateRsAffix(vo);
		return 0;
	}
	/**
	 * 根据人员ID查询附件信息
	 * @param object
	 * @param menuId
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	public List<RsAffixQo> queryByPersonId(Object object) throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		String personId = (String) object;
		com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixQo[] valueElement = null;
        valueElement = this.initRsAffixStubOut().acceptFindRsAffixByPersonId(personId);
		//调用WS返回结果 value
        RsAffixQo[] value = valueElement;
        if(value == null || value.length == 0){
        	return null;
        }
        ArrayList<RsAffixQo> result = new ArrayList<RsAffixQo>();//保存处理结果
		for (int i = 0;i<value.length;i++) {
			result.add(value[i]);
		}
		return result;
	}
}
