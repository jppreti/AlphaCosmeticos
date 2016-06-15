package br.com.compdevbooks.alphacosmetics.entity.endereco;

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
@Table(name = "bairro")
public class BairroEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(length = 40, nullable = false)
    private String nome;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    private CidadeEntity cidadeVO;

    public BairroEntity() {
       
    }

    public BairroEntity(String nome, CidadeEntity cidadeVO) {
        this.cidadeVO = cidadeVO;
        this.nome = nome;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CidadeEntity getCidadeVO() {
        return cidadeVO;
    }

    public void setCidadeVO(CidadeEntity cidadeVO) {
        this.cidadeVO = cidadeVO;
    }

    @Override
    public String toString() {
        return this.nome.trim()+", "+this.cidadeVO;
    }

	@Override
	public Object validar() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
