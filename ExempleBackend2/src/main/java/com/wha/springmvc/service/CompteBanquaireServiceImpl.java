package com.wha.springmvc.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.CompteBanquaireDAO;
import com.wha.springmvc.model.CompteBanquaire;



@Service("compteBanquaireService")
@Transactional
public class CompteBanquaireServiceImpl implements CompteBanquaireService{
	    
        @Autowired
		private CompteBanquaireDAO dao;

		@Override
		public CompteBanquaire findById(int id) {
			// TODO Auto-generated method stub
			return dao.findById((int)id);
		
		}


}
