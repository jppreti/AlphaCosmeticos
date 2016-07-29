/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.FormaPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaContasReceber;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.sql.Select;
//import br.com.compdevbooks.alphacosmetics.entity.pagamento.

public class FrmContas_a_receber {

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
    private String path;
    private String pathToReportPackage;

    public FrmContas_a_receber() {
        /*this.path = this.getClass().getClassLoader().getResource("").getPath();
        this.pathToReportPackage = this.path + "br\\com\\compdevbooks\\alphacosmetics\\gui\\javafx\\jasper\\";
        System.out.println(path+" "+"aqui");*/
    }

    @FXML
    void initialize() {
        tabVisualizar.setDisable(true);

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
                if (parcPg.getDataPagamento() == null) {

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
        }

        txtTotalEmAbertoValor.setText("$ " + aberto);
        txtTotalVencidosValor.setText("$ " + vencidos);
        txtTotalVencido30Valor.setText("$ " + vencidos30);

        completar(listaVendaT);

    }

    public String getPathToReportPackage() {
        return this.pathToReportPackage;
    }

    public String getPath() {
        return this.path;
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
                if (parcPg.getDataPagamento() == null) {

                    if (cmbFormaPgto.getValue().toString().toUpperCase().equals("TODOS")) {
                        if (cmbOpcaoPesquisa.getValue().equals("Dt Lançamento")) {

                            if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {

                                if (fim.after(vo.getDataLancamento()) || comparador(fim, vo.getDataLancamento())) {
                                    if (rdbEmAberto.isSelected()) {
                                        if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());

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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());

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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);

                                    }
                                }
                            }
                            if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
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
                                    tabela.setId_venda(vo.getId());
                                    tabela.setId_parcela(parcPg.getId());
                                    dado.add(tabela);

                                }
                            }
                            if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                                if (inicio.before(vo.getDataLancamento()) || comparador(inicio, vo.getDataLancamento())) {
                                    if (rdbEmAberto.isSelected()) {
                                        if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);

                                    }
                                }
                            }
                            if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                                if ((fim.after(vo.getDataLancamento()) && inicio.before(vo.getDataLancamento()))
                                        || comparador(fim, vo.getDataLancamento()) || comparador(inicio, vo.getDataLancamento())) {

                                    if (rdbEmAberto.isSelected()) {
                                        if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);
                                    }
                                }
                            }

                        }
                        if (cmbOpcaoPesquisa.getValue().equals("Dt Vencimento")) {

                        }
                        if (cmbOpcaoPesquisa.getValue().equals("Dt Vencimento")) {

                            if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {
                                /*
                             arrumar aqui!!
                                 */

                                if ((fim.after(parcPg.getDataVencimento())) || comparador(fim, parcPg.getDataVencimento())) {

                                    if (rdbEmAberto.isSelected()) {
                                        if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);

                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);

                                    }
                                }
                            }
                            if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
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
                                    tabela.setId_venda(vo.getId());
                                    tabela.setId_parcela(parcPg.getId());
                                    dado.add(tabela);

                                }

                            }
                            if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                                if (inicio.before(parcPg.getDataVencimento()) || comparador(inicio, parcPg.getDataVencimento())) {
                                    if (rdbEmAberto.isSelected()) {
                                        if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);

                                    }
                                }
                            }
                            if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                                if ((fim.after(parcPg.getDataVencimento()) && inicio.before(parcPg.getDataVencimento()))
                                        || comparador(fim, parcPg.getDataVencimento()) || comparador(inicio, parcPg.getDataVencimento())) {

                                    if (rdbEmAberto.isSelected()) {
                                        if (parcPg.getDataVencimento().after(referencia) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);

                                    }
                                }
                            }

                        }
                    }
                    if (parcPg.getDocumentoPagamento().getNome().toUpperCase().equals(cmbFormaPgto.getValue().toString().toUpperCase())) {
                        if (cmbOpcaoPesquisa.getValue().equals("Dt Lançamento")) {

                            if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {

                                if (fim.after(vo.getDataLancamento()) || comparador(fim, vo.getDataLancamento())) {
                                    if (rdbEmAberto.isSelected()) {
                                        if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);

                                    }
                                }
                            }
                            if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
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
                                    tabela.setId_venda(vo.getId());
                                    tabela.setId_parcela(parcPg.getId());
                                    dado.add(tabela);

                                }
                            }
                            if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                                if (inicio.before(vo.getDataLancamento()) || comparador(inicio, vo.getDataLancamento())) {
                                    if (rdbEmAberto.isSelected()) {
                                        if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);

                                    }
                                }
                            }
                            if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                                if ((fim.after(vo.getDataLancamento()) && inicio.before(vo.getDataLancamento()))
                                        || comparador(fim, vo.getDataLancamento()) || comparador(inicio, vo.getDataLancamento())) {

                                    if (rdbEmAberto.isSelected()) {
                                        if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);
                                    }
                                }
                            }

                        }
                        if (cmbOpcaoPesquisa.getValue().equals("Dt Vencimento")) {

                        }
                        if (cmbOpcaoPesquisa.getValue().equals("Dt Vencimento")) {

                            if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {
                                /*
                             arrumar aqui!!
                                 */

                                if ((fim.after(parcPg.getDataVencimento())) || comparador(fim, parcPg.getDataVencimento())) {

                                    if (rdbEmAberto.isSelected()) {
                                        if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);

                                    }
                                }
                            }
                            if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                        tabela.setCliente(vo.getNomeCliente());
                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                        tabela.setParcela(cont);
                                        tabela.setValor((float) parcPg.getValorTotalPago());
                                        tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
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
                                    tabela.setId_venda(vo.getId());
                                    tabela.setId_parcela(parcPg.getId());
                                    dado.add(tabela);

                                }

                            }
                            if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                                if (inicio.before(parcPg.getDataVencimento()) || comparador(inicio, parcPg.getDataVencimento())) {
                                    if (rdbEmAberto.isSelected()) {
                                        if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);

                                    }
                                }
                            }
                            if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                                if ((fim.after(parcPg.getDataVencimento()) && inicio.before(parcPg.getDataVencimento()))
                                        || comparador(fim, parcPg.getDataVencimento()) || comparador(inicio, parcPg.getDataVencimento())) {

                                    if (rdbEmAberto.isSelected()) {
                                        if (parcPg.getDataVencimento().after(referencia) || comparador(parcPg.getDataVencimento(), referencia)) {

                                            TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();

                                            tabela.setCliente(vo.getNomeCliente());
                                            tabela.setDtLancamento(vo.getDataLancamento());
                                            tabela.setDtVencimento(parcPg.getDataVencimento());
                                            tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome().toUpperCase());
                                            tabela.setParcela(cont);
                                            tabela.setValor((float) parcPg.getValorTotalPago());
                                            tabela.setCnpj(vo.getClienteVO().getCNPJ());
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                            tabela.setId_venda(vo.getId());
                                            tabela.setId_parcela(parcPg.getId());
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
                                        tabela.setId_venda(vo.getId());
                                        tabela.setId_parcela(parcPg.getId());
                                        dado.add(tabela);

                                    }
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
        TabelaTelaContasReceber teste;
        teste = tblVenda.getSelectionModel().getSelectedItem();
        System.out.println(teste.getId_parcela());
        ParcelaPagamentoEntity aux = null;

        for (VendaEntity vo : listaVendaT) {

            for (ParcelaPagamentoEntity parcPg : vo.getPagamentoVO().getListaParcelas()) {
                System.out.println(parcPg.getId());

                if (parcPg.getId().equals(teste.getId_parcela())) {
                    parcPg.setDataPagamento(referencia);
                }
            }
            //   System.out.println("aaa");
            // vo.getPagamentoVO().getListaParcelas().remove(aux);
            //System.out.println("bbbbb");
        }

        completar(listaVendaT);

    }



    @FXML
    void btnVisualizarImpressao_onAction(ActionEvent event) throws Exception {
          imprimir();
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
            if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {
                if (validar_data(dtpInicial.getValue(), dtpFinal.getValue())) {
                    busca();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Data Inválida!");

                    alert.setContentText("Erro ao buscar pelas datas selecionadas");

                    alert.showAndWait();
                    return;
                }
            } else {
                busca();
            }
        }
    }

    @FXML
    void btnProcurar_onAction(ActionEvent event) {
        if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {
            if (validar_data(dtpInicial.getValue(), dtpFinal.getValue())) {
                busca();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Data Inválida!");

                alert.setContentText("Erro ao buscar pelas datas selecionadas");

                alert.showAndWait();
                return;
            }
        } else {
            busca();
        }
    }

    @FXML
    void rdbEmAberto_onAction(ActionEvent event) {

        rdbTodosTipoCliente.setSelected(false);
        rdbVencidos.setSelected(false);
        if (!rdbEmAberto.isSelected()) {
            rdbEmAberto.setSelected(true);
        }
        btnProcurar_onAction(event);
    }

    @FXML
    void rdbVencidos_onAction(ActionEvent event) {
        rdbEmAberto.setSelected(false);
        rdbTodosTipoCliente.setSelected(false);
        if (!rdbVencidos.isSelected()) {
            rdbVencidos.setSelected(true);
        }
        btnProcurar_onAction(event);
    }

    @FXML
    void rdbTodosTipoCliente_onAction(ActionEvent event) {
        rdbEmAberto.setSelected(false);
        rdbVencidos.setSelected(false);
        if (!rdbTodosTipoCliente.isSelected()) {
            rdbTodosTipoCliente.setSelected(true);
        }
        btnProcurar_onAction(event);

    }

    @FXML
    void cmbOpcaoPesquisa_onAction(ActionEvent event) {
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
            // List<VendaEntity> listaVendaT;
            // listaVendaT = venda.buscarTodasVendas();
            completar(listaVendaT);
            return;
        }

        for (int i = 0; i < listaVendaT.size(); i++) {
            //   System.out.println(dado.size() + " " + i);
            if (!txtNomeRazaoSocial.getText().equals("")) {
                int aux = 0;
                if (listaVendaT.get(i).getClienteVO().getNome().toUpperCase().contains(txtNomeRazaoSocial.getText().toUpperCase())) {
                    dado.add(listaVendaT.get(i));
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

    private boolean comparador(Date data1, Date data2) {

        Instant instant1 = Instant.ofEpochMilli(data1.getTime());
        LocalDate localDate1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault()).toLocalDate();

        Instant instant2 = Instant.ofEpochMilli(data2.getTime());
        LocalDate localDate2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()).toLocalDate();

        if (localDate1.equals(localDate2)) {
            return true;
        } else {
            return false;
        }

    }

    private boolean validar_data(LocalDate inicio, LocalDate fim) {
        if (fim.isAfter(inicio) || fim.equals(inicio)) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void tblVenda_onMouseClicked(MouseEvent event) {
        if (event.getClickCount() >= 1) {
            if (tblVenda.getSelectionModel().getSelectedItem() == null) {
                return;
            }
            tabVisualizar.setDisable(false);
        }

        TabelaTelaContasReceber receber = tblVenda.getSelectionModel().getSelectedItem();

        lblClienteValor.setText("  " + receber.getCliente());
        lblLancamentoValor.setText("  " + receber.getDtLancamento());
        lblVencimentoValor.setText("  " + receber.getDtVencimento());
        lblValorValor.setText("  $" + receber.getValor());
        lblNumTituloValor.setText("  " + receber.getParcela());
        lblTipoDocumentoValor.setText("  " + receber.getFormapgto());
        txtValorTotal.setText(String.valueOf(receber.getValor()));

    }
    
    
    public void imprimir() throws Exception {

        System.out.println("ok");

        JasperReport report = JasperCompileManager.compileReport("F:\\AlphaCosmeticos\\src\\main\\java\\br\\com\\compdevbooks\\alphacosmetics\\jasper\\ContasReceber.jrxml");
        System.out.println("ok2");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(tblVenda.getItems()));

        JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Roberto Junior\\Documents\\NetBeansProjects\\Relatorio_de_ContasReceber.pdf");

    }

}
