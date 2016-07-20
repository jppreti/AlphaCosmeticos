package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;


import br.com.compdevbooks.alphacosmetics.business.Fornecedor;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoCompraEnum;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.MaskFieldUtil;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.NavegarObjetos;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class FrmPedidoCompra {

    @FXML
    private Label lblDtRecebimento;

    @FXML
    private Label lblCompra;

    @FXML
    private TableColumn<ItemCompraEntity, String> clmItemCompraProduto;

    @FXML
    private Button btnFinalizar;

    @FXML
    private TextField txtInscricao;

    @FXML
    private TableColumn<ItemCompraEntity, Float> clmItemCompraQtde;

    @FXML
    private Button btnConferir;

    @FXML
    private Label lblSituacao;

    @FXML
    private Label lblDtLancamento;

    @FXML
    private Label lblIID;

    @FXML
    private TextField txtFormaPagamento;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private ComboBox<SituacaoCompraEnum> cmbPesqSituacao;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtPesqCNPJ;

    @FXML
    private TableColumn<CompraEntity, String> clmCompraDtLancamento;

    @FXML
    private TextField txtPesqDtLancamento;

    @FXML
    private Label lblPedidoCompra;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label lblInscricao;

    @FXML
    private TableView<ItemCompraEntity> tblItemCompra;

    @FXML
    private TableColumn<CompraEntity, SituacaoCompraEnum> clmCompraSituacao;

    @FXML
    private Label lblRazaoSocial;

    @FXML
    private Label lblPesqCompra;

    @FXML
    private TableView<CompraEntity> tblCompra;

    @FXML
    private TextField txtSituacao;

    @FXML
    private Label lblPesqFornecedor;

    @FXML
    private TextField txtPesqRazaoSocial;

    @FXML
    private Button btnPesquisar;

    @FXML
    private TableColumn<CompraEntity, String> clmCompraID;

    @FXML
    private TextField txtDtRecebimento;

    @FXML
    private TextField txtDtLancamento;

    @FXML
    private Label lblCNPJ;

    @FXML
    private TextField txtRazaoSocial;

    @FXML
    private TextField txtPesqInscricao;

    @FXML
    private Button btnSair;

    @FXML
    private Label lblFormaPagamento;
    private Compra compra= new Compra(DAOFactory.getDAOFactory().getCompraDAO());
    @FXML
    void initialize(){
        completarCompra(compra.buscarTodasCompras());
        ObservableList<SituacaoCompraEnum> combo= FXCollections.observableArrayList(SituacaoCompraEnum.LANCADA,SituacaoCompraEnum.PROCESSADA,SituacaoCompraEnum.RECEBIDA);
        this.cmbPesqSituacao.setItems(combo);
        this.cmbPesqSituacao.getSelectionModel().select(SituacaoCompraEnum.LANCADA);
        MaskFieldUtil.dateField(this.txtPesqDtLancamento);
        this.btnConferir.setDisable(true);
        this.btnFinalizar.setDisable(true);
        MaskFieldUtil.dateField(this.txtPesqDtLancamento);
        MaskFieldUtil.cnpjField(this.txtPesqCNPJ);
    }
    private void completarCompra(List<CompraEntity> lista){
        this.clmCompraDtLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamentoString"));
        this.clmCompraID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.clmCompraSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
        this.tblCompra.setItems(FXCollections.observableArrayList(lista));
    }
    private void setarBotao(CompraEntity compra){
        if(compra.getSituacao().equals(SituacaoCompraEnum.LANCADA)){
            this.btnConferir.setDisable(false);
             this.btnFinalizar.setDisable(true);
        }else if(compra.getSituacao().equals(SituacaoCompraEnum.RECEBIDA)){
            this.btnConferir.setDisable(true);
             this.btnFinalizar.setDisable(false);
        }else if(compra.getSituacao().equals(SituacaoCompraEnum.PROCESSADA)){
            this.btnConferir.setDisable(true);
             this.btnFinalizar.setDisable(true);
        }
            
    }
    @FXML
    void btnConferir_onAction(ActionEvent event) {
            BorderPane frmCompra=null;
        try{ 
            NavegarObjetos.setCompra(this.tblCompra.getSelectionModel().getSelectedItem());
            frmCompra= FXMLLoader.load(FrmPedidoCompraConfirmar.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoCompraConfirmar.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            ((BorderPane)NavegarObjetos.getPai()).setCenter(frmCompra);
            NavegarObjetos.setPedidoCompra(frmCompra);
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    @FXML
    void btnConferir_onKeyPressed(KeyEvent event) {
            if(event.getCode()==KeyCode.ENTER)
               btnConferir.fire();
    }

    @FXML
    void btnFinalizar_onAction(ActionEvent event) {
        BorderPane frmCompra=null;
        try{ 
            NavegarObjetos.setCompra(this.tblCompra.getSelectionModel().getSelectedItem());
            frmCompra= FXMLLoader.load(FrmPedidoCompraFinalizar.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoCompraFinalizar.fxml"),ResourceBundle.getBundle("gui/i18N_pt_BR"));
            ((BorderPane)NavegarObjetos.getPai()).setCenter(frmCompra);
            NavegarObjetos.setPedidoCompra(frmCompra);
        }catch (Exception ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    @FXML
    void btnFinalizar_onKeyPressed(KeyEvent event) {
            if(event.getCode()==KeyCode.ENTER)
                btnFinalizar.fire();
    }

    @FXML
    void btnCancelar_onAction(ActionEvent event) {
    }

    @FXML
    void btnnCancelar_onKeyPressed(KeyEvent event) {

    }

   

    @FXML
    void btnSair_onAction(ActionEvent event) {
        ((BorderPane)NavegarObjetos.getPai()).setCenter(null);
    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
             ((BorderPane)NavegarObjetos.getPai()).setCenter(null);
    }
     @FXML
    void tblCompra_onMouseClicked(MouseEvent event) {
        CompraEntity compraTemp= this.tblCompra.getSelectionModel().getSelectedItem();
        this.txtRazaoSocial.setText(compraTemp.getNomeFornecedor());
        this.txtCNPJ.setText(compraTemp.getFornecedorVO().getCNPJ());
        this.txtInscricao.setText(compraTemp.getFornecedorVO().getInscricao());
        this.txtID.setText(String.valueOf(compraTemp.getId()));
        this.txtSituacao.setText(compraTemp.getSituacao().toString());
        DateFormat date= new SimpleDateFormat("dd/MM/yyyy");
        if(compraTemp.getDataLancamento()!=null)
            this.txtDtLancamento.setText(date.format(compraTemp.getDataLancamento()));
        if(compraTemp.getDataRecebimento()!=null)
            this.txtDtRecebimento.setText(date.format(compraTemp.getDataRecebimento()));
        this.txtFormaPagamento.setText(compraTemp.getPagamentoVO().getTipoPagamento().toString());
        this.completarItem(compra.pegarItemCompra());
        this.setarBotao(compraTemp);
        
    }
    private void completarItem(Set<ItemCompraEntity> lista){
        this.clmItemCompraProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        this.clmItemCompraQtde.setCellValueFactory(new PropertyValueFactory<>("quantidadePedida"));
        this.tblItemCompra.setItems(FXCollections.observableArrayList(lista));
    }

    @FXML
    void txtPesqRazaoSocial_onKeyPressed(KeyEvent event) {
               if(event.getCode()==KeyCode.ENTER)
                pesquisar();
    }

    @FXML
    void txtCNPJ_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
                pesquisar();
    }

    @FXML
    void txtInscricao_onKeyPressed(KeyEvent event) {
            if(event.getCode()==KeyCode.ENTER)
                pesquisar();
    }

    @FXML
    void txtDtLancamento_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
                pesquisar();

    }

    @FXML
    void cmbSituacao_onAction(ActionEvent event) {
                pesquisar();
    }

    @FXML
    void btnPesquisar_onAction(ActionEvent event) {
        
                pesquisar();
    }

    @FXML
    void btnPesquisar_onKeyPressed(KeyEvent event) {
            if(event.getCode()==KeyCode.ENTER)
                pesquisar();
    }
    private void pesquisar(){
        FornecedorEntity fornecedor= new FornecedorEntity();
        CompraEntity compra= new CompraEntity();
        fornecedor.setFantasia(this.txtPesqRazaoSocial.getText());
        System.out.println(fornecedor.getFantasia());
        fornecedor.setInscricao(this.txtPesqInscricao.getText());
        System.out.println(fornecedor.getInscricao());
        fornecedor.setCNPJ(this.txtCNPJ.getText());
        System.out.println(fornecedor.getCNPJ());
        
       
            compra.setSituacao(cmbPesqSituacao.getSelectionModel().getSelectedItem());
            System.out.println(compra.getSituacao().toString());
        
        
        
            try {
                if(this.txtPesqDtLancamento.getText().equals(""))
                compra.setDataLancamento(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/1111"));
                else
                 compra.setDataLancamentoString(this.txtPesqDtLancamento.getText());
                System.out.println(compra.getDataLancamento());
        } catch (ParseException ex) {
            Logger.getLogger(FrmPedidoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.completarCompra(this.compra.buscarPedidoCompra(fornecedor, compra));
        
    }

}