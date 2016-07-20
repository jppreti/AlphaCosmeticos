/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.business.Vendedor;
import br.com.compdevbooks.alphacosmetics.business.cadastro.Produto;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.VendedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoVendaEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.NavegarObjetos;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class FrmPedidoVendaSeparar {

    @FXML
    private TextField txtNomeVendedor;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Label lblFiltrarPor;

    @FXML
    private Label lblIDVenda;

    @FXML
    private Label lblDtLancamento;

    @FXML
    private RadioButton rdbProx10Dias;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label lblNomeVendedor;

    @FXML
    private TableColumn<ItemVendaEntity, Long> clmPedidoVendaID;

    @FXML
    private RadioButton rdbProxSemana;

    @FXML
    private TableView<ItemVendaEntity> tblPedidoVenda;

    @FXML
    private RadioButton rdbProx60Dias;

    @FXML
    private TableColumn<ItemVendaEntity, Long> clmPedidoVendaQtdeTotal;

    @FXML
    private Label lblDtAprovacao;

    @FXML
    private TableColumn<ItemVendaEntity, String> clmPedidoVendaDtPrevisto;

    @FXML
    private TextField txtDtAprovacao;

    @FXML
    private TableColumn<ItemVendaEntity, String> clmPedidoVendaProduto;

    @FXML
    private TextField txtIDVenda;

    @FXML
    private DatePicker dtpDtEntrega;

    @FXML
    private TextField txtDtLancamento;

    @FXML
    private Label lblDtEntrega;

    @FXML
    private Button btnSair;

    @FXML
    private Label lblPedidoVendaSeparacao;

    @FXML
    private RadioButton rdbProx30Dias;

    @FXML
    private BorderPane bdpPrincipal;
    
    private VendaEntity venda;
    Vendedor vendedor =new Vendedor(DAOFactory.getDAOFactory().getVendedorDAO());
    Produto produto = new Produto(DAOFactory.getDAOFactory().getProdutoDAO());
    @FXML
    void initialize(){
        venda=NavegarObjetos.getVenda();
        this.completar(venda);
        this.completarItensVenda(venda.getListaItens());   
        this.dtpDtEntrega.setValue(LocalDate.now());
    }
    
    void completar(VendaEntity venda){
        this.txtIDVenda.setText(Long.toString(venda.getId()));
        this.txtNomeVendedor.setText(this.buscarVendedor().getNome());
        this.txtDtLancamento.setText(venda.getDataLancamentoString());
        if (venda.getDataAprovacao()!= null){
            this.txtDtAprovacao.setText(venda.getDataAprovacaoString());
        }
        
    }
    
    void completarItensVenda(Set<ItemVendaEntity> lista){
        this.clmPedidoVendaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.clmPedidoVendaProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        this.clmPedidoVendaQtdeTotal.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        //this.clmPedidoVendaDtPrevisto.setCellValueFactory(new PropertyValueFactory<>(""));
        this.tblPedidoVenda.setItems(FXCollections.observableArrayList(lista));
    }
    
    VendedorEntity buscarVendedor(){
        List<VendedorEntity> vendedores = vendedor.buscarTodosVendedores();
        Set<ClienteEntity> clientes;
        for (VendedorEntity vov: vendedores){
            clientes=vov.getListaClientes();
            for(ClienteEntity cli: clientes){
                if (cli.getId().equals(venda.getClienteVO().getId())){
                    return vov;
                }
                    
            }
        }
        return null;        
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
    

    @FXML
    void btnConfirmar_onAction(ActionEvent event) {
        AceitarDialog();
    }

    @FXML
    void btnConfirmar_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
            AceitarDialog();
    }
    
    private void AceitarDialog(){
        if(this.dtpDtEntrega.getValue()!=null){
            Alert caixa= new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType sim= new ButtonType("Sim");
            ButtonType nao = new ButtonType("Não");
            caixa.setTitle("AlphaComesticos");
            caixa.setHeaderText("Separar produtos");
            caixa.setContentText("Deseja separar os produtos?");
            caixa.getButtonTypes().setAll(sim,nao);

            caixa.showAndWait().ifPresent(p->{ 
                if(p==sim){
                   
                    ProdutoEntity prod= null;
                    List<ProdutoEntity> lista= new ArrayList<>();
                    for(ItemVendaEntity vo: venda.getListaItens()){
                        if (produto.getById(vo.getProdutoVO().getId()).getQuantidade()<vo.getQuantidade()){
                         lista.add(vo.getProdutoVO());
                        }
                    }
                    if(lista.size()==0){
                        venda.setDataRecebimento(Date.from(this.dtpDtEntrega.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                        venda.setSituacao(SituacaoVendaEnum.SEPARADA);

                        for(ItemVendaEntity vo: venda.getListaItens()){
                            prod=produto.buscarPorId(vo.getProdutoVO().getId());  
                            prod.setQuantidade(prod.getQuantidade()-vo.getQuantidade());
                        }
                        chamarPai();
                    }else{
                        Alert caixa2= new Alert(Alert.AlertType.INFORMATION);
                        ButtonType ok= new ButtonType("OK");
                        caixa2.setTitle("AlphaComesticos");
                        caixa2.setHeaderText("");
                        String text="O produto ";
                        for(ProdutoEntity vo: lista){
                            text=text+vo.getNome()+" ";
                        }
                        caixa2.setContentText(text+"está abaixo da quantidade necessaria!");
                        caixa2.getButtonTypes().setAll(ok);
                        caixa2.showAndWait().isPresent();
                    }
                    
                }
                if(p==nao){}


            });
        }else {
            Alert caixa= new Alert(Alert.AlertType.INFORMATION);
            ButtonType ok= new ButtonType("OK");
            caixa.setTitle("AlphaComesticos");
            caixa.setHeaderText("");
            caixa.setContentText("Selecione a Data de Envio do pedido!");
            caixa.getButtonTypes().setAll(ok);
            caixa.showAndWait().isPresent();
        }
        
    }
    @FXML
    void btnCancelar_onAction(ActionEvent event) {
        RecusarDialog();
    }

    @FXML
    void btnCancelar_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
            RecusarDialog();
    }
    
    private void RecusarDialog(){
        Alert caixa= new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType sim= new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");
        caixa.setTitle("AlphaComesticos");
        caixa.setHeaderText("Separar produtos");
        caixa.setContentText("Deseja realmente recusar o venda?");
        caixa.getButtonTypes().setAll(sim,nao);
        
        caixa.showAndWait().ifPresent(p->{ 
            if(p==sim){
              venda.setSituacao(SituacaoVendaEnum.RECUSADA);
                chamarPai();
            }
            if(p==nao){}
               
            
        });
    }
}
