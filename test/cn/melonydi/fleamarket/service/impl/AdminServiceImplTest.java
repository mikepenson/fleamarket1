package cn.melonydi.fleamarket.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.melonydi.fleamarket.model.Admin;
import cn.melonydi.fleamarket.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-public.xml")
public class AdminServiceImplTest {

	@Resource
	private AdminService adminService;
	
//	@Test
//	public void testSave() {
//		adminService.save(new Admin("hello", "123"));
//	}

}
