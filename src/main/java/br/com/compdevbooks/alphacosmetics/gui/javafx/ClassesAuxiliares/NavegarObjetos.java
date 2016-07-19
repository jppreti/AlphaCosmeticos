/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
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
    private static Node pais;
    private static Node pedidoGerenteEstoque;
    private static Node pedidoCompra;
    private static VendaEntity venda;
    private static CompraEntity compra;
    
    public static void setPai(Node pai){
        pais=pai;
    }
    public static Node getPai(){
        return pais;
    }
    public static void setPedidoGerenteEstoque(Node g){
        pedidoGerenteEstoque=g;
    }
    public static Node getPedidoGerenteEstoque(){
        return pedidoGerenteEstoque;
    }
    public static void setVenda(VendaEntity v){
        venda=v;
    }
    public static VendaEntity getVenda(){ 
        return venda;
    }
    public static void setPedidoCompra(Node g){
        pedidoCompra=g;
    }
    public static Node getPedidoCompra(){
        return pedidoCompra;
    }
    public static void setCompra(CompraEntity c){
        compra=c;
    }
    public static CompraEntity getCompra(){
        return compra;
    }
    
}
