package org.krohm.generic.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
public class GenericDao<T> {

    @PersistenceContext(unitName = "default")
    protected EntityManager em;
    private static final Logger logger = LoggerFactory.getLogger(GenericDao.class);
    // This variable is only needed to allow findById to take only one argument
    private Class tClass;

    public GenericDao(Class<T> clazz) {
        this.tClass = clazz;
    }

    public GenericDao() {
    }

    @Transactional(readOnly = true)
    public T findById(Class<T> typeClass, Object id) {
        return (T) em.find(typeClass, id);
    }

    @Transactional(readOnly = true)
    public T findById(Object id) {
        return (T) em.find(tClass, id);
    }

    @Transactional
    public void flush() {
        em.flush();
    }

    @Transactional
    public void create(T o) {
        em.persist(o);
    }

    @Transactional
    public void update(T o) {
        em.merge(o);
    }

    @Transactional
    public void delete(Class<T> typeClass, Object id) {
        Object o = em.getReference(typeClass, id);
        em.remove(o);
    }
}
