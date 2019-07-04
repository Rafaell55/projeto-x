package com.rafael.projetox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.projetox.domain.Categoria;
import com.rafael.projetox.repositories.CategoriaRepository;
import com.rafael.projetox.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository rep;
	
	public Categoria buscar(Integer id) {
		Categoria obj = rep.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
					+ ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return rep.save(obj);
	}

}
