package cn.melonydi.fleamarket.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.Subtype;
import cn.melonydi.fleamarket.service.GoodstypeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-public.xml")
public class GoodstypeServiceImplTest {
	
	@Resource
	private GoodstypeService goodstypeService;

	@Test
	public void testQuery() {
		List<Goodstype> list=goodstypeService.query();
		System.out.println(list.size());
		Iterator<Goodstype> iterator=list.iterator();
		while (iterator.hasNext()) {
			Goodstype goodstype=iterator.next();
			System.out.println(goodstype.getGoodsTypeName());
			for (Subtype subtype : goodstype.getSubtypes()) {
				System.out.println(" -"+subtype.getSubTypeName());
			}
		}
	}
	
	@Test
	public void testUpdate() {
		goodstypeService.update(15, "数码产品");
	}

}
