/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.business.Vendedor;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.VendedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoVendaEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.NavegarObjetos;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class FrmPedidoVendaFinalizacao {

    @FXML
    private TextField txtNomeVendedor;

    @FXML
    private Button btnRecusar;

    @FXML
    private Button btnFinalizar;

    @FXML
    private TextField txtNome;

    @FXML
    private TableColumn<VendaEntity, Long> clmQtdeVendida;

    @FXML
    private TextField txtIDVenda;

    @FXML
    private TextField txtDtEnvio;

    @FXML
    private TextField txtQtdeTotal;

    @FXML
    private TextField txtDtLancamento;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtCidade;

    @FXML
    private TableColumn<VendaEntity, String> clmProduto;

    @FXML
    private TableColumn<VendaEntity, Long> clmID;

    @FXML
    private TextField txtCEP;

    @FXML
    private TextField txtLogradouro;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TextField txtBairro;

    @FXML
    private TableView<ItemVendaEntity> tblItemVenda;

    @FXML
    private BorderPane bdpPrincipal;
    
    @FXML
    private TextField txtDtAprovacao;
    
    private VendaEntity venda;
    Vendedor vendedor =new Vendedor(DAOFactory.getDAOFactory().getVendedorDAO());
    
    
    @FXML
    void initialize(){
        venda=NavegarObjetos.getVenda();
        this.completar(venda);
        this.completarItensVenda(venda.getListaItens());   
    }
    
    void completarItensVenda(Set<ItemVendaEntity> lista){
        this.clmID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.clmProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        this.clmQtdeVendida.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        
        this.tblItemVenda.setItems(FXCollections.observableArrayList(lista));
    }
    
    void completar(VendaEntity venda){
        this.txtNome.setText(venda.getClienteVO().getNome());
        this.txtCEP.setText(venda.getClienteVO().getEnderecoVO().getCEP());
        this.txtBairro.setText(venda.getClienteVO().getEnderecoVO().getBairroVO().getNome());
        this.txtCidade.setText(venda.getClienteVO().getEnderecoVO().getBairroVO().getCidadeVO().getNome());
        this.txtLogradouro.setText(venda.getClienteVO().getEnderecoVO().getLogradouro());
        this.txtIDVenda.setText(venda.getId().toString());
        this.txtNomeVendedor.setText(buscarVendedor().getNome());
        this.txtValorTotal.setText(Float.toString(venda.getValorTotal()));
        this.txtQtdeTotal.setText(Float.toString(venda.getQtdeTotal()));

        this.txtDtLancamento.setText(venda.getDataLancamentoString()); 
        this.txtDtEnvio.setText(venda.getDataRecebimString());
        if(venda.getDataAprovacao()!= null){
            this.txtDtAprovacao.setText(venda.getDataAprovacaoString());
        }
        
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
        if(event.getCode()==KeyCode.ENTER)
            chamarPai();
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
    void btnFinalizar_onAction(ActionEvent event) {
        AceitarDialog();
    }

    @FXML
    void btnFinalizar_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
            AceitarDialog();
    }
    
    private void AceitarDialog(){
        Alert caixa= new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType sim= new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");
        caixa.setTitle("AlphaComesticos");
        caixa.setHeaderText("Finalizar venda");
        caixa.setContentText("Deseja realmente finalizar a venda?");
        caixa.getButtonTypes().setAll(sim,nao);
        caixa.showAndWait().ifPresent(p->{ 
            if(p==sim){
                venda.setSituacao(SituacaoVendaEnum.ENVIADA);
                chamarPai();
            }
            if(p==nao){}
        });        
    }
     
    @FXML
    void btnRecusar_onAction(ActionEvent event) {
        RecusarDialog();
    }

    @FXML
    void btnRecusar_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER)
            RecusarDialog();
    }
     private void RecusarDialog(){
        Alert caixa= new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType sim= new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");
        caixa.setTitle("AlphaComesticos");
        caixa.setHeaderText("Finalizar venda");
        caixa.setContentText("Deseja realmente recusar a venda?");
        caixa.getButtonTypes().setAll(sim,nao);
        
        caixa.showAndWait().ifPresent(p->{ 
            if(p==sim){
                venda.setSituacao(SituacaoVendaEnum.RECUSADA);
                ProdutoEntity prod= null;
                for(ItemVendaEntity vo: venda.getListaItens()){
                    prod=vo.getProdutoVO();
                    prod.setQuantidade(prod.getQuantidade()+vo.getQuantidade());
                }
                chamarPai();
            }
            if(p==nao){}
               
            
        });
    }
    
}

