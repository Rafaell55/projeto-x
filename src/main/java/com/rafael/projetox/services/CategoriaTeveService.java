package com.rafael.projetox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.projetox.domain.CategoriaTeve;
import com.rafael.projetox.repositories.CategoriaTeveRepository;
import com.rafael.projetox.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaTeveService {
	
	@Autowired
	private CategoriaTeveRepository rep;
	
	public CategoriaTeve buscar(Integer id) {
		CategoriaTeve objs = rep.findOne(id);
		if (objs == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
					+ ", Tipo: " + CategoriaTeve.class.getName());
		}
		return objs;
	}
	
	public CategoriaTeve insert(CategoriaTeve obj) {
		obj.setId(null);
		return rep.save(obj);
	}

}
