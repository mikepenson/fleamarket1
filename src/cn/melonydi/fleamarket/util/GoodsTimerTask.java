package cn.melonydi.fleamarket.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.melonydi.fleamarket.model.Goods;
import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.service.GoodsService;
import cn.melonydi.fleamarket.service.GoodstypeService;

/**
 * 任务：run方法中加载首页商品信息数据
 * @author mike
 *
 */
@Component
public class GoodsTimerTask extends TimerTask {

	@Resource
	private GoodsService goodsService;
	@Resource
	private GoodstypeService goodstypeService;
	
	private ServletContext application=null;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
	@Override
	public void run() {
		System.out.println("----run----");
		// 首先查询出大小类别
		List<Goodstype> goodstypeList=goodstypeService.query();
		// 其次查询热门商品
		List<Goods> hotList=goodsService.queryByHit();
		// 接着分类别（大类）查询出商品信息
		List<List<Goods>> goodsList=new ArrayList<List<Goods>>();
		for (Goodstype goodstype : goodstypeList) {
			goodsList.add(goodsService.queryByGid(goodstype.getId()));
		}
		
		// 把查询的goodstypeList  hotList goodsList交给application内置对象
		application.setAttribute("goodstypeList", goodstypeList);
		application.setAttribute("hotList", hotList);
		application.setAttribute("goodsList", goodsList);
		
	}
	
}
