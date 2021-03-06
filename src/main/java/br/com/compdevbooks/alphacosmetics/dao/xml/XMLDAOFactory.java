package br.com.compdevbooks.alphacosmetics.dao.xml;

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
        public IProdutoDAO getProdutoDAO(){
            return null;
        }
        
        public ICompraDAO getCompraDAO() {
            return null;
        }
        public IItemCompraDAO getItemCompraDAO(){
            return null;
        }
        public ICategoriaDAO getCategoriaDAO(){
            return null;
        }
        public IFornecedorDAO getFornecedorDAO(){
            return null;
        }
        public IEstadoDAO getEstadoDAO(){
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
            @Override
    public IOperadoraDAO getOperadoraDAO() {
        return null;
    }

    @Override
    public IBancoDAO getBancoDAO() {
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

    @Override
    public IComissaoDAO getComissaoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
