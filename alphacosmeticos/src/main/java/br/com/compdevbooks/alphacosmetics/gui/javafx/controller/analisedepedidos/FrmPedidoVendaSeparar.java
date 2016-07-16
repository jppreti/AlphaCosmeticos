/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FrmPedidoVendaSeparar {

    @FXML
    private TextField txtNomeVendedor;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Label lblFiltrarPor;

    @FXML
    private Label lblIDVenda;

    @FXML
    private Label lblDtLancamento;

    @FXML
    private CheckBox ckbQtde;

    @FXML
    private RadioButton rdbProx10Dias;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label lblNomeVendedor;

    @FXML
    private Label lblOrdenarPor;

    @FXML
    private TableColumn<?, ?> clmPedidoVendaID;

    @FXML
    private RadioButton rdbProxSemana;

    @FXML
    private TableView<?> tblPedidoVenda;

    @FXML
    private RadioButton rdbProx60Dias;

    @FXML
    private TableColumn<?, ?> clmPedidoVendaQtdeTotal;

    @FXML
    private Label lblDtAprovacao;

    @FXML
    private TableColumn<?, ?> clmPedidoVendaDtPrevisto;

    @FXML
    private TextField txtDtAprovacao;

    @FXML
    private TableColumn<?, ?> clmPedidoVendaProduto;

    @FXML
    private TextField txtIDVenda;

    @FXML
    private TextField txtDtEntrega;

    @FXML
    private TextField txtDtLancamento;

    @FXML
    private Label lblDtEntrega;

    @FXML
    private Button btnSair;

    @FXML
    private Label lblPedidoVendaSeparacao;

    @FXML
    private RadioButton rdbProx30Dias;

    @FXML
    void btnSair_onAction(ActionEvent event) {

    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void rdbProx60Dias_onAction(ActionEvent event) {

    }

    @FXML
    void rdbProx30Dias_onAction(ActionEvent event) {

    }

    @FXML
    void rdbProx10Dias_onAction(ActionEvent event) {

    }

    @FXML
    void rdbProxSemana_onAction(ActionEvent event) {

    }

    @FXML
    void ckbQtde_onAction(ActionEvent event) {

    }

    @FXML
    void btnConfirmar_onAction(ActionEvent event) {

    }

    @FXML
    void btnConfirmar_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnCancelar_onAction(ActionEvent event) {

    }

    @FXML
    void btnCancelar_onKeyPressed(KeyEvent event) {

    }

}
