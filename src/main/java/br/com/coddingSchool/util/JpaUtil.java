package br.com.coddingSchool.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;

public class JpaUtil {

    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("CoddingSchool");

    public static EntityManager getEntityManager() {
        Map<String, Object> properties = FACTORY.getProperties();
        return FACTORY.createEntityManager();
    }
}
