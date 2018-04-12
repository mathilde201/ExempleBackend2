package com.wha.springmvc.dao;

import java.util.List;
import com.wha.springmvc.model.Visiteur;

public interface VisiteurDAO 
{

	void save(Visiteur visiteur);
	
	List<Visiteur> findAllVisiteurs();
}
