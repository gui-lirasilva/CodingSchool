package br.com.coddingSchool.model;

public class CourseTest {

//    private Category category = new Category(
//            "Category Name",
//            "category-code10",
//            8,
//            "Category description",
//            true,
//            "www.iconpath.com",
//            "#ff5733"
//    );
//
//    private Subcategory subcategory = new Subcategory(
//            "Subcategory name",
//            "subcategory-code20",
//            8,
//            "Subcategory description",
//            true,
//            category
//    );
//
//    private String name = "Couse name";
//    private String code = "course-code30";
//    private int estimatedTime = 15;
//    private boolean visible = true;
//    private String target = "Children";
//    private String instructor = "Paulo Silveira";
//    private String descrioption = "Course description";
//    private String developedSkills = "Skills";
//
//    @Test
//    void cannotAcceptACourseThatHasNoName() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Course("" , code, estimatedTime, visible, target,
//                    instructor, descrioption, developedSkills, subcategory);
//        });
//        assertEquals("The name can't be null or empty", ex.getMessage());
//    }
//
//    @Test
//    void cannotAcceptACourseThatHasANullName() {
//        Exception ex = assertThrows(NullPointerException.class, () -> {
//            new Course(null , code, estimatedTime, visible, target,
//                    instructor, descrioption, developedSkills, subcategory);
//        });
//        assertEquals("The name can't be null or empty", ex.getMessage());
//    }
//
//    @Test
//    void doesNotAcceptNonPatternCode() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Course(name, "course-code30*", estimatedTime, visible, target,
//                    instructor, descrioption, developedSkills, subcategory);
//        });
//        assertEquals("The code must obey the pattern: only lowercase letters and numbers", ex.getMessage());
//    }
//
//    @Test
//    void doesNotAcceptAEmptyCode() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Course(name, "", estimatedTime, visible, target,
//                    instructor, descrioption, developedSkills, subcategory);
//        });
//        assertEquals("The code must obey the pattern: only lowercase letters and numbers", ex.getMessage());
//    }
//
//    @Test
//    void doesNotAcceptANullCode() {
//        Exception ex = assertThrows(NullPointerException.class, () -> {
//            new Course(name, null, estimatedTime, visible, target,
//                    instructor, descrioption, developedSkills, subcategory);
//        });
//        assertEquals("The code must obey the pattern: only lowercase letters and numbers", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptEstimatedTimeSmallerThen_1() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Course(name, code, 0, visible, target,
//                    instructor, descrioption, developedSkills, subcategory);
//        });
//        assertEquals("The estimated time can't be smaller 1 or bigger than 20", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptEstimatedTimeBiggerThen_20() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Course(name, code, 21, visible, target,
//                    instructor, descrioption, developedSkills, subcategory);
//        });
//        assertEquals("The estimated time can't be smaller 1 or bigger than 20", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptAInstructorWithoutName() {
//        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
//            new Course(name, code, estimatedTime, visible, target,
//                    "", descrioption, developedSkills, subcategory);
//        });
//        assertEquals("The instructor name can't be null or empty", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptAInstructorWithANullName() {
//        Exception ex = assertThrows(NullPointerException.class, () -> {
//            new Course(name, code, estimatedTime, visible, target,
//                    null, descrioption, developedSkills, subcategory);
//        });
//        assertEquals("The instructor name can't be null or empty", ex.getMessage());
//    }
//
//    @Test
//    void notAcceptANullSubcategory() {
//        Exception ex = assertThrows(NullPointerException.class, () -> {
//            new Course(name, code, estimatedTime, visible, target,
//                    instructor, descrioption, developedSkills, null);
//        });
//        assertEquals("The sub category can't be null", ex.getMessage());
//    }
//
//    @Test
//    void shouldBeAcceptAValidCourse() {
//        assertDoesNotThrow(() -> {
//            new Course(name, code, estimatedTime, visible, target,
//                instructor, descrioption, developedSkills, subcategory);},"Throw exception");
//    }
}
