/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.operacoes;

import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.IVendaDAO;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoVendaEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josiel
 */
public class MockVendaDAO implements IVendaDAO {
    private static  List<VendaEntity> vendas= new ArrayList<>();
    private static MockItemVendaDAO ItemVenda= new MockItemVendaDAO();
    private static Set<ItemVendaEntity> listaItem= new HashSet();
    
    
    
    static{
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data= formato.parse("16/05/2016");
            listaItem.add(ItemVenda.getById((long)1));
            listaItem.add(ItemVenda.getById((long) 2));
            vendas.add(new VendaEntity(1L,data,SituacaoVendaEnum.ANALISE,listaItem));
            data= formato.parse("30/06/2016");
            listaItem= new HashSet();
            listaItem.add(ItemVenda.getById((long)1));
            listaItem.add(ItemVenda.getById((long) 3));
            vendas.add(new VendaEntity(1L,data,SituacaoVendaEnum.ANALISE, listaItem));
            data= formato.parse("01/07/2016");
            listaItem= new HashSet();
            listaItem.add(ItemVenda.getById((long)2));
            listaItem.add(ItemVenda.getById((long) 3));
            vendas.add(new VendaEntity(1L,data,SituacaoVendaEnum.ANALISE,listaItem));
            
        } catch (ParseException ex) {
            Logger.getLogger(MockVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    private static MockVendaDAO singleton;
    public MockVendaDAO(){  }
    
    public static MockVendaDAO getInstace(){
        if(singleton==null) singleton=new MockVendaDAO();
        return singleton;
    
    }

    @Override
    public List<VendaEntity> buscarGerenteEstoque(ClienteEntity cliente, VendaEntity venda) {
       ArrayList<VendaEntity> res= new ArrayList<>();
       for(VendaEntity vo: vendas)
           if( vo.getClienteVO().getNome().toUpperCase().contains(cliente.getNome().toUpperCase()) &&
                vo.getClienteVO().getCNPJ().contains(cliente.getCNPJ()) &&
                vo.getSituacao().equals(venda.getSituacao()) &&
                vo.getDataLancamento().equals(venda.getDataLancamento()))
               res.add(vo);
       return res;
    }

    @Override
    public List<VendaEntity> buscarGerenteVenda(ClienteEntity cliente, VendaEntity venda) {
        ArrayList<VendaEntity> res= new ArrayList<>();
        for(VendaEntity vo : vendas)
            if(vo.getClienteVO().getNome().toUpperCase().contains(cliente.getNome().toUpperCase()) &&
               vo.getClienteVO().getCNPJ().equals(cliente.getCNPJ())  &&
               vo.getDataLancamento().equals(venda.getDataLancamento())
                    )
                res.add(vo);
        return res;
    }

    @Override
    public void save(VendaEntity entity) {
       if(vendas.indexOf(entity)<0)
           vendas.add(entity);
    }

    @Override
    public void delete(VendaEntity entity) {
        vendas.remove(entity);
    }

    @Override
    public VendaEntity getById(Long id) {
       for(VendaEntity vo: vendas)
           if(vo.getId().equals(id))
               return vo;
       return null;
    }
    
  

    
}
