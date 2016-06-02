package br.com.compdevbooks.alphacosmetics.dao;

import java.util.List;

import br.com.compdevbooks.alphacosmetics.vo.ClienteVO;

public interface IClienteDAO extends IDAO<ClienteVO>{
		
	List<ClienteVO> getByNome(String nome);
	
}
