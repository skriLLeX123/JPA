package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterUpdate {

    public static void main(String[]args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Employee employee = entityManager.find(Employee.class,1);
        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 8);
        employee.addEmailSubscription(emailGroup);
        emailGroup.addMember(employee);

        entityTransaction.begin();

        entityManager.persist(employee);
        entityManager.persist(emailGroup);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
