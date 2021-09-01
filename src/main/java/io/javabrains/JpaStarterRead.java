package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterRead {

   public static void main(String[]args){
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       EntityTransaction entityTransaction = entityManager.getTransaction();

      EmailGroup emailGroup = entityManager.find(EmailGroup.class,7);
      System.out.println("Got Email group. Now accessing member");
      System.out.println(emailGroup.getMembers());


   }
}
