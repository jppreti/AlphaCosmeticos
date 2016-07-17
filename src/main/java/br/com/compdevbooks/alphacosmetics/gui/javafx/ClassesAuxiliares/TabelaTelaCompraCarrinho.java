/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;

public class TabelaTelaCompraCarrinho {
    private ItemCompraEntity itemCompra;
    private Compra compra= new Compra(DAOFactory.getDAOFactory().getCompraDAO());
    
    public TabelaTelaCompraCarrinho (ItemCompraEntity ic){
        itemCompra=ic;
    }

    public ItemCompraEntity getProduto(){
        return itemCompra;
    }
    public String getNome(){
        return itemCompra.getProdutoVO().getNome();
    }
    public int getQuantidade(){
        return itemCompra.getQuantidadePedida();
    }
    public String getCategoria(){
        return itemCompra.getProdutoVO().getNomeCategoria();
    }
    
    public String getFornecedor(){
        return itemCompra.getProdutoVO().getFornecedor().getFantasia();
    }
}
