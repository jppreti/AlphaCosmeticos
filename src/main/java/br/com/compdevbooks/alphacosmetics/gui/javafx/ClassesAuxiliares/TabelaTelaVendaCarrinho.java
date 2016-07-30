package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;

/**
 *
 * @author Mattheus Nunes
 */
public class TabelaTelaVendaCarrinho {
    private ItemVendaEntity itemVenda;
    private Venda venda= new Venda(DAOFactory.getDAOFactory().getVendaDAO());
    
    public TabelaTelaVendaCarrinho (ItemVendaEntity ic){
        itemVenda=ic;
    }

    public ItemVendaEntity getProduto(){
        return itemVenda;
    }
    public String getNome(){
        return itemVenda.getProdutoVO().getNome();
    }
    public int getQuantidade(){
        return itemVenda.getQuantidade();
    }
    public String getCategoria(){
        return itemVenda.getProdutoVO().getNomeCategoria();
    }
    
    public String getFornecedor(){
        return itemVenda.getProdutoVO().getFornecedor().getFantasia();
    }
}
