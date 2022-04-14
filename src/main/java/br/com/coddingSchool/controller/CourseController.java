package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.CourseDTO;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.CourseRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;


@Controller
@RequestMapping("/admin/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final SubcategoryRepository subcategoryRepository;

    public CourseController(CourseRepository courseRepository, SubcategoryRepository subcategoryRepository) {
        this.courseRepository = courseRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @GetMapping("/{categoryCode}/{subcategoryCode}")
    public String courses(@PathVariable String categoryCode, @PathVariable String subcategoryCode,
                          @PageableDefault(size = 5) Pageable pageable, Model model) {

        Subcategory subcategory = subcategoryRepository.findByCode(subcategoryCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Page<CourseDTO> paginatedCourses = courseRepository.findAllBySubcategory(subcategory, pageable)
                .map(CourseDTO::new);

        model.addAttribute("subcategory", subcategory);
        model.addAttribute("paginatedCourses", paginatedCourses);
        model.addAttribute("categoryCode", categoryCode);

        return "course/courseList";
    }
}
