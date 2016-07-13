package br.com.compdevbooks.alphacosmetics.dao.mock.cadastro;

import java.util.ArrayList;
import java.util.List;

import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;

public class MockClienteDAO implements IClienteDAO {
	
	private static List<ClienteEntity> clientes = new ArrayList<>();
	
	static {
		clientes.add(new ClienteEntity(1L,"JOAO PAULO PRETTI","JOÃO PAULO","11122233344455","000"));
		clientes.add(new ClienteEntity(1L,"MARIA CRISTINA","MARIA CRISTINA","12345678901234","1111"));
		clientes.add(new ClienteEntity(1L,"JOSE PEDRO","JOSÉ PEDRO","12874698314278","2222"));
		clientes.add(new ClienteEntity(1L,"ANA PAULA","ANA PAULA","1122223333","875"));
		clientes.add(new ClienteEntity(1L,"CRISTIANE SOUZA","CRISTIANE SOUZA","2167891234","9658"));
                
        }
	
	private static MockClienteDAO singleton = null;
	
	public MockClienteDAO(){	}
	
	public static MockClienteDAO getInstance() {
		if (singleton == null)
			singleton = new MockClienteDAO();
		
		return singleton;
	}
	
	@Override
	public void save(ClienteEntity entity) {
		if (clientes.indexOf(entity)<0)
			clientes.add(entity);
	}

	@Override
	public void delete(ClienteEntity entity) {
		clientes.remove(entity);
	}

	@Override
	public ClienteEntity getById(Long id) {
		for (ClienteEntity vo : clientes)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public List<ClienteEntity> getByNome(String nome) {
		ArrayList<ClienteEntity> resultado = new ArrayList<>();
		for (ClienteEntity vo : clientes)
			if (vo.getNome().toUpperCase().contains(nome.toUpperCase()))
				resultado.add(vo);		
		return resultado;
	}
        
     
        
        public List<ClienteEntity> getByCNPJ(String CNPJ) {
            ArrayList<ClienteEntity> resultado = new ArrayList<>();
            for (ClienteEntity vo : clientes){
                if (vo.getCNPJ().contains(CNPJ)){
                    resultado.add(vo);
                }
						
            }
			
		return resultado;  
    }

}
