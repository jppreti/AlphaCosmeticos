package br.com.compdevbooks.alphacosmetics.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import br.com.compdevbooks.alphacosmetics.dao.jpa.JPADAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.mock.MockDAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.xml.XMLDAOFactory;

public interface DAOFactory {

	public abstract IClienteDAO getClienteDAO();
        public abstract IVendaDAO getVendaDAO();
        public abstract ICompraDAO getCompraDAO();
        public abstract IItemVendaDAO getItemVendaDAO();
        public abstract IItemCompraDAO getItemCompraDAO();
        public abstract IProdutoDAO getProdutoDAO();
        
	public static Properties props = new Properties();

	public static DAOFactory getDAOFactory() {
		if (props.isEmpty()) {
			try {
				FileInputStream file = new FileInputStream(
						DAOFactory.class.getClassLoader().getResource("datasource.properties").getPath());
				props.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			props.getProperty("datasource");
		}

		DAOFactoryEnum datasource = DAOFactoryEnum.valueOf(props.getProperty("datasource"));
		switch (datasource) {
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

	// public abstract boolean isSessionClosed();
	// public abstract void closeSession();

}
