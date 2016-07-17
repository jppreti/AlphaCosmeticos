/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.produtos;

import br.com.compdevbooks.alphacosmetics.dao.IProdutoDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class MockProdutoDAO implements IProdutoDAO {

    private static List<ProdutoEntity> produtos = new ArrayList<>();
    private static MockCategoriaDAO cat = new MockCategoriaDAO();
    private static MockFornecedorDAO fornecedor = new MockFornecedorDAO();

    static {
        produtos.add(new ProdutoEntity((long) 1, "One Million", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 1), 30, fornecedor.getById((long) 1)));
        produtos.add(new ProdutoEntity((long) 2, "Vermelho", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 2), 40, fornecedor.getById((long) 2)));
        produtos.add(new ProdutoEntity((long) 3, "head shoulder", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 3), 50, fornecedor.getById((long) 3)));
        //verificar 

    }

    public MockProdutoDAO() {
    }
    private static MockProdutoDAO singleton;

    public static MockProdutoDAO getInstace() {
        if (singleton == null) {
            singleton = new MockProdutoDAO();
        }
        return singleton;
    }

    @Override
    public void save(ProdutoEntity entity) {
        if (produtos.indexOf(entity) < 0) {
            produtos.add(entity);
        }
    }

    @Override
    public void delete(ProdutoEntity entity) {
        produtos.remove(entity);
    }

    @Override
    public ProdutoEntity getById(Long id) {
        for (ProdutoEntity vo : produtos) {
            if (vo.getId().equals(id)) {
                return vo;
            }
        }
        return null;
    }

    public List<ProdutoEntity> buscarTodosProdutos() {
        return produtos;
    }

    public List<ProdutoEntity> buscarProdutos(ProdutoEntity pro) {
        ArrayList<ProdutoEntity> buscado = new ArrayList<>();
        int x;

        for (ProdutoEntity vo : produtos) {
            x = 0;
            if (pro.getNome().equals("") || vo.getNome().toUpperCase().contains(pro.getNome().toUpperCase())) {
                x++;
            }
            if (pro.getCategoria() == null || pro.getCategoria().getId().equals(vo.getCategoria().getId())) {
                x++;
            }
            if (pro.getFornecedor().getFantasia().equals("") || vo.getFornecedor().getFantasia().toUpperCase().contains(pro.getFornecedor().getFantasia().toUpperCase())) {
                x++;
            }
            if (pro.getQuantidade() == 0 || pro.getQuantidade() <= vo.getQuantidade()) {
                x++;
            }

            if (x == 4) {
                buscado.add(vo);
            }
        }
        return buscado;
    }
}
