package cn.melonydi.fleamarket.service.impl;

import static org.junit.Assert.*;

import java.util.Iterator;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.melonydi.fleamarket.model.User;
import cn.melonydi.fleamarket.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-public.xml")
public class UserServiceImplTest {
	@Resource
	private UserService userService;

	@Test
	public void testSave() {
		userService.save(new User("zhangsan"));
	}
	@Test
	public void testQuery() {
		for (User user : userService.queryByUsername("",1,2)) {
			System.out.println(user.getUsername());
			System.out.println(user.getUsercollects());
		}
	}
	@Test
	public void testGetCount() {
		System.out.println(userService.getCount("zhan"));
	}
	@Test
	public void testDelete() {
		userService.delete(8);
	}

}
