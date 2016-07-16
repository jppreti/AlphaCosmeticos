/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.cadastro;

import br.com.compdevbooks.alphacosmetics.dao.IFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.endereco.MockBairroDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockProdutoDAO;
import br.com.compdevbooks.alphacosmetics.entity.endereco.EnderecoEntity;
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

    private static MockBairroDAO bairro = new MockBairroDAO();
    private static Set<ProdutoEntity> listaProduto;
    private static EnderecoEntity endereco= new EnderecoEntity("Rua das araras",332,"1029,68638-000", bairro.getById((long) 2));
    static{
        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long)1));
        listaProduto.add(produto.getById((long)2));
        lista.add(new FornecedorEntity((long) 1,"Nome 1","Fantasia 1","000","001",listaProduto , endereco));
        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long)1));
        listaProduto.add(produto.getById((long)3));
        lista.add(new FornecedorEntity((long) 2,"Nome 2","Fantasia 3","001","002",listaProduto ,endereco));
        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long)2));
        listaProduto.add(produto.getById((long)3));
        lista.add(new FornecedorEntity((long) 3,"Nome 3","Fantasia 3","002","003",listaProduto, endereco));
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
           if(vo.getFantasia().toUpperCase().contains(nome.toUpperCase()))
               return vo;
       return null;
    }
    
    @Override
    public List<FornecedorEntity> buscarTodosFornecedores(){
        return lista;
    }
}
