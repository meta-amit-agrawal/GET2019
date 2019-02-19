package com.metacube.shoppingcart.Dao;

public interface BaseDao<T> {
	
	public void add(T entity);
	
	public void delete(T entity);
	
	public void update(T entity , T entity1);

	
	

}
