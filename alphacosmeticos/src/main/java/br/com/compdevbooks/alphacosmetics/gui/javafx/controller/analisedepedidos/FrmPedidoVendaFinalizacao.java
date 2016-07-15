/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class FrmPedidoVendaFinalizacao {

    @FXML
    private TextField txtNomeVendedor;

    @FXML
    private Button btnRecusar;

    @FXML
    private Button btnFinalizar;

    @FXML
    private TextField txtNome;

    @FXML
    private TableColumn<?, ?> clmQtdeVendida;

    @FXML
    private TextField txtIDVenda;

    @FXML
    private TextField txtDtEnvio;

    @FXML
    private TextField txtQtdeTotal;

    @FXML
    private TextField txDtLancamento;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtCidade;

    @FXML
    private TableColumn<?, ?> clmProduto;

    @FXML
    private TableColumn<?, ?> clmID;

    @FXML
    private TextField txtCEP;

    @FXML
    private TextField txtLogradouro;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TextField txtBairro;

    @FXML
    private TableView<?> tblItemVenda;

    @FXML
    private BorderPane bdpPrincipal;
    
    Venda venda = new Venda(DAOFactory.getDAOFactory().getVendaDAO());
    
    public void initialize(){
        
    
    }
    
    @FXML
    void btnSair_onAction(ActionEvent event) {

    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnFinalizar_onAction(ActionEvent event) {

    }

    @FXML
    void btnFinalizar_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnRecusar_onAction(ActionEvent event) {

    }

    @FXML
    void btnRecusar_onKeyPressed(KeyEvent event) {

    }
    
}

