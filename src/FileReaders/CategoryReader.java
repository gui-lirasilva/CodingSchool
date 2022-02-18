package FileReaders;

import school.Category;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static validations.BooleanValidator.isActive;
import static validations.NumberValidator.transformOnInteger;

public class CategoryReader {

    public static void listCategories(String path) throws Exception {

        List<Category> categories = csvReader(path);
        for (Category c : categories) {
            System.out.println(c);
        }
    }

    private static List<Category> csvReader(String path) throws Exception {

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
                transformOnInteger(csvData[2]),
                csvData[3],
                isActive(csvData[4]),
                csvData[5],
                csvData[6]
        );
    }

}

