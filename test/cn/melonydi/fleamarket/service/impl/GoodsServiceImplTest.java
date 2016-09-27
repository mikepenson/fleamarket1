package cn.melonydi.fleamarket.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

import cn.melonydi.fleamarket.model.Goods;
import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.Subtype;
import cn.melonydi.fleamarket.service.GoodsService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-public.xml")
public class GoodsServiceImplTest {
	@Resource
	private GoodsService goodsService;

	@Test
	public void testSave() {
	}
	@Test
	public void testGetbyUid() {
		goodsService.update(16, "adsf","1",new Integer(12));
	}
	
	@Test
	public void testGetByUid() {
		System.out.println(goodsService.queryByUid(1).get(0).getGoodsName());
	}
	
	@Test
	public void testGet(){
		System.out.println(goodsService.get(1).getGoodsName());
	}
	
	@Test
	public void testDelete(){
		goodsService.delete(11);
	}
	@Test
	public void testUpdate(){
		goodsService.updateCount(16, 16);
	}
	
	@Test
	public void testQuery() {
		for (Goods goods : goodsService.query()) {
			System.out.println(goods.getGoodsName());
		}
	}
	@Test
	public void tesQueryBySubtypeIdAndGoodsName() {
		List<Goods> list=goodsService
				.queryJoinUserBySubtypeIdAndGoodsName(1, "", 2, 1);
		for (Goods goods : list) {
			System.out.println(goods.getGoodsName());
		}
	}
	@Test
	public void tesGetCount() {
		System.out.println(goodsService.getCount(1, ""));
	}
	@Test
	public void tesDeleteByIds() {
		goodsService.deleteByIds("3,4");
	}
	@Test
	public void testGueryByHit() {
		for (Goods goods : goodsService.queryByHit()) {
			System.out.println(goods.getGoodsName());
		}
	}

	
	@Test
	public void testQueryByGid(){
		for (Goods goods : goodsService.queryByGid(3)) {
			if (goods==null) {
				System.out.println("I am null!");
			}
			System.out.println(goods.getGoodsName());
		}
	}
	@Test
	public void testQueryBySid(){
		List<Goods> goodsList=goodsService.queryBySid(1);
		if (goodsList.size()==0) {
			System.out.println("is null");
			return;
		}
		for (Goods goods : goodsList) {
			if (goods==null) {
				System.out.println("I am null!");
			}
			System.out.println(goods.getGoodsName());
		}
	}
	
	@Test
	public void test(){
		System.out.println(goodsService.queryByGoodsName("全网通").get(0).getGoodsName());
	}
	
	
}
