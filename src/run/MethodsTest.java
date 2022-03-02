package run;

import fileReaders.CategoryReader;
import fileReaders.CourseReader;
import fileReaders.SubcategoryReader;
import school.Category;
import school.Course;
import school.Subcategory;

import java.util.List;

import static fileReaders.CategoryReader.getActiveCategories;
import static fileReaders.SubcategoryReader.getSubcategoriesWithoutDescription;

public class MethodsTest {

    static String CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/planilha-dados-escola - Categoria.csv";
    static String SUBCATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/planilha-dados-escola - Subcategoria.csv";
    static String COURSE_CSV_PATH = "/home/guilherme/Documentos/Level Up/planilha-dados-escola-curso(copia).csv";


    public static void main(String[] args) throws Exception {

        List<Category> categoryList = CategoryReader.csvReader(CATEGORY_CSV_PATH);
        List<Subcategory> subcategoryList = SubcategoryReader.csvReader(categoryList, SUBCATEGORY_CSV_PATH);
        List<Course> courseList = CourseReader.csvReader(subcategoryList, COURSE_CSV_PATH);

        // Card 2
        System.out.println();

        List<Category> activeCategoryList = getActiveCategories(categoryList);
        System.out.println(activeCategoryList);

        System.out.println("***********************************************************************************");

        // Card 3

        List<Subcategory> subcategoriesWithoutDescription = getSubcategoriesWithoutDescription(subcategoryList);
        System.out.println(subcategoriesWithoutDescription);

        System.out.println("***********************************************************************************");

        // Card 4

        List<Course> privateCourses = CourseReader.getPrivateCourses(courseList);
        System.out.println(privateCourses);

        System.out.println("***********************************************************************************");

        // Card 5
        // Usando List
        List<String> instructorsList = CourseReader.getInstructorsList(courseList);
        System.out.println(instructorsList);

        System.out.println("***********************************************************************************");

        // Card 6
        long numberOfActiveSubcategoriesWithDescription = SubcategoryReader
                .activeSubcategoriesWithDescription(subcategoryList);
        System.out.println(numberOfActiveSubcategoriesWithDescription);

        System.out.println("***********************************************************************************");

        // Card 7
        System.out.println(CourseReader.getInstructorsAndCourses(courseList));

    }
}
