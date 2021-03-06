package com.company.withoutcodeduplicationJPA.abstactionfashion;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class AbstractionFashionDAO<T extends Serializable> {

  private Class<T> clazz;

  EntityManager entityManager;

  public void setClazz(Class<T> clazzToSet) {
    this.clazz = clazzToSet;
  }

  public T findOne(long id) {
    return entityManager.find(clazz, id);
  }

  public List<T> findAll() {
    return entityManager.createQuery("from " + clazz.getName())
        .getResultList();
  }

  public void create(T entity) {
    entityManager.persist(entity);
  }

  public T update(T entity) {
    return entityManager.merge(entity);
  }

  public void delete(T entity) {
    entityManager.remove(entity);
  }

  public void deleteById(long entityId) {
    T entity = findOne(entityId);
    delete(entity);
  }

}
