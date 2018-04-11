package com.wha.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Visiteur;

@Repository("visiteurDao")
public class VisiteurDaoImpl extends AbstractDAO<Integer, Visiteur> implements VisiteurDAO {

	@Override
	public void save(Visiteur visiteur) 
	{
		persist(visiteur);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Visiteur> findAllVisiteurs() 
	{
		return getEntityManager().createQuery("SELECT v FROM Visiteur as v ORDER BY v.nom ASC").getResultList();
	}

}
