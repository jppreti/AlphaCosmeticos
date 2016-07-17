/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.endereco;

import br.com.compdevbooks.alphacosmetics.dao.IEstadoDAO;
import br.com.compdevbooks.alphacosmetics.entity.endereco.EstadoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class MockEstadoDAO implements IEstadoDAO {
    
    private static List<EstadoEntity> estados= new ArrayList<>();
    static {
        estados.add(new EstadoEntity( (long) 1,"MT", "Mato Grosso"));
        estados.add(new EstadoEntity((long)2,"PA", "Pará"));
        estados.add(new EstadoEntity((long)3,"SP","São Paulo"));
    } 
    
    public MockEstadoDAO(){  }
    private static MockEstadoDAO singleton;
    
    public static MockEstadoDAO getInstace(){
        if(singleton==null)
            singleton= new MockEstadoDAO();
        return singleton;
    }

    public void save(EstadoEntity entity) {
        if(estados.indexOf(entity)<0)
            estados.add(entity);
    }

    public void delete(EstadoEntity entity) {
      estados.remove(entity);
    }

    public EstadoEntity getById(Long id) {
        for(EstadoEntity vo: estados)
            if(vo.getId().equals(id))
                return vo;
        return null;  
    }
    public List<EstadoEntity> buscarTodosEstados(){
        return estados;
    }
}
