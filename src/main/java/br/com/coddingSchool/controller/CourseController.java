package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.CourseDTO;
import br.com.coddingSchool.dto.SubcategoryDTO;
import br.com.coddingSchool.dto.form.CourseFormDTO;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.CourseRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import br.com.coddingSchool.service.CourseService;
import br.com.coddingSchool.service.SubcategoryService;
import br.com.coddingSchool.validators.CourseFormDTOValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/admin/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final CourseService courseService;
    private final SubcategoryService subcategoryService;
    private final CourseFormDTOValidator courseFormDTOValidator;

    public CourseController(CourseRepository courseRepository, SubcategoryRepository subcategoryRepository,
                            CourseService courseService, SubcategoryService subcategoryService,
                            CourseFormDTOValidator courseFormDTOValidator) {

        this.courseRepository = courseRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.courseService = courseService;
        this.subcategoryService = subcategoryService;
        this.courseFormDTOValidator = courseFormDTOValidator;
    }

    @InitBinder("courseFormDTO")
    void initBinderCategoryFormDto(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(courseFormDTOValidator);
    }

    @GetMapping("/{categoryCode}/{subcategoryCode}")
    public String coursesList(@PathVariable String categoryCode, @PathVariable String subcategoryCode,
                              @PageableDefault(size = 5) Pageable pageable, Model model) {

        SubcategoryDTO subcategoryDto = subcategoryService.findDtoByCode(subcategoryCode);

        Page<CourseDTO> paginatedCourses = courseService
                .findCoursesBySubcategory(subcategoryCode, pageable);

        model.addAttribute("subcategoryDto", subcategoryDto);
        model.addAttribute("paginatedCourses", paginatedCourses);
        model.addAttribute("categoryCode", categoryCode);

        return "course/courseList";
    }

    @GetMapping("/new")
    public String create(CourseFormDTO courseFormDTO, Model model) {
        List<SubcategoryDTO> subcategoryDTOList = SubcategoryDTO.toDTO(subcategoryRepository.findAllByOrderByName());
        model.addAttribute("subcategoryDTOList", subcategoryDTOList);
        model.addAttribute("courseFormDTO", courseFormDTO);
        return "course/insertCourse";
    }

    @PostMapping
    public String save(@Valid CourseFormDTO courseFormDTO, BindingResult bindResult, Model model) {
        if (bindResult.hasErrors()) {
            return create(courseFormDTO, model);
        }
        courseRepository.save(courseFormDTO.toEntity());
        return "redirect:/admin/courses/" +
                courseFormDTO.getSubcategory().getCategory().getCode() + "/" +
                courseFormDTO.getSubcategory().getCode();
    }

    @GetMapping("/{categoryCode}/{subcategoryCode}/{courseCode}")
    public String edit(@PathVariable String categoryCode, @PathVariable String subcategoryCode,
                       @PathVariable String courseCode, CourseFormDTO courseFormDTO, BindingResult bindingResult,
                       Model model) {

        CourseDTO courseDto = courseService.findDtoByCode(courseCode);

        Subcategory subcategory = subcategoryService.findByCode(subcategoryCode);
        SubcategoryDTO subcategoryDTO = subcategoryService.findDtoByCode(subcategoryCode);

        List<SubcategoryDTO> subcategoryDTOList = SubcategoryDTO.toDTO(subcategoryRepository.findAllByOrderByName());

        model.addAttribute("courseDto", courseDto);
        model.addAttribute("subcategoryDTOList", subcategoryDTOList);
        model.addAttribute("categoryCode", categoryCode);
        model.addAttribute("subcategory", subcategory);

        return "course/editCourseForm";
    }

    @Transactional
    @PostMapping("/{categoryCode}/{subcategoryCode}/{courseCode}")
    public String update(@PathVariable String categoryCode, @PathVariable String subcategoryCode,
                       @PathVariable String courseCode, @Valid CourseFormDTO courseFormDTO, BindingResult bindingResult,
                       Model model) {

        if(bindingResult.hasErrors()) {
            return edit(categoryCode, subcategoryCode, courseCode, courseFormDTO, bindingResult, model);
        }

        Course course = courseService.findByCode(courseCode);

        course.toMerge(courseFormDTO);
        courseRepository.save(course);

        return "redirect:/admin/courses/" +
                courseFormDTO.getSubcategory().getCategory().getCode() + "/" +
                courseFormDTO.getSubcategory().getCode();
    }
}
