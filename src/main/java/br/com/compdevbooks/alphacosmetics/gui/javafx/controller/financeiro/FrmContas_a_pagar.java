
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.FormaPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaContasAPagar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn< TabelaTelaContasAPagar, String> clmNomeRazaoSocial;

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
    private TableColumn< TabelaTelaContasAPagar, Float> clmValor;

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
    private TableColumn< TabelaTelaContasAPagar, String> clmDtLancamento;

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
    private TableColumn< TabelaTelaContasAPagar, String> clmFormaPgto;

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
    private TableColumn< TabelaTelaContasAPagar, String> clmDtVencimento;

    @FXML
    private Label lblValor;

    @FXML
    private DatePicker dtpInicial;

    @FXML
    private RadioButton rdbVencidos;

    @FXML
    private Label lblNomeRazaoSocialValor;
    

    
  
    @FXML
    private TableView<TabelaTelaContasAPagar> tblContas_a_pagar;
    
    private Compra compra = new Compra(DAOFactory.getDAOFactory().getCompraDAO());
    
    @FXML
    void initialize(){
         ObservableList<String> ob = FXCollections.observableArrayList();
         List<CompraEntity> ListaCompra;
         ListaCompra = compra.buscarTodasCompras();
         System.out.println(ListaCompra.size());
         
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
         completar(ListaCompra);
    }

    public void completar(List<CompraEntity> lista){
        ObservableList<TabelaTelaContasAPagar> listaFinal = FXCollections.observableArrayList();
        this.clmDtLancamento.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar,String>("dtLancamento"));
        this.clmDtVencimento.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar,String>("dtVencimento"));
        this.clmNomeRazaoSocial.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar,String>("nome"));
        this.clmFormaPgto.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar,String>("formaPgto"));
        this.clmValor.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasAPagar,Float>("valor"));
      
       
        
        for(CompraEntity vo : lista){ 
            System.out.println(vo.getPagamentoVO().getListaParcelas().size());
            for(ParcelaPagamentoEntity parcPg : vo.getPagamentoVO().getListaParcelas()){
                     
                System.out.println(parcPg.getDocumentoPagamento().getNome());
                TabelaTelaContasAPagar tabela = new TabelaTelaContasAPagar();
                          
                tabela.setDtLancamento(vo.getDataLancamento());
                tabela.setDtVencimento(parcPg.getDataVencimento());
                tabela.setNome(vo.getNomeFornecedor());
                tabela.setFormaPgto(parcPg.getDocumentoPagamento().getNome());
                System.out.println(parcPg.getDocumentoPagamento().getNome());
                tabela.setValor((float)parcPg.getValorOriginal());
            
               listaFinal.add(tabela);
            }
            
           
            
        }
        this.tblContas_a_pagar.setItems(listaFinal);
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
