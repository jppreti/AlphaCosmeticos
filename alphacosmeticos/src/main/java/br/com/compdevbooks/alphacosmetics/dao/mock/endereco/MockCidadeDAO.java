/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.endereco;

import br.com.compdevbooks.alphacosmetics.dao.ICidadeDAO;
import br.com.compdevbooks.alphacosmetics.entity.endereco.CidadeEntity;
import br.com.compdevbooks.alphacosmetics.entity.endereco.EstadoEntity;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class MockCidadeDAO implements ICidadeDAO{
    private static List<CidadeEntity> cidades= new ArrayList<>();
    private static MockEstadoDAO estado = new MockEstadoDAO();
    
    static {
        cidades.add(new CidadeEntity( (long) 1,"Cuiabá", estado.getById((long)1)));
        cidades.add(new CidadeEntity((long)2,"Belém", estado.getById((long)2)));
        cidades.add(new CidadeEntity((long)3,"São Paulo",estado.getById((long)3)));
    } 
    
    public MockCidadeDAO(){  }
    private static MockCidadeDAO singleton;
    
    public static MockCidadeDAO getInstace(){
        if(singleton==null)
            singleton= new MockCidadeDAO();
        return singleton;
    }

    public void save(CidadeEntity entity) {
        if(cidades.indexOf(entity)<0)
            cidades.add(entity);
    }

    public void delete(CidadeEntity entity) {
      cidades.remove(entity);
    }

    public CidadeEntity getById(Long id) {
        for(CidadeEntity vo: cidades)
            if(vo.getId().equals(id))
                return vo;
        return null;  
    }
    public List<CidadeEntity> buscarTodasCidades(){
        return cidades;
    }
}
