package com.rafael.projetox;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafael.projetox.domain.Categoria;
import com.rafael.projetox.domain.CategoriaTeve;
import com.rafael.projetox.domain.Cidade;
import com.rafael.projetox.domain.Estado;
import com.rafael.projetox.domain.Produto;
import com.rafael.projetox.domain.Teve;
import com.rafael.projetox.repositories.CategoriaRepository;
import com.rafael.projetox.repositories.CategoriaTeveRepository;
import com.rafael.projetox.repositories.CidadeRepository;
import com.rafael.projetox.repositories.EstadoRepository;
import com.rafael.projetox.repositories.ProdutoRepository;
import com.rafael.projetox.repositories.TeveRepository;

@SpringBootApplication
public class ProjetoXApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private CategoriaTeveRepository categoriaTeveRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private TeveRepository teveRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoXApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Internet");
		CategoriaTeve cat2 = new CategoriaTeve(null, "TV");
		
		Produto p1 = new Produto(null, "35 Megas", "35 MEGAS", "4 MEGAS", 59.90, "6 MESES");
		Produto p2 = new Produto(null, "50 Megas", "50 MEGAS", "10 MEGAS", 69.90, "6 MESES");
		Produto p3 = new Produto(null, "100 Megas", "100 MEGAS", "15 MEGAS", 74.90, "6 MESES");
		Produto p4 = new Produto(null, "150 Megas", "150 MEGAS", "23 MEGAS", 99.90, "6 MESES");
		
		Teve t1 = new Teve(null, "Super HD", "41 Canais", 25.90);
		Teve t2 = new Teve(null, "Ultra HD", "61 Canais", 65.90);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4));
		cat2.getTeves().addAll(Arrays.asList(t1, t2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		
		t1.getCategoriasteve().addAll(Arrays.asList(cat2));
		t2.getCategoriasteve().addAll(Arrays.asList(cat2));		
		
		categoriaRepository.save(Arrays.asList(cat1));
		categoriaTeveRepository.save(cat2);
		produtoRepository.save(Arrays.asList(p1, p2, p3, p4));
		teveRepository.save(Arrays.asList(t1,t2));
		
		Estado est1 = new Estado(null, "Minas Gerasis");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Ceará");
		
		Cidade c1 = new Cidade(null, "Underlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Fortaleza", est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		est3.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.save(Arrays.asList( est1, est2, est3));
		cidadeRepository.save(Arrays.asList(c1, c2, c3, c4));
	}

}