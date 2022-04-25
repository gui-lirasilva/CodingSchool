package br.com.coddingSchool.service;

import br.com.coddingSchool.dto.SubcategoryDTO;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.SubcategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public Subcategory findByCode(String code) {
       return subcategoryRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public SubcategoryDTO findDtoByCode(String code) {
        return new SubcategoryDTO(this.findByCode(code));
    }

    public List<Subcategory> findAllSubcategoriesByCategoryCode(String categoryCode) {
        return subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem(categoryCode);
    }
}
