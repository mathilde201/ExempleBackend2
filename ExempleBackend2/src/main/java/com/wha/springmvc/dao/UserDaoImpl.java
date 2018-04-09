package com.wha.springmvc.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.User;
@Repository("userDao")
public class UserDaoImpl extends AbstractDAO<Integer, User> implements UserDAO
{

	@Override
	public User findById(int id)
	{
		//User u = getByKey(id);
		return getByKey(id);
	}

	@Override
	public User findByName(String name)
	{
		System.out.println("Name : " + name);
		try
		{
			//User u = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.username LIKE :name").setParameter("name", name).getSingleResult();
			return (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.username LIKE :name").setParameter("name", name).getSingleResult();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}

	@Override
	public void save(User user)
	{
		persist(user);		
	}

	@Override
	public void deleteUserById(int id)
	{
		//User u = (User)getByKey(id);
		delete((User)getByKey(id));
	}

	@Override
	public List<User> findAllUsers()
	{
		//List<User> l = getEntityManager().createQuery("SELECT u FROM User ORDER BY u.username ASC").getResultList();
		return getEntityManager().createQuery("SELECT u FROM User u ORDER BY u.username ASC").getResultList();
	}

	@Override
	public void deleteAllusers()
	{
				
	}
	
	public void deleteBySSO(String sso)
	{
		delete((User) getEntityManager().createQuery("SELECT u FROM User WHERE u.ssiId LIKE :ssoId").setParameter("ssoId", sso).getSingleResult());
	
	}
	
	//An alternate to hibernate.initialize()
	protected void initializeCollection(Collection<?> collection)
	{
		if(collection == null)
			return;
		collection.iterator().hasNext();
	}
	
	
	
}
