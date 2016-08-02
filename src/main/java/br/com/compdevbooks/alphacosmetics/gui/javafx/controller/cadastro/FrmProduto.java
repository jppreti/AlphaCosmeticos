
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.cadastro;

import br.com.compdevbooks.alphacosmetics.business.Categoria;
import br.com.compdevbooks.alphacosmetics.business.Fornecedor;
import br.com.compdevbooks.alphacosmetics.business.cadastro.Produto;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.exception.ProdutoException;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ArvoreCategoria;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaProdutos;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FrmProduto implements Initializable{
    
//No formato da hierarquia do Scene Builder (Formatar Alt+Shift+F)
    @FXML private BorderPane bdpPrincipal;
        //Superior
        @FXML private FlowPane flpSuperiorPrincipal;
            @FXML private Label lblProduto;
            @FXML private TextField txtProduto;
            @FXML private Button btnProcurar;
        //Esquerda
        @FXML private FlowPane flpEsquerdaPrincipal;
            @FXML private Label lblCategoria;
            @FXML private TreeView treeCategoria;
            @FXML private Button btnGerenciar;
        //Centro
        @FXML private TabPane tbpCentroPrincipal;
            @FXML private Tab tabProduto;
                @FXML private BorderPane bdpProduto;
                    //Centro
                    @FXML private TableView<TabelaTelaProdutos> tblCentroProduto;
                        @FXML private TableColumn<TabelaTelaProdutos, String> tblColunaNomeProduto;
                        @FXML private TableColumn<TabelaTelaProdutos, String> tblColunaDescricaoProduto;
                        @FXML private TableColumn<TabelaTelaProdutos, String> tblColunaMarcaProduto;
                        @FXML private TableColumn<TabelaTelaProdutos, Integer> tblColunaQuantidadeProduto;
                        @FXML private TableColumn<TabelaTelaProdutos, Float> tblColunaValorProduto;
                    //Inferior
                    @FXML private FlowPane flpInferiorProduto;
                        @FXML private Button btnNovoProduto;
                        @FXML private Button btnAlterarProduto;
                        @FXML private Button btnExcluirProduto;
            @FXML private Tab tabRegistro;
                @FXML private BorderPane bdpRegistro;
                    //Esquerda
                    @FXML private FlowPane flpEsquerdaRegistro;
                        @FXML private GridPane grdDadosRegistro;
                            @FXML private Label lblDadosRegistro;
                            @FXML private Label lblCodigoRegistro;
                            @FXML private Label lblNomeRegistro;
                            @FXML private Label lblDescricaoRegistro;
                            @FXML private Label lblMarcaRegistro;
                            @FXML private TextField txtCodigoRegistro;
                            @FXML private TextField txtNomeRegistro;
                            @FXML private TextField txtDescricaoRegistro;
                            @FXML private TextField txtMarcaRegistro;
                        @FXML private GridPane grdCustoRegistro;
                            @FXML private Label lblCustoRegistro;
                            @FXML private Label lblValorVendaRegistro;
                            @FXML private Label lblValorCompraRegistro;
                            @FXML private TextField txtValorVendaRegistro;
                            @FXML private TextField txtValorCompraRegistro;
                    //Centro
                    @FXML private FlowPane flpCentroRegistro;
                        @FXML private GridPane grdPercentualRegistro;
                            @FXML private Label lblPercentualRegistro;
                            @FXML private Label lblMargemLucroRegistro;
                            @FXML private Label lblPromocaoRegistro;
                            @FXML private Label lblComissaoRegistro;
                            @FXML private TextField txtMargemLucroRegistro;
                            @FXML private TextField txtPromocaoRegistro;
                            @FXML private TextField txtComissaoRegistro;
                        @FXML private GridPane grdEstoqueRegistro;
                            @FXML private Label lblEstoqueRegistro;
                            @FXML private Label lblQuantidadeAtualRegistro;
                            @FXML private Label lblQuantidadeMinimaRegistro;
                            @FXML private Label lblQuantidadeMaximaRegistro;
                            @FXML private TextField txtQuantidadeAtualRegistro;
                            @FXML private TextField txtQuantidadeMinimaRegistro;
                            @FXML private TextField txtQuantidadeMaximaRegistro;
                    //Direita
                    @FXML private FlowPane flpDireitaRegistro;
                        @FXML private VBox vbxProdutoRegistro;
                            @FXML private ImageView imgProdutoRegistro;
                        @FXML private HBox hbxProdutoRegistro;
                            @FXML private TextField txtLocalProdutoRegistro;
                            @FXML private Button btnAddProdutoRegistro;
                        @FXML private Label lblFornecedorRegistro;
                        @FXML private ComboBox <String> cmbFornecedorRegistro;
//                        @FXML private TableView tblFornecedorRegistro;
//                            @FXML private TableColumn tblColunaSelecaoRegistro;
//                            @FXML private TableColumn tblColunaFornecedorRegistro;
                    //Inferior
                    @FXML private FlowPane flpInferiorRegistro;
                        @FXML private Button btnSalvarRegistro;
                        @FXML private Button btnVoltarRegistro;
            @FXML private Tab tabEdicao;
                @FXML private BorderPane bdpEdicao;
                    //Esquerda
                    @FXML private FlowPane flpEsquerdaEdicao;
                        @FXML private GridPane grdDadosEdicao;
                            @FXML private Label lblDadosEdicao;
                            @FXML private Label lblCodigoEdicao;
                            @FXML private Label lblNomeEdicao;
                            @FXML private Label lblDescricaoEdicao;
                            @FXML private Label lblMarcaEdicao;
                            @FXML private TextField txtCodigoEdicao;
                            @FXML private TextField txtNomeEdicao;
                            @FXML private TextField txtDescricaoEdicao;
                            @FXML private TextField txtMarcaEdicao;
                        @FXML private GridPane grdCustoEdicao;
                            @FXML private Label lblCustoEdicao;
                            @FXML private Label lblValorVendaEdicao;
                            @FXML private Label lblValorCompraEdicao;
                            @FXML private TextField txtValorVendaEdicao;
                            @FXML private TextField txtValorCompraEdicao;
                        @FXML private GridPane grdCategoriaEdicao;
                            @FXML private Label lblCategoriaEdicao;
                            @FXML private Label lblSelecionadaEdicao;
                            @FXML private TextField txtSelecionadaEdicao;
                    //Centro
                    @FXML private FlowPane flpCentroEdicao;
                        @FXML private GridPane grdPercentualEdicao;
                            @FXML private Label lblPercentualEdicao;
                            @FXML private Label lblMargemLucroEdicao;
                            @FXML private Label lblPromocaoEdicao;
                            @FXML private Label lblComissaoEdicao;
                            @FXML private TextField txtMargemLucroEdicao;
                            @FXML private TextField txtPromocaoEdicao;
                            @FXML private TextField txtComissaoEdicao;
                        @FXML private GridPane grdEstoqueEdicao;
                            @FXML private Label lblEstoqueEdicao;
                            @FXML private Label lblQuantidadeAtualEdicao;
                            @FXML private Label lblQuantidadeMinimaEdicao;
                            @FXML private Label lblQuantidadeMaximaEdicao;
                            @FXML private TextField txtQuantidadeAtualEdicao;
                            @FXML private TextField txtQuantidadeMinimaEdicao;
                            @FXML private TextField txtQuantidadeMaximaEdicao;
                    //Direita
                    @FXML private FlowPane flpDireitaEdicao;
                        @FXML private VBox vbxProdutoEdicao;
                            @FXML private ImageView imgProdutoEdicao;
                        @FXML private HBox hbxProdutoEdicao;
                            @FXML private TextField txtLocalProdutoEdicao;
                            @FXML private Button btnAddProdutoEdicao;
                        @FXML private Label lblFornecedorEdicao;
                        @FXML private ComboBox <String> cmbFornecedorEdicao;
//                        @FXML private TableView tblFornecedorEdicao;
//                            @FXML private TableColumn tblColunaSelecaoEdicao;
//                            @FXML private TableColumn tblColunaFornecedorEdicao;
                    //Inferior
                    @FXML private FlowPane flpInferiorEdicao;
                        @FXML private Button btnSalvarEdicao;
                        @FXML private Button btnVoltarEdicao;
            @FXML private Tab tabArvore;
                @FXML private VBox vbArvore;
                    @FXML private Label lblAviso;
                    @FXML private HBox hbArvore;
                        @FXML private Label lblItem;
                        @FXML private TextField txtItem;
                        @FXML private VBox vbBotoes;
                            @FXML private Button btnAdicionarCategoria;
                            @FXML private Button btnRemoverCategoria;
                    @FXML private Label lblInformacoes;
                    @FXML private TextArea txtareaInformacoes;
                    @FXML private Button btnVoltarArvore;
//Fim BorderPane Principal
    
    private String categoriaSelecionada;
    private String pai;
    private String avo;
    
    private Categoria categoria = new Categoria(DAOFactory.getDAOFactory().getCategoriaDAO());
    private Produto produto = new Produto(DAOFactory.getDAOFactory().getProdutoDAO());
    public Fornecedor fornecedor = new Fornecedor(DAOFactory.getDAOFactory().getFornecedorDAO());
    
    private ArvoreCategoria arvore;
    private TreeItem root = new TreeItem("Categoria");
    
    private boolean novo = true;
    
    public FrmProduto() {
    }
    
//Eventos                      
    //Botao Procurar -> Principal -> Superior
    @FXML
    void btnProcurar_onAction (ActionEvent evento) {
        ProdutoEntity produ = new ProdutoEntity();
        FornecedorEntity fornecedor = new FornecedorEntity();
        produ.setFornecedor(fornecedor);
        TabelaTelaProdutos aux;
        produ.setNome(txtProduto.getText());
        produ.setCategoria(null);                
        produ.getFornecedor().setFantasia("");
                
        List<ProdutoEntity> listaP = null;
        listaP = produto.buscarProdutos(produ);
              
        List<TabelaTelaProdutos> listaProdutos = new ArrayList<>();
                
        for(ProdutoEntity vo : listaP){
            aux = new TabelaTelaProdutos(vo);
            listaProdutos.add(aux);
        }
        this.completarProdutos(listaProdutos); 
	txtProduto.requestFocus();
    }
    //Texto Produto -> Principal -> Superior
        //Se possivel fazer a filtragem conforme o digitar do nome
    
    //Arvore Categoria -> Principal -> Esquerda (Verificar como fica!!!)           
        //Seleciona item da arvore e captura
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
                TabelaTelaProdutos aux;
                produ.setNome("");
                
                
                btnNovoProduto.setDisable(false);        
                
                produ.setCategoria(categoria.getByNome(categoriaSelecionada));                
                produ.getFornecedor().setFantasia("");
                
                List<ProdutoEntity> listaP = null;
                listaP = produto.buscarProdutos(produ);
                
                List<TabelaTelaProdutos> listaProdutos = new ArrayList<>();
                
                for(ProdutoEntity vo : listaP){
                    aux = new TabelaTelaProdutos(vo);
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
                    TabelaTelaProdutos aux;
                    produ.setNome("");
                
                
                    btnNovoProduto.setDisable(false);        
                
                    produ.setCategoria(categoria.getByNome(categoriaSelecionada));                
                    produ.getFornecedor().setFantasia("");
                
                    List<ProdutoEntity> listaP = null;
                    listaP = produto.buscarProdutos(produ);
                
                    List<TabelaTelaProdutos> listaProdutos = new ArrayList<>();
                
                    for(ProdutoEntity vo : listaP){
                        aux = new TabelaTelaProdutos(vo);
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
                    TabelaTelaProdutos aux;
                    produ.setNome("");
                
                
                    btnNovoProduto.setDisable(false);        
                
                    produ.setCategoria(categoria.getByNome(categoriaSelecionada));                
                    produ.getFornecedor().setFantasia("");
                
                    List<ProdutoEntity> listaP = null;
                    listaP = produto.buscarProdutos(produ);
                
                    List<TabelaTelaProdutos> listaProdutos = new ArrayList<>();
                
                    for(ProdutoEntity vo : listaP){
                        aux = new TabelaTelaProdutos(vo);
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
    
    @FXML
    void treeCategoria_onEditStart() {
    
    }
    
    @FXML
    void treeCategoria_onEditCommit() {
    
    }
    @FXML
    void treeCategoria_onEditCancel() {
    
    }
    
    //Botao Gerenciar -> Principal -> Esquerda
    @FXML
    void btnGerenciar_onAction(ActionEvent evento){
        tbpCentroPrincipal.getSelectionModel().select(tabArvore);
        tabArvore.setDisable(false);
        tabProduto.setDisable(true);
        modificarArvore();
    }
    
    //Tabela Produto -> Centro (Verificar como fica!!!)
    
    //Botao Novo -> Produto -> Inferior
    @FXML
    void btnNovoProduto_onAction (ActionEvent evento) {
        tabRegistro.setDisable(false);
        tbpCentroPrincipal.getSelectionModel().select(tabRegistro);
        tabProduto.setDisable(true);
//            habilitarEdicao(true);
//            tbpCliente.getSelectionModel().select(tabEdicao);
//            limparFormulario();
//            novo = true;
    }
    //Botao Alterar -> Produto -> Inferior
    @FXML
    void btnAlterarProduto_onAction (ActionEvent evento) {
        if(tblCentroProduto.getSelectionModel().getSelectedIndex() >= 0){
            tbpCentroPrincipal.getSelectionModel().select(tabEdicao);
            tabEdicao.setDisable(false);
            tabProduto.setDisable(true);
            btnExcluirProduto.setDisable(true);
        }
    }
    //Botao Excluir -> Produto -> Inferior
    @FXML
    void btnExcluirProduto_onAction (ActionEvent evento) {
        
        if (tblCentroProduto.getSelectionModel().getSelectedIndex() >= 0) {
            TabelaTelaProdutos ent = tblCentroProduto.getSelectionModel().getSelectedItem();
//            produto.delete(ent);
            System.out.println("Excluido com sucesso");
        }
    }
    
    //Botao Add -> Registro -> Direita
    @FXML
    void btnAddProdutoRegistro_onAction (ActionEvent evento) {
    
    }
    //Tabela Fornecedor -> Registro -> Direita (Verificar como fica!!!)
        //Tem os CheckBox para cada fornecedor, para liga-los ao produto
    //Botao Salvar -> Registro -> Inferior
    @FXML
    void btnSalvarRegistro_onAction (ActionEvent evento) {
        ProdutoEntity pro = new ProdutoEntity();
        //Dados
        //pro.setId(Long.parseLong(txtCodigoRegistro.getText()));
        pro.setNome(txtNomeRegistro.getText());
        pro.setDescricao(txtDescricaoRegistro.getText());
        pro.setMarca(txtMarcaRegistro.getText());
        //Percentual
        pro.setMargemLucro(Float.parseFloat(txtMargemLucroRegistro.getText()));
        pro.setPercPromocao(Float.parseFloat(txtPromocaoRegistro.getText()));
        pro.setPercComissao(Float.parseFloat(txtComissaoRegistro.getText()));
        //Custo
        pro.setValorVenda(Float.parseFloat(txtValorVendaRegistro.getText()));
        pro.setValorCompra(Float.parseFloat(txtValorCompraRegistro.getText()));
        //Estoque
        pro.setQuantidade(Long.parseLong(txtQuantidadeAtualRegistro.getText()));
        pro.setQtdMin(Long.parseLong(txtQuantidadeMinimaRegistro.getText()));
        pro.setQtdMax(Long.parseLong(txtQuantidadeMaximaRegistro.getText()));
        //Categoria
        pro.setCategoria(categoria.getByNome(categoriaSelecionada));
        //Fornecedor

        pro.setFornecedor(fornecedor.getByNome(cmbFornecedorRegistro.getValue()));
        ProdutoException exc = produto.save(pro);
        if (exc == null) {
            System.out.println("Cliente salvo com sucesso.");
        }

        //Habilitar
        tbpCentroPrincipal.getSelectionModel().select(tabProduto);
        tabRegistro.setDisable(true);
        tabProduto.setDisable(false);
    }
    //Botao Voltar -> Registro -> Inferior
    @FXML
    void btnVoltarRegistro_onAction (ActionEvent evento) {
        tbpCentroPrincipal.getSelectionModel().select(tabProduto);
        tabProduto.setDisable(false);
        tabRegistro.setDisable(true);
    }
    
    //Texto Categoria Seleciona -> Edicao -> Esquerda
        //Atraves da selecao da arvore, deve ser atualizada a categoria no TextField
    //Botao Add -> Edicao -> Direita
    @FXML
    void btnAddProdutoEdicao_onAction (ActionEvent evento) {
    
    }
    //Tabela Fornecedor -> Edicao -> Direita (Verifar com fica!!!)
        //Deve mostrar os CheckBox selecionado com todos os fornecedores deste produto
    //Botao Salvar -> Edicao -> Inferior
    @FXML
    void btnSalvarEdicao_onAction (ActionEvent evento) {
        ProdutoEntity pro = null;
        //Dados
        pro.setId(Long.parseLong(txtCodigoEdicao.getText()));
        pro.setNome(txtNomeEdicao.getText());
        pro.setDescricao(txtDescricaoEdicao.getText());
        pro.setMarca(txtMarcaEdicao.getText());
        //Percentual
        pro.setMargemLucro(Float.parseFloat(txtMargemLucroEdicao.getText()));
        pro.setPercPromocao(Float.parseFloat(txtPromocaoEdicao.getText()));
        pro.setPercComissao(Float.parseFloat(txtComissaoEdicao.getText()));
        //Custo
        pro.setValorVenda(Float.parseFloat(txtValorVendaEdicao.getText()));
        pro.setValorCompra(Float.parseFloat(txtValorCompraEdicao.getText()));
        //Estoque
        pro.setQuantidade(Long.parseLong(txtQuantidadeAtualEdicao.getText()));
        pro.setQtdMin(Long.parseLong(txtQuantidadeMinimaEdicao.getText()));
        pro.setQtdMax(Long.parseLong(txtQuantidadeMaximaEdicao.getText()));
        //Categoria
        pro.setCategoria(categoria.getByNome(txtSelecionadaEdicao.getText()));
        //Fornecedor

        pro.setFornecedor(fornecedor.getByNome(cmbFornecedorEdicao.getValue()));
        ProdutoException exc = produto.save(pro);
        if (exc == null) {
            System.out.println("Cliente Alterado com sucesso.");
        }

        //Habilitar
        tbpCentroPrincipal.getSelectionModel().select(tabProduto);
        tabEdicao.setDisable(true);
        tabProduto.setDisable(false);
    }
    //Botao Voltar -> Edicao -> Inferior
    @FXML
    void btnVoltarEdicao_onAction (ActionEvent evento) {
        tbpCentroPrincipal.getSelectionModel().select(tabProduto);
        tabEdicao.setDisable(true);
        tabProduto.setDisable(false);
        btnAlterarProduto.setDisable(true);
        txtProduto.requestFocus();
    }
    
    //Arvore  
    //Botao Adicionar -> Arvore -> VBox -> HBox -> VBox
    @FXML
    void btnAdicionarCategoria_onAction(ActionEvent evento) {
        btnAdicionarCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addItem(txtItem.getText());
            }
        });
    }
    //Botao Remover -> Arvore -> VBox -> HBox -> VBox
    @FXML
    void btnRemoverCategoria_onAction(ActionEvent evento) {
        btnRemoverCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                removeItem();
            }
        });
    }
    
    //Botao Voltar -> Arvore -> VBox
    @FXML
    void btnVoltarArvore_onAction(ActionEvent evento) {
        tbpCentroPrincipal.getSelectionModel().select(tabProduto);
        this.treeCategoria.setEditable(false);
        tabProduto.setDisable(false);
        tabArvore.setDisable(true);
        this.treeCategoria.getSelectionModel().selectFirst();
    }    
//Fim Evento

//Outros Metodos
    /**
     * Metodos Abstratos (conf)
     */
    public void modificarArvore(){
       
        //Funcoes uteis em TreeView para configura-la
        this.treeCategoria.setEditable(true);
        this.treeCategoria.setCellFactory(TextFieldTreeCell.forTreeView());
        this.treeCategoria.getSelectionModel().selectFirst();
        
        
        this.treeCategoria.setOnEditStart(new EventHandler<TreeView.EditEvent>() {
        @Override
            public void handle(TreeView.EditEvent event) {
                editStart(event);
            }
        });
        
        
        this.treeCategoria.setOnEditCommit(new EventHandler<TreeView.EditEvent>() {
            @Override
            public void handle(TreeView.EditEvent event) {
                editCommit(event);
            }
        });
        
        
        this.treeCategoria.setOnEditCancel(new EventHandler<TreeView.EditEvent>()
        {
            @Override
            public void handle(TreeView.EditEvent event) {
                editCancel(event);
            }
        });
        
        
	this.root.addEventHandler(TreeItem.branchExpandedEvent(),new EventHandler<TreeItem.TreeModificationEvent>()
	{
            @Override
            public void handle(TreeItem.TreeModificationEvent event) {
                branchExpended(event);
            }
        });
        
        
        this.root.addEventHandler(TreeItem.branchCollapsedEvent(),new EventHandler<TreeItem.TreeModificationEvent>()
        {
            @Override
            public void handle(TreeItem.TreeModificationEvent event) {
                branchCollapsed(event);
            }
	});

        
	this.root.addEventHandler(TreeItem.childrenModificationEvent(),new EventHandler<TreeItem.TreeModificationEvent>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent event) {
                childrenModification(event);
            }
        });

        //Define o numero de texto nas linhas e colunas para a area de texto
        txtareaInformacoes.setPrefRowCount(15);
        txtareaInformacoes.setPrefColumnCount(25);

        //Atualizar a TreeView da classe arvore
        arvore.setTreeCategoria(this.treeCategoria);
    }    
    
    private void addItem(String value) {
        
        if (value == null || value.trim().equals("")) {
            writeMessage("A nova categoria não pode ser vazio.");
            return;
        }

        TreeItem parent =  (TreeItem) treeCategoria.getSelectionModel().getSelectedItem();

        if (parent == null) {
            writeMessage("Selecione um categoria para adicionar sua nova subcategoria.");
            return;
        }

        for (Iterator it = parent.getChildren().iterator(); it.hasNext();) {
            TreeItem child = (TreeItem) it.next();
            if (child.getValue().equals(value)) {
                writeMessage("A categoria "+ value + " já existe em baixo (" + parent.getValue() + ")");
                return;
            }
        }

        TreeItem newItem = new TreeItem(value);
        parent.getChildren().add(newItem);

        if (!parent.isExpanded()) {
            parent.setExpanded(true);
        }
    }

    private void removeItem() {
        
        TreeItem item = (TreeItem) treeCategoria.getSelectionModel().getSelectedItem();

        if (item == null) {
            writeMessage("Selecione um nó para remover.");
            return;
        }

        TreeItem parent = item.getParent();
        if (parent == null || treeCategoria.getTreeItemLevel(item) != 3) {
            writeMessage("Não é possivel remover uma supercategoria");
        } else {
            parent.getChildren().remove(item);
        }
    }
    
    
    public void branchExpended(TreeItem.TreeModificationEvent event) {
        String nodeValue = event.getSource().getValue().toString();
        writeMessage("A categoria " + nodeValue + " foi expandida.");
    }

    public void branchCollapsed(TreeItem.TreeModificationEvent event) {
        String nodeValue = event.getSource().getValue().toString();
        writeMessage("A categoria " + nodeValue + " foi compactada.");
    }

    public void childrenModification(TreeItem.TreeModificationEvent event) {
        if (event.wasAdded()) {
            
            for (Iterator it = event.getAddedChildren().iterator(); it.hasNext();) {
                TreeItem item = (TreeItem) it.next();
                writeMessage("A nova categoria (" + item.getValue() + "), foi adicionada.");
            }
        }

        if (event.wasRemoved()) {
            
            for (Iterator it = event.getRemovedChildren().iterator(); it.hasNext();) {
                TreeItem item = (TreeItem) it.next();
                writeMessage("A categoria (" + item.getValue() + "), foi removido.");
            }
        }
    }

    public void editStart(TreeView.EditEvent event) {
        writeMessage("Edição iniciada: " + event.getTreeItem());
    }

    public void editCommit(TreeView.EditEvent event) {
        writeMessage(event.getTreeItem() + " mudou:"
                + " (antigo = " + event.getOldValue()
                + ", novo = " + event.getNewValue() + ")");
    }

    public void editCancel(TreeView.EditEvent e) {
        writeMessage("Edição finalizada: " + e.getTreeItem());
    }    
    
    
    public void writeMessage(String msg) {
        this.txtareaInformacoes.appendText(msg + "\n");
    }	
    
    private void completarProdutos(List<TabelaTelaProdutos> lista){
        this.tblColunaNomeProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.tblColunaDescricaoProduto.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        this.tblColunaMarcaProduto.setCellValueFactory(new PropertyValueFactory<>("marca"));
        this.tblColunaQuantidadeProduto.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.tblColunaValorProduto.setCellValueFactory(new PropertyValueFactory<>("valorVenda"));
        
        this.tblCentroProduto.setItems(FXCollections.observableArrayList(lista));
    }
    
    
    @FXML
	void tblCentroProduto_mouseClicked(MouseEvent event) {
		TabelaTelaProdutos ent = tblCentroProduto.getSelectionModel().getSelectedItem();
		if (ent != null) {
                        //Dados
                        txtCodigoEdicao.setText(ent.getId().toString());
			txtNomeEdicao.setText(ent.getNome());
			txtDescricaoEdicao.setText(ent.getDescricao());
			txtMarcaEdicao.setText(ent.getMarca());
                        //Percentual
                        txtMargemLucroEdicao.setText(String.valueOf(ent.getMargemLucro()));
                        txtPromocaoEdicao.setText(String.valueOf(ent.getPercPromocao()));
                        txtComissaoEdicao.setText(String.valueOf(ent.getPercComissao()));
                        //Custo
                        txtValorVendaEdicao.setText(String.valueOf(ent.getValorVenda()));
                        txtValorCompraEdicao.setText(String.valueOf(ent.getValorCompra()));
                        //Estoque
                        txtQuantidadeAtualEdicao.setText(String.valueOf(ent.getQuantidade()));
                        txtQuantidadeMinimaEdicao.setText(String.valueOf(ent.getQtdMin()));
                        txtQuantidadeMaximaEdicao.setText(String.valueOf(ent.getQtdMax()));                        
                        //Categoria
                        txtSelecionadaEdicao.setText(ent.getNomeCategoria().toString());
                        //Fornecedor
                        cmbFornecedorEdicao.setValue(ent.getFornecedor());
                        
                        //Habilitar botão alterar e excluir
                        btnAlterarProduto.setDisable(false);
                        btnExcluirProduto.setDisable(false);
                        
		}
		if (event.getClickCount() > 2){
			tbpCentroPrincipal.getSelectionModel().select(tabEdicao);
                        tabEdicao.setDisable(false);
                        tabProduto.setDisable(true);
                        btnExcluirProduto.setDisable(true);
                }
	}

    /**
     * Metodos Abstratos (conf)
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        ArvoreCategoria arvore = new ArvoreCategoria(treeCategoria);
        arvore = new ArvoreCategoria(this.treeCategoria, this.root);
        Fornecedor fornecedor1 = new Fornecedor(DAOFactory.getDAOFactory().getFornecedorDAO());
        
        
        //Funcao para completar a tabela com todos os produtos
        ProdutoEntity produ = new ProdutoEntity();
        FornecedorEntity fornecedor = new FornecedorEntity();
        produ.setFornecedor(fornecedor);
        TabelaTelaProdutos aux;
        produ.setNome("");
        produ.setCategoria(null);                
        produ.getFornecedor().setFantasia("");
                
        List<ProdutoEntity> listaP = null;
        listaP = produto.buscarProdutos(produ);
              
        List<TabelaTelaProdutos> listaProdutos = new ArrayList<>();
                
        for(ProdutoEntity vo : listaP){
            aux = new TabelaTelaProdutos(vo);
            listaProdutos.add(aux);
        }
        this.completarProdutos(listaProdutos);  
    
        ObservableList<String> ob = FXCollections.observableArrayList();
        for(FornecedorEntity fo:fornecedor1.buscarTodosFornecedores()) {
            ob.add(fo.getFantasia());            
        }
        this.cmbFornecedorRegistro.setItems(ob);
        this.cmbFornecedorEdicao.setItems(ob);
    }

}
