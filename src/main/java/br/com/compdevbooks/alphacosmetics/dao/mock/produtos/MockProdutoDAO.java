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
        produtos.add(new ProdutoEntity((long) 1, "One Million", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 1), 30, fornecedor.getById((long) 3)));
        produtos.add(new ProdutoEntity((long) 2, "Vermelho", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 2), 50, fornecedor.getById((long) 2)));
        produtos.add(new ProdutoEntity((long) 3, "head shoulder", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 3), 40, fornecedor.getById((long) 3)));
        produtos.add(new ProdutoEntity((long) 4, "Montelukast Sodium", (float) 66.49, (float) 97.74, (float) 54.79, (float) 88.03, (float) 87.4, cat.getById((long) 3), 779, fornecedor.getById((long) 5)));
        produtos.add(new ProdutoEntity((long) 5, "Chlorpheniramine maleate", (float) 41.53, (float) 3.86, (float) 46.34, (float) 13.37, (float) 28.73, cat.getById((long) 1), 766, fornecedor.getById((long) 5)));
        produtos.add(new ProdutoEntity((long) 6, "Octinoxate and Titanium Dioxide", (float) 23.33, (float) 52.53, (float) 72.11, (float) 88.62, (float) 16.7, cat.getById((long) 2), 608, fornecedor.getById((long) 2)));
        produtos.add(new ProdutoEntity((long) 7, "fluocinolone acetonide", (float) 26.35, (float) 51.41, (float) 18.09, (float) 5.64, (float) 86.2, cat.getById((long) 1), 832, fornecedor.getById((long) 7)));
        produtos.add(new ProdutoEntity((long) 8, "diltiazem hydrochloride", (float) 99.44, (float) 97.49, (float) 20.63, (float) 57.82, (float) 51.2, cat.getById((long) 2), 256, fornecedor.getById((long) 6)));
        produtos.add(new ProdutoEntity((long) 9, "TETRAHYDROZOLINE HYDROCHLORIDE", (float) 69.01, (float) 48.74, (float) 40.35, (float) 10.44, (float) 83.45, cat.getById((long) 2), 457, fornecedor.getById((long) 3)));
        produtos.add(new ProdutoEntity((long) 10, "Acetaminophen", (float) 98.51, (float) 46.85, (float) 39.01, (float) 32.16, (float) 24.39, cat.getById((long) 3), 407, fornecedor.getById((long) 3)));
        produtos.add(new ProdutoEntity((long) 11, "Bamboo Rosemary", (float) 62.67, (float) 73.26, (float) 43.06, (float) 26.53, (float) 7.63, cat.getById((long) 1), 719, fornecedor.getById((long) 5)));
        produtos.add(new ProdutoEntity((long) 12, "SODIUM MONOFLUOROPHOSPHATE", (float) 19.21, (float) 12.73, (float) 67.67, (float) 64.24, (float) 86.33, cat.getById((long) 3), 677, fornecedor.getById((long) 7)));
        produtos.add(new ProdutoEntity((long) 13, "Eszopiclone", (float) 20.95, (float) 34.34, (float) 42.31, (float) 62.86, (float) 17.84, cat.getById((long) 3), 876, fornecedor.getById((long) 2)));
        produtos.add(new ProdutoEntity((long) 14, "NEEM OIL, TEA TREE OIL", (float) 82.22, (float) 40.08, (float) 70.55, (float) 97.55, (float) 65.3, cat.getById((long) 2), 762, fornecedor.getById((long) 1)));
        produtos.add(new ProdutoEntity((long) 15, "OCTINOXATE and TITANIUM DIOXIDE", (float) 45.43, (float) 52.87, (float) 82.26, (float) 90.45, (float) 17.45, cat.getById((long) 1), 159, fornecedor.getById((long) 1)));
        produtos.add(new ProdutoEntity((long) 16, "Triclosan", (float) 68.66, (float) 95.64, (float) 92.41, (float) 31.02, (float) 63.46, cat.getById((long) 2), 873, fornecedor.getById((long) 3)));
        produtos.add(new ProdutoEntity((long) 17, "Clobetasol Propionate", (float) 27.84, (float) 51.51, (float) 96.88, (float) 85.47, (float) 87.34, cat.getById((long) 1), 184, fornecedor.getById((long) 4)));
        produtos.add(new ProdutoEntity((long) 18, "Octinoxate and Zinc Oxide", (float) 97.02, (float) 62.49, (float) 90.87, (float) 62.87, (float) 81.71, cat.getById((long) 1), 110, fornecedor.getById((long) 4)));
         

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
