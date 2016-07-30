package br.com.compdevbooks.alphacosmetics.entity.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class CategoriaEntity implements IEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    @Column(length = 30, nullable = false)
    private String nome;
    
    private CategoriaEntity superCat;
    
    public CategoriaEntity(){}
    
    public CategoriaEntity(Long id, String nome, CategoriaEntity superCat){
        this.Id=id;
        this.nome=nome;
        this.superCat=superCat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public CategoriaEntity getSuperCat() {
        return superCat;
    }

    public void setSuperCat(CategoriaEntity superCat) {
        this.superCat = superCat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaEntity other = (CategoriaEntity) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
    
}
