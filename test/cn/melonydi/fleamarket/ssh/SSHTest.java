package cn.melonydi.fleamarket.ssh;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.melonydi.fleamarket.model.Admin;
import cn.melonydi.fleamarket.service.AdminService;
import cn.melonydi.fleamarket.service.impl.AdminServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-public.xml")
public class SSHTest {

	@Resource
	private Date date;
	
	@Test
	public void testSSH() {
		System.out.println(date);
	}

//	@Test
//	public void testHibernate(){
//		AdminService adminService=new AdminServiceImpl();
//		Admin admin=new Admin("mike", "123");
//		adminService.save(admin);
//		
//	}
//	@Test
//	public void testHibernate_Spring(){
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-public.xml");
//		AdminService adminService=(AdminService) context.getBean("adminService");
//		Admin admin=new Admin("penson", "123");
//		adminService.save(admin);
//		
//	}
}
