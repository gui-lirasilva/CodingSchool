package com.coddingSchool.dao;

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
            category = new Category(
                    "First category", "category-code", 1,
                    "Category description", true,
                    "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                    "#00c86f", "");
            categoryDao.insertNewCategory(category);

            subcategory = new Subcategory("First subcategory", "java", 1,
                    "Subcategory description", true, category, "");
            subcategoryDao.insertNewSubcategory(subcategory);

            course1 = new Course("First course", "course-code", 6, true,
                    "Target audience", "Instructor name", "Course description",
                    "Developed skills", subcategory);
            course2 = new Course("Second course", "course-code", 6, false,
                    "Target audience", "Instructor name", "Course description",
                    "Developed skills", subcategory);
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