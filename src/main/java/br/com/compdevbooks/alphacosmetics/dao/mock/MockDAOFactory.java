package br.com.compdevbooks.alphacosmetics.dao.mock;

import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockClienteDAO;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.dao.IItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.IVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockVendaDAO;

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
        public IVendaDAO getVendaDAO(){
            return MockVendaDAO.getInstace();
        }
        public IItemVendaDAO getItemVendaDAO(){
            return MockItemVendaDAO.getInstace();
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
