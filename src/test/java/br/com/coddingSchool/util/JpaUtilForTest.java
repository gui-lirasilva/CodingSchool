package br.com.coddingSchool.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JpaUtilForTest {

    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("CoddingSchool_test");

    public static EntityManager getEntityManagerForTest() {
        return FACTORY.createEntityManager();
    }

}