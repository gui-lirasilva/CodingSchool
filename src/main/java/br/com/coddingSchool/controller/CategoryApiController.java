package br.com.coddingSchool.controller;

import br.com.coddingSchool.dto.api.CategoryApiDTO;
import br.com.coddingSchool.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CategoryApiController {

    private final CategoryRepository categoryRepository;

    @Cacheable(value = "categoriesApi")
    @GetMapping(path = "/categories", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<CategoryApiDTO> categories() {
        return CategoryApiDTO.toDTO(categoryRepository.findCategoryByActiveIsTrue());
    }

    @CacheEvict(value = "categoriesApi")
    @GetMapping("/cache/bGltcGEtby1jYWNoZS1kYS1hcGktYWU")
    @ResponseStatus(HttpStatus.OK)
    public void invalidateCaches() {
    }
}
