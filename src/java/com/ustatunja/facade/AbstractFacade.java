package com.ustatunja.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class AbstractFacade<T> {

	private Class<T> entityClass;

	protected abstract EntityManager getEntityManager();

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void add(T entity) {
		getEntityManager().persist(entity);
	}

	public List<T> loadAll() {
                       
		// papa entity
		CriteriaBuilder cb; // maneja query
		CriteriaQuery<T> cq;// hacer consulta o manejar las sintaxis del query
		List<T> objData;

		cb = getEntityManager().getCriteriaBuilder();
		cq = cb.createQuery(entityClass);
		cq.select(cq.from(entityClass));
		/*
		 * Root<T> root = cq.from(entityClass); cq.orderBy(cb.desc(entityClass.));
		 */
		objData = getEntityManager().createQuery(cq).getResultList();

		return objData;
//
	}
	
	public List<T> search(String field, String value, String orderByField) {
	    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
	    CriteriaQuery<T> cq = cb.createQuery(entityClass);

	    Root<T> objRoot = cq.from(entityClass);
	    cq.orderBy(cb.asc(objRoot.get(orderByField)));
	    

	    if (!value.equals("")) {
	      String cadena = "%"+value.toLowerCase()+"%";
	      Expression<String> campo = objRoot.get(field);
	      campo = cb.lower(campo);
	      Predicate condition = cb.like(campo, cadena);
	      cq.where(condition);
	    }

	    Query query = getEntityManager().createQuery(cq);
	    
	    return query.getResultList();
	  }



	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	public void delete(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public void update(T entity) {
		getEntityManager().merge(entity);
	}

}
