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
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

@Entity
@Table(name = "compra")
public class CompraEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataLancamento;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvio;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRecebimento;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProcessamento;
    
    @Enumerated(EnumType.ORDINAL)
    private SituacaoCompraEnum situacao;
    
    @OneToMany(fetch = FetchType.LAZY)
    private Set<ItemCompraEntity> listaItens;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private FornecedorEntity fornecedorVO;
    
    @OneToOne(fetch = FetchType.EAGER)
    private PagamentoEntity pagamentoVO;

    public CompraEntity() {
        this.listaItens = new HashSet();
    }
    public CompraEntity(Long Id, Date data, FornecedorEntity fornecedor, PagamentoEntity pagamento,SituacaoCompraEnum sit, Set<ItemCompraEntity> lista){
        super();
        this.Id=Id;
        this.dataLancamento=data;
        this.fornecedorVO=fornecedor;
        this.pagamentoVO=pagamento;
        this.situacao=sit;
        this.listaItens=lista;
    }
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

      public String getNomeFornecedor(){
        return fornecedorVO.getFantasia();
    }
    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
     public void setDataLancamentoString(String data) throws ParseException{
        this.dataLancamento= (Date)new SimpleDateFormat("dd/MM/yyyy").parse(data);
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
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

    public SituacaoCompraEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCompraEnum situacao) {
        this.situacao = situacao;
    }

    public Set<ItemCompraEntity> getListaItens() {
        return listaItens;
    }

    public void setListaItens(Set<ItemCompraEntity> listaItens) {
        this.listaItens = listaItens;
    }

    public FornecedorEntity getFornecedorVO() {
        return fornecedorVO;
    }

    public void setFornecedorVO(FornecedorEntity fornecedorVO) {
        this.fornecedorVO = fornecedorVO;
    }

    public PagamentoEntity getPagamentoVO() {
        return pagamentoVO;
    }

    public void setPagamentoVO(PagamentoEntity pagamentoVO) {
        this.pagamentoVO = pagamentoVO;
    }
    public String getDataLancamentoString(){
        return new SimpleDateFormat("dd/MM/yyyy").format(this.dataLancamento);
    }
    public float getValorTotal(){
        Iterator<ItemCompraEntity> i= listaItens.iterator();
        float vT=0;
        ItemCompraEntity item=null;
        while(i.hasNext()){
            item=i.next();
            vT+=item.getQuantidadePedida()*item.getProdutoVO().getValorCompra();
        }
        return vT;
    }
    public float getQtdeTotal(){
        Iterator<ItemCompraEntity> i= listaItens.iterator();
        float qtdeT=0;
        ItemCompraEntity item=null;
        while(i.hasNext()){
            item=i.next();
            qtdeT+=item.getQuantidadePedida();
        }
        return qtdeT;
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
