/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro;

import br.com.compdevbooks.alphacosmetics.business.Cliente;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockVendaDAO;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.FormaPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaContasReceber;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
//import br.com.compdevbooks.alphacosmetics.entity.pagamento.

public class FrmContas_a_receber {

    @FXML
    private TextField txtNumParcelas;

    @FXML
    private TextField txtNomeRazaoSocial;

    @FXML
    private DatePicker dtpFinal;

    @FXML
    private Label lblTotaisPeriodo;

    @FXML
    private BorderPane frmContaReceber;

    @FXML
    private Label lblTotalVencidos30;

    @FXML
    private Label lblSituacao;

    @FXML
    private GridPane grpVisualizar;

    @FXML
    private RadioButton rdbEmAberto;

    @FXML
    private Label lblValorValor;

    @FXML
    private TextField txtTotalVencido30Valor;

    @FXML
    private Label lblVencimento;

    @FXML
    private Button btnBaixarTitulos;

    @FXML
    private Label lblNumPedidoValor;

    @FXML
    private ComboBox<FormaPagamentoEnum> cmbFormaPgto;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmCliente;

    @FXML
    private TableColumn<TabelaTelaContasReceber, Float> clmValor;

    @FXML
    private Label lblVencimentoValor;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblLancamento;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmDtLancamento;

    @FXML
    private Label lblTotalEmAberto;

    @FXML
    private Button btnVisualizarImpressao;

    @FXML
    private TextField txtTotalVencidosValor;

    @FXML
    private Button btnSair;

    @FXML
    private ComboBox<String> cmbOpcaoPesquisa;

    @FXML
    private Label lblValorTotal;

    @FXML
    private Tab tabTitulos;

    @FXML
    private Label lblTipoDocumento;

    @FXML
    private Label lblLancamentoValor;

    @FXML
    private Label lblNumTituloValor;

    @FXML
    private TextField txtCpfCnpj;

    @FXML
    private Label lblNumTitulo;

    @FXML
    private Label lblNumPedido;

    @FXML
    private Button btnProcurar;

    @FXML
    private Tab tabVisualizar;

    @FXML
    private Label lblCliente;

    @FXML
    private Label lblNumParcelas;

    @FXML
    private TextField txtTotalEmAbertoValor;

    @FXML
    private Label lblTipoDocumentoValor;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmFormaPgto;

    @FXML
    private RadioButton rdbTodosTipoCliente;

    @FXML
    private Label lblClienteValor;

    @FXML
    private Label lblSituacaoValor;

    @FXML
    private Label lblPo;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmDtVencimento;

    @FXML
    private Label lblValor;

    @FXML
    private TableColumn<TabelaTelaContasReceber, String> clmSituacao;

    @FXML
    private DatePicker dtpInicial;

    @FXML
    private RadioButton rdbVencidos;

    @FXML
    private TextField txtValorTotal;    
    
    @FXML
    private TableView<TabelaTelaContasReceber> tblVenda;
    
    private Venda venda = new Venda(DAOFactory.getDAOFactory().getVendaDAO());

    @FXML
    void initialize() {
        

        ObservableList<String> ob = FXCollections.observableArrayList();
        List<VendaEntity> listaVendaT;
        listaVendaT = venda.buscarTodasVendas();
        
        ob.add("Dt Lançamento");
        ob.add("Dt Vencimento");
        cmbOpcaoPesquisa.setItems(ob);
        cmbOpcaoPesquisa.setValue("Dt Lançamento");

        Date data = new Date();
        LocalDate dtlocal = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dtpFinal.setValue(dtlocal);
        rdbTodosTipoCliente.setSelected(true);

        cmbFormaPgto.setItems(FXCollections.observableArrayList(FormaPagamentoEnum.values()));
        cmbFormaPgto.setValue(FormaPagamentoEnum.TODOS);

        completar(listaVendaT);

    }

    void completar(List<VendaEntity> lista) {
        
        Date referencia = new Date();
        float vencidos =0;
        float vencidos30=0;
        float aberto =0;
        
        ObservableList<TabelaTelaContasReceber> dado= FXCollections.observableArrayList();
        
        this.clmCliente.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber,String>("cliente"));
        this.clmDtLancamento.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber,String>("dtLancamento"));
        this.clmDtVencimento.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber,String>("dtVencimento"));
        this.clmFormaPgto.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber,String>("formapgto"));
        this.clmSituacao.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber,String>("parcela"));
        this.clmValor.setCellValueFactory(new PropertyValueFactory<TabelaTelaContasReceber,Float>("valor"));
        
        int cont=0;
        
      
        for(VendaEntity vo : lista){ 
            //  System.out.println(vo.getPagamentoVO().getListaParcelas().size());
            System.out.println(vo.getId());
            System.out.println(vo.getClienteVO().getNome());
            for(ParcelaPagamentoEntity parcPg : vo.getPagamentoVO().getListaParcelas()){
                cont++;       
                //System.out.println(parcPg.getDocumentoPagamento().getNome());
                
                TabelaTelaContasReceber tabela = new TabelaTelaContasReceber();
                
                tabela.setCliente(vo.getNomeCliente());               
                tabela.setDtLancamento(vo.getDataLancamento());
                tabela.setDtVencimento(parcPg.getDataVencimento());
                tabela.setFormapgto(parcPg.getDocumentoPagamento().getNome());
                tabela.setParcela(cont);
                tabela.setValor((float)parcPg.getValorTotalPago());
            
               dado.add(tabela);
               
               if(parcPg.getDataVencimento().compareTo(referencia)==0) aberto+=(float)parcPg.getValorTotalPago();
               if(parcPg.getDataVencimento().compareTo(referencia)==1) aberto+=(float)parcPg.getValorTotalPago();
               if(parcPg.getDataVencimento().compareTo(referencia) ==-1){
                   referencia.setDate(referencia.getDate()+30);
                   if(parcPg.getDataVencimento().compareTo(referencia) == -1)vencidos30+=(float)parcPg.getValorTotalPago();
                    if(parcPg.getDataVencimento().compareTo(referencia) == 0)vencidos30+=(float)parcPg.getValorTotalPago();
                    else vencidos+=(float)parcPg.getValorTotalPago();
               }
            }
            cont=0;
           
            
        }
         this.tblVenda.setItems(dado);
        
        
         txtTotalEmAbertoValor.setText("$ "+aberto);
         txtTotalVencidosValor.setText("$ "+vencidos);
         txtTotalVencido30Valor.setText("$ "+vencidos30);
     
        
    
    }

    @FXML
    void btnBaixarTitulos_onAction(ActionEvent event) {

    }

    @FXML
    void btnVisualizarImpressao_onAction(ActionEvent event) {

    }

    @FXML
    void btnSair_onAction(ActionEvent event) {

        getPai(frmContaReceber);

    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            getPai(frmContaReceber);
        }

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
    void txtNomeRazaoSocial(ActionEvent event) {

    }

    @FXML
    void btnProcurar_onAction(ActionEvent event) {

    }

    @FXML
    void rdbEmAberto_onAction(ActionEvent event) {

        rdbTodosTipoCliente.setSelected(false);
        rdbVencidos.setSelected(false);

    }

    @FXML
    void rdbVencidos_onAction(ActionEvent event) {
        rdbEmAberto.setSelected(false);
        rdbTodosTipoCliente.setSelected(false);

    }

    @FXML
    void rdbTodosTipoCliente_onAction(ActionEvent event) {
        rdbEmAberto.setSelected(false);
        rdbVencidos.setSelected(false);

    }

    private void getPai(Node node) {
        Node aux = node.getParent();
        while (!(aux instanceof BorderPane)) {
            aux = node.getParent();
        }
        ((BorderPane) aux).setCenter(null);
    }

}
