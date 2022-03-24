package br.com.coddingSchool.run.sql;

import br.com.coddingSchool.helpers.HelperCsv;
import br.com.coddingSchool.dao.CategoryDao;
import br.com.coddingSchool.dao.CourseDao;
import br.com.coddingSchool.dao.SubcategoryDao;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.util.JpaUtil;

import javax.persistence.EntityManager;
import java.io.*;
import java.util.List;

public class RunningSqlReport {

    private static void htmlReport() {

        EntityManager em = JpaUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(em);
        SubcategoryDao subcategoryDao = new SubcategoryDao(em);
        CourseDao courseDao = new CourseDao(em);

        try (OutputStream os = new FileOutputStream("sqlReport.html")) {
            PrintStream ps = new PrintStream(os);

            ps.println("<html>");
            ps.println("<head>");
            ps.println("<meta charset=\"UTF-8\">");
            ps.println("</head>");
            ps.println("<body>");

            List<Category> categoryList = categoryDao.listAllActiveCategories();
            List<Subcategory> subcategoryList = subcategoryDao.listAllActiveSubcategories();
            List<Course> courseList = courseDao.listAllPublicCourses();
            List<Subcategory> subcategoriesWithoutDescription = subcategoryDao.
                    listAllSubcategoriesWithoutDescription();

            ps.println("<h3>Active categories:</h3>");
            for(Category c : categoryList) {
                ps.printf("""
                            <ul>
                                <li>Category id = %d</li>
                                <br>
                                <li>Category name = %s</li>
                                <br>
                                <li>Category code = %s</li>
                                <br>
                                <li>Order = %d</li>
                                <br>
                                <li>Description = %s</li>
                                <br>
                                <li>Active = %s</li>
                                <br>
                                <li>Icon path = %s</li>
                                <br>
                                <li>Hexadecimal color code = %s</li>
                                <br>
                                <li>Study guide = %s</li>
                            </ul>
                            <p>------------------------------------------------------------------------------------------------------------------</p>
                            <br>
                            <br>
                            <br>
                            %n""",
                        c.getId(), c.getName(), c.getCode(), c.getOrder(), c.getDescription(),
                        HelperCsv.isActive(c.getActive()), c.getIconPath(), c.getColorCode(), c.getStudyGuide());

            }

            ps.println("<h3>Active subcategories:</h3>");
            for(Subcategory s : subcategoryList) {
                Category category = s.getCategory();
                ps.printf("""
                            <ul>
                                <li>Subcategory id = %d</li>
                                <br>
                                <li>Subcategory name = %s</li>
                                <br>
                                <li>Subcategory code = %s</li>
                                <br>
                                <li>Order = %d</li>
                                <br>
                                <li>Description = %s</li>
                                <br>
                                <li>Active = %s</li>
                                <br>
                                <li>Category = %s</li>
                                <br>
                                <li>Study guide = %s</li>
                            </ul>
                            <p>------------------------------------------------------------------------------------------------------------------</p>
                            <br>
                            <br>
                            <br>
                            %n""",
                        s.getId(), s.getName(), s.getCode(), s.getOrder(), s.getDescription(),
                        HelperCsv.isActive(s.getActive()), category.getName(), s.getStudyGuide());

            }

            ps.println("<h3>Public courses:</h3>");
            for(Course c : courseList) {
                Subcategory subcategory = c.getSubcategory();
                ps.printf("""
                            <ul>
                                <li>Course id = %d</li>
                                <br>
                                <li>Course name = %s</li>
                                <br>
                                <li>Course code = %s</li>
                                <br>
                                <li>Estimated time = %d hours</li>
                                <br>
                                <li>Visibility = %s</li>
                                <br>
                                <li>Target = %s</li>
                                <br>
                                <li>Instructor = %s</li>
                                <br>
                                <li>Description = %s</li>
                                <br>
                                <li>Developed skills = %s</li>
                                <br>
                                <li>Subcategory = %s</li>
                            </ul>
                            <p>------------------------------------------------------------------------------------------------------------------</p>
                            <br>
                            <br>
                            <br>
                            %n""",
                        c.getId(), c.getName(), c.getCode(), c.getEstimatedTime(), HelperCsv.isPublic(c.getVisible()),
                        c.getTarget(), c.getInstructor(), c.getDescription(), c.getDevelopedSkills(),
                        subcategory.getName());

            }

            ps.println("<h3>Subcategories without description:</h3>");
            for(Subcategory s : subcategoriesWithoutDescription) {
                ps.printf("""
                            <li>Subcategory name = %s</li>
                            """, s.getName());

            }

            ps.println("</body>");
            ps.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {

        htmlReport();
    }

}
