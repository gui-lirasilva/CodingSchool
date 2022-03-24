package br.com.coddingSchool.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubcategoryTest {

    private Category category = new Category(
            "Category Name",
            "category-code10",
            8,
            "Category description",
            true,
            "www.iconpath.com",
            "#ff5733",
            "Study guide"
    );

    private String name = "Subcategory name";
    private String code = "subcategory-code20";
    private int order = 2;
    private String description = "Subcategory description";
    private boolean active = true;
    private String studyGuide = "Study guide";

    @Test
    void cannotAcceptASubcategoryThatHasEmptyName() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Subcategory("", code, order, description, active, category, studyGuide);
        });
        assertEquals("The name can't be empty or null", ex.getMessage());
    }

    @Test
    void cannotAcceptASubcategoryThatHasANullName() {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            new Subcategory(null, code, order, description, active, category, studyGuide);
        });
        assertEquals("The name can't be empty or null", ex.getMessage());
    }

    @Test
    void doesNotAcceptNonPatternCode() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Subcategory(name, "asd-as12*", order, description, active, category, studyGuide);
        });
        assertEquals("The code must obey the pattern: only lowercase letters and numbers", ex.getMessage());
    }

    @Test
    void doesNotAcceptAEmptyCode() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Subcategory(name, "", order, description, active, category, studyGuide);
        });
        assertEquals("The code must obey the pattern: only lowercase letters and numbers", ex.getMessage());
    }

    @Test
    void doesNotAcceptANullCode() {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            new Subcategory(name, null, order, description, active, category, studyGuide);
        });
        assertEquals("The code must obey the pattern: only lowercase letters and numbers", ex.getMessage());
    }

    @Test
    void doesNotAcceptANullDescription() {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            new Subcategory(name, code, order, null, active, category, studyGuide);
        });
        assertEquals("The subcategory description can't be null", ex.getMessage());
    }

    @Test
    void notAcceptANullCategory() {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            new Subcategory(name, code, order, description, active, null, studyGuide);
        });
        assertEquals("The category can't be null", ex.getMessage());
    }

    @Test
    void shouldBeAcceptAValidSubcategory() {
        assertDoesNotThrow(() -> new Subcategory(name, code, order, description, active, category, studyGuide),
                "Throw exception");
    }
}
