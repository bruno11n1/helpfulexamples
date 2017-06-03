package com.company.withoutcodeduplicationJPA;

import javax.persistence.EntityManager;

/**
 * Created by Grzegorz on 03-Jun-17.
 */

//this interface is require for refactoring to anonymous inner class
public interface BlockOfCodeTryCatchFinally {

  AnEntity execute(EntityManager entityManager);

}
