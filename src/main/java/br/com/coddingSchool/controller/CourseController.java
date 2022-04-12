package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.CourseDTO;
import br.com.coddingSchool.dto.SubcategoryDTO;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.CourseRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


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
                          @PageableDefault (size = 5) Pageable pageable, Model model) {
        Subcategory subcategory = subcategoryRepository.findByCode(subcategoryCode);

        Page<Course> paginatedCourses = courseRepository.findAllBySubcategory(subcategory, pageable);
        List<CourseDTO> courseDTOList = paginatedCourses.getContent().stream().map(CourseDTO::new).toList();

        model.addAttribute("subcategory", subcategory);
        model.addAttribute("courseDTOList", courseDTOList);
        model.addAttribute("categoryCode", categoryCode);
        model.addAttribute("totalPages", paginatedCourses.getTotalPages());
        model.addAttribute("firstPage", paginatedCourses.isFirst());
        model.addAttribute("lastPage", paginatedCourses.isLast());
        model.addAttribute("pageNumber", paginatedCourses.getNumber());

        return "Course/courseList";
    }
}
