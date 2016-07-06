/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.operacoes;

import br.com.compdevbooks.alphacosmetics.dao.IItemCompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockProdutoDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class MockItemCompraDAO implements IItemCompraDAO {
    private static List<ItemCompraEntity> lista= new ArrayList();
    private static MockProdutoDAO produto = new MockProdutoDAO();
    
    static {
        lista.add(new ItemCompraEntity((long) 1, 10, produto.getById((long) 1)));
        lista.add(new ItemCompraEntity((long) 2, 10, produto.getById((long) 2)));
        lista.add(new ItemCompraEntity((long) 3, 10, produto.getById((long) 3)));
    }

    @Override
    public void save(ItemCompraEntity entity) {
       if(lista.indexOf(entity)<0)
           lista.add(entity);
    }

    @Override
    public void delete(ItemCompraEntity entity) {
        lista.remove(entity);
    }

    @Override
    public ItemCompraEntity getById(Long id) {
        for(ItemCompraEntity vo: lista)
            if(vo.getId().equals(id))
                return vo;
        return null;
    }
    
}
