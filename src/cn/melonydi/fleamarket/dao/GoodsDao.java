package cn.melonydi.fleamarket.dao;

import java.util.List;

import cn.melonydi.fleamarket.model.Goods;
import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.User;

public interface GoodsDao extends BaseDao<Goods> {
	// 通过子类别id，商品名称分页查询商品信息
	public List<Goods> queryJoinUserBySubtypeIdAndGoodsName(int sid,
			String goodsName, int page, int rows);

	// 根据条件分页查询商品总数
	public Long getCount(int sid, String goodsName);

	// 删除一个或者 多个商品
	public void deleteByIds(String ids);

	// 降序查询热门商品
	public List<Goods> queryByHit();

	public List<Goods> queryByGid(int gid);

	public List<Goods> queryBySid(int sid);

	// 根据用户查询商品信息
	public List<Goods> queryByUid(int id);

	// 更新count
	public void updateCount(int id, int hit);

	public void updateTag(int id, String tag);

	// 用户更新商品信息
	public void update(int id, String goodsName, String tag, Integer count);

	// 根据商品模糊查询
	public List<Goods> queryByGoodsName(String goodsName);
	
	public List<Goods> queryByReleaseDate();
	
	public List<Goods> queryByBizType();
}
