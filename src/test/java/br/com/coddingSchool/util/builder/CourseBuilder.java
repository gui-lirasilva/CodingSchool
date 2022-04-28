package br.com.coddingSchool.util.builder;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;

public class CourseBuilder {

    private String name;
    private String code;
    private int estimatedTime;
    private Boolean visible = false;
    private String target;
    private String instructor;
    private String description;
    private String developedSkills;
    private Subcategory subcategory;

    public CourseBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CourseBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CourseBuilder withEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
        return this;
    }

    public CourseBuilder withVisible(Boolean visible) {
        this.visible = visible;
        return this;
    }

    public CourseBuilder withTarget(String target) {
        this.target = target;
        return this;
    }

    public CourseBuilder withInstructor(String instructor) {
        this.instructor = instructor;
        return this;
    }

    public CourseBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CourseBuilder withDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
        return this;
    }

    public CourseBuilder withSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
        return this;
    }

    public Course completeBuild() {
        return new Course(name, code, estimatedTime, visible, target, instructor, description, developedSkills, subcategory);
    }

    public Course build() {
        return new Course(name, code, estimatedTime, visible, instructor, subcategory);
    }

    public static Course newCourseJava(Subcategory subCategory) {
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
        return javaPoo;
    }

    public static Course newCourseJavaAndSpringBoot(Subcategory subCategory) {
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
        return javaAndSpringBoot;
    }

    public static Course newCourseKotlinInitial(Subcategory subCategory) {
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
        return kotlinInitial;
    }

    public static Course newCourseGitAndGithub(Subcategory subCategory) {
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
        return gitAndGithub;
    }

    public static Course newCourseAws(Subcategory subCategory) {
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
        return aws;
    }

    public static Course newCourseEntrepreneur(Subcategory subCategory) {
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
        return entrepreneur;
    }
}
