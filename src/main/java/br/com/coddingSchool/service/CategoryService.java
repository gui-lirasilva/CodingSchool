package br.com.coddingSchool.service;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryService {

    public Category findByCode(CategoryRepository categoryRepository, String categoryCode) {
        return categoryRepository.findByCode(categoryCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
