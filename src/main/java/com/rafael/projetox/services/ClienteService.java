package com.rafael.projetox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.projetox.domain.Cliente;
import com.rafael.projetox.repositories.ClienteRepository;
import com.rafael.projetox.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository rep;
	
	public Cliente buscar(Integer id) {
		Cliente obj = rep.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
					+ ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}

}
