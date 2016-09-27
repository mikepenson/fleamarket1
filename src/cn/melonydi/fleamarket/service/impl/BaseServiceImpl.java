package cn.melonydi.fleamarket.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cn.melonydi.fleamarket.dao.AdminDao;
import cn.melonydi.fleamarket.dao.BaseDao;
import cn.melonydi.fleamarket.dao.GoodsDao;
import cn.melonydi.fleamarket.dao.GoodstypeDao;
import cn.melonydi.fleamarket.dao.SubtypeDao;
import cn.melonydi.fleamarket.dao.UserDao;
import cn.melonydi.fleamarket.service.BaseService;

@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {
	
	private Class clazz;	//clazz中存储了当前操作的类型
	
	public BaseServiceImpl(){
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class)type.getActualTypeArguments()[0];
	}
	@PostConstruct
	public void init() {
		// 根据clazz的类型，把不同的dao对象赋值给baseDao对象
		String clazzName=clazz.getSimpleName();
		String clazzDao=clazzName.substring(0, 1).toLowerCase()+clazzName.substring(1)+"Dao";
		
		try {
			Field clazzField=this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField=this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, clazzField.get(this));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected BaseDao baseDao; // 如果当前T account，则baseDao就是accountDao   category，则baseDao就是categoryDao
	@Resource
	protected AdminDao adminDao;
	@Resource
	protected GoodstypeDao goodstypeDao;
	@Resource
	protected SubtypeDao subtypeDao;
	@Resource
	protected GoodsDao goodsDao;
	@Resource
	protected UserDao userDao;
	
	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	
	@Override
	public T get(int id) {
		return (T) baseDao.get(id);
	}

	@Override
	public List<T> query() {
		return baseDao.query();
	}

}
