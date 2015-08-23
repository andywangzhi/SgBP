package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.Conf;
import com.gzepro.internal.query.system.model.Menu;
import com.gzepro.internal.query.system.model.MenuDictionary;
import com.gzepro.internal.query.system.service.MenuService;
import com.gzepro.internal.query.system.vo.TreeVo;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("menuService")
public class MenuServiceImpl extends SystemBaseService implements
        MenuService {

	/**
	 * 增加一条数据
	 * @param menu
	 */
	public  Menu add(Menu menu){
		if(menu.getParentId() != null && menu.getParentId() == 0){
			menu.setParentId(null);
		}  
		menu.setCreateDate(new Date());
		menu.setCreator(this.getAccount().getId());
		return (Menu)baseDao.create(menu);
	}

	/**
	 * 修改一条数据
	 * @param menu
	 */
	public  Menu edit(Menu menu){
		if(menu.getParentId() != null && menu.getParentId() == 0){
			menu.setParentId(null);
		}
		menu.setCreateDate(new Date());
		menu.setCreator(this.getAccount().getId());
		return (Menu)baseDao.update(menu);
	}
	
	
	/**
	 * 检测菜单Code 存在
	 */
	public Menu menuCodeExist(String code){
		String hql = "from Menu m where m.code = ? ";
		List<Menu> menu = baseDao.find(hql, new String[] { code });
		if (menu != null && menu.size() > 0) {
			return menu.get(0);
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
				Menu menu = (Menu) baseDao.get(Menu.class, new Long(id));
				menu.setValid(status);
				if(status.equals("2")){//删除的时候,则删除相关联的信息
					deleteRelate(id);
				}
				baseDao.saveOrUpdate(menu);
			}
		}
		return true;
	}
	
	/**
	 * 保存菜单的敏感字段
	 * @param menuId
	 * @param dicIds
	 * @return
	 */
	public  void saveDic(Long menuId,String dicIds){
		
		String newDicIds = ","+dicIds+",";
		String oldDicIds= findMenuDicIds(menuId);
		
		String deleteIds = "";//查找到要删除的记录
        if(oldDicIds != null && !oldDicIds.equals("")){
        	String[] arr = oldDicIds.split(",");
        	for(String id :arr){
        		if(id != null &&  !id.equals("") && !newDicIds.contains(","+id+",")){
        			deleteIds+=id+",";
        		}
        	}
        }
		
        if(deleteIds.endsWith(","))deleteIds = deleteIds.substring(0,deleteIds.length()-1);
        if(!deleteIds.equals("")){
    		//操作之前先清空菜单原来的记录
    		String sql = " delete from mstb_sys_menu_dictionary t where t.dictionary_id in( "+deleteIds+" ) and t.menu_id=? ";
    		this.springJdbcQueryManager.update(sql,new Object[]{menuId});
    		
    		//操作之前先清空菜单原来的记录
    		sql = " delete from mstb_sys_role_menu t where t.right_id in( "+deleteIds+" ) and t.right_type='d' and t.menu_id=? ";
    		this.springJdbcQueryManager.update(sql,new Object[]{menuId});
        }
        
        if(newDicIds != null && !newDicIds.equals("")){
        	oldDicIds = ","+oldDicIds+",";
        	String[] arr = newDicIds.split(",");
        	for(String id :arr){
        		if(id != null &&  !id.equals("") && !oldDicIds.contains(","+id+",")){ //剩下的就是新增的记录
        			MenuDictionary dic = new MenuDictionary();
        			dic.setMenuId(menuId);
        			dic.setDictionaryId(new Long(id));
        			this.baseDao.create(dic);
        		}
        	}
        }
	}
	
	/**
	 * 查找敏感信息关联有菜单
	 * @param id
	 * @return
	 */
	private String findMenuDicIds(Long menuId){
		String dicIds = "";
		String hql = "from MenuDictionary d where d.menuId  = ? " ;
		List<MenuDictionary> list = this.baseDao.find(hql,new Long[] { menuId });
		 if(list != null && list.size() > 0){
			 for(MenuDictionary md:list){
				 dicIds += md.getDictionaryId()+",";
			 }
			 if(dicIds.endsWith(","))dicIds=dicIds.substring(0,dicIds.length()-1);
		 }
		return dicIds;
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
			Menu menu = findById(id);
			deleteRelate(id.toString());
			baseDao.delete(menu);
			return true;
		}
	}
	
	/**
	 * 删除关联信息
	 * @param id
	 * @return
	 */
	private void deleteRelate(String id){
		String sql = " delete from mstb_sys_role_menu t where  t.menu_id=? ";
		this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
		
		sql = " delete from mstb_sys_menu_dictionary t where  t.menu_id=? ";
		this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
		
		sql = " delete from mstb_sys_group_menu t where  t.menu_id=? ";
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
	public Menu findById(Long id){
		Menu menu = (Menu) baseDao.get(Menu.class, id);
		if(menu.getCreator() != null ){
			Account creator = (Account) baseDao.get(Account.class, menu.getCreator());
			menu.setCreatorName(creator.getNameCN());
		}
		if(menu.getParentId() ==null){
			menu.setParentName("根");
		}else{
			Menu parent = (Menu) baseDao.get(Menu.class, menu.getParentId());
			menu.setParentName(parent.getNameZh());
		}

		String dicIds = "";
		String hql = " select distinct f from MenuDictionary f where f.menuId = ? ";
		List<MenuDictionary> listSec = baseDao.find(hql, new Object[] { id });
		if (listSec != null && listSec.size() > 0) {
			for(MenuDictionary dic:listSec){
				dicIds += dic.getDictionaryId()+",";
			}
		}
		if(dicIds.endsWith(","))dicIds=dicIds.substring(0,dicIds.length()-1);
		menu.setDicIds(dicIds);
		
		return menu;
	}
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String name,String type,String valid){
		String hql = "from Menu r  where 1=1 ";
		List qo=new ArrayList();
		if(code != null && !code.equals("")){
			qo.add("%"+code+"%");
			hql += " and r.code like ? ";
		}
		if(name != null && !name.equals("")){
			qo.add("%"+name+"%");
			qo.add("%"+name+"%");
			qo.add("%"+name+"%");
			hql += " and (r.nameZh like ? or r.nameEn like ?  or r.nameTw like ? ) ";
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
			Menu menu = (Menu)it.next();
			if(menu.getParentId() ==null){
				menu.setParentName("根");
			}else{
				Menu parent = (Menu) baseDao.get(Menu.class, menu.getParentId());
				menu.setParentName(parent.getNameZh());
			}
			if(menu.getCreator() != null ){
				Account creator = (Account) baseDao.get(Account.class, menu.getCreator());
				menu.setCreatorName(creator.getNameCN());
			}
			
			if(menu.getTypeId() != null ){
				Conf conf = (Conf) baseDao.get(Conf.class, menu.getTypeId());
				menu.setTypeName(conf.getName());
			}
			
			list.add(menu);
		}
		jsonPaging.setList(list);
		
		return jsonPaging;
	}
	
	/************ 菜单操作使用 开始********************/
	/**
	 * 获得所有菜单的json格式串
	 * @return
	 */
	public String findMenuJsonStr(){
		String result = "[{\"id\":\"0\",\"text\":\"根\" ";
		String hql = "from Menu r where r.valid ='1' and r.parentId is null order by r.priority asc";
		List list = this.baseDao.find(hql);
		if (list != null && list.size() > 0) {
			result += ",\"state\":\"open\",\"children\":[";
			for (int i = 0; i < list.size(); i++) {
				Menu menu = (Menu) list.get(i);
				result += "{\"id\":"+menu.getId()+",\"text\":\""+menu.getNameZh()+"\" ";
				List<TreeVo> childList = findChildAccordionNodes(menu.getId());
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
	 * 获得所有菜单的json格式串 不包含根结点
	 * @return
	 */
	public String findMenuJsonStrSec(String selectedIds){
		String result = "[";
		String hql = "from Menu r where r.valid ='1' and r.parentId is null order by r.priority asc ";
		List<Menu> list = this.baseDao.find(hql);
		if (list != null && list.size() > 0) {
			for (Menu menu:list) {
				result += "{\"id\":"+menu.getId()+",\"text\":\""+menu.getNameZh()+"\" ";
				hql = "select distinct f from Menu f where f.valid ='1' and f.parentId = ?  order by f.priority asc";
				List<Menu> ls = this.baseDao.find(hql,new Object[]{menu.getId()});
				String mStr = "";
				if (ls != null && ls.size() > 0) {
					mStr += ",\"children\":[";
					for (Menu m:ls) {
						mStr += "{\"id\":"+m.getId()+",\"text\":\""+m.getNameZh()+"\" ";
						if(selectedIds != null && !selectedIds.equals("")){
							String tempStr = ","+selectedIds+",";
							if(tempStr.contains(","+m.getId()+",")){
								mStr += ",\"checked\":true ";
							}
						}
						mStr += "},";
					}
					if(mStr.endsWith(","))mStr=mStr.substring(0,mStr.length()-1);
					mStr += "]";
				}
				result += mStr+"},";
			}
			if(result.endsWith(","))result=result.substring(0,result.length()-1);
		}
		result += "]";
		return result;
	}
	
	/**
	 * 加载指定父菜单下的二级菜单
	 * @param parentId
	 * @return
	 */
	public List<TreeVo> findChildAccordionNodes(Long parentId) {
		List<TreeVo> returnList = new ArrayList<TreeVo>();
		String hql = "select distinct f from Menu f where f.valid ='1' and f.parentId = ?  order by f.priority asc";
		List list = this.baseDao.find(hql,new Object[]{parentId});
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Menu menu = (Menu) list.get(i);
				TreeVo vo = new TreeVo();
				vo.setId(menu.getId() + "");
				vo.setText(menu.getNameZh());
				vo.setChildren(findChildAccordionNodes(menu.getId()));
				vo.setIconCls(menu.getIcon());
				
				//判断是否还有子节点
				List listTmp = this.baseDao.find(hql,new Object[]{menu.getId()});
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
	/************ 菜单操作使用 结束********************/
	
}
