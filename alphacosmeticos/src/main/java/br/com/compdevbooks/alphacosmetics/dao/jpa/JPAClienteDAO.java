package br.com.compdevbooks.alphacosmetics.dao.jpa;

import java.util.List;

import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.entity.ClienteEntity;

public class JPAClienteDAO implements IClienteDAO {
		
	private static JPAClienteDAO singleton = null;
	
	private JPAClienteDAO(){	}
	
	public static JPAClienteDAO getInstance() {
		if (singleton == null)
			singleton = new JPAClienteDAO();
		
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
		return null;
	}

}
