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
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.NavegarObjetos;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private TextField txtDtEntrega;

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
    
    @FXML
    void initialize(){
        venda=NavegarObjetos.getVenda();
        this.completar(venda);
        this.completarItensVenda(venda.getListaItens());   
    }
    
    void completar(VendaEntity venda){
        this.txtIDVenda.setText(Long.toString(venda.getId()));
        this.txtNomeVendedor.setText(this.buscarVendedor().getNome());
        this.txtDtLancamento.setText(venda.getDataLancamentoString());
        //this.txtDtEntrega.setText(venda.getDataRecebimString());
        //this.txtDtAprovacao.setText(venda.getDataAprovacaoString());
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
        getPai(this.bdpPrincipal);
    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            getPai(this.bdpPrincipal);
        }
    }
    
    private void getPai(Node node){
        Node aux = node.getParent();
        while(!(aux instanceof BorderPane)){
            aux=node.getParent();
        }
        ((BorderPane)aux).setCenter(null);
    }
    
    @FXML
    void rdbProx60Dias_onAction(ActionEvent event) {
        this.rdbProx10Dias.setSelected(false);
        this.rdbProx30Dias.setSelected(false);
        this.rdbProxSemana.setSelected(false);
    }

    @FXML
    void rdbProx30Dias_onAction(ActionEvent event) {
        this.rdbProx10Dias.setSelected(false);
        this.rdbProx60Dias.setSelected(false);
        this.rdbProxSemana.setSelected(false);
    }

    @FXML
    void rdbProx10Dias_onAction(ActionEvent event) {
        this.rdbProx60Dias.setSelected(false);
        this.rdbProx30Dias.setSelected(false);
        this.rdbProxSemana.setSelected(false);
    }

    @FXML
    void rdbProxSemana_onAction(ActionEvent event) {
        this.rdbProx10Dias.setSelected(false);
        this.rdbProx30Dias.setSelected(false);
        this.rdbProx60Dias.setSelected(false);
    }

    @FXML
    void btnConfirmar_onAction(ActionEvent event) {

    }

    @FXML
    void btnConfirmar_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnCancelar_onAction(ActionEvent event) {

    }

    @FXML
    void btnCancelar_onKeyPressed(KeyEvent event) {

    }

}
