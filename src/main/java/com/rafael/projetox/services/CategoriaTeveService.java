package com.rafael.projetox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.projetox.domain.CategoriaTeve;
import com.rafael.projetox.repositories.CategoriaTeveRepository;

@Service
public class CategoriaTeveService {
	
	@Autowired
	private CategoriaTeveRepository rep;
	
	public CategoriaTeve buscar(Integer id) {
		CategoriaTeve objs = rep.findOne(id);
		return objs;
	}

}
