package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import java.util.List;

/**
 *
 * @author Josiel
 */
public interface IProdutoDAO extends IDAO<ProdutoEntity> {
    
    List<ProdutoEntity> getByNome(String nome);
    
    public List<ProdutoEntity> buscarTodosProdutos();

    public List<ProdutoEntity> buscarProdutos(ProdutoEntity pro);
}
