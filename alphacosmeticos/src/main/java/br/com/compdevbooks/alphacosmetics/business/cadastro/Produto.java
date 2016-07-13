package br.com.compdevbooks.alphacosmetics.business.cadastro;

import br.com.compdevbooks.alphacosmetics.business.ABusiness;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.IProdutoDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockProdutoDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import java.util.List;

public class Produto extends ABusiness<ProdutoEntity, Exception, IProdutoDAO>{
    
    public Produto(IDAO<ProdutoEntity> dao) {
        super(dao);
    }
    
    public List<ProdutoEntity> buscarTodos(){
        return ((IProdutoDAO)dao).buscarTodosProdutos();
    }
    
}
