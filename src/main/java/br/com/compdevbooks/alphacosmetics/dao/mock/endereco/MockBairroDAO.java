/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.endereco;

import br.com.compdevbooks.alphacosmetics.dao.IBairroDAO;
import br.com.compdevbooks.alphacosmetics.entity.endereco.BairroEntity;
import br.com.compdevbooks.alphacosmetics.entity.endereco.CidadeEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class MockBairroDAO implements IBairroDAO{
    private static List<BairroEntity> bairros= new ArrayList<>();
    private static MockCidadeDAO cidade = new MockCidadeDAO();
    
    static {
        bairros.add(new BairroEntity( (long) 1,"Cidade Alta", cidade.getById((long)1)));
        bairros.add(new BairroEntity((long)2,"CidadeVelha", cidade.getById((long)2)));
        bairros.add(new BairroEntity((long)3,"Morumbi",cidade.getById((long)3)));
    } 
    
    public MockBairroDAO(){  }
    private static MockBairroDAO singleton;
    
    public static MockBairroDAO getInstace(){
        if(singleton==null)
            singleton= new MockBairroDAO();
        return singleton;
    }

    public void save(BairroEntity entity) {
        if(bairros.indexOf(entity)<0)
            bairros.add(entity);
    }

    public void delete(BairroEntity entity) {
      bairros.remove(entity);
    }

    public BairroEntity getById(Long id) {
        for(BairroEntity vo: bairros)
            if(vo.getId().equals(id))
                return vo;
        return null;  
    }
    public List<BairroEntity> buscarTodosBairros(){
        return bairros;
    }
}
