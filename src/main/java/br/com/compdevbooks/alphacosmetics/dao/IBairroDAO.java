/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.entity.endereco.BairroEntity;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface IBairroDAO extends IDAO<BairroEntity>{
    public List<BairroEntity> buscarTodosBairros();
    
}
