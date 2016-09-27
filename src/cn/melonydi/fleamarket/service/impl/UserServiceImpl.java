package cn.melonydi.fleamarket.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.melonydi.fleamarket.model.User;
import cn.melonydi.fleamarket.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Override
	public List<User> queryByUsername(String username,int page,int rows) {
		return userDao.queryByUsername(username,page,rows);
	}

	@Override
	public Long getCount(String username) {
		return userDao.getCount(username);
	}

	@Override
	public User login(String username) {
		return userDao.login(username);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

}
