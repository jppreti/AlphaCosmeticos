package br.com.compdevbooks.alphacosmetics.gui.javafx.controller;

import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.NavegarObjetos;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos.FrmPedidoCompra;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos.FrmPedidoVendaGerenteEstoque;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos.FrmPedidoVendaGerenteVendas;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.cadastro.FrmCliente;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.cadastro.FrmProduto;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro.FrmComissao;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro.FrmContas_a_pagar;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro.FrmContas_a_receber;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.operacoes.FrmCompra;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.produto.FrmEstoque;
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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
    private ScrollBar sbaLateral;

    
    @FXML
    void initialize(){
        NavegarObjetos.setPai(bdpPrincipal);
    }
    
    @FXML
    void mniFinComissao_onAction(ActionEvent event) {
        
    BorderPane frmComissao = null;
           
            try{
            
                  frmComissao= FXMLLoader.load(FrmComissao.class.getClassLoader().getResource("gui//financeiro//Comissao.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
                  bdpPrincipal.setCenter(frmComissao);
                 
            }catch(IOException ioe){
                ioe.printStackTrace();
               
            }

    }
    
    
    @FXML
    void sbaLateral_onDragDetected(DragEvent event) {
     sbaLateral.setTranslateY(10);
    }
    
    @FXML
    void mniFinContaPagar_onAction(ActionEvent event)  {
        
           BorderPane frmContasPagar = null;
           
            try{
            
                  frmContasPagar= FXMLLoader.load(FrmContas_a_pagar.class.getClassLoader().getResource("gui//financeiro//Contas_a_pagar.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
                  bdpPrincipal.setCenter(frmContasPagar);
                 
            }catch(IOException ioe){
                ioe.printStackTrace();
               
            }
    }

    @FXML
    void mniFinContaReceber_onAction(ActionEvent event) {
        
        BorderPane frmContasReceber = null;
           
            try{
            
                  frmContasReceber= FXMLLoader.load(FrmContas_a_receber.class.getClassLoader().getResource("gui//financeiro//Contas_a_receber.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
                  bdpPrincipal.setCenter(frmContasReceber);
                 
            }catch(IOException ioe){
                ioe.printStackTrace();
               
            }

    }


    @FXML
    void mniProdEstoque_onAction(ActionEvent event) {
        BorderPane frmEstoque=null;
        try{
            frmEstoque = FXMLLoader.load(FrmEstoque.class.getClassLoader().getResource("gui//produto//estoque.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            bdpPrincipal.setCenter(frmEstoque);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }  
    }
    
    @FXML
    void mniCliente_onAction(ActionEvent event) {
      /*  BorderPane frmCliente = null;
        
        try{
            frmCliente = FXMLLoader.load(FrmCliente.class.getClassLoader().getResource("gui/FrmCliente.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            bdpPrincipal.setCenter(frmCliente);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }*/    	
    }
    
    @FXML
    void mniFornecedor_onAction(ActionEvent event) {
      /*  BorderPane frmCliente = null;
        
        try{
            frmCliente = FXMLLoader.load(FrmCliente.class.getClassLoader().getResource("gui/FrmCliente.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            bdpPrincipal.setCenter(frmCliente);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }*/    	
    }
    
    @FXML
    void mniVendedor_onAction(ActionEvent event) {
      /*  BorderPane frmCliente = null;
        
        try{
            frmCliente = FXMLLoader.load(FrmCliente.class.getClassLoader().getResource("gui/FrmCliente.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            bdpPrincipal.setCenter(frmCliente);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }*/    	
    }
    
    @FXML
    void mniSobre_onAction(ActionEvent event) {
        VBox frmSobre = null;
        try{
            frmSobre = FXMLLoader.load(FrmPrincipal.class.getClassLoader().getResource("gui\\FrmSobre.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            bdpPrincipal.setCenter(frmSobre);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }    	
    }

    @FXML //Add inicio - Evento Aba Produto
        void mniProduto_onAction(ActionEvent event) {
            BorderPane frmProduto = null;

            try{
                frmProduto = FXMLLoader.load(FrmProduto.class.getClassLoader().getResource("gui/FrmProduto.fxml"));//,ResourceBundle.getBundle("gui/i18N"));
                bdpPrincipal.setCenter(frmProduto);
            }catch (IOException ioe){
                ioe.printStackTrace();
            }    	
        }//Add fim
    
    @FXML
    void mniPedidoVenda_onAction(ActionEvent event) {
      /*
        BorderPane frmPedidoVendaGerenteVenda= null;
        try{
            frmPedidoVendaGerenteVenda= FXMLLoader.load(FrmPedidoVendaGerenteVendas.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoVendaGerenteVendas.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            bdpPrincipal.setCenter(frmPedidoVendaGerenteVenda);
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        //controle de acesso
        */
     
        
        BorderPane frmPedidoVendaGerenteEstoque=null;
        try{
            frmPedidoVendaGerenteEstoque= FXMLLoader.load(FrmPedidoVendaGerenteEstoque.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoVendaGerenteEstoque.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            bdpPrincipal.setCenter(frmPedidoVendaGerenteEstoque);
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        
                

    }
       @FXML
    void mniOpCompra_onAction(ActionEvent event){
        BorderPane frmCompra=null;
        try{
            frmCompra= FXMLLoader.load(FrmCompra.class.getClassLoader().getResource("gui/operacoes/compra_final.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            bdpPrincipal.setCenter(frmCompra);
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }
    
    @FXML
    void mniPedCompra_onAction(ActionEvent event){
        BorderPane frmCompra=null;
        try{
            frmCompra= FXMLLoader.load(FrmPedidoCompra.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoCompra.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            bdpPrincipal.setCenter(frmCompra);
            NavegarObjetos.setPedidoCompra(frmCompra);
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

 
    @FXML
    void mniSair_onAction(ActionEvent event) {
    	System.exit(0);
    }

}
