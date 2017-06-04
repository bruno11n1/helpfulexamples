package com.company.withoutcodeduplicationJPA.java8fashion;

import com.company.withoutcodeduplicationJPA.AnEntity;

/**
 * Created by Grzegorz on 03-Jun-17.
 */
public class Java8FashionDAO {

  private TransactionTemplate transaction;

  public Java8FashionDAO(
      TransactionTemplate transaction) {
    this.transaction = transaction;
  }

  public void sava(AnEntity entity) {
    transaction.execute(
        (entityManager -> {
          entityManager.persist(entity);
          return null;
        })
    );
  }

  public void update(long id, String newPropertyValue) {
    transaction.execute(
        (entityManager -> {
          AnEntity entity = entityManager.find(AnEntity.class, id);
          entity.setProperty(newPropertyValue);
          return null;
        })
    );
  }

  public AnEntity byId(long id){
    return transaction.execute(
        (entityManager -> {
          return entityManager.find(AnEntity.class, id);
        })
    );
  }
}

