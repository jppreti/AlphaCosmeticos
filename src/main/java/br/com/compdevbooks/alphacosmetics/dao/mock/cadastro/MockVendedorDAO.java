/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.cadastro;

import br.com.compdevbooks.alphacosmetics.dao.IVendedorDAO;
import br.com.compdevbooks.alphacosmetics.entity.endereco.CidadeEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.VendedorEntity;
import java.util.ArrayList;
import java.util.List;


public class MockVendedorDAO implements IVendedorDAO{
    private static List<VendedorEntity> vendedores = new ArrayList<>();
    
    private static MockVendedorDAO singleton = null;
	
        //private MockVendedorDAO()
	//private MockVendedorDAO(){}
	
	public static MockVendedorDAO getInstance() {
		if (singleton == null)
			singleton = new MockVendedorDAO();
		
		return singleton;
	}

    @Override
    public List<VendedorEntity> getByNome(String nome) {
        ArrayList<VendedorEntity> resultado = new ArrayList<>();
		for (VendedorEntity vo : vendedores)
			if (vo.getNome().toUpperCase().contains(nome.toUpperCase()))
				resultado.add(vo);
                
		return resultado;
    }

    @Override
    public void save(VendedorEntity entity) {
        if (vendedores.indexOf(entity)<0)
            vendedores.add(entity);
    }

    @Override
    public void delete(VendedorEntity entity) {
        vendedores.remove(entity);
    }

    @Override
    public VendedorEntity getById(Long id) {
        for (VendedorEntity vo : vendedores)
			if (vo.getId().equals(id))
				return vo;
		return null;
    }

    public VendedorEntity getVendedorByMunicipio(CidadeEntity municipio) {
        for(VendedorEntity vo: vendedores)
            
            if (vo.getListaMunicipios().contains(municipio))
                return vo;
        return null;
    }

}
