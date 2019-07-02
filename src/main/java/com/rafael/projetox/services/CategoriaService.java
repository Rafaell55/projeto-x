package com.rafael.projetox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.projetox.domain.Categoria;
import com.rafael.projetox.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository rep;
	
	public Categoria buscar(Integer id) {
		Categoria obj = rep.findOne(id);
		return obj;
	}

}
