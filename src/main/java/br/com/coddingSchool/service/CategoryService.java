package br.com.coddingSchool.service;

import br.com.coddingSchool.dto.CategoryDTO;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.projections.publicView.CategoryProjectionView;
import br.com.coddingSchool.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findByCode(String categoryCode) {
        return categoryRepository.findByCode(categoryCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public CategoryDTO findDtoByCode(String categoryCode) {
        return new CategoryDTO(this.findByCode(categoryCode));
    }

    public CategoryProjectionView categoryProjectionByCode(String categoryCode) {
        return categoryRepository
                .findCategoryProjectionByCode(categoryCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
