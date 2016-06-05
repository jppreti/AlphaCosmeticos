package br.com.compdevbooks.alphacosmetics.dao.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;

public class JPADAOFactory implements DAOFactory {

	private static JPADAOFactory factory = null;
	private EntityManagerFactory emFactory;
	private static WeldContainer weld;
	
	static {
    	Weld theWeld = new Weld();
    	weld = theWeld.initialize();
	}
	
	private JPADAOFactory() {
		emFactory = Persistence.createEntityManagerFactory("jpa-alphacosmetics");
	}
	
	public static JPADAOFactory getInstance() {
		if (factory == null) 
			factory = new JPADAOFactory();
		return factory;
	}
	
	@Produces @ApplicationScoped
	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
	
	public void close() {
		emFactory.close();
	}
	
	@Override
	public IClienteDAO getClienteDAO() {
		return weld.instance().select(JPAClienteDAO.class).get();
	}

	public void closeEntityManager(@Disposes EntityManager em){
		em.close();
	}
}
