package com.coddingSchool.dao;

import com.coddingSchool.model.Course;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDao {

    private final EntityManager entityManager;

    public CourseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insertNewCourse(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateCourse(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(course);
            entityManager.persist(course);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeCourse(Course course) {
        try {
            entityManager.getTransaction().begin();
            course = entityManager.find(Course.class, course.getId());
            entityManager.remove(course);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateAllCoursesVisibility() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Course c SET c.visible = :visibility")
                .setParameter("visibility", true).executeUpdate();
        entityManager.getTransaction().commit();
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public List<Course> listAll() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    public List<Course> listAllPublicCourses() {
        return entityManager
                .createQuery("SELECT c FROM Course c WHERE c.visible = :visible ORDER BY c.id", Course.class)
                .setParameter("visible", true)
                .getResultList();
    }

    public void removeAll() {
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM Course").executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
}
