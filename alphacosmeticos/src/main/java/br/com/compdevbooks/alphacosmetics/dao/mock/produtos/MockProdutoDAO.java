/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.produtos;

import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockCategoriaDAO;
import br.com.compdevbooks.alphacosmetics.business.Categoria;
import br.com.compdevbooks.alphacosmetics.dao.IProdutoDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.CategoriaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class MockProdutoDAO implements IProdutoDAO {
    private static List<ProdutoVO> produtos= new ArrayList<>();
    private static MockCategoriaDAO cat= new MockCategoriaDAO();
    
  
   static {
        produtos.add(new ProdutoVO((long) 1,"One Million",(float)10.0,(float)5.0,(float)2.0, (float) 4.0,(float) 8.0,cat.getById((long) 1),null));
        produtos.add(new ProdutoVO((long) 2,"Vermelho",(float)10.0,(float)5.0,(float)2.0, (float) 4.0,(float) 8.0,cat.getById((long) 2),null));
        produtos.add(new ProdutoVO((long) 3,"head shoulder",(float)10.0,(float)5.0,(float)2.0, (float) 4.0,(float) 8.0,cat.getById((long) 2),null));
       //verificar 
        
    }   

    
    public MockProdutoDAO(){  }
    private static MockProdutoDAO singleton;
    
    public static MockProdutoDAO getInstace(){
        if(singleton==null)
            singleton= new MockProdutoDAO();
        return singleton;
    }
    @Override
    public void save(ProdutoVO entity) {
        if(produtos.indexOf(entity)<0)
            produtos.add(entity);
    }

    @Override
    public void delete(ProdutoVO entity) {
      produtos.remove(entity);
    }

    @Override
    public ProdutoVO getById(Long id) {
        for(ProdutoVO vo: produtos)
            if(vo.getId().equals(id))
                return vo;
        return null;
            
    }
    
}
