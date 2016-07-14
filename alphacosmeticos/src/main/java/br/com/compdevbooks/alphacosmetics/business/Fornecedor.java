/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.business;

import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.IFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Fornecedor extends ABusiness<FornecedorEntity, Exception, IFornecedorDAO>{
    
    public Fornecedor(IDAO<FornecedorEntity> dao) {
        super(dao);
    }
    public FornecedorEntity getByNome(String nome){
        return ((IFornecedorDAO) dao).getByNome(nome); 
    }
    
    public FornecedorEntity getById(long id){
        return ((IFornecedorDAO) dao).getById(id); 
    }
    
    public List<FornecedorEntity> buscarTodasCategorias(){
        return ((IFornecedorDAO) dao).buscarTodosFornecedores();
    }
    
}
