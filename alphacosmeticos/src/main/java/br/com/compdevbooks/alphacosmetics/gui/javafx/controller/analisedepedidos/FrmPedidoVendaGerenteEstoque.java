/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoVO;
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
import br.com.compdevbooks.alphacosmetics.gui.javafx.MaskFieldUtil;
import java.text.SimpleDateFormat;

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
    private TableColumn<ProdutoVO, String> clmtemVendaProduto;

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
    private Venda venda= new Venda(DAOFactory.getDAOFactory().getVendaDAO());
   
    
    @FXML
    void initialize(){
        this.completarTableVenda(venda.buscarTodasVendas());
        ObservableList<SituacaoVendaEnum> combo=  FXCollections.observableArrayList(SituacaoVendaEnum.ANALISE ,SituacaoVendaEnum.APROVADA,SituacaoVendaEnum.ENVIADA,
                SituacaoVendaEnum.PEDIDO,SituacaoVendaEnum.PROCESSADA,SituacaoVendaEnum.SEPARACAO);
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

    }

    @FXML
    void btnAnalisar_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnSeparar_onAction(ActionEvent event) {

    }

    @FXML
    void btnSeparar_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnFinalizar_onAction(ActionEvent event) {

    }

    @FXML
    void btnFinalizar_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnRecusar_onAction(ActionEvent event) {

    }

    @FXML
    void btnRecusar_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnSair_onAction(ActionEvent event) {
            
    }

    @FXML
    void btnSair_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void txtPesqRazaoSocial_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void txtCNPJ_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void txtInscricao_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void cmbPesqSituacao_onAction(ActionEvent event) {

    }

    @FXML
    void txtDtLancamento_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnPesquisar_onAction(ActionEvent event) {

    }

    @FXML
    void btnPesquisar_onKeyPressed(ActionEvent event) {

    }
    
    private void completarTableVenda(List<VendaEntity> lista){
        this.clmVendaID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.clmVendaSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
        this.clmVendaDtLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamento"));
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

}

