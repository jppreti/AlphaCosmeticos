package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import br.com.compdevbooks.alphacosmetics.entity.pagamento.PagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerarEmailCompra {

    private List<CompraEntity> listaCompras;
    private final List<String> saidaCompras = new ArrayList<>();

    public GerarEmailCompra(List<CompraEntity> listaCompras) {
        this.listaCompras = listaCompras;
        String texto = "";
        for (CompraEntity c : listaCompras) {
            texto = this.processarEmail(c);
            this.saidaCompras.add(texto);
        }
    }

    public List<CompraEntity> getListaCompras() {
        return listaCompras;
    }

    public String getSaidaCompras(int index) {
        return saidaCompras.get(index);
    }

    private String processarEmail(CompraEntity compra) {

        String saida = "Para:emaildofornecedor@gmail.com\n\n"+compra.getNomeFornecedor() + "\n"
                + "\n"
                + "Pedido de Compra nº: " + compra.getId() + "\n"
                + "\n"
                + "Data de Lançamento: " + compra.getDataLancamentoString() + "\n"
                + "Forma de Pagamento: BOLETO BANCÁRIO\n"
                + "Tipo de Pagamento: " + compra.getPagamentoVO().getTipoPagamento() + "\n"
                + "Nº de Parcelas:" + compra.getPagamentoVO().getListaParcelas().size() + "\t\tDatas de Vencimento: ";
        for (ParcelaPagamentoEntity p : compra.getPagamentoVO().getListaParcelas()) {
            Date d = p.getDataVencimento();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            saida += sdf.format(d) + "\t";
        }
        saida += "\n\n\n"
                + "Endereço de Entrega: \n"
                + "Empresa Alpha Cosméticos	CEP:78000-000\n"
                + "Rua dos cosméticos, nº 1234.\n"
                + "Bairro do Perfume.\n"
                + "Cuiabá-MT.\n"
                + "\n"
                + "\n"
                + "\tPRODUTO\t|\tMARCA\t|\tVALOR\t|\tQUANTIDADE\n";

        for (ItemCompraEntity ic : compra.getListaItens()) {

            saida += "\t" + ic.getNomeProduto() + "\t|\t" + ic.getProdutoVO().getMarca() + "\t|\t" + ic.getProdutoVO().getValorCompra() + "\t|\t" + ic.getQuantidadePedida() + "\n";
        }

        saida += "\nValor Total: " + compra.getValorTotal()
                + "\n"
                + "\n"
                + "\n"
                + "Este e-mail é gerado automáticamente pelo sistema AlphaCosméticos.\n"
                + "\n"
                + "\n"
                + "Atenciosamente,\n"
                + "Empresa AlphaCosméticos.";

        return saida;
    }

}
