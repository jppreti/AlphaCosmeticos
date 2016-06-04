package br.com.compdevbooks.alphacosmetics.dao.jpa;

import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;

public class JPADAOFactory implements DAOFactory {

	private static JPADAOFactory factory = null;
	
	public static JPADAOFactory getInstance() {
		if (factory == null)
			factory = new JPADAOFactory();
		return factory;
	}
	
	@Override
	public IClienteDAO getClienteDAO() {
		return JPAClienteDAO.getInstance();
	}

}
