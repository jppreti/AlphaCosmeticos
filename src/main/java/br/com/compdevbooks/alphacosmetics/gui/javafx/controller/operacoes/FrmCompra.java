package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.operacoes;

import br.com.compdevbooks.alphacosmetics.business.Categoria;
import br.com.compdevbooks.alphacosmetics.business.Fornecedor;
import br.com.compdevbooks.alphacosmetics.business.cadastro.Produto;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.business.operacoes.ItemCompra;
import br.com.compdevbooks.alphacosmetics.business.pagamento.Banco;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.BoletoBancarioEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.PagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.SituacaoPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.TipoPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CategoriaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoCompraEnum;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaCompra;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaCompraCarrinho;
import java.util.ArrayList;
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

public class FrmCompra {

    @FXML
    private Button btnConfirmar;

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
    private Tab tabProduto;

    @FXML
    private TabPane tabPainel;

    @FXML
    private TextField txtProdutoCarrinho;

    @FXML
    private TableColumn<TabelaTelaCompraCarrinho, String> clmProdutoCarrinhoFornecedor;

    @FXML
    private Label lblQtdePedir;

    @FXML
    private Button btnCancelar;

    @FXML
    private TableView<TabelaTelaCompraCarrinho> tblProdutoCarrinho;

    @FXML
    private TableColumn<TabelaTelaCompra, String> clmProdutoProduto;

    @FXML
    private TextField txtFornecedorCarrinho;

    @FXML
    private TableView<TabelaTelaCompra> tblProduto;

    @FXML
    private TableColumn<TabelaTelaCompra, String> clmProdutoFornecedor;

    @FXML
    private TableColumn<TabelaTelaCompra, String> clmProdutoCategoria;

    @FXML
    private ComboBox<String> cmbCategoriaCarrinho;

    @FXML
    private TableColumn<TabelaTelaCompraCarrinho, Integer> clmProdutoCarrinhoQtdePedida;

    @FXML
    private ComboBox<String> cmbCategoria;

    @FXML
    private TextField txtQtdePedir;

    @FXML
    private TableColumn<TabelaTelaCompraCarrinho, String> clmProdutoCarrinhoProduto;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Tab tabCarrinho;

    @FXML
    private TableColumn<TabelaTelaCompra, Integer> clmProdutoQtdeReservada;

    @FXML
    private Button btnRemoverProduto;

    @FXML
    private Button btnAdicionarCarrinho;

    @FXML
    private TableColumn<TabelaTelaCompra, Integer> clmProdutoQtdeEsperada;

    @FXML
    private TableColumn<TabelaTelaCompraCarrinho, String> clmProdutoCarrinhoCategoria;

    @FXML
    private Button btnNovoProduto;

    @FXML
    private TableColumn<TabelaTelaCompra, Integer> clmProdutoQtdeEstoque;

    @FXML
    private Label lblMensagem;

    @FXML
    private Tab tabFormaPagamento;

    @FXML
    private TextField txtvalorTotal;

    @FXML
    private TableView<ItemCompraEntity> tblItemCompras;

    @FXML
    private TableColumn<ItemCompraEntity, String> clmFornecedor;

    @FXML
    private TableColumn<ItemCompraEntity, String> clmItemCompra;

    @FXML
    private ComboBox<TipoPagamentoEnum> cmbFormaPagamento;

    @FXML
    private TextField txtNumeroParcelas;

    @FXML
    private Button btnMenos_Parcelas;

    @FXML
    private Button btnMais_Parcelas;

    @FXML
    void btnMenos_Parcelas_onMouseClicked(MouseEvent event) {
        int x = Integer.parseInt(this.txtNumeroParcelas.getText());
        x--;
        if (x > 0) {
            this.txtNumeroParcelas.setText(Integer.toString(x));
        }
    }

    @FXML
    void btnMais_Parcelas_onMouseClicked(MouseEvent event) {
        int x = Integer.parseInt(this.txtNumeroParcelas.getText());
        x++;
        this.txtNumeroParcelas.setText(Integer.toString(x));
    }

    @FXML
    void btnFormadePagamento_onAction(ActionEvent event) {
        this.lblMensagem.setText("");
        this.tabFormaPagamento.setDisable(false);
        this.tabPainel.getSelectionModel().select(this.tabFormaPagamento);
        this.tabProduto.setDisable(true);
        this.tabCarrinho.setDisable(true);
        this.btnConfirmar.setVisible(true);
        this.completarFormaPagamento();
    }

    void completarFormaPagamento() {
        ObservableList<TipoPagamentoEnum> ob = FXCollections.observableArrayList();
        ob.add(TipoPagamentoEnum.VISTA);
        ob.add(TipoPagamentoEnum.PRAZO);

        this.cmbFormaPagamento.setItems(ob);

        this.clmFornecedor.setCellValueFactory(new PropertyValueFactory<>("NomeFornecedor"));
        this.clmItemCompra.setCellValueFactory(new PropertyValueFactory<>("NomeProduto"));
        this.tblItemCompras.setItems(FXCollections.observableArrayList(listaCarrinho));

        float x = 0;

        for (ItemCompraEntity ic : listaCarrinho) {
            x = (ic.getProdutoVO().getValorCompra()) * (ic.getQuantidadePedida());
        }

        this.txtvalorTotal.setText(Float.toString(x));

        this.btnMais_Parcelas.setDisable(true);
        this.btnMenos_Parcelas.setDisable(true);

        this.cmbFormaPagamento.getSelectionModel().selectFirst();

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
                    completarCompra();
                    getPai(this.bdpPrincipal);
                }
                if (p == nao) {
                    caixa.close();
                }
            });
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

    List<CompraEntity> listaCompras = new ArrayList<>();
    private static Banco ABanco = new Banco(DAOFactory.getDAOFactory().getBancoDAO());

    void completarCompra() {

        List<List<ItemCompraEntity>> matAux = new ArrayList<>();
        boolean i = false;
        
        matAux.add(new ArrayList<>());
        
        for (ItemCompraEntity ic : listaCarrinho) {
            if(matAux.get(0).isEmpty())matAux.get(0).add(ic);
            else{
                for (List<ItemCompraEntity> listiic : matAux) {
                    if(listiic.get(0).getProdutoVO().getFornecedor().getFantasia().equals(ic.getNomeFornecedor())) {
                        listiic.add(ic);
                        i = true;
                    }
                }
                if(!i){
                    List<ItemCompraEntity> listAux = new ArrayList<>();
                    listAux.add(ic);
                    matAux.add(listAux);
                }
            }
        }

        TipoPagamentoEnum e = this.cmbFormaPagamento.getValue();
        PagamentoEntity paga = new PagamentoEntity();
        paga.setId((long) 1);
        paga.setSituPagamento(SituacaoPagamentoEnum.NORMAL);
        paga.setTipoPagamento(e);

        Set<ParcelaPagamentoEntity> listaParcelas = new HashSet<>();

        ParcelaPagamentoEntity parcela = new ParcelaPagamentoEntity();

        BoletoBancarioEntity boleto = new BoletoBancarioEntity();
        boleto.setBancoEmissorVO(ABanco.getBancos("Banco Bradesco S.A."));
        boleto.setAgencia("5423-5");
        boleto.setCarteira("Registrada");
        
        
        int j = 1;
        if (e == TipoPagamentoEnum.VISTA) {
            
            boleto.setId((long) j);
            boleto.setCodigoBarra(UUID.randomUUID().toString());
            
            parcela.setDataVencimento(new Date());
            parcela.setValorOriginal(Float.parseFloat(this.txtvalorTotal.getText()));
            parcela.setValorTotalPago(0.00);
            parcela.setDocumentoPagamento(boleto);
            listaParcelas.add(parcela);
            paga.setListaParcelas(listaParcelas);
        } else {
            int numeroParcelas = Integer.parseInt(this.txtNumeroParcelas.getText());
            float valorParcelas = Float.parseFloat(this.txtvalorTotal.getText()) / numeroParcelas;

            for (int x = 0; x < numeroParcelas; x++) {
                boleto.setId((long)(x + 1));
                boleto.setCodigoBarra(UUID.randomUUID().toString());
                
                
                parcela.setValorOriginal(valorParcelas);
                parcela.setValorTotalPago(0.00);
                parcela.setDocumentoPagamento(boleto);
                listaParcelas.add(parcela);
            }

            paga.setListaParcelas(listaParcelas);

        }
        j = 4;
        for (List<ItemCompraEntity> l : matAux) {
            j++;
            this.listaCompras.add(new CompraEntity((long)j, new Date(), l.get(0).getProdutoVO().getFornecedor(), paga, SituacaoCompraEnum.LANCADA, new HashSet<ItemCompraEntity>(l)));
        }

        ItemCompra itensFinalizados = new ItemCompra(DAOFactory.getDAOFactory().getItemCompraDAO());

        for (ItemCompraEntity ice : listaCarrinho) {
            itensFinalizados.save(ice);
        }

        Compra compraFinalizada = new Compra(DAOFactory.getDAOFactory().getCompraDAO());

        for (CompraEntity c : listaCompras) {
            compraFinalizada.save(c);
            
        }

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
            this.btnAdicionarCarrinho.fire();
        }
    }

    @FXML
    void btnAdicionarCarrinho_onAction(ActionEvent event) {
        if ("".equals(txtQtdePedir.getText()) || this.tblProduto.getSelectionModel().getSelectedItem() == null) {
            this.lblMensagem.setText("Por Favor, selecione um produto e insira a quantidade desejada para adicionar ao carrinho.");
        } else {
            ProdutoEntity aux = this.tblProduto.getSelectionModel().getSelectedItem().getProduto();
            ItemCompraEntity aux2 = new ItemCompraEntity(Long.MIN_VALUE, Integer.parseInt(txtQtdePedir.getText()), aux);
            boolean pass = false;

            for (ItemCompraEntity ice : listaCarrinho) {
                if (ice.getProdutoVO() == aux2.getProdutoVO()) {
                    ice.setQuantidadePedida(ice.getQuantidadePedida() + aux2.getQuantidadePedida());
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
    void btnAdicionarCarrinho_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.btnAdicionarCarrinho.fire();
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
        //Chamar tela de Cadastro de Produto
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
            this.btnAdicionarCarrinho.fire();
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
            ItemCompraEntity item = tblProdutoCarrinho.getSelectionModel().getSelectedItem().getProduto();
            listaCarrinho.remove(item);
            this.completarCarrinhoComLista();
            this.lblMensagem.setText("Produto \"" + item.getProdutoVO().getNome() + "\" removido do carrinho.");
            if (listaCarrinho.size() == 0) {
                this.tabPainel.getSelectionModel().select(this.tabProduto);
                this.tabCarrinho.setDisable(true);
            }
        }
    }

    @FXML
    void btnRemover_onKeyPressed(KeyEvent event) {
        this.btnRemoverProduto.fire();
    }

    private Produto produto = new Produto(DAOFactory.getDAOFactory().getProdutoDAO());
    private ItemCompra itemCompra = new ItemCompra(DAOFactory.getDAOFactory().getItemCompraDAO());
    private Categoria categoria = new Categoria(DAOFactory.getDAOFactory().getCategoriaDAO());
    private Fornecedor fornecedor = new Fornecedor(DAOFactory.getDAOFactory().getFornecedorDAO());
    private List<ItemCompraEntity> listaCarrinho = new ArrayList<>();

    @FXML
    private void initialize() {
        List<TabelaTelaCompra> lista = new ArrayList();
        List<ProdutoEntity> l = produto.buscarTodos();
        for (ProdutoEntity vo : l) {
            lista.add(new TabelaTelaCompra(vo));
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

    private void completarProdutos(List<TabelaTelaCompra> lista) {
        this.clmProdutoProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.clmProdutoQtdeEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.clmProdutoQtdeEsperada.setCellValueFactory(new PropertyValueFactory<>("quantidadeEsperada"));
        this.clmProdutoQtdeReservada.setCellValueFactory(new PropertyValueFactory<>("quantidadeReservada"));
        this.clmProdutoCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.clmProdutoFornecedor.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        this.tblProduto.setItems(FXCollections.observableArrayList(lista));
    }

    private void completarCarrinhoComLista() {
        List<TabelaTelaCompraCarrinho> listItem = new ArrayList<>();

        for (ItemCompraEntity vo : listaCarrinho) {
            TabelaTelaCompraCarrinho aux = new TabelaTelaCompraCarrinho(vo);
            listItem.add(aux);
        }
        completarCarrinho(listItem);
    }

    private void completarCarrinho(List<TabelaTelaCompraCarrinho> lista) {

        ObservableList<String> ob = FXCollections.observableArrayList();
        List<CategoriaEntity> cat = new ArrayList<>();
        for (ItemCompraEntity ic : listaCarrinho) {
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
        TabelaTelaCompra aux;

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

        List<TabelaTelaCompra> listProdutos = new ArrayList<>();

        for (ProdutoEntity vo : listaP) {
            aux = new TabelaTelaCompra(vo);
            listProdutos.add(aux);
        }
        this.completarProdutos(listProdutos);
    }

    private void objetoBuscarCarrinho() {
        ItemCompraEntity item = new ItemCompraEntity();
        FornecedorEntity fornecedor = new FornecedorEntity();
        ProdutoEntity produto = new ProdutoEntity();
        item.setProdutoVO(produto);
        item.getProdutoVO().setFornecedor(fornecedor);
        TabelaTelaCompraCarrinho aux;

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

        List<ItemCompraEntity> listaP = null;
        listaP = buscarEmLista(item);

        List<TabelaTelaCompraCarrinho> listItem = new ArrayList<>();

        for (ItemCompraEntity vo : listaP) {
            aux = new TabelaTelaCompraCarrinho(vo);
            listItem.add(aux);
        }
        this.completarCarrinho(listItem);
    }

    public ArrayList<ItemCompraEntity> buscarEmLista(ItemCompraEntity ic) {

        ArrayList<ItemCompraEntity> buscado = new ArrayList<>();
        int x;

        for (ItemCompraEntity vo : listaCarrinho) {
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
            if (ic.getQuantidadePedida() == 0 || ic.getQuantidadePedida() <= vo.getQuantidadePedida()) {
                x++;
            }
            if (x == 4) {
                buscado.add(vo);
            }
        }
        return buscado;
    }

}
