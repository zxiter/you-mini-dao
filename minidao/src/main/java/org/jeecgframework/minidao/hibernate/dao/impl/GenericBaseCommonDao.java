package org.jeecgframework.minidao.hibernate.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jeecgframework.minidao.hibernate.dao.IGenericBaseCommonDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dell on 2015/8/21.
 */
public class GenericBaseCommonDao<T> implements IGenericBaseCommonDao<T> {

	/**
	 * 初始化Log4j的一个实例
	 */
	private static final Logger logger = Logger.getLogger(GenericBaseCommonDao.class);
	/**
	 * 注入一个sessionFactory属性,并注入到父类(HibernateDaoSupport)
	 * **/
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 获取hibernate的session
	 * 
	 * @return
	 */
	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		// for:因为加了MiniDao接口自动扫描，导致开启事务失败，所以捕获获取session异常，如果从当前线程获取不到，就重新创建
		try {
			return sessionFactory.getCurrentSession();
		} catch (Exception e) {
			return sessionFactory.openSession();
		}
	}

	/**
	 * 添加
	 * 
	 * @param t
	 * @return
	 */
	public Serializable save(T t) {
		return getSession().save(t);
	}

	/**
	 * 删除实体
	 * 
	 * @param t
	 */
	public void delete(T t) {
		getSession().delete(t);
	}

	/**
	 * 更新
	 * 
	 * @param t
	 */
	public void update(T t) {
		getSession().update(t);
	}

	/**
	 * 添加或者更新
	 * 
	 * @param t
	 */

	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	/**
	 * 根据id查询一个实体
	 * 
	 * @param c
	 * @param id
	 * @return
	 */
	public T get(Class<T> c, Serializable id) {
		return (T) getSession().get(c, id);
	}

	/**
	 * 根据hql查询一个实体
	 * 
	 * @param hql
	 * @return
	 */
	public T get(String hql) {
		Query query = getSession().createQuery(hql);
		List<T> list = query.list();
		if (null != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据hql和参数查询一个实体
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public T get(String hql, Map<String, Object> params) {
		Query query = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		List<T> list = query.list();
		if (null != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据hql查询列表
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql) {
		Query query = getSession().createQuery(hql);
		List<T> list = query.list();
		return list;
	}

	/**
	 * 根据hql和参数查询列表
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> find(String hql, Map<String, Object> params) {
		Query query = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		List<T> list = query.list();
		return list;
	}

	/**
	 * 根据hql查询分页列表
	 * 
	 * @param hql
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, int page, int rows) {
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * rows);
		query.setMaxResults(rows);
		List<T> list = query.list();
		return list;
	}

	/**
	 * 根据hql和参数查询分页列表
	 * 
	 * @param hql
	 * @param params
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query query = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		query.setFirstResult((page - 1) * rows);
		query.setMaxResults(rows);
		List<T> list = query.list();
		return list;
	}

	/**
	 * 根据hql统计
	 * 
	 * @param hql
	 * @return
	 */
	public Long count(String hql) {
		Query query = getSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}

	/**
	 * 根据hql和参数统计
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public Long count(String hql, Map<String, Object> params) {
		Query query = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return (Long) query.uniqueResult();
	}
}
