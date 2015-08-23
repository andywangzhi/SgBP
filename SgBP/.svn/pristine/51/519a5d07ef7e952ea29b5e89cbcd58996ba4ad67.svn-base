package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.Group;
import com.gzepro.internal.query.system.model.GroupAccount;
import com.gzepro.internal.query.system.model.Menu;
import com.gzepro.internal.query.system.service.TreeService;
import com.gzepro.internal.query.system.vo.TreeModel;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("treeService")
public class TreeServiceImpl extends SystemBaseService implements TreeService {	
	
	public String loadUserMenuForJson(Long accountId,int lang) {
		String result = "";
		String hql = "";
		List list = null;
		int dist = checkAccountDist(accountId);//获得用户的身份
		if(dist == Constants.DIST_TYPE_SUPER){//超级管理员
			hql = "select distinct menu from Menu menu where menu.parentId is null   and menu.valid='1' order by menu.priority asc";
			list = this.baseDao.find(hql);
		}else{//系统管理员的用户 只要是这个组的用户,则可操作所有的组菜单
			if(dist == Constants.DIST_TYPE_SYS || dist == Constants.DIST_TYPE_MANAGER){ //2 系统管理员的用户 只要是这个组的用户,则可操作所有的组菜单  3 组管理员可以加载本组的所有菜单
				hql = "select distinct menu from Menu menu where menu.parentId is null   and menu.valid='1' and menu.id in (select distinct gm.menuId from Group g,GroupAccount ga,GroupMenu gm where g.id=ga.groupId and g.valid='1' and ga.groupId=gm.groupId  and ga.accountId = ? ) order by menu.priority asc ";
			}else{//普通用户
				hql = "select distinct menu from Menu menu where menu.parentId is null   and menu.valid='1' and menu.id in (select distinct rm.menuId from Role r,AccountRole ar,RoleMenu rm where r.id=ar.roleId and r.valid='1' and ar.roleId=rm.roleId  and ar.accountId = ? ) order by menu.priority asc";
			}
			list = this.baseDao.find(hql,new Object[]{accountId});
		}
		if (list != null && list.size() > 0) {
			result = "{\"menus\":[";
			for (int i = 0; i < list.size(); i++) {
				Menu menu = (Menu) list.get(i);
				List<TreeModel> tmpList = loadChildAccordionNodes(menu.getId(),accountId,lang,dist);//有二级菜单
				if(tmpList != null  && tmpList.size() > 0){
					String name = "";
					if(lang == 0){
						name = menu.getNameZh();
					}else if (lang == 1){
						name = menu.getNameEn();
					}else if (lang == 2){
						name = menu.getNameTw();
					}
					result += "{\"menuid\":\""+menu.getId()+"\",\"icon\":\""+menu.getIcon()+"\",\"menuname\":\""+name+"\" ";
					result += ",\"menus\":[";
					result += this.loadAllChildNodes(tmpList);
/*					for(TreeModel treeModel:tmpList){
						String url = treeModel.getLink();
						if(url.indexOf("?")>0){
							url = url+"&menuId="+treeModel.getId();
						}else{
							url = url+"?menuId="+treeModel.getId();
						}
						result += "{\"menuid\":\""+treeModel.getId()+"\",\"menuname\":\""+treeModel.getText()+"\",\"icon\":\""+treeModel.getIconCls()+"\",\"url\":\""+contextPvd.getAppCxtPath()+url+"\"},";
					}
					result = result.substring(0, result.length() - 1);
					*/
					if(result.endsWith(","))result = result.substring(0, result.length() - 1);
					result += "]";
					result += "},";
				}
			}
			if(result.endsWith(","))result = result.substring(0, result.length() - 1);
			result += "]}";
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public String loadAllUrl() {
		String result = "";
		String hql = "";
		List list = null;
		hql = "select distinct menu from Menu menu";
		list = this.baseDao.find(hql);
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				Menu menu = (Menu) list.get(i);
				result+=menu.getUrl()+",";
			}
		}
		return result;
	}
    /**
     * 获得菜单的子菜单及子菜单的子菜单
     * @return
     */
	private String loadAllChildNodes(List<TreeModel> listTree){
		String result = "";
		for(TreeModel treeModel:listTree){
			String url = treeModel.getLink();
			if(url.indexOf("?")>0){
				url = url+"&menuId="+treeModel.getId();
			}else{
				url = url+"?menuId="+treeModel.getId();
			}
			
			if(treeModel.getChildren() != null && treeModel.getChildren().size() >0){
				result += "{\"menuid\":\""+treeModel.getId()+"\",\"menuname\":\""+treeModel.getText()+"\",\"icon\":\""+treeModel.getIconCls()+"\" ";
				result += ",\"menus\":[";
				String tmpJson = this.loadAllChildNodes(treeModel.getChildren());
				if(tmpJson.endsWith(","))tmpJson = tmpJson.substring(0, tmpJson.length() - 1);
				result += tmpJson;
				result += "]";
			}
			else
			{
				result += "{\"menuid\":\""+treeModel.getId()+"\",\"menuname\":\""+treeModel.getText()+"\",\"icon\":\""+treeModel.getIconCls()+"\",\"url\":\""+contextPvd.getAppCxtPath()+url+"\" ";
			}
			result += "},";
		}
		return result;
	}
	
	/**
	 * 递归获得子菜单
	 * @param parentId 父菜单
	 * @param accountId 用户
	 * @param lang 语言
	 * @param dist 身份
	 * @return
	 */
	private List<TreeModel> loadChildAccordionNodes(Long parentId,Long accountId,int lang,int dist) {
		List<TreeModel> returnList = new ArrayList<TreeModel>();
		String hql = "";
		List list = null;
		if(dist == Constants.DIST_TYPE_SUPER){//超级管理员
			hql = "select distinct menu from Menu menu where menu.parentId = ? and menu.valid='1' order by menu.priority asc";
			list = this.baseDao.find(hql,new Object[]{parentId});
		}else{//系统管理员的用户 只要是这个组的用户,则可操作所有的组菜单
			if(dist == Constants.DIST_TYPE_SYS || dist == Constants.DIST_TYPE_MANAGER){ //系统管理员的用户 只要是这个组的用户,则可操作所有的组菜单  组管理员可以加载本组的所有菜单
				hql = "select distinct menu from Menu menu where menu.parentId = ?  and menu.valid='1' and menu.id in (select distinct gm.menuId from Group g,GroupAccount ga,GroupMenu gm where g.id=ga.groupId and g.valid='1' and ga.groupId=gm.groupId  and ga.accountId = ? ) order by menu.priority asc ";
			}else{//普通用户
				hql = "select distinct menu from Menu menu where menu.parentId = ? and menu.valid='1' and menu.id in (select distinct rm.menuId from Role r,AccountRole ar,RoleMenu rm where r.id=ar.roleId and r.valid='1' and ar.roleId=rm.roleId  and ar.accountId = ? ) order by menu.priority asc";
			}
			
			list = this.baseDao.find(hql,new Object[]{parentId,accountId});
		}
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Menu menu = (Menu) list.get(i);
				String name = "";
				if(lang == 0){
					name = menu.getNameZh();
				}else if (lang == 1){
					name = menu.getNameEn();
				}else if (lang == 2){
					name = menu.getNameTw();
				}
				TreeModel treeModel = new TreeModel();
				treeModel.setId(menu.getId() + "");
				treeModel.setText(name);
				treeModel.setLink(menu.getUrl());
				treeModel.setChildren(loadChildAccordionNodes(menu.getId(),accountId,lang,dist));
				treeModel.setIconCls(menu.getIcon());
				
				//判断是否还有子节点
				List listTmp = this.baseDao.find(" from Menu f where f.valid='1'  and f.parentId = ? ",new Object[]{menu.getId()});
				if(listTmp != null && listTmp.size() > 0 ){
					treeModel.setLeaf(false);
				}else{
					treeModel.setLeaf(true);
				}
				returnList.add(treeModel);
			}
			return returnList;
		}
		return null;
	}
	
	/**
	 * 通过用户id获得用户的身份
	 * @param accountId 用户Id
	 * @return 1 为超级管理员 2系统管理员 3组管理员 4普通用户
	 */
	public int checkAccountDist(Long accountId) {
		int result = Constants.DIST_TYPE_COMMON;
		if(accountId == 1){//超级管理员
			return Constants.DIST_TYPE_SUPER;
		}
		String hql = "select r from Group r,GroupAccount ga where r.valid='1' and r.id=ga.groupId and ga.accountId=? ";
		List<Group> list = this.baseDao.find(hql,new Object[]{accountId});
		if(list != null && list.size() >0){
			Group group = list.get(0);
			if(group != null && group.getGroupLevel() == 0){//0表示系统管理员组
				return Constants.DIST_TYPE_SYS;
			}
			hql = "from GroupAccount m where m.manager='1' and m.accountId = ? ";
			List<GroupAccount> ls =  baseDao.find(hql, new Object[] {accountId});
			if(ls != null && ls.size()>0){
				return Constants.DIST_TYPE_MANAGER;//组管理员
			}
		}
		return result;
	}
}
