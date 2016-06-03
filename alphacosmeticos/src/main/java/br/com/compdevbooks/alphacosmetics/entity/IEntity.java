package br.com.compdevbooks.alphacosmetics.entity;

public interface IEntity<EXCEPTION> {
	
	Long getId();
	EXCEPTION validar();
	
}
