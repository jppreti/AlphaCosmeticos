/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.business.operacoes;

import br.com.compdevbooks.alphacosmetics.business.ABusiness;
import br.com.compdevbooks.alphacosmetics.dao.ICompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;

/**
 *
 * @author Daniel
 */
public class Compra extends ABusiness<CompraEntity,Exception, ICompraDAO> {
    
    public Compra(IDAO<CompraEntity> dao) {
        super(dao);
    }
    
    public CompraEntity pegaCompra(ItemCompraEntity item){
        return ((ICompraDAO)dao).pegaCompra(item);
    }
    
}
