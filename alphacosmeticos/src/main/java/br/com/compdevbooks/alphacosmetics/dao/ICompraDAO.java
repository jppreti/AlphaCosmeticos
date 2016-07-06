/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import java.util.List;

/**
 *
 * @author Josiel
 */
public interface ICompraDAO extends IDAO<CompraEntity> {
    List<CompraEntity> buscar(FornecedorEntity fornecedor, CompraEntity compra);
}
