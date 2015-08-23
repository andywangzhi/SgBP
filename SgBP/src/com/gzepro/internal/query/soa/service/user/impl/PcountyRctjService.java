package com.gzepro.internal.query.soa.service.user.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeQo;
import com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeVo;
import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.rctj.RctjDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.rctj.RetrieveRctjSO;

/**
 * 
 * 
 * 人才统计service！
 * 
 * @author 王志 E-mail:wangzhi291@163.com
 * @version 1.0 Created On: 2012-7-31
 */
@Service("rsPersonTypeService")
public class PcountyRctjService extends BaseService {

	/**
	 * 统计区县的人才信息
	 * 
	 * @param personTypeQo
	 * @return
	 * @throws Exception
	 */
	public Object findPcounty(Object obj) throws Exception {
		RetrieveRctjSO dto = (RetrieveRctjSO) obj;
		com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeQo parameters = new com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeQo();
		parameters = (RsPersonTypeQo) CloneUtil.cloneObject(dto, parameters,
				null);
		parameters.setForDate(this.dealDate(dto.getForDate()));
		parameters.setTodate(this.dealDate(dto.getTodate()));
		RsPersonTypeVo[] vos = this.initRctjStub()
				.acceptRsPersonTypeDetailByPcounty(parameters);
		if (vos != null && vos.length > 0) {
			List<RctjDetailDTO> list = new ArrayList<RctjDetailDTO>();
			for (RsPersonTypeVo vo : vos) {
				RctjDetailDTO detailDTO = new RctjDetailDTO();
				detailDTO.setArea(vo.getArea());
				detailDTO.setType(vo.getType());
				detailDTO.setCount(vo.getCount());
				list.add(detailDTO);
			}
			if (list != null && list.size() > 0) {
				return list;
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 统计专业类型的人才信息
	 * 
	 * @param personTypeQo
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public Object findSpecialtyType(Object obj) throws Exception {
		RetrieveRctjSO dto = (RetrieveRctjSO) obj;
		com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeQo parameters = new com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeQo();
		parameters = (RsPersonTypeQo) CloneUtil.cloneObject(dto, parameters,
				null);
		parameters.setForDate(this.dealDate(dto.getForDate()));
		parameters.setTodate(this.dealDate(dto.getTodate()));
		RsPersonTypeVo[] vos = this.initRctjStub()
				.acceptRsPersonTypeDetailBySpecialtyType(parameters);
		if (vos != null && vos.length > 0) {
			List<RctjDetailDTO> list = new ArrayList<RctjDetailDTO>();
			for (RsPersonTypeVo vo : vos) {
				RctjDetailDTO detailDTO = new RctjDetailDTO();
				detailDTO.setArea(vo.getArea());
				detailDTO.setType(vo.getType());
				detailDTO.setCount(vo.getCount());
				list.add(detailDTO);
			}
			if (list != null && list.size() > 0) {
				return list;
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 按职称级别统计人才信息
	 * 
	 * @param personTypeQo
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public Object findTechnicallytype(Object obj) throws Exception {
		RetrieveRctjSO dto = (RetrieveRctjSO) obj;
		com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeQo parameters = new com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeQo();
		parameters = (RsPersonTypeQo) CloneUtil.cloneObject(dto, parameters,
				null);
		parameters.setForDate(this.dealDate(dto.getForDate()));
		parameters.setTodate(this.dealDate(dto.getTodate()));
		RsPersonTypeVo[] vos = this.initRctjStub()
				.acceptRsPersonTypeDetailByTechnicallytype(parameters);
		if (vos != null && vos.length > 0) {
			List<RctjDetailDTO> list = new ArrayList<RctjDetailDTO>();
			for (RsPersonTypeVo vo : vos) {
				RctjDetailDTO detailDTO = new RctjDetailDTO();
				detailDTO.setArea(vo.getArea());
				detailDTO.setType(vo.getType());
				detailDTO.setCount(vo.getCount());
				list.add(detailDTO);
			}
			if (list != null && list.size() > 0) {
				return list;
			} else {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * 统计专业类型的人才需求信息
	 * 
	 * @param personTypeQo
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public Object findNeedSpecialtyType(Object obj) throws Exception {
		RetrieveRctjSO dto = (RetrieveRctjSO) obj;
		com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeQo parameters = new com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeQo();
		parameters = (RsPersonTypeQo) CloneUtil.cloneObject(dto, parameters,
				null);
		RsPersonTypeVo[] vos = this.initRctjStub()
				.acceptRsPersonneedDetailBySpecialtyType(parameters);
		if (vos != null && vos.length > 0) {
			List<RctjDetailDTO> list = new ArrayList<RctjDetailDTO>();
			for (RsPersonTypeVo vo : vos) {
				RctjDetailDTO detailDTO = new RctjDetailDTO();
				detailDTO.setArea(vo.getArea());
				detailDTO.setType(vo.getType());
				detailDTO.setCount(vo.getCount());
				list.add(detailDTO);
			}
			if (list != null && list.size() > 0) {
				return list;
			} else {
				return null;
			}
		}
		return null;
	}

}
