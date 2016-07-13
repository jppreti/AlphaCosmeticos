package br.com.compdevbooks.alphacosmetics.entity.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;

@Entity
@Table(name = "estado")
public class EstadoEntity implements IEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(length = 2, nullable = false)
    private String UF;
    
    @Column(length = 40, nullable = false)
    private String nome;

    public EstadoEntity() {
        this.UF = "";
        this.nome = "";
    }

    public EstadoEntity(String uf, String nome) {
        this.UF = uf;
        this.nome = nome;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String uf) {
        this.UF = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome.trim() + " (" + this.UF + ")";
    }

	@Override
	public Object validar() {
		// TODO Auto-generated method stub
		return null;
	}
}
