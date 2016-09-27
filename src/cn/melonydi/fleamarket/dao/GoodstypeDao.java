package cn.melonydi.fleamarket.dao;

import java.util.List;

import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.Subtype;

public interface GoodstypeDao extends BaseDao<Goodstype> {
	public List<Goodstype> queryByGoodsTypeName(String goodsTypeName);
	// 通过id更新Goodstype
	public void update(Integer id, String goodsTypeName);
}
