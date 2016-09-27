package cn.melonydi.fleamarket.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.melonydi.fleamarket.dao.GoodstypeDao;
import cn.melonydi.fleamarket.dao.SubtypeDao;
import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.Subtype;

@SuppressWarnings("unchecked")
@Repository("subtypeDao")
public class SubtypeDaoImpl extends BaseDaoImpl<Subtype> implements SubtypeDao {

	@Override
	public List<Subtype> queryByGid(int gid) {
		String hql="from Subtype where gid=:gid";
		return getSession().createQuery(hql)
				.setInteger("gid", gid)
				.list();
	}
	
	
}
