package br.com.compdevbooks.alphacosmetics.gui.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactoryEnum;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.entity.ClienteEntity;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class FrmCliente {

	@FXML
	private Button btnConfirmar;

	@FXML
	private TextField txtPesqNome;

	@FXML
	private Label lblPesqNome;

	@FXML
	private HBox hbxEditButtons;

	@FXML
	private Tab tabClientes;

	@FXML
	private Label lblCodigoValue;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtTelefone;

	@FXML
	private Label lblEmail;

	@FXML
	private VBox vbxBottom;

	@FXML
	private TableView<ClienteEntity> tblClientes;

	@FXML
	private Label lblStatus;

	@FXML
	private GridPane grdEdicao;

	@FXML
	private Button btnProcurar;

	@FXML
	private Button btnAlterar;

	@FXML
	private Button btnCancelar;

	@FXML
	private TabPane tbpCliente;

	@FXML
	private Label lblTelefone;

	@FXML
	private Tab tabEdicao;

	@FXML
	private Button btnExcluir;

	@FXML
	private Label lblCodigo;

	@FXML
	private Label lblNome;

	@FXML
	private Button btnNovo;

	IClienteDAO dao = DAOFactory.getDAOFactory(DAOFactoryEnum.MOCK).getClienteDAO();

	@FXML
	void btnNovo_onAction(ActionEvent event) {
		lblStatus.setText("Cadastrando novo cliente.");
		habilitarEdicao(true);
	}

	@FXML
	void btnConfirmar_onAction(ActionEvent event) {
		lblStatus.setText("Cliente salvo com sucesso.");
		habilitarEdicao(false);
	}

	@FXML
	void btnAlterar_onAction(ActionEvent event) {
		lblStatus.setText("Alterando dados do cliente.");
		habilitarEdicao(true);
	}

	@FXML
	void btnCancelar_onAction(ActionEvent event) {
		lblStatus.setText("Edição cancelada.");
		habilitarEdicao(false);
	}

	@FXML
	void btnExcluir_onAction(ActionEvent event) {
		lblStatus.setText("Cliente excluído com sucesso.");
	}

	@FXML
	void txtPesqNome_onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER)
			btnProcurar.fire();
	}

	@FXML
	void btnProcurar_onAction(ActionEvent event) {
		final ObservableList<ClienteEntity> produtos = FXCollections
				.observableArrayList(dao.getByNome(txtPesqNome.getText()));
		
		TableColumn<ClienteEntity, String> tbcNome = new TableColumn<ClienteEntity, String>("Nome");
		tbcNome.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper(c.getValue().getNome());
			}
		});

		tblClientes.getColumns().add(tbcNome);
		
		tblClientes.setItems(produtos);

		lblStatus.setText("Foram encontrados " + produtos.size() + " clientes.");

	}

	void habilitarEdicao(boolean sim) {
		if (sim) {
			btnNovo.setDisable(sim);
			btnConfirmar.setDisable(!sim);
			btnAlterar.setDisable(sim);
			btnCancelar.setDisable(!sim);
			btnExcluir.setDisable(sim);
		} else {
			btnNovo.setDisable(!sim);
			btnConfirmar.setDisable(sim);
			btnAlterar.setDisable(!sim);
			btnCancelar.setDisable(sim);
			btnExcluir.setDisable(!sim);
		}
	}
}
