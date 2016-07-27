/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.analisedepedidos;

import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoCompraEnum;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.NavegarObjetos;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class FrmPedidoCompraFinalizar {

    @FXML
    private Label lblRazaoSocial;

    @FXML
    private Label lblDtRecebimento;

    @FXML
    private TableColumn<ItemCompraEntity, Integer> clmItemCompraQtdeTotal;

    @FXML
    private TableColumn<ItemCompraEntity, String> clmItemCompraProduto;

    @FXML
    private Button btnFinalizar;

    @FXML
    private TextField txtInscricao;

    @FXML
    private TableColumn<ItemCompraEntity, String> clmItemCompraID;

    @FXML
    private Label lblQtdeTotal;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private Label lblID;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtDtRecebimento;

    @FXML
    private TextField txtQtdeTotal;

    @FXML
    private Label lblCNPJ;

    @FXML
    private TableColumn<ItemCompraEntity, Integer> clmItemCompraQtdeEstoque;

    @FXML
    private TextField txtRazaoSocial;

    @FXML
    private Button btnSair;

    @FXML
    private TextField lblValorTotal;

    @FXML
    private Label lblInscricao;

    @FXML
    private TableView<ItemCompraEntity> tblItemCompra;

    @FXML
    private TableColumn<ItemCompraEntity, Integer> clmItemCompraQtdeRecebida;
    
    @FXML
    private TableColumn<ItemCompraEntity, Integer> clmItemCompraQtdePedida;

    @FXML
    private Label lblPedidoCompraFinalizar;

    private CompraEntity compra;

    @FXML
    void initialize() {
        this.tblItemCompra.requestFocus();
        compra = NavegarObjetos.getCompra();
        completarTable(compra.getListaItens());
        this.txtRazaoSocial.setText(compra.getNomeFornecedor());
        this.txtInscricao.setText(compra.getFornecedorVO().getInscricao());
        this.txtCNPJ.setText(compra.getFornecedorVO().getCNPJ());
        this.txtDtRecebimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(compra.getDataRecebimento()));
        this.txtQtdeTotal.setText(String.valueOf(compra.getQtdeTotal()));
        this.lblValorTotal.setText(String.valueOf(compra.getValorTotal()));
        this.txtID.setText(String.valueOf(compra.getId()));
    }

    private void completarTable(Set<ItemCompraEntity> lista) {
        this.clmItemCompraID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.clmItemCompraProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        this.clmItemCompraQtdeRecebida.setCellValueFactory(new PropertyValueFactory<>("quantidadeFornecida"));
        this.clmItemCompraQtdeEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));
        this.clmItemCompraQtdePedida.setCellValueFactory(new PropertyValueFactory<>("quantidadePedida"));
        this.clmItemCompraQtdeTotal.setCellValueFactory(new PropertyValueFactory<>("quantidadeTotal"));
        this.tblItemCompra.setItems(FXCollections.observableArrayList(lista));
    }

    @FXML
    void btnSair_onAction(ActionEvent event) {
        BorderPane frmCompra = null;
        try {
            frmCompra = FXMLLoader.load(FrmPedidoCompra.class.getClassLoader().getResource("gui\\analisedepedidos\\pedidoCompra.fxml"), ResourceBundle.getBundle("gui/i18N_pt_BR"));

            ((BorderPane) NavegarObjetos.getPai()).setCenter(frmCompra);

        } catch (Exception ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnSair.fire();
        }
    }

    @FXML
    void btnFinalizar_onAction(ActionEvent event) {
        Alert caixa = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType sim = new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não");
        caixa.setTitle("Alpha Cosmeticos");
        caixa.setHeaderText("Finalizar pedido Compra");
        caixa.setContentText("Deseja finalizar pedido de compra?");
        caixa.getButtonTypes().setAll(sim, nao);

        caixa.showAndWait().ifPresent(p -> {
            if (p == sim) {
                compra.setSituacao(SituacaoCompraEnum.PROCESSADA);
                Date data = new Date();
                compra.setDataProcessamento(data);
                Iterator<ItemCompraEntity> i = compra.getListaItens().iterator();
                ItemCompraEntity item = null;
                while (i.hasNext()) {
                    item = i.next();
                    item.getProdutoVO().setQuantidade(item.getProdutoVO().getQuantidade() + item.getQuantidadeFornecida());
                }
                btnSair.fire();
            }
            if (p == nao) {
            }

        });

    }

    @FXML
    void btnFinalizar_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnFinalizar.fire();
        }
    }

}
