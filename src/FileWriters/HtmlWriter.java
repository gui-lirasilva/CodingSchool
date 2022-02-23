package FileWriters;


import FileReaders.CategoryReader;
import FileReaders.CourseReader;
import FileReaders.SubcategoryReader;
import school.Category;
import school.Course;
import school.Subcategory;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import static Helpers.HelperCsv.isActive;

public class HtmlWriter {

    public static void createFile(String categoryPath, String subcategoryPath, String coursePath) throws Exception {


        List<Category> categoryList = CategoryReader.csvReader(categoryPath);

        List<Subcategory> subcategoryList = SubcategoryReader.csvReader(categoryList, subcategoryPath);

        List<Course> courseList = CourseReader.csvReader(subcategoryList, coursePath);

        writePage(categoryList, subcategoryList, courseList);
    }

    private static void writePage(List<Category> categoryList, List<Subcategory> subcategoryList, List<Course> courseList) throws Exception {
        try (OutputStream os = new FileOutputStream("codingSchool.html")) {
            PrintStream ps = new PrintStream(os);

            ps.println("<html>");
            ps.println("<head>");
            ps.println("<meta charset=\"UTF-8\">");
            ps.println("</head>");
            ps.println("<body>");
            for (Category c : categoryList) {
                ps.println("<div style =\" padding:20px; background-color:" + c.getColorCode() + "\">");
                ps.println("<h2>" + c.getName() + "</h2>");
                ps.println("<ul>");
                ps.println("<li>" + c.getDescription() + "</li>");
                ps.println("<li>" + isActive(c.getActive()) + "</li>");
                ps.print("<img src=\"" + c.getIconPath() + "\"height=\"100\" width=\"100\">");
                int hours = subcategoryList.stream()
                        .filter(Subcategory::getActive)
                        .filter(s -> s.getCategory() == c).mapToInt(s -> {
                            int sum = courseList.stream()
                                    .filter(course -> course.getSubcategory() == s)
                                    .mapToInt(Course::getEstimatedTime)
                                    .sum();
                            return sum;
                        }).sum();
                ps.println("Total de horas da categoria: " +hours);
                ps.println("</ul>");
                ps.println("<h3>Subcategorias</h3>");
                ps.println("</div>");

                subcategoryList.stream()
                        .filter(Subcategory::getActive)
                        .filter(s -> s.getCategory() == c)
                        .forEach( s -> {
                    ps.println("<div style =\" padding:20px; background-color:" + c.getColorCode() + "\">");
                    ps.println("<h4>" + s.getName() + "</h4>");
                    ps.println("<ul><b>Descrição: </b>" + s.getDescription() + "</ul>");

                    String coursesNames = courseList.stream()
                            .filter(course -> course.getSubcategory() == s)
                            .map(Course::getName)
                            .collect(Collectors.joining(" , "));
                    ps.println("<ul><b>Cursos:</b></li></ul>");
                    ps.println("<ul><li>" + coursesNames + "</li></ul>");

                    ps.println("<ul><b>Número de horas de cursos na subcategoria:</b></li></ul>");
                    ps.println("</div>");
                });
            }
            ps.println("</body>");
            ps.println("</html>");
            System.out.println();
        }
    }


}
