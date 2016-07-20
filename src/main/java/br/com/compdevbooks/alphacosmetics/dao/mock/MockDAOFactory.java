package br.com.compdevbooks.alphacosmetics.dao.mock;

import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockClienteDAO;
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
import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockVendedorDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.endereco.MockBairroDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.endereco.MockCidadeDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.endereco.MockEstadoDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockComissaoDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockCompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockItemCompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.operacoes.MockVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.pagamento.MockBancoDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.pagamento.MockOperadoraDAO;
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
        public IEstadoDAO getEstadoDAO(){
            return MockEstadoDAO.getInstace();
        }
        public ICidadeDAO getCidadeDAO() {
            return MockCidadeDAO.getInstace();
        }
        public IVendedorDAO getVendedorDAO(){
            return MockVendedorDAO.getInstance();
        }
        public IBairroDAO getBairroDAO(){
            return MockBairroDAO.getInstace();
        }
        
            @Override
    public IOperadoraDAO getOperadoraDAO() {
        return MockOperadoraDAO.getInstance();
    }

    @Override
    public IBancoDAO getBancoDAO() {
        return MockBancoDAO.getInstance();
    }
    
    @Override
    public IComissaoDAO getComissaoDAO() {
        return MockComissaoDAO.getInstace();
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
