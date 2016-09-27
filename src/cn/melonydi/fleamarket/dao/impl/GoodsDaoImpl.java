package cn.melonydi.fleamarket.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.melonydi.fleamarket.dao.GoodsDao;
import cn.melonydi.fleamarket.model.Goods;
import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.User;
@SuppressWarnings("unchecked")
@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao {

	public List<Goods> queryJoinUserBySubtypeIdAndGoodsName(int sid,String goodsName,int page,int rows){
		String hql=null;
		if (sid==0) {
			hql="from Goods g left join fetch g.user where g.goodsName like:goodsName";
			return getSession().createQuery(hql)
					.setString("goodsName", "%"+goodsName+"%")
					.setFirstResult((page-1)*rows)
					.setMaxResults(rows)
					.list();
		}
		hql="from Goods g left join fetch g.user where g.goodsName like:goodsName and g.sid=:sid";
		return getSession().createQuery(hql)
				.setString("goodsName", "%"+goodsName+"%")
				.setInteger("sid", sid)
				.setFirstResult((page-1)*rows)
				.setMaxResults(rows)
				.list();
	}

	@Override
	public Long getCount(int sid, String goodsName) {
		String hql=null;
		if (sid==0) {
			hql="select count(*) from Goods where goodsName like:goodsName";
			return (Long) getSession().createQuery(hql)
					.setString("goodsName", "%"+goodsName+"%")
					.uniqueResult();
		}
		hql="select count(*) from Goods where goodsName like:goodsName and sid=:sid";
		return (Long) getSession().createQuery(hql)
				.setString("goodsName", "%"+goodsName+"%")
				.setInteger("sid", sid)
				.uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		String hql="delete from Goods where id in ("+ids+")";
		getSession().createQuery(hql)
		.executeUpdate();
	}

	@Override
	public List<Goods> queryByHit() {
		String hql="from Goods where bizType=:bizType and tag=:tag order by hit desc";
		return getSession().createQuery(hql)
		.setString("bizType", "0")
		.setString("tag", "0")
		.setFirstResult(0)
		.setMaxResults(4)
		.list();
	}

	@Override
	public List<Goods> queryByGid(int gid) {
		String hql="from Goods where gid=:gid and bizType=:bizType and tag=:tag order by releaseDate desc";
		return getSession().createQuery(hql)
		.setInteger("gid", gid)
		.setString("bizType", "0")
		.setString("tag", "0")
		.list();
	}

	@Override
	public List<Goods> queryBySid(int sid) {
		String hql="from Goods where sid=:sid and bizType=:bizType and tag=:tag order by releaseDate desc";
		return getSession().createQuery(hql)
		.setInteger("sid", sid)
		.setString("bizType", "0")
		.setString("tag", "0")
		.list();
	}

	@Override
	public void updateCount(int id, int hit) {
		String hql="update Goods set hit=:hit where id=:id";
		getSession().createQuery(hql)
		.setInteger("hit", hit)
		.setInteger("id", id)
		.executeUpdate();
	}

	@Override
	public List<Goods> queryByUid(int uid) {
		String hql="from Goods where uid=:uid order by releaseDate desc";
		return getSession().createQuery(hql)
				.setParameter("uid", uid)
				.list();
	}

	@Override
	public void updateTag(int id, String tag) {
		String hql="update Goods set tag=:tag where id=:id";
		getSession().createQuery(hql)
		.setString("tag", tag)
		.setInteger("id", id)
		.executeUpdate();
	}

	@Override
	public void update(int id, String goodsName,String tag,Integer count) {
		String hql="update Goods set goodsName=:goodsName,tag=:tag,price=:count where id=:id";
		getSession().createQuery(hql)
		.setString("goodsName", goodsName)
		.setString("tag", tag)
		.setInteger("price", count)
		.setInteger("id", id)
		.executeUpdate();
	}

	@Override
	public List<Goods> queryByGoodsName(String goodsName) {
		String hql="from Goods where goodsName like:goodsName and tag=:tag order by releaseDate desc";
		return getSession().createQuery(hql)
		.setString("goodsName", "%"+goodsName+"%")
		.setString("tag", "0")
		.list();
	}
	@Override
	public List<Goods> queryByReleaseDate() {
		String hql="from Goods where tag=:tag order by releaseDate desc";
		return getSession().createQuery(hql)
				.setString("tag", "0")
				.list();
	}

	@Override
	public List<Goods> queryByBizType() {
		String hql="from Goods where bizType=:bizType and tag=:tag";
		return getSession().createQuery(hql)
		.setString("bizType", "1")
		.setString("tag", "0")
		.list();
	}

}
