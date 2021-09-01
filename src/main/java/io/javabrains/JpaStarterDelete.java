package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterDelete {

    public static void main(String[]args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Employee employee = entityManager.find(Employee.class,1);

        entityTransaction.begin();

        entityManager.remove(employee);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
