package br.com.compdevbooks.alphacosmetics.dao.jpa;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.entity.ClienteEntity;

public class JPAClienteDAO implements IClienteDAO {
		
	private static JPAClienteDAO singleton = null;
	
	@Inject
	private EntityManager em;
	
	public JPAClienteDAO(){	}
	
	public static JPAClienteDAO getInstance() {
		if (singleton == null)
			singleton = new JPAClienteDAO();
		
		//singleton.em = em;
		return singleton;
	}
	
	@Override
	public void save(ClienteEntity entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public void delete(ClienteEntity entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	@Override
	public ClienteEntity getById(Long id) {
		return em.find(ClienteEntity.class, id);
	}

	@Override
	public List<ClienteEntity> getByNome(String nome) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<ClienteEntity> q = cb.createQuery(ClienteEntity.class);
		 Root<ClienteEntity> cliente = q.from(ClienteEntity.class);
		 q.select(cliente);
		 ParameterExpression<String> p = cb.parameter(String.class,"pnome");
		 q.where(cb.like(cliente.get("nome"), p));
		 return em.createQuery(q).setParameter("pnome", nome).getResultList();
	}

}
