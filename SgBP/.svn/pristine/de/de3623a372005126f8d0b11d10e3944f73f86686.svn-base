package com.gzepro.internal.query.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.model.RsPerson;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.service.RsPersonSer;

@Component("rsPersonSer")
public class RsPersonSerImp extends SystemBaseService implements RsPersonSer{
@SuppressWarnings("unchecked")
public RsPerson idCardExist(String idCard) {
		String hql = "from RsPerson d where d.idcard=? ";
		List<RsPerson> rsPersons=this.baseDao.find(hql,new Object[]{new String(idCard)});
		if (rsPersons != null && rsPersons.size() > 0) {
			return rsPersons.get(0);
		}
		return null;
	}
}
