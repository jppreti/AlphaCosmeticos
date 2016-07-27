package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.FormaPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaContasAPagar;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

public class FrmContas_a_pagar {

    @FXML
    private TextField txtNomeRazaoSocial;

    @FXML
    private BorderPane frmContasPagar;

    @FXML
    private DatePicker dtpFinal;

    @FXML
    private Label lblDataFinal;

    @FXML
    private Label lblTotaisPeriodo;

    @FXML
    private Label lblSituacao;

    @FXML
    private Label lblDiaAtrasado;

    @FXML
    private TextField txtTotal;

    @FXML
    private TableColumn< TabelaTelaContasAPagar, String> clmNomeRazaoSocial;

    @FXML
    private TableColumn<TabelaTelaContasAPagar, String> clmCnpj;

    @FXML
    private RadioButton rdbEmAberto;

    @FXML
    private Label lblValorValor;

    @FXML
    private DatePicker dtpPagamento;

    @FXML
    private Label lblVencimento;

    @FXML
    private TextField txtTotalVencidos30Valor;

    @FXML
    private ComboBox<FormaPagamentoEnum> cmbFormaPgto;

    @FXML
    private TableColumn< TabelaTelaContasAPagar, Float> clmValor;

    @FXML
    private TextField txtValorAPagar;

    @FXML
    private Tab tabDividas;

    @FXML
    private Label lblValorPago;

    @FXML
    private Label lblDiaAtrasadoValor;

    @FXML
    private Label lblVencimentoValor;

    @FXML
    private Label txtTotalVencidos;

    @FXML
    private TextField txtValorPago;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblTotalVencido30;

    @FXML
    private TableColumn< TabelaTelaContasAPagar, String> clmDtLancamento;

    @FXML
    private Label lblDataInicial;

    @FXML
    private Label lblDataPagamento;

    @FXML
    private Label lblNomeRazaoSocial;

    @FXML
    private GridPane grpRelatorioResumido;

    @FXML
    private Label lblTotalEmAberto;

    @FXML
    private Label lblDocumento;

    @FXML
    private TextField txtTotalVencidosValor;

    @FXML
    private Button btnSair;

    @FXML
    private ComboBox<String> cmbOpcaoPesquisa;

    @FXML
    private Label lblFormaPagamento;

    @FXML
    private TextField txtCpfCnpj;

    @FXML
    private Button btnProcurar;

    @FXML
    private TextField txtTotalEmAbertoValor;

    @FXML
    private Button btnBaixarDivida;

    @FXML
    private TableColumn< TabelaTelaContasAPagar, String> clmFormaPgto;

    @FXML
    private RadioButton rdbTodosTipoCliente;

    @FXML
    private Label lblValorAPagar;

    @FXML
    private Label lblTotal;

    @FXML
    private Tab tabRelatorioResumido;

    @FXML
    private Label lblDocumentoValor;

    @FXML
    private TableColumn< TabelaTelaContasAPagar, String> clmDtVencimento;

    @FXML
    private Label lblValor;

    @FXML
    private DatePicker dtpInicial;

    @FXML
    private RadioButton rdbVencidos;

    @FXML
    private Label lblNomeRazaoSocialValor;

    @FXML
    private TableView<TabelaTelaContasAPagar> tblContas_a_pagar;

    Date referencia = new Date();
    Date refAux = new Date();
    float vencidos = 0;
    float vencidos30 = 0;
    float aberto = 0;
    private Compra compra = new Compra(DAOFactory.getDAOFactory().getCompraDAO());
    List<CompraEntity> ListaCompra;

    @FXML
    void initialize() {
        tabRelatorioResumido.setDisable(true);
        ObservableList<String> ob = FXCollections.observableArrayList();
        refAux.setDate(refAux.getDate() - 30);
        ListaCompra = compra.buscarTodasCompras();
        System.out.println(ListaCompra.size());

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

        for (CompraEntity vo : ListaCompra) {
            for (ParcelaPagamentoEntity parcPg : vo.getPagamentoVO().getListaParcelas()) {
                if (parcPg.getDataVencimento().compareTo(referencia) == 0) {
                    aberto += (float) parcPg.getValorOriginal();
                }
                if (parcPg.getDataVencimento().compareTo(referencia) == 1) {
                    aberto += (float) parcPg.getValorOriginal();
                }
                if (parcPg.getDataVencimento().compareTo(referencia) == -1) {

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
        txtTotalVencidos30Valor.setText("$ " + vencidos30);

        completar(ListaCompra);
    }

    public void completar(List<CompraEntity> lista) {
        ObservableList<TabelaTelaContasAPagar> listaFinal = FXCollections.observableArrayList();
        this.clmDtLancamento.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar, String>("dtLancamento"));
        this.clmDtVencimento.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar, String>("dtVencimento"));
        this.clmNomeRazaoSocial.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar, String>("nome"));
        this.clmFormaPgto.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar, String>("formaPgto"));
        this.clmValor.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar, Float>("valor"));
        this.clmCnpj.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar, String>("cnpj"));
        Date fim = new Date();
        Date inicio = new Date();
        int cont = 0;

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
        for (CompraEntity vo : lista) {
            for (ParcelaPagamentoEntity parcPg : vo.getPagamentoVO().getListaParcelas()) {
                cont++;

                if (cmbFormaPgto.getValue().toString().toUpperCase().equals("TODOS")) {
                    if (cmbOpcaoPesquisa.getValue().equals("Dt Lançamento")) {

                        if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {

                            if (fim.after(vo.getDataLancamento()) || comparador(fim, vo.getDataLancamento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                            if (rdbEmAberto.isSelected()) {
                                if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);
                                }
                            }
                            if (rdbVencidos.isSelected()) {
                                if (parcPg.getDataVencimento().before(referencia)) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);
                                }
                            }

                            if (rdbTodosTipoCliente.isSelected()) {

                                TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                tabela.setDtLancamento(vo.getDataLancamento());
                                tabela.setDtVencimento(parcPg.getDataVencimento());
                                tabela.setNome(vo.getNomeFornecedor());
                                tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                tabela.setValor((float) parcPg.getValorOriginal());

                                listaFinal.add(tabela);

                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                            if (inicio.before(vo.getDataLancamento()) || comparador(inicio, vo.getDataLancamento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                            if ((fim.after(vo.getDataLancamento()) && inicio.before(vo.getDataLancamento()))
                                    || comparador(fim, vo.getDataLancamento()) || comparador(inicio, vo.getDataLancamento())) {

                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);
                                }
                            }
                        }

                    }
                    if (cmbOpcaoPesquisa.getValue().equals("Dt Vencimento")) {

                        if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {
                            /*
                             arrumar aqui!!
                             */

                            if ((fim.after(parcPg.getDataVencimento())) || comparador(fim, parcPg.getDataVencimento())) {

                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                            if (rdbEmAberto.isSelected()) {
                                if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);
                                }
                            }
                            if (rdbVencidos.isSelected()) {
                                if (parcPg.getDataVencimento().before(referencia)) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);
                                }
                            }

                            if (rdbTodosTipoCliente.isSelected()) {

                                TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                tabela.setDtLancamento(vo.getDataLancamento());
                                tabela.setDtVencimento(parcPg.getDataVencimento());
                                tabela.setNome(vo.getNomeFornecedor());
                                tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                tabela.setValor((float) parcPg.getValorOriginal());

                                listaFinal.add(tabela);

                            }

                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                            if (inicio.before(parcPg.getDataVencimento()) || comparador(inicio, parcPg.getDataVencimento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                            if ((fim.after(parcPg.getDataVencimento()) && inicio.before(parcPg.getDataVencimento()))
                                    || comparador(fim, parcPg.getDataVencimento()) || comparador(inicio, parcPg.getDataVencimento())) {

                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);

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

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                            if (rdbEmAberto.isSelected()) {
                                if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);
                                }
                            }
                            if (rdbVencidos.isSelected()) {
                                if (parcPg.getDataVencimento().before(referencia)) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);
                                }
                            }

                            if (rdbTodosTipoCliente.isSelected()) {

                                TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                tabela.setDtLancamento(vo.getDataLancamento());
                                tabela.setDtVencimento(parcPg.getDataVencimento());
                                tabela.setNome(vo.getNomeFornecedor());
                                tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                tabela.setValor((float) parcPg.getValorOriginal());

                                listaFinal.add(tabela);

                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                            if (inicio.before(vo.getDataLancamento()) || comparador(inicio, vo.getDataLancamento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                            if ((fim.after(vo.getDataLancamento()) && inicio.before(vo.getDataLancamento()))
                                    || comparador(fim, vo.getDataLancamento()) || comparador(inicio, vo.getDataLancamento())) {

                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);
                                }
                            }
                        }

                    }
                    if (cmbOpcaoPesquisa.getValue().equals("Dt Vencimento")) {

                        if (dtpFinal.getValue() != null && dtpInicial.getValue() == null) {
                            /*
                             arrumar aqui!!
                             */

                            if ((fim.after(parcPg.getDataVencimento())) || comparador(fim, parcPg.getDataVencimento())) {

                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() == null) {

                            if (rdbEmAberto.isSelected()) {
                                if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);
                                }
                            }
                            if (rdbVencidos.isSelected()) {
                                if (parcPg.getDataVencimento().before(referencia)) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);
                                }
                            }

                            if (rdbTodosTipoCliente.isSelected()) {

                                TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                tabela.setDtLancamento(vo.getDataLancamento());
                                tabela.setDtVencimento(parcPg.getDataVencimento());
                                tabela.setNome(vo.getNomeFornecedor());
                                tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                tabela.setValor((float) parcPg.getValorOriginal());

                                listaFinal.add(tabela);

                            }

                        }
                        if (dtpFinal.getValue() == null && dtpInicial.getValue() != null) {

                            if (inicio.before(parcPg.getDataVencimento()) || comparador(inicio, parcPg.getDataVencimento())) {
                                if (rdbEmAberto.isSelected()) {
                                    if ((parcPg.getDataVencimento().after(referencia)) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);

                                }
                            }
                        }
                        if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {

                            if ((fim.after(parcPg.getDataVencimento()) && inicio.before(parcPg.getDataVencimento()))
                                    || comparador(fim, parcPg.getDataVencimento()) || comparador(inicio, parcPg.getDataVencimento())) {

                                if (rdbEmAberto.isSelected()) {
                                    if (parcPg.getDataVencimento().after(referencia) || comparador(parcPg.getDataVencimento(), referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }
                                if (rdbVencidos.isSelected()) {
                                    if (parcPg.getDataVencimento().before(referencia)) {

                                        TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                        tabela.setDtLancamento(vo.getDataLancamento());
                                        tabela.setDtVencimento(parcPg.getDataVencimento());
                                        tabela.setNome(vo.getNomeFornecedor());
                                        tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                        tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                        tabela.setValor((float) parcPg.getValorOriginal());

                                        listaFinal.add(tabela);
                                    }
                                }

                                if (rdbTodosTipoCliente.isSelected()) {

                                    TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();

                                    tabela.setDtLancamento(vo.getDataLancamento());
                                    tabela.setDtVencimento(parcPg.getDataVencimento());
                                    tabela.setNome(vo.getNomeFornecedor());
                                    tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                                    tabela.setCnpj(vo.getFornecedorVO().getCNPJ());
                                    tabela.setValor((float) parcPg.getValorOriginal());

                                    listaFinal.add(tabela);

                                }
                            }
                        }

                    }
                }
            }

        }
        this.tblContas_a_pagar.setItems(listaFinal);
    }
    
    

    @FXML
    void btnBaixarDivida_onAction(ActionEvent event) throws Exception {
        
        
    }

    @FXML
    void cmbOpcaoPesquisa_onAction(ActionEvent event) {
        btnProcurar_onAction(event);
    }

    @FXML
    void btnSair_onAction(ActionEvent event) {

        getPai(frmContasPagar);

    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            getPai(frmContasPagar);
        }
    }

    @FXML
    void dtpInicial_onKeyPressed(KeyEvent event) {
        btnProcurar_onKeyPressed(event);
    }

    private void getPai(Node node) {
        Node aux = node.getParent();
        while (!(aux instanceof BorderPane)) {
            aux = node.getParent();
        }
        ((BorderPane) aux).setCenter(null);
    }

    @FXML
    void dtpFinal_onKeyPressed(KeyEvent event) {
        btnProcurar_onKeyPressed(event);
    }

    @FXML
    void dtpInicial_onAction(ActionEvent event) {
        btnProcurar_onAction(event);
    }

    private boolean validar_data(LocalDate inicio, LocalDate fim) {
        if (fim.isAfter(inicio) || fim.equals(inicio)) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void dtpFinal_onAction(ActionEvent event) {

        btnProcurar_onAction(event);
    }

    @FXML
    void cmbFormaPgto_onAction(ActionEvent event) {
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
            btnProcurar_onKeyPressed(event);

        }

    }

    @FXML
    void txtNomeRazaoSocial_onKeyPressed(KeyEvent event) {
        if (txtNomeRazaoSocial.getText().isEmpty()) {

            if (event.getCode() == KeyCode.TAB) {
                txtCpfCnpj.setDisable(false);
            } else {
                txtCpfCnpj.setDisable(true);
            }

        }
        if (event.getCode() == KeyCode.ENTER) {
            btnProcurar_onKeyPressed(event);

        }

    }

    @FXML
    void btnProcurar_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {
                if (validar_data(dtpInicial.getValue(), dtpFinal.getValue())) {
                    busca();
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
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
    void txtNomeRazaoSocial_onKeyReleased(KeyEvent event) {
        if (txtNomeRazaoSocial.getText().isEmpty()) {
            txtCpfCnpj.setDisable(false);
        }
    }

    @FXML
    void txtCpfCnpj_onKeyReleased(KeyEvent event) {
        if (txtCpfCnpj.getText().isEmpty()) {
            txtNomeRazaoSocial.setDisable(false);
        }
    }

    @FXML
    void btnProcurar_onAction(ActionEvent event) {
        if (dtpFinal.getValue() != null && dtpInicial.getValue() != null) {
            if (validar_data(dtpInicial.getValue(), dtpFinal.getValue())) {
                busca();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
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
        rdbVencidos.setSelected(false);
        rdbTodosTipoCliente.setSelected(false);
        if (!rdbEmAberto.isSelected()) {
            rdbEmAberto.setSelected(true);
        }
        btnProcurar_onAction(event);
    }

    @FXML
    void rdbVencidos_onAction(ActionEvent event) {
        if (!rdbVencidos.isSelected()) {
            rdbVencidos.setSelected(true);
        }
        rdbEmAberto.setSelected(false);
        rdbTodosTipoCliente.setSelected(false);
        btnProcurar_onAction(event);
    }

    @FXML
    void rdbTodosTipoCliente_onAction(ActionEvent event) {
        if (!rdbTodosTipoCliente.isSelected()) {
            rdbTodosTipoCliente.setSelected(true);
        }
        rdbEmAberto.setSelected(false);
        rdbVencidos.setSelected(false);
        btnProcurar_onAction(event);

    }

    private void busca() {
        List<CompraEntity> dado = new ArrayList<>();
        if (txtNomeRazaoSocial.getText().equals("") && txtCpfCnpj.getText().equals("")) {
            List<CompraEntity> listaCompraT;
            listaCompraT = compra.buscarTodasCompras();
            completar(listaCompraT);
            return;
        }
        for (int i = 0; i < ListaCompra.size(); i++) {
            if (!txtNomeRazaoSocial.getText().equals("")) {

                if (ListaCompra.get(i).getNomeFornecedor().toUpperCase().contains(txtNomeRazaoSocial.getText().toUpperCase())) {
                    dado.add(ListaCompra.get(i));
                }
            }
            if (!txtCpfCnpj.getText().equals("")) {
                if (ListaCompra.get(i).getFornecedorVO().getCNPJ().contains(txtCpfCnpj.getText())) {
                    dado.add(ListaCompra.get(i));
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

    @FXML
    void tblContas_a_pagar_onMouseClicked(MouseEvent event) {
        if (event.getClickCount() >= 1) {
            if(tblContas_a_pagar.getSelectionModel().getSelectedItem() == null) return;
            tabRelatorioResumido.setDisable(false);
        }
        TabelaTelaContasAPagar pagar = tblContas_a_pagar.getSelectionModel().getSelectedItem();
        lblDocumentoValor.setText("  "+pagar.getCnpj());
        lblNomeRazaoSocialValor.setText("  "+pagar.getNome());
        lblVencimentoValor.setText("  "+pagar.getDtVencimento());
        lblValorValor.setText("  $"+pagar.getValor());
        
    }

}
