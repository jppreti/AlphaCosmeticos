/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.business.operacoes.ItemCompra;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoCompraEnum;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.jboss.weld.util.collections.ArraySet;

/**
 *
 * @author Daniel
 */
public class TabelaTelaVendaSeparar {
    ItemVendaEntity itemVenda;
    List<CompraEntity> compras = new ArrayList<>();
    Compra compra = new Compra(DAOFactory.getDAOFactory().getCompraDAO());
    int dias;
    
    public TabelaTelaVendaSeparar(ItemVendaEntity vendaVO, int dias){
       this.itemVenda = vendaVO;
       this.dias=dias;
    }
    
    public Long getId() {
        return this.itemVenda.getId();
    }
    
    public int getQuantidade() {
        return this.itemVenda.getQuantidade();
    }
    
    public String getNomeProduto (){
        return this.itemVenda.getNomeProduto();
    }
    
    public Long getQtdePrevista(){
        return this.getQuantidadeEsperada()+itemVenda.getProdutoVO().getQuantidade();
        
    }
    
    public String getDtPrevistoQtdeEstoqueString(){
        Date data= new Date();
        data.setDate(data.getDate()+this.dias);
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    public Date getDtPrevistoQtdeEstoque(){
        Date data= new Date();
        data.setDate(data.getDate()+this.dias);
        return data;
    }    
    
    public Long getQuantidadeEsperada(){
        long soma=0;
        try{
            compras= this.compra.buscarTodasCompras();
            Date data;
            for (CompraEntity vo:compras){                
                if (vo.getSituacao()!= SituacaoCompraEnum.CANCELADA &&vo.getSituacao()!= SituacaoCompraEnum.PROCESSADA){
                    data = vo.getDataRecebimento();
                    if (data.compareTo(this.getDtPrevistoQtdeEstoque())<=0){
                        for (ItemCompraEntity vo2: vo.getListaItens()){
                            if (vo2.getProdutoVO().getId().equals(this.itemVenda.getProdutoVO().getId())){
                                soma=soma+vo2.getQuantidadePedida();
                            }
                        }
                    }
                }
            }
            return soma;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return soma;
    }    
}
