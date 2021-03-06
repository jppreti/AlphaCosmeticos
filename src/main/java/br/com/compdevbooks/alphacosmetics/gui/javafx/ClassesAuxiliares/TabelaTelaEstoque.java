package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.business.operacoes.ItemCompra;
import br.com.compdevbooks.alphacosmetics.business.operacoes.ItemVenda;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoCompraEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoVendaEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TabelaTelaEstoque implements Comparable<TabelaTelaEstoque> {
    private ProdutoEntity produto;
    private ItemVenda itemVenda= new ItemVenda(DAOFactory.getDAOFactory().getItemVendaDAO());
    private ItemCompra itemCompra=new ItemCompra(DAOFactory.getDAOFactory().getItemCompraDAO());
    private Compra compra= new Compra(DAOFactory.getDAOFactory().getCompraDAO());
    private Venda venda = new Venda (DAOFactory.getDAOFactory().getVendaDAO());
    public TabelaTelaEstoque (ProdutoEntity pro){
        produto=pro;
    }
    public List<ItemVendaEntity> listaItemVenda;
    public List<ItemCompraEntity> listaItemCompra;

    public ProdutoEntity getProduto(){
        return produto;
    }
    public String getNome(){
        return produto.getNome();
    }
    public Long getQuantidade(){
        return produto.getQuantidade();
    }
    public String getCategoria(){
        return produto.getNomeCategoria();
    }
    
    public Long getQuantidadeEsperada(){
        long soma=0;
        CompraEntity compraTemp=null;
        try{
            listaItemCompra= itemCompra.buscarPorProduto(produto.getId());
            for (ItemCompraEntity vo:listaItemCompra){
               compraTemp= compra.pegaCompra(vo);
               if(!compraTemp.getSituacao().equals(SituacaoCompraEnum.PROCESSADA))
                   soma +=vo.getQuantidadePedida();
            }
            return soma;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return soma;
    }
    
    public Long getQuantidadeReservada(){
        long soma=0;
        VendaEntity vendaTemp = null;
        listaItemVenda=itemVenda.buscarPorProduto(produto.getId());
        for (ItemVendaEntity vo: listaItemVenda){
            vendaTemp = venda.pegaVenda(vo);
            if(((!vendaTemp.getSituacao().equals(SituacaoVendaEnum.RECUSADA)) && !vendaTemp.getSituacao().equals(SituacaoVendaEnum.PROCESSADA)))
                    soma+= vo.getQuantidade();
            
        }
        return soma;
    }
    
    public String getFornecedor(){
        return produto.getFornecedor().getFantasia();
    }
    @Override
    public int compareTo(TabelaTelaEstoque t) {
        int retorno =0;
        if(this==null || t==null){
            return 0;
        }
        int aux = this.estadoCritico(produto);
        if(this.getProduto().getQuantidade()<=aux && t.getProduto().getQuantidade()>aux){
            retorno=-1;
        } else if (t.getProduto().getQuantidade()<=aux && this.getProduto().getQuantidade()>aux){
            retorno=1 ;
        } else{
           retorno = this.getProduto().getNome().toUpperCase().compareTo(t.getProduto().getNome().toUpperCase());
        }
        
        return retorno;
    }
    
    public int estadoCritico(ProdutoEntity produ){
        Date data = new Date();
        int quantidade=0;
        data.setDate(data.getDate()-30);
        for (VendaEntity vo:venda.buscarTodasVendas()){
            if (vo.getDataLancamento().after(data)){
                for (ItemVendaEntity vo2: vo.getListaItens()){
                    if (vo2.getProdutoVO().getId().equals(produ.getId())){
                        quantidade = vo2.getQuantidade()+quantidade;
                    }
                }
            }
        }
        quantidade = (int) (quantidade)/10;
        return quantidade+1;
    }
}
