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
import java.util.List;

public class TabelaTelaCompra {

    private ProdutoEntity produto;
    private ItemVenda itemVenda = new ItemVenda(DAOFactory.getDAOFactory().getItemVendaDAO());
    private ItemCompra itemCompra = new ItemCompra(DAOFactory.getDAOFactory().getItemCompraDAO());
    private Compra compra = new Compra(DAOFactory.getDAOFactory().getCompraDAO());
    private Venda venda = new Venda(DAOFactory.getDAOFactory().getVendaDAO());

    public TabelaTelaCompra(ProdutoEntity pro) {
        produto = pro;
    }
    public List<ItemVendaEntity> listaItemVenda;
    public List<ItemCompraEntity> listaItemCompra;

    public ProdutoEntity getProduto() {
        return produto;
    }

    public String getNome() {
        return produto.getNome();
    }

    public float getQuantidade() {
        return produto.getQuantidade();
    }

    public String getCategoria() {
        return produto.getNomeCategoria();
    }

    public Float getQuantidadeEsperada() {
        float soma = 0;
        CompraEntity compraTemp = null;
        try {
            listaItemCompra = itemCompra.buscarPorProduto(produto.getId());
            for (ItemCompraEntity vo : listaItemCompra) {
                compraTemp = compra.pegaCompra(vo);
                if (!compraTemp.getSituacao().equals(SituacaoCompraEnum.PROCESSADA)) {
                    soma += vo.getQuantidadePedida();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return soma;
    }

    public Float getQuantidadeReservada() {
        float soma = 0;
        VendaEntity vendaTemp = null;
        listaItemVenda = itemVenda.buscarPorProduto(produto.getId());
        for (ItemVendaEntity vo : listaItemVenda) {
            vendaTemp = venda.pegaVenda(vo);
            if (((!vendaTemp.getSituacao().equals(SituacaoVendaEnum.RECUSADA)) && !vendaTemp.getSituacao().equals(SituacaoVendaEnum.PROCESSADA))) {
                soma += vo.getQuantidade();
            }

        }
        return soma;
    }

    public String getFornecedor() {
        return produto.getFornecedor().getFantasia();
    }
}
