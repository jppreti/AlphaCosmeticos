package br.com.compdevbooks.alphacosmetics.entity.pessoa;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoVO;

@Entity
@Table(name = "fornecedor")
public class FornecedorEntity extends PessoaJuridicaEntity {

    @ManyToMany(mappedBy = "listaFornecedores", fetch = FetchType.LAZY)
    private Set<ProdutoVO> listaProdutos;

    public FornecedorEntity() {
        this.listaProdutos = new HashSet();
    }

    public FornecedorEntity(Long id,String razao, String fantasia, String CNPJ, String inscricao, Set<ProdutoVO> lista) {
        super(id, razao, fantasia, CNPJ, inscricao);
        this.listaProdutos=lista;
    }

    public Set<ProdutoVO> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(Set<ProdutoVO> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

}
