package com.rafael.projetox.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Teve  implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String pacote;
	private Double preco;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "TEVE_CATEGORIA", // Mapeamento da lista de Categorias
			joinColumns = @JoinColumn(name = "tv_id"), // informando a chave primaria do produto
			inverseJoinColumns = @JoinColumn(name = "categoriatv_id") // informando a chave primaria da categoria
	)
	private List<CategoriaTeve> categoriasteve = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.teve")
	private Set<ItemPedido> itens = new HashSet<>();

	public Teve() {
	}

	public Teve(Integer id, String nome, String pacote, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.pacote = pacote;
		this.preco = preco;
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> lista = new ArrayList<>();
		for (ItemPedido x : itens) {
			lista.add(x.getPedido());
		}
		return lista;
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

	public String getPacote() {
		return pacote;
	}

	public void setPacote(String pacote) {
		this.pacote = pacote;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public List<CategoriaTeve> getCategoriasteve() {
		return categoriasteve;
	}

	public void setCategoriasteve(List<CategoriaTeve> categoriasteve) {
		this.categoriasteve = categoriasteve;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teve other = (Teve) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}