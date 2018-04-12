package com.wha.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.VisiteurDAO;
import com.wha.springmvc.model.Visiteur;

@Service("visiteurService")
@Transactional
public class VisiteurServiceImpl implements VisiteurService 
{
	@Autowired
	private VisiteurDAO visiteurDao;
	
	@Override
	public void save(Visiteur visiteur) 
	{
		visiteurDao.save(visiteur);
	}

	@Override
	public List<Visiteur> findAllVisiteurs() 
	{
		return visiteurDao.findAllVisiteurs();
	}

}
