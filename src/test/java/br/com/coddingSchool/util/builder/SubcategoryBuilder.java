package br.com.coddingSchool.util.builder;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;

public class SubcategoryBuilder {

    private String name;
    private String code;
    private int orderInSystem;
    private String description;
    private boolean active;
    private Category category;
    private String studyGuide;

    public SubcategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public SubcategoryBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public SubcategoryBuilder withOrderInSystem(int order) {
        this.orderInSystem = order;
        return this;
    }

    public SubcategoryBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public SubcategoryBuilder withActive(boolean active) {
        this.active = active;
        return this;
    }

    public SubcategoryBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public SubcategoryBuilder withStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
        return this;
    }

    public Subcategory completeBuild() {
        return new Subcategory(name, code, orderInSystem, description, active, category, studyGuide);
    }

    public Subcategory build() {
        return new Subcategory(name, code, active, category);
    }

    public static Subcategory newSubcategoryJava(Category category) {
        Subcategory java = new SubcategoryBuilder()
                .withName("Java")
                .withCode("java")
                .withOrderInSystem(1)
                .withDescription("Projetos em java")
                .withActive(true)
                .withCategory(category)
                .withStudyGuide("")
                .completeBuild();
        return java;
    }

    public static Subcategory newSubcategoryKotlin(Category category) {
        Subcategory kotlin = new SubcategoryBuilder()
                .withName("Kotlin")
                .withCode("kotlin")
                .withOrderInSystem(2)
                .withDescription("Projetos web com kotlin")
                .withActive(true)
                .withCategory(category)
                .withStudyGuide("")
                .completeBuild();
        return kotlin;
    }

    public static Subcategory newSubcategoryGit(Category category) {
        Subcategory git = new SubcategoryBuilder()
                .withName("Git")
                .withCode("git")
                .withOrderInSystem(3)
                .withDescription("Aprenda comandos de terminal")
                .withActive(true)
                .withCategory(category)
                .withStudyGuide("")
                .completeBuild();
        return git;
    }

    public static Subcategory newSubcategoryAws(Category category) {
        Subcategory aws = new SubcategoryBuilder()
                .withName("AWS")
                .withCode("aws")
                .withOrderInSystem(4)
                .withDescription("A cloud mais utilizada")
                .withActive(false)
                .withCategory(category)
                .withStudyGuide("")
                .completeBuild();
        return aws;
    }

    public static Subcategory newSubcategorySucesso(Category category) {
        Subcategory sucesso = new SubcategoryBuilder()
                .withName("Sucesso profissional")
                .withCode("sucesso-profissional")
                .withOrderInSystem(5)
                .withDescription("Como atingir os objetivos profissionais")
                .withActive(true)
                .withCategory(category)
                .withStudyGuide("")
                .completeBuild();
        return sucesso;
    }
}
