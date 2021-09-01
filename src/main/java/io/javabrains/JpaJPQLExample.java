package io.javabrains;

import org.hibernate.boot.model.source.spi.EmbeddableMapping;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JpaJPQLExample {
    public static void main(String[]args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String minAge = "25; delete * from Employee";

        TypedQuery<Employee> namedquery = entityManager.createNamedQuery("emp age desc",Employee.class);
        namedquery.setParameter("name","Foo Bar");
        List<Employee> list = namedquery.getResultList();
        list.forEach(e->System.out.println(e));

        entityManager.close();
        entityManagerFactory.close();
    }
}
