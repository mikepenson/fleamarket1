package cn.melonydi.fleamarket.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.melonydi.fleamarket.dao.UserDao;
import cn.melonydi.fleamarket.model.User;

@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public List<User> queryByUsername(String username,int page,int rows) {
		String hql="from User where username like:username";
		return getSession().createQuery(hql)
				.setString("username", "%"+username+"%")// 模糊查询
				.setFirstResult((page-1)*rows)
				.setMaxResults(rows)
				.list();
	}

	@Override
	public Long getCount(String username) {
		String hql="select count(*) from User where username like:username";
		return (Long) getSession().createQuery(hql)
				.setString("username", "%"+username+"%")
				.uniqueResult();
	}


	@Override
	public User login(String username) {
		String hql="from User where username=:username";
		return  (User) getSession().createQuery(hql)
				.setString("username", username)
				.uniqueResult();
	}

	@Override
	public User getUserByUsername(String username) {
		String hql="from User where username=:username";
		return (User) getSession().createQuery(hql)
				.setString("username", username)
				.uniqueResult();
	}

	@Override
	public User getUserByEmail(String email) {
		String hql="from User where email=:email";
		return (User) getSession().createQuery(hql)
				.setString("email", email)
				.uniqueResult();
	}
	
}
