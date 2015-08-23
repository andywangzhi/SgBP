package com.gzepro.internal.query.common.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.gzepro.internal.query.common.util.Paging;
import com.gzepro.internal.query.common.util.json.JsonPaging;

/**
 * 
 * DAO操作接口。
 * 
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface BaseDao {
	/**
	 * 创建持久化对象。
	 * @param object  临时状态（transient）的实体对象。
	 * @return 创建后的持久化实例。
	 */
	public Object create(Object object);
	
	/**
	 * 修改持久化对象。
	 * @param object 准备修改的实体对象。
	 * @return       修改后的实体对象。
	 */
	public Object update(Object object);
	
	/**
	 * 创建/修改实体对象。Hibernate会根据object的状态，决定是使用save()还是update()。
	 */
	public Object saveOrUpdate(Object object);
	
	/**
	 * 删除持久化对象。
	 * @param object 想要删除的实体对象。
	 */
	public void delete(Object object);
	
	/**
	 * 从数据库中读取一个持久化对象。
	 * @param clazz 持久化类
	 * @param id    持久化对象的主键字
	 * @return      读取的一个持久化对象，或者null。
	 */
	public Object get(Class clazz, Serializable id);
	
	/**
	 * 从数据库中读取一个持久化对象。
	 * @param clazz 持久化类
	 * @param id    持久化对象的主键字
	 * @return      读取的一个持久化对象，或者null。
	 */
	public Object load(Class clazz, Serializable id);

	/**
	 * 刷新实体
	 * @param object
	 */
	public void refresh(Object object);
	
	/**
	 * 从缓存中删除一个持久化对象,使之转变为游离对象
	 */
	public void evict(Object object);
	
	/**
	 * 按hql语句查询
	 * @param HQL
	 * @return
	 */
	public List find(String hql);
	
	/**
	 * 根据参数查询
	 * @param HQL
	 * @param obj
	 * @return
	 */
	public List find(String hql, Object[] obj);
	
	public List findByNamedQuery(String queryName, String value);

	public List findByNamedQuery(String queryName, Object[] value);

    public List findWithCache(String hql);
    
	public List findWithCache(String hql, Object[] obj);

	public List findWithQueryCache(String hql);
	
	public List findWithQueryCache(String hql, Object[] obj);
	
    /**
     * 得到HibernateTemplate对象
     * @return
     */
    public HibernateTemplate getHbTemplate();
    
	public Paging selectPaging(String hql, Object[] params,Paging paging);
	
	public Paging selectPagingSec(String hql, Object[] params,Paging paging);
	
	public long selectTotalRecords(String hql, Object[] params);
	
	public int batchUpdateOrDelete(String hql, Object[] params);
	
	public List selectAll(String hql, Object[] params);
	
	public List selectAllBySQL(final String sql, final Object[] params);
	
	public Paging selectAllBySQL(final String sql, final Object[] params,  Paging paging);
	
	public int updateBySQL(final String sql, final Object[] params);
	
	public JsonPaging selectJsonPaging(String hql, Object[] params,JsonPaging jsonPaging);
	
}