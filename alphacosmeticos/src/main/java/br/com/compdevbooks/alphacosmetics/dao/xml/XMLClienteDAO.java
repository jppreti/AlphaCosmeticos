package br.com.compdevbooks.alphacosmetics.dao.xml;

import java.util.ArrayList;
import java.util.List;

import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.entity.ClienteEntity;

public class XMLClienteDAO implements IClienteDAO {
	

	private static XMLClienteDAO singleton = null;
	
	private XMLClienteDAO(){	}
	
	public static XMLClienteDAO getInstance() {
		if (singleton == null)
			singleton = new XMLClienteDAO();
		
		return singleton;
	}
	
	@Override
	public void save(ClienteEntity entity) {

	}

	@Override
	public void delete(ClienteEntity entity) {

	}

	@Override
	public ClienteEntity getById(Long id) {
		return null;
	}

	@Override
	public List<ClienteEntity> getByNome(String nome) {
		ArrayList<ClienteEntity> resultado = new ArrayList<>();
			
		return resultado;
	}

}
