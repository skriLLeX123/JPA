package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JpaStarterWrite {

    public static void main(String[]args){

        Employee employee = new Employee();
        employee.setType(EmployeeType.FULL_TIME);
        employee.setDob(LocalDate.now());
        employee.setAge(20);
        employee.setName("Foo Bar");

        Employee employee1 = new Employee();
        employee1.setType(EmployeeType.CONTRACTOR);
        employee1.setDob(LocalDate.now());
        employee1.setAge(25);
        employee1.setName("Foo Bar Tar");

        AccessCard accessCard = new AccessCard();
        accessCard.setActive(true);
        accessCard.setIssuedDate(LocalDate.now());
        accessCard.setFirmwareVersion("1.0.0");
        employee.setAccessCardId(accessCard);
        accessCard.setOwner(employee);


        AccessCard accessCard1 = new AccessCard();
        accessCard1.setActive(false);
        accessCard1.setIssuedDate(LocalDate.now());
        accessCard1.setFirmwareVersion("1.2.0");
        employee1.setAccessCardId(accessCard1);
        accessCard1.setOwner(employee1);


        PayStub payStub1= new PayStub();
        payStub1.setPayPeriodStart(LocalDate.now());
        payStub1.setPayPeriodEnd(LocalDate.now());
        payStub1.setEmployee(employee);
        employee.addPayStub(payStub1);
        payStub1.setSalary(1000);

        PayStub payStub2= new PayStub();
        payStub2.setPayPeriodStart(LocalDate.now());
        payStub2.setPayPeriodEnd(LocalDate.now());
        payStub2.setEmployee(employee);
        employee.addPayStub(payStub2);
        payStub2.setSalary(2000);

        EmailGroup emailGroup1 = new EmailGroup();
        emailGroup1.setName("Company WaterCooler Discussions");
        emailGroup1.addMember(employee);
        emailGroup1.addMember(employee1);
        employee.addEmailSubscription(emailGroup1);
        employee1.addEmailSubscription(emailGroup1);

        EmailGroup emailGroup2 = new EmailGroup();
        emailGroup2.setName("Engineering");
        employee1.addEmailSubscription(emailGroup2);
        emailGroup2.addMember(employee1);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(employee);
        entityManager.persist(employee1);

        entityManager.persist(accessCard);
        entityManager.persist(accessCard1);

        entityManager.persist(payStub1);
        entityManager.persist(payStub2);

        entityManager.persist(emailGroup1);
        entityManager.persist(emailGroup2);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
