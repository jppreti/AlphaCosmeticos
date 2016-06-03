package br.com.compdevbooks.alphacosmetics.business;

import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.entity.IEntity;

public abstract class ABusiness<ENTITY,EXCEPTION,DAO> implements IBusiness<ENTITY,EXCEPTION>{

	IDAO dao;
	
	public ABusiness(IDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public EXCEPTION save(ENTITY entity) {
		EXCEPTION exc = (EXCEPTION) ((IEntity)entity).validar();
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
