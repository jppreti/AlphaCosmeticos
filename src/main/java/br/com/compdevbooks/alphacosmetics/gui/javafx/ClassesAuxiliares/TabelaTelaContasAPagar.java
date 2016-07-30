/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TabelaTelaContasAPagar {

    public TabelaTelaContasAPagar() {
    }

    private String dtLancamento;
    private String dtVencimento;
    private String nome;
    private String formaPgto;

    public Long getId_venda() {
        return id_venda;
    }

    public void setId_venda(Long id_venda) {
        this.id_venda = id_venda;
    }

    public Long getId_parcela() {
        return id_parcela;
    }

    public void setId_parcela(Long id_parcela) {
        this.id_parcela = id_parcela;
    }
    private float valor;
    private String valor2;
    private String cnpj;
    private Long id_venda;
    private Long id_parcela;

    public String getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(dtLancamento);

        this.setDtLancamento(data);
    }

    public void setDtLancamento(String dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public String getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(dtVencimento);

        this.setDtVencimento(data);
    }

    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
        valor2 = String.valueOf(valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormaPgto() {
        return formaPgto;
    }

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

    /**
     * @return the valor2
     */
    public String getValor2() {
        return valor2;
    }

}
