package br.com.coddingSchool;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public abstract class DatabaseTestEnvironment {

    @Autowired
    protected CategoryRepository categoryRepository;

    @Autowired
    protected SubcategoryRepository subcategoryRepository;

    @Autowired
    protected CourseRepository courseRepository;

    @Autowired
    protected UserRepository userRepository;

    protected Category newCategoryBusiness() {
        Category businessCategory = new CategoryBuilder()
                .withName("Business")
                .withCode("business")
                .withDescription("Categoria Business")
                .withActive(true)
                .withOrderInSystem(2)
                .withIconpath("www.imgur.com")
                .withColorCode("#FFFFFF")
                .withStudyGuide("")
                .buildComplete();
        return  categoryRepository.save(businessCategory);
    }

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

    protected Category newCategoryDevops(){
        Category devOpsCategory = new CategoryBuilder()
                .withName("DevOps")
                .withCode("devops")
                .withDescription("Categoria Devops")
                .withActive(false)
                .withOrderInSystem(1)
                .withIconpath("www.imgur.com")
                .withColorCode("#FFFFFF")
                .withStudyGuide("")
                .buildComplete();
        return categoryRepository.save(devOpsCategory);
    }

    protected Subcategory newSubcategoryJava(Category category) {
        Subcategory java = new SubcategoryBuilder()
                .withName("Java")
                .withCode("java")
                .withOrderInSystem(1)
                .withDescription("Projetos em java")
                .withActive(true)
                .withCategory(category)
                .withStudyGuide("")
                .completeBuild();
        return subcategoryRepository.save(java);
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

    protected Subcategory newSubcategoryGit(Category category) {
        Subcategory git = new SubcategoryBuilder()
                .withName("Git")
                .withCode("git")
                .withOrderInSystem(3)
                .withDescription("Aprenda comandos de terminal")
                .withActive(true)
                .withCategory(category)
                .withStudyGuide("")
                .completeBuild();
        return subcategoryRepository.save(git);
    }

    protected Subcategory newSubcategoryAws(Category category) {
        Subcategory aws = new SubcategoryBuilder()
                .withName("AWS")
                .withCode("aws")
                .withOrderInSystem(4)
                .withDescription("A cloud mais utilizada")
                .withActive(false)
                .withCategory(category)
                .withStudyGuide("")
                .completeBuild();
        return subcategoryRepository.save(aws);
    }

    protected Subcategory newSubcategorySucesso(Category category) {
        Subcategory sucesso = new SubcategoryBuilder()
                .withName("Sucesso profissional")
                .withCode("sucesso-profissional")
                .withOrderInSystem(5)
                .withDescription("Como atingir os objetivos profissionais")
                .withActive(true)
                .withCategory(category)
                .withStudyGuide("")
                .completeBuild();
        return subcategoryRepository.save(sucesso);
    }

    protected Course newCourseJava(Subcategory subCategory) {
        Course javaPoo = new CourseBuilder()
                .withName("Java e POO")
                .withCode("java-poo")
                .withEstimatedTime(15)
                .withVisible(true)
                .withTarget("Iniciantes")
                .withInstructor("Rodrigo")
                .withDescription("Java e orientação a objetos")
                .withDevelopedSkills("Os principais conceitos do Java e do paradigma de POO")
                .withSubcategory(subCategory)
                .completeBuild();
        return courseRepository.save(javaPoo);
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

    protected Course newCourseJavaAndSpringBoot(Subcategory subCategory) {
        Course javaAndSpringBoot = new CourseBuilder()
                .withName("Java e Spring boot")
                .withCode("java-spring")
                .withEstimatedTime(18)
                .withVisible(false)
                .withTarget("Desenvolvedores juniores")
                .withInstructor("Rodrigo")
                .withDescription("Java e Spring Boot, o framwork mais usado")
                .withDevelopedSkills("Spring boot, Java EE, SQL, JPA")
                .withSubcategory(subCategory)
                .completeBuild();
        return courseRepository.save(javaAndSpringBoot);
    }

    protected Course newCourseGitAndGithub(Subcategory subCategory) {
        Course gitAndGithub = new CourseBuilder()
                .withName("Git e GitHub")
                .withCode("git-github")
                .withEstimatedTime(10)
                .withVisible(true)
                .withTarget("Iniciantes")
                .withInstructor("Mila")
                .withDescription("")
                .withDevelopedSkills("Conceitos iniciais de versionamento de código")
                .withSubcategory(subCategory)
                .completeBuild();
        return courseRepository.save(gitAndGithub);
    }

    protected Course newCourseAws(Subcategory subCategory) {
        Course aws = new CourseBuilder()
                .withName("AWS EC2")
                .withCode("aws-ec2")
                .withEstimatedTime(10)
                .withVisible(false)
                .withTarget("Ninjas")
                .withInstructor("Mila")
                .withDescription("")
                .withDevelopedSkills("Tudo sobre as ferramentas da AWS")
                .withSubcategory(subCategory)
                .completeBuild();
        return courseRepository.save(aws);
    }

    protected Course newCourseEntrepreneur(Subcategory subCategory) {
        Course entrepreneur = new CourseBuilder()
                .withName("Empreendedorismo")
                .withCode("empreendedorismo")
                .withEstimatedTime(10)
                .withVisible(true)
                .withTarget("Empreendedores")
                .withInstructor("Pricila")
                .withDescription("")
                .withDevelopedSkills("Como abrir seu primeiro e-commerce")
                .withSubcategory(subCategory)
                .completeBuild();
        return courseRepository.save(entrepreneur);
    }

    protected User newUser() {
        User user = new UserBuilder()
                .withName("User name")
                .withEmail("newuser@gmail.com")
                .withPassword("123456")
                .build();
        return userRepository.save(user);
    }

}
