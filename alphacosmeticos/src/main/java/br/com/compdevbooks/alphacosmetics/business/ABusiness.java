package br.com.compdevbooks.alphacosmetics.business;

import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.entity.IEntity;

public abstract class ABusiness<ENTITY,EXCEPTION,DAO> implements IBusiness<ENTITY,EXCEPTION>{

	IDAO<ENTITY> dao;
	
	public ABusiness(IDAO<ENTITY> dao) {
		this.dao = dao;
	}
	
	@Override
	public EXCEPTION save(ENTITY entity) {
		@SuppressWarnings("unchecked")
		EXCEPTION exc = (EXCEPTION) ((IEntity<EXCEPTION>)entity).validar();
		if (exc==null)
			return exc;
		dao.save(entity);
		return null;
	}

	@Override
	public EXCEPTION delete(ENTITY entity) {
		dao.delete(entity);
		return null;
	}

	@Override
	public ENTITY getById(Long id) {
		return (ENTITY) dao.getById(id);
	}
	
	
	
}
