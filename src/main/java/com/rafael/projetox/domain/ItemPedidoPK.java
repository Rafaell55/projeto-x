package com.rafael.projetox.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class ItemPedidoPK implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;	
	
	@ManyToOne
	@JoinColumn(name ="produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "teve_id")
	private Teve teve;	
		
	public Teve getTeve() {
		return teve;
	}
	public void setTeve(Teve teve) {
		this.teve = teve;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((teve == null) ? 0 : teve.hashCode());
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
		ItemPedidoPK other = (ItemPedidoPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (teve == null) {
			if (other.teve != null)
				return false;
		} else if (!teve.equals(other.teve))
			return false;
		return true;
	}
	
	
	
	

}