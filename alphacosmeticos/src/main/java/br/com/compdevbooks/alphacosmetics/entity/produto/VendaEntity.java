package br.com.compdevbooks.alphacosmetics.entity.produto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.PagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;

@Entity
@Table(name = "venda")
public class VendaEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataLancamento;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRecebimento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAprovacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProcessamento;
    
    @Enumerated(EnumType.ORDINAL)
    private SituacaoVendaEnum situacao;
    
    @OneToMany(fetch = FetchType.LAZY)
    private Set<ItemVendaEntity> listaItens;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private ClienteEntity clienteVO;
    
    @OneToOne(fetch = FetchType.EAGER)
    private PagamentoEntity pagamentoVO;

    public VendaEntity() {
        this.listaItens = new HashSet();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(Date dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public SituacaoVendaEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoVendaEnum situacao) {
        this.situacao = situacao;
    }

    public Set<ItemVendaEntity> getListaItens() {
        return listaItens;
    }

    public void setListaItens(Set<ItemVendaEntity> listaItens) {
        this.listaItens = listaItens;
    }

    public ClienteEntity getClienteVO() {
        return clienteVO;
    }

    public void setClienteVO(ClienteEntity clienteVO) {
        this.clienteVO = clienteVO;
    }

    public PagamentoEntity getPagamentoVO() {
        return pagamentoVO;
    }

    public void setPagamentoVO(PagamentoEntity pagamentoVO) {
        this.pagamentoVO = pagamentoVO;
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
