package br.com.compdevbooks.alphacosmetics.business;

public interface IBusiness<ENTITY, EXCEPTION> {

	EXCEPTION save(ENTITY entity);
	EXCEPTION delete(ENTITY entity);
	ENTITY getById(Long id);
	
}
