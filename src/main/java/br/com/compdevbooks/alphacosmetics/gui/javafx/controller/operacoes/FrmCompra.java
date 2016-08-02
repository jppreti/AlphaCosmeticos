package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.operacoes;

import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaCompraCarrinho;
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
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.GerarEmailCompra;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaCompra;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FrmCompra {

    @FXML
    private TableView<TabelaTelaCompraCarrinho> tblProdutoCarrinho;

    @FXML
    private TableColumn<TabelaTelaCompra, String> clmProdutoProduto;

    @FXML
    private TableView<TabelaTelaCompra> tblProduto;

    @FXML
    private TableColumn<TabelaTelaCompra, String> clmProdutoFornecedor;

    @FXML
    private TableColumn<TabelaTelaCompra, String> clmProdutoCategoria;

    @FXML
    private ComboBox<String> cmbCategoriaCarrinho;

    @FXML
    private ComboBox<String> cmbCategoria;

    @FXML
    private TableColumn<TabelaTelaCompra, Integer> clmProdutoQtdeReservada;

    @FXML
    private TableColumn<TabelaTelaCompra, Integer> clmProdutoQtdeEsperada;

    @FXML
    private TableColumn<TabelaTelaCompra, Integer> clmProdutoQtdeEstoque;

    @FXML
    private TableView<ItemCompraEntity> tblItemCompras;

    @FXML
    private TableColumn<ItemCompraEntity, String> clmFornecedor;

    @FXML
    private TableColumn<ItemCompraEntity, String> clmItemCompra;

    @FXML
    private ComboBox<TipoPagamentoEnum> cmbFormaPagamento;

    @FXML
    private TableColumn<TabelaTelaCompraCarrinho, Float> clmCarrinhoValorTotal;

    @FXML
    private TableColumn<TabelaTelaCompraCarrinho, Integer> clmCarrinhoQuantidade;

    @FXML
    private TableColumn<TabelaTelaCompraCarrinho, String> clmCarrinhoProduto;

    @FXML
    private TableColumn<TabelaTelaCompraCarrinho, Float> clmCarrinhoValorUni;

    @FXML
    private TableColumn<TabelaTelaCompraCarrinho, String> clmCarrinhoFornecedor;

    @FXML
    private Button btnConfirmar;

    @FXML
    private ToggleButton btnCarinho;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private TreeView<?> treeCategoria;

    @FXML
    private BorderPane bdnPrincipal;

    @FXML
    private Label lblCodigoBarras;

    @FXML
    private TextField txtProduto;

    @FXML
    private Label lblValorParcela;

    @FXML
    private VBox paneCarrinho;

    @FXML
    private Button btnMenos_Parcelas;

    @FXML
    private Button btnLayout;

    @FXML
    private Button btnLayout2;

    @FXML
    private VBox paneProduto1;

    @FXML
    private Label lblSelecionarProduto;

    @FXML
    private BorderPane paneProduto2;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label lblBanco;

    @FXML
    private StackPane paneFormaPgto;

    @FXML
    private Label lblXdeY;

    @FXML
    private Button btnFormadePagamento;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Label lblNumeroDocumento;

    @FXML
    private Label lblBancoAgencia;

    @FXML
    private Label lblDataVenc;

    @FXML
    private Button btnProximo;

    @FXML
    private Label lblNomeFornecedor;

    @FXML
    private TextField txtNumeroParcelas;

    @FXML
    private Button btnPesquisar2;

    @FXML
    private Label lblValorTotal;

    @FXML
    private Label lblSelecionarProduto3;

    @FXML
    private Button btnMais_Parcelas;

    @FXML
    private Label lblMensagem;

    @FXML
    private TextField txtProduto2;

    final KeyCombination keyComb1 = new KeyCodeCombination(KeyCode.C, KeyCombination.SHIFT_DOWN,KeyCodeCombination.CONTROL_DOWN);
    final KeyCombination keyComb2 = new KeyCodeCombination(KeyCode.L, KeyCombination.SHIFT_DOWN,KeyCodeCombination.CONTROL_DOWN);
    final KeyCombination keyComb3 = new KeyCodeCombination(KeyCode.P, KeyCombination.SHIFT_DOWN,KeyCodeCombination.CONTROL_DOWN);
    final KeyCombination keyComb4 = new KeyCodeCombination(KeyCode.F, KeyCombination.SHIFT_DOWN,KeyCodeCombination.CONTROL_DOWN);
    

    //ID
    int id_global = 100;

    int getId() {
        id_global++;
        return id_global;
    }

    @FXML
    void txtNumeroParcelas_onAction(ActionEvent event) {
        int x = Integer.parseInt(this.txtNumeroParcelas.getText());
        valorParcelas = Float.parseFloat(this.lblValorTotal.getText()) / x;
        this.lblValorParcela.setText(new DecimalFormat("##.##").format(valorParcelas));
    }

    @FXML
    void txtNumeroParcelas_onKeyPressed(KeyEvent event) {
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

    @FXML
    void btnProximo_onAction(ActionEvent event) {
        if (true) // ADICIONAR ERROS.
        {
            completarCompra();
            numeroFornecedor++;
        }
        if (numeroFornecedor + 1 > matAux.size()) {
            this.btnProximo.setDisable(true);
            this.btnConfirmar.setVisible(true);
        } else {
            List<ItemCompraEntity> li = new ArrayList();
            li = matAux.get(numeroFornecedor);
            this.completarFormaPagamento(li);
        }
    }

    float valorParcelas = 0;

    @FXML
    void btnMenos_Parcelas_onMouseClicked(MouseEvent event) {
        int x = Integer.parseInt(this.txtNumeroParcelas.getText());
        x--;
        if (x > 0) {
            this.txtNumeroParcelas.setText(Integer.toString(x));
            valorParcelas = Float.parseFloat(this.lblValorTotal.getText()) / x;
            this.lblValorParcela.setText(new DecimalFormat("##.##").format(valorParcelas));
        }
    }

    @FXML
    void btnMais_Parcelas_onMouseClicked(MouseEvent event) {
        int x = Integer.parseInt(this.txtNumeroParcelas.getText());
        x++;
        this.txtNumeroParcelas.setText(Integer.toString(x));
        valorParcelas = Float.parseFloat(this.lblValorTotal.getText()) / x;
        this.lblValorParcela.setText(new DecimalFormat("##.##").format(valorParcelas));
    }

    List<List<ItemCompraEntity>> matAux = new ArrayList<>();

    @FXML
    void btnFormadePagamento_onAction(ActionEvent event) {
        this.lblMensagem.setText("");
        this.btnCarinho.setVisible(false);
        this.paneCarrinho.setVisible(false);
        this.paneFormaPgto.setVisible(true);

        ObservableList<TipoPagamentoEnum> ob = FXCollections.observableArrayList();
        ob.add(TipoPagamentoEnum.VISTA);
        ob.add(TipoPagamentoEnum.PRAZO);

        this.cmbFormaPagamento.setItems(ob);

        boolean i = false;
        matAux.add(new ArrayList<>());

        for (TabelaTelaCompraCarrinho ic : listaCarrinho) {
            if (matAux.get(0).isEmpty()) {
                matAux.get(0).add(ic.getItemCompra());
            } else {
                for (List<ItemCompraEntity> listiic : matAux) {
                    if (listiic.get(0).getProdutoVO().getFornecedor().getFantasia().equals(ic.getNomeFornecedor())) {
                        listiic.add(ic.getItemCompra());
                        i = true;
                    }
                }
                if (!i) {
                    List<ItemCompraEntity> listAux = new ArrayList<>();
                    listAux.add(ic.getItemCompra());
                    matAux.add(listAux);
                }
            }
            i = false;
        }
        completarFormaPagamento(matAux.get(0));
    }

    boolean f = false;

    void completarFormaPagamento(List<ItemCompraEntity> li) {

        this.clmItemCompra.setCellValueFactory(new PropertyValueFactory<>("NomeProduto"));
        this.tblItemCompras.setItems(FXCollections.observableArrayList(li));

        float x = 0;
        for (ItemCompraEntity ic : li) {
            x = (ic.getProdutoVO().getValorCompra()) * (ic.getQuantidadePedida());
        }
        this.lblValorTotal.setText(Float.toString(x));

        this.txtNumeroParcelas.setText("1");
        this.cmbFormaPagamento.getSelectionModel().selectFirst();

        this.btnMais_Parcelas.setDisable(true);
        this.btnMenos_Parcelas.setDisable(true);

        this.lblValorParcela.setText(this.lblValorTotal.getText());
        this.lblNumeroDocumento.setText(Long.toString((long) this.getId()));
        this.lblNomeFornecedor.setText(li.get(0).getNomeFornecedor());
        this.lblBanco.setText("Banco do Brasil"); //li.get(0).getProdutoVO().getFornecedorVO().getNomeBanco()
        this.lblBancoAgencia.setText("12345-6"); //li.get(0).getProdutoVO().getFornecedorVO().getNumeroAgencia()
        this.lblCodigoBarras.setText(UUID.randomUUID().toString());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, diasdepoisdehoje);
        this.lblDataVenc.setText(cal.getTime().toString());
        this.lblXdeY.setText((listaCompras.size() + 1) + " de " + matAux.size());
    }

    @FXML
    void btnFormadePagamento_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.btnFormadePagamento.fire();
        }
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
                    finalizarCompra();
                    caixa.close();
                    getPai(this.bdnPrincipal);
                }
                if (p == nao) {
                    caixa.close();
                }
            });
        }
    }

    void finalizarCompra() {

        ItemCompra itensFinalizados = new ItemCompra(DAOFactory.getDAOFactory().getItemCompraDAO());

        for (TabelaTelaCompraCarrinho ice : listaCarrinho) {
            itensFinalizados.save(ice.getItemCompra());
        }

        Compra compraFinalizada = new Compra(DAOFactory.getDAOFactory().getCompraDAO());

        for (CompraEntity c : listaCompras) {
            compraFinalizada.save(c);

        }

        GerarEmailCompra Emails = new GerarEmailCompra(listaCompras);
        int x = 0;
        for (CompraEntity c : listaCompras) {
            Alert caixa = new Alert(Alert.AlertType.INFORMATION);
            TextArea txt = new TextArea(Emails.getSaidaCompras(x));
            txt.setPrefSize(600, 600);
            txt.setEditable(false);
            txt.setFocusTraversable(false);
            ButtonType fechar = new ButtonType("Fechar");
            ButtonType proximo = new ButtonType("Próximo");
            caixa.setTitle("AlphaComesticos");
            caixa.getButtonTypes().setAll(fechar, proximo);
            caixa.setGraphic(txt);

            caixa.showAndWait().ifPresent(p -> {
                if (p == proximo) {
                    caixa.close();
                }
                if (p == fechar) {
                    caixa.close();
                    f = true;
                }
            });
            if (f == true) {
                break;
            }
            x++;
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
    private int diasdepoisdehoje = 30;

    void completarCompra() {

        TipoPagamentoEnum e = this.cmbFormaPagamento.getValue();
        PagamentoEntity paga = new PagamentoEntity();
        paga.setId((long) this.getId());
        paga.setSituPagamento(SituacaoPagamentoEnum.NORMAL);
        paga.setTipoPagamento(e);

        Set<ParcelaPagamentoEntity> listaParcelas = new HashSet<>();

        BoletoBancarioEntity boleto = new BoletoBancarioEntity();
        boleto.setBancoEmissorVO(ABanco.getBancos("Banco Bradesco S.A.")); //Arrumar
        boleto.setAgencia("5423-5");
        boleto.setCarteira("Registrada");

        Calendar cal = Calendar.getInstance();

        if (e == TipoPagamentoEnum.VISTA) {

            boleto.setId(Long.parseLong(this.lblNumeroDocumento.getText()));
            boleto.setCodigoBarra(this.lblCodigoBarras.getText());

            ParcelaPagamentoEntity parcela = new ParcelaPagamentoEntity();
            parcela.setId((long) this.getId());
            diasdepoisdehoje = 2;
            for (int i = 0; i < diasdepoisdehoje;) {
                cal.add(Calendar.DAY_OF_MONTH, 1);
                if (cal.get(Calendar.DAY_OF_WEEK) <= 5) {
                    i++;
                }
            }
            parcela.setDataVencimento(cal.getTime());
            parcela.setValorOriginal(Float.parseFloat(this.lblValorTotal.getText()));
            parcela.setValorTotalPago(0.00);
            parcela.setDocumentoPagamento(boleto);
            listaParcelas.add(parcela);
            paga.setListaParcelas(listaParcelas);
        } else {
            int numeroParcelas = Integer.parseInt(this.txtNumeroParcelas.getText());

            for (int x = 0; x < numeroParcelas; x++) {

                boleto.setId((long) this.getId());
                if (x == 0) {
                    boleto.setCodigoBarra(this.lblCodigoBarras.getText());
                } else {
                    boleto.setCodigoBarra(UUID.randomUUID().toString());
                }

                ParcelaPagamentoEntity parcela = new ParcelaPagamentoEntity();
                parcela.setId((long) this.getId());
                cal.add(Calendar.DATE, diasdepoisdehoje);
                parcela.setDataVencimento(cal.getTime());
                parcela.setValorOriginal(valorParcelas);
                parcela.setValorTotalPago(0.00);
                parcela.setDocumentoPagamento(boleto);

                listaParcelas.add(parcela);
            }

            paga.setListaParcelas(listaParcelas);

        }

        List<ItemCompraEntity> l = matAux.get(numeroFornecedor);
        this.listaCompras.add(new CompraEntity((long) this.getId(), new Date(), l.get(0).getProdutoVO().getFornecedor(), paga, SituacaoCompraEnum.LANCADA, new HashSet<ItemCompraEntity>(l)));
        this.progressBar.setProgress((double) (numeroFornecedor + 1) / matAux.size());
    }

    @FXML
    void btnConfirmar_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.btnConfirmar.fire();
        }
    }

    @FXML
    void btnCancelar_onAction(ActionEvent event) {
        getPai(this.bdnPrincipal);
    }

    @FXML
    void btnCancelar_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            getPai(this.bdnPrincipal);
        }
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
        if (this.tblProduto.getSelectionModel().getSelectedItem() == null) {
            this.lblMensagem.setText("Por Favor, selecione um produto e insira a quantidade desejada para adicionar ao carrinho.");
        } else {
            ProdutoEntity aux = this.tblProduto.getSelectionModel().getSelectedItem().getProduto();
            TabelaTelaCompraCarrinho aux2 = new TabelaTelaCompraCarrinho(new ItemCompraEntity((long) this.getId(), 1, aux));
            boolean pass = false;

            for (TabelaTelaCompraCarrinho ice : listaCarrinho) {
                if (ice.getItemCompra().getProdutoVO() == aux2.getItemCompra().getProdutoVO()) {
                    this.lblMensagem.setText("O Produto selecionado já se encontra no carrinho.");
                    pass = true;
                }
            }
            if (!pass) {
                listaCarrinho.add(aux2);
                this.lblMensagem.setText("Produto \"" + aux2.getItemCompra().getProdutoVO().getNome() + "\" adicionado ao carrinho.");
                atualizarTabela();
            }
        }
    }

    @FXML
    void txtProdutoFornecedor_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.objetoBuscar();
        }
    }

    @FXML
    void tblProduto_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.adicionaraocarrinho();
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
        if (event.getCode() == KeyCode.DELETE) {
            String nomeProduto = tblProdutoCarrinho.getSelectionModel().getSelectedItem().getNome();
            listaCarrinho.remove(tblProdutoCarrinho.getSelectionModel().getSelectedItem());
            atualizarTabela();
            lblMensagem.setText("Produto \"" + nomeProduto + "\" removido do carrinho.");
        }
        if ((event.getCode() == KeyCode.PLUS) || (event.getCode() == KeyCode.EQUALS)) {
            tblProdutoCarrinho.getSelectionModel().getSelectedItem().setQuantidade(tblProdutoCarrinho.getSelectionModel().getSelectedItem().getQuantidade() + 1);
            tblProdutoCarrinho.refresh();
        }
        if (event.getCode() == KeyCode.MINUS) {
            int y = tblProdutoCarrinho.getSelectionModel().getSelectedItem().getQuantidade();
            if (y > 1) {
                tblProdutoCarrinho.getSelectionModel().getSelectedItem().setQuantidade(tblProdutoCarrinho.getSelectionModel().getSelectedItem().getQuantidade() - 1);
                tblProdutoCarrinho.refresh();
            }
        }
    }

    private Produto produto = new Produto(DAOFactory.getDAOFactory().getProdutoDAO());
    private ItemCompra itemCompra = new ItemCompra(DAOFactory.getDAOFactory().getItemCompraDAO());
    private Categoria categoria = new Categoria(DAOFactory.getDAOFactory().getCategoriaDAO());
    private Fornecedor fornecedor = new Fornecedor(DAOFactory.getDAOFactory().getFornecedorDAO());
    private List<TabelaTelaCompraCarrinho> listaCarrinho = FXCollections.observableArrayList();
    int linhadobotao = 0;

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
        this.lblMensagem.setText("Por Favor, selecione um produto para adicionar ao carrinho.");

        bdnPrincipal.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (keyComb1.match(event)) {
                    btnCarinho.fire();
                }
                if (keyComb2.match(event)) {
                    boolean passou = false;
                    if (paneProduto1.isVisible()) {
                        btnLayout.fire();
                        passou = true;
                    }
                    if (paneProduto2.isVisible() && !passou) {
                        btnLayout2.fire();
                    }
                }
                if (keyComb3.match(event)) {
                    if (paneProduto1.isVisible()) {
                        txtProduto.requestFocus();
                    }
                    if (paneProduto2.isVisible()) {
                        txtProduto2.requestFocus();
                    }
                }
                if (keyComb4.match(event)) {
                    if (paneCarrinho.isVisible()) {
                        if(listaCarrinho.size() > 0)btnFormadePagamento.fire();
                    }
                }
            }
        }
        );
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

    private void atualizarTabela() {

        this.clmCarrinhoProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.clmCarrinhoProduto.setCellFactory(column -> {
            return new TableCell<TabelaTelaCompraCarrinho, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        final VBox vbox = new VBox(2);
                        ImageView imageview = new ImageView();
                        imageview.setFitHeight(50);
                        imageview.setFitWidth(50);
                        String imageUrl = "file:///C://NetBeans//AlphaCosmeticos//src//main//resources//imagem//imagem.jpg";
                        imageview.setImage(new Image(imageUrl));
                        Label label = new Label(item);

                        vbox.getChildren().add(imageview);
                        vbox.getChildren().add(label);
                        vbox.setAlignment(Pos.TOP_LEFT);
                        setGraphic(vbox);
                    } else {
                        setGraphic(null);
                    }
                }
            };
        });

        this.clmCarrinhoFornecedor.setCellValueFactory(new PropertyValueFactory<>("nomeFornecedor"));
        this.clmCarrinhoQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.clmCarrinhoValorUni.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        this.clmCarrinhoValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        linhadobotao = -3;
        this.clmCarrinhoQuantidade.setCellFactory((TableColumn<TabelaTelaCompraCarrinho, Integer> column) -> {
            return new TableCell<TabelaTelaCompraCarrinho, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {

                    super.updateItem(item, empty);
                    if (!empty) {
                        final HBox hbox = new HBox(5);
                        final VBox vbox = new VBox(5);
                        Label label = new Label(item.toString());
                        final Button btnMais = new Button("+");
                        btnMais.setMinSize(25, 25);
                        btnMais.setFocusTraversable(false);
                        final TableCell<TabelaTelaCompraCarrinho, Integer> c = this;
                        btnMais.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                //TabelaTelaCompraCarrinho tbl2 = (TabelaTelaCompraCarrinho) ((ParameterizedType)c.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                                //tblProdutoCarrinho.getSelectionModel().setSelectedItem(tbl2);
                                TabelaTelaCompraCarrinho row = tblProdutoCarrinho.getItems().get(getIndex());
                                tblProdutoCarrinho.getSelectionModel().select(row);
                                tblProdutoCarrinho.getSelectionModel().getSelectedItem().setQuantidade(tblProdutoCarrinho.getSelectionModel().getSelectedItem().getQuantidade() + 1);
                                tblProdutoCarrinho.refresh();
                            }
                        });
                        final Button btnMenos = new Button("-");
                        btnMenos.setMinSize(25, 25);
                        btnMenos.setFocusTraversable(false);
                        final TableCell<TabelaTelaCompraCarrinho, Integer> d = this;
                        btnMenos.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                if (getItem() > 1) {
                                    TabelaTelaCompraCarrinho row = tblProdutoCarrinho.getItems().get(getIndex());
                                    tblProdutoCarrinho.getSelectionModel().select(row);
                                    tblProdutoCarrinho.getSelectionModel().getSelectedItem().setQuantidade(tblProdutoCarrinho.getSelectionModel().getSelectedItem().getQuantidade() - 1);
                                    tblProdutoCarrinho.refresh();
                                }
                            }
                        });
                        final Button btnRemover = new Button("Remover");
                        btnRemover.setFont(new Font(8));
                        final TableCell<TabelaTelaCompraCarrinho, Integer> e = this;
                        btnRemover.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                TabelaTelaCompraCarrinho row = tblProdutoCarrinho.getItems().get(getIndex());
                                tblProdutoCarrinho.getSelectionModel().select(row);
                                String nomeProduto = tblProdutoCarrinho.getSelectionModel().getSelectedItem().getNome();
                                listaCarrinho.remove(tblProdutoCarrinho.getSelectionModel().getSelectedItem());
                                atualizarTabela();
                                lblMensagem.setText("Produto \"" + nomeProduto + "\" removido do carrinho.");
                            }
                        });
                        btnRemover.setFocusTraversable(false);
                        vbox.getChildren().add(hbox);
                        vbox.getChildren().add(btnRemover);
                        hbox.getChildren().add(btnMais);
                        hbox.getChildren().add(label);
                        hbox.getChildren().add(btnMenos);
                        hbox.setAlignment(Pos.CENTER);
                        vbox.setAlignment(Pos.CENTER);
                        setGraphic(vbox);
                        linhadobotao++;
                    } else {
                        setGraphic(null);
                    }

                }
            };
        });

        this.tblProdutoCarrinho.setItems(FXCollections.observableArrayList(listaCarrinho));
        controlarBtnFormaPagto();
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

    /*
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
     */
    @FXML
    void btnLayout_onAction(ActionEvent event) {
        this.paneProduto1.setVisible(false);
        this.paneProduto2.setVisible(true);
    }

    @FXML
    void btnLayout_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.btnLayout.fire();
        }
    }

    @FXML
    void btnPesquisar2_onAction(ActionEvent event) {

    }

    @FXML
    void btnPesquisar2_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void treeCategoria_onEditCancel(ActionEvent event) {

    }

    @FXML
    void treeCategoria_onEditCommit(ActionEvent event) {

    }

    @FXML
    void treeCategoria_onEditStart(ActionEvent event) {

    }

    @FXML
    void treeCategoria_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnLayout2_onAction(ActionEvent event) {
        this.paneProduto2.setVisible(false);
        this.paneProduto1.setVisible(true);
    }

    @FXML
    void btnLayout2_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.btnLayout2.fire();
        }
    }

    int panePassado = 0;
    boolean passou_carrinho = false;

    @FXML
    void btnCarinho_onAction(ActionEvent event) {
        if (passou_carrinho) {
            this.paneCarrinho.setVisible(false);
            if (panePassado == 1) {
                this.paneProduto1.setVisible(true);
            }
            if (panePassado == 2) {
                this.paneProduto2.setVisible(true);
            }
            passou_carrinho = false;
        } else {
            if (this.paneProduto1.isVisible()) {
                panePassado = 1;
                this.paneProduto1.setVisible(false);
            }
            if (this.paneProduto2.isVisible()) {
                panePassado = 2;
                this.paneProduto2.setVisible(false);
            }
            this.paneCarrinho.setVisible(true);
            controlarBtnFormaPagto();
            lblMensagem.setText(listaCarrinho.size() + " produto(s) no carrinho.");
            passou_carrinho = true;
        }
    }

    void controlarBtnFormaPagto() {
        if (listaCarrinho.size() < 1) {
            this.btnFormadePagamento.setVisible(false);
        } else {
            this.btnFormadePagamento.setVisible(true);
        }
    }

    @FXML
    void btnCarinho_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.btnCarinho.fire();
        }
    }

}
