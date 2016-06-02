package br.com.compdevbooks.alphacosmetics.dao.mock;

import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;

public class MockDAOFactory implements DAOFactory {

	@Override
	public IClienteDAO getClienteDAO() {
		return MockClienteDAO.getInstance();
	}

}
