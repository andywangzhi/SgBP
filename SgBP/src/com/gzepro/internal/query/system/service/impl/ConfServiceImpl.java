package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.Conf;
import com.gzepro.internal.query.system.model.ConfType;
import com.gzepro.internal.query.system.service.ConfService;
import com.gzepro.internal.query.system.vo.TreeVo;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("confService")
public class ConfServiceImpl extends SystemBaseService implements
		ConfService {

	/**
	 * 增加一条数据
	 * @param conf
	 */
	public  Conf add(Conf conf){
		if(conf.getParentId() != null && conf.getParentId() == 0){
			conf.setParentId(null);
		}
		return (Conf)baseDao.create(conf);
	}
	
	/**
	 * 修改一条数据
	 * @param conf
	 */
	public  Conf edit(Conf conf){
		if(conf.getParentId() != null && conf.getParentId() == 0){
			conf.setParentId(null);
		}
		return (Conf)baseDao.update(conf);
	}
	
	/**
	 * 是否存在唯一的Code
	 */
	public Conf codeExist(String code){
		String hql = "from Conf d where d.code = ? ";
		List<Conf> conf = baseDao.find(hql, new String[] { code });
		if (conf != null && conf.size() > 0) {
			return conf.get(0);
		}
		return null;
	}
	
	/**
	 * 修改数据的状态
	 * @param ids
	 * @param status
	 */
	public  boolean saveStatus(String ids,String status){
		if (ids != null && !ids.equals("")) {
			if(ids.endsWith(":"))ids = ids.substring(0,ids.length()-1);
			String[] arr = ids.split(":");
			for (String id : arr) {
				Conf conf = (Conf) baseDao.get(Conf.class, new Long(id));
				conf.setValid(status);
				baseDao.saveOrUpdate(conf);
			}
		}
		return true;
	}
	
	/**
	 * 通过ID删除一条记录
	 * @param id
	 * @return
	 */
	public boolean deleteById(Long id){
		if (id == null) {
			return false;
		}else{
			Conf conf = findById(id);
			baseDao.delete(conf);
			return true;
		}
	}
	
	/**
	 * 删除多条数据
	 * @param account
	 */
	public  boolean delete(String ids){
		if (ids != null && !ids.equals("")) {
			if(ids.endsWith(":"))ids = ids.substring(0,ids.length()-1);
			String[] arr = ids.split(":");
			for (String id : arr) {
				deleteById(new Long(id));
			}
		}
		return true;
	}
	
	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public Conf findById(Long id){
		Conf conf = (Conf) baseDao.get(Conf.class, id);
		if(conf.getParentId() ==null){
			conf.setParentName("根");
		}else{
			Conf parent = (Conf) baseDao.get(Conf.class, conf.getParentId());
			conf.setParentName(parent.getName());
		}
		return conf;
	}
	
	/**
	 * 基础数据操作 获得所有数据的json格式串
	 * @return
	 */
	public String findConfJsonStr(Long typeId){
		String result = "[{\"id\":\"0\",\"text\":\"根\" ";
		String hql = "from Conf r where r.valid ='1' ";
		List qo=new ArrayList();
		if(typeId != null){
			qo.add(typeId);
			hql += " and r.typeId=? ";
		}
		hql += " and r.parentId is null order by r.priority asc ";
		List list = this.baseDao.find(hql, qo.toArray());
		if (list != null && list.size() > 0) {
			result += ",\"state\":\"open\",\"children\":[";
			for (int i = 0; i < list.size(); i++) {
				Conf conf = (Conf) list.get(i);
				result += "{\"id\":"+conf.getId()+",\"text\":\""+conf.getName()+"\" ";
				List<TreeVo> childList = findChildAccordionNodes(conf.getId());
				if(childList != null && childList.size() >0){
					result += ",\"state\":\"open\",\"children\":";
					result += JSONUtils.toJSONString(childList);
				}
				result += "},";
			}
			if(result.endsWith(","))result = result.substring(0, result.length() - 1);
			result += "]";
		}
		result += "}]";
		return result;
	}
	
	/**
	 * 加载指定父菜单下的二级菜单
	 * @param parentId
	 * @return
	 */
	public List<TreeVo> findChildAccordionNodes(Long parentId) {
		List<TreeVo> returnList = new ArrayList<TreeVo>();
		String hql = "select distinct f from Conf f where f.valid ='1' and f.parentId = ?  order by f.priority asc";
		List list = this.baseDao.find(hql,new Object[]{parentId});
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Conf conf = (Conf) list.get(i);
				TreeVo vo = new TreeVo();
				vo.setId(conf.getId() + "");
				vo.setText(conf.getName());
				vo.setChildren(findChildAccordionNodes(conf.getId()));
				
				//判断是否还有子节点
				List listTmp = this.baseDao.find(hql,new Object[]{conf.getId()});
				if(listTmp != null && listTmp.size() > 0 ){
					vo.setState("open");
				}else{
					vo.setState("close");
				}
				returnList.add(vo);
			}
			return returnList;
		}
		return null;
	}
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String name,String type,String valid){
		String hql = "from Conf r where 1 = 1 ";
		List qo=new ArrayList();
		if(code != null && !code.equals("")){
			qo.add("%"+code+"%");
			hql += " and r.code like ? ";
		}
		if(name != null && !name.equals("")){
			qo.add("%"+name+"%");
			hql += " and r.name like ? ";
		}
		if(type != null && !type.equals("")){
			qo.add(new Long(type));
			hql += " and r.typeId=? ";
		}
		if(valid != null && !valid.equals("")){
			qo.add(valid);
			hql += " and r.valid=? ";
		}
		this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
		List list = new ArrayList();
		Iterator it = jsonPaging.getList().iterator();
		while(it.hasNext()){
			Conf conf = (Conf)it.next();
			if(conf.getTypeId() != null ){
				ConfType confType = (ConfType) baseDao.get(ConfType.class, conf.getTypeId());
				conf.setTypeName(confType.getName());
			}
			if(conf.getParentId() ==null){
				conf.setParentName("根");
			}else{
				Conf parent = (Conf) baseDao.get(Conf.class, conf.getParentId());
				conf.setParentName(parent.getName());
			}
			list.add(conf);
		}
		jsonPaging.setList(list);
		return jsonPaging;
	}

	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<Conf> findAll(Long typeId){
		String hql = "from Conf m where m.valid ='1' and m.typeId = ? order by priority asc ";
		return this.baseDao.find(hql,new Object[]{ typeId });
	}
	
	/**
	 * 查找字典表中所有的数据
	 * 加载到application中
	 * 王志
	 * @return
	 */
	public List<Conf> findConfAll(){
		String hql = "from Conf m  where m.valid ='1' order by m.typeId,m.priority ";
		return this.baseDao.find(hql);
	}
	
	/**
	 * 查找字典表子类型的字典数据
	 * zjw
	 * @return
	 */
	public List<Conf> findChildConf(Long parentId){
		String hql = "from Conf m  where m.valid ='1' and m.typeId=? and m.parentId=? order by m.priority";
		return this.baseDao.find(hql,new Object[]{new Long(7),parentId});
	}
	
	public Conf findConf(String code,Long typeId){
		String hql = "from Conf d where d.valid ='1' and d.code = ? and d.typeId=? ";
		List<Conf> conf = baseDao.find(hql, new Object[] { code,typeId });
		if (conf != null && conf.size() > 0) {
			return conf.get(0);
		}
		return null;
	}

}
