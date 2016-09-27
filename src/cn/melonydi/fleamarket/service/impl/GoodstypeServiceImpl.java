package cn.melonydi.fleamarket.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.service.GoodstypeService;
@Service("goodstypeService")
public class GoodstypeServiceImpl extends BaseServiceImpl<Goodstype> implements GoodstypeService {

	@Override
	public List<Goodstype> queryByGoodsTypeName(String goodsTypeName) {
		return goodstypeDao.queryByGoodsTypeName(goodsTypeName);
	}

	@Override
	public void update(Integer id, String goodsTypeName) {
		goodstypeDao.update(id, goodsTypeName);
	}

	
}
