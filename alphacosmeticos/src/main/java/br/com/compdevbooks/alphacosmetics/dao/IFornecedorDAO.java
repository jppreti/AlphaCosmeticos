/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import java.util.List;

/**
 *
 * @author Josiel
 */
public interface IFornecedorDAO extends IDAO<FornecedorEntity> {
    public FornecedorEntity getByNome(String nome);
    public List<FornecedorEntity> buscarTodosFornecedores();
}
