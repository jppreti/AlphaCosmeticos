/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TabelaTelaContasAPagar {
    
    public TabelaTelaContasAPagar(){}
    
    private String dtLancamento;
    private String dtVencimento;
    private String nome;
    private String formaPgto;
    private float valor;
    private String cnpj;

    public String getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(dtLancamento);

        this.setDtLancamento(data);
    }

    public String getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(dtVencimento);

        this.setDtVencimento(data);
    }


    
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @param dtLancamento the dtLancamento to set
     */
    public void setDtLancamento(String dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    /**
     * @param dtVencimento the dtVencimento to set
     */
    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the formaPgto
     */
    public String getFormaPgto() {
        return formaPgto;
    }

    /**
     * @param formaPgto the formaPgto to set
     */
    public void setFormaPgto(String formaPgto) {
        this.formaPgto = formaPgto;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
