/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoVendaEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import java.util.List;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.MaskFieldUtil;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.NavegarObjetos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class FrmPedidoVendaGerenteEstoque {

    @FXML
    private Button btnRecusar;

    @FXML
    private Label lblDtRecebimento;

    @FXML
    private Button btnFinalizar;

    @FXML
    private TextField txtNome;

    @FXML
    private Label lblSituacao;

    @FXML
    private Label lblDtLancamento;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtFormaPagamento;

    @FXML
    private ComboBox<SituacaoVendaEnum> cmbPesqSituacao;

    @FXML
    private TextField txtID;

    @FXML
    private TableColumn<ItemVendaEntity, Float> clmtemVendaQtdePedida;

    @FXML
    private Button btnAnalisar;

    @FXML
    private TextField txtPesqCNPJ;

    @FXML
    private TextField txtPesqDtLancamento;

    @FXML
    private Label lblCliente;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblVenda;

    @FXML
    private TableView<VendaEntity> tblVenda;

    @FXML
    private Label lblCPF;

    @FXML
    private TableColumn<ItemCompraEntity, Float> clmtemVendaQtdeEstoque;

    @FXML
    private TableColumn<ProdutoEntity, String> clmtemVendaProduto;

    @FXML
    private Label lblPesqCompra;

    @FXML
    private Label lblDtAprovacao;

    @FXML
    private TableColumn<VendaEntity, Long> clmVendaID;

    @FXML
    private TextField txtSituacao;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtDtAprovacao;

    @FXML
    private Label lblPesqFornecedor;

    @FXML
    private TextField txtPesqRazaoSocial;

    @FXML
    private Button btnPesquisar;

    @FXML
    private TableColumn<VendaEntity, String> clmVendaDtLancamento;

    @FXML
    private Label lblID;

    @FXML
    private TextField txtDtRecebimento;

    @FXML
    private Button btnSeparar;

    @FXML
    private TextField txtDtLancamento;

    @FXML
    private TextField txtPesqInscricao;

    @FXML
    private TableColumn<VendaEntity, SituacaoVendaEnum> clmVendaSituacao;

    @FXML
    private Button btnSair;

    @FXML
    private Label lblPedidoVenda;

    @FXML
    private Label lblTelefone;

    @FXML
    private Label lblFormaPagamento;
    

    @FXML
    private TableView<ItemVendaEntity> tblItemVenda;
    
    @FXML
    private BorderPane bdpPrincipal;
    
    private Venda venda= new Venda(DAOFactory.getDAOFactory().getVendaDAO());
   
    
    @FXML
    void initialize(){
        NavegarObjetos.setPedidoGerenteEstoque(bdpPrincipal);
        this.completarTableVenda(venda.buscarTodasVendas());
        ObservableList<SituacaoVendaEnum> combo=  FXCollections.observableArrayList(SituacaoVendaEnum.ANALISE ,SituacaoVendaEnum.APROVADA,SituacaoVendaEnum.ENVIADA,
                SituacaoVendaEnum.PEDIDO,SituacaoVendaEnum.PROCESSADA,SituacaoVendaEnum.SEPARADA, SituacaoVendaEnum.RECUSADA);
        this.cmbPesqSituacao.setItems(combo);
        MaskFieldUtil.dateField(this.txtPesqDtLancamento);
        MaskFieldUtil.dateField(this.txtDtAprovacao);
        MaskFieldUtil.dateField(this.txtDtRecebimento);
        MaskFieldUtil.dateField(this.txtDtLancamento);
        MaskFieldUtil.cnpjField(this.txtPesqCNPJ);
        MaskFieldUtil.cnpjField(this.txtCPF);
        this.habilitar();
    }

    @FXML
    void btnAnalisar_onAction(ActionEvent event) {
        BorderPane frmAnalisarEstoque=null;
        NavegarObjetos.setVenda(this.tblVenda.getSelectionModel().getSelectedItem());
        if(NavegarObjetos.getVenda()!=null){
        try{
            frmAnalisarEstoque= FXMLLoader.load(FrmPedidoVendaAnaliseEstoque.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoVendaAnaliseEstoque.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            ((BorderPane)NavegarObjetos.getPai()).setCenter(frmAnalisarEstoque);
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        
        }else{
            SelecionarVenda();
        }
    }

    

    @FXML
    void btnAnalisar_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
        BorderPane frmAnalisarEstoque=null;
        NavegarObjetos.setVenda(this.tblVenda.getSelectionModel().getSelectedItem());
        if(NavegarObjetos.getVenda()!=null){
        try{
            frmAnalisarEstoque= FXMLLoader.load(FrmPedidoVendaAnaliseEstoque.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoVendaAnaliseEstoque.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            ((BorderPane)NavegarObjetos.getPai()).setCenter(frmAnalisarEstoque);
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        }
        }else{
            SelecionarVenda();
        }
    }

    @FXML
    void btnSeparar_onAction(ActionEvent event) {
        
    }

    @FXML
    void btnSeparar_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){}
    }

    @FXML
    void btnFinalizar_onAction(ActionEvent event) {
        BorderPane frmFinalizar=null;
        NavegarObjetos.setVenda(this.tblVenda.getSelectionModel().getSelectedItem());
        if(NavegarObjetos.getVenda()!=null){
        try{
            frmFinalizar= FXMLLoader.load(FrmPedidoVendaFinalizacao.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoVendaFinalizacao.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            ((BorderPane)NavegarObjetos.getPai()).setCenter(frmFinalizar);
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        }else{
            SelecionarVenda();
        }
    }

    @FXML
    void btnFinalizar_onKeyPressed(KeyEvent event) {
            if(event.getCode()==KeyCode.ENTER){}
    }
    private void SelecionarVenda(){
        Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Alpha Cosmetico");
            //dialogoErro.setHeaderText("Erro");
            dialogoErro.setContentText("Selecione um pedido de venda");
            dialogoErro.showAndWait();
    }

    @FXML
    void btnRecusar_onAction(ActionEvent event) {
        RecusarDialog();
        this.completarTableVenda(venda.buscarTodasVendas());
    }

    @FXML
    void btnRecusar_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
            RecusarDialog();
        this.completarTableVenda(venda.buscarTodasVendas());
                
    }
    private void RecusarDialog(){
        Alert caixa= new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType sim= new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");
        caixa.setTitle("Alpha Cosmeticos");
        caixa.setHeaderText("Recusar Pedido");
        caixa.setContentText("Deseja recusar pedido?");
        caixa.getButtonTypes().setAll(sim,nao);
        
        caixa.showAndWait().ifPresent(p->{ 
            if(p==sim){
              this.tblVenda.getSelectionModel().getSelectedItem().setSituacao(SituacaoVendaEnum.RECUSADA);
                System.out.println("saida");
            }
            if(p==nao){}
               
            
        });
        //this.tblVenda.refresh();
        
    }

    @FXML
    void btnSair_onAction(ActionEvent event) {
           ((BorderPane) NavegarObjetos.getPai()).setCenter(null);
            //this.getPainelPrincipal(this.bdpPrincipal);
    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER)
            ((BorderPane) NavegarObjetos.getPai()).setCenter(null);
           // this.getPainelPrincipal(this.bdpPrincipal);
    }

    @FXML
    void txtPesqRazaoSocial_onKeyPressed(KeyEvent event) {
            if(event.getCode()==KeyCode.ENTER){}
    }

    @FXML
    void txtCNPJ_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){}
    }

    @FXML
    void txtInscricao_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){}
    }

    @FXML
    void cmbPesqSituacao_onAction(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){}
    }

    @FXML
    void txtDtLancamento_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){}
    }   

    @FXML
    void btnPesquisar_onAction(ActionEvent event) {
        pesquisar();
    }

    @FXML
    void btnPesquisar_onKeyPressed(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER)
            pesquisar();
    }
    
    private void completarTableVenda(List<VendaEntity> lista){
        this.clmVendaID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.clmVendaSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
        this.clmVendaDtLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamentoString"));
        this.tblVenda.setItems(FXCollections.observableArrayList(lista));
    }
     @FXML
    void tblVenda_OnMouseClicked(MouseEvent event) {
        completar();
    }
    private void completar(){
        VendaEntity venda= this.tblVenda.getSelectionModel().getSelectedItem();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if(venda!=null){
            this.txtNome.setText(venda.getClienteVO().getNome());
            //this.txtFormaPagamento.setText();  fazer
           if(venda.getDataLancamento()!=null) this.txtDtLancamento.setText(formato.format(venda.getDataLancamento()));
           if(venda.getDataAprovacao()!=null) this.txtDtAprovacao.setText(formato.format(venda.getDataAprovacao()));
           if(venda.getDataRecebimento()!=null) this.txtDtRecebimento.setText(formato.format(venda.getDataRecebimento())); 
           
            this.txtID.setText(String.valueOf(venda.getId()));
            this.txtSituacao.setText(venda.getSituacao().toString());
            //this.txtTelefone.setText(venda.getClienteVO().getTelefone());
            this.txtCPF.setText(venda.getClienteVO().getCNPJ());
        } 
        this.completarItem();
         
    }
    private void habilitar(){
        this.txtCPF.setEditable(false);
        this.txtDtAprovacao.setEditable(false);
        this.txtDtLancamento.setEditable(false);
        this.txtDtRecebimento.setEditable(false);
        this.txtFormaPagamento.setEditable(false);
        this.txtID.setEditable(false);
        this.txtNome.setEditable(false);
    }
    
    private void completarItem(){
        this.clmtemVendaQtdePedida.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.clmtemVendaProduto.setCellValueFactory(new PropertyValueFactory <>("ProdutoVO"));
        
        Set<ItemVendaEntity> lista= this.tblVenda.getSelectionModel().getSelectedItem().getListaItens();
        this.tblItemVenda.setItems(FXCollections.observableArrayList(lista));
        
    }
    private void getPainelPrincipal(Node node){
        Node aux= node.getParent();
        while(!(aux instanceof  BorderPane))
            aux =node.getParent();
        ((BorderPane) aux).setCenter(null);
        
    }
    private void pesquisar(){
        ClienteEntity cliente= new ClienteEntity();
        VendaEntity venda= new VendaEntity();
        
        System.out.println(this.txtPesqCNPJ.getText());
        cliente.setCNPJ(this.txtPesqCNPJ.getText());
        
        System.out.println(this.txtPesqRazaoSocial.getText());
        cliente.setNome(this.txtPesqRazaoSocial.getText());
        
        System.out.println(this.txtPesqInscricao.getText());
        cliente.setInscricao(this.txtPesqInscricao.getText());
        System.out.println(this.cmbPesqSituacao.getSelectionModel().getSelectedItem());
        venda.setSituacao(this.cmbPesqSituacao.getSelectionModel().getSelectedItem());
        
        try {
                 System.out.println(this.txtPesqDtLancamento.getText().replaceAll("", "1"));
             if(this.txtPesqDtLancamento.getText().equals(""))
                 venda.setDataLancamento(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/1111"));
             else 
                 venda.setDataLancamentoString(this.txtPesqDtLancamento.getText());
                 
        } catch (ParseException ex) {
            Logger.getLogger(FrmPedidoVendaGerenteVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

