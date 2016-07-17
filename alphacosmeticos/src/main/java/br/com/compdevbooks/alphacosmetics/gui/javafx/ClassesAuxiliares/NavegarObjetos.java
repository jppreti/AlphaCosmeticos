/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Josiel
 */
public abstract class NavegarObjetos {
    private static List<Node> pais= new ArrayList();
    private static VendaEntity venda;
    
    public static void setPai(Node pai){
        pais.add(0, pai);
    }
    public static Node getPai(){
        return pais.get(0);
    }
    public static void setPedidoGerenteEstoque(Node g){
        pais.add(1,g);
    }
    public static Node getPedidoGerenteEstoque(){
        return pais.get(1);
    }
    public static void setVenda(VendaEntity v){
        venda=v;
    }
    public static VendaEntity getVenda(){ 
        return venda;
    }
}
