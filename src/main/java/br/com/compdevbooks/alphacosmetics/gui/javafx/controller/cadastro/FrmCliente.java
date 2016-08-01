package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.cadastro;

import br.com.compdevbooks.alphacosmetics.business.Vendedor;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.VendedorEntity;
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
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

public class FrmCliente {

    @FXML
    private TextField txtClienteMunicipio;

    @FXML
    private TextField txtPesqNome;

    @FXML
    private TableView<VendedorEntity> tableViewCliente;

    @FXML
    private Tab tabCliente;

    @FXML
    private Label nomeFantasia1;

    @FXML
    private TextField txtClienteBairro;

    @FXML
    private TextField txtClienteCep;

    @FXML
    private TextField txtClienteFantasia;

    @FXML
    private Label nomeFantasia;

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
    private Button botao_limpar;

    @FXML
    private TextField txtClienteInscricao;

    @FXML
    private Button botao_salvar;

    @FXML
    private StackPane stkDialog;

    @FXML
    private TextField txtClienteEstado;

    @FXML
    private Button botao_cancelar;

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Label nomeFantasia11;

    @FXML
    private Label razaoSocial;

    @FXML
    private TextField txtClienteRazaoSocial;
    
    Vendedor vendedor = new Vendedor(DAOFactory.getDAOFactory().getVendedorDAO());
    private boolean novo = true;
    
    //Inicializa os elementos da TableViewCliente
    @FXML
    void initialize() {
		TableColumn<VendedorEntity, String> tbcNome = new TableColumn<VendedorEntity, String>("Nome");
		tbcNome.setCellValueFactory(new Callback<CellDataFeatures<VendedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<VendedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getNome());
			}
		});
                tableViewCliente.getColumns().add(tbcNome);
                atualiza_Cliente();
    }
    
    @FXML
    void btnCadastrar(ActionEvent event) {
    
    }
    
    //Método para Alterar
    @FXML
    void btnAlterar(ActionEvent event) {
        VendedorEntity ent = tableViewCliente.getSelectionModel().getSelectedItem();
        //Deleta a informação anterior e adiciona a nova informação no TextField
		if (ent != null) {
                    vendedor.delete(tableViewCliente.getSelectionModel().getSelectedItem());
                    txtClienteFantasia.setText(ent.getNome());
	            txtClienteCnpj.setText(ent.getRG());
		    txtClienteInscricao.setText(ent.getCPF());
		}
    }
    
    //Método para Excluir
    @FXML
    void btnExcluir(ActionEvent event) {
        if (tableViewCliente.getSelectionModel().getSelectedIndex() >= 0) {
            vendedor.delete(tableViewCliente.getSelectionModel().getSelectedItem());
            atualiza_Cliente();
        }
    }

    @FXML
    void botao_cancelar(ActionEvent event) {

    }

    //Método para Cadastrar    
    @FXML
    void button_salvar(ActionEvent event) {
        VendedorEntity ent;
        ent = new VendedorEntity();
	ent.setNome(txtClienteFantasia.getText());
	vendedor.save(ent);
        atualiza_Cliente();
    }

    //Método para Limpar os campos
    @FXML
    void limpar_dados(){
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
    
    //Pesquisa Por Nome
    @FXML
    void botao_pesquisa(ActionEvent event) {
        atualiza_Cliente();
    }
    
    void atualiza_Cliente(){
        final ObservableList<VendedorEntity> produtos = FXCollections.observableArrayList(vendedor.getByNome(txtPesqNome.getText()));
        tableViewCliente.setItems(produtos);
    }
    

}
