package com.rafael.projetox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.projetox.domain.Pedido;
import com.rafael.projetox.repositories.PedidoRepository;
import com.rafael.projetox.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository rep;
	
	public Pedido find(Integer id) {
		Pedido obj = rep.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
					+ ", Tipo: " + Pedido.class.getName());
		}
		return obj;
	}

}
