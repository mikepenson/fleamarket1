package cn.melonydi.fleamarket.service;

import java.util.List;


/**
 * 接口级别的抽取
 * @author mike
 */
public interface BaseService<T> {
	public void save(T t);
	public void update(T t);
	
	public void delete(int id);
	public T get(int id);
	public List<T> query();
}
