package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    List<Subcategory> findAllByOrderByName();

    List<Subcategory> findAllByCategory_CodeOrderByOrderInSystem(String code);

    Optional<Subcategory> findByCode(String subcategoryCode);

    @Query("""
            SELECT DISTINCT s FROM Subcategory s
            INNER JOIN Category c
            ON c.id = s.category.id
            INNER JOIN Course course
            ON s.id = course.subcategory.id
            WHERE s.active = true AND c.code = :categoryCode
            """)
    List<Subcategory> findAllByActive(String categoryCode);
}
