package br.com.compdevbooks.alphacosmetics.entity.pessoa;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.compdevbooks.alphacosmetics.entity.endereco.CidadeEntity;

@Entity
@Table(name = "vendedor")
public class VendedorEntity extends PessoaFisicaEntity {

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CidadeEntity> listaMunicipios;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<ClienteEntity> listaClientes;

    public VendedorEntity() {
        this.listaMunicipios = new HashSet();
        this.listaClientes = new HashSet();
    }

    public VendedorEntity(String nome, String CPF, String RG) {
        super(nome, CPF, RG);
    }

    public Set<CidadeEntity> getListaMunicipios() {
        return listaMunicipios;
    }

    public void setListaMunicipios(Set<CidadeEntity> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public Set<ClienteEntity> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Set<ClienteEntity> listaClientes) {
        this.listaClientes = listaClientes;
    }

}
