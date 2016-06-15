package br.com.compdevbooks.alphacosmetics.entity.pessoa;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;
import br.com.compdevbooks.alphacosmetics.entity.endereco.EnderecoEntity;
import br.com.compdevbooks.alphacosmetics.entity.endereco.TelefoneEntity;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PessoaEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    @Column(length = 50, nullable = false)
    protected String nome;
    //@Embedded
    protected EnderecoEntity enderecoVO;
    //@ElementCollection
    @CollectionTable(
            name="telefonepessoa",
            joinColumns=@JoinColumn(name="pessoa_fone"),
            uniqueConstraints= @UniqueConstraint(columnNames={"pessoa_fone", "numero"})
    )    
    private Set<TelefoneEntity> listaFone;
    
    public PessoaEntity() {
        this.listaFone = new HashSet();
    }

    public PessoaEntity(String nome) {
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

    public EnderecoEntity getEnderecoVO() {
        return enderecoVO;
    }

    public void setEnderecoVO(EnderecoEntity EnderecoVO) {
        this.enderecoVO = EnderecoVO;
    }

    public Set<TelefoneEntity> getListaFone() {
        return listaFone;
    }

    public void setListaFone(Set<TelefoneEntity> listaFone) {
        this.listaFone = listaFone;
    } 

    @Override
    public String toString() {
        return this.nome;
    }

}
