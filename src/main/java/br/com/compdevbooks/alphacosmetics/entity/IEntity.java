package br.com.compdevbooks.alphacosmetics.entity;

import java.io.Serializable;

public interface IEntity<EXCEPTION> extends Serializable {
	
	Long getId();
	EXCEPTION validar();
	
}
