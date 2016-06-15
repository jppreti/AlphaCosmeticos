package br.com.compdevbooks.alphacosmetics.entity.pagamento;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;

@Entity
@Table(name = "parcelapagamento")
public class ParcelaPagamentoEntity implements IEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private DocumentoPagamentoEntity documentoPagamento;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataOperacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPagamento;
    
    @Column(scale = 2)
    private double valorOriginal;
    
    @Column(scale = 2)
    private double valorDesconto;
    
    @Column(scale = 2)
    private double valorJuro;
    
    @Column(scale = 2)
    private double valorMulta;
    
    @Column(scale = 2)
    private double valorTotalPago;
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public DocumentoPagamentoEntity getDocumentoPagamento() {
        return documentoPagamento;
    }

    public void setDocumentoPagamento(DocumentoPagamentoEntity documentoPagamento) {
        this.documentoPagamento = documentoPagamento;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorJuro() {
        return valorJuro;
    }

    public void setValorJuro(double valorJuro) {
        this.valorJuro = valorJuro;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public double getValorTotalPago() {
        return valorTotalPago;
    }

    public void setValorTotalPago(double valorTotalPago) {
        this.valorTotalPago = valorTotalPago;
    }

    @Override
    public String toString() {
        return "";
    }

	@Override
	public Object validar() {
		// TODO Auto-generated method stub
		return null;
	}
}
