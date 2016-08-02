/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import br.com.compdevbooks.alphacosmetics.entity.produto.CategoriaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;

/**
 *
 * @author Andrei
 */
public class TabelaTelaProdutos {
    
    private ProdutoEntity produto;

    public TabelaTelaProdutos(ProdutoEntity pro) {
        produto = pro;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public String getNome() {
        return produto.getNome();
    }   
    
    public String getMarca() {
        return produto.getMarca();
    }    
    
    public String getDescricao() {
        return produto.getDescricao();
    }
    
    public float getQuantidade() {
        return produto.getQuantidade();
    }
    public float getValorVenda() {
        return produto.getValorVenda();
    }
    public Long getId() {
        return produto.getId();
    }
    public float getMargemLucro() {
        return produto.getMargemLucro();
    }
    public float getPercPromocao() {
        return produto.getPercPromocao();
    }
    public float getPercComissao() {
        return produto.percComissao;
    }
    public float getValorCompra() {
        return produto.valorCompra;
    }
    public long getQtdMin() {
        return produto.qtdMin;
    }
    public long getQtdMax() {
        return produto.qtdMax;
    }
    
    public String getNomeCategoria(){
        return produto.getCategoriaVO().getNome();
    }
    
    public String getFornecedor() {
        return produto.getFornecedor().getFantasia();
    }
    
}
