package br.com.compdevbooks.alphacosmetics.dao.mock;

import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockClienteDAO;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;

public class MockDAOFactory implements DAOFactory {

	private static MockDAOFactory factory = null;
	
	public static MockDAOFactory getInstance() {
		if (factory == null)
			factory = new MockDAOFactory();
		return factory;
	}
	
	@Override
	public IClienteDAO getClienteDAO() {
		return MockClienteDAO.getInstance();
	}
/*
	@Override
	public boolean isSessionClosed() {
		return false;
	}

	@Override
	public void closeSession() {
		
	}
*/
}
