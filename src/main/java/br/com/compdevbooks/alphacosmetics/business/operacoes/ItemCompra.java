/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.business.operacoes;

import br.com.compdevbooks.alphacosmetics.business.ABusiness;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.IItemCompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.IItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class ItemCompra extends ABusiness<ItemCompraEntity,Exception, IItemCompraDAO>{
    
    public ItemCompra(IDAO<ItemCompraEntity> dao) {
        super(dao);
    }
    
    public List<ItemCompraEntity> buscarTodosItemCompras(){
        return ((IItemCompraDAO)dao).buscarTodosItemCompra();
    }
    
    public List<ItemCompraEntity> buscarPorProduto(long id){
        return ((IItemCompraDAO)dao).buscarPorProduto(id);
    }
    
    public List<ItemCompraEntity> buscarItensCompra(ItemCompraEntity ic){
        return ((IItemCompraDAO)dao).buscarItensCompra(ic);
    }
}
