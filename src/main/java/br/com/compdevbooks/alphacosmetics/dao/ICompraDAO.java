/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Josiel
 */
public interface ICompraDAO extends IDAO<CompraEntity> {
    List<CompraEntity> buscar(FornecedorEntity fornecedor, CompraEntity compra);
     CompraEntity pegaCompra(ItemCompraEntity item);
    List<CompraEntity> buscarTodasCompras();
    Set<ItemCompraEntity> pegarItemCompra();
    List<CompraEntity> buscarPedidoCompra(FornecedorEntity f, CompraEntity c);
}
