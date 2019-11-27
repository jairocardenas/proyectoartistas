package com.ustatunja.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);

        cq.select(cq.from(entityClass));
        List<T> data = getEntityManager().createQuery(cq).getResultList();
        return data;
    }

    public void delete(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
}
