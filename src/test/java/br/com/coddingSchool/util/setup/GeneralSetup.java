package br.com.coddingSchool.util.setup;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.model.access.User;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.CourseRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import br.com.coddingSchool.repository.UserRepository;
import br.com.coddingSchool.util.builder.CategoryBuilder;
import br.com.coddingSchool.util.builder.CourseBuilder;
import br.com.coddingSchool.util.builder.SubcategoryBuilder;
import br.com.coddingSchool.util.builder.UserBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

public class GeneralSetup {

    private CategoryRepository categoryRepository;
    private SubcategoryRepository subcategoryRepository;
    private CourseRepository courseRepository;
    private UserRepository userRepository;

    public GeneralSetup(CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository,
                        CourseRepository courseRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.courseRepository = courseRepository;
    }

    public GeneralSetup(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setupCategories() {
        Category programming = CategoryBuilder.newCategoryProgramming();
        Category devops = CategoryBuilder.newCategoryDevops();
        Category business = CategoryBuilder.newCategoryBusiness();
        categoryRepository.saveAll(Arrays.asList(programming, devops, business));
    }

    public void setupSubcategories() {

        setupCategories();

        Category programming = categoryRepository.findByCode("programacao")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Subcategory java = SubcategoryBuilder.newSubcategoryJava(programming);
        Subcategory kotlin = SubcategoryBuilder.newSubcategoryKotlin(programming);

        Category devops = categoryRepository.findByCode("devops")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Subcategory git = SubcategoryBuilder.newSubcategoryGit(devops);
        Subcategory aws = SubcategoryBuilder.newSubcategoryAws(devops);

        Category business = categoryRepository.findByCode("business")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Subcategory sucesso = SubcategoryBuilder.newSubcategorySucesso(business);

        subcategoryRepository.saveAll(Arrays.asList(java, kotlin, git, aws, sucesso));
    }

    public void setupCourses() {

        setupSubcategories();

        Subcategory java = subcategoryRepository.findByCode("java")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));;
        Course javaPoo = CourseBuilder.newCourseJava(java);
        Course javaAndSpring = CourseBuilder.newCourseJavaAndSpringBoot(java);

        Subcategory kotlin = subcategoryRepository.findByCode("kotlin")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Course kotlinInitial = CourseBuilder.newCourseKotlinInitial(kotlin);

        Subcategory git = subcategoryRepository.findByCode("git")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Course gitAndGithub = CourseBuilder.newCourseGitAndGithub(git);

        Subcategory aws = subcategoryRepository.findByCode("aws")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Course awsEc2 = CourseBuilder.newCourseAws(aws);

        Subcategory sucsses = subcategoryRepository.findByCode("sucesso-profissional")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Course entrepreneur = CourseBuilder.newCourseEntrepreneur(sucsses);

        courseRepository.saveAll(Arrays.asList(javaPoo, javaAndSpring, kotlinInitial, gitAndGithub, awsEc2, entrepreneur));
    }

    public void setupUser() {
        User user = UserBuilder.newUser();
        userRepository.save(user);
    }
}
