package br.com.compdevbooks.alphacosmetics.business.cadastro;

import br.com.compdevbooks.alphacosmetics.business.ABusiness;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.IProdutoDAO;
import br.com.compdevbooks.alphacosmetics.entity.exception.ProdutoException;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.ClassesAuxiliares.TabelaTelaProdutos;
import java.util.List;

public class Produto extends ABusiness<ProdutoEntity, ProdutoException, IProdutoDAO>{
    
    public Produto(IDAO<ProdutoEntity> dao) {
        super(dao);
    }
    
    public List<ProdutoEntity> buscarTodos(){
        return ((IProdutoDAO)dao).buscarTodosProdutos();
    }
        
    public List<ProdutoEntity> buscarProdutos(ProdutoEntity pro){
        return ((IProdutoDAO)dao).buscarProdutos(pro);
    }
    
    public ProdutoEntity buscarPorId(long id){
        return ((IProdutoDAO)dao).getById(id);
    }
    
    public List <ProdutoEntity> getByNome(String nome){
        return ((IProdutoDAO)dao).getByNome(nome);
    }

}
