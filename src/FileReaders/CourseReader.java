package FileReaders;

import school.Course;
import school.Subcategory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static validations.BooleanValidator.isVisible;
import static validations.NumberValidator.transformOnInteger;
import static validations.StringValidator.makeEmpty;

public class CourseReader {

    public static void listCourses(String path) throws Exception {

        List<Course> courses = csvReader(path);
        courses.forEach(System.out::println);
    }

    private static List<Course> csvReader(String path) throws Exception {

        List<Course> courses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader((new FileReader(path)))) {
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] csvData = line.split(",");
                Course course = parseCourse(csvData);
                courses.add(course);
                line = br.readLine();
            }
            return courses;
        }
    }

    private static Course parseCourse(String[] csvData) {

       if (csvData.length < 9) {
           throw new IllegalArgumentException("Arquivo csv com dados incorretos");
       }

        return new Course(
                csvData[0], // nome
                csvData[1], // Código
                transformOnInteger(csvData[2]), // Tempo estimado
                isVisible(csvData[3]), // Visibilidade
                csvData[4], // Publico alvo
                csvData[5], // Instrutor
                csvData[6], // Ementa ou descrição
                csvData[7], // Habilidades desenvolvidas
                new Subcategory(makeEmpty(csvData[8])) // Subcategoria
        );

    }
}
