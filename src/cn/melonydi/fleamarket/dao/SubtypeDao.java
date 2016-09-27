package cn.melonydi.fleamarket.dao;

import java.util.List;

import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.Subtype;

public interface SubtypeDao extends BaseDao<Subtype> {
	// ajax级联查询子类别
	public List<Subtype> queryByGid(int gid);
}
