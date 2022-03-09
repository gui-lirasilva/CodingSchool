package com.coddingSchool.fileReaders;

import com.coddingSchool.model.Category;
import com.coddingSchool.model.Course;
import com.coddingSchool.model.Subcategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CourseReaderTest {

    private String CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola - Categoria.csv";

    private String SUBCATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola - Subcategoria.csv";

    private String COURSE_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola-curso.csv";

    private String INVALID_COURSE_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola-curso invalido.csv";

    private List<Category> categoryList;
    private List<Subcategory> subcategoryList;
    private List<Course> courseList;
    private List<Course> privateCourses;

    @BeforeEach
    void setup() throws Exception {
        categoryList = CategoryReader.csvReader(CATEGORY_CSV_PATH);
        subcategoryList = SubcategoryReader.csvReader(categoryList, SUBCATEGORY_CSV_PATH);
        courseList = CourseReader.csvReader(subcategoryList, COURSE_CSV_PATH);
        privateCourses = courseList.stream().filter(c -> c.getVisible().equals(false)).toList();
    }

    @Test
    void csvReader_dontThrowExceptionIfRecieveAValidCsvFile() {
        assertDoesNotThrow(() -> {
            CourseReader.csvReader(subcategoryList, COURSE_CSV_PATH);
        },"Throw exception");
    }

    @Test
    void csvReader_ThrowExceptionIfRecieveAInvalidCsvFile() {
        assertThrows(IllegalArgumentException.class, () -> {
            CourseReader.csvReader(subcategoryList, INVALID_COURSE_CSV_PATH);
        });
    }

    @Test
    void getPrivateCourses_shouldDevolveAPrivateCoursesList() {
        assertEquals(privateCourses, CourseReader.getPrivateCourses(courseList));
    }

    @Test
    void getPrivateCourses_shouldDevolveACorrectNumberOfPrivateCourses() {
        assertEquals(1, CourseReader.getPrivateCourses(courseList).size());
    }

    @Test
    void getInstructorsList_shouldDevolveACorrectNumberOfInstructors() {
        assertEquals(4, CourseReader.getInstructorsList(courseList).size());
    }

    @Test
    void getInstructorsList_shouldDevolveACorrectListOfInstructors() {
        List<String> instructors = new ArrayList<>();
        instructors.add("Mario Souto");
        instructors.add("Rodrigo Ferreira");
        instructors.add("Paulo Silveira");
        instructors.add("Alvaro Camilo");

        assertEquals(instructors, CourseReader.getInstructorsList(courseList));
    }

    @Test
    void getInstructorsAndCourses_shouldDevolveACorrectMapOfInstructorsAndCourses() {
        Map<String, Long> instructorsEndCourses = new HashMap<>();
        instructorsEndCourses.put("Paulo Silveira",2L);
        instructorsEndCourses.put("Rodrigo Ferreira",1L);
        instructorsEndCourses.put("Alvaro Camilo",1L);
        instructorsEndCourses.put("Mario Souto",1L);

        assertEquals(instructorsEndCourses, CourseReader.getInstructorsAndCourses(courseList));
    }
}