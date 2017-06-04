package com.company.withoutcodeduplicationJPA.anonymousfashion;

import com.company.withoutcodeduplicationJPA.AnEntity;
import com.company.withoutcodeduplicationJPA.BlockOfCodeTryCatchFinally;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class AnonymousFashionDAO {

  private EntityManagerFactory entityManagerFactory;

  public AnonymousFashionDAO(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  public void save(AnEntity entity) {
    transactionExecute(new BlockOfCodeTryCatchFinally() {
      @Override
      public AnEntity execute(EntityManager entityManager) {
        //not duplicate part of old fashion code
        entityManager.persist(entity);
        return null;
      }
    });
  }

  public void update(long id, String newPropertyValue) {
    transactionExecute(new BlockOfCodeTryCatchFinally() {
      @Override
      public AnEntity execute(EntityManager entityManager) {
        //not duplicate part of old fashion code
        AnEntity entity = entityManager.find(AnEntity.class, id);
        entity.setProperty(newPropertyValue);
        return null;
      }
    });
  }

  public AnEntity byId(long id) {
    return (AnEntity) transactionExecute(new BlockOfCodeTryCatchFinally() {
      @Override
      public AnEntity execute(EntityManager entityManager) {
        return entityManager.find(AnEntity.class, id);
      }
    });
  }


  private <T> T transactionExecute(BlockOfCodeTryCatchFinally <T> blockOfCode) {
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      T entity = blockOfCode.execute(entityManager);
      transaction.commit();
      return entity;
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new RuntimeException(e);
    } finally {
      entityManager.close();
    }
  }
}
