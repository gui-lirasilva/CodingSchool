package FileReaders;

import school.Category;
import school.Subcategory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static validations.BooleanValidator.isActive;
import static validations.NumberValidator.transformOnInteger;

public class SubcategoryReader {

    public static void listSubcategories(String path) throws Exception {

        List<Subcategory> subcategories = csvReader(path);
        subcategories.forEach(System.out::println);
    }

    private static List<Subcategory> csvReader(String path) throws Exception {

        List<Subcategory> subcategories = new ArrayList<>();

        try (BufferedReader br = new BufferedReader((new FileReader(path)))) {
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] csvData = line.split(",");
                Subcategory subcategory = parseSubcategory(csvData);
                subcategories.add(subcategory);
                line = br.readLine();
            }
            return subcategories;
        }
    }

    private static Subcategory parseSubcategory(String[] csvData) {

        return new Subcategory(
                csvData[0],
                csvData[1],
                transformOnInteger(csvData[2]),
                csvData[3],
                isActive(csvData[4]),
                new Category(csvData[5])
        );
    }
}
