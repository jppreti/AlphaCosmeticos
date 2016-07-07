package br.com.compdevbooks.alphacosmetics.entity.produto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;

@Entity
@Table(name = "itemvenda")
public class ItemVendaEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @Column(nullable = false)
    private int quantidade;
    
    @Column(precision = 5, scale = 2, nullable = false)
    private float percPromocao;

    @Column(precision = 5, scale = 2, nullable = false)
    private float percComissao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    private ProdutoVO produtoVO;
    
    public ItemVendaEntity(){}
    
    public ItemVendaEntity(Long id, int qtde, float pro, float com, ProdutoVO produto){
        this.Id=id;
        this.quantidade=qtde;
        this.percPromocao=pro;
        this.percComissao=com;
        this.produtoVO=produto;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoVO getProdutoVO() {
        return produtoVO;
    }

    public void setProdutoVO(ProdutoVO produtoVO) {
        this.produtoVO = produtoVO;
    }

    public float getPercPromocao() {
        return percPromocao;
    }

    public void setPercPromocao(float percPromocao) {
        this.percPromocao = percPromocao;
    }

    public float getPercComissao() {
        return percComissao;
    }

    public void setPercComissao(float percComissao) {
        this.percComissao = percComissao;
    }
    
    private float calcularSubtotal() {
        return this.quantidade * this.produtoVO.getValorVenda();
    }

    @Override
    public String toString() {
        return this.produtoVO.getNome() + " - "+this.quantidade+" - "+this.calcularSubtotal();
    }

	@Override
	public Object validar() {
		// TODO Auto-generated method stub
		return null;
	}
}
