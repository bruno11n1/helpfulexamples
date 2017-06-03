package com.company.withoutcodeduplicationJPA.oldfashion;

import com.company.withoutcodeduplicationJPA.AnEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class OldFashionDAO {

  private EntityManagerFactory entityManagerFactory;

  public OldFashionDAO(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  public void save(AnEntity entity) {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.persist(entity);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new RuntimeException(e);
    } finally {
      entityManager.close();
    }
  }

  public void update(long id, String newPropertyValue) {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      AnEntity entity = entityManager.find(AnEntity.class, id);
      entity.setProperty(newPropertyValue);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new RuntimeException(e);
    } finally {
      entityManager.close();
    }
  }

  private AnEntity byId(long id) {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    try {
      return entityManager.find(AnEntity.class, id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      entityManager.close();
    }
  }

}
