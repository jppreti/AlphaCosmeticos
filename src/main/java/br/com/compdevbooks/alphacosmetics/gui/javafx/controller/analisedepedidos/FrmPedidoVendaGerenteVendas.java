/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.endereco.TelefoneEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoVendaEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.MaskFieldUtil;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.FrmPrincipal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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
    private TextField txtID;

    @FXML
    private Label lblCliente;

   
    @FXML
    private TextField txtPesqDatLancamento;

    @FXML
    private TableColumn<VendaEntity, Float> clmHistoricoQtdePedida;

    @FXML
    private TableColumn<VendaEntity, Long> clmPedidoVendaID;

    @FXML
    private TableColumn<VendaEntity, String> clmPedidoVendaDtLancamento;

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
    @FXML
    private BorderPane bdpPrincipal;
    
 
    private FrmPrincipal principal;
    private Venda Venda= new Venda(DAOFactory.getDAOFactory().getVendaDAO());
   
  
    
    @FXML
    private void initialize() {
        this.completarPedidoVenda(Venda.buscarVendas());
        MaskFieldUtil.dateField(this.txtDtLancamento);
        MaskFieldUtil.dateField(this.txtPesqDatLancamento);
        MaskFieldUtil.cnpjField(this.txtCNPJ);
        MaskFieldUtil.cnpjField(this.txtPesqCNPJ);
        
       
     
        
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
       if(this.tblPedidoVenda.getSelectionModel().getSelectedItem()!=null) 
        this.Recusar();
    }
    private void Recusar(){
        Alert caixa= new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType sim= new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");
        caixa.setTitle("AlphaComesticos");
        caixa.setHeaderText("Autorizar crédito");
        caixa.setContentText("Deseja autorizar crédito?");
        caixa.getButtonTypes().setAll(sim,nao);
        
        caixa.showAndWait().ifPresent(p->{ 
            if(p==sim){
              this.tblPedidoVenda.getSelectionModel().getSelectedItem().setSituacao(SituacaoVendaEnum.APROVADA);
              Date data= new Date();
              this.tblPedidoVenda.getSelectionModel().getSelectedItem().setDataAprovacao(data);
            }
            if(p==nao){
                this.tblPedidoVenda.getSelectionModel().getSelectedItem().setSituacao(SituacaoVendaEnum.RECUSADA);
            }
        });
        this.completarPedidoVenda(this.Venda.buscarVendas());
    }

    @FXML
    void btnAutorizar_onKeyPressed(KeyEvent event) {
            if(event.getCode()==KeyCode.ENTER)
                this.Recusar();
                 
    }
    @FXML
    void tblPedidoVenda_onMouseClick(MouseEvent event) {
            VendaEntity vendaTemp= tblPedidoVenda.getSelectionModel().getSelectedItem();
            this.txtNome.setText(vendaTemp.getClienteVO().getNome());
           /* String aux="";
            
              if(vendaTemp.getClienteVO().getListaFone().size()>0){  
                Iterator<TelefoneEntity> tel= vendaTemp.getClienteVO().getListaFone().iterator();
                TelefoneEntity telefone=null;
                if(tel.hasNext()) telefone=tel.next();
                 aux= telefone.getDdi()+telefone.getDdd()+telefone.getNumero();
              }
            this.txtTelefone.setText(aux);*/
            completarHistoricoVenda(this.Venda.buscarVendasPorCliente(vendaTemp.getClienteVO()));
            completarItemVenda(vendaTemp.getListaItens());
            this.txtID.setText(String.valueOf(vendaTemp.getId()));
            //this.txtFormaPagamento.setText(vendaTemp.getPagamentoVO().getTipoPagamento().toString());
            this.txtValorTotal.setText(String.valueOf(vendaTemp.getValorTotal()));
            this.txtQtdeTotal.setText(String.valueOf(vendaTemp.getQtdeTotal()));
            this.txtDtLancamento.setText(vendaTemp.getDataLancamentoString());
            this.txtCNPJ.setText(vendaTemp.getClienteVO().getCNPJ());
            this.txtFormaPagamento.setText(vendaTemp.getPagamentoVO().getTipoPagamento().toString());
 
    }


    @FXML
    void btnSair_onAction(ActionEvent event) {
        this.getPainelPrincipal((Node)this.bdpPrincipal);
    }
    private void getPainelPrincipal(Node node){
        Node aux= node.getParent();
        while(!(aux instanceof  BorderPane))
            aux =node.getParent();
        ((BorderPane) aux).setCenter(null);
        
    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            this.getPainelPrincipal(this.bdpPrincipal);

    }
    
    private void completarPedidoVenda(List<VendaEntity> lista){       
        this.clmPedidoVendaDtLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamentoString"));
        this.clmPedidoVendaID.setCellValueFactory(new PropertyValueFactory<>("Id")); 
        this.tblPedidoVenda.setItems(FXCollections.observableArrayList(lista));
    }
    private void completarHistoricoVenda(List<VendaEntity> lista){
        System.out.println(lista.get(0).getId());
        this.clmHistoricoPedido.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.clmHistoricoSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
        this.clmHistoricoQtdePedida.setCellValueFactory(new PropertyValueFactory<>("qtdeTotal"));
        this.clmHistoricoValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        this.tblHistorico.setItems(FXCollections.observableArrayList(lista));
    }
    private void completarItemVenda(Set<ItemVendaEntity> lista){
        this.clmItemVendaProduto.setCellValueFactory(new PropertyValueFactory<>("ProdutoVO"));
        this.clmItemVendaQtdePedida.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.tblItemVenda.setItems(FXCollections.observableArrayList(lista));
    }
    
    private void objetoBuscar(){
        ClienteEntity cliente= new ClienteEntity();
        VendaEntity venda = new VendaEntity();
        
        if(this.txtPesqNome.getText().equals(""))
            cliente.setNome("");
        else
            cliente.setNome(this.txtPesqNome.getText());
        System.out.println(txtPesqNome.getText());
        System.out.println(this.txtPesqCNPJ.getText());
         if(this.txtPesqCNPJ.getText().equals(""))
             cliente.setCNPJ("");
         else
             cliente.setCNPJ(txtPesqCNPJ.getText());
         
        
             try {
                 System.out.println(this.txtPesqDatLancamento.getText().replaceAll("", "1"));
             if(this.txtPesqDatLancamento.getText().equals(""))
                 venda.setDataLancamento(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/1111"));
             else 
                 venda.setDataLancamentoString(this.txtPesqDatLancamento.getText());
                 
        } catch (ParseException ex) {
            Logger.getLogger(FrmPedidoVendaGerenteVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<VendaEntity> lis= Venda.buscarGerenteVenda(cliente,venda);
        this.completarPedidoVenda(lis);
    }

}

