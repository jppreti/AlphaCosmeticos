package br.com.compdevbooks.alphacosmetics.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;

public class JPADAOFactory implements DAOFactory {

	private static JPADAOFactory factory = null;
	private EntityManagerFactory emFactory;
	
	private JPADAOFactory() {
		emFactory = Persistence.createEntityManagerFactory("jpa-alphacosmetics");
	}
	
	public static JPADAOFactory getInstance() {
		if (factory == null)
			factory = new JPADAOFactory();
		return factory;
	}
	
	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
	
	public void close() {
		emFactory.close();
	}
	
	@Override
	public IClienteDAO getClienteDAO() {
		return JPAClienteDAO.getInstance(getEntityManager());
	}

}
