package cn.melonydi.fleamarket.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.Subtype;
import cn.melonydi.fleamarket.service.GoodstypeService;
import cn.melonydi.fleamarket.service.SubtypeService;
@Service("subtypeService")
public class SubtypeServiceImpl extends BaseServiceImpl<Subtype> implements SubtypeService {

	@Override
	public List<Subtype> queryByGid(int gid) {
		// TODO Auto-generated method stub
		return subtypeDao.queryByGid(gid);
	}
}
