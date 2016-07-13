package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;


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
    private TableColumn<?, ?> clmValorVenda;

    @FXML
    private Button btnPagarComissao;

    @FXML
    private TableColumn<?, ?> clmNome;

    @FXML
    private Label lblVendedor;

    @FXML
    private Tab tabComissao;

    @FXML
    private Button btnGerarRealatorio;

    @FXML
    private Label lblStatus;

    @FXML
    private TableColumn<?, ?> clmRegiao;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblDataInicial;

    @FXML
    private Button btnSair;

    @FXML
    private TableColumn<?, ?> clmDataVenda;

    @FXML
    private Label lblRegiao;

    @FXML
    private DatePicker dtpInicial;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TableColumn<?, ?> clmValorComissao;

    @FXML
    void btnSair_onAction(ActionEvent event) {

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
