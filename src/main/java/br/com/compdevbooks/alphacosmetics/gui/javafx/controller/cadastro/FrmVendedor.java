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
import javax.swing.JOptionPane;

public class FrmVendedor {

    @FXML
    private TextField txtPesqNome;

    @FXML
    private HBox hbxEditButtons1;

    @FXML
    private HBox hbxEditButtons;

    @FXML
    private Tab tabCliente;

    @FXML
    private TextField txtNome;

    @FXML
    private VBox vbxBottom;

    @FXML
    private TextField txtCpf;

    @FXML
    private StackPane stkDialog;

    @FXML
    private Button btnProcurar;

    @FXML
    private TabPane tbpFornecedores;

    @FXML
    private Button buttonExcluir;

    @FXML
    private Tab tabEditar;

    @FXML
    private TableView<VendedorEntity> tableViewVendedor;

    @FXML
    private TextField txtCidade;

    @FXML
    private Button buttonEditar;

    @FXML
    private TextField txtRegiao;

    @FXML
    private TextField txtRg;
    
    Vendedor vendedor = new Vendedor(DAOFactory.getDAOFactory().getVendedorDAO());

    //Inicializa os elementos da TableViewCliente
    @FXML
    void initialize() {
                //Adciona a Coluna Nome
		TableColumn<VendedorEntity, String> tbcNome = new TableColumn<VendedorEntity, String>("Nome");
		tbcNome.setCellValueFactory(new Callback<CellDataFeatures<VendedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<VendedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getNome());
			}
		});
                
                //Adciona a Coluna CPF
                TableColumn<VendedorEntity, String> tbcCPF = new TableColumn<VendedorEntity, String>("CPF");
		tbcCPF.setCellValueFactory(new Callback<CellDataFeatures<VendedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<VendedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getCPF());
			}
		});
                
                //Adciona a Coluna RG
                TableColumn<VendedorEntity, String> tbcRg = new TableColumn<VendedorEntity, String>("RG");
		tbcRg.setCellValueFactory(new Callback<CellDataFeatures<VendedorEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<VendedorEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getRG());
			}
		});
                

                tableViewVendedor.getColumns().add(tbcNome);
                tableViewVendedor.getColumns().add(tbcCPF);
                tableViewVendedor.getColumns().add(tbcRg);
                atualiza_Cliente();
    } 
    
    void atualiza_Cliente(){
        final ObservableList<VendedorEntity> produtos = FXCollections.observableArrayList(vendedor.getByNome(txtPesqNome.getText()));
        tableViewVendedor.setItems(produtos);
    }
    
    //Método para Alterar
    @FXML
    void Editar(ActionEvent event) {
        VendedorEntity ent = tableViewVendedor.getSelectionModel().getSelectedItem();
        //Deleta a informação anterior e adiciona a nova informação no TextField
		if (ent != null) {
                    vendedor.delete(tableViewVendedor.getSelectionModel().getSelectedItem());
                    txtNome.setText(ent.getNome());
                    txtCpf.setText(ent.getCPF());
                    txtRg.setText(ent.getRG());
		}
    }

    //Método para Excluir
    @FXML
    void Excluir(ActionEvent event) {
        if (tableViewVendedor.getSelectionModel().getSelectedIndex() >= 0) {
            int reply = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir o Item Selecionado?", 
            "Excluir Item", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
              vendedor.delete(tableViewVendedor.getSelectionModel().getSelectedItem());
              atualiza_Cliente();  
              JOptionPane.showMessageDialog(null, "Item Excluído com Sucesso!!");
            }
        }
    }

    //Método para Cadastrar
    @FXML
    void Salvar_Dados(ActionEvent event) {
        VendedorEntity ent;
        ent = new VendedorEntity();
        
        if(txtNome.getText().equals("")||
           txtCpf.getText().equals("")|| 
           txtRg.getText().equals("")){  
           JOptionPane.showMessageDialog(null,"Os Campos Nome, CPF e RG devem ser informados!");
        }else{
	ent.setNome(txtNome.getText());
        ent.setCPF(txtCpf.getText());
        ent.setRG(txtRg.getText());
	vendedor.save(ent);
        atualiza_Cliente();
        JOptionPane.showMessageDialog(null,"Cliente Cadastrado com Sucesso!!");
        }
    }

    //Método para Limpar os Campos
    @FXML
    void Limpar_Dados(){
        txtNome.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        JOptionPane.showMessageDialog(null, "Todos os campos foram limpos");
    }	
    
    //Método para Pesquisar Por Nome
    @FXML
    void Pesquisa_Nome(ActionEvent event) {
        atualiza_Cliente();
    }
    
    
}
