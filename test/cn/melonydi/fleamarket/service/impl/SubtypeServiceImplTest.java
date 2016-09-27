package cn.melonydi.fleamarket.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.melonydi.fleamarket.model.Subtype;
import cn.melonydi.fleamarket.service.SubtypeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-public.xml")
public class SubtypeServiceImplTest {
	@Resource
	private SubtypeService subtypeService;

	@Test
	public void testDelete() {
		subtypeService.delete(91);
		System.out.println("还能到这里吗？？");
	}
	
	@Test
	public void testUpdate() {
		subtypeService.update(new Subtype(11, 1, "冬装"));
	}

}
