package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Visiteur;

public interface VisiteurService
{
	void save(Visiteur visiteur);
	
	List<Visiteur> findAllVisiteurs();
}
