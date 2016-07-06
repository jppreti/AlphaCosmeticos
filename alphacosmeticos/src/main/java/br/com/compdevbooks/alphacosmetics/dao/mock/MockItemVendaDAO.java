/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock;

import br.com.compdevbooks.alphacosmetics.dao.IItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class MockItemVendaDAO implements IItemVendaDAO {
    private static List<ItemVendaEntity> itens= new ArrayList();
    private static MockProdutoDAO produto = new MockProdutoDAO();
    
    static {
        itens.add(new ItemVendaEntity((long) 1, 10, (float) 5.0,(float) 5.0, produto.getById((long) 1)));
        itens.add(new ItemVendaEntity((long) 1, 25, (float) 5.0,(float) 5.0, produto.getById((long) 2)));
        itens.add(new ItemVendaEntity((long) 1, 15, (float) 5.0,(float) 5.0, produto.getById((long) 3)));
        
        
    }
    
    @Override
    public void save(ItemVendaEntity entity) {
        if(itens.indexOf(entity)<0)
            itens.add(entity);
    }

    @Override
    public void delete(ItemVendaEntity entity) {
        itens.remove(entity);
    }

    @Override
    public ItemVendaEntity getById(Long id) {
       for(ItemVendaEntity vo: itens)
           if(vo.getId().equals(id))
               return vo;
       return null;
    }
    
    
}
