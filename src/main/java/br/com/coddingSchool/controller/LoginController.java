package br.com.coddingSchool.controller;

import br.com.coddingSchool.projections.login.CategoryProjectionLogin;
import br.com.coddingSchool.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/login")
    public String login(Model model) {
        List<CategoryProjectionLogin> categoryProjectionLogins = categoryRepository.categoriesProjectionLoginPage();
        model.addAttribute("categoryDtoList", categoryProjectionLogins);
        return "login/login";
    }
}
