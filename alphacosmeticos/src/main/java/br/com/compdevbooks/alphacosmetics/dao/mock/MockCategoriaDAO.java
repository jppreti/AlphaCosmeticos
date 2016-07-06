/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock;

import br.com.compdevbooks.alphacosmetics.dao.ICategoriaDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.CategoriaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class MockCategoriaDAO implements ICategoriaDAO {
    private static List<CategoriaEntity> categorias= new ArrayList();
    static {
        categorias.add(new CategoriaEntity((long) 1 ,"Perfume",(float)10.0,(float)10.0, (float)10.0,null));
        categorias.add(new CategoriaEntity((long) 2,"Batão",(float)10.0,(float)10.0, (float)10.0,null));
        categorias.add(new CategoriaEntity((long) 3 ,"Shampoo",(float)10.0,(float)10.0, (float)10.0,null));
    }
            
    public MockCategoriaDAO(){  }
    
    private static MockCategoriaDAO singleton;
    
    public static MockCategoriaDAO getInstace(){
        if(singleton==null)
            singleton=new MockCategoriaDAO();
        return singleton;
    }
    
    @Override
    public void save(CategoriaEntity entity) {
        if(categorias.indexOf(entity)<0)
            categorias.add(entity);
    }

    @Override
    public void delete(CategoriaEntity entity) {
       categorias.remove(entity);
    }

    @Override
    public CategoriaEntity getById(Long id) {
       for(CategoriaEntity vo: categorias)
           if(vo.getId().equals(id))
               return vo;
       return null;
    }
    
}
