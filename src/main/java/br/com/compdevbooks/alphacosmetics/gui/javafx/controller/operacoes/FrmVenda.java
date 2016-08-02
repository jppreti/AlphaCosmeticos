package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.operacoes;

import br.com.compdevbooks.alphacosmetics.business.Categoria;
import br.com.compdevbooks.alphacosmetics.business.Fornecedor;
import br.com.compdevbooks.alphacosmetics.business.cadastro.Produto;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.business.operacoes.ItemCompra;
import br.com.compdevbooks.alphacosmetics.business.operacoes.ItemVenda;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.business.pagamento.Banco;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.BoletoBancarioEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.FormaPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.PagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.PagamentoVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.SituacaoPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.TipoPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ArvoreCategoria;
import br.com.compdevbooks.alphacosmetics.entity.produto.CategoriaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoCompraEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoVendaEnum;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaCompra;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaCompraCarrinho;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaContasReceber;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaPagamentos;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaVenda;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaVendaCarrinho;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.jboss.weld.util.collections.ArraySet;

public class FrmVenda {
    
    @FXML
    private ProgressBar progressBar;
    
    @FXML
    private Button btnConfirmar;

    @FXML
    private Label lblNumeroDocumento;

    @FXML
    private Label lblNomeFornecedor;

    @FXML
    private Label lblBancoAgencia;

    @FXML
    private Label lblBanco;

    @FXML
    private Label lblCodigoBarras;

    @FXML
    private Label lblValorTotal;

    @FXML
    private Label lblValorParcela;

    @FXML
    private Label lblDataVenc;

    @FXML
    private Button btnProximo;

    @FXML
    private Button btnMais;

    @FXML
    private Button btnMenos;

    @FXML
    private Button btnFormadePagamento;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private TextField txtProduto;

    @FXML
    private BorderPane bdpPrincipal;

    @FXML
    private Button btnPesquisarCarrino;

    @FXML
    private Tab tabCatalogo;

    @FXML
    private TabPane tabPainel;

    @FXML
    private TextField txtProdutoCarrinho;

    @FXML
    private TableColumn<TabelaTelaVendaCarrinho, String> clmProdutoCarrinhoFornecedor;

    @FXML
    private Label lblQtdePedir;

    @FXML
    private Button btnCancelar;

    @FXML
    private TableView<TabelaTelaVendaCarrinho> tblProdutoCarrinho;

    @FXML
    private TableColumn<TabelaTelaVenda, String> clmProdutoProduto;

    @FXML
    private TextField txtFornecedorCarrinho;

    @FXML
    private TableView<TabelaTelaVenda> tblProduto;

    @FXML
    private TableColumn<TabelaTelaVenda, String> clmProdutoFornecedor;

    @FXML
    private TableColumn<TabelaTelaVenda, String> clmProdutoCategoria;

    @FXML
    private ComboBox<String> cmbCategoriaCarrinho;

    @FXML
    private TableColumn<TabelaTelaVendaCarrinho, Integer> clmProdutoCarrinhoQtdePedida;

    @FXML
    private ComboBox<String> cmbCategoria;

    @FXML
    private TextField txtQtdePedir;

    @FXML
    private TableColumn<TabelaTelaVendaCarrinho, String> clmProdutoCarrinhoProduto;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Tab tabCarrinho;

    @FXML
    private TableColumn<TabelaTelaVenda, Integer> clmProdutoQtdeReservada;

    @FXML
    private Button btnRemoverProduto;

    @FXML
    private TableColumn<TabelaTelaVenda, Integer> clmProdutoQtdeEsperada;

    @FXML
    private TableColumn<TabelaTelaVendaCarrinho, String> clmProdutoCarrinhoCategoria;

    @FXML
    private Button btnNovoProduto;

    @FXML
    private TableColumn<TabelaTelaVenda, Integer> clmProdutoQtdeEstoque;

    @FXML
    private Label lblMensagem;

    @FXML
    private Tab tabFormaPagamento;

    @FXML
    private TableView<ItemVendaEntity> tblItemVendas;

    @FXML
    private TableColumn<ItemVendaEntity, String> clmFornecedor;

    @FXML
    private TableColumn<ItemVendaEntity, String> clmItemVenda;

    @FXML
    private ComboBox<FormaPagamentoEnum> cmbFormaPagamento;

    @FXML
    private TextField txtNumeroParcelas;

    @FXML
    private Button btnMenos_Parcelas;

    @FXML
    private Button btnMais_Parcelas;
    
    @FXML 
    private TreeView<String> treeCategoria;
    
    @FXML 
    private TableView tblFormaPagamento;
    
    @FXML 
    private TableColumn clmFormaPagamento;
    
    @FXML
    private TableColumn clmQtdPrcelas;
    
    @FXML
    private TableColumn cmlValorParcela;
    
    @FXML
    private TableColumn cmlValorTotal;

    
    private String categoriaSelecionada;
    private ArvoreCategoria arvore;
    private TreeItem root = new TreeItem();
    
    private String pai;
    private String avo;
    
    //ID
    
    int id_global = 100;

    int getId() {
        id_global++;
        return id_global;
    }
    
    @FXML
    void txtNumeroParcelas_onAction(ActionEvent event){
        int x = Integer.parseInt(this.txtNumeroParcelas.getText());
        valorParcelas = Float.parseFloat(this.lblValorTotal.getText())/x;
        this.lblValorParcela.setText(new DecimalFormat("##.##").format(valorParcelas));
    }
    
    @FXML
    void txtNumeroParcelas_onKeyPressed(KeyEvent event){
        if (event.getCode() == KeyCode.ENTER) {
            this.btnProximo.requestFocus();
        }
    }
    
    
    @FXML
    void btnProximo_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.btnProximo.fire();
        }
    }
    
    private int numeroFornecedor = 0;
    private Set<ParcelaPagamentoEntity> listaparcelapagamento = new ArraySet();
    
    public void completarTabela(){
         ObservableList<TabelaTelaPagamentos> dado = FXCollections.observableArrayList();
        for(ParcelaPagamentoEntity parc: listaparcelapagamento){
            TabelaTelaPagamentos tabela = new TabelaTelaPagamentos();
            
            
            
            dado.add(tabela);
            
        }
        
        
    }
    @FXML
    void btnProximo_onAction(ActionEvent event) {
        
       
        
        for (int i =0 ; i< Integer.parseInt(txtNumeroParcelas.getText());i++){
             ParcelaPagamentoEntity parc = new ParcelaPagamentoEntity();
        parc.setValorOriginal(valorParcelas);
        
        listaparcelapagamento.add(parc);
        }
        
        
        
        completarTabela();
        
        /*if (true) // ADICIONAR ERROS.
        {
            completarVenda();
            numeroFornecedor++;
        }
        if(numeroFornecedor+1 > matAux.size()) {
            this.btnProximo.setDisable(true);
            this.btnConfirmar.setVisible(true);
        }else{
            List<ItemVendaEntity> li = new ArrayList();
            li = matAux.get(numeroFornecedor);
            this.completarFormaPagamento(li);
        }*/
        completarVenda();
    }

    float valorParcelas = 0;

    @FXML
    void btnMenos_Parcelas_onMouseClicked(MouseEvent event) {
        int x = Integer.parseInt(this.txtNumeroParcelas.getText());
        x--;
        if (x > 0) {
            this.txtNumeroParcelas.setText(Integer.toString(x));
            valorParcelas = Float.parseFloat(this.lblValorTotal.getText())/x;
            this.lblValorParcela.setText(new DecimalFormat("##.##").format(valorParcelas));
        }
    }

    @FXML
    void btnMais_Parcelas_onMouseClicked(MouseEvent event) {
        int x = Integer.parseInt(this.txtNumeroParcelas.getText());
        x++;
        this.txtNumeroParcelas.setText(Integer.toString(x));
        valorParcelas = Float.parseFloat(this.lblValorTotal.getText())/x;
        this.lblValorParcela.setText(new DecimalFormat("##.##").format(valorParcelas));
    }

    List<List<ItemVendaEntity>> matAux = new ArrayList<>();

    @FXML
    void btnFormadePagamento_onAction(ActionEvent event) {
        this.lblMensagem.setText("");
        this.tabFormaPagamento.setDisable(false);
        this.tabPainel.getSelectionModel().select(this.tabFormaPagamento);
        this.tabCatalogo.setDisable(true);
        this.tabCarrinho.setDisable(true);

        ObservableList<FormaPagamentoEnum> ob = FXCollections.observableArrayList();
        ob.add(FormaPagamentoEnum.CARTÃO_CRÉDITO);
        ob.add(FormaPagamentoEnum.CARTÃO_DEBITO);
        ob.add(FormaPagamentoEnum.CHEQUE);
        ob.add(FormaPagamentoEnum.DINHEIRO);

        this.cmbFormaPagamento.setItems(ob);
        
        /*
        boolean i = false;
        matAux.add(new ArrayList<>());

        for (ItemVendaEntity ic : listaCarrinho) {
            if (matAux.get(0).isEmpty()) {
                matAux.get(0).add(ic);
            } else {
                for (List<ItemVendaEntity> listiic : matAux) {
                    if (listiic.get(0).getProdutoVO().getFornecedor().getFantasia().equals(ic.getNomeFornecedor())) {
                        listiic.add(ic);
                        i = true;
                    }
                }
                if (!i) {
                    List<ItemVendaEntity> listAux = new ArrayList<>();
                    listAux.add(ic);
                    matAux.add(listAux);
                }
            }
            i = false;
        }*/
        completarFormaPagamento(listaCarrinho);
    }

    void completarFormaPagamento(List<ItemVendaEntity> li) {
        
        this.clmItemVenda.setCellValueFactory(new PropertyValueFactory<>("NomeProduto"));
        this.tblItemVendas.setItems(FXCollections.observableArrayList(li));

        float x = 0;
        for (ItemVendaEntity ic : li) {
            x = x + (ic.getProdutoVO().getValorCompra()) * (ic.getQuantidade());
        }
        this.lblValorTotal.setText(Float.toString(x));

        this.txtNumeroParcelas.setText("1");
        this.cmbFormaPagamento.getSelectionModel().selectFirst();

        this.btnMais_Parcelas.setDisable(true);
        this.btnMenos_Parcelas.setDisable(true);

        this.lblValorParcela.setText(this.lblValorTotal.getText());
        
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, diasdepoisdhoje);
        this.lblDataVenc.setText(cal.getTime().toString());
            
    }

    @FXML
    void btnFormadePagamento_onKeyPressed(KeyEvent event) {
        this.btnFormadePagamento.fire();
    }

    @FXML
    void btnConfirmar_onAction(ActionEvent event) {
        if (listaCarrinho.size() == 0) {

        } else {
            Alert caixa = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType sim = new ButtonType("Sim");
            ButtonType nao = new ButtonType("Não");
            caixa.setTitle("AlphaComesticos");
            caixa.setHeaderText("Confirmar Compra");
            caixa.setContentText("Deseja confirmar esta compra?");
            caixa.getButtonTypes().setAll(sim, nao);

            caixa.showAndWait().ifPresent(p -> {
                if (p == sim) {
                    finalizarVenda();
                    getPai(this.bdpPrincipal);
                }
                if (p == nao) {
                    caixa.close();
                }
            });
        }
    }

    void finalizarVenda() {

        ItemVenda itensFinalizados = new ItemVenda(DAOFactory.getDAOFactory().getItemVendaDAO());

        for (ItemVendaEntity ice : listaCarrinho) {
            itensFinalizados.save(ice);
        }

        Venda vendaFinalizada = new Venda(DAOFactory.getDAOFactory().getVendaDAO());

        for (VendaEntity c : listaVendas) {
            vendaFinalizada.save(c);

        }
    }

    @FXML
    void cmbFormaPagamento_onAction(ActionEvent event) {
        if (cmbFormaPagamento.getSelectionModel().getSelectedItem().equals(TipoPagamentoEnum.VISTA)) {
            this.txtNumeroParcelas.setText("1");
            this.txtNumeroParcelas.setDisable(true);
            this.btnMais_Parcelas.setDisable(true);
            this.btnMenos_Parcelas.setDisable(true);
        } else {
            this.txtNumeroParcelas.setDisable(false);
            this.btnMais_Parcelas.setDisable(false);
            this.btnMenos_Parcelas.setDisable(false);
        }
    }

    List<VendaEntity> listaVendas = new ArrayList<>();
    private static Banco ABanco = new Banco(DAOFactory.getDAOFactory().getBancoDAO());
    private int diasdepoisdhoje = 10;

    void completarVenda() {
        double valorTotalFormaPagamento = 0;
        FormaPagamentoEnum e = this.cmbFormaPagamento.getValue();
        PagamentoVendaEntity paga = new PagamentoVendaEntity();
        paga.setId((long) this.getId());
        paga.setSituPagamento(SituacaoPagamentoEnum.NORMAL);
        paga.setFormaPagamento(e);

        Set<ParcelaPagamentoEntity> listaParcelas = new HashSet<>();
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, diasdepoisdhoje);

        if (e == FormaPagamentoEnum.DINHEIRO || e == FormaPagamentoEnum.CARTÃO_DEBITO) {            
            ParcelaPagamentoEntity parcela = new ParcelaPagamentoEntity();
            parcela.setId((long) this.getId());
            parcela.setDataVencimento(cal.getTime());
            parcela.setValorOriginal(Float.parseFloat(this.lblValorTotal.getText()));
            parcela.setValorTotalPago(0.00);
            listaParcelas.add(parcela);
            paga.setListaParcelas(listaParcelas);
        } else {
            int numeroParcelas = Integer.parseInt(this.txtNumeroParcelas.getText());

            for (int x = 0; x < numeroParcelas; x++) {
                ParcelaPagamentoEntity parcela = new ParcelaPagamentoEntity();
                parcela.setId((long) this.getId());
                parcela.setDataVencimento(cal.getTime());
                parcela.setValorOriginal(valorParcelas);
                parcela.setValorTotalPago(0.00);
                listaParcelas.add(parcela);
                valorTotalFormaPagamento = valorTotalFormaPagamento + parcela.getValorTotalPago();
            }
            paga.setListaParcelas(listaParcelas);

        }

        List<ItemVendaEntity> l = matAux.get(numeroFornecedor);
        //this.listaVendas.add(new VendaEntity((long) this.getId(), new Date(), l.get(0).getProdutoVO().getFornecedor(), paga, SituacaoVendaEnum.ENVIADA, new HashSet<ItemVendaEntity>(l))); 
        //this.progressBar.setProgress((double) (numeroFornecedor + 1)/matAux.size());
        System.out.println(" " + valorTotalFormaPagamento);
    }

    @FXML
    void btnConfirmar_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.btnConfirmar.fire();
        }
    }

    @FXML
    void btnCancelar_onAction(ActionEvent event) {
        getPai(this.bdpPrincipal);
    }

    @FXML
    void btnCancelar_onKeyPressed(KeyEvent event) {
        getPai(this.bdpPrincipal);
    }

    private void getPai(Node node) {
        Node aux = node.getParent();
        while (!(aux instanceof BorderPane)) {
            aux = node.getParent();
        }
        ((BorderPane) aux).setCenter(null);
    }

    @FXML
    void txtProduto_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.objetoBuscar();
        }
    }

    @FXML
    void txtFornecedor_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.objetoBuscar();
        }
    }

    @FXML
    void btnPesquisar_onAction(ActionEvent event) {
        this.objetoBuscar();
    }

    @FXML
    void btnPesquisar_onKeyPressed(KeyEvent event) {
        this.objetoBuscar();
    }

    @FXML
    void txtQtdePedir_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.adicionaraocarrinho();
        }
    }

    void adicionaraocarrinho() {
        if ("".equals(txtQtdePedir.getText()) || this.tblProduto.getSelectionModel().getSelectedItem() == null) {
            this.lblMensagem.setText("Por Favor, selecione um produto e insira a quantidade desejada para adicionar ao carrinho.");
        } else {
            ProdutoEntity aux = this.tblProduto.getSelectionModel().getSelectedItem().getProduto();
            ItemVendaEntity aux2 = new ItemVendaEntity((long) this.getId(),Integer.parseInt(txtQtdePedir.getText()),0,0, aux);
            boolean pass = false;

            for (ItemVendaEntity ice : listaCarrinho) {
                if (ice.getProdutoVO() == aux2.getProdutoVO()) {
                    ice.setQuantidade(ice.getQuantidade() + aux2.getQuantidade());
                    pass = true;
                }
            }
            if (!pass) {
                listaCarrinho.add(aux2);
            }
            completarCarrinhoComLista();
            this.lblMensagem.setText("Produto \"" + aux2.getProdutoVO().getNome() + "\" adicionado ao carrinho.");
            this.tabCarrinho.setDisable(false);
        }
    }

    @FXML
    void txtProdutoCarrinho_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.objetoBuscarCarrinho();
        }
    }

    @FXML
    void txtProdutoFornecedor_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.objetoBuscar();
        }
    }

    @FXML
    void cmbCategoriaCarrinho_onAction(ActionEvent event) {
        this.objetoBuscar();
    }

    @FXML
    void btnPesquisarCarrinho_onAction(ActionEvent event) {
        this.objetoBuscarCarrinho();
    }

    @FXML
    void btnPesquisarCarrinho_onKeyPressed(KeyEvent event) {
        this.objetoBuscarCarrinho();
    }

    @FXML
    void btnNovoProduto_onAction(ActionEvent event) {
        if (this.tblProduto.getSelectionModel().getSelectedItem() == null) {
            this.lblMensagem.setText("Por Favor, selecione um item para Adcionar ao carrinho.");
        }else{
            this.adicionaraocarrinho();
        }
    }

    @FXML
    void btnNovoProduto_onKeyPressed(KeyEvent event) {
        this.btnNovoProduto.fire();
    }

    @FXML
    void tblProduto_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.txtQtdePedir.requestFocus();
        }
    }

    @FXML
    void tblProduto_onMouseClicked(MouseEvent event) {
        if (event.getClickCount() >= 2) {
            this.adicionaraocarrinho();
        }
    }

    @FXML
    void tblProdutoCarrinho_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.btnRemoverProduto.requestFocus();
        }
    }

    @FXML
    void btnMais_onMouseClicked(MouseEvent event) {
        int x = Integer.parseInt(this.txtQtdePedir.getText());
        x++;
        this.txtQtdePedir.setText(Integer.toString(x));
    }

    @FXML
    void btnMenos_onMouseClicked(MouseEvent event) {
        int x = Integer.parseInt(this.txtQtdePedir.getText());
        if (x > 1) {
            x--;
        }
        this.txtQtdePedir.setText(Integer.toString(x));
    }

    @FXML
    void btnRemover_onAction(ActionEvent event) {
        if (this.tblProdutoCarrinho.getSelectionModel().getSelectedItem() == null) {
            this.lblMensagem.setText("Por Favor, selecione um item para remover do carrinho.");
        } else {
            ItemVendaEntity item = tblProdutoCarrinho.getSelectionModel().getSelectedItem().getProduto();
            listaCarrinho.remove(item);
            this.completarCarrinhoComLista();
            this.lblMensagem.setText("Produto \"" + item.getProdutoVO().getNome() + "\" removido do carrinho.");
            if (listaCarrinho.size() == 0) {
                this.tabPainel.getSelectionModel().select(this.tabCatalogo);
                this.tabCarrinho.setDisable(true);
            }
        }
    }

    @FXML
    void btnRemover_onKeyPressed(KeyEvent event) {
        this.btnRemoverProduto.fire();
    }

    private Produto produto = new Produto(DAOFactory.getDAOFactory().getProdutoDAO());
    private ItemVenda itemVenda = new ItemVenda(DAOFactory.getDAOFactory().getItemVendaDAO());
    private Categoria categoria = new Categoria(DAOFactory.getDAOFactory().getCategoriaDAO());
    private Fornecedor fornecedor = new Fornecedor(DAOFactory.getDAOFactory().getFornecedorDAO());
    private List<ItemVendaEntity> listaCarrinho = new ArrayList<>();

    @FXML
    private void initialize() {
        arvore = new ArvoreCategoria(this.treeCategoria, this.root);
        List<TabelaTelaVenda> lista = new ArrayList();
        List<ProdutoEntity> l = produto.buscarTodos();
        for (ProdutoEntity vo : l) {
            lista.add(new TabelaTelaVenda(vo));
        }
        this.completarProdutos(lista);

        ObservableList<String> ob = FXCollections.observableArrayList();
        for (CategoriaEntity cat : categoria.buscarTodasCategorias()) {
            ob.add(cat.getNome());
        }
        this.cmbCategoria.setItems(ob);

        this.txtQtdePedir.setText("1");

        this.lblMensagem.setText("Por Favor, selecione um produto e insira a quantidade desejada para adicionar ao carrinho.");
    }

    private void completarProdutos(List<TabelaTelaVenda> lista) {
        this.clmProdutoProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.clmProdutoQtdeEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.clmProdutoQtdeEsperada.setCellValueFactory(new PropertyValueFactory<>("quantidadeEsperada"));
        this.clmProdutoQtdeReservada.setCellValueFactory(new PropertyValueFactory<>("quantidadeReservada"));
        this.clmProdutoCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.clmProdutoFornecedor.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        

//Método para colorir tabela: Por Professor.
    /*    this.clmProdutoFornecedor.setCellFactory(column -> {
        return new TableCell<TabelaTelaVenda, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                setText(empty ? "" : getItem().toString());
                setGraphic(null);

                TableRow<TabelaTelaVenda> currentRow = getTableRow();

                if (!isEmpty()) {

                    if(item.equals("Fantasia 1")) 
                        currentRow.setStyle("-fx-background-color:lightcoral");
                    else
                        currentRow.setStyle("-fx-background-color:lightgreen");
                }

            }
        };
    });*/
        
        
        this.tblProduto.setItems(FXCollections.observableArrayList(lista));
    }

    private void completarCarrinhoComLista() {
        List<TabelaTelaVendaCarrinho> listItem = new ArrayList<>();

        for (ItemVendaEntity vo : listaCarrinho) {
            TabelaTelaVendaCarrinho aux = new TabelaTelaVendaCarrinho(vo);
            listItem.add(aux);
        }
        completarCarrinho(listItem);
    }

    private void completarCarrinho(List<TabelaTelaVendaCarrinho> lista) {

        ObservableList<String> ob = FXCollections.observableArrayList();
        List<CategoriaEntity> cat = new ArrayList<>();
        for (ItemVendaEntity ic : listaCarrinho) {
            cat.add(ic.getProdutoVO().getCategoriaVO());
        }
        for (CategoriaEntity x : cat) {
            ob.add(x.getNome());
        }
        this.cmbCategoriaCarrinho.setItems(ob);

        this.clmProdutoCarrinhoProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.clmProdutoCarrinhoQtdePedida.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.clmProdutoCarrinhoCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.clmProdutoCarrinhoFornecedor.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        this.tblProdutoCarrinho.setItems(FXCollections.observableArrayList(lista));
    }

    private void objetoBuscar() {
        ProdutoEntity produ = new ProdutoEntity();
        FornecedorEntity fornecedor = new FornecedorEntity();
        produ.setFornecedor(fornecedor);
        TabelaTelaVenda aux;

        if (this.txtProduto.getText() == "") {
            produ.setNome("");
        } else {
            produ.setNome(txtProduto.getText());
        }

        if (this.cmbCategoria.getValue() != null) {
            produ.setCategoria(categoria.getByNome(cmbCategoria.getSelectionModel().getSelectedItem().toString()));
        } else {
            produ.setCategoria(null);
        }

        if (this.txtFornecedor.getText() == "") {
            produ.getFornecedor().setFantasia("");
        } else {
            produ.getFornecedor().setFantasia(txtFornecedor.getText());
        }

        List<ProdutoEntity> listaP = null;
        listaP = produto.buscarProdutos(produ);

        List<TabelaTelaVenda> listProdutos = new ArrayList<>();

        for (ProdutoEntity vo : listaP) {
            aux = new TabelaTelaVenda(vo);
            listProdutos.add(aux);
        }
        this.completarProdutos(listProdutos);
    }

    private void objetoBuscarCarrinho() {
        ItemVendaEntity item = new ItemVendaEntity();
        FornecedorEntity fornecedor = new FornecedorEntity();
        ProdutoEntity produto = new ProdutoEntity();
        item.setProdutoVO(produto);
        item.getProdutoVO().setFornecedor(fornecedor);
        TabelaTelaVendaCarrinho aux;

        if (this.txtProdutoCarrinho.getText() == "") {
            item.getProdutoVO().setNome("");
        } else {
            item.getProdutoVO().setNome(txtProdutoCarrinho.getText());
        }

        if (this.cmbCategoriaCarrinho.getValue() != null) {
            item.getProdutoVO().setCategoria(categoria.getByNome(cmbCategoriaCarrinho.getSelectionModel().getSelectedItem().toString()));
        } else {
            item.getProdutoVO().setCategoria(null);
        }

        if (this.txtFornecedorCarrinho.getText() == "") {
            item.getProdutoVO().setNome("");
        } else {
            item.getProdutoVO().getFornecedor().setFantasia(txtFornecedorCarrinho.getText());
        }

        List<ItemVendaEntity> listaP = null;
        listaP = buscarEmLista(item);

        List<TabelaTelaVendaCarrinho> listItem = new ArrayList<>();

        for (ItemVendaEntity vo : listaP) {
            aux = new TabelaTelaVendaCarrinho(vo);
            listItem.add(aux);
        }
        this.completarCarrinho(listItem);
    }

    public ArrayList<ItemVendaEntity> buscarEmLista(ItemVendaEntity ic) {

        ArrayList<ItemVendaEntity> buscado = new ArrayList<>();
        int x;

        for (ItemVendaEntity vo : listaCarrinho) {
            x = 0;
            if (ic.getProdutoVO().getNome().equals("") || vo.getProdutoVO().getNome().toUpperCase().contains(ic.getProdutoVO().getNome().toUpperCase())) {
                x++;
            }
            if (ic.getProdutoVO().getCategoria() == null || ic.getProdutoVO().getCategoria().getId().equals(vo.getProdutoVO().getCategoria().getId())) {
                x++;
            }
            if (ic.getProdutoVO().getFornecedor().getFantasia().equals("") || vo.getProdutoVO().getFornecedor().getFantasia().toUpperCase().contains(ic.getProdutoVO().getFornecedor().getFantasia().toUpperCase())) {
                x++;
            }
            if (ic.getQuantidade() == 0 || ic.getQuantidade() <= vo.getQuantidade()) {
                x++;
            }
            if (x == 4) {
                buscado.add(vo);
            }
        }
        return buscado;
    }
    
    @FXML
    public void treeCategoria_onMouseClicked(MouseEvent mouseEvent) {
        //Para ativar o evento do mouse necessita dar 2 clicks
        if(mouseEvent.getClickCount() == 2){
            
            //captura da TreeItem que sofreu a acao
            TreeItem item = (TreeItem) treeCategoria.getSelectionModel().getSelectedItem();
            
            //Nivel 3 - TreeView(treeCategoria)
            if (treeCategoria.getTreeItemLevel(item) == 3){
                categoriaSelecionada =  item.getValue().toString();
                pai = item.getParent().getValue().toString();
                avo = item.getParent().getParent().getValue().toString();
                System.out.println(categoriaSelecionada+" <----- "+avo+"/"+pai);
                
                ProdutoEntity produ = new ProdutoEntity();
                FornecedorEntity fornecedor = new FornecedorEntity();
                produ.setFornecedor(fornecedor);
                TabelaTelaVenda aux;
                produ.setNome("");
                
                
                //btnNovoProduto.setDisable(false);        
                
                produ.setCategoria(categoria.getByNome(categoriaSelecionada));                
                produ.getFornecedor().setFantasia("");
                
                List<ProdutoEntity> listaP = null;
                listaP = produto.buscarProdutos(produ);
                
                List<TabelaTelaVenda> listaProdutos = new ArrayList<>();
                
                for(ProdutoEntity vo : listaP){
                    aux = new TabelaTelaVenda(vo);
                    listaProdutos.add(aux);
                }
                this.completarProdutos(listaProdutos);
                
            }
            
            //Nivel 2 - TreeView(treeCategoria) 
            else if (treeCategoria.getTreeItemLevel(item) == 2){
                if(item.getValue().toString().compareTo("Acessorios") == 0){ //caso especial
                    categoriaSelecionada = (String) item.getValue(); 
                    pai = item.getParent().getValue().toString();
                    avo = null;
                    System.out.println(categoriaSelecionada+" <----- "+avo+"/"+pai);
                    ProdutoEntity produ = new ProdutoEntity();
                    FornecedorEntity fornecedor = new FornecedorEntity();
                    produ.setFornecedor(fornecedor);
                    TabelaTelaVenda aux;
                    produ.setNome("");
                
                
                    //btnNovoProduto.setDisable(false);        
                
                    produ.setCategoria(categoria.getByNome(categoriaSelecionada));                
                    produ.getFornecedor().setFantasia("");
                
                    List<ProdutoEntity> listaP = null;
                    listaP = produto.buscarProdutos(produ);
                
                    List<TabelaTelaVenda> listaProdutos = new ArrayList<>();
                
                    for(ProdutoEntity vo : listaP){
                        aux = new TabelaTelaVenda(vo);
                        listaProdutos.add(aux);
                    }
                    this.completarProdutos(listaProdutos);
                }else {
                    categoriaSelecionada = (String) item.getValue();
                    pai = item.getParent().getValue().toString();
                    avo = null;
                    System.out.println(categoriaSelecionada+" <----- "+avo+"/"+pai);
                    ProdutoEntity produ = new ProdutoEntity();
                    FornecedorEntity fornecedor = new FornecedorEntity();
                    produ.setFornecedor(fornecedor);
                    TabelaTelaVenda aux;
                    produ.setNome("");
                
                
                    //btnNovoProduto.setDisable(false);        
                
                    produ.setCategoria(categoria.getByNome(categoriaSelecionada));                
                    produ.getFornecedor().setFantasia("");
                
                    List<ProdutoEntity> listaP = null;
                    listaP = produto.buscarProdutos(produ);
                
                    List<TabelaTelaVenda> listaProdutos = new ArrayList<>();
                
                    for(ProdutoEntity vo : listaP){
                        aux = new TabelaTelaVenda(vo);
                        listaProdutos.add(aux);
                    }
                    this.completarProdutos(listaProdutos);
                }
            }
            
            //Nivel 1 - TreeView(treeCategoria)
            else if (treeCategoria.getTreeItemLevel(item) == 1){
                categoriaSelecionada = (String) item.getValue();
                pai = null;
                avo = null;
                System.out.println(categoriaSelecionada+" <----- "+avo+"/"+pai);
            }
        }
    }

}
