package br.com.coddingSchool;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.CourseRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import br.com.coddingSchool.util.builder.CategoryBuilder;
import br.com.coddingSchool.util.builder.CourseBuilder;
import br.com.coddingSchool.util.builder.SubcategoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public abstract class ControllerTestEnvironment {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected CategoryRepository categoryRepository;

    @Autowired
    protected SubcategoryRepository subcategoryRepository;

    @Autowired
    protected CourseRepository courseRepository;

    protected Category newCategoryProgramming(){
        Category programmingCategory = new CategoryBuilder()
                .withName("Programação")
                .withCode("programacao")
                .withDescription("Categoria programacao")
                .withActive(true)
                .withOrderInSystem(3)
                .withIconpath("www.imgur.com")
                .withColorCode("#FFFFFF")
                .withStudyGuide("")
                .buildComplete();
        return categoryRepository.save(programmingCategory);
    }

    protected Category newCategoryInative(){
        Category inativeCategory = new CategoryBuilder()
                .withName("Programação")
                .withCode("programacao")
                .withDescription("Categoria programacao")
                .withActive(false)
                .withOrderInSystem(3)
                .withIconpath("www.imgur.com")
                .withColorCode("#FFFFFF")
                .withStudyGuide("")
                .buildComplete();
        return categoryRepository.save(inativeCategory );
    }

    protected Subcategory newSubcategoryKotlin(Category category) {
        Subcategory kotlin = new SubcategoryBuilder()
                .withName("Kotlin")
                .withCode("kotlin")
                .withOrderInSystem(2)
                .withDescription("Projetos web com kotlin")
                .withActive(true)
                .withCategory(category)
                .withStudyGuide("")
                .completeBuild();
        return subcategoryRepository.save(kotlin);
    }

    protected Course newCourseKotlinInitial(Subcategory subCategory) {
        Course kotlinInitial = new CourseBuilder()
                .withName("Iniciando com Kotlin")
                .withCode("kotlin-inicial")
                .withEstimatedTime(12)
                .withVisible(true)
                .withTarget("Iniciantes")
                .withInstructor("Alex")
                .withDescription("")
                .withDevelopedSkills("Spring boot, Java EE, SQL, JPA")
                .withSubcategory(subCategory)
                .completeBuild();
        return courseRepository.save(kotlinInitial);
    }
}
