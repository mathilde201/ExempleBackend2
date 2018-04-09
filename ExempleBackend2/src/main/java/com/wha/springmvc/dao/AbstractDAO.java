package com.wha.springmvc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class AbstractDAO<PK extends Serializable, T>
{
	private final Class<T> persistantClass;
	
	@PersistenceContext
	
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public AbstractDAO()
	{
		this.persistantClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	protected EntityManager getEntityManager()
	{
		return this.em;
	}
	
	protected T getByKey(PK key)
	{
		return (T)em.find(persistantClass, key);
	}
	
	protected void persist(T entity)
	{
		em.persist(entity);
	}
	
	protected void update(T entity)
	{
		em.merge(entity);
	}
	
	protected void delete(T entity)
	{
		em.remove(entity);
	}
	
}
