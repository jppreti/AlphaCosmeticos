package br.com.compdevbooks.alphacosmetics.dao.mock;

import java.util.ArrayList;
import java.util.List;

import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.vo.ClienteVO;

public class MockClienteDAO implements IClienteDAO {
	
	private static List<ClienteVO> clientes = new ArrayList<>();
	
	static {
		clientes.add(new ClienteVO(1L,"JOAO PAULO","jppreti@gmail.com","6581232323"));
		clientes.add(new ClienteVO(1L,"MARIA CRISTINA","mariac@terra.com.br","6612345678"));
		clientes.add(new ClienteVO(1L,"JOSE PEDRO","jose.pedro@microsoft.com","8343214321"));
		clientes.add(new ClienteVO(1L,"ANA PAULA","anapaula@hotmail.com","1122223333"));
		clientes.add(new ClienteVO(1L,"CRISTIANE","cristiane@ifmt.edu.br","2167891234"));
	}
	
	private static MockClienteDAO singleton = null;
	
	private MockClienteDAO(){	}
	
	public static MockClienteDAO getInstance() {
		if (singleton == null)
			singleton = new MockClienteDAO();
		
		return singleton;
	}
	
	@Override
	public void save(ClienteVO vo) {
		clientes.add(vo);
	}

	@Override
	public void delete(ClienteVO vo) {
		clientes.remove(vo);
	}

	@Override
	public ClienteVO getById(Long id) {
		for (ClienteVO vo : clientes)
			if (vo.getIdCliente().equals(id))
				return vo;
		return null;
	}

	@Override
	public List<ClienteVO> getByNome(String nome) {
		ArrayList<ClienteVO> resultado = new ArrayList<>();
		for (ClienteVO vo : clientes)
			if (vo.getNome().toUpperCase().contains(nome.toUpperCase()))
				resultado.add(vo);		
		return resultado;
	}

}
