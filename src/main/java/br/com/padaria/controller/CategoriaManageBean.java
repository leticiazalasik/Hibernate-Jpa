package br.com.padaria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.padaria.model.Categoria;
import br.com.padaria.service.CategoriaService;

@ViewScoped
@ManagedBean(name="categoriaMB")
public class CategoriaManageBean {

	//Instâncias necessárias para a controller 
	CategoriaService service = new CategoriaService();
	Categoria categoria = new Categoria();
	List<Categoria> categorias = new ArrayList<Categoria>();
	
//Métodos CRUD 
	public String salvar() { 
		service.salvar(categoria);
		categoria = new Categoria();
		return "/categoria/listar.xhtml"; 
	}
	
	public String alterar() { 
		service.alterar(categoria);
		categoria = new Categoria(); 
		return "/categoria/listar.xhtml"; 
	}
	
	public void buscarTodos() { 
		categorias = service.buscarTodos();
	}
	
	public void buscarPorId() {
		categoria = service.buscarPorId(categoria.getId());
	}
	
	public String deletar (Categoria c) { 
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
}
