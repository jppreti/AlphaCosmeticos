package br.com.compdevbooks.alphacosmetics.entity.produto;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import java.util.HashSet;

@Entity
@Table(name = "produto")
public class ProdutoEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(precision = 5, scale = 2, nullable = false)
    private float margemLucro;

    @Column(precision = 5, scale = 2, nullable = false)
    private float percPromocao;

    @Column(precision = 5, scale = 2, nullable = false)
    private float percComissao;

    @Column(precision = 5, scale = 2, nullable = false)
    private float valorCompra;

    @Column(nullable=false)
    private long quantidade;
    
    @Transient
    private float valorVenda;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    private CategoriaEntity categoriaVO;
/*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "fornecido", 
            joinColumns = {@JoinColumn(name = "produto")}, 
            inverseJoinColumns = {@JoinColumn(name = "fornecedor")})
    private Set<FornecedorEntity> listaFornecedores;    
    */
    private FornecedorEntity fornecedor;
    
    public ProdutoEntity(){
       // listaFornecedores= new HashSet();//verificar
    }
    public ProdutoEntity(Long Id, String nome,float mar, float pro, float com, float compra,float venda,CategoriaEntity cate, int quantidade, FornecedorEntity fornecedor ){
     super();
     this.Id=Id;
     this.nome=nome;
     this.margemLucro=mar;
     this.percComissao=com;
     this.percPromocao=pro;
     this.valorCompra=compra;
     this.valorVenda=venda;
     this.categoriaVO=cate;
     this.quantidade=quantidade;
     this.fornecedor=fornecedor;
     //this.listaFornecedores.add(fornecedor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public float getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
        this.calcularValorVenda();
    }

    public float getPercPromocao() {
        return percPromocao;
    }

    public void setPercPromocao(float percPromocao) {
        this.percPromocao = percPromocao;
        this.calcularValorVenda();
    }

    public float getPercComissao() {
        return percComissao;
    }

    public void setPercComissao(float percComissao) {
        this.percComissao = percComissao;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
        this.calcularValorVenda();
    }

    public CategoriaEntity getCategoria() {
        return getCategoriaVO();
    }
    public String getNomeCategoria(){
        return getCategoriaVO().getNome();
    }

    public void setCategoria(CategoriaEntity categoriaVO) {
        this.setCategoriaVO(categoriaVO);
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public CategoriaEntity getCategoriaVO() {
        return categoriaVO;
    }

    public void setCategoriaVO(CategoriaEntity categoriaVO) {
        this.categoriaVO = categoriaVO;
    }

    private void calcularValorVenda() {
        float tempPercMargemLucro = this.getMargemLucro();
        float tempPercPromocao = this.getPercPromocao();

        if (this.getCategoriaVO() != null && tempPercPromocao == 0) {
            tempPercPromocao = this.getCategoriaVO().getPercPromocao();
        }

        if (this.getCategoriaVO() != null && tempPercMargemLucro == 0) {
            tempPercMargemLucro = this.getCategoriaVO().getMargemLucro();
        }

        this.setValorVenda(this.getValorCompra() + (this.getValorCompra() * tempPercMargemLucro / 100));
        this.setValorVenda(this.getValorVenda() - (this.getValorVenda() * tempPercPromocao / 100));
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

	@Override
	public Object validar() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * @return the fornecedor
     */
    public FornecedorEntity getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(FornecedorEntity fornecedor) {
        this.fornecedor = fornecedor;
    }

}
