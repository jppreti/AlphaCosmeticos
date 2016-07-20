
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.cadastro;

import br.com.compdevbooks.alphacosmetics.entity.produto.ArvoreCategoria;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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
            @FXML private TreeView<String> treeCategoria;
            @FXML private Button btnGerenciar;
        //Centro
        @FXML private TabPane tbpCentroPrincipal;
            @FXML private Tab tabProduto;
                @FXML private BorderPane bdpProduto;
                    //Centro
                    @FXML private TableView tblCentroProduto;
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
                        @FXML private TableView tblFornecedorRegistro;
                            @FXML private TableColumn tblColunaSelecaoRegistro;
                            @FXML private TableColumn tblColunaFornecedorRegistro;
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
                        @FXML private TableView tblFornecedorEdicao;
                            @FXML private TableColumn tblColunaSelecaoEdicao;
                            @FXML private TableColumn tblColunaFornecedorEdicao;
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
    private ArvoreCategoria arvore;
    private TreeItem root = new TreeItem();
    
    public FrmProduto() {
    }
    
//Eventos                      
    //Botao Procurar -> Principal -> Superior
    @FXML
    void btnProcurar_onAction (ActionEvent evento) {
    
    }
    //Texto Produto -> Principal -> Superior
        //Se possivel fazer a filtragem conforme o digitar do nome
    
    //Arvore Categoria -> Principal -> Esquerda (Verificar como fica!!!)           
        //Seleciona item da arvore e captura
    @FXML
    public void treeCategoria_onMouseClicked(MouseEvent mouseEvent) {
        //Para ativar o evento do mouse necessita dar 2 clicks
        if(mouseEvent.getClickCount() == 2){
            TreeItem<String> item = treeCategoria.getSelectionModel().getSelectedItem();
            categoriaSelecionada = item.getValue();
            System.out.println(categoriaSelecionada);
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
        modificarArvore();
    }
    
    //Tabela Produto -> Centro (Verificar como fica!!!)
    
    //Botao Novo -> Produto -> Inferior
    @FXML
    void btnNovoProduto_onAction (ActionEvent evento) {
    
    }
    //Botao Alterar -> Produto -> Inferior
    @FXML
    void btnAlterarProduto_onAction (ActionEvent evento) {
    
    }
    //Botao Excluir -> Produto -> Inferior
    @FXML
    void btnExcluirProduto_onAction (ActionEvent evento) {
    
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
    
    }
    //Botao Voltar -> Registro -> Inferior
    @FXML
    void btnVoltarRegistro_onAction (ActionEvent evento) {
    
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
    
    }
    //Botao Voltar -> Edicao -> Inferior
    @FXML
    void btnVoltarEdicao_onAction (ActionEvent evento) {
    
    }
    
    //Arvore
    //Botao Adicionar -> Arvore -> VBox -> HBox -> VBox
    public void eventoBotaoAdicionarCategoria(){
        btnAdicionarCategoria = new Button();
        btnAdicionarCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addItem(txtItem.getText());
            }
        });
    }
    
    //Botao Remover -> Arvore -> VBox -> HBox -> VBox
    public void eventoBotaoRemoverCategoria(){
        btnRemoverCategoria = new Button();
        btnRemoverCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                removeItem();
            }
        });
    }
    
    @FXML
    void btnAdicionarCategoria_onAction(ActionEvent evento) {
    
    }
    
    @FXML
    void btnRemoverCategoria_onAction(ActionEvent evento) {
    
    }
    
    //Botao Voltar -> Arvore -> VBox
    @FXML
    void btnVoltarArvore_onAction(ActionEvent evento) {
        tbpCentroPrincipal.getSelectionModel().select(tabProduto);
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
        
        // Set editing related event handlers (OnEditStart)
        this.treeCategoria.setOnEditStart(new EventHandler<TreeView.EditEvent<String>>() {
        @Override
            public void handle(TreeView.EditEvent<String> event) {
                editStart(event);
            }
        });
        
        // Set editing related event handlers (OnEditCommit)
        this.treeCategoria.setOnEditCommit(new EventHandler<TreeView.EditEvent<String>>() {
            @Override
            public void handle(TreeView.EditEvent<String> event) {
                editCommit(event);
            }
        });
        
        // Set editing related event handlers (OnEditCancel)
        this.treeCategoria.setOnEditCancel(new EventHandler<TreeView.EditEvent<String>>()
        {
            @Override
            public void handle(TreeView.EditEvent<String> event) {
                editCancel(event);
            }
        });
        
        // Set tree modification related event handlers (branchExpandedEvent)
	this.root.addEventHandler(TreeItem.<String>branchExpandedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>()
	{
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                branchExpended(event);
            }
        });
        
        // Set tree modification related event handlers (branchCollapsedEvent)
        this.root.addEventHandler(TreeItem.<String>branchCollapsedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>()
        {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                branchCollapsed(event);
            }
	});

        // Set tree modification related event handlers (childrenModificationEvent)
	this.root.addEventHandler(TreeItem.<String>childrenModificationEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                childrenModification(event);
            }
        });
        
        //Habilitando os evento de adicionar e remover
        eventoBotaoAdicionarCategoria();
        eventoBotaoRemoverCategoria();
/*
        btnAdicionarCategoria = new Button();
        btnAdicionarCategoria.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
                addItem(txtItem.getText());
            }
        });

        btnRemoverCategoria = new Button();
        btnRemoverCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                removeItem();
            }
        });
*/

        //Define o numero de texto nas linhas e colunas para a area de texto
        txtareaInformacoes.setPrefRowCount(15);
        txtareaInformacoes.setPrefColumnCount(25);

        //Atualizar a TreeView da classe arvore
        arvore.setTreeCategoria(this.treeCategoria);
    }    
    
    private void addItem(String value) {
        
        if (value == null || value.trim().equals("")) {
            writeMessage("O item n�o pode ser vazio.");
            return;
        }

        TreeItem<String> parent = treeCategoria.getSelectionModel().getSelectedItem();

        if (parent == null) {
            writeMessage("Selecione um n� para adicionar este item.");
            return;
        }

        // Check for duplicate
        for (TreeItem<String> child : parent.getChildren()) {
            if (child.getValue().equals(value)) {
                writeMessage(value + " j� existe em baixo " + parent.getValue());
                return;
            }
        }

        TreeItem<String> newItem = new TreeItem<String>(value);
        parent.getChildren().add(newItem);

        if (!parent.isExpanded()) {
            parent.setExpanded(true);
        }
    }

    // Helper Method for Removing an Item
    private void removeItem() {
        
        TreeItem<String> item = treeCategoria.getSelectionModel().getSelectedItem();

        if (item == null) {
            writeMessage("Selecione um n� para remover.");
            return;
        }

        TreeItem<String> parent = item.getParent();
        if (parent == null) {
            writeMessage("N�o � poss�vel remover o n� raiz.");
        } else {
            parent.getChildren().remove(item);
        }
    }
    
    
    public void branchExpended(TreeItem.TreeModificationEvent<String> event) {
        String nodeValue = event.getSource().getValue().toString();
        writeMessage("N� " + nodeValue + " expandido.");
    }

    public void branchCollapsed(TreeItem.TreeModificationEvent<String> event) {
        String nodeValue = event.getSource().getValue().toString();
        writeMessage("N� " + nodeValue + " se acabou.");
    }

    public void childrenModification(TreeItem.TreeModificationEvent<String> event) {
        if (event.wasAdded()) {
            for (TreeItem<String> item : event.getAddedChildren()) {
                writeMessage("N� " + item.getValue() + " foi adicionado.");
            }
        }

        if (event.wasRemoved()) {
            for (TreeItem<String> item : event.getRemovedChildren()) {
                writeMessage("N� " + item.getValue() + " foi removido.");
            }
        }
    }

    public void editStart(TreeView.EditEvent<String> event) {
        writeMessage("Edi��o iniciada: " + event.getTreeItem());
    }

    public void editCommit(TreeView.EditEvent<String> event) {
        writeMessage(event.getTreeItem() + " mudou."
                + " antigo = " + event.getOldValue()
                + ", novo = " + event.getNewValue());
    }

    public void editCancel(TreeView.EditEvent<String> e) {
        writeMessage("Edi��o finalizada: " + e.getTreeItem());
    }    
    
    // Method for Logging
    public void writeMessage(String msg) {
        this.txtareaInformacoes.appendText(msg + "\n");
    } 

    /**
     * Metodos Abstratos (conf)
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        ArvoreCategoria arvore = new ArvoreCategoria(treeCategoria);
//        arvore.carregarTreeView();
        arvore = new ArvoreCategoria(this.treeCategoria, this.root);
    }

}
