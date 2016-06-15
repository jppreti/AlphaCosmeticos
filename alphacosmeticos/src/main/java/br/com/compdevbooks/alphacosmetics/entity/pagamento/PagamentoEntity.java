package br.com.compdevbooks.alphacosmetics.entity.pagamento;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;

@Entity
@Table(name = "pagamento")
public class PagamentoEntity implements IEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    
    @Enumerated(EnumType.ORDINAL)
    private TipoPagamentoEnum tipoPagamento;
    
    @Enumerated(EnumType.ORDINAL)
    private SituacaoPagamentoEnum situPagamento;
    
    @OneToMany(fetch = FetchType.EAGER)
    private Set<ParcelaPagamentoEntity> listaParcelas;
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public SituacaoPagamentoEnum getSituPagamento() {
        return situPagamento;
    }

    public void setSituPagamento(SituacaoPagamentoEnum situPagamento) {
        this.situPagamento = situPagamento;
    }

    public Set<ParcelaPagamentoEntity> getListaParcelas() {
        return listaParcelas;
    }

    public void setListaParcelas(Set<ParcelaPagamentoEntity> listaParcelas) {
        this.listaParcelas = listaParcelas;
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
