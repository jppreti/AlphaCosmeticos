package br.com.compdevbooks.alphacosmetics.dao.mock;

import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockClienteDAO;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.ICategoriaDAO;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.dao.ICompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.IFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.dao.IItemCompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.IItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.IProdutoDAO;
import br.com.compdevbooks.alphacosmetics.dao.IVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockCompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockItemCompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockCategoriaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockProdutoDAO;

public class MockDAOFactory implements DAOFactory {

	private static MockDAOFactory factory = null;
	
	public static MockDAOFactory getInstance() {
		if (factory == null)
			factory = new MockDAOFactory();
		return factory;
	}
	
	@Override
	public IClienteDAO getClienteDAO() {
		return MockClienteDAO.getInstance();
	}
        public IVendaDAO getVendaDAO(){
            return MockVendaDAO.getInstace();
        }
        public IItemVendaDAO getItemVendaDAO(){
            return MockItemVendaDAO.getInstace();
        }
        public IProdutoDAO getProdutoDAO(){
            return MockProdutoDAO.getInstace();
        }
        
        public ICompraDAO getCompraDAO() {
            return MockCompraDAO.getInstance();
        }
        
        public IItemCompraDAO getItemCompraDAO() {
            return MockItemCompraDAO.getInstance();
        }   
        
        public ICategoriaDAO getCategoriaDAO(){
            return MockCategoriaDAO.getInstace();
        }

        public  IFornecedorDAO getFornecedorDAO(){
            return MockFornecedorDAO.getInstance();
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
