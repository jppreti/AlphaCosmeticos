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
import br.com.compdevbooks.alphacosmetics.entity.pagamento.PagamentoVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.VendedorEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "venda")
public class VendaEntity implements IEntity, Comparable<VendaEntity> {

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
    //alterar depois;
    @ManyToOne(fetch = FetchType.EAGER)
    private ClienteEntity clienteVO;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private VendedorEntity vendedorVO;
    
    @OneToOne(fetch = FetchType.EAGER)
    private PagamentoVendaEntity pagamentoVO;

    public VendaEntity() {
        this.listaItens = new HashSet();
    }
    
    public VendaEntity(Long id, Date lancamento, SituacaoVendaEnum sit, Set<ItemVendaEntity> lista, ClienteEntity cliente) {
        super();
        this.Id = id;
        this.dataLancamento = lancamento;
        this.situacao = sit;
        this.listaItens = lista;
        this.clienteVO = cliente;
    }
    
    public VendaEntity(Long id, Date lancamento, PagamentoVendaEntity pagamento, SituacaoVendaEnum situacao, Set<ItemVendaEntity> lista, ClienteEntity cliente, VendedorEntity vendedor) {
        super();
        this.Id = id;
        this.dataLancamento = lancamento;
        this.pagamentoVO = pagamento;
        this.situacao = situacao;
        this.listaItens = lista;
        this.clienteVO = cliente;
        this.vendedorVO = vendedor;
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

    public void setDataLancamentoString(String data) throws ParseException {
        this.dataLancamento = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(data);
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public String getDataAprovacaoString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataAprovacao);
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public String getDataRecebimString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataRecebimento);
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

    public String getNomeCliente() {
        return clienteVO.getNome();
    }

    public void setClienteVO(ClienteEntity clienteVO) {
        this.clienteVO = clienteVO;
    }

    public List<Date> getDataVencimento() {
        List<Date> datas = new ArrayList();
        for (ParcelaPagamentoEntity parcela : this.pagamentoVO.getListaParcelas()) {
            datas.add(parcela.getDataVencimento());
        }
        return datas;
    }

    public String getDataLancamentoString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataLancamento);
    }

    public float getValorTotal() {
        Iterator<ItemVendaEntity> it = listaItens.iterator();
        float valorTotal = 0;
        ItemVendaEntity item;
        while (it.hasNext()) {
            item = it.next();
            valorTotal += item.getQuantidade() * item.getProdutoVO().getValorVenda();

        }
        return valorTotal;
    }

    public float getQtdeTotal() {
        Iterator<ItemVendaEntity> it = listaItens.iterator();
        ItemVendaEntity item;
        float QtdeTotal = 0;
        while (it.hasNext()) {
            item = it.next();
            QtdeTotal += item.getQuantidade();
        }
        return QtdeTotal;
    }

    @Override
    public String toString() {
        return "";

    }

    public Set<ParcelaPagamentoEntity> getParcelas() {
        return this.pagamentoVO.getListaParcelas();
    }

    @Override
    public Object validar() {
        // TODO Auto-generated method stub
        return null;
    }

   // @Override
    //public int compareTo(VendaEntity t) {
    //    return this.getSituacao().compareTo(t.getSituacao());
        //

  //  }

    public int compareTo(VendaEntity t) {
        int retorno = 0;
        if (this == null || t == null) {
            return 0;
        }
        if(t.getDataRecebimento()==null && this.getDataRecebimento()!=null){
            return -1;
        }else if (t.getDataRecebimento()!=null &&this.getDataRecebimento()==null){
            return 1;
        }else if (t.getDataRecebimento()==null &&this.getDataRecebimento()==null){
            retorno = this.getSituacao().compareTo(t.getSituacao());
        }else{
            if (this.getDataRecebimento().after(t.getDataRecebimento())) {
                retorno = 1;
            } else if (this.getDataRecebimento().before(t.getDataRecebimento())) {
                retorno = -1;
            } else {
                retorno = this.getSituacao().compareTo(t.getSituacao());
            }
        }
        return retorno;
    }

    public VendedorEntity getVendedorVO() {
        return vendedorVO;
    }

    public void setVendedorVO(VendedorEntity vendedorVO) {
        this.vendedorVO = vendedorVO;
    }

    public PagamentoVendaEntity getPagamentoVO() {
        return pagamentoVO;
    }

    public void setPagamentoVO(PagamentoVendaEntity pagamentoVO) {
        this.pagamentoVO = pagamentoVO;
    }
}
