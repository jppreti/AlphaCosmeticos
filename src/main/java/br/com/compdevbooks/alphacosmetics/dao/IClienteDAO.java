package br.com.compdevbooks.alphacosmetics.dao;

import java.util.List;

import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;

import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;

public interface IClienteDAO extends IDAO<ClienteEntity>{
		
	List<ClienteEntity> getByNome(String nome);
        ClienteEntity getById (Long id);
	
}
