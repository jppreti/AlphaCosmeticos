/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoVO;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoVendaEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.MaskFieldUtil;
import java.text.SimpleDateFormat;
import java.util.Collection;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class FrmPedidoVendaGerenteVendas {

    @FXML
    private TableView<VendaEntity> tblHistorico;

    @FXML
    private TableColumn<VendaEntity, Long> clmHistoricoPedido;

    @FXML
    private TextField txtPesqNome;

    @FXML
    private TextField txtNome;

     @FXML
    private TextField txtCNPJ;

    @FXML
    private TextField txtPesqCNPJ;


    @FXML
    private Label lblDtLancamento;

    @FXML
    private TextField txtFormaPagamento;


    @FXML
    private TextField txtPesqDatLancamento;

    @FXML
    private TextField txtID;

    @FXML
    private Label lblCliente;

    @FXML
    private TextField txtPesqTelefone;

    @FXML
    private TableColumn<VendaEntity, Float> clmHistoricoQtdePedida;

    @FXML
    private TableColumn<VendaEntity, Long> clmPedidoVendaID;

    @FXML
    private TableColumn<VendaEntity, Date> clmPedidoVendaDtLancamento;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblVenda;

    @FXML
    private TableView<VendaEntity> tblPedidoVenda;

    @FXML
    private Label lblCNPJ;

    @FXML
    private Button btnAutorizar;

    @FXML
    private TextField txtTelefone;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Label lblQtdeTotal;

    @FXML
    private TableColumn<ItemVendaEntity, String> clmItemVendaProduto;

    @FXML
    private Label lblID;

    @FXML
    private TableColumn<ItemVendaEntity, Float> clmItemVendaQtdePedida;

    @FXML
    private TextField txtDtLancamento;

    @FXML
    private TableColumn<VendaEntity, Float> clmHistoricoValorTotal;

    @FXML
    private TextField txtQtdeTotal;

    @FXML
    private TableColumn<VendaEntity, SituacaoVendaEnum> clmHistoricoSituacao;

    @FXML
    private Button btnSair;

    @FXML
    private Label lblPedidoVenda;

    @FXML
    private Label lblTelefone;

    @FXML
    private Label lblValorTotal;

    @FXML
    private Label lblFormaPagamento;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TableView<ItemVendaEntity> tblItemVenda;
    
 
    
    private Venda Venda= new Venda(DAOFactory.getDAOFactory().getVendaDAO());
   
    
    
    @FXML
    private void initialize() {
        this.completarPedidoVenda(Venda.buscarVendas());
        MaskFieldUtil.dateField(this.txtDtLancamento);
        MaskFieldUtil.dateField(this.txtPesqDatLancamento);
     
        
    }
  
    @FXML
    void txtPesqNome_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            this.objetoBuscar();
    }

    @FXML
    void txtCPF_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            this.objetoBuscar();
    }

    @FXML
    void txtTelefone_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
             this.objetoBuscar();
    }

    @FXML
    void txtDtLancamento_onKeyPressed(KeyEvent event) {
       if (event.getCode() == KeyCode.ENTER)
            this.objetoBuscar();
    }

    @FXML
    void btnPesquisar_onAction(ActionEvent event) {
        this.objetoBuscar();
    }

    @FXML
    void btnPesquisar_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
             this.objetoBuscar();
    }

    @FXML
    void btnAutorizar_onAction(ActionEvent event) {
            
    }

    @FXML
    void btnAutorizar_onKeyPressed(KeyEvent event) {

    }
    @FXML
    void tblPedidoVenda_onMouseClick(MouseEvent event) {
            VendaEntity vendaTemp= tblPedidoVenda.getSelectionModel().getSelectedItem();
            this.txtNome.setText(vendaTemp.getClienteVO().getNome());
            this.txtNome.setEditable(false);
            this.txtTelefone.setText(vendaTemp.getClienteVO().getTelefone());
            this.txtTelefone.setEditable(false);
            completarHistoricoVenda(this.Venda.buscarVendasPorCliente(vendaTemp.getClienteVO()));
            completarItemVenda(vendaTemp.getListaItens());
            this.txtID.setText(String.valueOf(vendaTemp.getId()));
            this.txtID.setEditable(false);
            //this.txtFormaPagamento.setText(vendaTemp.getPagamentoVO().getTipoPagamento().toString());
            this.txtFormaPagamento.setEditable(false);
            float valorTotal=0;
            float QtdeTotal=0;
            Iterator<ItemVendaEntity> it= vendaTemp.getListaItens().iterator();
            ItemVendaEntity item;
            while(it.hasNext()){
                item= it.next();
                valorTotal+= item.getQuantidade()*item.getProdutoVO().getValorVenda();
                QtdeTotal+=item.getQuantidade();
            }
            this.txtValorTotal.setText(String.valueOf(valorTotal));
            this.txtValorTotal.setEditable(false);
            this.txtQtdeTotal.setText(String.valueOf(QtdeTotal));
            this.txtValorTotal.setEditable(false);
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.txtDtLancamento.setText(formato.format(vendaTemp.getDataLancamento()));
            this.txtDtLancamento.setEditable(false);
            
           
    }


    @FXML
    void btnSair_onAction(ActionEvent event) {

    }

    @FXML
    void btnSair_onKeyPressed(ActionEvent event) {

    }
    
    private void completarPedidoVenda(List<VendaEntity> lista){ 
        this.clmPedidoVendaDtLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamento"));
        this.clmPedidoVendaID.setCellValueFactory(new PropertyValueFactory<>("Id")); 
        this.tblPedidoVenda.setItems(FXCollections.observableArrayList(lista));
    }
    private void completarHistoricoVenda(List<VendaEntity> lista){
        System.out.println(lista.get(0).getId());
        this.clmHistoricoPedido.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.clmHistoricoSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
        this.tblHistorico.setItems(FXCollections.observableArrayList(lista));
    }
    private void completarItemVenda(Set<ItemVendaEntity> lista){
        this.clmItemVendaProduto.setCellValueFactory(new PropertyValueFactory<>("ProdutoVO"));
        this.clmItemVendaQtdePedida.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.tblItemVenda.setItems(FXCollections.observableArrayList(lista));
    }
    
    private void objetoBuscar(){
        ClienteEntity cliente= new ClienteEntity();
        
        if(this.txtPesqNome.getText()==null)
            cliente.setNome("");
        else
            cliente.setNome(this.txtPesqNome.getText());
        
        if(this.txtPesqTelefone.getText()==null)
            cliente.setTelefone("");
        else
            cliente.setTelefone(txtPesqTelefone.getText());
        
        List<VendaEntity> lis= Venda.buscarGerenteVenda(cliente);
        this.completarPedidoVenda(lis);
         
    }
    
}

