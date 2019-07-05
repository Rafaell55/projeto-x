package com.rafael.projetox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rafael.projetox.domain.CategoriaTeve;
import com.rafael.projetox.repositories.CategoriaTeveRepository;
import com.rafael.projetox.services.exceptions.DataIntegrityException;
import com.rafael.projetox.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaTeveService {
	
	@Autowired
	private CategoriaTeveRepository rep;
	
	public CategoriaTeve find(Integer id) {
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
	
	public CategoriaTeve update(CategoriaTeve obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			rep.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public List<CategoriaTeve> findAll(){
		return rep.findAll();
	}

}
