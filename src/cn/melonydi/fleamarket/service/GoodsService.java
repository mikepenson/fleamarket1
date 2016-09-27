package cn.melonydi.fleamarket.service;

import java.util.List;

import cn.melonydi.fleamarket.model.Goods;
import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.User;

public interface GoodsService extends BaseService<Goods>{
	// 通过子类别id，商品名称分页查询商品信息
	public List<Goods> queryJoinUserBySubtypeIdAndGoodsName(int sid,String goodsName,int page,int rows);
	// 根据条件分页查询商品总数
	public Long getCount(int sid, String goodsName);
	// 删除一个或者 多个商品
	public void deleteByIds(String ids);
	// 降序查询热门商品
	public List<Goods> queryByHit();
	public List<Goods> queryByGid(int gid);
	public List<Goods> queryBySid(int sid);
	
	// 更新count.tag
	public void	updateCount(int id,int hit);
	public void updateTag(int id, String tag);
	
	// 根据用户查询商品信息
	public List<Goods> queryByUid(int id);
	// 用户更新商品信息
	public void update(int id, String goodsName,String tag,Integer count);
	// 根据商品模糊查询
	public List<Goods> queryByGoodsName(String goodsName);
	public List<Goods> queryByReleaseDate();
	public List<Goods> queryByBizType();
	
}
