/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.produto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FrmEstoque {

    @FXML
    private TextField txtFornecedor;

    @FXML
    private TextField txtPercComi;

    @FXML
    private TextField txtProduto;

    @FXML
    private TextField txtNome;

    @FXML
    private Tab tabDetalhe;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblCategoria;

    @FXML
    private TableColumn<?, ?> clmProdutoProduto;

    @FXML
    private Label lblPercComi;

    @FXML
    private TextField txtMargemLucro;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TableView<?> tblProduto;

    @FXML
    private TableColumn<?, ?> clmProdutoFornecedor;

    @FXML
    private Label lblMargemLucro;

    @FXML
    private TableColumn<?, ?> clmProdutoCategoria;

    @FXML
    private Tab tabEstoque;

    @FXML
    private Label lblValorVenda;

    @FXML
    private ComboBox<?> cmbCategoria;

    @FXML
    private TextField txtEstoque;

    @FXML
    private Button btnPesquisar;

    @FXML
    private TableColumn<?, ?> clmProdutoQtdeReservada;

    @FXML
    private TextField txtValorVenda;

    @FXML
    private TextField txtValorCompra;

    @FXML
    private Label lblValorCompra;

    @FXML
    private TableColumn<?, ?> clmProdutoQtdeEsperada;

    @FXML
    private Label lblPercPromo;

    @FXML
    private Button btnCompra;

    @FXML
    private Button btnSair;

    @FXML
    private TableColumn<?, ?> clmProdutoQtdeEstoque;

    @FXML
    private TextField txtPercPromo;

    @FXML
    void btnCompra_onAction(ActionEvent event) {

    }

    @FXML
    void btnCompra_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnSair_onAction(ActionEvent event) {

    }

    @FXML
    void btnSair_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void txtProduto_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void cmbCategoria_onAction(ActionEvent event) {

    }

    @FXML
    void txtFornecedor_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void txtQtdeEstoque_onKeyPressed(ActionEvent event) {
    }
}
