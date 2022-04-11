package br.com.coddingSchool.controller;

import br.com.coddingSchool.projections.CategoryProjection;
import br.com.coddingSchool.projections.InstructorProjection;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    private final CategoryRepository categoryRepository;
    private final CourseRepository courseRepository;

    public DashboardController(CategoryRepository categoryRepository, CourseRepository CourseRepository) {
        this.categoryRepository = categoryRepository;
        this.courseRepository = CourseRepository;
    }

    @GetMapping
    public String redirectToDashboard() {
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<CategoryProjection> categoryAndCourses = categoryRepository.findCategoryAndCourses();
        InstructorProjection instructorProjection = courseRepository.findInstructorWithMoreCourses();
        model.addAttribute("categoryAndCourses", categoryAndCourses);
        model.addAttribute("instructorProjection", instructorProjection);
        return "Dashboard/dashboardCourses";
    }
}
