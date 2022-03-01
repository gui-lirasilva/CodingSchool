package FileReaders;

import school.Category;
import school.Subcategory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static Helpers.HelperCsv.isActive;
import static Helpers.HelperCsv.transformToInteger;

public class SubcategoryReader {

    public static void listSubcategories(List<Category> categoryList, String path) throws Exception {

        List<Subcategory> subcategories = csvReader(categoryList, path);
        subcategories.forEach(System.out::println);
    }

    public static List<Subcategory> csvReader(List<Category> categoryList, String path) throws Exception {

        List<Subcategory> subcategories = new ArrayList<>();

        try (BufferedReader br = new BufferedReader((new FileReader(path)))) {
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] csvData = line.split(",");
                Subcategory subcategory = parseSubcategory(categoryList, csvData);
                subcategories.add(subcategory);
                line = br.readLine();
            }
            return subcategories;
        }
    }

    private static Subcategory parseSubcategory(List<Category> categoryList, String[] csvData) {

        Category category = categoryList.stream()
                .filter(c -> c.getCode().equals(csvData[5]))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The category is necessary"));



        return new Subcategory(
                csvData[0],
                csvData[1],
                transformToInteger(csvData[2]),
                csvData[3],
                isActive(csvData[4]),
                category
        );
    }

    public static List<Subcategory> getSubcategoriesWithoutDescription(List<Subcategory> subCategories) throws Exception {

        return subCategories.stream().filter(s -> s.getDescription().equals("")).toList();
    }

    public static long activeSubcategoriesWithDescription(List<Subcategory> subCategories) throws Exception {

        return subCategories.stream()
                .filter(Subcategory::getActive)
                .filter(subcategory -> subcategory
                        .getDescription().trim().length() > 0 && subcategory.getDescription() != null)
                .count();
    }
}
