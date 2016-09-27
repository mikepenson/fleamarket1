package cn.melonydi.fleamarket.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.melonydi.fleamarket.dao.GoodstypeDao;
import cn.melonydi.fleamarket.model.Goodstype;

@SuppressWarnings("unchecked")
@Repository("goodstypeDao")
public class GoodstypeDaoImpl extends BaseDaoImpl<Goodstype> implements GoodstypeDao {

	@Override
	public List<Goodstype> queryByGoodsTypeName(String goodsTypeName) {
		String hql="from Goodstype where goodsTypeName=:goodsTypeName";
		return getSession().createQuery(hql)
				.setString("goodsTypeName", goodsTypeName)
				.list();
	}

	@Override
	public void update(Integer id, String goodsTypeName) {
		String hql="update Goodstype set goodsTypeName=:goodsTypeName where id=:id";
		getSession().createQuery(hql)
		.setString("goodsTypeName", goodsTypeName)
		.setInteger("id", id)
		.executeUpdate();
	}
	
	
}
