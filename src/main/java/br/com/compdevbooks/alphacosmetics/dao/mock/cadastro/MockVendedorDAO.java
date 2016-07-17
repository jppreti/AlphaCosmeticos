/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.cadastro;

import br.com.compdevbooks.alphacosmetics.dao.IVendedorDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.endereco.MockCidadeDAO;
import br.com.compdevbooks.alphacosmetics.entity.endereco.CidadeEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.VendedorEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MockVendedorDAO implements IVendedorDAO{
    private static List<VendedorEntity> lista= new ArrayList();
    private static MockCidadeDAO cidades= new MockCidadeDAO();
    private static MockClienteDAO clientes = new MockClienteDAO();
    private static Set<CidadeEntity> listaCidades;
    private static Set<ClienteEntity> listaClientes;
    
    static{
        listaCidades = new HashSet();
        listaCidades.add(cidades.getById((long)1));
        listaCidades.add(cidades.getById((long)2));
        listaClientes = new HashSet();
        listaClientes.add(clientes.getById((long)1));
        listaClientes.add(clientes.getById((long)2));
        lista.add(new VendedorEntity((long) 1,"Nome 1","023.456.656-01","234466",listaCidades,listaClientes ));
        listaCidades = new HashSet();
        listaCidades.add(cidades.getById((long)1));
        listaCidades.add(cidades.getById((long)3));
        listaClientes = new HashSet();
        listaClientes.add(clientes.getById((long)1));
        listaClientes.add(clientes.getById((long)3));
        lista.add(new VendedorEntity((long) 1,"Nome 2","084.645.928-02","234466",listaCidades,listaClientes ));
        listaCidades = new HashSet();
        listaCidades.add(cidades.getById((long)2));
        listaCidades.add(cidades.getById((long)3));
        listaClientes = new HashSet();
        listaClientes.add(clientes.getById((long)2));
        listaClientes.add(clientes.getById((long)3));
        lista.add(new VendedorEntity((long) 1,"Nome 3","043.678.908-03","357487",listaCidades,listaClientes ));
    }
    
    private static MockVendedorDAO singleton = null;
	
	public MockVendedorDAO(){	}
	
    
    public static MockVendedorDAO getInstance() {
		if (singleton == null)
			singleton = new MockVendedorDAO();
		
		return singleton;
	}

    @Override
    public void save(VendedorEntity entity) {
       if(lista.indexOf(entity)<0)
           lista.add(entity);
    }

    @Override
    public void delete(VendedorEntity entity) {
        lista.remove(entity);
    }

    @Override
    public VendedorEntity getById(Long id) {
       for(VendedorEntity vo: lista)
           if(vo.getId().equals(id))
               return vo;
       return null;
    }
    
    @Override
    public List<VendedorEntity> getByNome(String nome) {
       List<VendedorEntity> list= new ArrayList();
       for(VendedorEntity vo: lista){
           if(vo.getNome().toUpperCase().contains(nome.toUpperCase())){
               list.add(vo);
           }
       }
       return list;
    }

    @Override
    public List<VendedorEntity> buscarTodosVendedores() {
        return lista;
    }
}
