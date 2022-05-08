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

    @Deprecated
    boolean existsByNameAndIdNot(String name, Long id);

    default boolean existsByNameWithDifferentId(String name, Long id) {
        return existsByNameAndIdNot(name, id);
    }

    @Deprecated
    boolean existsByCodeAndIdNot(String code, Long id);

    default boolean existsByCodeWithDifferentId(String code, Long id) {
        return existsByCodeAndIdNot(code, id);
    }
}
