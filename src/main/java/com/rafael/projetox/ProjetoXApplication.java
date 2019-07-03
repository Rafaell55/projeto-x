package com.rafael.projetox;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafael.projetox.domain.Categoria;
import com.rafael.projetox.domain.CategoriaTeve;
import com.rafael.projetox.domain.Cidade;
import com.rafael.projetox.domain.Cliente;
import com.rafael.projetox.domain.Endereco;
import com.rafael.projetox.domain.Estado;
import com.rafael.projetox.domain.Pagamento;
import com.rafael.projetox.domain.PagamentoComBoleto;
import com.rafael.projetox.domain.PagamentoComCartao;
import com.rafael.projetox.domain.Pedido;
import com.rafael.projetox.domain.Produto;
import com.rafael.projetox.domain.Teve;
import com.rafael.projetox.domain.enums.EstadoPagamento;
import com.rafael.projetox.domain.enums.TipoCliente;
import com.rafael.projetox.repositories.CategoriaRepository;
import com.rafael.projetox.repositories.CategoriaTeveRepository;
import com.rafael.projetox.repositories.CidadeRepository;
import com.rafael.projetox.repositories.ClienteRepository;
import com.rafael.projetox.repositories.EnderecoRepository;
import com.rafael.projetox.repositories.EstadoRepository;
import com.rafael.projetox.repositories.PagamentoRepository;
import com.rafael.projetox.repositories.PedidoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", "2019500200" , sdf.parse("05/06/200 00:00") , TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Cliente cli2 = new Cliente(null, "Rafael Souza", "rafael-souza4@hotmail.com", "68078489005", "115144006" , sdf.parse("22/05/2015 00:00") , TipoCliente.PESSOAJURIDICA);
		cli2.getTelefones().addAll(Arrays.asList("27258000", "93573393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apt 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		Endereco e3 = new Endereco(null, "Av. 13 de Maio", "1310", null, "Benfica", "3258478", cli2, c4);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(e1, e2, e3));		
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2019 10:32") , cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2019 19:35") , cli1, e2);
		Pedido ped3 = new Pedido(null, sdf.parse("03/07/2019 11:24") , cli2, e3);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/07/2019 00:00"), null);
		ped2.setPagamento(pagto2);
		
		Pagamento pagto3 = new PagamentoComCartao(null, EstadoPagamento.CANCELADO, ped3, 3);
		ped3.setPagamento(pagto3);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		cli2.getPedidos().addAll(Arrays.asList(ped3));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2, ped3));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2, pagto3));
		
	}

}