package cn.melonydi.fleamarket.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.melonydi.fleamarket.model.Goods;
import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.User;
import cn.melonydi.fleamarket.service.GoodsService;
@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

	@Override
	public List<Goods> queryJoinUserBySubtypeIdAndGoodsName(int sid,String goodsName,int page,int rows) {
		return goodsDao.queryJoinUserBySubtypeIdAndGoodsName(sid, goodsName, page, rows);
	}

	@Override
	public Long getCount(int sid, String goodsName) {
		// TODO Auto-generated method stub
		return goodsDao.getCount(sid, goodsName);
	}

	@Override
	public void deleteByIds(String ids) {
		goodsDao.deleteByIds(ids);
	}

	@Override
	public List<Goods> queryByHit() {
		return goodsDao.queryByHit();
	}

	@Override
	public List<Goods> queryByGid(int gid) {
		// TODO Auto-generated method stub
		return goodsDao.queryByGid(gid);
	}

	@Override
	public List<Goods> queryBySid(int sid) {
		return goodsDao.queryBySid(sid);
	}

	@Override
	public void updateCount(int id, int hit) {
		goodsDao.updateCount(id, hit);
	}

	@Override
	public List<Goods> queryByUid(int uid) {
		return goodsDao.queryByUid(uid);
	}

	@Override
	public void updateTag(int id, String tag) {
		goodsDao.updateTag(id, tag);
	}

	@Override
	public void update(int id, String goodsName,String tag,Integer count) {
		goodsDao.update(id, goodsName, tag,count);
	}

	@Override
	public List<Goods> queryByGoodsName(String goodsName) {
		return goodsDao.queryByGoodsName(goodsName);
	}

	@Override
	public List<Goods> queryByReleaseDate() {
		// TODO Auto-generated method stub
		return goodsDao.queryByReleaseDate();
	}

	@Override
	public List<Goods> queryByBizType() {
		// TODO Auto-generated method stub
		return goodsDao.queryByBizType();
	}

}
