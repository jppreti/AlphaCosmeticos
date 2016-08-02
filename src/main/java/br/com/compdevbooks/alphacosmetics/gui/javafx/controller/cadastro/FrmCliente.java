package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.cadastro;

import br.com.compdevbooks.alphacosmetics.business.Cliente;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class FrmCliente {

    @FXML
    private TextField txtClienteMunicipio;

    @FXML
    private TextField txtPesqNome;

    @FXML
    private Button botao_limpar;

    @FXML
    private TableView<ClienteEntity> tableViewCliente;

    @FXML
    private TextField txtClienteInscricao;

    @FXML
    private Tab tabCliente;

    @FXML
    private Button botao_salvar;

    @FXML
    private StackPane stkDialog;

    @FXML
    private TextField txtClienteBairro;

    @FXML
    private TextField txtClienteCep;

    @FXML
    private TextField txtClienteFantasia;

    @FXML
    private TextField txtClienteEstado;

    @FXML
    private Button btnProcurar;

    @FXML
    private TabPane tbpFornecedores;

    @FXML
    private Button buttonExcluir;

    @FXML
    private Tab tabEditar;

    @FXML
    private TextField txtClienteCnpj;

    @FXML
    private TextField txtClienteLogradouro;

    @FXML
    private Button buttonEditar;

    @FXML
    private TextField txtClienteNumero;

    @FXML
    private TextField txtClienteRazaoSocial;
    
    Cliente cliente = new Cliente(DAOFactory.getDAOFactory().getClienteDAO());
    
    //Inicializa os elementos da TableViewCliente
    @FXML
    void initialize() {
                //Adciona a Coluna Razão Social
		TableColumn<ClienteEntity, String> tbcRazaoSocial = new TableColumn<ClienteEntity, String>("Razão Social");
		tbcRazaoSocial.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getNome());
			}
		});
                
                //Adciona a Coluna Nome Fantasia
		TableColumn<ClienteEntity, String> tbcNome = new TableColumn<ClienteEntity, String>("Nome Fantasia");
		tbcNome.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getFantasia());
			}
		});
                
                //Adciona a Coluna CNPJ
		TableColumn<ClienteEntity, String> tbcCnpj = new TableColumn<ClienteEntity, String>("CNPJ");
		tbcCnpj.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getCNPJ());
			}
		});
                
                //Adciona a Coluna Inscrição Estadual
		TableColumn<ClienteEntity, String> tbcInscrição = new TableColumn<ClienteEntity, String>("Inscrição Estadual");
		tbcInscrição.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getInscricao());
			}
		});
                
                //Adciona a Coluna Logradouro
		TableColumn<ClienteEntity, String> tbcLogradouro = new TableColumn<ClienteEntity, String>("Logradouro");
		tbcLogradouro.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getEnderecoVO().getLogradouro());
			}
		});
                
                //Adciona a Coluna Número
		TableColumn<ClienteEntity, Integer> tbcNumero = new TableColumn<ClienteEntity, Integer>("Número");
		tbcNumero.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, Integer>, ObservableValue<Integer>>() {
			public ObservableValue<Integer> call(CellDataFeatures<ClienteEntity, Integer> c) {
				return new ReadOnlyObjectWrapper<Integer>(c.getValue().getEnderecoVO().getNumero());
			}
		});
                
                //Adciona a Coluna CEP
		TableColumn<ClienteEntity, String> tbcCEP = new TableColumn<ClienteEntity, String>("CEP");
		tbcCEP.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getEnderecoVO().getCEP());
			}
		});
                
                //Adciona a Coluna Bairro
		TableColumn<ClienteEntity, String> tbcBairro = new TableColumn<ClienteEntity, String>("Bairro");
		tbcBairro.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getEnderecoVO().getBairroVO().getNome());
			}
		});
                

                //tbcRazaoSocial.setMinWidth(40);
                //tbcNome.setMinWidth(40);
                tableViewCliente.getColumns().add(tbcRazaoSocial);
                tableViewCliente.getColumns().add(tbcNome);
                tableViewCliente.getColumns().add(tbcCnpj);
                tableViewCliente.getColumns().add(tbcInscrição);
                tableViewCliente.getColumns().add(tbcLogradouro);
                tableViewCliente.getColumns().add(tbcNumero);
                tableViewCliente.getColumns().add(tbcCEP);
                tableViewCliente.getColumns().add(tbcBairro);
                atualiza_Cliente();
    } 
    
    void atualiza_Cliente(){
        ObservableList<ClienteEntity> produtos = FXCollections.observableArrayList(cliente.getByNome(txtPesqNome.getText()));
        tableViewCliente.setItems(produtos);
    }

    @FXML
    void btnAlterar(ActionEvent event) {
        ClienteEntity ent = tableViewCliente.getSelectionModel().getSelectedItem();
        //Deleta a informação anterior e adiciona a nova informação no TextField
		if (ent != null) {
                    cliente.delete(tableViewCliente.getSelectionModel().getSelectedItem());
                    txtClienteRazaoSocial.setText(ent.getNome());
                    txtClienteFantasia.setText(ent.getFantasia());
                    txtClienteCnpj.setText(ent.getCNPJ());
                    txtClienteInscricao.setText(ent.getInscricao());
                    txtClienteLogradouro.setText(ent.getEnderecoVO().getLogradouro());
                    txtClienteNumero.setText(String.valueOf(ent.getEnderecoVO().getNumero()));
                    txtClienteCep.setText(ent.getEnderecoVO().getLogradouro());
                    txtClienteBairro.setText(ent.getEnderecoVO().getBairroVO().getNome());
		}
    }

    @FXML
    void btnExcluir(ActionEvent event) {
        if (tableViewCliente.getSelectionModel().getSelectedIndex() >= 0) {
            cliente.delete(tableViewCliente.getSelectionModel().getSelectedItem());
            atualiza_Cliente();
        }
    }

    @FXML
    void button_salvar(ActionEvent event) {
        ClienteEntity ent = new ClienteEntity();
	ent.setInscricao(txtClienteInscricao.getText());
	cliente.save(ent);
        atualiza_Cliente();
    }

    @FXML
    void limpar_dados(ActionEvent event) {
        txtClienteRazaoSocial.setText("");
        txtClienteFantasia.setText("");
        txtClienteCnpj.setText("");
        txtClienteInscricao.setText("");
        txtClienteLogradouro.setText("");
        txtClienteNumero.setText("");
        txtClienteCep.setText("");
        txtClienteBairro.setText("");
        txtClienteMunicipio.setText("");
        txtClienteEstado.setText("");
    }

    @FXML
    void botao_pesquisa(ActionEvent event) {
        atualiza_Cliente();
    }

}
