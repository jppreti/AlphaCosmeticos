package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.dao.jpa.JPADAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.mock.MockDAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.xml.XMLDAOFactory;

public interface DAOFactory {

	public abstract IClienteDAO getClienteDAO();
	
	public static DAOFactory getDAOFactory(DAOFactoryEnum type){
		switch (type) {
		case MOCK:
			return MockDAOFactory.getInstance();
		case JPA:
			return JPADAOFactory.getInstance();
		case XML:
			return XMLDAOFactory.getInstance();			
		default:
			return null;
		}
	}
	
	//public abstract boolean isSessionClosed();
	//public abstract void closeSession();
	
}
