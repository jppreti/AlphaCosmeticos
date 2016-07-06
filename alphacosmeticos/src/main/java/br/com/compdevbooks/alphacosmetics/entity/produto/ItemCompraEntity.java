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
@Table(name = "itemcompra")
public class ItemCompraEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @Column(nullable = false)
    private int quantidadePedida;

    @Column(nullable = true)
    private int quantidadeFornecida;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    private ProdutoVO produtoVO;
    
    public ItemCompraEntity(Long id, int qtdePedida,ProdutoVO produto){
        this.Id=id;
        this.quantidadePedida=qtdePedida;
        this.produtoVO=produto;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public int getQuantidadePedida() {
        return quantidadePedida;
    }

    public void setQuantidadePedida(int quantidadePedida) {
        this.quantidadePedida = quantidadePedida;
    }

    public int getQuantidadeFornecida() {
        return quantidadeFornecida;
    }

    public void setQuantidadeFornecida(int quantidadeFornecida) {
        this.quantidadeFornecida = quantidadeFornecida;
    }

    public ProdutoVO getProdutoVO() {
        return produtoVO;
    }

    public void setProdutoVO(ProdutoVO produtoVO) {
        this.produtoVO = produtoVO;
    }
    
    private float calcularSubtotal() {
        return this.quantidadePedida * this.produtoVO.getValorCompra();
    }

    @Override
    public String toString() {
        return this.produtoVO.getNome() + " - "+this.quantidadePedida+" - "+this.calcularSubtotal();
    }

	@Override
	public Object validar() {
		// TODO Auto-generated method stub
		return null;
	}
}
