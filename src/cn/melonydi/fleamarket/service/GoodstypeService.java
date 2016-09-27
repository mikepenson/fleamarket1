package cn.melonydi.fleamarket.service;

import java.util.List;

import cn.melonydi.fleamarket.model.Goodstype;

public interface GoodstypeService extends BaseService<Goodstype>{
	
	public List<Goodstype> queryByGoodsTypeName(String goodsTypeName);
	// 通过id更新Goodstype
	public void update(Integer id, String goodsTypeName);
	
}
