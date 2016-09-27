package cn.melonydi.fleamarket.service;

import java.util.List;

import cn.melonydi.fleamarket.model.User;


public interface UserService extends BaseService<User>{
	// 根据关键字分页查询用户信息
	public List<User> queryByUsername(String username,int page,int rows);
	// 根据关键字查询用户数量
	public Long getCount(String username);
	public User login(String username);
	// 根据姓名查询出用户
	public User getUserByUsername(String username);
	// 根据邮箱查询出用户
	public User getUserByEmail(String email);	
	
}	
