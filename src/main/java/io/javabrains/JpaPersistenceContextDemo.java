package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class JpaPersistenceContextDemo {
    public static void main(String[]args){

        Employee employee = new Employee();
        employee.setType(EmployeeType.FULL_TIME);
        employee.setDob(LocalDate.now());
        employee.setAge(25);
        employee.setName("New Employee");
        System.out.printf("*********************** Created Employee Instance");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        System.out.printf("*********************** Starting transaction");
        entityManager.persist(employee);
        System.out.printf("*********************** after Persist method called");
        Employee employeeFound = entityManager.find(Employee.class,1);
        System.out.println(employee);
        System.out.println(employeeFound);
        System.out.println(employee == employeeFound);
        entityTransaction.commit();
        System.out.printf("*********************** After transaction closed");
        entityManager.close();
        entityManagerFactory.close();


    }
}
