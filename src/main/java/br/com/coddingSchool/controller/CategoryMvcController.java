package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.CategoryDTO;
import br.com.coddingSchool.dto.form.CategoryFormDTO;
import br.com.coddingSchool.dto.form.UpdateCategoryForm;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{code}")
    public String update(@PathVariable String code, Model model) {
        Category category = categoryRepository.findByCode(code);
        CategoryDTO categoryDTO = new CategoryDTO(category);
        model.addAttribute("category", categoryDTO);
        return "editCategoryForm";
    }

    @Transactional
    @PostMapping("/{code}")
    public String updateCategory(@PathVariable String code, UpdateCategoryForm updateCategoryForm, Model model) {
        Category category = categoryRepository.findByCode(code);
        category.toMerge(updateCategoryForm);
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

}
