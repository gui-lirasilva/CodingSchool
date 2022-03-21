package com.coddingSchool.run.sql;

import com.coddingSchool.dao.CategoryDao;
import com.coddingSchool.dao.CourseDao;
import com.coddingSchool.dao.SubcategoryDao;
import com.coddingSchool.model.Category;
import com.coddingSchool.model.Course;
import com.coddingSchool.model.Section;
import com.coddingSchool.model.Subcategory;
import com.coddingSchool.util.JpaUtil;

import javax.persistence.EntityManager;

public class RunningDao {

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

        Section section = new Section();


        EntityManager em = JpaUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(em);
        SubcategoryDao subcategoryDao = new SubcategoryDao(em);
        CourseDao courseDao = new CourseDao(em);

        categoryDao.insertNewCategory(category);
        subcategoryDao.insertNewSubcategory(subcategory);
        courseDao.insertNewCourse(course);

        category.setName("New name");
        categoryDao.updateCategory(category);
        subcategory.setName("New name");
        subcategoryDao.updateSubcategory(subcategory);
        course.setName("New name");
        courseDao.updateCourse(course);

//        courseDao.removeCourse(course);
//        subcategoryDao.removeSubcategory(subcategory);
//        categoryDao.removeCategory(category);

        courseDao.updateAllCoursesVisibility();

//        List<Course> courseList = courseDao.listAll();
//        System.out.println(courseList);
    }
}
