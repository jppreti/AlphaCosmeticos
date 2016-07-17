package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
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
    private BorderPane frmComissao;
        
        @FXML
        void initialize(){

                Date data = new Date();
               
                LocalDate dtlocal = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                dtpFinal.setValue(dtlocal);
                
                data.setDate(data.getDate()-7);
                
                dtlocal = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                dtpInicial.setValue(dtlocal);
                
               
                
                
                }
         @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
           
        if(event.getCode()==KeyCode.ENTER){
           getPai(frmComissao);
        }
        
    }
        

    @FXML
    void btnSair_onAction(ActionEvent event) {
        
        getPai(frmComissao);

    }
       private void getPai(Node node){
        Node aux = node.getParent();
        while(!(aux instanceof BorderPane)){
            aux=node.getParent();
        }
        ((BorderPane)aux).setCenter(null);
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
