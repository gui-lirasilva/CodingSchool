package FileReaders;

import school.Course;
import school.Subcategory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static Helpers.HelperCsv.isVisible;
import static Helpers.HelperCsv.transformToInteger;

public class CourseReader {

    public static void listCourses(List<Subcategory> subcategoryList, String path) throws Exception {

        List<Course> courses = csvReader(subcategoryList, path);
        courses.forEach(System.out::println);
    }

    public static List<Course> csvReader(List<Subcategory> subcategoryList, String path) throws Exception {

        List<Course> courses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader((new FileReader(path)))) {
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] csvData = line.split(",");
                Course course = parseCourse(subcategoryList, csvData);
                courses.add(course);
                line = br.readLine();
            }
            return courses;
        }
    }

    private static Course parseCourse(List<Subcategory> subcategoryList, String[] csvData) {

        Subcategory subcategory = subcategoryList.stream()
                .filter(s -> s.getCode().equalsIgnoreCase(csvData[8]))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The subcategory is necessary"));

        return new Course(
                csvData[0],
                csvData[1],
                transformToInteger(csvData[2]),
                isVisible(csvData[3]),
                csvData[4],
                csvData[5],
                csvData[6],
                csvData[7],
                subcategory
        );
    }
}
