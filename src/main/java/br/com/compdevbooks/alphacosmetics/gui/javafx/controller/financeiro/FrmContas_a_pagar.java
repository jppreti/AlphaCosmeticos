
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import br.com.compdevbooks.alphacosmetics.entity.pagamento.FormaPagamentoEnum;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
public class FrmContas_a_pagar {
    
     @FXML
    private TextField txtNomeRazaoSocial;
     
         @FXML
    private BorderPane frmContasPagar;

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
    private ComboBox<FormaPagamentoEnum> cmbFormaPgto;

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
    private ComboBox<String> cmbOpcaoPesquisa;

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
    void initialize(){
         ObservableList<String> ob = FXCollections.observableArrayList();
             
             ob.add("Dt Lançamento");
              ob.add("Dt Vencimento");
            cmbOpcaoPesquisa.setItems(ob);
            cmbOpcaoPesquisa.setValue("Dt Lançamento");
            
            Date data = new Date();
            LocalDate dtlocal = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dtpFinal.setValue(dtlocal);
            
            rdbTodos.setSelected(true);
            rdbTodosTipoCliente.setSelected(true);
            
            cmbFormaPgto.setItems(FXCollections.observableArrayList(FormaPagamentoEnum.values()));
             cmbFormaPgto.setValue(FormaPagamentoEnum.TODOS);
    }

    @FXML
    void btnBaixarDivida_onAction(ActionEvent event) {

    }

    @FXML
    void btnSair_onAction(ActionEvent event) {
        
        getPai(frmContasPagar);

    }
    
    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
                getPai(frmContasPagar);
                }
    }

    @FXML
    void dtpInicial_onKeyPressed(ActionEvent event) {

    }
        private void getPai(Node node){
        Node aux = node.getParent();
        while(!(aux instanceof BorderPane)){
            aux=node.getParent();
        }
        ((BorderPane)aux).setCenter(null);
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
    
    
    @FXML
    void rdbEmAberto_onAction(ActionEvent event) {
            rdbVencidos.setSelected(false);
            rdbTodosTipoCliente.setSelected(false);

    }

    @FXML
    void rdbVencidos_onAction(ActionEvent event) {
        
     rdbEmAberto.setSelected(false);
     rdbTodos.setSelected(false);
    }

    @FXML
    void rdbTodosTipoCliente_onAction(ActionEvent event) {
        
        rdbEmAberto.setSelected(false);
        rdbVencidos.setSelected(false);

    }
    
        @FXML
    void rdbFornecedor_onAction(ActionEvent event) {
        
        rdbTodos.setSelected(false);
        rdbPromotor.setSelected(false);

    }

    @FXML
    void rdbPromotor_onAction(ActionEvent event) {
        
        rdbTodos.setSelected(false);
        rdbFornecedor.setSelected(false);

    }

    @FXML
    void rdbTodos_onAction(ActionEvent event) {
        
        rdbFornecedor.setSelected(false);
        rdbPromotor.setSelected(false);

    }
}
