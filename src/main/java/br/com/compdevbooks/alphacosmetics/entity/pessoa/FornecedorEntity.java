package br.com.compdevbooks.alphacosmetics.entity.pessoa;

import br.com.compdevbooks.alphacosmetics.entity.endereco.EnderecoEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;

@Entity
@Table(name = "fornecedor")
public class FornecedorEntity extends PessoaJuridicaEntity {

    @ManyToMany(mappedBy = "listaFornecedores", fetch = FetchType.LAZY)
    private Set<ProdutoEntity> listaProdutos;
    
    public FornecedorEntity() {
        this.listaProdutos = new HashSet();
    }

    public FornecedorEntity(Long id,String razao, String fantasia, String CNPJ, String inscricao, Set<ProdutoEntity> lista, EnderecoEntity endereco) {
        super(id, razao, fantasia, CNPJ, inscricao, endereco);
        this.listaProdutos=lista;
    }

    public Set<ProdutoEntity> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(Set<ProdutoEntity> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

}
