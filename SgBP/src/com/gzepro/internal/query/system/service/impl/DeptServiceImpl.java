package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.AccountDept;
import com.gzepro.internal.query.system.model.Dept;
import com.gzepro.internal.query.system.service.DeptService;
import com.gzepro.internal.query.system.vo.TreeVo;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("deptService")
public class DeptServiceImpl extends SystemBaseService implements
		DeptService {

	/**
	 * 增加一条数据
	 * @param dept
	 */
	public  Dept add(Dept dept,String accountIds){
		dept = init(dept);
		dept = (Dept)baseDao.create(dept);
		saveAccount(dept.getId(),accountIds);
		return dept;
	}
	
	/**
	 * 修改一条数据
	 * @param dept
	 */
	public  Dept edit(Dept dept,String accountIds){
		dept = init(dept);
		dept = (Dept)baseDao.update(dept);
		saveAccount(dept.getId(),accountIds);
		return dept;
	}
	
	/**
	 * 初始化方法
	 * @param dept
	 */
	private  Dept init(Dept dept){
		if(null == dept.getId()){
			dept.setId(null);
			dept.setValid("1");
		}
		if(dept.getParentId() == null || dept.getParentId() == 0){
			dept.setParentId(null);
		}
		dept.setParentName("");
		return dept;
	}
	
	/**
	 * 是否存在唯一的Code
	 */
	public Dept codeExist(String code){
		String hql = "from Dept d where d.code = ? ";
		List<Dept> dept = baseDao.find(hql, new String[] { code });
		if (dept != null && dept.size() > 0) {
			return dept.get(0);
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
				Dept dept = (Dept) baseDao.get(Dept.class, new Long(id));
				dept.setValid(status);
				baseDao.saveOrUpdate(dept);
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
			Dept dept = findById(id);
			baseDao.delete(dept);
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
	public Dept findById(Long id){
		return (Dept) baseDao.get(Dept.class, id);
	}
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String name,String valid){
		String hql = "from Dept r where 1 = 1 ";
		List qo=new ArrayList();
		if(code != null && !code.equals("")){
			qo.add("%"+code+"%");
			hql += " and r.code like ? ";
		}
		if(name != null && !name.equals("")){
			qo.add("%"+name+"%");
			hql += " and r.nameCN like ? ";
		}
		if(valid != null && !valid.equals("")){
			qo.add(valid);
			hql += " and r.valid=? ";
		}
		this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
		List list = new ArrayList();
		Iterator it = jsonPaging.getList().iterator();
		while(it.hasNext()){
			Dept dept = (Dept)it.next();
			if(dept.getParentId() ==null){
				dept.setParentName("根");
			}else{
				Dept parent = (Dept) baseDao.get(Dept.class, dept.getParentId());
				dept.setParentName(parent.getNameCN());
			}
			list.add(dept);
		}
		jsonPaging.setList(list);
		return jsonPaging;
	}
	
	/**
	 * 查找所有的数据
	 * @param id
	 * @return
	 */
	public List<Dept> findAll(){
		String hql = "from Dept d where d.valid ='1'";
		List<Dept> list = this.baseDao.find(hql);
		return list;
	}
	

	public  List<Dept> loadDeptNodesList(String name) {
		String hql = " from Dept d where d.valid ='1' ";
		if(name!=null && !"".equals(name.trim())){
			hql += " and d.nameCN like '%"+name+"%' ";
		}
		return this.baseDao.find(hql);
	}
	
	/************ 树状 json 开始********************/
	/**
	 * 基础数据操作 获得所有数据的json格式串
	 * @return
	 */
	public String findDeptJsonStr(){
		String result = "[{\"id\":\"0\",\"text\":\"根\" ";
		String hql = "from Dept r where r.valid ='1' and r.parentId is null order by r.id asc ";
		List list = this.baseDao.find(hql);
		if (list != null && list.size() > 0) {
			result += ",\"state\":\"open\",\"children\":[";
			for (int i = 0; i < list.size(); i++) {
				Dept dept = (Dept) list.get(i);
				result += "{\"id\":"+dept.getId()+",\"text\":\""+dept.getNameCN()+"\" ";
				List<TreeVo> childList = findChildAccordionNodes(dept.getId());
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
		String hql = "select distinct f from Dept f where f.valid ='1' and f.parentId = ?  order by f.id asc";
		List list = this.baseDao.find(hql,new Object[]{parentId});
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Dept dept = (Dept) list.get(i);
				TreeVo vo = new TreeVo();
				vo.setId(dept.getId() + "");
				vo.setText(dept.getNameCN());
				vo.setChildren(findChildAccordionNodes(dept.getId()));
				
				//判断是否还有子节点
				List listTmp = this.baseDao.find(hql,new Object[]{dept.getId()});
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
	/************ 树状 json 结束********************/
	
	
	/************ 保存部门用户 开始********************/
	/**
	 * 保存部门成员
	 * @param deptId
	 * @param accountIds
	 * @return
	 */
	private  void saveAccount(Long deptId,String accountIds){
        String newAccountIds = ","+accountIds+",";
        String oldAccountIds = findAccountById(deptId);
		String deleteIds = "";//查找到要删除的记录
        if(oldAccountIds != null && !oldAccountIds.equals("")){
        	String[] arr = oldAccountIds.split(",");
        	for(String id :arr){
        		if(id != null &&  !id.equals("") && !newAccountIds.contains(","+id+",")){
        			deleteIds+=id+",";
        		}
        	}
        }
        
        if(deleteIds.endsWith(","))deleteIds = deleteIds.substring(0,deleteIds.length()-1);
        if(!deleteIds.equals("")){
    		//删除部门成员
        	String sql = " delete from mstb_sys_account_dept where account_id in("+deleteIds+")";
    		this.springJdbcQueryManager.execute(sql);
        }
        if(newAccountIds != null && !newAccountIds.equals("")){
        	oldAccountIds = ","+oldAccountIds+",";
        	String[] arr = newAccountIds.split(",");
        	for(String id :arr){
        		if(id != null &&  !id.equals("") && !oldAccountIds.contains(","+id+",")){ //剩下的就是新增的记录
        			
        			Account account = new Account();
        			account.setId(new Long(id));
        			
        			AccountDept ad = new AccountDept();
        			ad.setAccountId(new Long(id));
        			ad.setDeptId(deptId);
        			baseDao.create(ad);
        		}
        	}
        }
	}
	
	/**
	 * 通过部门ID查找部门用户
	 * @param deptId
	 * @return
	 */
	private String findAccountById(Long deptId){
        String accountIds = "";
		String hql = "from AccountDept u where u.deptId = ? ";
		List<AccountDept> list = baseDao.find(hql, new Long[] { deptId });
		if (list != null && list.size() > 0) {
			for(AccountDept dept:list){
				accountIds += dept.getAccountId()+",";
			}
			if(accountIds.endsWith(","))accountIds = accountIds.substring(0,accountIds.length()-1);
		}
		return accountIds;
	}
	/************ 保存部门用户 结束********************/
	
	/**
	 * 通过部门ID查找部门用户
	 * @param deptId
	 * @return
	 */
	public List<Account> findAllAccountByDeptId(Long deptId){
		String hql = "from Account u where u.id in(select ad.accountId from AccountDept ad where ad.deptId = ? ) ";
		return baseDao.find(hql, new Long[] { deptId });
	}
	
}
