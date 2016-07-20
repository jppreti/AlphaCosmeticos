package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Comissao;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.produto.ComissaoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ParcelaComissaoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaComissao;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

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
    private TableColumn<?, ?> clmValorComissaoRelatorio;

    @FXML
    private Button btnProcurar;

    @FXML
    private TextField txtRegiao;

    @FXML
    private TableColumn<?, ?> clmCliente;

    @FXML
    private TableColumn<TabelaTelaComissao, Float> clmValorVenda;

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
    private TableColumn<TabelaTelaComissao, String> clmRegiao;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblDataInicial;

    @FXML
    private Button btnSair;

    @FXML
    private TableColumn<TabelaTelaComissao, Date> clmDataVenda;

    @FXML
    private Label lblRegiao;

    @FXML
    private DatePicker dtpInicial;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TableColumn<TabelaTelaComissao, Float> clmValorComissao;

    @FXML
    private BorderPane frmComissao;
    
    @FXML
    private TableView<TabelaTelaComissao> tblRelatorio;
    
    @FXML
    private TableView<TabelaTelaComissao> tblComissao;
    
    private Comissao comissao = new Comissao(DAOFactory.getDAOFactory().getComissaoDAO());
    
    @FXML
    void initialize() {
        List<ComissaoEntity> listaComissoes;
        listaComissoes = comissao.buscarTodasComissoes();
        Date data = new Date();
        LocalDate dtlocal = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dtpFinal.setValue(dtlocal);
        data.setDate(data.getDate() - 7);
        dtlocal = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dtpInicial.setValue(dtlocal);

        completar(listaComissoes);

    }

    void completar(List<ComissaoEntity> lista) {
        ObservableList<TabelaTelaComissao> listaFinal = FXCollections.observableArrayList();
        this.clmNome.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("nome"));
        this.clmRegiao.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, String>("regiao"));
        this.clmValorComissao.setCellValueFactory(new PropertyValueFactory<TabelaTelaComissao, Float>("valor"));
        int cont = 0;

        for (ComissaoEntity vo : lista) {
            for (ParcelaComissaoEntity parcCom : vo.getListaParcelaComissao()) {
                cont++;
                TabelaTelaComissao tabela = new TabelaTelaComissao();

                tabela.setNome(vo.getVendedor().getNome());
                tabela.setValor((float)parcCom.getValorParcela());

                listaFinal.add(tabela);
            }
            cont = 0;

        }
        this.tblComissao.setItems(listaFinal);

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
    void btnGerarRealatorio_onAction(ActionEvent event) {

    }

    @FXML
    void txtVendedor_onKeyPressed(ActionEvent event) {

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

    }

}
