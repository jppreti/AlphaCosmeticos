package br.com.compdevbooks.alphacosmetics.dao.xml;

import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;

public class XMLDAOFactory  implements DAOFactory {

	private static XMLDAOFactory factory = null;
	
	public static XMLDAOFactory getInstance() {
		if (factory == null)
			factory = new XMLDAOFactory();
		return factory;
	}
	
	@Override
	public IClienteDAO getClienteDAO() {
		return XMLClienteDAO.getInstance();
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
