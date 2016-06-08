package br.com.compdevbooks.alphacosmetics.business;

import java.util.List;

import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.entity.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.exception.ClienteException;

public class Cliente extends ABusiness<ClienteEntity, ClienteException, IClienteDAO> {

	public Cliente(IDAO<ClienteEntity> dao) {
		super(dao);
	}

	public List<ClienteEntity> getByNome(String nome){
		return ((IClienteDAO)dao).getByNome(nome);
	}
	
}
