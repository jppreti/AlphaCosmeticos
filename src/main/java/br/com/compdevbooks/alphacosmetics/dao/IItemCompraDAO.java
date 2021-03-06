/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import java.util.List;

/**
 *
 * @author Josiel
 */
public interface IItemCompraDAO extends IDAO<ItemCompraEntity> {
    public List<ItemCompraEntity> buscarTodosItemCompra();
    
    public List<ItemCompraEntity> buscarPorProduto(Long id);

    public List<ItemCompraEntity> buscarItensCompra(ItemCompraEntity ic);
}
