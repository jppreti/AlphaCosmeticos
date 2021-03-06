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
import br.com.compdevbooks.alphacosmetics.dao.IBairroDAO;
import br.com.compdevbooks.alphacosmetics.dao.IBancoDAO;
import br.com.compdevbooks.alphacosmetics.dao.ICategoriaDAO;
import br.com.compdevbooks.alphacosmetics.dao.ICidadeDAO;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.dao.IComissaoDAO;
import br.com.compdevbooks.alphacosmetics.dao.ICompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.IEstadoDAO;
import br.com.compdevbooks.alphacosmetics.dao.IFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.dao.IItemCompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.IItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.IOperadoraDAO;
import br.com.compdevbooks.alphacosmetics.dao.IProdutoDAO;
import br.com.compdevbooks.alphacosmetics.dao.IVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.IVendedorDAO;


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
        public IVendaDAO getVendaDAO(){
            return null;
        }
        public IItemVendaDAO getItemVendaDAO(){
            return null;
        }
        public IProdutoDAO getProdutoDAO(){
            return null;
        }
        public ICompraDAO getCompraDAO() {
            return null;
        }
        public IItemCompraDAO getItemCompraDAO() {
            return null;
        }
        public ICategoriaDAO getCategoriaDAO(){
            return null;
        }
        public  IFornecedorDAO getFornecedorDAO(){
            return null;
        }
        public IEstadoDAO getEstadoDAO() {
            return null;
        }
        public ICidadeDAO getCidadeDAO(){
            return null;
        }
        public IVendedorDAO getVendedorDAO(){
            return null;
        }
        public IBairroDAO getBairroDAO(){
            return null;
        }
        
      
    public IOperadoraDAO getOperadoraDAO() {
        return null;
    }

    public IBancoDAO getBancoDAO() {
        return null;
    }

    @Override
    public IComissaoDAO getComissaoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
