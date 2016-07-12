package br.com.compdevbooks.alphacosmetics.dao.xml;

import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.dao.IItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.IVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockVendaDAO;

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
        public IVendaDAO getVendaDAO(){
            return null;
        }
        public IItemVendaDAO getItemVendaDAO(){
            return null;
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
