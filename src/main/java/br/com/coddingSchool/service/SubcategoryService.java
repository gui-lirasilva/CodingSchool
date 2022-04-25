package br.com.coddingSchool.service;

import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.SubcategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubcategoryService {

    public Subcategory findByCode(SubcategoryRepository subcategoryRepository, String code) {
       return subcategoryRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Subcategory> findAllSubcategoriesByCategoryCode(SubcategoryRepository subcategoryRepository, String categoryCode) {
        return subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem(categoryCode);
    }
}
