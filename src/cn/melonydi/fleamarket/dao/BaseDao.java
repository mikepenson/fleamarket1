package cn.melonydi.fleamarket.dao;

import java.util.List;


/**
 * 接口级别的抽取
 * @author mike
 */
public interface BaseDao<T> {
	public void save(T t);
	public void update(T t);
	
	public void delete(int id);
	public T get(int id);
	public List<T> query();
}
