package com.coddingSchool.run;

import com.coddingSchool.fileReaders.CategoryReader;
import com.coddingSchool.fileReaders.CourseReader;
import com.coddingSchool.fileReaders.SubcategoryReader;
import com.coddingSchool.model.Category;
import com.coddingSchool.model.Course;
import com.coddingSchool.model.Subcategory;

import java.util.List;

public class RunningCsvReader {

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