package br.com.compdevbooks.alphacosmetics.dao;

public interface IDAO<ENTITY> {

	void save(ENTITY vo);
	void delete(ENTITY vo);
	ENTITY getById(Long id);
	
}
