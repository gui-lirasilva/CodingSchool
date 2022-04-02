package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    @Query("SELECT s.name, s.code, s.studyGuide FROM Subcategory s WHERE s.category = :category")
    List<Subcategory> findSubcategoriesFromCategory(Category category);
}
