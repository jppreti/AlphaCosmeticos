package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Comparator;

/**
 *
 * @author Daniel
 */
public class ComparaDoisCriterios implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        int retorno =0;
        if(o1==null || o2==null){
            return 0;
        }
        TabelaTelaEstoque ob1 = (TabelaTelaEstoque) o1;
        TabelaTelaEstoque ob2 = (TabelaTelaEstoque) o2;
        if(ob1.getProduto().getQuantidade()<=15 && ob2.getProduto().getQuantidade()>15){
            retorno=1;
        } else if (ob2.getProduto().getQuantidade()<=15 && ob1.getProduto().getQuantidade()>15){
            retorno=-1 ;
        } else{
           retorno = ob1.getProduto().getNome().compareTo(ob2.getProduto().getNome());
        }
        
        return retorno;
    }
}
