package br.com.compdevbooks.alphacosmetics.dao;

import br.com.compdevbooks.alphacosmetics.vo.ClienteVO;

public interface IClienteDAO {

	void save(ClienteVO vo);
	ClienteVO getClienteVO(Long id);
	void delete(ClienteVO vo);
	
}
