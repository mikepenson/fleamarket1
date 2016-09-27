package cn.melonydi.fleamarket.service;

import java.util.List;

import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.Subtype;

public interface SubtypeService extends BaseService<Subtype>{
	// ajax级联查询子类别
	public List<Subtype> queryByGid(int gid);
	
}
