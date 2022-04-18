package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.projections.CategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByOrderByName();

    List<Category> findCategoryByActiveIsTrue();

    @Query("SELECT c FROM Category c ORDER BY c.orderInSystem")
    List<Category> findAllByOrder();

    Optional<Category> findByCode(String code);

    @Query(value = """
    SELECT  ca.name AS name, COUNT(co.id) AS coursesNumber FROM Category ca
    LEFT JOIN Subcategory su ON ca.id = su.category_id
    LEFT JOIN Course co ON su.id = co.subcategory_id
    GROUP BY ca.name
    ORDER BY coursesNumber DESC;
    """, nativeQuery = true)
    List<CategoryProjection> findCategoryAndCourses();

    @Query(value = """
    SELECT ca.id, ca.name, ca.code, ca.order_in_system, ca.description, ca.active, ca.icon_path, ca.color_code, ca.study_guide
    FROM Category ca 
    LEFT JOIN Subcategory su ON ca.id = su.category_id
    LEFT JOIN Course co ON su.id = co.subcategory_id
    WHERE ca.active AND su.active AND co.visible
    GROUP BY ca.id, ca.name, ca.code, ca.order_in_system, ca.description, ca.active, ca.icon_path, ca.color_code, ca.study_guide
    ORDER BY ca.order_in_system
    """, nativeQuery = true)
    List<Category> categoriesForLoginPage();
}
