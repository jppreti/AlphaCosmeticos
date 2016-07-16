/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.NavegarObjetos;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class FrmPedidoCompraFinalizar {

    @FXML
    private Label lblRazaoSocial;

    @FXML
    private Label lblDtRecebimento;

    @FXML
    private TableColumn<?, ?> clmItemCompraQtdeTotal;

    @FXML
    private TableColumn<?, ?> clmItemCompraProduto;

    @FXML
    private Button btnFinalizar;

    @FXML
    private TextField txtInscricao;

    @FXML
    private TableColumn<?, ?> clmItemCompraID;

    @FXML
    private Label lblQtdeTotal;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private Label lblID;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtDtRecebimento;

    @FXML
    private TextField txtQtdeTotal;

    @FXML
    private Label lblCNPJ;

    @FXML
    private TableColumn<?, ?> clmItemCompraQtdeEstoque;

    @FXML
    private TextField txtRazaoSocial;

    @FXML
    private Button btnSair;

    @FXML
    private TextField lblValorTotal;

    @FXML
    private Label lblInscricao;

    @FXML
    private TableView<?> tblItemCompra;

    @FXML
    private TableColumn<?, ?> clmItemCompraQtdeRecebida;

    @FXML
    private Label lblPedidoCompraFinalizar;
       

    @FXML
    void btnFinalizar_onAction(ActionEvent event) {

    }

    @FXML
    void btnFinalizar_onKeyPressed(ActionEvent event) {

    }

}
