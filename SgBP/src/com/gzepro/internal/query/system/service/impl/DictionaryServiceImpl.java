package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.Conf;
import com.gzepro.internal.query.system.model.Dictionary;
import com.gzepro.internal.query.system.model.Menu;
import com.gzepro.internal.query.system.model.MenuDictionary;
import com.gzepro.internal.query.system.service.DictionaryService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("dictionaryService")
public class DictionaryServiceImpl extends SystemBaseService implements
		DictionaryService {

	/**
	 * 增加一条数据
	 * @param dictionary
	 */
	public  Dictionary add(Dictionary dictionary){
		dictionary.setCreateDate(new Date());
		dictionary.setCreator(this.getAccount().getId());
		dictionary.setValid("1");
		return (Dictionary)baseDao.create(dictionary);
	}
	
	/**
	 * 修改一条数据
	 * @param dictionary
	 */
	public  Dictionary edit(Dictionary dictionary){
		if(dictionary.getId()==0){
			dictionary.setId(null);
		}
		dictionary.setCreateDate(new Date());
		dictionary.setCreator(this.getAccount().getId());
		return (Dictionary)baseDao.saveOrUpdate(dictionary);
	}
	
	/**
	 * 是否存在唯一的Code
	 */
	public Dictionary dictionaryCodeExist(String code){
		
		String hql = "from Dictionary d where d.code = ? ";
		List<Dictionary> dictionary = baseDao.find(hql, new String[] { code });
		if (dictionary != null && dictionary.size() > 0) {
			return dictionary.get(0);
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
				Dictionary dictionary = (Dictionary) baseDao.get(Dictionary.class, new Long(id));
				dictionary.setValid(status);
				if(status.equals("2")){//删除的时候,则删除相关联的信息
					deleteRelate(id);
				}
				baseDao.saveOrUpdate(dictionary);
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
			Dictionary dictionary = findById(id);
			deleteRelate(id.toString());
			baseDao.delete(dictionary);
			return true;
		}
	}
	
	/**
	 * 删除关联信息
	 * @param id
	 * @return
	 */
	private void deleteRelate(String id){
		String sql = " delete from mstb_sys_menu_dictionary t where  t.dictionary_id=?";
//		this.springJdbcQueryManager.execute(sql);
		this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
		
		sql = " delete from mstb_sys_role_menu t where t.right_type='d' and t.right_id=? ";
		this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
		
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
	public Dictionary findById(Long id){
		Dictionary dictionary = (Dictionary) baseDao.get(Dictionary.class, id);
		if(dictionary.getCreator() != null ){
			Account creator = (Account) baseDao.get(Account.class, dictionary.getCreator());
			dictionary.setCreatorName(creator.getNameCN());
		}
		dictionary.setMenuIds(findMenuIds(id));
		return dictionary;
	}
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String name,String type,String valid,String sensitive){
		String hql = "from Dictionary r  where 1=1 ";
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
		if(sensitive != null && !sensitive.equals("") && sensitive.equals("1")){
			hql += " and r.sensitive='1' ";
		}
		this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
		List list = new ArrayList();
		Iterator it = jsonPaging.getList().iterator();
		while(it.hasNext()){
			Dictionary dictionary = (Dictionary)it.next();
			if(dictionary.getCreator() != null ){
				Account creator = (Account) baseDao.get(Account.class, dictionary.getCreator());
				dictionary.setCreatorName(creator.getNameCN());
			}
			if(dictionary.getTypeId() != null ){
				Conf conf = (Conf) baseDao.get(Conf.class, dictionary.getTypeId());
				dictionary.setTypeName(conf.getName());
			}
			list.add(dictionary);
		}
		jsonPaging.setList(list);
		return jsonPaging;
	}

	/**
	 * 查找指定菜单的可控字段
	 * @param jsonPaging
	 * @param menuId
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,Long menuId){
		String hql = "from Dictionary d where  d.valid='1' " ;
		List qo=new ArrayList();
		if(menuId != null && menuId != 0){
			qo.add(menuId);
			hql += " and r.menuId=? ";
		}
		this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
		List list = new ArrayList();
		Iterator it = jsonPaging.getList().iterator();
		while(it.hasNext()){
			Dictionary dictionary = (Dictionary)it.next();
			if(dictionary.getCreator() != null ){
				Account creator = (Account) baseDao.get(Account.class, dictionary.getCreator());
				dictionary.setCreatorName(creator.getNameCN());
			}
			if(dictionary.getValid().equals("1")){
				dictionary.setValid("激活");
			}else if(dictionary.getValid().equals("0")){
				dictionary.setValid("停用");
			}
			list.add(dictionary);
		}
		jsonPaging.setList(list);
		return jsonPaging;
	}
	
	/**
	 * 查找所有的数据
	 * @param id
	 * @return
	 */
	public List<Dictionary> findAll(){
		List<Dictionary> result = new ArrayList<Dictionary>();
		String hql = "from Dictionary d where  d.valid='1' and d.sensitive='1' " ;
		List list = this.baseDao.find(hql);
		Iterator it = list.iterator();
		while(it.hasNext()){
			Dictionary dictionary = (Dictionary)it.next();
			if(dictionary.getCreator() != null ){
				Account creator = (Account) baseDao.get(Account.class, dictionary.getCreator());
				dictionary.setCreatorName(creator.getNameCN());
			}
			result.add(dictionary);
		}
		return result;
	}
	
	/**
	 * 查找敏感信息关联有菜单
	 * @param id
	 * @return
	 */
	public String findMenuIds(Long dicId){
		String menuIds = "";
		String hql = "from MenuDictionary d where d.dictionaryId  = ? " ;
		List<MenuDictionary> list = this.baseDao.find(hql,new Long[] { dicId });
		 if(list != null && list.size() > 0){
			 for(MenuDictionary md:list){
				 menuIds += md.getMenuId()+",";
			 }
			 if(menuIds.endsWith(","))menuIds=menuIds.substring(0,menuIds.length()-1);
		 }
		return menuIds;
	}
	
	/**
	 * 保存菜单的敏感信息
	 * @param dicId 敏感信息id
	 * @param menuIds 菜单id
	 * @return
	 */
	public boolean saveMenuDic(Long dicId,String menuIds){
		boolean result = true;
		
		String newMenuIds = ","+menuIds+",";
		String oldMenuIds = findMenuIds(dicId);
		
		String deleteIds = "";//查找到要删除的记录
        if(oldMenuIds != null && !oldMenuIds.equals("")){
        	String[] arr = oldMenuIds.split(",");
        	for(String id :arr){
        		if(id != null &&  !id.equals("") && !newMenuIds.contains(","+id+",")){
        			deleteIds+=id+",";
        		}
        	}
        }
        if(deleteIds.endsWith(","))deleteIds = deleteIds.substring(0,deleteIds.length()-1);
        if(!deleteIds.equals("")){
    		//操作之前先清空菜单原来的记录
    		String sql = " delete from mstb_sys_menu_dictionary t where t.menu_id in( "+deleteIds+" ) and t.dictionary_id=? ";
    		this.springJdbcQueryManager.update(sql,new Object[]{dicId});
    		
    		//操作之前先清空菜单原来的记录
    		sql = " delete from mstb_sys_role_menu t where t.menu_id in( "+deleteIds+" ) and t.right_type='d' and t.right_id=? ";
    		this.springJdbcQueryManager.update(sql,new Object[]{dicId});
        }
        
        if(newMenuIds != null && !newMenuIds.equals("")){
        	oldMenuIds = ","+oldMenuIds+",";
        	String[] arr = newMenuIds.split(",");
        	for(String id :arr){
        		if(id != null &&  !id.equals("") && !oldMenuIds.contains(","+id+",")){ //剩下的就是新增的记录
        			Menu menu = (Menu) baseDao.get(Menu.class, new Long(id));
        			if(menu.getParentId() != null){//只保留二级菜单的敏感信息
            			MenuDictionary dic = new MenuDictionary();
            			dic.setMenuId(new Long(id));
            			dic.setDictionaryId(dicId);
            			this.baseDao.create(dic);
        			}
        		}
        	}
        }
        
		return result;
	}
	
}
