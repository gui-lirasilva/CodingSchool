package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.SubcategoryDTO;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/subcategories")
public class SubcategoryController {

    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubcategoryController(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{categoryCode}")
    public String redirect(@PathVariable String categoryCode, Model model) {
        List<SubcategoryDTO> subcategories = SubcategoryDTO.toDTO(subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem(categoryCode));
        Category category = categoryRepository.findByCode(categoryCode);
        model.addAttribute("subcategories", subcategories);
        model.addAttribute("categoryName", category.getName());
        return "Subcategory/subcategoryList";
    }
}
