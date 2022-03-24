package br.com.coddingSchool.run.sql;

import br.com.coddingSchool.dao.CategoryDao;
import br.com.coddingSchool.dao.CourseDao;
import br.com.coddingSchool.dao.SubcategoryDao;
import br.com.coddingSchool.model.*;
import br.com.coddingSchool.util.JpaUtil;

import javax.persistence.EntityManager;

public class RunningSqlDelete {
    public static void main(String[] args) {

        Category category = new Category(
                "Category name", "category-code", 1,
                "Category description", true,
                "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                "#00c86f", "");

        Subcategory subcategory = new Subcategory("Subcategory name", "java", 1,
                "Subcategory description", true, category, "");

        Course course = new Course("Course name", "course-code", 6, false,
                "Target audience", "Instructor name", "Course description",
                "Developed skills", subcategory);

        EntityManager em = JpaUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(em);
        SubcategoryDao subcategoryDao = new SubcategoryDao(em);
        CourseDao courseDao = new CourseDao(em);

        categoryDao.insertNewCategory(category);
        subcategoryDao.insertNewSubcategory(subcategory);
        courseDao.insertNewCourse(course);

        courseDao.removeCourse(course);
        subcategoryDao.removeSubcategory(subcategory);
        categoryDao.removeCategory(category);

    }
}
