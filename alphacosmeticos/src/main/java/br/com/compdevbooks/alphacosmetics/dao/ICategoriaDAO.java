/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.entity.produto.CategoriaEntity;
import java.util.List;

/**
 *
 * @author Josiel
 */
public interface ICategoriaDAO extends IDAO<CategoriaEntity> {
    public List<CategoriaEntity> buscarTodasCategorias();
    public CategoriaEntity getByNome(String nome);
}
