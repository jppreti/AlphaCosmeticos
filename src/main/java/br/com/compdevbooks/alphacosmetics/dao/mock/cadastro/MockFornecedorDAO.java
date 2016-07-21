/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.cadastro;

import br.com.compdevbooks.alphacosmetics.dao.IFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.endereco.MockBairroDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockProdutoDAO;
import br.com.compdevbooks.alphacosmetics.entity.endereco.EnderecoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Josiel
 */
public class MockFornecedorDAO implements IFornecedorDAO {

    private static List<FornecedorEntity> lista = new ArrayList();
    private static MockProdutoDAO produto = new MockProdutoDAO();

    private static MockBairroDAO bairro = new MockBairroDAO();
    private static Set<ProdutoEntity> listaProduto;
    private static EnderecoEntity endereco = new EnderecoEntity("Rua das araras", 332, "1029,68638-000", bairro.getById((long) 2));

    static {
        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long) 8));
        listaProduto.add(produto.getById((long) 15));
        listaProduto.add(produto.getById((long) 17));
        listaProduto.add(produto.getById((long) 6));
        listaProduto.add(produto.getById((long) 1));
        listaProduto.add(produto.getById((long) 7));
        listaProduto.add(produto.getById((long) 5));
        lista.add(new FornecedorEntity((long) 1, "Blogpad", "Paul Hudson", "001", "001", listaProduto, endereco));

        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long) 1));
        listaProduto.add(produto.getById((long) 18));
        listaProduto.add(produto.getById((long) 3));
        listaProduto.add(produto.getById((long) 8));
        listaProduto.add(produto.getById((long) 1));
        listaProduto.add(produto.getById((long) 4));
        lista.add(new FornecedorEntity((long) 2, "Meevee", "Ernest Wheeler", "002", "002", listaProduto, endereco));

        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long) 15));
        listaProduto.add(produto.getById((long) 9));
        listaProduto.add(produto.getById((long) 11));
        listaProduto.add(produto.getById((long) 8));
        listaProduto.add(produto.getById((long) 1));
        listaProduto.add(produto.getById((long) 18));
        lista.add(new FornecedorEntity((long) 3, "Jaxnation", "Ernest Ford", "003", "003", listaProduto, endereco));
        
        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long) 10));
        listaProduto.add(produto.getById((long) 18));
        listaProduto.add(produto.getById((long) 5));
        listaProduto.add(produto.getById((long) 13));
        listaProduto.add(produto.getById((long) 15));
        lista.add(new FornecedorEntity((long) 4, "Abata", "Robert Ward", "004", "004", listaProduto, endereco));

        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long) 11));
        listaProduto.add(produto.getById((long) 14));
        listaProduto.add(produto.getById((long) 5));
        listaProduto.add(produto.getById((long) 1));
        listaProduto.add(produto.getById((long) 2));
        listaProduto.add(produto.getById((long) 7));
        listaProduto.add(produto.getById((long) 2));
        listaProduto.add(produto.getById((long) 13));
        listaProduto.add(produto.getById((long) 1));
        listaProduto.add(produto.getById((long) 8));
        listaProduto.add(produto.getById((long) 10));
        lista.add(new FornecedorEntity((long) 5, "Meedoo", "Lawrence Hart", "005", "005", listaProduto, endereco));

        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long) 18));
        listaProduto.add(produto.getById((long) 13));
        listaProduto.add(produto.getById((long) 3));
        listaProduto.add(produto.getById((long) 1));
        listaProduto.add(produto.getById((long) 12));
        listaProduto.add(produto.getById((long) 17));
        listaProduto.add(produto.getById((long) 11));
        lista.add(new FornecedorEntity((long) 6, "Flashset", "Anne Ford", "006", "006", listaProduto, endereco));
        
        listaProduto = new HashSet();
        listaProduto.add(produto.getById((long) 8));
        listaProduto.add(produto.getById((long) 18));
        listaProduto.add(produto.getById((long) 13));
        lista.add(new FornecedorEntity((long) 7, "Wordpedia", "Jessica Franklin", "007", "007", listaProduto, endereco));
         
    }

    private static MockFornecedorDAO singleton = null;

    public MockFornecedorDAO() {
    }

    public static MockFornecedorDAO getInstance() {
        if (singleton == null) {
            singleton = new MockFornecedorDAO();
        }

        return singleton;
    }

    @Override
    public void save(FornecedorEntity entity) {
        if (lista.indexOf(entity) < 0) {
            lista.add(entity);
        }
    }

    @Override
    public void delete(FornecedorEntity entity) {
        lista.remove(entity);
    }

    @Override
    public FornecedorEntity getById(Long id) {
        for (FornecedorEntity vo : lista) {
            if (vo.getId().equals(id)) {
                return vo;
            }
        }
        return null;
    }

    @Override
    public FornecedorEntity getByNome(String nome) {
        for (FornecedorEntity vo : lista) {
            if (vo.getFantasia().toUpperCase().contains(nome.toUpperCase())) {
                return vo;
            }
        }
        return null;
    }

    @Override
    public List<FornecedorEntity> buscarTodosFornecedores() {
        return lista;
    }
}
