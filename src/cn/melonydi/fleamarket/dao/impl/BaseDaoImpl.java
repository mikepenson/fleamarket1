package cn.melonydi.fleamarket.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import cn.melonydi.fleamarket.dao.BaseDao;

@SuppressWarnings("unchecked")
@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private Class clazz;	//clazz中存储了当前操作的类型
	
	public BaseDaoImpl(){
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class)type.getActualTypeArguments()[0];
	}
	
	@Resource	//没有指定名称默认属性的名称与id相同
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		//从当前线程创建一个session，如果没有则创建一个新的session
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		String hql="DELETE "+clazz.getSimpleName()+" WHERE id=:id";
		getSession().createQuery(hql)
			.setInteger("id", id)
			.executeUpdate();
	}

	
	@Override
	public T get(int id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		return getSession().createQuery("from "+clazz.getSimpleName()).list();
	}

}
