package com.company.withoutcodeduplicationJPA.java8fashion;

import com.company.withoutcodeduplicationJPA.BlockOfCodeTryCatchFinally;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class TransactionTemplate {

  public EntityManagerFactory entityManagerFactory;

  public TransactionTemplate(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  public <T> T execute(BlockOfCodeTryCatchFinally<T> blockOfCode) {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    EntityTransaction transaction = null;
    T entity = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entity = blockOfCode.execute(entityManager);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
        throw new RuntimeException(e);
      }
    } finally {
      entityManager.close();
    }
    return entity;
  }
}
