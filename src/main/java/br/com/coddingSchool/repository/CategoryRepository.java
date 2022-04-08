package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findCategoryByActiveIsTrue();

    @Query("SELECT c FROM Category c ORDER BY c.orderInSystem")
    List<Category> findAllByOrder();

    Category findByCode(String code);

}
