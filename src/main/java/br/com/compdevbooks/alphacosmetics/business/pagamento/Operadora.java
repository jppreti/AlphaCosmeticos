/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.business.pagamento;

import br.com.compdevbooks.alphacosmetics.business.ABusiness;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.IOperadoraDAO;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.OperadoraCartaoEntity;
import java.util.List;

public class Operadora extends ABusiness<OperadoraCartaoEntity, Exception, IOperadoraDAO> {

    public Operadora(IDAO<OperadoraCartaoEntity> dao) {
        super(dao);
    }

    public List<OperadoraCartaoEntity> buscarTodasOperadoras() {
        return ((IOperadoraDAO) dao).buscarTodasOperadoras();
    }
    
    public  OperadoraCartaoEntity getOperadora(String nome){
        return ((IOperadoraDAO) dao).getByNome(nome);
    }

}
