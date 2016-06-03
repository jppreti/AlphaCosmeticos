package br.com.compdevbooks.alphacosmetics.business;

import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.entity.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.exception.ClienteException;

public class Cliente extends ABusiness<ClienteEntity, ClienteException, IClienteDAO> {

	public Cliente(IDAO dao) {
		super(dao);
	}

}
