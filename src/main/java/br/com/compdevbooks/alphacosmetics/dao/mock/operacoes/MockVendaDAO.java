/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.operacoes;

import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.IVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockClienteDAO;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.PagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.SituacaoPagamentoEnum;
import static br.com.compdevbooks.alphacosmetics.entity.pagamento.SituacaoPagamentoEnum.ATRASADO;
import static br.com.compdevbooks.alphacosmetics.entity.pagamento.SituacaoPagamentoEnum.NORMAL;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MockVendaDAO implements IVendaDAO {
    private static  List<VendaEntity> vendas= new ArrayList<>();
    private static MockItemVendaDAO ItemVenda= new MockItemVendaDAO();
    private static Set<ItemVendaEntity> listaItem;
    private static MockClienteDAO cliente= new MockClienteDAO();
    
    
    
    
    static{
        try {
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data= formato.parse("16/05/2016");
            listaItem= new HashSet();
            listaItem.add(ItemVenda.getById((long)1));
            listaItem.add(ItemVenda.getById((long)2));
            VendaEntity temp= new VendaEntity((long)1,data,SituacaoVendaEnum.ANALISE,listaItem);
            temp.setClienteVO(cliente.getById((long) 1));
            vendas.add(temp);
            
            data= formato.parse("30/06/2016");
            listaItem= new HashSet();
            listaItem.add(ItemVenda.getById((long)1));
            listaItem.add(ItemVenda.getById((long)3));
            temp=new VendaEntity((long) 2,data,SituacaoVendaEnum.ANALISE, listaItem);
            temp.setClienteVO(cliente.getById((long)2));
            vendas.add(temp);
            
            data= formato.parse("01/07/2016");
            listaItem= new HashSet();
            listaItem.add(ItemVenda.getById((long)2));
            listaItem.add(ItemVenda.getById((long)3));
            temp=new VendaEntity((long) 3,data,SituacaoVendaEnum.ANALISE,listaItem);
            temp.setClienteVO(cliente.getById((long)3));
            vendas.add(temp);
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
                /*vo.getClienteVO().getCNPJ().contains(cliente.getCNPJ()) &&*/
                vo.getSituacao().equals(venda.getSituacao()) &&
                vo.getDataLancamento().equals(venda.getDataLancamento()))
               res.add(vo);
       return res;
    }

    @Override
    public List<VendaEntity> buscarGerenteVenda(ClienteEntity cliente) {
        ArrayList<VendaEntity> res= new ArrayList<>();
        for(VendaEntity vo : vendas)
            if(vo.getClienteVO().getNome().toUpperCase().contains(cliente.getNome().toUpperCase()) &&
              /* vo.getClienteVO().getCNPJ().equals(cliente.getCNPJ())  &&*/
               vo.getDataLancamento().equals(vo.getDataLancamento())
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
    
    @Override
    public  List<VendaEntity> buscarTodasVendas(){
        return vendas;
    }
    
    @Override
    public List<VendaEntity> buscarVendas(){
        List<VendaEntity> temp = new ArrayList();
        for(VendaEntity vo: vendas)
            if(vo.getSituacao().equals(SituacaoVendaEnum.ANALISE))
                temp.add(vo);
        return temp;
    }
    
    @Override
    public List<VendaEntity> buscarVendasPorCliente(ClienteEntity cliente){
        List<VendaEntity> temp= new ArrayList();
        for(VendaEntity vo: vendas)
            if(vo.getClienteVO().getId().equals(cliente.getId()))
                temp.add(vo);
        return temp;
    }
    
    public List<VendaEntity> getBySituacao(SituacaoPagamentoEnum situacao ){
	List<VendaEntity> temp= new ArrayList();
        for(VendaEntity vo: vendas){
		if(vo.getPagamentoVO().getSituPagamento().equals(situacao)){
                   temp.add(vo);
                }
	}
        return temp;
    }
    //obs: rever forma pagamento
    public List<VendaEntity> getByFormaPagamento(PagamentoEntity pagamento){
	List<VendaEntity> temp= new ArrayList();
        for(VendaEntity vo: vendas){
               Set<ParcelaPagamentoEntity> parc = new HashSet<>();
               parc = vo.getPagamentoVO().getListaParcelas();
               Iterator it =parc.iterator();
               while(it.hasNext()){
                   ParcelaPagamentoEntity parcela = (ParcelaPagamentoEntity) it.next();
                   //if(parcela.getDocumentoPagamento().){
                   
                   //}
               }
	}
        return temp;
    }
    
    public float getByVencidos(){
        List<VendaEntity> temp = new ArrayList();
        float total=0;
        Date DataAtual = new Date();
        for(VendaEntity vo: vendas){
            if(vo.getPagamentoVO().getSituPagamento().equals(ATRASADO)){
               Set<ParcelaPagamentoEntity> parc = new HashSet<>();
               parc = vo.getPagamentoVO().getListaParcelas();
               Iterator it =parc.iterator();
               while(it.hasNext()){
                   ParcelaPagamentoEntity parcela = (ParcelaPagamentoEntity) it.next();
                   if(parcela.getDataVencimento().before(DataAtual)){
                       total += parcela.getValorTotalPago();
                   }
               }
            }
        }
        return total;
    }
    
    public float getByVencidos30(){
        List<VendaEntity> temp = new ArrayList();
        float total=0;
        Date DataAtual = new Date();
        DataAtual.setDate(DataAtual.getDate()+30);
        for(VendaEntity vo: vendas){
            if(vo.getPagamentoVO().getSituPagamento().equals(ATRASADO)){
               Set<ParcelaPagamentoEntity> parc = new HashSet<>();
               parc = vo.getPagamentoVO().getListaParcelas();
               Iterator it =parc.iterator();
               while(it.hasNext()){
                   ParcelaPagamentoEntity parcela = (ParcelaPagamentoEntity) it.next();
                   if(parcela.getDataVencimento().before(DataAtual)){
                       total += parcela.getValorTotalPago();
                   }
               }
            }
        }
        return total;
    }
    
    
    public float getByEmAberto(){
         List<VendaEntity> temp = new ArrayList();
        float total=0;
        Date DataAtual = new Date();
        
        for(VendaEntity vo: vendas){
            if(vo.getPagamentoVO().getSituPagamento().equals(NORMAL)){
               Set<ParcelaPagamentoEntity> parc = new HashSet<>();
               parc = vo.getPagamentoVO().getListaParcelas();
               Iterator it =parc.iterator();
               while(it.hasNext()){
                   ParcelaPagamentoEntity parcela = (ParcelaPagamentoEntity) it.next();
                   if(parcela.getDataVencimento().after(DataAtual)){
                       total += parcela.getValorTotalPago();
                   }
               }
            }
        }
        return total;
    }
    
    public VendaEntity getByCNPJ(ClienteEntity cliente){
        
        for(VendaEntity vo : vendas){
            if(vo.getClienteVO().getCNPJ().contains(cliente.getCNPJ())){
                return vo;
            }
            
        }
        return null;
    }
    
    public List<VendaEntity> getByNome(ClienteEntity cliente){
        List<VendaEntity> temp = new ArrayList();
        for(VendaEntity vo : vendas){
            if(vo.getClienteVO().getNome().toUpperCase().contains(cliente.getNome().toUpperCase())){
                temp.add(vo);
            }
            
        }
        return temp;
    }

 
    
}
