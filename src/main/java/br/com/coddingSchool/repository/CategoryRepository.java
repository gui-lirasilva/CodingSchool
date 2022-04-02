package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c.name, c.code, c.order, c.colorCode, c.studyGuide FROM Category c WHERE c.active = true")
    List<Category> findActiveCategoriesAndSubcategories();

    List<Category> findCategoryByActiveIsTrue();

    @Query("SELECT COUNT(co) FROM Course co WHERE co.subcategory.category = :category")
    Long totalOfCourses(@Param("category") Category category);

}