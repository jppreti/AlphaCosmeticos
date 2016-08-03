package br.com.compdevbooks.alphacosmetics.gui.javafx.controller.login;

import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.FrmPrincipal;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import br.com.compdevbooks.alphacosmetics.gui.javafx.Main;
import javafx.scene.control.Alert;

public class FrmLogin {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Text mensagem;

    @FXML
    private Text Titulo;
    

    @FXML
    void button_cadastrar(ActionEvent event) {

    }

    void chama_tela_login(){
        BorderPane frmPrincipal = null;
        Stage primaryStage = new Stage();
        try {
            frmPrincipal = FXMLLoader.load(FrmPrincipal.class.getClassLoader().getResource("gui\\FrmPrincipal.fxml"), ResourceBundle.getBundle("gui/i18N_pt_BR"));
        } catch (Exception ex) {
            System.out.println("Exception on FXMLLoader.load()");
            System.out.println(ex.getMessage());   
        }
        
        primaryStage.setTitle("Tela Principal do Sistema");

        Scene scene = new Scene(frmPrincipal);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    @FXML
    void button_entrar(ActionEvent event) {
        if(txtLogin.getText().equals("admin") &&
           txtSenha.getText().equals("admin")){
            chama_tela_login();
            Main.login.close();//Fecha a Tela de Login
            
        }else{
            tratamento_login_senha();
        }   
    }
    
    void tratamento_login_senha(){
        if(txtLogin.getText().equals("") &&
           !txtSenha.getText().equals("")){
            /*
            JOptionPane.showMessageDialog(null,"O Login deve ser informado"
            ,"Erro ao Logar no Sistema",
            JOptionPane.ERROR_MESSAGE); 
            */
            Alert msg_erro = new Alert(Alert.AlertType.ERROR);
            msg_erro.setTitle("Erro ao Logar no Sistema");
            msg_erro.setHeaderText("O Login deve ser informado");
            msg_erro.setContentText("Por favor forneça o Login");
            msg_erro.showAndWait();
        }
        
        if(txtSenha.getText().equals("") &&
           !txtLogin.getText().equals("")){
            /*
            JOptionPane.showMessageDialog(null,"A senha deve ser informada"
            ,"Erro ao Logar no Sistema",
            JOptionPane.ERROR_MESSAGE);
            */
            Alert msg_erro = new Alert(Alert.AlertType.ERROR);
            msg_erro.setTitle("Erro ao Logar no Sistema");
            msg_erro.setHeaderText("A senha deve ser informada");
            msg_erro.setContentText("Por favor forneça a Senha");
            msg_erro.showAndWait();
        }
        
        if(txtLogin.getText().equals("") && 
            txtSenha.getText().equals("")){
            /* 
            JOptionPane.showMessageDialog(null,"O Login e a Senha devem ser informados"
             ,"Erro ao Logar no Sistema",
             JOptionPane.ERROR_MESSAGE); 
            */
            Alert msg_erro = new Alert(Alert.AlertType.ERROR);
            msg_erro.setTitle("Erro ao Logar no Sistema");
            msg_erro.setHeaderText("A Senha e o Login devem ser informados");
            msg_erro.setContentText("Por favor forneça a Senha e o Login");
            msg_erro.showAndWait();
            }
        
        if(!txtLogin.getText().equals("") && 
            !txtSenha.getText().equals("")){
            /* 
            JOptionPane.showMessageDialog(null,"Login e Senha Inválidos!"
             ,"Erro ao Logar no Sistema",
             JOptionPane.ERROR_MESSAGE);
             */
            Alert msg_erro = new Alert(Alert.AlertType.ERROR);
            msg_erro.setTitle("Erro ao Logar no Sistema");
            msg_erro.setHeaderText("Login e Senha Inválidos");
            msg_erro.setContentText("Por favor forneça um Login e Senha Válidos");
            msg_erro.showAndWait();
            }     
    }
   
    
    @FXML
    void button_sair(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Deseja Realmente Sair do Sistema?", 
            "Sair do Sistema", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) { 
              System.exit(0);
            }
        
    }

}
