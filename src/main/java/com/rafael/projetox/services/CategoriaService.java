package com.rafael.projetox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rafael.projetox.domain.Categoria;
import com.rafael.projetox.repositories.CategoriaRepository;
import com.rafael.projetox.services.exceptions.DataIntegrityException;
import com.rafael.projetox.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository rep;

	public Categoria find(Integer id) {
		Categoria obj = rep.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	public Categoria update(Categoria obj) {
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
	
	public List<Categoria> findAll(){
		return rep.findAll();
	}

}
