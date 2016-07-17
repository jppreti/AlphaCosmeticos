/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.business.pagamento;

import br.com.compdevbooks.alphacosmetics.business.ABusiness;
import br.com.compdevbooks.alphacosmetics.dao.IBancoDAO;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.BancoEntity;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class Banco extends ABusiness<BancoEntity,Exception,IBancoDAO>{
    
    public Banco(IDAO<BancoEntity> dao) {
        super(dao);
    }
    
    public List<BancoEntity> buscarTodasBancos() {
        return ((IBancoDAO) dao).buscarTodosBancos();
    }
    
    public  BancoEntity getBancos(String nome){
        return ((IBancoDAO) dao).getByNome(nome);
    }
    
}
