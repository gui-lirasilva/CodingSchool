package br.com.coddingSchool.dao;

import br.com.coddingSchool.model.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {

    private final EntityManager entityManager;

    public CategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insertNewCategory(Category category) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(category);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateCategory(Category category) {
        String jqpl = """
                UPDATE Category c SET c.name = :name, c.code = :code, c.description = :description, 
                c.studyGuide = :studyGuide, c.active = :active, c.order = :order, c.iconPath = :iconPath, 
                c.colorCode = :colorCode WHERE c.id = :id
                """;
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery(jqpl)
                    .setParameter("id", category.getId())
                    .setParameter("name", category.getName())
                    .setParameter("code", category.getCode())
                    .setParameter("description", category.getDescription())
                    .setParameter("studyGuide", category.getStudyGuide())
                    .setParameter("active", category.getActive())
                    .setParameter("order", category.getOrder())
                    .setParameter("iconPath", category.getIconPath())
                    .setParameter("colorCode", category.getColorCode())
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }

    public void removeCategory(Category category) {
        try {
            entityManager.getTransaction().begin();
            category = entityManager.find(Category.class, category.getId());
            entityManager.remove(category);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> listAll() {
        entityManager.clear();
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    public List<Category> listAllActiveCategories() {
        entityManager.clear();
        return entityManager
                .createQuery("SELECT c FROM Category c WHERE c.active = :active ORDER BY c.order", Category.class)
                .setParameter("active", true).getResultList();
    }


    public void removeAll() {
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM Category").executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
}
