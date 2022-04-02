package br.com.coddingSchool.controller;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.repository.CourseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/list")
    public List<Course> listAll() {
        return courseRepository.findAllByVisibleIsTrue();
    }
}
