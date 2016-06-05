package br.com.compdevbooks.alphacosmetics.gui.javafx;

import java.io.IOException;

import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.FrmCliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
        BorderPane frmCliente = null;
        
        try{
            frmCliente = FXMLLoader.load(FrmCliente.class.getClassLoader().getResource("gui//FrmCliente.fxml"));
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        primaryStage.setTitle("Formulário de Manutenção de Clientes");
        primaryStage.setWidth(800);
        primaryStage.setHeight(660);
        
        Scene scene = new Scene(frmCliente);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}