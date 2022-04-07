package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findCategoryByActiveIsTrue();

    Category findByCode(String code);

}
