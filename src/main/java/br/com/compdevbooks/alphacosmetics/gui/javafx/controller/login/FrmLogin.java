package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.login;


import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.FrmPrincipal;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.cadastro.FrmCliente;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FrmLogin {

    @FXML
    private Text mensagem;

    @FXML
    private Text Titulo;

    @FXML
    void button_cadastrar(ActionEvent event) {

    }

    @FXML
    void button_entrar(ActionEvent event) {
        BorderPane frmPrincipal = null;
        Stage primaryStage = new Stage();
        try {
            frmPrincipal = FXMLLoader.load(FrmPrincipal.class.getClassLoader().getResource("gui\\FrmPrincipal.fxml"), ResourceBundle.getBundle("gui/i18N_pt_BR"));
        } catch (Exception ex) {
            System.out.println("Exception on FXMLLoader.load()");
            System.out.println(ex.getMessage());   
        }
        
        primaryStage.setTitle("Alphacosmetics System");

        Scene scene = new Scene(frmPrincipal);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void button_sair(ActionEvent event) {
        System.exit(0);
    }

}
