package br.com.compdevbooks.alphacosmetics.dao;

import java.util.List;

import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;

public interface IClienteDAO extends IDAO<ClienteEntity>{
		
	List<ClienteEntity> getByNome(String nome);
	
}
