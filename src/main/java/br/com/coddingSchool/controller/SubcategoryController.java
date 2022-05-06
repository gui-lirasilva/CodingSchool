package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.CategoryDTO;
import br.com.coddingSchool.dto.SubcategoryDTO;
import br.com.coddingSchool.dto.form.SubcategoryFormDTO;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import br.com.coddingSchool.service.CategoryService;
import br.com.coddingSchool.service.SubcategoryService;
import br.com.coddingSchool.validators.SubcategoryFormDTOValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/subcategories")
public class SubcategoryController {

    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryService subcategoryService;
    private final CategoryService categoryService;
    private final SubcategoryFormDTOValidator subcategoryFormDTOValidator;

    public SubcategoryController(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository,
                                 SubcategoryService subcategoryService, CategoryService categoryService,
                                 SubcategoryFormDTOValidator subcategoryFormDTOValidator) {

        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
        this.subcategoryService = subcategoryService;
        this.categoryService = categoryService;
        this.subcategoryFormDTOValidator = subcategoryFormDTOValidator;
    }

    @InitBinder("subcategoryFormDTO")
    void initBinderCategoryFormDto(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(subcategoryFormDTOValidator);
    }

    @GetMapping("/{categoryCode}")
    public String subcategoriesList(@PathVariable String categoryCode, Model model) {
        List<SubcategoryDTO> subcategories = SubcategoryDTO.toDTO(subcategoryService
                .findAllSubcategoriesByCategoryCode(categoryCode));

        CategoryDTO categoryDTO = categoryService.findDtoByCode(categoryCode);

        model.addAttribute("subcategories", subcategories);
        model.addAttribute("Category", categoryDTO);
        return "subcategory/subcategoryList";
    }

    @GetMapping("/new")
    public String create(SubcategoryFormDTO subcategoryFormDTO, Model model) {
        List<CategoryDTO> categoryDTOList = CategoryDTO.toDTO(categoryRepository.findAllByOrderByName());
        model.addAttribute("categoryDTOList", categoryDTOList);
        model.addAttribute("subcategoryFormDTO", subcategoryFormDTO);
        return "subcategory/insertSubcategory";
    }

    @PostMapping
    public String save(@Valid SubcategoryFormDTO subcategoryFormDTO, BindingResult bindResult, Model model) {
        if(bindResult.hasErrors()) {
            return create(subcategoryFormDTO, model);
        }
        subcategoryRepository.save(subcategoryFormDTO.toEntity());
        return "redirect:/admin/subcategories/" + subcategoryFormDTO.getCategory().getCode();
    }

    @GetMapping("/{categoryCode}/{subcategoryCode}")
    public String edit(@PathVariable String categoryCode, @PathVariable String subcategoryCode,
                       SubcategoryFormDTO subcategoryFormDTO, BindingResult bindingResult, Model model) {

        List<CategoryDTO> categoryDtoList = CategoryDTO.toDTO(categoryRepository.findAllByOrderByName());

        CategoryDTO categoryDto = categoryService.findDtoByCode(categoryCode);

        SubcategoryDTO subcategoryDto = subcategoryService.findDtoByCode(subcategoryCode);

        model.addAttribute("categoryDtoList", categoryDtoList);
        model.addAttribute("categoryDTO", categoryDto);
        model.addAttribute("subcategoryDTO", subcategoryDto);
        return "subcategory/editSubcategoryForm";
    }

    @PostMapping("/{categoryCode}/{subcategoryCode}")
    public String update(@PathVariable String categoryCode, @PathVariable String subcategoryCode,
                         @Valid SubcategoryFormDTO subcategoryFormDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return edit(categoryCode, subcategoryCode, subcategoryFormDTO, bindingResult, model);
        }
        Subcategory subcategory = subcategoryService.findByCode(subcategoryCode);

        subcategory.toMerge(subcategoryFormDTO);
        subcategoryRepository.save(subcategory);
        return "redirect:/admin/subcategories/" + subcategoryFormDTO.getCategory().getCode();
    }

    @PostMapping("/{subcategoryCode}/switchVisibility")
    @ResponseStatus(code= HttpStatus.OK)
    public void toogleSubcategoryVisibility(@PathVariable String subcategoryCode) {

        Subcategory subcategory = subcategoryService.findByCode(subcategoryCode);

        subcategory.toggleVisibility();
        subcategoryRepository.save(subcategory);
    }
}
