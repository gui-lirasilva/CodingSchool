package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.CategoryDTO;
import br.com.coddingSchool.dto.form.CategoryFormDTO;
import br.com.coddingSchool.dto.form.UpdateCategoryForm;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String categories(Model model) {
        List<CategoryDTO> categories = CategoryDTO.toDTO(categoryRepository.findAllByOrder());
        model.addAttribute("categories", categories);
        return "category/categoryList";
    }

    @GetMapping("/new")
    public String newCategory(CategoryFormDTO categoryFormDTO, Model model) {
        model.addAttribute("category", categoryFormDTO);
        return "category/insertCategory";
    }

    @PostMapping
    public String insertNewCategory(@Valid CategoryFormDTO categoryFormDTO, BindingResult bindResult, Model model) {
        if(bindResult.hasErrors()) {
            return newCategory(categoryFormDTO, model);
        }
        categoryRepository.save(categoryFormDTO.toEntity());
        return "redirect:/admin/categories";
    }

    @GetMapping("/{code}")
    public String update(@PathVariable String code, UpdateCategoryForm updateCategoryForm, Model model) {
        Category category = categoryRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        CategoryDTO categoryDTO = new CategoryDTO(category);
        model.addAttribute("category", categoryDTO);
        return "category/editCategoryForm";
    }

    @Transactional
    @PostMapping("/{code}")
    public String updateCategory(@PathVariable String code, @Valid UpdateCategoryForm updateCategoryForm,
                                 BindingResult bindResult, Model model) {
        if(bindResult.hasErrors()) {
            return update(code, updateCategoryForm, model);
        }
        Category category = categoryRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        category.toMerge(updateCategoryForm);
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @PostMapping("/{code}/switchVisibility")
    @ResponseStatus(code= HttpStatus.OK)
    public void toogleSubcategoryVisibility(@PathVariable String code) {
        Category category = categoryRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        category.toggleVisibility();
        categoryRepository.save(category);
    }
}
