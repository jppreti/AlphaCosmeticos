package br.com.compdevbooks.alphacosmetics.dao.mock.cadastro;

import java.util.ArrayList;
import java.util.List;

import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.endereco.MockBairroDAO;
import br.com.compdevbooks.alphacosmetics.entity.endereco.EnderecoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;

public class MockClienteDAO implements IClienteDAO {
	
	private static List<ClienteEntity> clientes = new ArrayList<>();
        private static MockBairroDAO bairro = new MockBairroDAO();
	static {
		clientes.add(new ClienteEntity((long)1,"JOAO paulo PRETTI","JOÃO PAULO","11122233344455","000",new EnderecoEntity("Rua São Paulo",196,"78078-446", bairro.getById((long) 1))));
		clientes.add(new ClienteEntity((long)2,"MARIA CRISTINA","MARIA CRISTINA","12345678901234","1111",new EnderecoEntity("Rua São Paulo",196,"78078-446", bairro.getById((long) 1))));
		clientes.add(new ClienteEntity((long)3,"JOSE PEDRO","JOSÉ PEDRO","12874698314278","2222",new EnderecoEntity("Rua Coronel Escolastico",237,"323,83874-740",bairro.getById((long) 3))));
		clientes.add(new ClienteEntity((long)4,"ANA PAULA","ANA PAULA","1122223333","875",new EnderecoEntity("Rua Coronel Escolastico",237,"323,83874-740",bairro.getById((long) 3))));
		clientes.add(new ClienteEntity((long)5,"CRISTIANE SOUZA","CRISTIANE SOUZA","2167891234","9658",new EnderecoEntity("Rua São Paulo",196,"78078-446", bairro.getById((long) 1))));
                
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
