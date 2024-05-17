package br.com.padaria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.padaria.model.Produto;
import br.com.padaria.service.ProdutoService;

@ViewScoped
@ManagedBean(name="produtoMB")
public class ProdutoManageBean {
	
	//Instâncias necessárias para a controller 
		ProdutoService service = new ProdutoService();
		Produto produto = new Produto();
		List<Produto> categorias = new ArrayList<Produto>();
		
	//Métodos CRUD 
		public String salvar() { 
			service.salvar(produto);
			produto = new Produto();
			return "/produto/listar.xhtml"; 
		}
		
		public String alterar() { 
			service.alterar(produto);
			produto = new Produto(); 
			return "/produto/listar.xhtml"; 
		}
		
		public void buscarTodos() { 
			categorias = service.buscarTodos();
		}
		
		public void buscarPorId() {
			produto = service.buscarPorId(produto.getId());
		}
		
		public String deletar (Produto c) { 
			service.deletar(c);
			buscarTodos(); 
			return null; 
		}
		
		//Método executado ao carregar a controller no navegador 
		@PostConstruct
		public void Inicio() { 
			buscarTodos();
		}
		

		//Getters and Setters 

		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}

		public List<Produto> getCategorias() {
			return categorias;
		}

		public void setCategorias(List<Produto> categorias) {
			this.categorias = categorias;
		}

	
}
