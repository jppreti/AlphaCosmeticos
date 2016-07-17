/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.business;

import br.com.compdevbooks.alphacosmetics.dao.ICategoriaDAO;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.CategoriaEntity;
import java.util.List;




/**
 *
 * @author Josiel
 */
public class Categoria extends ABusiness<CategoriaEntity, Exception,ICategoriaDAO> {
    
 
    
    public Categoria(IDAO<CategoriaEntity> dao) {
        super(dao);
    }
    
    public CategoriaEntity getById(Long id){
        return ((ICategoriaDAO) dao).getById(id);
    }
    
    public List<CategoriaEntity> buscarTodasCategorias(){
        return ((ICategoriaDAO) dao).buscarTodasCategorias();
    }
    
    public CategoriaEntity getByNome(String nome){
        return ((ICategoriaDAO)dao).getByNome(nome);
    }
}
