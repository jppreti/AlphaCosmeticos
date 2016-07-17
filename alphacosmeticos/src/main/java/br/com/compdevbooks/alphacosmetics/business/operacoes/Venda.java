/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.business.operacoes;

import br.com.compdevbooks.alphacosmetics.business.ABusiness;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.IVendaDAO;

import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;


import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;

import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class Venda extends ABusiness<VendaEntity,Exception, IVendaDAO> {
    
    public Venda(IDAO<VendaEntity> dao) {
        super(dao);
    }
    public List<VendaEntity> buscarTodasVendas(){
        return ((IVendaDAO)dao).buscarTodasVendas();
    }
    
    public List<VendaEntity> buscarGerenteEstoque(ClienteEntity cliente,VendaEntity venda){
        return ((IVendaDAO)dao).buscarGerenteEstoque(cliente, venda);
    }
    public List<VendaEntity> buscarGerenteVenda(ClienteEntity cliente, VendaEntity venda){
        return ((IVendaDAO)dao).buscarGerenteVenda(cliente,venda);
    }
    public List<VendaEntity> buscarVendas(){
        return((IVendaDAO)dao).buscarVendas();
    }
    public List<VendaEntity> buscarVendasPorCliente(ClienteEntity cliente){
        return ((IVendaDAO)dao).buscarVendasPorCliente(cliente);
    }
    
    public VendaEntity pegaVenda(ItemVendaEntity item){
        return ((IVendaDAO)dao).pegaVenda(item);
    }
    
}
