package com.coddingSchool.run.sql;

import com.coddingSchool.dao.CourseDao;
import com.coddingSchool.model.Category;
import com.coddingSchool.model.Course;
import com.coddingSchool.model.Subcategory;

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
        CourseDao.updateAllCourses();
    }
}
