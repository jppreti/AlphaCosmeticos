package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Comissao;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.produto.ComissaoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ParcelaComissaoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaComissao;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import javafx.scene.input.MouseEvent;

public class FrmComissao {

    @FXML
    private Tab tabRelatorio;

    @FXML
    private DatePicker dtpFinal;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtVendedor;

    @FXML
    private Label lblDataFinal;

    @FXML
    private TableColumn<TabelaTelaComissao, String> clmValorComissaoRelatorio;

    @FXML
    private Button btnProcurar;

    @FXML
    private TextField txtRegiao;

    @FXML
    private TableColumn<TabelaTelaComissao, String> clmCliente;

    @FXML
    private TableColumn<TabelaTelaComissao, String> clmValorVenda;

    @FXML
    private Button btnPagarComissao;

    @FXML
    private TableColumn<TabelaTelaComissao, String> clmNome;

    @FXML
    private Label lblVendedor;

    @FXML
    private Tab tabComissao;

    @FXML
    private Button btnGerarRealatorio;

    @FXML
    private Label lblStatus;

    @FXML
    private TableColumn<TabelaTelaComissao, String> clmdtPrevista;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblDataInicial;

    @FXML
    private Button btnSair;

    @FXML
    private TableColumn<TabelaTelaComissao, String> clmDataVenda;

    @FXML
    private Label lblRegiao;

    @FXML
    private DatePicker dtpInicial;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TableColumn<TabelaTelaComissao, String> clmValorComissao;

    @FXML
    private BorderPane frmComissao;

    @FXML
    private TableView<TabelaTelaComissao> tblRelatorio;

    @FXML
    private TableView<TabelaTelaComissao> tblComissao;

    @FXML
    private TabPane tbpComissao;

    @FXML
    private TableColumn<TabelaTelaComissao, String> clmNomeRelatorio;

    @FXML
    private TableColumn<TabelaTelaComissao, String> clmdtPrevistaRelatorio;

    @FXML
    private TableColumn<TabelaTelaComissao, String> clmSituacaoParcelaVenda;

    private Comissao comissao = new Comissao(DAOFactory.getDAOFactory().getComissaoDAO());
    private String path;
    private String pathToReportPackage;
    List<ComissaoEntity> listaComissoes;

    public FrmComissao() {
        this.path = this.getClass().getClassLoader().getResource("").getPath();
        this.pathToReportPackage = this.path + "br\\com\\compdevbooks\\alphacosmetics\\gui\\javafx\\jasper\\";
        System.out.println(path+" "+"aqui");
    }

    @FXML
    void initialize() {

        listaComissoes = comissao.buscarTodasComissoes();
        Date data = new Date();
        LocalDate dtlocal = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dtpFinal.setValue(dtlocal);
        data.setDate(data.getDate() - 7);
        dtlocal = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dtpInicial.setValue(dtlocal);

        completar(listaComissoes);

    }

    public String getPathToReportPackage() {
        return this.pathToReportPackage;
    }

    public String getPath() {
        return this.path;
    }

    void completar(List<ComissaoEntity> lista) {
        ObservableList<TabelaTelaComissao> listaFinal = FXCollections.observableArrayList();
        this.clmNome.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("nome"));
        this.clmdtPrevista.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("dataPrevista"));
        this.clmValorComissao.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("valor"));
        this.clmDataVenda.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("dataVenda"));
        this.clmValorVenda.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("valorVenda"));
        this.clmValorComissaoRelatorio.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("valor"));
        this.clmCliente.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("Cliente"));
        this.clmdtPrevistaRelatorio.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("dataPrevista"));
        this.clmNomeRelatorio.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("nome"));
        this.clmSituacaoParcelaVenda.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("SituacaoParcela"));
        int cont = 0;

        for (ComissaoEntity vo : lista) {
            for (ParcelaComissaoEntity parcCom : vo.getListaParcelaComissao()) {
                if (parcCom.getDataPagamento() == null) {
                    TabelaTelaComissao tabela = new TabelaTelaComissao();
                    tabela.setNome(vo.getVendedor().getNome());
                    tabela.setDataPrevista(parcCom.getDataVencimento());
                    System.out.println(parcCom.getDataVencimento() + " teste");
                    tabela.setValor(Float.toString(parcCom.getValorParcela()));
                    tabela.setDataVenda(vo.getDataVenda());
                    System.out.println(vo.getDataVenda());
                    tabela.setValorVenda(Float.toString(vo.getVenda().getValorTotal()));
                    tabela.setValorComissaoRelatorio(Float.toString(parcCom.getValorParcela()));
                    tabela.setCliente(vo.getVenda().getNomeCliente());
                    tabela.setId(parcCom.getId());
                    if (parcCom.getDataPagamento() != null) {
                        tabela.setSituacaoParcela("Pago");
                    } else {
                        tabela.setSituacaoParcela("Não Pago");
                    }
                    listaFinal.add(tabela);
                    cont++;
                }
            }
            cont = 0;

        }
        this.tblComissao.setItems(listaFinal);
        this.tblRelatorio.setItems(listaFinal);
    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            getPai(frmComissao);
        }

    }

    @FXML
    void btnSair_onAction(ActionEvent event) {

        getPai(frmComissao);

    }

    private void getPai(Node node) {
        Node aux = node.getParent();
        while (!(aux instanceof BorderPane)) {
            aux = node.getParent();
        }
        ((BorderPane) aux).setCenter(null);
    }

    @FXML
    void btnGerarRealatorio_onAction(ActionEvent event) throws Exception {
        imprimir();
    }

    @FXML
    void txtVendedor_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            busca();
        }

    }

    @FXML
    void dtpInicial_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void txtRegiao_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void dtpFinal_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnProcurar_onAction(ActionEvent event) {

    }

    @FXML
    void txtValorTotal_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnPagarComissao_onAction(ActionEvent event) {
        TabelaTelaComissao telaComissao;

        telaComissao = tblComissao.getSelectionModel().getSelectedItem();

        ParcelaComissaoEntity aux = null;
        
        if(telaComissao == null){
            System.out.println("erro aqui");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pagamento de comissão");
            alert.setHeaderText(null);
            alert.setContentText("Selecione uma linha");
            alert.showAndWait();
            return;
        }    
            
        if (telaComissao.getSituacaoParcela() == "Pago") {
            for (ComissaoEntity com : comissao.buscarTodasComissoes()) {
                for (ParcelaComissaoEntity parc : com.getListaParcelaComissao()) {
                    System.out.println(telaComissao.getId());
                    if (parc.getId().equals(telaComissao.getId())) {
                        aux = parc;
                    }

                }

                com.getListaParcelaComissao().remove(aux);

            }
            busca();
        } else {
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Pagamento de comissão");
            alert2.setHeaderText(null);
            alert2.setContentText("Comissão não pode ser paga, parcela cliente em aberto");
            alert2.showAndWait();
            System.out.println("não pode pagar");
        }

        //
    }

    @FXML
    void tblComissao_onMouseClicked(MouseEvent event) {
        TabelaTelaComissao com = tblComissao.getSelectionModel().getSelectedItem();
        if (event.getClickCount() >= 1) {
            txtValorTotal.setText(com.getValorComissaoRelatorio());
        }
        //

        if (event.getClickCount() >= 2) {
            tbpComissao.getSelectionModel().select(tabRelatorio);
        }

    }

    public void imprimir() throws Exception {

        System.out.println("ok");

        JasperReport report = JasperCompileManager.compileReport("F:\\AlphaCosmeticos\\src\\main\\java\\br\\com\\compdevbooks\\alphacosmetics\\jasper\\Comissao.jrxml");
        System.out.println("ok2");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(tblComissao.getItems()));

        JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Roberto Junior\\Documents\\NetBeansProjects\\Relatorio_de_Comissoes.pdf");

    }

    private void busca() {
        List<ComissaoEntity> dado = new ArrayList<>();

        if (txtVendedor.getText().equals("")) {
            completar(dado);
        }

        for (int i = 0; i < listaComissoes.size(); i++) {
            if (listaComissoes.get(i).getVendedor().getNome().toUpperCase().contains(txtVendedor.getText().toUpperCase())) {
                dado.add(listaComissoes.get(i));
            }
        }
        completar(dado);
    }

}
