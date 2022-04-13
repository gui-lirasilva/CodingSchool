package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.CategoryDTO;
import br.com.coddingSchool.dto.SubcategoryDTO;
import br.com.coddingSchool.dto.form.SubcategoryFormDTO;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/subcategories")
public class SubcategoryController {

    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubcategoryController(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{categoryCode}")
    public String subcategoriesList(@PathVariable String categoryCode, Model model) {
        List<SubcategoryDTO> subcategories = SubcategoryDTO.toDTO(subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem(categoryCode));
        CategoryDTO categoryDTO = new CategoryDTO(categoryRepository.findByCode(categoryCode));
        model.addAttribute("subcategories", subcategories);
        model.addAttribute("Category", categoryDTO);
        return "Subcategory/subcategoryList";
    }

    @GetMapping("/new")
    public String newSubcategory(SubcategoryFormDTO subcategoryFormDTO, Model model) {
        List<CategoryDTO> categoryDTOList = CategoryDTO.toDTO(categoryRepository.findAll());
        model.addAttribute("categoryDTOList", categoryDTOList);
        model.addAttribute("subcategoryFormDTO", subcategoryFormDTO);
        return "Subcategory/insertSubcategory";
    }

    @PostMapping
    public String insertNewSubcategory(@Valid SubcategoryFormDTO subcategoryFormDTO, BindingResult bindResult, Model model) {
        if(bindResult.hasErrors()) {
            return newSubcategory(subcategoryFormDTO, model);
        }
        subcategoryRepository.save(subcategoryFormDTO.toEntity());
        return "redirect:/admin/subcategories/" + subcategoryFormDTO.getCategory().getCode();
    }

    @GetMapping("/{categoryCode}/{subcategoryCode}")
    public String update(@PathVariable String categoryCode, @PathVariable String subcategoryCode,
                         SubcategoryFormDTO subcategoryFormDTO, BindingResult bindingResult, Model model) {

        List<CategoryDTO> categoryDtoList = CategoryDTO.toDTO(categoryRepository.findAll());
        CategoryDTO categoryDto = new CategoryDTO(categoryRepository.findByCode(categoryCode));
        SubcategoryDTO subcategoryDto = new SubcategoryDTO(subcategoryRepository.findByCode(subcategoryCode));
        model.addAttribute("categoryDtoList", categoryDtoList);
        model.addAttribute("categoryDTO", categoryDto);
        model.addAttribute("subcategoryDTO", subcategoryDto);
        return "Subcategory/editSubcategoryForm";
    }

    @PostMapping("/{categoryCode}/{subcategoryCode}")
    public String updateSubcategory(@PathVariable String categoryCode, @PathVariable String subcategoryCode,
                         @Valid SubcategoryFormDTO subcategoryFormDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return update(categoryCode, subcategoryCode, subcategoryFormDTO, bindingResult, model);
        }
        Subcategory subcategory = subcategoryRepository.findByCode(subcategoryFormDTO.getCode());
        subcategory.toMerge(subcategoryFormDTO);
        subcategoryRepository.save(subcategory);
        return "redirect:/admin/subcategories/" + subcategoryFormDTO.getCategory().getCode();
    }

    @PostMapping("/{subcategoryCode}/switchVisibility")
    @ResponseStatus(code= HttpStatus.OK)
    public void toogleSubcategoryVisibility(@PathVariable String subcategoryCode) {
        Subcategory subcategory = subcategoryRepository.findByCode(subcategoryCode);
        subcategory.toggleVisibility();
        subcategoryRepository.save(subcategory);
    }
}
