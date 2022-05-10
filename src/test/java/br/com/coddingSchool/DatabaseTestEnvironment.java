package br.com.coddingSchool;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.model.access.User;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.CourseRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import br.com.coddingSchool.repository.UserRepository;
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
        Category businessCategory = Category.builder()
                .name("Business")
                .code("business")
                .description("Categoria Business")
                .active(true)
                .orderInSystem(2)
                .iconPath("www.imgur.com")
                .colorCode("#FFFFFF")
                .studyGuide("")
                .build();
        return  categoryRepository.save(businessCategory);
    }

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

    protected Category newCategoryDevops(){
        Category devOpsCategory = Category.builder()
                .name("DevOps")
                .code("devops")
                .description("Categoria Devops")
                .active(false)
                .orderInSystem(1)
                .iconPath("www.imgur.com")
                .colorCode("#FFFFFF")
                .studyGuide("")
                .build();
        return categoryRepository.save(devOpsCategory);
    }

    protected Subcategory newSubcategoryJava(Category category) {
        Subcategory java = Subcategory.builder()
                .name("Java")
                .code("java")
                .orderInSystem(1)
                .description("Projetos em java")
                .active(true)
                .category(category)
                .studyGuide("")
                .build();
        return subcategoryRepository.save(java);
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

    protected Subcategory newSubcategoryGit(Category category) {
        Subcategory git = Subcategory.builder()
                .name("Git")
                .code("git")
                .orderInSystem(3)
                .description("Aprenda comandos de terminal")
                .active(true)
                .category(category)
                .studyGuide("")
                .build();
        return subcategoryRepository.save(git);
    }

    protected Subcategory newSubcategoryAws(Category category) {
        Subcategory aws = Subcategory.builder()
                .name("AWS")
                .code("aws")
                .orderInSystem(4)
                .description("A cloud mais utilizada")
                .active(false)
                .category(category)
                .studyGuide("")
                .build();
        return subcategoryRepository.save(aws);
    }

    protected Subcategory newSubcategorySucesso(Category category) {
        Subcategory sucesso = Subcategory.builder()
                .name("Sucesso profissional")
                .code("sucesso-profissional")
                .orderInSystem(5)
                .description("Como atingir os objetivos profissionais")
                .active(true)
                .category(category)
                .studyGuide("")
                .build();
        return subcategoryRepository.save(sucesso);
    }

    protected Course newCourseJava(Subcategory subCategory) {
        Course javaPoo = Course.builder()
                .name("Java e POO")
                .code("java-poo")
                .estimatedTime(15)
                .visible(true)
                .target("Iniciantes")
                .instructor("Rodrigo")
                .description("Java e orientação a objetos")
                .developedSkills("Os principais conceitos do Java e do paradigma de POO")
                .subcategory(subCategory)
                .build();
        return courseRepository.save(javaPoo);
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

    protected Course newCourseJavaAndSpringBoot(Subcategory subCategory) {
        Course javaAndSpringBoot = Course.builder()
                .name("Java e Spring boot")
                .code("java-spring")
                .estimatedTime(18)
                .visible(false)
                .target("Desenvolvedores juniores")
                .instructor("Rodrigo")
                .description("Java e Spring Boot, o framwork mais usado")
                .developedSkills("Spring boot, Java EE, SQL, JPA")
                .subcategory(subCategory)
                .build();
        return courseRepository.save(javaAndSpringBoot);
    }

    protected Course newCourseGitAndGithub(Subcategory subCategory) {
        Course gitAndGithub = Course.builder()
                .name("Git e GitHub")
                .code("git-github")
                .estimatedTime(10)
                .visible(true)
                .target("Iniciantes")
                .instructor("Mila")
                .description("")
                .developedSkills("Conceitos iniciais de versionamento de código")
                .subcategory(subCategory)
                .build();
        return courseRepository.save(gitAndGithub);
    }

    protected Course newCourseAws(Subcategory subCategory) {
        Course aws = Course.builder()
                .name("AWS EC2")
                .code("aws-ec2")
                .estimatedTime(10)
                .visible(false)
                .target("Ninjas")
                .instructor("Mila")
                .description("")
                .developedSkills("Tudo sobre as ferramentas da AWS")
                .subcategory(subCategory)
                .build();
        return courseRepository.save(aws);
    }

    protected Course newCourseEntrepreneur(Subcategory subCategory) {
        Course entrepreneur = Course.builder()
                .name("Empreendedorismo")
                .code("empreendedorismo")
                .estimatedTime(10)
                .visible(true)
                .target("Empreendedores")
                .instructor("Pricila")
                .description("")
                .developedSkills("Como abrir seu primeiro e-commerce")
                .subcategory(subCategory)
                .build();
        return courseRepository.save(entrepreneur);
    }

    protected User newUser() {
        User user = User.builder()
                .name("User name")
                .email("newuser@gmail.com")
                .password("123456")
                .build();
        return userRepository.save(user);
    }

}
