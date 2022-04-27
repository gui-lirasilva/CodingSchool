package br.com.coddingSchool.util.setup;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.util.builder.CategoryBuilder;

import java.util.Arrays;

public class GeneralSetup {

    private final CategoryRepository categoryRepository;

    public GeneralSetup(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void setupCategories() {
        Category programming = CategoryBuilder.newCategoryProgramming();
        Category devops = CategoryBuilder.newCategoryDevops();
        Category business = CategoryBuilder.newCategoryBusiness();
        categoryRepository.saveAll(Arrays.asList(programming, devops, business));
    }
}
