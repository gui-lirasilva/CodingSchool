package run;

import FileReaders.CategoryReader;
import FileReaders.CourseReader;
import FileReaders.SubcategoryReader;
import school.Category;
import school.Course;
import school.Subcategory;

import java.util.List;

public class CsvReader {

    static String CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/planilha-dados-escola - Categoria.csv";
    static String SUBCATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/planilha-dados-escola - Subcategoria.csv";
    static  String COURSE_CSV_PATH = "/home/guilherme/Documentos/Level Up/planilha-dados-escola-curso(copia).csv";

    public static void main(String[] args) throws Exception{

        List<Category> categoryList = CategoryReader.csvReader(CATEGORY_CSV_PATH);

        List<Subcategory> subcategoryList = SubcategoryReader.csvReader(categoryList, SUBCATEGORY_CSV_PATH);

        List<Course> courseList = CourseReader.csvReader(subcategoryList, COURSE_CSV_PATH);

        System.out.println(categoryList);
        System.out.println(subcategoryList);
        System.out.println(courseList);
    }
}