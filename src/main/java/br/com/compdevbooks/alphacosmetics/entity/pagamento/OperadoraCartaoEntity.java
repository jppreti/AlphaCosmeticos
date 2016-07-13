package br.com.compdevbooks.alphacosmetics.entity.pagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;

@Entity
@Table(name = "bandeiracartao")
public class OperadoraCartaoEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(length = 20, nullable = false)
    private String nome;

    public OperadoraCartaoEntity() {
        this.nome = "";
    }

    public OperadoraCartaoEntity(String nome) {
        this.nome = nome;
    }

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

    @Override
    public String toString() {
        return this.nome.trim();
    }

	@Override
	public Object validar() {
		// TODO Auto-generated method stub
		return null;
	}
}
