/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.cadastro;

import br.com.compdevbooks.alphacosmetics.dao.IFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockProdutoDAO;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Josiel
 */
public class MockFornecedorDAO implements IFornecedorDAO {
    private static List<FornecedorEntity> lista= new ArrayList();
    private static MockProdutoDAO produto= new MockProdutoDAO();
    private static Set<ProdutoEntity> listaProduto;
    
    static{
        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long)1));
        listaProduto.add(produto.getById((long)2));
        lista.add(new FornecedorEntity((long) 1,"Nome 1","Fantasia 1","000","001",listaProduto ));
        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long)1));
        listaProduto.add(produto.getById((long)3));
        lista.add(new FornecedorEntity((long) 2,"Nome 2","Fantasia 3","001","002",listaProduto ));
        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long)2));
        listaProduto.add(produto.getById((long)3));
        lista.add(new FornecedorEntity((long) 3,"Nome 3","Fantasia 3","002","003",listaProduto ));
    }
    
    private static MockFornecedorDAO singleton = null;
	
	public MockFornecedorDAO(){	}
	
    
    public static MockFornecedorDAO getInstance() {
		if (singleton == null)
			singleton = new MockFornecedorDAO();
		
		return singleton;
	}

    @Override
    public void save(FornecedorEntity entity) {
       if(lista.indexOf(entity)<0)
           lista.add(entity);
    }

    @Override
    public void delete(FornecedorEntity entity) {
        lista.remove(entity);
    }

    @Override
    public FornecedorEntity getById(Long id) {
       for(FornecedorEntity vo: lista)
           if(vo.getId().equals(id))
               return vo;
       return null;
    }
    
    @Override
    public FornecedorEntity getByNome(String nome) {
       for(FornecedorEntity vo: lista)
           if(vo.getFantasia().equals(nome))
               return vo;
       return null;
    }
    
    @Override
    public List<FornecedorEntity> buscarTodosFornecedores(){
        return lista;
    }
}
