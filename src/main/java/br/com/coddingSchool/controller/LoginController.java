package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.CategoryDTO;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController {

    CategoryRepository categoryRepository;
    SubcategoryRepository subcategoryRepository;

    public LoginController(CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @GetMapping("/login")
    public String login(Model model) {
        List<CategoryDTO> categoryDtoList = CategoryDTO.toDTO(categoryRepository.categoriesForLoginPage());
        model.addAttribute("categoryDtoList", categoryDtoList);
        return "login/login";
    }
}
