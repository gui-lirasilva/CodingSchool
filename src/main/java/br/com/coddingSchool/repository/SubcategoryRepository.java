package br.com.coddingSchool.repository;

import br.com.coddingSchool.dto.SubcategoryDTO;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    List<Subcategory> findAllByCategory_CodeOrderByOrderInSystem(String code);
}
