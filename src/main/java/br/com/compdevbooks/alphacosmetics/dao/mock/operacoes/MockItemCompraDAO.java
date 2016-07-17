/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.operacoes;

import br.com.compdevbooks.alphacosmetics.dao.IItemCompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockProdutoDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class MockItemCompraDAO implements IItemCompraDAO {

    private static List<ItemCompraEntity> lista = new ArrayList();
    private static MockProdutoDAO produto = new MockProdutoDAO();

    static {
        lista.add(new ItemCompraEntity((long) 1, 10, produto.getById((long) 1)));
        lista.add(new ItemCompraEntity((long) 2, 20, produto.getById((long) 2)));
        lista.add(new ItemCompraEntity((long) 3, 15, produto.getById((long) 3)));
    }

    private static MockItemCompraDAO singleton;

    public static MockItemCompraDAO getInstance() {
        if (singleton == null) {
            singleton = new MockItemCompraDAO();
        }
        return singleton;
    }

    @Override
    public void save(ItemCompraEntity entity) {
        if (lista.indexOf(entity) < 0) {
            lista.add(entity);
        }
    }

    @Override
    public void delete(ItemCompraEntity entity) {
        lista.remove(entity);
    }

    @Override
    public ItemCompraEntity getById(Long id) {
        for (ItemCompraEntity vo : lista) {
            if (vo.getId().equals(id)) {
                return vo;
            }
        }
        return null;
    }

    @Override
    public List<ItemCompraEntity> buscarTodosItemCompra() {
        return lista;
    }

    public List<ItemCompraEntity> buscarPorProduto(Long id) {
        List<ItemCompraEntity> temp = new ArrayList();
        for (ItemCompraEntity vo : lista) {
            if (vo.getProdutoVO().getId().equals(id)) {
                temp.add(vo);
            }
        }
        return temp;
    }

    public List<ItemCompraEntity> buscarItensCompra(ItemCompraEntity ic) {

        ArrayList<ItemCompraEntity> buscado = new ArrayList<>();
        int x;

        for (ItemCompraEntity vo : lista) {
            x = 0;
            if (ic.getProdutoVO().getNome().equals("") || vo.getProdutoVO().getNome().toUpperCase().contains(ic.getProdutoVO().getNome().toUpperCase())) {
                x++;
            }
            if (ic.getProdutoVO().getCategoria() == null || ic.getProdutoVO().getCategoria().getId().equals(vo.getProdutoVO().getCategoria().getId())) {
                x++;
            }
            if (ic.getProdutoVO().getFornecedor().getFantasia().equals("") || vo.getProdutoVO().getFornecedor().getFantasia().toUpperCase().contains(ic.getProdutoVO().getFornecedor().getFantasia().toUpperCase())) {
                x++;
            }
            if (ic.getQuantidadePedida() == 0 || ic.getQuantidadePedida() <= vo.getQuantidadePedida()) {
                x++;
            }
            if (x == 4) {
                buscado.add(vo);
            }
        }
        return buscado;
    }
}
