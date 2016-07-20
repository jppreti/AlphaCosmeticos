/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoCompraEnum;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.MaskFieldUtil;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.NavegarObjetos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class FrmPedidoCompraConfirmar {

    @FXML
    private Button btnConfirmar;

    @FXML
    private TableColumn<ItemCompraEntity, Float> clmItemPedidoQtdePedida;

    @FXML
    private Label lblIDVenda;

    @FXML
    private Label lblDtRecebimento;

    @FXML
    private TextField txtProduto;

    @FXML
    private TableColumn<ItemCompraEntity, String> clmItemPedidoConfProduto;

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
    private TableColumn<ItemCompraEntity, String >clmItemPedidoProduto;

    @FXML
    private TableColumn<ItemCompraEntity, String> clmItemPedidoConfID;

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
    private TableView<ItemCompraEntity> tblItemPedidoConf;

    @FXML
    private TableColumn<ItemCompraEntity, Float> clmItemPedidoConfQtdeRecebida;

    @FXML
    private Label lblPedidoCompraConferir;

    @FXML
    private Button btnSair;

    @FXML
    private TableView<ItemCompraEntity> tblItemPedido;

    @FXML
    private Label lblValorTotal;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TableColumn<ItemCompraEntity, String> clmItemPedidoID;
    
    private CompraEntity compra;
    private Compra CompraNegocio= new Compra(DAOFactory.getDAOFactory().getCompraDAO());
    private Set<ItemCompraEntity> lista= new HashSet();
    
    @FXML
    void initialize(){
        compra=NavegarObjetos.getCompra();
        this.txtIDVenda.setText(String.valueOf(compra.getId()));
        this.txtQtdeTotal.setText(String.valueOf(compra.getQtdeTotal()));
        this.txtValorTotal.setText(String.valueOf(compra.getValorTotal()));
        this.txtDtLancamento.setText(new SimpleDateFormat("dd/MM/yyyy").format(compra.getDataLancamento()));
        this.btnConfirmar.setDisable(true);
        MaskFieldUtil.numericField(this.txtQtdeRecebida);
        this.dtpDtRecebimento.setValue(LocalDate.now());
        completar(compra.getListaItens());
        this.txtQtdeRecebida.setDisable(true);
    }
    private void completar(Set<ItemCompraEntity> lista){
        this.clmItemPedidoID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.clmItemPedidoProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        this.clmItemPedidoQtdePedida.setCellValueFactory(new PropertyValueFactory<>("quantidadePedida"));
        this.tblItemPedido.setItems(FXCollections.observableArrayList(lista));
    }
    

    @FXML
    void btnSair_onAction(ActionEvent event) {
             BorderPane frmCompra=null;
        try{
            frmCompra= FXMLLoader.load(FrmPedidoCompra.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoCompra.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            
            ((BorderPane)NavegarObjetos.getPai()).setCenter(frmCompra);
            
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
            btnSair.fire();
    }

    @FXML
    void btnConfirmar_onAction(ActionEvent event) {
             this.botaoConfirmar(this.tblItemPedido.getSelectionModel().getSelectedItem());
    }

    @FXML
    void btnConfirmar_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
            btnConfirmar.fire();
    }

    @FXML
    void dtpDtRecebimento_onKeyPressed(ActionEvent event) {
        
    }

    @FXML
    void btnConfirmarRecebimento_onAction(ActionEvent event) {
        confirmarPedido();
    }

    @FXML
    void btnConfirmarRecebimento_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
            btnConfirmarRecebimento.fire();
    }
    private void confirmarPedido() {
        if(compra.getListaItens().isEmpty()){
            compra.setListaItens(lista);
            compra.setSituacao(SituacaoCompraEnum.RECEBIDA);
            compra.setDataRecebimento(Date.from(this.dtpDtRecebimento.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
           //converter localDate em date
            btnSair.fire();
        }else{
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Alpha Cosmeticos");
            dialogoErro.setHeaderText("Obrigatório confirmar todos os produtos pedidos");
            dialogoErro.showAndWait();
        }
    }
    
    @FXML
    void tblItemPedido_OnMouseClicked(MouseEvent event) {
        ItemCompraEntity itemTemp= this.tblItemPedido.getSelectionModel().getSelectedItem();
        this.txtID.setText(String.valueOf(itemTemp.getId()));
        this.txtProduto.setText(itemTemp.getNomeProduto());
        this.txtQtdeRecebida.setDisable(false);
        this.txtQtdeRecebida.requestFocus();
        this.btnConfirmar.setDisable(false);
       
    }
  
 
    private void botaoConfirmar(ItemCompraEntity t){
         if(this.txtQtdeRecebida.getText().equals("")){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Alpha Cosmeticos");
            dialogoErro.setHeaderText("Quantidade Inválida");
            dialogoErro.setContentText("Digite a quantidade recebida");
            dialogoErro.showAndWait();
            this.txtQtdeRecebida.requestFocus();
        } else if(Integer.parseInt(this.txtQtdeRecebida.getText())>t.getQuantidadePedida()){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Alpha Cosmeticos");
            dialogoErro.setHeaderText("Quantidade Inválida");
            dialogoErro.setContentText("Quantidade superior a quantidade pedida");
            dialogoErro.showAndWait();
            this.txtQtdeRecebida.requestFocus();
        }else{
        t.setQuantidadeFornecida(Integer.parseInt(this.txtQtdeRecebida.getText()));
        lista.add(t);
        compra.getListaItens().remove(t);
        completarTblConferir();
        completar(compra.getListaItens());
        txtQtdeRecebida.setText("");
        txtQtdeRecebida.setDisable(true);
        btnConfirmar.setDisable(true);
        txtID.setText("");
        txtProduto.setText("");
        }
    }
    private void completarTblConferir(){
        this.clmItemPedidoConfID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.clmItemPedidoConfProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        this.clmItemPedidoConfQtdeRecebida.setCellValueFactory(new PropertyValueFactory<>("quantidadeFornecida"));
        this.tblItemPedidoConf.setItems(FXCollections.observableArrayList(lista));
    }

}
