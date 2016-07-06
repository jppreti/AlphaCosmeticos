
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
public class FrmContas_a_pagar {
    
    @FXML
    private TextField txtNomeRazaoSocial;

    @FXML
    private DatePicker dtpFinal;

    @FXML
    private Label lblDataFinal;

    @FXML
    private Label lblTotaisPeriodo;

    @FXML
    private Label lblSituacao;

    @FXML
    private Label lblDiaAtrasado;

    @FXML
    private TextField txtTotal;

    @FXML
    private TableColumn<?, ?> clmNomeRazaoSocial;

    @FXML
    private RadioButton rdbEmAberto;

    @FXML
    private Label lblValorValor;

    @FXML
    private DatePicker dtpPagamento;

    @FXML
    private Label lblVencimento;

    @FXML
    private TextField txTotalVencidos30Valor;

    @FXML
    private ComboBox<?> cmbFormaPgto;

    @FXML
    private RadioButton rdbTodos;

    @FXML
    private TableColumn<?, ?> clmValor;

    @FXML
    private TextField txtValorAPagar;

    @FXML
    private Tab tabDividas;

    @FXML
    private Label lblValorPago;

    @FXML
    private Label lblDiaAtrasadoValor;

    @FXML
    private Label lblVencimentoValor;

    @FXML
    private Label txtTotalVencidos;

    @FXML
    private TextField txtValorPago;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblTotalVencido30;

    @FXML
    private TableColumn<?, ?> clmDtLancamento;

    @FXML
    private Label lblDataInicial;

    @FXML
    private Label lblDataPagamento;

    @FXML
    private Label lblNomeRazaoSocial;

    @FXML
    private GridPane grpRelatorioResumido;

    @FXML
    private Label lblTotalEmAberto;

    @FXML
    private Label lblDocumento;

    @FXML
    private TextField txtTotalVencidosValor;

    @FXML
    private Button btnSair;

    @FXML
    private ComboBox<?> cmbOpcaoPesquisa;

    @FXML
    private Label lblFormaPagamento;

    @FXML
    private RadioButton rdbPromotor;

    @FXML
    private RadioButton rdbFornecedor;

    @FXML
    private TextField txtCpfCnpj;

    @FXML
    private Button btnProcurar;

    @FXML
    private TextField txtTotalEmAbertoValor;

    @FXML
    private Button btnBaixarDivida;

    @FXML
    private TableColumn<?, ?> clmFormaPgto;

    @FXML
    private RadioButton rdbTodosTipoCliente;

    @FXML
    private Label lblValorAPagar;

    @FXML
    private Label lblTotal;

    @FXML
    private Tab tabRelatorioResumido;

    @FXML
    private Label lblDocumentoValor;

    @FXML
    private TableColumn<?, ?> clmDtVencimento;

    @FXML
    private Label lblValor;

    @FXML
    private DatePicker dtpInicial;

    @FXML
    private RadioButton rdbVencidos;

    @FXML
    private Label lblNomeRazaoSocialValor;

    @FXML
    void btnBaixarDivida_onAction(ActionEvent event) {

    }

    @FXML
    void btnSair_onAction(ActionEvent event) {

    }

    @FXML
    void dtpInicial_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void dtpFinal_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void txtCpfCnpj_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void txtNomeRazaoSocial_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnProcurar_onAction(ActionEvent event) {

    }
}
