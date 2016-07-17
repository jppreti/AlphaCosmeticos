/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.business;

import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.IVendedorDAO;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.VendedorEntity;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Vendedor extends ABusiness<VendedorEntity, Exception, IVendedorDAO>{
    
    public Vendedor(IDAO<VendedorEntity> dao) {
        super(dao);
    }
    
    public List<VendedorEntity> getByNome(String nome){
        return ((IVendedorDAO) dao).getByNome(nome); 
    }

    
    public List<VendedorEntity> buscarTodosVendedores(){
        return ((IVendedorDAO) dao).buscarTodosVendedores();
    }
}
