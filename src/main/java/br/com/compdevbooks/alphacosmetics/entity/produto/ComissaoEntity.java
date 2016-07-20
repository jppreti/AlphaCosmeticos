package br.com.compdevbooks.alphacosmetics.entity.produto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.VendedorEntity;

@Entity
@Table(name = "comissao")
public class ComissaoEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataVenda;
    
    @OneToOne(fetch = FetchType.EAGER)
    private VendaEntity venda;
    
    @OneToOne(fetch = FetchType.EAGER)
    private VendedorEntity vendedor;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<ParcelaComissaoEntity> listaParcelaComissao;
    
    public ComissaoEntity(Long Id, Date dataVenda){
        this.Id = Id;
        this.dataVenda=dataVenda;
        
    }
    
    public ComissaoEntity() {
        this.listaParcelaComissao = new HashSet();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public VendaEntity getVenda() {
        return venda;
    }

    public void setVenda(VendaEntity venda) {
        this.venda = venda;
    }

    public VendedorEntity getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorEntity vendedor) {
        this.vendedor = vendedor;
    }

    public Set<ParcelaComissaoEntity> getListaParcelaComissao() {
        return listaParcelaComissao;
    }

    public void setListaParcelaComissao(Set<ParcelaComissaoEntity> listaParcelaComissao) {
        this.listaParcelaComissao = listaParcelaComissao;
    }

    
    public boolean isValido() {
        boolean resp = false;

        return resp;
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
