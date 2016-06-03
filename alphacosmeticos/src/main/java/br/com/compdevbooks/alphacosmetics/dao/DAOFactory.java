package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.dao.mock.MockDAOFactory;

public interface DAOFactory {

	public abstract IClienteDAO getClienteDAO();
	
	public static DAOFactory getDAOFactory(DAOFactoryEnum type){
		switch (type) {
		case MOCK:
			return MockDAOFactory.getInstance();
		case JPA:
			return null;
		default:
			return null;
		}
	}
	
}
