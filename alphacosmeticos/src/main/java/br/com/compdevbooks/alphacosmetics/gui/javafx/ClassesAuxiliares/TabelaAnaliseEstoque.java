/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.business.operacoes.ItemCompra;
import br.com.compdevbooks.alphacosmetics.business.operacoes.ItemVenda;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoCompraEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoVendaEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class TabelaAnaliseEstoque {
    private ItemVendaEntity item;
    private ItemCompra itemCompra= new ItemCompra(DAOFactory.getDAOFactory().getItemCompraDAO());
    private Compra compra= new Compra(DAOFactory.getDAOFactory().getCompraDAO());
    private ItemVenda itemVenda= new ItemVenda(DAOFactory.getDAOFactory().getItemVendaDAO());
    private Venda venda= new Venda(DAOFactory.getDAOFactory().getVendaDAO());
    public TabelaAnaliseEstoque(ItemVendaEntity item){
        this.item=item;
    }
    public Long getId(){
        return item.getProdutoVO().getId();
    }
    public String getProduto(){
        return item.getProdutoVO().getNome();
    }
    public Long getEstoque(){
        return item.getProdutoVO().getQuantidade();
    }
    public int getPedida(){
        return item.getQuantidade();
    }
   public Float getQtdeReservada(){
        float soma=0;
        VendaEntity vendaTemp = null;
        List<ItemVendaEntity>listaItemVenda=itemVenda.buscarPorProduto(item.getProdutoVO().getId());
        for (ItemVendaEntity vo: listaItemVenda){
            vendaTemp = venda.pegaVenda(vo);
            if(((!vendaTemp.getSituacao().equals(SituacaoVendaEnum.RECUSADA)) && !vendaTemp.getSituacao().equals(SituacaoVendaEnum.PROCESSADA)))
                    soma+= vo.getQuantidade();
            
        }
        return soma;
    }
    
    public Float getQtdePrevista(){
        List<ItemCompraEntity> lista= itemCompra.buscarPorProduto(item.getProdutoVO().getId());
        float qtde=0;
        for(ItemCompraEntity vo: lista){
            CompraEntity compraTemp= compra.pegaCompra(vo);
            if(!compraTemp.getSituacao().equals(SituacaoCompraEnum.PROCESSADA))
                qtde+=vo.getQuantidadePedida();
        }
        return qtde;
    }
    
    
}
