package com.rafael.projetox.dto;

import java.io.Serializable;

import com.rafael.projetox.domain.CategoriaTeve;

public class CategoriaTeveDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CategoriaTeveDTO() {			
	}
	
	public CategoriaTeveDTO(CategoriaTeve obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
