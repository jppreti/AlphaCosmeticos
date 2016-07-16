/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import java.util.List;

/**
 *
 * @author Josiel
 */
public interface IProdutoDAO extends IDAO<ProdutoEntity> {
    public List<ProdutoEntity> buscarTodosProdutos();

    public List<ProdutoEntity> buscarProdutos(ProdutoEntity pro);
}
