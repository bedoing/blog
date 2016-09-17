package org.bedoing.blog.mybatis;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MyBatisDAO extends SqlSessionDaoSupport {

	public int save(String key, Object object){
		return getSqlSession().insert(key, object);
	}
	
	public int delete(String key, Serializable id){
		return getSqlSession().delete(key, id);
	}
	
	public int delete(String key, Object object){
		return getSqlSession().delete(key, object);
	}
	
	public int update(String key, Object params){
		return getSqlSession().update(key, params);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key){
		return (T) getSqlSession().selectOne(key);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key, Object params){
		return (T) getSqlSession().selectOne(key, params);
	}
	
	public <T> List<T> getList(String key){
		return getSqlSession().selectList(key);
	}
	
	public <T> List<T> getList(String key, Object params){
		return getSqlSession().selectList(key, params);
	}
}
