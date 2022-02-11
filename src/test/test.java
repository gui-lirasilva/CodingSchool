package test;

import school.*;

public class test {

    public static void main(String[] args) {

        Category category1 = new Category("Category Name", "45a4sa-5as4d5q");
        System.out.println(category1);

        Subcategory subcategory1 = new Subcategory("Sub category name", "56as4d96sq-sdasc", category1);
        System.out.println(subcategory1);

        Course course1 = new Course("The course name", "45asd98-a54s", 15, "Astolfo", subcategory1);
        System.out.println(course1)

        Section section1 = new Section("Section name", "5sa4s6a5-987", course1);
        System.out.println(section1);

        Video video1 = new Video("Title", "35a1s-asdq5412cx", section1, "www.video.com", 40, "The best video");
        System.out.println(video1);

        Question question1 = new Question("Title", "as5d4-as54d", section1, "Statement", QuestionType.MULTIPLE);
        System.out.println(question1);

        Alternative alternative1 = new Alternative("Explanatory text", true, question1);
        System.out.println(alternative1);

    }
}
