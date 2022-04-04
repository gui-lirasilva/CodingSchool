package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.CategoryDTO;
import br.com.coddingSchool.dto.form.CategoryFormDTO;
import br.com.coddingSchool.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoryMvcController {

    private final CategoryRepository categoryRepository;

    public CategoryMvcController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String categories(Model model) {
        List<CategoryDTO> categories = CategoryDTO.toDTO(categoryRepository.findAll());
        model.addAttribute("categories", categories);
        return "categoryList";
    }

    @GetMapping("/new")
    public String newCategory() {
        return "insertCategory";
    }

    @PostMapping
    public String insertNewCategory(CategoryFormDTO categoryFormDTO, Model model) {
        categoryRepository.save(categoryFormDTO.toEntity());
        return "redirect:/admin/categories";
    }



}
