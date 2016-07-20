/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.entity.produto.ComissaoEntity;
import java.util.List;

public interface IComissaoDAO extends IDAO<ComissaoEntity>{
    public List<ComissaoEntity> BuscarTodasComissoes();
    
}
