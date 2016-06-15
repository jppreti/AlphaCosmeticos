package br.com.compdevbooks.alphacosmetics.entity.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;

@Entity
@Table(name = "categoria")
public class CategoriaEntity implements IEntity {
    
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
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

    @Override
    public String toString() {
        return this.nome;
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
    
}
