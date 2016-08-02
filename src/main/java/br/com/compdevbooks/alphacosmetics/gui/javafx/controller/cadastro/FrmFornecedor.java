package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.cadastro;

import br.com.compdevbooks.alphacosmetics.business.Fornecedor;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class FrmFornecedor {

    @FXML
    private TextField txtPesqNome;

    @FXML
    private TextField txtInscricao;

    @FXML
    private HBox hbxEditButtons1;

    @FXML
    private HBox hbxEditButtons;

    @FXML
    private Tab tabCliente;

    @FXML
    private TableView<FornecedorEntity> tableViewFornecedor;

    @FXML
    private TextField txtEmail;

    @FXML
    private VBox vbxBottom;

    @FXML
    private TextField txtNumero;

    @FXML
    private Label lblStatus;

    @FXML
    private StackPane stkDialog;

    @FXML
    private TextField txtCnpj;

    @FXML
    private Button btnProcurar;

    @FXML
    private TabPane tbpFornecedores;

    @FXML
    private Button buttonExcluir;

    @FXML
    private Tab tabEditar;

    @FXML
    private TextField txtRazaoSocial;

    @FXML
    private Button buttonEditar;

    @FXML
    private TextField txtCep;

    @FXML
    private TextField txtBanco;

    @FXML
    private TextField txtLogradouro;

    @FXML
    private TextField txtFantasia;

    @FXML
    private TextField txtBairro;
    
    Fornecedor fornecedor = new Fornecedor(DAOFactory.getDAOFactory().getFornecedorDAO());
    
    //Inicializa os elementos da TableViewFornecedor
    @FXML
    void initialize() {
                //Adciona a Coluna Razão Social
		TableColumn<FornecedorEntity, String> tbcRazaoSocial = new TableColumn<FornecedorEntity, String>("Razão Social");
		tbcRazaoSocial.setCellValueFactory(new Callback<CellDataFeatures<FornecedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<FornecedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getNome());
			}
		});
                
                //Adciona a Coluna Nome Fantasia
                TableColumn<FornecedorEntity, String> tbcNomeFantasia = new TableColumn<FornecedorEntity, String>("Nome Fantasia");
		tbcNomeFantasia.setCellValueFactory(new Callback<CellDataFeatures<FornecedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<FornecedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getFantasia());
			}
		});
                
                //Adciona a Coluna Cnpj
                TableColumn<FornecedorEntity, String> tbcCnpj = new TableColumn<FornecedorEntity, String>("Inscrição Estadual");
		tbcCnpj.setCellValueFactory(new Callback<CellDataFeatures<FornecedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<FornecedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getCNPJ());
			}
		});
                
                //Adciona a Coluna Inscrição Estadual
                TableColumn<FornecedorEntity, String> tbcInscricao = new TableColumn<FornecedorEntity, String>("Inscrição Estadual");
		tbcInscricao.setCellValueFactory(new Callback<CellDataFeatures<FornecedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<FornecedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getInscricao());
			}
		});
                
                //Coluna Referente a Endereço......
                //Adciona a Coluna Logradouro
                TableColumn<FornecedorEntity, String> tbcLogradouro = new TableColumn<FornecedorEntity, String>("Logradouro");
		tbcLogradouro.setCellValueFactory(new Callback<CellDataFeatures<FornecedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<FornecedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getEnderecoVO().getLogradouro());
			}
		});
                
                //Adciona a Coluna Número
                TableColumn<FornecedorEntity, Integer> tbcNumero = new TableColumn<FornecedorEntity, Integer>("Número");
		tbcNumero.setCellValueFactory(new Callback<CellDataFeatures<FornecedorEntity, Integer>, ObservableValue<Integer>>() {
			public ObservableValue<Integer> call(CellDataFeatures<FornecedorEntity, Integer> c) {
				return new ReadOnlyObjectWrapper<Integer>(c.getValue().getEnderecoVO().getNumero());
			}
		});
                
                //Adciona a Coluna Cep
                TableColumn<FornecedorEntity, String> tbcCep = new TableColumn<FornecedorEntity, String>("CEP");
		tbcCep.setCellValueFactory(new Callback<CellDataFeatures<FornecedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<FornecedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getEnderecoVO().getCEP());
			}
		});
                
                //Adciona a Coluna Bairro
                TableColumn<FornecedorEntity, String> tbcBairro = new TableColumn<FornecedorEntity, String>("Bairro");
		tbcBairro.setCellValueFactory(new Callback<CellDataFeatures<FornecedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<FornecedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getEnderecoVO().getBairroVO().getNome());
			}
		});
                          
                tableViewFornecedor.getColumns().add(tbcRazaoSocial);
                tableViewFornecedor.getColumns().add(tbcNomeFantasia);
                tableViewFornecedor.getColumns().add(tbcCnpj);
                tableViewFornecedor.getColumns().add(tbcInscricao);
                
                tableViewFornecedor.getColumns().add(tbcLogradouro);
                tableViewFornecedor.getColumns().add(tbcNumero);
                tableViewFornecedor.getColumns().add(tbcCep);
                tableViewFornecedor.getColumns().add(tbcBairro);
                atualiza_Fornecedor();
                
    }
    void atualiza_Fornecedor(){
        final ObservableList<FornecedorEntity> produtos = FXCollections.observableArrayList(fornecedor.buscarTodosFornecedores());
        tableViewFornecedor.setItems(produtos);
    }
        
    //Método para Alterar
    @FXML
    void botao_editar_fornecedor(ActionEvent event) {
        if (tableViewFornecedor.getSelectionModel().getSelectedIndex() >= 0) {
            FornecedorEntity ent = tableViewFornecedor.getSelectionModel().getSelectedItem();
        //Deleta a informação anterior e adiciona a nova informação no TextField
		if (ent != null) {
                    fornecedor.delete(tableViewFornecedor.getSelectionModel().getSelectedItem());
                    txtRazaoSocial.setText(ent.getNome());
                    txtFantasia.setText(ent.getFantasia());
                    txtCnpj.setText(ent.getCNPJ());
                    txtInscricao.setText(ent.getInscricao());
                    txtBanco.setText("");
                    txtEmail.setText("");
                    
                    txtLogradouro.setText(ent.getEnderecoVO().getLogradouro());
                    txtNumero.setText(String.valueOf(ent.getEnderecoVO().getNumero()));
                    txtCep.setText(ent.getEnderecoVO().getCEP());
                    txtBairro.setText(ent.getEnderecoVO().getBairroVO().getNome());
		}
        }
    }

    //Método para Excluir    
    @FXML
    void botao_remover_fornecedor(ActionEvent event) {
         if (tableViewFornecedor.getSelectionModel().getSelectedIndex() >= 0) {
            fornecedor.delete(tableViewFornecedor.getSelectionModel().getSelectedItem());
            atualiza_Fornecedor();
        }
    }

    //Método para Cadastrar    
    @FXML
    void Salvar_Dados(ActionEvent event) {
        FornecedorEntity ent;
        ent = new FornecedorEntity();
	ent.setFantasia("teste");
        fornecedor.save(ent);
        atualiza_Fornecedor();
    }

    //Método para Limpar os Campos    
    @FXML
    void Limpar_Dados(ActionEvent event) {
        txtRazaoSocial.setText("");
        txtFantasia.setText("");
        txtCnpj.setText("");
        txtInscricao.setText("");
        txtBanco.setText("");
        txtEmail.setText("");
                    
        txtLogradouro.setText("");
        txtNumero.setText("");
        txtCep.setText("");
        txtBairro.setText("");
    }

    //Método para Pesquisar Por Nome
    @FXML
    void Pesquisa(ActionEvent event) {
        atualiza_Fornecedor();
    }

}
