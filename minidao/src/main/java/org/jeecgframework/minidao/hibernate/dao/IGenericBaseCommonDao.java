package org.jeecgframework.minidao.hibernate.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

/**
 * 类描述：DAO层泛型基类接口 Created by dell on 2015/8/21.
 */
public interface IGenericBaseCommonDao<T> {

	/**
	 * 获取hibernate的session
	 * 
	 * @return
	 */
	public Session getSession();

	/**
	 * 添加
	 * 
	 * @param t
	 * @return
	 */

	public Serializable save(T t);

	/**
	 * 删除实体
	 * 
	 * @param t
	 */

	public void delete(T t);

	/**
	 * 更新
	 * 
	 * @param t
	 */
	public void update(T t);

	/**
	 * 添加或者更新
	 * 
	 * @param t
	 */
	public void saveOrUpdate(T t);

	/**
	 * 根据id查询一个实体
	 * 
	 * @param c
	 * @param id
	 * @return
	 */
	public T get(Class<T> c, Serializable id);

	/**
	 * 根据hql查询一个实体
	 * 
	 * @param hql
	 * @return
	 */
	public T get(String hql);

	/**
	 * 根据hql和参数查询一个实体
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public T get(String hql, Map<String, Object> params);

	/**
	 * 根据hql查询列表
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql);

	/**
	 * 根据hql和参数查询列表
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> find(String hql, Map<String, Object> params);

	/**
	 * 根据hql查询分页列表
	 * 
	 * @param hql
	 * @param page
	 * @param rows
	 * @return
	 */

	public List<T> find(String hql, int page, int rows);

	/**
	 * 根据hql和参数查询分页列表
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> find(String hql, Map<String, Object> params, int page, int rows);

	/**
	 * 根据hql统计
	 * 
	 * @param hql
	 * @return
	 */
	public Long count(String hql);

	/**
	 * 根据hql和参数统计
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public Long count(String hql, Map<String, Object> params);
}
