package com.coddingSchool.dao;

import com.coddingSchool.model.Subcategory;

import javax.persistence.EntityManager;
import java.util.List;

public class SubcategoryDao {

    private final EntityManager entityManager;

    public SubcategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insertNewSubcategory(Subcategory subcategory) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(subcategory);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateSubcategory(Subcategory subcategory) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(subcategory);
            entityManager.persist(subcategory);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeSubcategory(Subcategory subcategory) {
        try {
            entityManager.getTransaction().begin();
            subcategory = entityManager.find(Subcategory.class, subcategory.getId());
            entityManager.remove(subcategory);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Subcategory findById(Long id) {
        return entityManager.find(Subcategory.class, id);
    }

    public List<Subcategory> listAll() {
        return entityManager.createQuery("SELECT s FROM Subcategory s", Subcategory.class).getResultList();
    }

    public List<Subcategory> listAllActiveSubcategories() {
        return entityManager
                .createQuery("SELECT s FROM Subcategory s WHERE s.active = :active ORDER BY s.order",
                        Subcategory.class)
                .setParameter("active", true)
                .getResultList();
    }

    public List<Subcategory> listAllSubcategoriesWithoutDescription() {
        return entityManager
                .createQuery("SELECT s FROM Subcategory s WHERE s.description = ?1 OR s.description = ?2",
                        Subcategory.class).setParameter(1, "").setParameter(2, null)
                .getResultList();
    }
}
