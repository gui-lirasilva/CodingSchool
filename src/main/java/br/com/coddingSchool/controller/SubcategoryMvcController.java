package br.com.coddingSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/subcategories")
public class SubcategoryMvcController {

    @GetMapping("{code}")
    public String redirect() {
        return "redirect:/admin/categories";
    }
}
