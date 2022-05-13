package br.com.coddingSchool;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.CourseRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
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
        Category programmingCategory = Category.builder()
                .name("Programação")
                .code("programacao")
                .description("Categoria programacao")
                .active(true)
                .orderInSystem(3)
                .iconPath("www.imgur.com")
                .colorCode("#FFFFFF")
                .studyGuide("")
                .build();
        return categoryRepository.save(programmingCategory);
    }

    protected Category newCategoryInative(){
        Category inativeCategory = Category.builder()
                .name("Inactive Category")
                .code("inactive")
                .description("Categoria programacao")
                .active(false)
                .orderInSystem(3)
                .iconPath("www.imgur.com")
                .colorCode("#FFFFFF")
                .studyGuide("")
                .build();
        return categoryRepository.save(inativeCategory );
    }

    protected Subcategory newSubcategoryKotlin(Category category) {
        Subcategory kotlin = Subcategory.builder()
                .name("Kotlin")
                .code("kotlin")
                .orderInSystem(2)
                .description("Projetos web com kotlin")
                .active(true)
                .category(category)
                .studyGuide("")
                .build();

        return subcategoryRepository.save(kotlin);
    }

    protected Course newCourseKotlinInitial(Subcategory subCategory) {
        Course kotlinInitial = Course.builder()
                .name("Iniciando com Kotlin")
                .code("kotlin-inicial")
                .estimatedTime(12)
                .visible(true)
                .target("Iniciantes")
                .instructor("Alex")
                .description("")
                .developedSkills("Spring boot, Java EE, SQL, JPA")
                .subcategory(subCategory)
                .build();
        return courseRepository.save(kotlinInitial);
    }
}
