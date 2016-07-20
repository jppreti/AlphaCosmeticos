/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.produto;

import br.com.compdevbooks.alphacosmetics.business.Categoria;
import br.com.compdevbooks.alphacosmetics.business.Fornecedor;
import br.com.compdevbooks.alphacosmetics.business.cadastro.Produto;
import br.com.compdevbooks.alphacosmetics.business.operacoes.ItemCompra;
import br.com.compdevbooks.alphacosmetics.business.operacoes.ItemVenda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CategoriaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaEstoque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.hibernate.persister.collection.CollectionPropertyNames;

public class FrmEstoque {
    
    @FXML
    private TextField txtFornecedor;
    
    @FXML
    private TextField txtPercComi;

    @FXML
    private TextField txtProduto;

    @FXML
    private TabPane tbpEstoque;
        
    @FXML
    private TextField txtNome;

    @FXML
    private Tab tabDetalhe;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblCategoria;

    @FXML
    private TableColumn<TabelaTelaEstoque, Float> clmProdutoProduto;

    @FXML
    private Label lblPercComi;

    @FXML
    private BorderPane bdpPrincipal;
    
    @FXML
    private TextField txtMargemLucro;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TableView<TabelaTelaEstoque> tblProduto;

    @FXML
    private TableColumn<TabelaTelaEstoque, Float> clmProdutoFornecedor;

    @FXML
    private Label lblMargemLucro;

    @FXML
    private TableColumn<TabelaTelaEstoque, String> clmProdutoCategoria;

    @FXML
    private Tab tabEstoque;

    @FXML
    private Label lblValorVenda;

    @FXML
    private ComboBox<String> cmbCategoria;

    @FXML
    private TextField txtEstoque;

    @FXML
    private Button btnPesquisar;

    @FXML
    private TableColumn<TabelaTelaEstoque, Long> clmProdutoQtdeReservada;

    @FXML
    private TextField txtValorVenda;

    @FXML
    private TextField txtValorCompra;

    @FXML
    private Label lblValorCompra;

    @FXML
    private TableColumn<TabelaTelaEstoque, Long> clmProdutoQtdeEsperada;

    @FXML
    private Label lblPercPromo;

    @FXML
    private Button btnCompra;

    @FXML
    private Button btnSair;

    @FXML
    private TableColumn<ProdutoEntity,Float> clmProdutoQtdeEstoque;

    @FXML
    private TextField txtPercPromo;

    private Produto produto = new Produto(DAOFactory.getDAOFactory().getProdutoDAO());
    private ItemVenda itemVenda = new ItemVenda(DAOFactory.getDAOFactory().getItemVendaDAO());
    private ItemCompra itemCompra = new ItemCompra(DAOFactory.getDAOFactory().getItemCompraDAO());
    private Categoria categoria = new Categoria(DAOFactory.getDAOFactory().getCategoriaDAO());
    private Fornecedor fornecedor = new Fornecedor(DAOFactory.getDAOFactory().getFornecedorDAO());
    
    @FXML
    private void initialize() {
        List<TabelaTelaEstoque> lista = new ArrayList();
        List<ProdutoEntity> l= produto.buscarTodos();
        for(ProdutoEntity vo : l){
            lista.add(new TabelaTelaEstoque(vo));
        }
        
        Collections.sort(lista);
        
        this.completarProdutos(lista);
        
        ObservableList<String> ob = FXCollections.observableArrayList();
        for(CategoriaEntity cat: categoria.buscarTodasCategorias()){
            ob.add(cat.getNome());
        }
        this.cmbCategoria.setItems(ob);
 
    }
    
    private void completarProdutos(List<TabelaTelaEstoque> lista){ 
        this.clmProdutoProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.clmProdutoQtdeEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.clmProdutoQtdeEsperada.setCellValueFactory(new PropertyValueFactory<>("quantidadeEsperada"));
        this.clmProdutoQtdeReservada.setCellValueFactory(new PropertyValueFactory<>("quantidadeReservada"));
        this.clmProdutoCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.clmProdutoFornecedor.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        this.tblProduto.setItems(FXCollections.observableArrayList(lista));
    }
    
    
    
    @FXML
    void btnCompra_onAction(ActionEvent event) {

    }

    @FXML
    void btnCompra_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnSair_onAction(ActionEvent event) {
        getPai(this.bdpPrincipal);
    }
    private void getPai(Node node){
        Node aux = node.getParent();
        while(!(aux instanceof BorderPane)){
            aux=node.getParent();
        }
        ((BorderPane)aux).setCenter(null);
    }
    
    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            getPai(this.bdpPrincipal);
        }
    }

    @FXML
    void txtProduto_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
             this.objetoBuscar();
    }

    @FXML
    void cmbCategoria_onAction(ActionEvent event) {
        this.objetoBuscar();
    }// mudar para separado
    
    @FXML
    void tblProduto_onMouseClicked(MouseEvent event) {
       ProdutoEntity produto = tblProduto.getSelectionModel().getSelectedItem().getProduto();
       Completar(produto);
       if(event.getClickCount()>=2)
           this.tbpEstoque.getSelectionModel().select(this.tabDetalhe);
    }
    
    @FXML
    void tblProduto_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            ProdutoEntity produto = tblProduto.getSelectionModel().getSelectedItem().getProduto();
            Completar(produto);
            this.tbpEstoque.getSelectionModel().select(this.tabDetalhe);
        }
    }
    
    void Completar( ProdutoEntity produto){
        this.txtNome.setText(produto.getNome());
        this.txtCategoria.setText(produto.getCategoria().getNome());
        this.txtPercPromo.setText(String.valueOf(produto.getPercPromocao()));
        this.txtValorVenda.setText(String.valueOf(produto.getValorVenda()));
        this.txtMargemLucro.setText(String.valueOf(produto.getMargemLucro()));
        this.txtValorCompra.setText(String.valueOf(produto.getValorCompra()));
        this.txtPercComi.setText(String.valueOf(produto.getPercComissao()));
        
        
    }
    
    
    @FXML
    void txtQtdeEstoque_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
             this.objetoBuscar();
    }

    @FXML
    void btnPesquisar_onAction(ActionEvent event) {
        this.objetoBuscar();
    }

    @FXML
    void btnPesquisa_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            this.objetoBuscar();
    }
    
    @FXML
    void txtNome_onKeyPressed(KeyEvent event) {
        
    }

    @FXML
    void txtCategoria_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtMargemLucro_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtPercPromo_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtPercComi_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtValorVenda_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtValorCompra_onKeyPressed(KeyEvent event) {

    }
    
    @FXML
    void txtFornecedor_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
             this.objetoBuscar();
    }
    
    private void objetoBuscar(){
        ProdutoEntity produ = new ProdutoEntity();
        FornecedorEntity fornecedor = new FornecedorEntity();
        produ.setFornecedor(fornecedor);
        TabelaTelaEstoque aux;
        
        
        if (this.txtProduto.getText()==""){
            produ.setNome("");
        }else{
         produ.setNome(txtProduto.getText());
        }
        
        
        if (this.cmbCategoria.getValue()!=null){
            produ.setCategoria(categoria.getByNome(cmbCategoria.getSelectionModel().getSelectedItem().toString()));
        }else{
            produ.setCategoria(null);
        }
        
        
        if (this.txtFornecedor.getText()==""){
            produ.getFornecedor().setFantasia("");
        }else{
            produ.getFornecedor().setFantasia(txtFornecedor.getText());
        }
        
        if ("".equals(this.txtEstoque.getText())){
            produ.setQuantidade(0);
        }else{
         produ.setQuantidade(Integer.parseInt(txtEstoque.getText()));
        }
        
        List<ProdutoEntity> listaP = null;
        listaP = produto.buscarProdutos(produ);
        
        List<TabelaTelaEstoque> listProdutos = new ArrayList<>();
        
        for(ProdutoEntity vo: listaP){
            aux = new TabelaTelaEstoque(vo);
            listProdutos.add(aux);
        }
        this.completarProdutos(listProdutos);
    }
}