/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.business.operacoes;

import br.com.compdevbooks.alphacosmetics.business.ABusiness;
import br.com.compdevbooks.alphacosmetics.dao.IComissaoDAO;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.ComissaoEntity;
import java.util.List;


public class Comissao extends ABusiness<ComissaoEntity,Exception, IComissaoDAO>{
    
    public Comissao(IDAO<ComissaoEntity> dao) {
        super(dao);
    }
    
    public List<ComissaoEntity> buscarTodasComissoes(){
        return ((IComissaoDAO)dao).BuscarTodasComissoes();
    }
}
