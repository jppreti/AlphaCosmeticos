package br.com.compdevbooks.alphacosmetics.gui.javafx.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class FrmPrincipal {

    @FXML
    private MenuItem mniVenda;

    @FXML
    private MenuItem mniSair;

    @FXML
    private Menu mnuOperacoes;

    @FXML
    private BorderPane bdpPrincipal;

    @FXML
    private MenuBar mnbPrincipal;

    @FXML
    private MenuItem mniCliente;

    @FXML
    private MenuItem mniSobre;

    @FXML
    private Menu mnuCadastro;

    @FXML
    private Menu mnuAjuda;

    @FXML
    void mniCliente_onAction(ActionEvent event) {
        BorderPane frmCliente = null;
        
        try{
            frmCliente = FXMLLoader.load(FrmCliente.class.getClassLoader().getResource("gui//FrmCliente.fxml"));
            bdpPrincipal.setCenter(frmCliente);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }    	
    }

    @FXML
    void mniSair_onAction(ActionEvent event) {
    	System.exit(0);
    }

}
