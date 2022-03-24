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
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(category);
            entityManager.persist(category);
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
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    public List<Category> listAllActiveCategories() {
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