package com.coddingSchool.run.sql;

import com.coddingSchool.model.Category;
import com.coddingSchool.model.Course;
import com.coddingSchool.model.Subcategory;
import com.coddingSchool.util.JpaUtil;

import javax.persistence.EntityManager;

public class RunningDao {

    public static void main(String[] args) {

        Category category = new Category(
                "Category name", "category-code", 1,
                "Category description", true,
                "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                "#00c86f"
        );

        Subcategory subcategory = new Subcategory("Subcategory name", "java", 1,
                "Subcategory description", true, category
        );

        Course course = new Course("Course name", "course-code", 6, true,
                "Target audience", "Instructor name", "Course description",
                "Developed skills", subcategory);

//        CourseDao.insertNewCourse(course);
//        CourseDao.deleteCourse(course);
//        CourseDao.updateAllCourses();

        EntityManager em = JpaUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        em.close();
    }
}
