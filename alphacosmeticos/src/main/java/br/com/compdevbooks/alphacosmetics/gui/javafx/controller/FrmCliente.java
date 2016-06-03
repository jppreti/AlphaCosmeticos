package br.com.compdevbooks.alphacosmetics.gui.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

public class FrmCliente {

    @FXML
    private Button btnConfirmar;

    @FXML
    private TextField txtPesqNome;

    @FXML
    private Label lblPesqNome;

    @FXML
    private HBox hbxEditButtons;

    @FXML
    private Tab tabClientes;

    @FXML
    private Label lblCodigoValue;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefone;

    @FXML
    private Label lblEmail;

    @FXML
    private VBox vbxBottom;

    @FXML
    private TableView<?> tblClientes;

    @FXML
    private Label lblStatus;

    @FXML
    private GridPane grdEdicao;

    @FXML
    private Button btnProcurar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TabPane tbpCliente;

    @FXML
    private Label lblTelefone;

    @FXML
    private Tab tabEdicao;

    @FXML
    private Button btnExcluir;

    @FXML
    private Label lblCodigo;

    @FXML
    private Label lblNome;

    @FXML
    private Button btnNovo;

    @FXML
    void btnNovo_onAction(ActionEvent event) {
    	lblStatus.setText("Cadastrando novo cliente.");
    	habilitarEdicao(true);
    }

    @FXML
    void btnConfirmar_onAction(ActionEvent event) {
    	lblStatus.setText("Cliente salvo com sucesso.");    	
    	habilitarEdicao(false);
    }

    @FXML
    void btnAlterar_onAction(ActionEvent event) {
    	lblStatus.setText("Alterando dados do cliente.");
    	habilitarEdicao(true);
    }

    @FXML
    void btnCancelar_onAction(ActionEvent event) {
    	lblStatus.setText("Edição cancelada.");
    	habilitarEdicao(false);
    }

    @FXML
    void btnExcluir_onAction(ActionEvent event) {
    	lblStatus.setText("Cliente excluído com sucesso.");
    }

    @FXML
    void txtPesqNome_onKeyPressed(KeyEvent event) {
    	if (event.getCode() == KeyCode.ENTER)
    		btnProcurar.fire();
    }

    @FXML
    void btnProcurar_onAction(ActionEvent event) {
    	lblStatus.setText("Buscando " + txtPesqNome.getText());
    }

    void habilitarEdicao(boolean sim) {
    	if (sim) {
    		btnNovo.setDisable(sim);
    		btnConfirmar.setDisable(!sim);
    		btnAlterar.setDisable(sim);
    		btnCancelar.setDisable(!sim);
    		btnExcluir.setDisable(sim);
    	} else {
    		btnNovo.setDisable(!sim);
    		btnConfirmar.setDisable(sim);
    		btnAlterar.setDisable(!sim);
    		btnCancelar.setDisable(sim);
    		btnExcluir.setDisable(!sim);    		
    	}
    }
}
