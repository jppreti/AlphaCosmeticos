package br.com.compdevbooks.alphacosmetics.entity.produto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;

@Entity
@Table(name = "parcelacomissao")
public class ParcelaComissaoEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataVencimento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date dataPagamento;
    
    @Column(nullable = false)
    private float valorParcela;
    
    public ParcelaComissaoEntity() {
        
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
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

    public float getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
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
