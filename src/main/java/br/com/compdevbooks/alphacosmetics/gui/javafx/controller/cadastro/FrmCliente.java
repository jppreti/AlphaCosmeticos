package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.cadastro;

import br.com.compdevbooks.alphacosmetics.business.Cliente;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javax.smartcardio.ATR;

public class FrmCliente {

    @FXML
    private TextField txtNome11;

    @FXML
    private TextField txtNome22;

    @FXML
    private TextField txtPesqNome;

    @FXML
    private TextField txtNome21;

    @FXML
    private TableView<ClienteEntity> tableViewCliente;

    @FXML
    private TextField txtNome212;

    @FXML
    private Tab tabCliente;

    @FXML
    private TextField txtNome111;

    @FXML
    private TextField txtNome211;

    @FXML
    private Label nomeFantasia1;

    @FXML
    private TextField txtNome2;

    @FXML
    private StackPane stkDialog;

    @FXML
    private TextField txtNome1;

    @FXML
    private TextField txtNome2111;

    @FXML
    private Label nomeFantasia;

    @FXML
    private Button btnProcurar;

    @FXML
    private TabPane tbpFornecedores;

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Button buttonExcluir;

    @FXML
    private Tab tabEditar;

    @FXML
    private Label nomeFantasia11;

    @FXML
    private Button buttonEditar;

    @FXML
    private Label razaoSocial;

    @FXML
    private TextField txtClienteRazaoSocial;

    Cliente cliente = new Cliente(DAOFactory.getDAOFactory().getClienteDAO());
    
    //Inicializa os elementos da TableViewCliente
    @FXML
    void initialize() {
		TableColumn<ClienteEntity, String> tbcNome = new TableColumn<ClienteEntity, String>("Nome Fantasia");
		tbcNome.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getFantasia());
			}
		});
                tableViewCliente.getColumns().add(tbcNome);
                atualiza_Cliente();
    }
    
    @FXML
    void btnCadastrar(ActionEvent event) {
        
    }

    @FXML
    void btnAlterar(ActionEvent event) {
    }

    @FXML
    void btnExcluir(ActionEvent event) {
        if (tableViewCliente.getSelectionModel().getSelectedIndex() >= 0) {
            cliente.delete(tableViewCliente.getSelectionModel().getSelectedItem());
            atualiza_Cliente();
        }
    }
    
    
    void atualiza_Cliente(){
        final ObservableList<ClienteEntity> produtos = FXCollections.observableArrayList(cliente.getByNome(txtPesqNome.getText()));
        tableViewCliente.setItems(produtos);
    }
    
    
}   
    
