/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao;

//import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;

import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import java.util.List;

/**
 *
 * @author Josiel
 */
public interface IVendaDAO extends IDAO<VendaEntity> {
    List<VendaEntity> buscarTodasVendas();
    List<VendaEntity> buscarVendas();
    List<VendaEntity> buscarVendasPorCliente(ClienteEntity cliente);
    List<VendaEntity> buscarGerenteEstoque(ClienteEntity cliente,VendaEntity venda);
    List<VendaEntity> buscarGerenteVenda(ClienteEntity cliente);
}
