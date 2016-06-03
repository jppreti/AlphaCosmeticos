package br.com.compdevbooks.alphacosmetics.dao;

public interface IDAO<ENTITY> {

	void save(ENTITY entity);
	void delete(ENTITY entity);
	ENTITY getById(Long id);
	
}
