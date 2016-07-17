/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.pagamento;

import br.com.compdevbooks.alphacosmetics.dao.IOperadoraDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.OperadoraCartaoEntity;
import java.util.ArrayList;
import static java.util.Collections.singleton;
import java.util.List;

public class MockOperadoraDAO implements IOperadoraDAO {

    private static List<OperadoraCartaoEntity> listaOperadora = new ArrayList<>();

    static {
        OperadoraCartaoEntity operadora = new OperadoraCartaoEntity();

        operadora.setId((long) 1);
        operadora.setNome("Visa");
        listaOperadora.add(operadora);

        operadora.setId((long) 2);
        operadora.setNome("Elo");
        listaOperadora.add(operadora);

        operadora.setId((long) 3);
        operadora.setNome("MasterCard");
        listaOperadora.add(operadora);

    }
    private static MockOperadoraDAO singleton;
    
    public MockOperadoraDAO() { }

    public static MockOperadoraDAO getInstance() {
        if (singleton == null) {
            singleton = new MockOperadoraDAO();
        }

        return singleton;
    }

    @Override
    public List<OperadoraCartaoEntity> buscarTodasOperadoras() {
        return listaOperadora;
    }

    @Override
    public void save(OperadoraCartaoEntity entity) {
        if (listaOperadora.indexOf(entity) < 0) {
            listaOperadora.add(entity);
        }
    }

    @Override
    public void delete(OperadoraCartaoEntity entity) {
        listaOperadora.remove(entity);
    }

    @Override
    public OperadoraCartaoEntity getById(Long id) {

        for (OperadoraCartaoEntity vo : listaOperadora) {
            if (vo.getId().equals(id)) {
                return vo;
            }
        }
        return null;
    }

    @Override
    public OperadoraCartaoEntity getByNome(String nome) {

        for (OperadoraCartaoEntity vo : listaOperadora) {
            if (vo.getNome().equals(nome)) {
                return vo;
            }
        }

        return null;
    }

}
