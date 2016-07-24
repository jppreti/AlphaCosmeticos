/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import br.com.compdevbooks.alphacosmetics.business.Cliente;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockVendaDAO;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.FormaPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaContasReceber;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import org.hibernate.sql.Select;
//import br.com.compdevbooks.alphacosmetics.entity.pagamento.

public class FrmContas_a_receber {

    @FXML
    private TextField txtNumParcelas;

    @FXML
    private TextField txtNomeRazaoSocial;

    @FXML
    private DatePicker dtpFinal;

    @FXML
    private Label lblTotaisPeriodo;

    @FXML
    private BorderPane frmContaReceber;

    @FXML
    private Label lblTotalVencidos30;

    @FXML
    private Label lblSituacao;

    @FXML
    private GridPane grpVisualizar;

    @FXML
    private RadioButton rdbEmAberto;

    @FXML
    private Label lblValorValor;

    @FXML
    private TextField txtTotalVencido30Valor;

    @FXML
    private Label lblVencimento;

    @FXML
    private Button btnBaixarTitulos;

    @FXML
    private Label lblNumPedidoValor;

    @FXML
    private ComboBox<FormaPagamentoEnum> cmbFormaPgto;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmCliente;

    @FXML
    private TableColumn<TabelaTelaContasReceber, Float> clmValor;

    @FXML
    private Label lblVencimentoValor;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblLancamento;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmDtLancamento;

    @FXML
    private Label lblTotalEmAberto;

    @FXML
    private Button btnVisualizarImpressao;

    @FXML
    private TextField txtTotalVencidosValor;

    @FXML
    private Button btnSair;

    @FXML
    private ComboBox<String> cmbOpcaoPesquisa;

    @FXML
    private Label lblValorTotal;

    @FXML
    private Tab tabTitulos;

    @FXML
    private Label lblTipoDocumento;

    @FXML
    private Label lblLancamentoValor;

    @FXML
    private Label lblNumTituloValor;

    @FXML
    private TextField txtCpfCnpj;

    @FXML
    private Label lblNumTitulo;

    @FXML
    private Label lblNumPedido;

    @FXML
    private Button btnProcurar;

    @FXML
    private Tab tabVisualizar;

    @FXML
    private Label lblCliente;

    @FXML
    private Label lblNumParcelas;

    @FXML
    private TextField txtTotalEmAbertoValor;

    @FXML
    private Label lblTipoDocumentoValor;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmFormaPgto;

    @FXML
    private RadioButton rdbTodosTipoCliente;

    @FXML
    private Label lblClienteValor;

    @FXML
    private Label lblSituacaoValor;

    @FXML
    private Label lblPo;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmDtVencimento;

    @FXML
    private Label lblValor;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmNumParc;

    @FXML
    private DatePicker dtpInicial;

    @FXML
    private RadioButton rdbVencidos;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TableView<TabelaTelaContasReceber> tblVenda;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmCnpj;

    Date referencia = new Date();
    Date refAux = new Date();
    float vencidos = 0;
    float vencidos30 = 0;
    float aberto = 0;

    private Venda venda = new Venda(DAOFactory.getDAOFactory().getVendaDAO());

    List<VendaEntity> listaVendaT;

    @FXML
    void initialize() {

        ObservableList<String> ob = FXCollections.observableArrayList();

        refAux.setDate(refAux.getDate() - 30);

        listaVendaT = venda.buscarTodasVendas();

        ob.add("Dt Lançamento");
        ob.add("Dt Vencimento");
        cmbOpcaoPesquisa.setItems(ob);
        cmbOpcaoPesquisa.setValue("Dt Lançamento");

        Date data = new Date();
        LocalDate dtlocal = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dtpFinal.setValue(dtlocal);
        rdbTodosTipoCliente.setSelected(true);

        cmbFormaPgto.setItems(FXCollections.observableArrayList(FormaPagamentoEnum.values()));
        cmbFormaPgto.setValue(FormaPagamentoEnum.TODOS);

        for (VendaEntity vo : listaVendaT) {

            for (ParcelaPagamentoEntity parcPg : vo.getPagamentoVO().getListaParcelas()) {

                if (parcPg.getDataVencimento().compareTo(referencia) == 0) {
                    aberto += (float) parcPg.getValorOriginal();
                }
                if (parcPg.getDataVencimento().compareTo(referencia) == 1) {
                    aberto += (float) parcPg.getValorOriginal();
                }
                if (parcPg.getDataVencimento().compareTo(referencia) == -1) {
                    //  referencia.setDate(referencia.getDate() + 30);
                    if (parcPg.getDataVencimento().compareTo(refAux) == -1) {
                        vencidos30 += (float) parcPg.getValorOriginal();
                    }
                    if (parcPg.getDataVencimento().compareTo(refAux) == 0) {
                        vencidos30 += (float) parcPg.getValorOriginal();
                    }
                    if (parcPg.getDataVencimento().compareTo(refAux) == 1) {
                        vencidos += (float) parcPg.getValorOriginal();
                    }
                }
            }
        }

        txtTotalEmAbertoValor.setText("$ " + aberto);
        txtTotalVencidosValor.setText("$ " + vencidos);
        txtTotalVencido30Valor.setText("$ " + vencidos30);

        completar(listaVendaT);

    }

    void completar(List<VendaEntity> lista) {

        ObservableList<TabelaTelaContasReceber> dado = FXCollections.observableArrayList();

        this.clmCliente.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber, String>("cliente"));
        this.clmDtLancamento.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber, String>("dtLancamento"));
        this.clmDtVencimento.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber, String>("dtVencimento"));
        this.clmFormaPgto.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber, String>("formapgto"));
        this.clmNumParc.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber, String>("parcela"));
        this.clmValor.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber, Float>("valor"));
        this.clmCnpj.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber, String>("cnpj"));
        int cont = 0;

        Date fim = new Date();
        Date inicio = new Date();

        if (dtpFinal.getValue() != null) {
            LocalDate ld = dtpFinal.getValue();
            Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            fim = Date.from(instant);
        }
        if (dtpInicial.getValue() != null) {
            LocalDate ld = dtpInicial.getValue();
            Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            inicio = Date.from(instant);
        }

        for (VendaEntity vo : lista) {

            for (ParcelaPagamentoEntity parcPg : vo.getPagamentoVO().getListaParcelas()) {
                cont++;

                if (cmbFormaPgto.getValue().toString().toUpperCase().equals("TODOS")) {
                    if (cmbOpcaoPesquisa.getValue().equals("Dt Lançamento")) {

                        if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {

                            if (fim.after(vo.getDataLancamento()) || fim.equals(vo.getDataLancamento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                            if (rdbEmAberto.isSelected()) {
                                if (parcPg.getDataVencimento().after(referencia)) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);
                                }
                            }
                            if (rdbVencidos.isSelected()) {
                                if (parcPg.getDataVencimento().before(referencia)) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);
                                }
                            }

                            if (rdbTodosTipoCliente.isSelected()) {

                                TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                tabela.setCliente(vo.getNomeCliente());
                                tabela.setDtLancamento(vo.getDataLancamento());
                                tabela.setDtVencimento(parcPg.getDataVencimento());
                                tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                tabela.setParcela(cont);
                                tabela.setValor((float) parcPg.getValorTotalPago());
                                tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                dado.add(tabela);

                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                            if (inicio.before(vo.getDataLancamento()) || inicio.equals(vo.getDataLancamento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                            if ((fim.after(vo.getDataLancamento()) && inicio.before(vo.getDataLancamento()))
                                    || fim.equals(vo.getDataLancamento()) || inicio.equals(vo.getDataLancamento())) {

                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }

                    }
                    if (cmbOpcaoPesquisa.getValue().equals("Dt Vencimento")) {

                        if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {

                            if (fim.after(parcPg.getDataVencimento()) || fim.equals(parcPg.getDataVencimento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                            if (rdbEmAberto.isSelected()) {
                                if (parcPg.getDataVencimento().after(referencia)) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);
                                }
                            }
                            if (rdbVencidos.isSelected()) {
                                if (parcPg.getDataVencimento().before(referencia)) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);
                                }
                            }

                            if (rdbTodosTipoCliente.isSelected()) {

                                TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                tabela.setCliente(vo.getNomeCliente());
                                tabela.setDtLancamento(vo.getDataLancamento());
                                tabela.setDtVencimento(parcPg.getDataVencimento());
                                tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                tabela.setParcela(cont);
                                tabela.setValor((float) parcPg.getValorTotalPago());
                                tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                dado.add(tabela);

                            }

                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                            if (inicio.before(parcPg.getDataVencimento()) || inicio.equals(parcPg.getDataVencimento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                            if ((fim.after(parcPg.getDataVencimento()) && inicio.before(parcPg.getDataVencimento()))
                                    || fim.equals(parcPg.getDataVencimento()) || inicio.equals(parcPg.getDataVencimento())) {

                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }

                    }
                }
                if (parcPg.getDocumentoPagamento().getNome().toUpperCase().equals(cmbFormaPgto.getValue().toString().toUpperCase())) {
                     if (cmbOpcaoPesquisa.getValue().equals("Dt Lançamento")) {

                        if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {

                            if (fim.after(vo.getDataLancamento()) || fim.equals(vo.getDataLancamento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                            if (rdbEmAberto.isSelected()) {
                                if (parcPg.getDataVencimento().after(referencia)) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);
                                }
                            }
                            if (rdbVencidos.isSelected()) {
                                if (parcPg.getDataVencimento().before(referencia)) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);
                                }
                            }

                            if (rdbTodosTipoCliente.isSelected()) {

                                TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                tabela.setCliente(vo.getNomeCliente());
                                tabela.setDtLancamento(vo.getDataLancamento());
                                tabela.setDtVencimento(parcPg.getDataVencimento());
                                tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                tabela.setParcela(cont);
                                tabela.setValor((float) parcPg.getValorTotalPago());
                                tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                dado.add(tabela);

                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                            if (inicio.before(vo.getDataLancamento()) || inicio.equals(vo.getDataLancamento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                            if ((fim.after(vo.getDataLancamento()) && inicio.before(vo.getDataLancamento()))
                                    || fim.equals(vo.getDataLancamento()) || inicio.equals(vo.getDataLancamento())) {

                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }

                    }
                    if (cmbOpcaoPesquisa.getValue().equals("Dt Vencimento")) {

                        if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {

                            if (fim.after(parcPg.getDataVencimento()) || fim.equals(parcPg.getDataVencimento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                            if (rdbEmAberto.isSelected()) {
                                if (parcPg.getDataVencimento().after(referencia)) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);
                                }
                            }
                            if (rdbVencidos.isSelected()) {
                                if (parcPg.getDataVencimento().before(referencia)) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);
                                }
                            }

                            if (rdbTodosTipoCliente.isSelected()) {

                                TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                tabela.setCliente(vo.getNomeCliente());
                                tabela.setDtLancamento(vo.getDataLancamento());
                                tabela.setDtVencimento(parcPg.getDataVencimento());
                                tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                tabela.setParcela(cont);
                                tabela.setValor((float) parcPg.getValorTotalPago());
                                tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                dado.add(tabela);

                            }

                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                            if (inicio.before(parcPg.getDataVencimento()) || inicio.equals(parcPg.getDataVencimento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                            if ((fim.after(parcPg.getDataVencimento()) && inicio.before(parcPg.getDataVencimento()))
                                    || fim.equals(parcPg.getDataVencimento()) || inicio.equals(parcPg.getDataVencimento())) {

                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                        dado.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                    tabela.setCliente(vo.getNomeCliente());
                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                    tabela.setParcela(cont);
                                    tabela.setValor((float) parcPg.getValorTotalPago());
                                    tabela.setCnpj(vo.getClienteVO().getCNPJ());

                                    dado.add(tabela);

                                }
                            }
                        }

                    }
                }
            }
            cont = 0;

        }
        this.tblVenda.setItems(dado);

    }

    @FXML
    void btnBaixarTitulos_onAction(ActionEvent event) {

    }

    @FXML
    void btnVisualizarImpressao_onAction(ActionEvent event) {

    }

    @FXML
    void btnSair_onAction(ActionEvent event) {

        getPai(frmContaReceber);

    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            getPai(frmContaReceber);
        }

    }

    @FXML
    void dtpInicial_onKeyPressed(KeyEvent event) {
        btnProcurar_OnKeyPressed(event);

    }

    @FXML
    void dtpFinal_onKeyPressed(KeyEvent event) {
        btnProcurar_OnKeyPressed(event);

    }

    @FXML
    void dtpInicial_onAction(ActionEvent event) {
        btnProcurar_onAction(event);
    }

    @FXML
    void dtpFinal_onAction(ActionEvent event) {
        btnProcurar_onAction(event);
    }

    @FXML
    void txtCpfCnpj_onKeyPressed(KeyEvent event) {
        if (txtCpfCnpj.getText().isEmpty()) {
            if (event.getCode() == KeyCode.TAB) {
                txtNomeRazaoSocial.setDisable(false);
            } else {
                txtNomeRazaoSocial.setDisable(true);
            }

        }

        if (event.getCode() == KeyCode.ENTER) {

            btnProcurar_OnKeyPressed(event);
        }

    }

    @FXML
    void txtCpfCnpj_onKeyReleased(KeyEvent event) {
        if (txtCpfCnpj.getText().isEmpty()) {
            txtNomeRazaoSocial.setDisable(false);
        }

    }

    @FXML
    void txtNomeRazaoSocial_onKeyReleased(KeyEvent event) {
        if (txtNomeRazaoSocial.getText().isEmpty()) {
            txtCpfCnpj.setDisable(false);
        }
    }

    @FXML
    void txtNomeRazaoSocial(KeyEvent event) {

        if (txtNomeRazaoSocial.getText().isEmpty()) {

            if (event.getCode() == KeyCode.TAB) {
                txtCpfCnpj.setDisable(false);
            } else {
                txtCpfCnpj.setDisable(true);
            }

        }
        if (event.getCode() == KeyCode.ENTER) {
            // System.out.println(txtNomeRazaoSocial.getText());
            btnProcurar_OnKeyPressed(event);
        }

    }

    @FXML
    void btnProcurar_OnKeyPressed(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            busca();
        }
    }

    @FXML
    void btnProcurar_onAction(ActionEvent event) {
        busca();
    }

    @FXML
    void rdbEmAberto_onAction(ActionEvent event) {

        rdbTodosTipoCliente.setSelected(false);
        rdbVencidos.setSelected(false);
        btnProcurar_onAction(event);
    }

    @FXML
    void rdbVencidos_onAction(ActionEvent event) {
        rdbEmAberto.setSelected(false);
        rdbTodosTipoCliente.setSelected(false);
        btnProcurar_onAction(event);
    }

    @FXML
    void rdbTodosTipoCliente_onAction(ActionEvent event) {
        rdbEmAberto.setSelected(false);
        rdbVencidos.setSelected(false);
        btnProcurar_onAction(event);

    }
    @FXML
    void cmbOpcaoPesquisa_onAction(ActionEvent event){
        btnProcurar_onAction(event);
    }

    @FXML
    void cmbFormaPgto_onAction(ActionEvent event) {
        btnProcurar_onAction(event);
    }

    private void getPai(Node node) {
        Node aux = node.getParent();
        while (!(aux instanceof BorderPane)) {
            aux = node.getParent();
        }
        ((BorderPane) aux).setCenter(null);
    }

    private void busca() {
        List<VendaEntity> dado = new ArrayList<>();

        if (txtNomeRazaoSocial.getText().equals("") && txtCpfCnpj.getText().equals("")) {
            List<VendaEntity> listaVendaT;
            listaVendaT = venda.buscarTodasVendas();
            completar(listaVendaT);
            return;
        }

        for (int i = 0; i < listaVendaT.size(); i++) {
            //   System.out.println(dado.size() + " " + i);
            if (!txtNomeRazaoSocial.getText().equals("")) {
                int aux = 0;
                if (listaVendaT.get(i).getClienteVO().getNome().toUpperCase().contains(txtNomeRazaoSocial.getText().toUpperCase())) {
                    dado.add(listaVendaT.get(aux));
                }
            }
            if (!txtCpfCnpj.getText().equals("")) {
                if (listaVendaT.get(i).getClienteVO().getCNPJ().contains(txtCpfCnpj.getText())) {
                    dado.add(listaVendaT.get(i));
                }
            }
        }

        completar(dado);

    }
}
