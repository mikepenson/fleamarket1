package cn.melonydi.fleamarket.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.melonydi.fleamarket.model.Goods;
import cn.melonydi.fleamarket.model.User;

@Controller
@Scope("prototype")
public class GoodsAction extends BaseAction<Goods> {
	// 接受页面传来的sid，默认是0

	public String queryJoinUserBySubtypeIdAndGoodsName() {
		// 创建jsonMap
		jsonMap=new HashMap<String, Object>();
		// 根据条件分页查询商品列表
//		System.out.println("sid="+model.getSid());
		List<Goods> goodsList=goodsService.queryJoinUserBySubtypeIdAndGoodsName(model.getSid(), model.getGoodsName(), page, rows);
		// 根据条件分页查询商品总数
		Long total=goodsService.getCount(model.getSid(),model.getGoodsName());
		// 封装数据到jsonMap中，在struts.xml中将jsonMap转化成json格式
		jsonMap.put("total", total);
		jsonMap.put("rows", goodsList);
		return "jsonMap";
	}
	
	public String deleteByIds() {
		System.out.println("ids:"+ids);
		goodsService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public String queryBySid() {
		List<Goods> goodsList=new ArrayList<Goods>();
		goodsList=goodsService.queryBySid(model.getSid());
		if (goodsList.size()==0) {
			goodsList=null;
		}
		request.put("goodsList", goodsList);
		return "goodsList";
	}
	
	public String queryByGoodsName() {
		List<Goods> goodsList=new ArrayList<Goods>();
		goodsList=goodsService.queryByGoodsName(model.getGoodsName());
		if (goodsList.size()==0) {
			goodsList=null;
		}
		request.put("goodsList", goodsList);
		return "goodsList";
	}
	
	public String queryByReleaseDate() {
		List<Goods> goodsList=new ArrayList<Goods>();
		goodsList=goodsService.queryByReleaseDate();
		if (goodsList.size()==0) {
			goodsList=null;
		}
		request.put("goodsList", goodsList);
		return "goodsList";
	}
	
	public String queryByBizType() {
		List<Goods> goodsList=new ArrayList<Goods>();
		goodsList=goodsService.queryByBizType();
		if (goodsList.size()==0) {
			goodsList=null;
		}
		request.put("goodsList", goodsList);
		return "goodsList";
	}
	
	public String get() {
		goodsService.updateCount(model.getId(), model.getHit()+1);
		Goods goods=goodsService.get(model.getId());
		request.put("goods", goods);
		return "goodsInfo";
	}
	
	public void save() {
		String imgUrl=fileUpload.uploadFile(fileImage);
		User user=(User) session.get("user");
		model.setImgUrl(imgUrl);
		model.setTag("0");
		model.setHit(0);
		model.setUser(user);
		// 商品信息入库
		goodsService.save(model);
	}
	
	public String queryByUid() {
		List<Goods> goodsList=new ArrayList<Goods>();
//		System.out.println("username:"+((User)session.get("user")).getUsername()+"uid:"+model.getUid());
		if (session.get("user")==null) {
			return "login";
		}
		goodsList=goodsService.queryByUid(((User)session.get("user")).getId());
		if (goodsList.size()==0) {
			goodsList=null;
		}
		request.put("goodsList", goodsList);
		return "myGoods";
	}
	
	public String getById() {
		request.put("goods", goodsService.get(model.getId()));
		return "update";
	}
	
	public String updateTag() {
		goodsService.updateTag(model.getId(),model.getTag());
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public String update() {
		System.out.println(model.toString());
		goodsService.update(model);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
}
