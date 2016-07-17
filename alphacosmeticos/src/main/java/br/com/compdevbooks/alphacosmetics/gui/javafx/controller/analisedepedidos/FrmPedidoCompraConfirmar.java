/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FrmPedidoCompraConfirmar {

    @FXML
    private Button btnConfirmar;

    @FXML
    private TableColumn<?, ?> clmItemPedidoQtdePedida;

    @FXML
    private Label lblIDVenda;

    @FXML
    private Label lblDtRecebimento;

    @FXML
    private TextField txtProduto;

    @FXML
    private TableColumn<?, ?> clmItemPedidoConfProduto;

    @FXML
    private DatePicker dtpDtRecebimento;

    @FXML
    private TextField txtQtdeRecebida;

    @FXML
    private Label lblDtLancamento;

    @FXML
    private Label lblProduto;

    @FXML
    private TextField txtID;

    @FXML
    private Label lblQtdeRecebida;

    @FXML
    private TableColumn<?, ?> clmItemPedidoProduto;

    @FXML
    private TableColumn<?, ?> clmItemPedidoConfID;

    @FXML
    private Button btnConfirmarRecebimento;

    @FXML
    private TextField txtIDVenda;

    @FXML
    private Label lblQtdeTotal;

    @FXML
    private Label lblID;

    @FXML
    private TextField txtDtLancamento;

    @FXML
    private TextField txtQtdeTotal;

    @FXML
    private TableView<?> tblItemPedidoConf;

    @FXML
    private TableColumn<?, ?> clmItemPedidoConfQtdeRecebida;

    @FXML
    private Label lblPedidoCompraConferir;

    @FXML
    private Button btnSair;

    @FXML
    private TableView<?> tblItemPedido;

    @FXML
    private Label lblValorTotal;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TableColumn<?, ?> clmItemPedidoID;

    @FXML
    void btnSair_onAction(ActionEvent event) {

    }

    @FXML
    void btnSair_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnConfirmar_onAction(ActionEvent event) {

    }

    @FXML
    void btnConfirmar_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void dtpDtRecebimento_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnConfirmarRecebimento_onAction(ActionEvent event) {

    }

    @FXML
    void btnConfirmarRecebimento_onKeyPressed(ActionEvent event) {

    }

}
