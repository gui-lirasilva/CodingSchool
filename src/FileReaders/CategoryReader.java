package FileReaders;

import school.Category;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static Helpers.HelperCsv.isActive;
import static Helpers.HelperCsv.transformToInteger;

public class CategoryReader {

    public static void listCategories(String path) throws Exception {

        List<Category> categories = csvReader(path);
        categories.forEach(System.out::println);
    }

    public static List<Category> csvReader(String path) throws Exception {

        List<Category> categories = new ArrayList<>();

        try (BufferedReader br = new BufferedReader((new FileReader(path)))) {
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] csvData = line.split(",");
                Category category = parseCategory(csvData);
                categories.add(category);
                line = br.readLine();
            }
            return categories;
        }
    }

    private static Category parseCategory(String[] csvData) {

        return new Category(
                csvData[0],
                csvData[1],
                transformToInteger(csvData[2]),
                csvData[3],
                isActive(csvData[4]),
                csvData[5],
                csvData[6]
        );
    }

    public static List<Category> getActiveCategories(List<Category> categories) throws Exception {

        return categories.stream().filter(Category::getActive).toList();
    }
}

