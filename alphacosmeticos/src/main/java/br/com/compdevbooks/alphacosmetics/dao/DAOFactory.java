package br.com.compdevbooks.alphacosmetics.dao;

public interface DAOFactory {

	public abstract IClienteDAO getClienteDAO();
	
	public static DAOFactory getDAOFactory(DAOFactoryEnum type){
		switch (type) {
		case MOCK:
			return null;
		case JPA:
			return null;
		default:
			return null;
		}
	}
	
}
