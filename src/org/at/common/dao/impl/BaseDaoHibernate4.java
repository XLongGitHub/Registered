package org.at.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.at.common.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDaoHibernate4<T> implements BaseDao<T> {

	private int num;
	
	private SessionFactory sessionFactory;
	
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		//return (T) getSessionFactory().getCurrentSession().load(entityClazz, id);   
//		Messages:	could not initialize proxy - no Session
		return (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
		
	}

	@Override
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		getSessionFactory().getCurrentSession().createQuery("delete " + entityClazz.getSimpleName()+" en wherer en.id = ?0")
		.setParameter(0, id).executeUpdate();
	}

	@Override
	public List<T> findAll(Class<T> entityClazz) {
//		java.lang.IllegalArgumentException: node to traverse cannot be null!   // hql 语法错误
		return getSessionFactory().getCurrentSession().createQuery("select en from " +entityClazz.getSimpleName()+" en ").list();
	}

	@Override
	public long findCount(Class<T> entityClazz) {
		List  l = getSessionFactory().getCurrentSession().createQuery("select count(*) from " + entityClazz.getSimpleName()).list();
		if (l != null && l.size() == 1) {
			return (long) l.get(0);
		}
		return -1;
	}
	
	public List<T> find(String hql) {
		return (List<T>)getSessionFactory().getCurrentSession().createQuery(hql).list();
	}
	
	/*protected List<T> find(String hql , Object... params)
	{
		// 创建查询
		Query query = getSessionFactory().getCurrentSession()
			.createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for(int i = 0 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i + "" , params[i]);      // 字符串
		}
		return (List<T>)query.list();
	}
	*/
	
	public List<T> find(String hql, Object... params) {
//		System.out.println("I'm here 4: " + this.getClass().getName() );
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) 
			//query.setParameter(i, params[i]);
			query.setParameter(i + "", params[i]);
		return query.list();
	}
	
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		return getSessionFactory().getCurrentSession().createQuery(hql)
				.setFirstResult( (pageNo-1) * pageSize).setMaxResults(pageSize).list();
	}
	
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++)
			query.setParameter(i + "", params[i]);
		return query.list();
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
//		System.out.println("sessionFactory = " + (sessionFactory != null));
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
//		System.out.println("di********");
		this.num = num;
//		System.out.println("num = "+ num +" "+this.getClass().getName());
	}

}
