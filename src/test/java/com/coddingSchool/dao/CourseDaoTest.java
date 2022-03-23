package com.coddingSchool.dao;

import com.coddingSchool.builders.CategoryBuilder;
import com.coddingSchool.builders.CourseBuilder;
import com.coddingSchool.builders.SubcategoryBuilder;
import com.coddingSchool.model.Category;
import com.coddingSchool.model.Course;
import com.coddingSchool.model.Subcategory;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDaoTest {

    private EntityManager entityManager;
    private CourseDao courseDao;
    private SubcategoryDao subcategoryDao;
    private CategoryDao categoryDao;
    private Category category;
    private Subcategory subcategory;
    private Course course1;
    private Course course2;

    @BeforeEach
    void setup() {
        entityManager = Persistence.createEntityManagerFactory("CoddingSchool_test")
                .createEntityManager();
        categoryDao = new CategoryDao(entityManager);
        subcategoryDao = new SubcategoryDao(entityManager);
        courseDao = new CourseDao(entityManager);
    }

    @Test
    void listAllPublicCourses__shouldBeDevolveAEmptyListIfTheDatabaseIsEmpty() {
        List<Course> courseList = courseDao.listAllPublicCourses();
        assertTrue(courseList.isEmpty());
    }

    @Nested
    class TestsWithData {
        @BeforeEach
        void setup2() {

            category = new CategoryBuilder()
                    .withName("First category")
                    .withCode("category-code")
                    .build();
            categoryDao.insertNewCategory(category);

            subcategory = new SubcategoryBuilder()
                    .withName("First subcategory")
                    .withCode("java")
                    .withCategory(category)
                    .build();
            subcategoryDao.insertNewSubcategory(subcategory);

            course1 = new CourseBuilder()
                    .withName("First course")
                    .withCode("course-code")
                    .withEstimatedTime(15)
                    .withVisible(true)
                    .withInstructor("Instructor name")
                    .withSubcategory(subcategory)
                    .build();

            course2 = new CourseBuilder()
                    .withName("Second course")
                    .withCode("course-code")
                    .withEstimatedTime(18)
                    .withVisible(false)
                    .withInstructor("Instructor name")
                    .withSubcategory(subcategory)
                    .build();
        }

        @Test
        void listAllPublicCourses__shouldBeDevolveACorrectNumberOfPublicCourses() {
            courseDao.insertNewCourse(course1);
            courseDao.insertNewCourse(course2);
            List<Course> courseList = courseDao.listAllPublicCourses();
            assertEquals(1, courseList.size());
        }

        @Test
        void listAllPublicCourses__shouldBeDevolveACorrectPublicCourse() {
            courseDao.insertNewCourse(course1);
            courseDao.insertNewCourse(course2);
            List<Course> courseList = courseDao.listAllPublicCourses();
            assertEquals(course1, courseList.get(0));
        }
    }

    @AfterEach
    void finish() {
        courseDao.removeAll();
        subcategoryDao.removeAll();
        categoryDao.removeAll();
    }
}