package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    List<Subcategory> findAllByOrderByName();

    List<Subcategory> findAllByCategory_CodeOrderByOrderInSystem(String code);

    Optional<Subcategory> findByCode(String subcategoryCode);

    boolean existsByName(String name);

    boolean existsByCode(String code);

    boolean existsByNameAndIdNot(String name, Long id);

    boolean existsByCodeAndIdNot(String code, Long id);
}
