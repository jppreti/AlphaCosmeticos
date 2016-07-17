/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoVendaEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.MaskFieldUtil;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.NavegarObjetos;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaAnaliseEstoque;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

public class FrmPedidoVendaAnaliseEstoque {

    @FXML
    private TextField txtNomeVendedor;

    @FXML
    private Button btnRecusar;

    @FXML
    private Label lblIDVenda;

    @FXML
    private TableColumn<TabelaAnaliseEstoque, Float> clmItemVendaQtdeEstoque;

    @FXML
    private TableColumn<TabelaAnaliseEstoque, String> clmItemVendaDtPrevista;

    @FXML
    private Label lblDtLancamento;

    @FXML
    private TableColumn<TabelaAnaliseEstoque, Float> clmItemVendaQtdeReservada;

    @FXML
    private TextField txtIDVenda;

    @FXML
    private TableColumn<TabelaAnaliseEstoque, String> clmItemVendaProduto;

    @FXML
    private Button btnAprovar;

    @FXML
    private TableColumn<TabelaAnaliseEstoque, Float> clmItemVendaQtdePedida;

    @FXML
    private TableColumn<TabelaAnaliseEstoque, Float> clmItemVendaQtdePrevista;

    @FXML
    private Label lblPedidoVendaAnaliseEstoque;

    @FXML
    private TextField txtDtLancamento;

    @FXML
    private Button btnSair;

    @FXML
    private Label lblValorTotal;

    @FXML
    private Label lblNomeVendedor;

    @FXML
    private TableColumn<TabelaAnaliseEstoque, Long> clmItemVendaID;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TableView<TabelaAnaliseEstoque> tblItemVenda;
    
    private VendaEntity venda;
    private List<TabelaAnaliseEstoque> lista;
   
    
    
    @FXML
    void initialize(){
        venda= NavegarObjetos.getVenda();
        lista= new ArrayList();
        MaskFieldUtil.dateField(this.txtDtLancamento);
        
        this.txtIDVenda.setText(String.valueOf(venda.getId()));
        this.txtValorTotal.setText(String.valueOf(venda.getValorTotal()));
        
        System.out.println(venda.getId());
        Iterator<ItemVendaEntity> interator= venda.getListaItens().iterator();
        ItemVendaEntity item;
        while(interator.hasNext()){
            item=interator.next();
            lista.add(new TabelaAnaliseEstoque((item)));
        }
        completarTable();
    }
    private void completarTable(){
        this.clmItemVendaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.clmItemVendaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        this.clmItemVendaQtdeEstoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
        this.clmItemVendaQtdePedida.setCellValueFactory(new PropertyValueFactory<>("pedida"));
        this.clmItemVendaQtdePrevista.setCellValueFactory(new PropertyValueFactory<>("qtdePrevista"));
        this.clmItemVendaQtdeReservada.setCellValueFactory(new PropertyValueFactory<>("qtdeReservada"));
        
        this.tblItemVenda.setItems(FXCollections.observableArrayList(lista));
    }
    
    
    @FXML
    void btnSair_onAction(ActionEvent event) {
        chamarPai();
        
    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            chamarPai();
        }
    }

    @FXML
    void btnAprovar_onAction(ActionEvent event) {
        AceitarDialog();
    }

    @FXML
    void btnAprovar_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
            AceitarDialog();
    }

    @FXML
    void btnRecursar_onAction(ActionEvent event) {
            RecusarDialog();
    }

    @FXML
    void btnRecursar_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
            RecusarDialog();
    }
    private void chamarPai(){
        BorderPane frmPedidoVendaGerenteEstoque=null;
        try{
            frmPedidoVendaGerenteEstoque= FXMLLoader.load(FrmPedidoVendaGerenteEstoque.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoVendaGerenteEstoque.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            ((BorderPane)NavegarObjetos.getPai()).setCenter(frmPedidoVendaGerenteEstoque);
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        NavegarObjetos.setVenda(null);
    }
    private void AceitarDialog(){
        Alert caixa= new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType sim= new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");
        caixa.setTitle("AlphaComesticos");
        caixa.setHeaderText("Análise de estoque");
        caixa.setContentText("Deseja aceita pedido?");
        caixa.getButtonTypes().setAll(sim,nao);
        
        caixa.showAndWait().ifPresent(p->{ 
            if(p==sim){
              venda.setSituacao(SituacaoVendaEnum.ANALISE);
                System.out.println("saida");
                chamarPai();
            }
            if(p==nao){}
               
            
        });
    }
    
    
    private void RecusarDialog(){
        Alert caixa= new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType sim= new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");
        caixa.setTitle("AlphaComesticos");
        caixa.setHeaderText("Análise de estoque");
        caixa.setContentText("Deseja recusar pedido?");
        caixa.getButtonTypes().setAll(sim,nao);
        
        caixa.showAndWait().ifPresent(p->{ 
            if(p==sim){
              venda.setSituacao(SituacaoVendaEnum.RECUSADA);
                System.out.println("saida");
                chamarPai();
            }
            if(p==nao){}
               
            
        });
        
    }
   

}
