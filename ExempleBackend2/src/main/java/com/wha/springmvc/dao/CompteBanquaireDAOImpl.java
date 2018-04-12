package com.wha.springmvc.dao;

import org.springframework.stereotype.Repository;



import com.wha.springmvc.model.CompteBanquaire;

@Repository("compteBanquaireDao")
public class CompteBanquaireDAOImpl extends  AbstractDAO<Integer, CompteBanquaire>  implements CompteBanquaireDAO {

	@Override
	public CompteBanquaire findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}
	
	
	

}
