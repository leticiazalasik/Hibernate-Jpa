package br.com.padaria.service;

import java.util.List;

import br.com.padaria.DAO.GenericDao;
import br.com.padaria.model.Produto;
public class ProdutoService {
	
	
private GenericDao<Produto> dao = new GenericDao<Produto>();
	
	public void salvar(Produto produto) { 
		dao.salvar(produto);
		
	}
	
	public void alterar(Produto produto) { 
		dao.alterar(produto);
	}
	
	public void deletar (Produto produto) { 
		dao.deletar(Produto.class, produto.getId());
	}

	public Produto buscarPorId(int id) { 
		return dao.buscarPorId(Produto.class, id); 
		
	}
	
	public List <Produto> buscarTodos(){ 
		String jpql = " SELECT c FROM Produto c ORDER BY c.descricao"; 
		return dao.buscarTodos(jpql); 
	}

}
