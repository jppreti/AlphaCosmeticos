package br.com.compdevbooks.alphacosmetics.gui.javafx;

import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.FrmPrincipal;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.login.FrmLogin;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.financeiro.FrmContas_a_pagar;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    public static void main(String[] args) {
        //Locale.setDefault(Locale.ENGLISH);
        Application.launch(Main.class, args);
    }
    
    /*
    @Override
    public void start(Stage primaryStage) {

        BorderPane frmPrincipal = null;

        try {
            frmPrincipal = FXMLLoader.load(FrmPrincipal.class.getClassLoader().getResource("gui\\FrmPrincipal.fxml"), ResourceBundle.getBundle("gui/i18N_pt_BR"));
            //frmPrincipal = FXMLLoader.load(FrmContas_a_pagar.class.getClassLoader().getResource("gui\\financeiro\\Contas_a_pagar.fxml"), ResourceBundle.getBundle("gui/i18N_pt_BR"));
        } catch (Exception ex) {
            System.out.println("Exception on FXMLLoader.load()");
            System.out.println(ex.getMessage());   //-- Doesn't show in stack dump
        }

        primaryStage.setTitle("Alphacosmetics System");
        // primaryStage.setWidth(1024);
        //primaryStage.setHeight(768);

        Scene scene = new Scene(frmPrincipal);
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                System.exit(0);
            }
        });

        primaryStage.show();
    }
    */
     
    //Descomentar 
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane FrmLogin = null;
        
        try {
            FrmLogin = FXMLLoader.load(FrmLogin.class.getClassLoader().getResource("gui//login//FrmLogin.fxml"), ResourceBundle.getBundle("gui/i18N_pt_BR"));
        } catch (Exception ex) {
            System.out.println("Exception on FXMLLoader.load()");
            System.out.println(ex.getMessage());  
        }

        primaryStage.setTitle("Tela de Login do Sistema");
        Scene scene = new Scene(FrmLogin);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    //Descomentar
    
    
    

}
