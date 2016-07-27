package br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TabelaTelaComissao {
    private Long id;
    private String nome;
    private String valor;
    private String ValorComissaoRelatorio;
    private String dataVenda;
    private String dataPrevista;
    private String valorVenda;
    private String cliente;
    private String SituacaoParcela;
    
    public String getSituacaoParcela() {
        return SituacaoParcela;
    }

    public void setSituacaoParcela(String SituacaoParcela) {
        this.SituacaoParcela = SituacaoParcela;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data2 = sdf.format(dataVenda);
        this.dataVenda = data2;
    }
    
    
    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getValorComissaoRelatorio() {
        return ValorComissaoRelatorio;
    }

    public void setValorComissaoRelatorio(String ValorComissaoRelatorio) {
        this.ValorComissaoRelatorio = ValorComissaoRelatorio;
    }

    /**
     * @return the dataPrevista
     */
    public String getDataPrevista() {
       // System.out.println(dataPrevista+" metodo tabela");
        return dataPrevista;
    }

    /**
     * @param dataPrevista the dataPrevista to set
     */
    public void setDataPrevista(Date dataPrevista) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data2 = sdf.format(dataPrevista);
        this.dataPrevista = data2;
        
    }


}
