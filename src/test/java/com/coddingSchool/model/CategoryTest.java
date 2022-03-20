package com.coddingSchool.model;

public class CategoryTest {

    private String name = "Category name";
    private String code = "category-code10";
    private int order = 1;
    private String description = "Category description";
    private boolean active = true;
    private String iconPath = "www.iconpath.com";
    private String colorCode = "#ff5733";

//    @Test
//    void cannotAcceptACategoryThatHasEmptyName() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Category("", code, order, description, active, iconPath, colorCode);
//        });
//        assertEquals("The name can't be empty or null", ex.getMessage());
//    }
//
//    @Test
//    void cannotAcceptACategoryThatHasNullName() {
//        Exception ex = assertThrows(NullPointerException.class, () -> {
//            new Category(null, code, order, description, active, iconPath, colorCode);
//        });
//        assertEquals("The name can't be empty or null", ex.getMessage());
//    }
//
//    @Test
//    void doesNotAcceptNonPatternCode() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Category(name, "asoda-asd*", order, description, active, iconPath, colorCode);
//        });
//        assertEquals("The code must obey the pattern: only lowercase letters and numbers", ex.getMessage());
//    }
//
//    @Test
//    void doesNotAcceptAEmptyCode() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Category(name, "", order, description, active, iconPath, colorCode);
//        });
//        assertEquals("The code must obey the pattern: only lowercase letters and numbers", ex.getMessage());
//    }
//
//    @Test
//    void doesNotAcceptANullCode() {
//        Exception ex = assertThrows(NullPointerException.class, () -> {
//            new Category(name, null, order, description, active, iconPath, colorCode);
//        });
//        assertEquals("The code must obey the pattern: only lowercase letters and numbers", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptAEmptyDescription() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Category(name, code, order, "", active, iconPath, colorCode);
//        });
//        assertEquals("The category description can't be empty or null", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptANullDescription() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Category(name, code, order, "", active, iconPath, colorCode);
//        });
//        assertEquals("The category description can't be empty or null", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptAEmptyIconPath() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Category(name, code, order, description, active, "", colorCode);
//        });
//        assertEquals("The icon path can't be empty or null", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptANullIconPath() {
//        Exception ex = assertThrows(NullPointerException.class, () -> {
//            new Category(name, code, order, description, active, null, colorCode);
//        });
//        assertEquals("The icon path can't be empty or null", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptAInvalidHexadecimalColorCode() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Category(name, code, order, description, active, iconPath, "#FF");
//        });
//        assertEquals("The color code should be hexadecimal", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptAEmptyHexadecimalColorCode() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Category(name, code, order, description, active, iconPath, "");
//        });
//        assertEquals("The color code should be hexadecimal", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptANullHexadecimalColorCode() {
//        Exception ex = assertThrows(NullPointerException.class, () -> {
//            new Category(name, code, order, description, active, iconPath, null);
//        });
//        assertEquals("The color code should be hexadecimal", ex.getMessage());
//    }
//
//    @Test
//    void shouldBeAcceptAValidCategory() {
//        assertDoesNotThrow(() -> new Category(name, code, order, description, active, iconPath, colorCode),
//                "Throw exception");
//    }
}