package com.gzepro.internal.query.common.persistence.hibernate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.persistence.BaseDao;
import com.gzepro.internal.query.common.util.Paging;
import com.gzepro.internal.query.common.util.json.JsonPaging;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("baseDao")
public class HibernateBaseDaoImpl extends HibernateDaoSupport implements
		BaseDao {
	/**
	 * 注入属性

	 * @param sessionFactory
	 */
	@Inject
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 创建持久化对象。

	 * 
	 * @param object
	 *            临时状态（transient）的实体对象。

	 * @return 创建后的持久化实例。

	 */
	public Object create(Object object) {
		getHibernateTemplate().save(object);
		return object;
	}

	/**
	 * 修改持久化对象。

	 * 
	 * @param object
	 *            准备修改的实体对象。

	 * @return 修改后的实体对象。

	 */
	public Object update(Object object) {
		getHibernateTemplate().update(object);
		return object;
	}

	/**
	 * 创建/修改实体对象。Hibernate会根据object的状态，决定是使用save()还是update()。

	 */
	public Object saveOrUpdate(Object object) {
		getHibernateTemplate().saveOrUpdate(object);
		return object;
	}

	/**
	 * 删除持久化对象。

	 * 
	 * @param object
	 *            想要删除的实体对象。

	 */
	public void delete(Object object) {
		getHibernateTemplate().delete(object);
	}

	/**
	 * 从数据库中读取一个持久化对象。

	 * 
	 * @param clazz
	 *            持久化类
	 * @param id
	 *            持久化对象的主键字

	 * @return 读取的一个持久化对象，或者null。

	 */
	public Object get(Class clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 从数据库中读取一个持久化对象。

	 * 
	 * @param clazz
	 *            持久化类
	 * @param id
	 *            持久化对象的主键字

	 * @return 读取的一个持久化对象，或者null。

	 */
	public Object load(Class clazz, Serializable id) {
		return getHibernateTemplate().load(clazz, id);
	}

	/**
	 * 刷新实体
	 * 
	 * @param object
	 */
	public void refresh(Object object) {
		getHibernateTemplate().refresh(object);
	}

	/**
	 * 从缓存中删除一个持久化对象,使之转变为游离对象

	 */
	public void evict(Object object) {
		getHibernateTemplate().evict(object);
	}

	/**
	 * 按hql语句查询
	 * 
	 * @param HQL
	 * @return
	 */
	public List find(String hql) {
		return getHibernateTemplate().find(hql);
	}

	/**
	 * 根据参数查询
	 * 
	 * @param hql
	 * @param obj
	 * @return
	 */
	public List find(String hql, Object[] obj) {
		return getHibernateTemplate().find(hql, obj);
	}

	public List findByNamedQuery(String queryName, String value) {
		return getHibernateTemplate().findByNamedQuery(queryName, value);
	}
	
	public List findByNamedQuery(String queryName, Object[] value) {
		return getHibernateTemplate().findByNamedQuery(queryName, value);
	}

    public List findWithCache(String hql)
    {
		getHibernateTemplate().setCacheQueries(true);
		List list = find(hql);
		getHibernateTemplate().setCacheQueries(false);
		return list;
    }
    
	public List findWithCache(String hql, Object[] obj) {
		getHibernateTemplate().setCacheQueries(true);
		List list = find(hql, obj);
		getHibernateTemplate().setCacheQueries(false);
		return list;
	}

	public List findWithQueryCache(String hql, Object[] obj) {
		getHibernateTemplate().setCacheQueries(true);
		getHibernateTemplate().setQueryCacheRegion("queryCache");
		List list = find(hql, obj);
		getHibernateTemplate().setCacheQueries(false);
		return list;
	}

	public List findWithQueryCache(String hql) {
		getHibernateTemplate().setCacheQueries(true);
		getHibernateTemplate().setQueryCacheRegion("queryCache");
		List list = find(hql);
		getHibernateTemplate().setCacheQueries(false);
		return list;
	}
	
    public HibernateTemplate getHbTemplate(){
    	return getHibernateTemplate();
    }
	
	public Paging selectPaging(final String hql, final Object[] params,
			Paging paging) {
		String hql1 = "select count(*) " + hql;
		long totalRecords;
		if (params != null)
			totalRecords = selectTotalRecords(hql1, params);
		else
			totalRecords = selectTotalRecords(hql1, null);
		paging.setTotalRecords(totalRecords);
		final int pageSize = paging.getPageSize();
		final int startRow = paging.getStartRow();
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				for (int i = 0; i < (params != null ? params.length : 0); i++) {
					query.setParameter(i, params[i]);
				}
				query.setFirstResult(startRow);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
		paging.setVoList((ArrayList) list);
		return paging;
	}
	
	public Paging selectPagingSec(final String hql, final Object[] params,
			Paging paging) {
		final int pageSize = paging.getPageSize();
		final int startRow = paging.getStartRow();
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				for (int i = 0; i < (params != null ? params.length : 0); i++) {
					query.setParameter(i, params[i]);
				}
				query.setFirstResult(startRow);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
		paging.setVoList((ArrayList) list);
		return paging;
	}
	
	public long selectTotalRecords(String hql, Object[] params) {
		List list = null;
		if (params != null)
			list = getHibernateTemplate().find(hql, params);
		else
			list = getHibernateTemplate().find(hql);

		if (list == null || list.size() <= 0) {
			return 0;
		} else {
			Object o = list.get(0);

			if (o == null)
				return 0;
			if (o instanceof Integer)
				return ((Integer) o).longValue();
			else
				return ((Long) o).longValue();
		}
	}
	
	public int batchUpdateOrDelete(String hql, Object[] params) {
		int result = 0;
		try { 
			if (params == null || params.length == 0)
				result = getHibernateTemplate().bulkUpdate(hql);
			else
				result = getHibernateTemplate().bulkUpdate(hql, params);
	    } catch (Exception e) { 
		   e.printStackTrace(); 
		} 
		return result;
	}
	
	public List selectAll(String hql, Object[] params) {
		if (params == null || params.length == 0)
			return getHibernateTemplate().find(hql);
		else
			return getHibernateTemplate().find(hql, params);
	}
	
	public List selectAllBySQL(final String sql, final Object[] params){
		return (List)getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				for(int i=0; i<(params!=null?params.length:0); i++){
					query.setParameter(i, params[i]);
				}
				return query.list();
			}
		});
	}
	
	public Paging selectAllBySQL(final String sql, final Object[] params,  Paging paging){
		final int pageSize = paging.getPageSize();
		final int startRow = paging.getStartRow();
		List list = (List)getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				for(int i=0; i<(params!=null?params.length:0); i++){
					query.setParameter(i, params[i]);
				}
				query.setFirstResult(startRow);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
		paging.setVoList((ArrayList)list);
		return paging;
	}
	
	public int updateBySQL(final String sql, final Object[] params) {
		Integer num = (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						SQLQuery query = session.createSQLQuery(sql);
						for (int i = 0; i < (params != null ? params.length : 0); i++) {
							query.setParameter(i, params[i]);
						}
						return new Integer(query.executeUpdate());
					}
				});
		return num.intValue();
	}
	
	
	public JsonPaging selectJsonPaging(final String hql, final Object[] params,JsonPaging jsonPaging) {
		String hql1 = "select count(*) " + hql;
		long totalRecords;
		if (params != null)
			totalRecords = selectTotalRecords(hql1, params);
		else
			totalRecords = selectTotalRecords(hql1, null);
		jsonPaging.setTotal(Integer.parseInt(totalRecords+""));
		
		final int curPage = jsonPaging.getPage();
		final int pageSize = jsonPaging.getRows();
		final String order = jsonPaging.getOrderStr();
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql+order);
				for (int i = 0; i < (params != null ? params.length : 0); i++) {
					query.setParameter(i, params[i]);
				}
				query.setFirstResult((curPage - 1) * pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
		jsonPaging.setList((ArrayList) list);
		return jsonPaging;
	}
	
}
