package br.com.coddingSchool.run.sql;

import br.com.coddingSchool.dao.CategoryDao;
import br.com.coddingSchool.dao.CourseDao;
import br.com.coddingSchool.dao.SubcategoryDao;
import br.com.coddingSchool.model.*;
import br.com.coddingSchool.util.JpaUtil;

import javax.persistence.EntityManager;

public class RunningSqlInsert {
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

        Section section = new Section(
                "Section name", "section-code", 1, true, false, course);

        Question question = new Question(
                "Title", "question-code", section, "Statement", QuestionType.MULTIPLE);

        Explanation explanation = new Explanation("Title", "explanation-code", section, "Text");

        Video video = new Video(
                "Title", "video-code", section, "URL", 15, "Video transcription");


        EntityManager em = JpaUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(em);
        SubcategoryDao subcategoryDao = new SubcategoryDao(em);
        CourseDao courseDao = new CourseDao(em);

        categoryDao.insertNewCategory(category);
        subcategoryDao.insertNewSubcategory(subcategory);
        courseDao.insertNewCourse(course);
        System.out.println("New course id = " + course.getId());

        em.getTransaction().begin();
        em.persist(section);
        em.persist(question);
        em.persist(explanation);
        em.persist(video);
        em.getTransaction().commit();
    }
}
