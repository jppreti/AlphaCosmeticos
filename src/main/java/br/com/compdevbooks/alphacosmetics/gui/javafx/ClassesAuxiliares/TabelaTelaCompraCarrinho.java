/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;

public class TabelaTelaCompraCarrinho {
    private ItemCompraEntity itemCompra;
    
    public TabelaTelaCompraCarrinho (ItemCompraEntity ic){
        itemCompra=ic;
    }

    public ItemCompraEntity getItemCompra(){
        return itemCompra;
    }
    public String getNome(){
        return itemCompra.getProdutoVO().getNome();
    }
    public String getNomeFornecedor(){
        return itemCompra.getProdutoVO().getFornecedor().getFantasia();
    }  
    public int getQuantidade(){
        return itemCompra.getQuantidadePedida();
    }
    public float getValorUnitario(){
        return itemCompra.getProdutoVO().getValorCompra();
    }
    
    public float getValorTotal(){
        return (itemCompra.getProdutoVO().getValorCompra() * itemCompra.getQuantidadePedida());
    }
    
    public void setQuantidade(int qtd){
        itemCompra.setQuantidadePedida(qtd);
    }
}
