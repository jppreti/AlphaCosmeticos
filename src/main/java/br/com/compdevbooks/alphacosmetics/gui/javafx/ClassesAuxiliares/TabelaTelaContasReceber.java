
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TabelaTelaContasReceber {

    public TabelaTelaContasReceber() {
    }

    private String dtLancamento;
    private String dtVencimento;
    private String cliente;
    private String formapgto;
    private float valor;
    private int parcela;
    private String cnpj;
    private Long id_venda;
    private Long id_parcela;
    private String valor2;

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

    public String getDtLancamento() {
        return dtLancamento;
    }

    /**
     * @param dtLancamento the dtLancamento to set
     */
    public void setDtLancamento(Date dtLancamento) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(dtLancamento);

        this.dtLancamento = data;
    }

    /**
     * @return the dtVencimento
     */
    public String getDtVencimento() {
        return dtVencimento;
    }

    /**
     * @param dtVencimento the dtVencimento to set
     */
    public void setDtVencimento(Date dtVencimento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(dtVencimento);

        this.dtVencimento = data;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the formapgto
     */
    public String getFormapgto() {
        return formapgto;
    }

    /**
     * @param formapgto the formapgto to set
     */
    public void setFormapgto(String formapgto) {
        this.formapgto = formapgto;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
        this.valor2 = String.valueOf(valor);
    }

    /**
     * @return the parcela
     */
    public int getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(int parcela) {
        this.parcela = parcela;
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
