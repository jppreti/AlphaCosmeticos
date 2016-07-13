/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.business.operacoes;

import br.com.compdevbooks.alphacosmetics.business.ABusiness;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.IItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;

/**
 *
 * @author Josiel
 */
public class ItemVenda extends ABusiness<ItemVendaEntity,Exception, IItemVendaDAO> {

    public ItemVenda(IDAO<ItemVendaEntity> dao) {
        super(dao);
    }
    
   
    
}
