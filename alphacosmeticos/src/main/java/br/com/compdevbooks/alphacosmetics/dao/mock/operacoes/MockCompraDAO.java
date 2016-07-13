/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.operacoes;

import br.com.compdevbooks.alphacosmetics.dao.ICompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoCompraEnum;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josiel
 */
public class MockCompraDAO implements ICompraDAO {
   private static List<CompraEntity> compras= new ArrayList();
   private static Set<ItemCompraEntity> lista= new HashSet();
   private static MockItemCompraDAO itemCompra = new MockItemCompraDAO();
   
   
   static {
       
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
             lista.add(itemCompra.getById((long)1));
             lista.add(itemCompra.getById((long)2));
             compras.add(new CompraEntity( (long) 1, formato.parse("16/05/2016"), null, null, SituacaoCompraEnum.ENVIADA , lista));
             lista= new HashSet();
             lista.add(itemCompra.getById((long)1));
             lista.add(itemCompra.getById((long)3));
             compras.add(new CompraEntity( (long) 2, formato.parse("25/05/2016"), null, null, SituacaoCompraEnum.ENVIADA,lista ));
             lista= new HashSet();
             lista.add(itemCompra.getById((long)2));
             lista.add(itemCompra.getById((long)3));
             compras.add(new CompraEntity( (long) 3, formato.parse("30/05/2016"), null, null, SituacaoCompraEnum.ENVIADA,lista ));
             
        } catch (ParseException ex) {
            Logger.getLogger(MockCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
       
       
       
   }
    
    public MockCompraDAO(){  }
    
    private static MockCompraDAO singleton;
    
    public static MockCompraDAO getInstance(){
        if(singleton==null)
               singleton= new MockCompraDAO();
        return singleton;
    }

    @Override
    public void save(CompraEntity entity) {
        if(compras.indexOf(entity)<0)
            compras.add(entity);
    }

    @Override
    public void delete(CompraEntity entity) {
        compras.remove(entity);
    }

    @Override
    public CompraEntity getById(Long id) {
        for(CompraEntity vo:compras)
            if(vo.getId().equals(id))
                return vo;
        return null;
    }
    @Override
    public CompraEntity pegaCompra(ItemCompraEntity item){
        for(CompraEntity vo : compras){
            Iterator<ItemCompraEntity> i= vo.getListaItens().iterator();
            ItemCompraEntity it=null;
            while(i.hasNext()){
                it=i.next();
                if(it.getId().equals(item.getId()))
                    return vo;
            }
            
        }
        return null;
    }

    @Override
    public List<CompraEntity> buscar(FornecedorEntity fornecedor, CompraEntity compra) {
        ArrayList<CompraEntity> resultado= new ArrayList<>();
        
        for(CompraEntity vo: compras)
            if(vo.getFornecedorVO().getCNPJ().toUpperCase().contains(fornecedor.getCNPJ().toUpperCase()) &&
               vo.getFornecedorVO().getInscricao().toUpperCase().contains(fornecedor.getInscricao().toUpperCase()) &&
               vo.getFornecedorVO().getFantasia().toUpperCase().contains(fornecedor.getFantasia().toUpperCase()) &&
               vo.getSituacao().equals(compra.getSituacao()) && 
                vo.getDataLancamento().equals(compra.getDataLancamento()))
                resultado.add(vo);
        return resultado;
    }
    
    
    
}
