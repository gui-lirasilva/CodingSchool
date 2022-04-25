package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.CategoryDTO;
import br.com.coddingSchool.dto.form.CategoryFormDTO;
import br.com.coddingSchool.dto.form.UpdateCategoryForm;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.projections.publicView.CategoryProjectionView;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;


    public CategoryController(CategoryRepository categoryRepository, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/categories")
    public String categories(Model model) {
        List<CategoryDTO> categories = CategoryDTO.toDTO(categoryRepository.findAllByOrder());
        model.addAttribute("categories", categories);
        return "category/categoryList";
    }

    @GetMapping("/admin/categories/new")
    public String newCategory(CategoryFormDTO categoryFormDTO, Model model) {
        model.addAttribute("category", categoryFormDTO);
        return "category/insertCategory";
    }

    @PostMapping("/admin/categories")
    public String insertNewCategory(@Valid CategoryFormDTO categoryFormDTO, BindingResult bindResult, Model model) {
        if(bindResult.hasErrors()) {
            return newCategory(categoryFormDTO, model);
        }
        categoryRepository.save(categoryFormDTO.toEntity());
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/{code}")
    public String update(@PathVariable String code, UpdateCategoryForm updateCategoryForm, Model model) {
        CategoryDTO categoryDTO = categoryService.findDtoByCode(code);
        model.addAttribute("category", categoryDTO);
        return "category/editCategoryForm";
    }

    @Transactional
    @PostMapping("/admin/categories/{code}")
    public String updateCategory(@PathVariable String code, @Valid UpdateCategoryForm updateCategoryForm,
                                 BindingResult bindResult, Model model) {
        if(bindResult.hasErrors()) {
            return update(code, updateCategoryForm, model);
        }
        Category category = categoryService.findByCode(code);
        category.toMerge(updateCategoryForm);
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @PostMapping("/admin/categories/{code}/switchVisibility")
    @ResponseStatus(code= HttpStatus.OK)
    public void toogleSubcategoryVisibility(@PathVariable String code) {
        Category category = categoryService.findByCode(code);
        category.toggleVisibility();
        categoryRepository.save(category);
    }

    @GetMapping("category/{categoryCode}")
    public String publicPage(@PathVariable String categoryCode, Model model) {
        CategoryProjectionView categoryProjectionView = categoryService.categoryProjectionByCode(categoryCode);
        model.addAttribute("categoryProjection", categoryProjectionView);
        return "category/categoryView";
    }
}
